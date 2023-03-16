package main_logic;

//import java.util.ArrayList;
//import java.util.ListIterator;

import entities.Transaction;
import entities.TransactionList;
import parsers.OFXParser;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ListIterator;

import static main_logic.Result.Code.*;
import static parsers.OFXParser.ofxParser;

public class PEC {

	public static String NEW_BANK = "<NEW BANK>";
	public static String NEW_ACCOUNT = "<NEW ACCOUNT>";
	public static String OTHER = "<OTHER>";

	// private main structure housing active Transaction data
	// (no more than 3 months worth)
	private TransactionList tList;
	// these variables contain the date of the first and last transaction
	// in each account of the authenticated user in the database, both initialized
	// with STR_DATE_MIN of TransactionList.java (1900/01/01)--that way, if the
	// database is empty, the parsing or manual entries can start anytime after that
	// initial date
	private Calendar[] acctBeginDate = new Calendar[0];
	private Calendar[] acctEndDate = new Calendar[0];
	private String[] allBanks = {};
	private String[] allAccounts = {};
	private String activeAccount;
	// array of booleans to remember if a particular column is sorted
	// in a descending (or ascending) direction
	private boolean[] descColumn = { true, true, true, true, true, true };
	// sortedColumn indicates which column is active and sorted on screen
	private int sortedColumn = Transaction.POSTED_DATE;

	private static PEC singleton = null;

	/**
	 * Private constructor.
	 */
	private PEC() {
		tList = new TransactionList();
		// code for reaching out to database, and if there are records, load
		// the last "batch" (last 3 months or less--last time index
		// (transaction_date)--whatever is included in the last encrypted
		// String of Transactions) into tList and display; IF NOTHING FOUND,
		// DISPLAY EMPTY TABLE AND A WINDOW: "To start, choose IMPORT ACCOUNT
		// ACTIVITY, MANUAL ENTRY, or HOW TO START from the Menu. <OK>".

		// VERY IMPORTANT:
		// beginDate = <the first time index (transaction_date) in the database>;
		// endDate = <the date of the last Transaction in tList>;
	}

	/**
	 * Instance creator.
	 * 
	 * @return an instance of PEC
	 */
	public static PEC instance() {
		if (singleton == null) {
			singleton = new PEC();
		}
		return singleton;
	}

//	an example of "loading" any logic bearing method with Request parameter
//	and returning a Result or a ListIterator to a list of Results.
//	
//	public Result XXX(Request request) {
//		Result result = new Result();
//		return result;
//	}
//	
//	public ListIterator<Result> YYY(Request request) {
//		ArrayList<Result> list = new ArrayList<Result>();
//		// ... code ...
//		for (... for loop ...) {
//			Result result = new Result();
//			result = ...;
//			list.add(result);
//		}
//		return list.listIterator();
//	}
// ...

	/**
	 * Sets all columns to be viewed in descending order, sets the sorted
	 * column to go by as the one with the "date posted".
	 */
	private void resetView() {
		for (int i = 0; i < descColumn.length; i++) {
			descColumn[i] = true;
		}
		sortedColumn = Transaction.POSTED_DATE;
	}

	public Calendar getAcctBeginDate(int position) {
		if (position>=acctBeginDate.length || position<0)
			return Transaction.returnCalendarFromYYYYMMDD(TransactionList.STR_DATE_MIN);
		return acctBeginDate[position];
	}

	public Calendar getAcctBeginDate(String account) {
		int count = 0;
		for (count = 0; count < allAccounts.length; count++) {
			if (allAccounts[count].startsWith(account)) return acctBeginDate[count];
		}
		return Transaction.returnCalendarFromYYYYMMDD(TransactionList.STR_DATE_MIN);
	}

	public void setAcctBeginDate(int position, Calendar acctBegin) {
		if (position>=0 && position<acctBeginDate.length)
			acctBeginDate[position] = acctBegin;
	}

	public void setAcctBeginDate(String account, Calendar acctBegin) {
		int count = 0;
		for (count = 0; count < allAccounts.length; count++) {
			if (allAccounts[count].startsWith(account)) acctBeginDate[count] = acctBegin;
		}
	}

	public Calendar getAcctEndDate(int position) {
		if (position>=acctEndDate.length || position<0)
			return Transaction.returnCalendarFromYYYYMMDD(TransactionList.STR_DATE_MIN);
		return acctEndDate[position];
	}

	public Calendar getAcctEndDate(String account) {
		int count = 0;
		for (count = 0; count < allAccounts.length; count++) {
			if (allAccounts[count].startsWith(account)) return acctEndDate[count];
		}
		return Transaction.returnCalendarFromYYYYMMDD(TransactionList.STR_DATE_MIN);
	}

	public void setAcctEndDate(int position, Calendar acctEnd) {
		if (position>=0 && position<acctEndDate.length)
			acctEndDate[position] = acctEnd;
	}

	public void setAcctEndDate(String account, Calendar acctEnd) {
		int count = 0;
		for (count = 0; count < allAccounts.length; count++) {
			if (allAccounts[count].startsWith(account)) acctEndDate[count] = acctEnd;
		}
	}

	public String getActiveAccount() {
		return activeAccount;
	}

	public void setActiveAccount(String activeAccount) {
		this.activeAccount = activeAccount;
	}

	/**
	 * Returns the account position in the allAccounts array,
	 * searched either by accountNick (if accountNick!=""), or
	 * by accountNumber's last four digits (if accountNumber>three digits)
	 * @param accountNick identifying account nick (or "" for search by number)
	 * @param accountNumber identifying account number (or "" for search by nick)
	 * @return position of the account in the array if found, -1 if not found
	 */
	private int accountPosition(String accountNick, String accountNumber) {
		// if the array is empty, return -1 right away
		if (allAccounts.length < 1) return -1;
		if (accountNick.length()>0) {
			int count = 0;
			for (count = 0; count < allAccounts.length; count++) {
				if (allAccounts[count].startsWith(accountNick)) return count;
			}
		} else if (accountNumber.length()>=4) {
			int count = 0;
			accountNumber = accountNumber.substring(accountNumber.length()-4, accountNumber.length());
			for (count = 0; count < allAccounts.length; count++) {
				String[] tempStr = allAccounts[count].split(" …");
				if (tempStr[1].startsWith(accountNumber)) return count;
			}
		}
		return -1;
	}

	/**
	 * Gets the name + abs. path from the Request object, checks the file for
	 * readability, hands the job over to OFX parser and collects and expedites
	 * the Result as a ListIterator. The newly populated list is no more than
	 * request.from - request.to long.
	 * @param request - Request object;
	 *                  request.fileWithPath, request.from, request.to filled out
	 * @return - list of Result objects with Transaction fields filled out
	 */
	public ListIterator<Result> parseOFX(Request request) {
		File file = null;
		Result result = new Result();
		TransactionList parsedTlist = new TransactionList();
		ArrayList<Result> rList = new ArrayList<Result>();
		try {
			file = new File(request.getFileWithPath());
			parsedTlist = OFXParser.ofxParser(file, request.getFrom(), request.getTo());
			if (parsedTlist ==null) {
				result.setCode(WRONG_FILE);
			} else if (parsedTlist.size()==0){
				result.setCode(NO_ITEMS_TO_READ);
			} else {
				result.setCode(SUCCESS);
			}
		} catch (Exception e) {
			result.setCode(IO_ERROR);
		}
		if (result.getCode()!=SUCCESS) {
			rList.add(result);
			return rList.listIterator();
		}
		//SUCCESS: parsedTList is merged into the beginning or ending of the database
		String acctNum = OFXParser.getAcctNumber();
		int acctPos = accountPosition("", acctNum);
		if (acctPos==-1) {
			// set up a new account, clear the table; the following is temporary
			String[] tempAccounts = new String[(allAccounts.length+1)];
			System.arraycopy(allAccounts, 0, tempAccounts, 0, allAccounts.length);
			allAccounts = tempAccounts;
			allAccounts[allAccounts.length-1] = "My "+OFXParser.getAcctType()+" …"+
					acctNum.substring(acctNum.length()-4, acctNum.length());
			if (OFXParser.getBankName().length()>0)
				allAccounts[allAccounts.length-1] += " ("+ OFXParser.getBankName()+")";
			activeAccount = "My "+OFXParser.getAcctType();
			Calendar[] tempBegin = new Calendar[acctBeginDate.length+1];
			Calendar[] tempEnd = new Calendar[acctEndDate.length+1];
			System.arraycopy(acctBeginDate, 0, tempBegin, 0, acctBeginDate.length);
			System.arraycopy(acctEndDate, 0, tempEnd, 0, acctEndDate.length);
			tempBegin[tempBegin.length-1] = Transaction.returnCalendarFromYYYYMMDD(TransactionList.STR_DATE_MIN);
			tempEnd[tempEnd.length-1] = Transaction.returnCalendarFromYYYYMMDD(TransactionList.STR_DATE_MIN);
			acctBeginDate = tempBegin;
			acctEndDate = tempEnd;
		} else {
			// if the parsed account is not the active account, fetch it and make it active
			String[] tempStr = allAccounts[acctPos].split(" …");
			setActiveAccount(tempStr[0]);
		}
		if (mergeNewTList(parsedTlist)) return returnRListIterator();
		else {
			result.setCode(NO_ITEMS_TO_READ);
			rList.add(result);
			return rList.listIterator();
		}
	}

	/**
	 * Merges a new list (from parsing or manual entry) into the database.
	 * @param list - list to be merged
	 * @return - TRUE if succeeded, FALSE if nothing got merged
	 */
	private boolean mergeNewTList(TransactionList list) {
		boolean change = false;
		System.out.println("POTENTIALLY ADDING "+list.size()+", active acct: "+activeAccount);
		for (int i = 0; i < allAccounts.length; i++) { System.out.println(allAccounts[i]); }
		System.out.println("\n");
		for (int i = 0; i < acctBeginDate.length; i++) { System.out.println(Transaction.returnYYYYMMDDFromCalendar
				(acctBeginDate[i])+"-"+Transaction.returnYYYYMMDDFromCalendar(acctEndDate[i])); }
		TransactionList resultTList = new TransactionList();
		if (list.getStartDate().compareTo(getAcctBeginDate(activeAccount))<=0) {
			// fetch the first 3-or-less-month chunk of the db and load it in tList
			int i = 0;
			for (int j=0;j<tList.size();j++) resultTList.add(tList.get(j));
			// do this until the end of the parsedTList or beginning of the db
			while (i< list.size() &&
					list.get(i).getPostedDate().compareTo(getAcctBeginDate(activeAccount))<=0) {
				if (resultTList.add(list.get(i))) change = true;
				i++;
			}
			setAcctBeginDate(activeAccount, resultTList.getStartDate());
			tList = resultTList;
			return change;
		} else if (list.getEndDate().compareTo(getAcctEndDate(activeAccount))>=0) {
			// fetch the last 3-or-less-month chunk of db and load it in tList
			for (int i=0;i<tList.size();i++) resultTList.add(tList.get(i));
			int i = 0;
			while (i< list.size() &&
					list.get(i).getPostedDate().compareTo(getAcctEndDate(activeAccount))<0) i++;
			for (int j = i; j< list.size(); j++) {
				if (resultTList.add(list.get(j))) change = true;
			}
			setAcctEndDate(activeAccount, resultTList.getEndDate());
			// If database is empty, do:
			if (tList.size()==0) setAcctBeginDate(activeAccount, list.getStartDate());
			tList = resultTList;
			return change;
		}
		return change;
	}

	/**
	 * Returns an ListIterator of Results with fields filled out with all Transactions
	 * from Transaction list.
	 */
	public ListIterator<Result> returnRListIterator() {
		ListIterator<Transaction> it = tList.listIterator();
		Result result = new Result();
		ArrayList<Result> rList = new ArrayList<Result>();
		result.setCode(SUCCESS);
		while (it.hasNext()) {
			result.setTFields(it.next());
			rList.add(result);
			result = new Result();
		}
		return rList.listIterator();
	}

	/**
	 * Fetches the Transaction list, sorts it by the active column criterion
	 * and distinguishes whether the data are in descending or ascending order.
	 * @return the Result object list with all Transaction fields filled out
	 */
	private ListIterator<Result> getNewView() {
		ListIterator<Transaction> it = tList.sort(sortedColumn);
		ArrayList<Result> resIt = new ArrayList<Result>();
		if (descColumn[sortedColumn]) {
			while (it.hasNext()) {
				Result result = new Result();
				result.setTFields(it.next());
				resIt.add(result);
			}
		} else {
			while (it.hasNext()) { it.next(); }
			while (it.hasPrevious()) {
				Result result = new Result();
				result.setTFields(it.previous());
				resIt.add(result);
			}
		}
		return resIt.listIterator();
	}

	/**
	 * Switches the view between descending and ascending order.
	 * @return new IteratorList to view
	 */
	public ListIterator<Result> sortingOrientationSwitched() {
		descColumn[sortedColumn] = !descColumn[sortedColumn];
		return getNewView();
	}

	/*
	/**
	 * Switches between the active columns and prepares a newly sorted view.
	 * @param request Request object preloaded with the button (column header)
	 *                pressed
	 * @return new IteratorList to view
	 */
	/*
	public ListIterator<Result> sortedColumnSwitched(Request request) {
		switch (request.getButton()) {
			case DATE:
				sortedColumn = Transaction.POSTED_DATE;
				break;
			case REF:
				sortedColumn = Transaction.REF_NUMBER;
				break;
			case NAME:
				sortedColumn = Transaction.DESCRIPTION;
				break;
			case MEMO:
				sortedColumn = Transaction.MEMO;
				break;
			case AMOUNT:
				sortedColumn = Transaction.AMOUNT;
				break;
			case CAT:
				sortedColumn = Transaction.CATEGORY;
				break;
			default: ;
		}
		return getNewView();
	}
	*/

	public boolean processSingleManualEntry(Request request) {
		int acctPos = accountPosition(request.getAccountNick(), "");
		if (acctPos==-1) {
			// set up a new account, clear the table; the following is temporary
			String[] tempAccounts = new String[(allAccounts.length+1)];
			System.arraycopy(allAccounts, 0, tempAccounts, 0, allAccounts.length);
			allAccounts = tempAccounts;
			String acctNum = request.getAccountNumber();
			if (acctNum.length()<4) acctNum = "    ";
			allAccounts[allAccounts.length-1] = request.getAccountNick()+" …"+
					acctNum.substring(acctNum.length()-4, acctNum.length());
			if (request.getBankName().length()>0)
				allAccounts[allAccounts.length-1] += " ("+ request.getBankName()+")";
			System.out.println("NEW ACCT: "+allAccounts[allAccounts.length-1]);
			activeAccount = request.getAccountNick();
			Calendar[] tempBegin = new Calendar[acctBeginDate.length+1];
			Calendar[] tempEnd = new Calendar[acctEndDate.length+1];
			System.arraycopy(acctBeginDate, 0, tempBegin, 0, acctBeginDate.length);
			System.arraycopy(acctEndDate, 0, tempEnd, 0, acctEndDate.length);
			tempBegin[tempBegin.length-1] = Transaction.returnCalendarFromYYYYMMDD(TransactionList.STR_DATE_MIN);
			tempEnd[tempEnd.length-1] = Transaction.returnCalendarFromYYYYMMDD(TransactionList.STR_DATE_MIN);
			acctBeginDate = tempBegin;
			acctEndDate = tempEnd;
		} else {
			// if the added account is not the active account, fetch it and make it active
			setActiveAccount(request.getAccountNick());
		}
		// if a new Category is present in request.tCat at time of syncing local<--->database, it will get
		// written in Category table.
		Transaction newT = new Transaction(Transaction.returnCalendarFromYYYYMMDD(request.getTDate()),
				request.getTRef(), request.getTDesc(), request.getTMemo(), request.getTAmount(), request.getTCat());
		TransactionList list = new TransactionList();
		list.add(newT);
		return mergeNewTList(list);
	}

	public Result downloadDropDownMenuEntries() {
		Result output = new Result();
		// code for downloading table accounts from the database: all account nicks (unique),
		// all account numbers (unique, decrypted), all bank names (unique). Also all
		// category names (unique; best make a table of categories, which can be encrypted).
		//
		// int accountCount = <number of lines of the account list in database>;
		// int bankCount = <number of banks in the account list in database>;
		int accountCount = 0;
		int bankCount = 0;
		allAccounts = new String[accountCount];
		for (int i = 0; i < accountCount; i++) {
			String accountDescription = "";
			// accountDescription= <account nick> + " …" + <last 4 digits of account number> +
			//					  " (" + <bank name> + ")";
			allAccounts[i] = accountDescription;
		}
		allBanks = new String[bankCount];
		for (int i = 0; i < bankCount; i++) {
			allBanks[i] = ""; // allBanks[i] = <bank name>;
		}
		String[] bankTestingArr = new String[]{"Wells Fargo", "US Bank", "Bank Of America"};
		String[] accntNicksTestingArr = new String[]{ "", "Work Accnt …5147 (Wells Fargo)",
				"Family Use Accnt …1440 (US Bank)","Secret Saving Accnt …4777 (Bank Of America)"};
		String[] trnsCategoriesTestingArr = new String[]{ "Food","Car Repair","Mortgage", "Car insurance", "Fun", "<OTHER>"};
		output.setBankList(bankTestingArr);
		output.setAcctList(accntNicksTestingArr);
		output.setCategoryList(trnsCategoriesTestingArr);
		return output;
	}

	public ListIterator<Result> initialDBaseDownload() {
		// set activeAccount = ...;
		// for each account fetch begin date and end date and store in the
		// arrays acctBeginDate and acctEndDate, in the order of accounts
		return returnRListIterator();
	}

	/*
	public static void main(String[] args) {
		Request request = Request.instance();
		ListIterator<Result> it;
		request.setFileWithPath("/Users/starnet/CreditCardSAMPLE.qfx");
		System.out.println("Now parsing.");
		it = PEC.instance().parseOFX(request);
		while (it.hasNext()) {
			System.out.println(it.next().getTDesc());
		}
	}
	*/
}

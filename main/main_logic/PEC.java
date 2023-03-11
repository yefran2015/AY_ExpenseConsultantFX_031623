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
	// in the whole database, both initialized with STR_DATE_MIN of
	// TransactionList.java (1900/01/01)--that way, if the database is empty,
	// the parsing or manual entries can start anytime after that initial date
	private Calendar dbBeginDate = Transaction.returnCalendarFromYYYYMMDD(TransactionList.STR_DATE_MIN);
	private Calendar dbEndDate = Transaction.returnCalendarFromYYYYMMDD(TransactionList.STR_DATE_MIN);
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

	public Calendar getDbBeginDate() {
		return dbBeginDate;
	}

	public void setDbBeginDate(Calendar dbBeginDate) {
		this.dbBeginDate = dbBeginDate;
	}

	public Calendar getDbEndDate() {
		return dbEndDate;
	}

	public void setDbEndDate(Calendar dbEndDate) {
		this.dbEndDate = dbEndDate;
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
		mergeNewTList(parsedTlist);
		return returnRListIterator();
	}

	/**
	 * Merges a new list (from parsing or manual entry) into the database.
	 * @param list - list to be merged
	 * @return - TRUE if succeeded, FALSE if nothing got merged
	 */
	private boolean mergeNewTList(TransactionList list) {
		Calendar listStart = list.getStartDate();
		Calendar listEnd = list.getEndDate();
		TransactionList resultTList = new TransactionList();
		if (listStart.compareTo(dbBeginDate)<=0) {
			// fetch the first 3-or-less-month chunk of the db and load it in tList
			int i = 0;
			// do this until the end of the parsedTList or beginning of the db
			while (i< list.size() &&
					list.get(i).getPostedDate().compareTo(dbBeginDate)<=0) {
				resultTList.add(list.get(i));
				i++;
			}
			for (int j=0;j<tList.size();j++) resultTList.add(tList.get(j));
			setDbBeginDate(resultTList.getStartDate());
			tList = resultTList;
			return true;
		} else if (listEnd.compareTo(dbEndDate)>=0) {
			// fetch the last 3-or-less-month chunk of db and load it in tList
			for (int i=0;i<tList.size();i++) resultTList.add(tList.get(i));
			int i = 0;
			while (i< list.size() &&
					list.get(i).getPostedDate().compareTo(dbEndDate)<0) i++;
			for (int j = i; j< list.size(); j++) resultTList.add(list.get(j));
			setDbEndDate(resultTList.getEndDate());
			// If database is empty, do:
			if (tList.size()==0) setDbBeginDate(listStart);
			tList = resultTList;
			return true;
		}
		return false;
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
		// code for downloading 3 lists from the database: all account nicks (unique),
		// all bank names (unique), and all category names (unique; best make a table of categories,
		// which can be encrypted).
		String[] bankTestingArr = new String[]{"Wells Fargo", "US Bank", "Bank Of America"};
		String[] accntNicksTestingArr = new String[]{ "", "Work Accnt","Family Use Accnt","Secret Saving Accnt"};
		String[] trnsCategoriesTestingArr = new String[]{ "Food","Car Repair","Mortgage", "Car insurance", "Fun"};
		output.setBankList(bankTestingArr);
		output.setNickList(accntNicksTestingArr);
		output.setCategoryList(trnsCategoriesTestingArr);
		return output;
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

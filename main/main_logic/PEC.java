package main_logic;

//import java.util.ArrayList;
//import java.util.ListIterator;

import entities.Transaction;
import entities.TransactionList;
import parsers.OFXParser;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
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
	// in the database, both initialized with STR_DATE_MIN of
	// TransactionList.java (1900/01/01)--that way, if the database is empty,
	// the parsing or manual entries can start anytime after that initial date
	private Calendar beginDate = Transaction.returnCalendarFromYYYYMMDD(TransactionList.STR_DATE_MIN);
	private Calendar endDate = Transaction.returnCalendarFromYYYYMMDD(TransactionList.STR_DATE_MIN);
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

		// beginning = <the first time index (transaction_date) in the database>;
		// ending = <the date of the last Transaction in tList>;
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

	public Calendar getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Calendar beginDate) {
		this.beginDate = beginDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
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
		ArrayList<Result> rList = new ArrayList<Result>();
		try {
			file = new File(request.getFileWithPath());
			System.out.println(tList.size());
			tList = OFXParser.ofxParser(file, request.getFrom(), request.getTo());
			System.out.println(tList.size());
			if (tList==null) {
				result.setCode(WRONG_FILE);
			} else if (tList.size()==0){
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
		//resetView();
		return returnRListIterator();
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
		System.out.println(tList.size());
		Transaction newT = new Transaction(Transaction.returnCalendarFromOFX(request.getTDate()),
				request.getTRef(), request.getTDesc(), request.getTMemo(), request.getTAmount(), request.getTCat());
		return tList.add(newT);
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

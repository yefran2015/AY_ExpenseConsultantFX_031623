package main_logic;

import entities.Transaction;
import entities.TransactionList;
import parsers.OFXParser;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

import static main_logic.Result.Code.*;

public class PEC {

	// private main structure housing active Transaction data
	// (no more than 3 months worth)
	private TransactionList tList;
	// array of booleans to remember if a particular column is sorted
	// in a ascending (or descending) direction
	private boolean[] ascColumn = { true, true, true, true, true, true };
	// sortedColumn indicates which column is active and sorted on screen
	private int sortedColumn = Transaction.POSTED_DATE;

	private static PEC singleton = null;

	/**
	 * Private constructor.
	 */
	private PEC() {
		tList = new TransactionList();
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

	/**
	 * Gets the ascending/descending orientation of all view columns.
	 * Important for GUI and the small arrow on the right side of the
	 * active column header.
	 * @return an array of boolean - each is TRUE if the corresponding
	 * 			column is sorted in ascending order (FALSE for descending)
	 */
	public boolean[] getAscColumn() {
		return ascColumn;
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
	 * Sets all columns to be viewed in ascending order, sets the sorted
	 * column to go by as the one with the "date posted".
	 */
	private void resetView() {
		Arrays.fill(ascColumn, true);
		sortedColumn = Transaction.POSTED_DATE;
	}

	/**
	 * Gets the name + abs. path from the Request object, checks the file for
	 * readability, hands the job over to OFX parser and collects and expedites
	 * the Result as a ListIterator. The newly populated list is no more than
	 * 3 months long.
	 * @param request - Request object
	 * @return - list of Result objects with Transaction fields filled out
	 */
	private ListIterator<Result> parseOFX(Request request) {
		File file = null;
		boolean exception = false;
		Result result = new Result();
		ListIterator<Result> rList = new ArrayList<Result>().listIterator();
		try {
			file = new File(request.getFileWithPath());
			tList = OFXParser.ofxParser(file);
		} catch (Exception e) {
			exception = true;
		}
		if (exception) {
			result.setCode(IO_ERROR);
			rList.add(result);
			return rList;
		}
		result.setCode(SUCCESS);
		ListIterator<Transaction> it = tList.listIterator();
		while (it.hasNext()) {
			result.setTFields(it.next());
			rList.add(result);
			result = new Result();
		}
		resetView();
		return rList;
	}

	/**
	 * Fetches the Transaction list, sorts it by the active column criterion
	 * and distinguishes whether the data are in ascending or descending order.
	 * @return the Result object list with all Transaction fields filled out
	 */
	private ListIterator<Result> getNewView() {
		ListIterator<Transaction> it = tList.sort(sortedColumn);
		ListIterator<Result> resIt = new ArrayList<Result>().listIterator();
		Result result = new Result();
		if (!it.hasNext()) {
			result.setCode(NO_TRANSACTIONS);
			resIt.add(result);
			return resIt;
		} else {
			result.setCode(SUCCESS);
		}
		if (ascColumn[sortedColumn]) {
			while (it.hasNext()) {
				result.setTFields(it.next());
				resIt.add(result);
				result = new Result();
			}
		} else {
			while (it.hasNext()) { it.next(); }
			// maybe we need to add the last element as the first
			// of the resIt ListIterator  ==>  test this!!
			while (it.hasPrevious()) {
				result.setTFields(it.previous());
				resIt.add(result);
				result = new Result();
			}
		}
		return resIt;
	}

	/**
	 * Switches the view between ascending and descending order.
	 * @return new IteratorList to view
	 */
	private ListIterator<Result> sortingOrientationSwitched() {
		ascColumn[sortedColumn] = !ascColumn[sortedColumn];
		return getNewView();
	}

	/**
	 * Switches between the active columns and prepares a newly sorted view.
	 * @param request Request object preloaded with the button (column header)
	 *                pressed
	 * @return new IteratorList to view
	 */
	private ListIterator<Result> sortedColumnSwitched(Request request) {
		switch (request.getButton()) {
			case DATE -> sortedColumn = Transaction.POSTED_DATE;
			case REF -> sortedColumn = Transaction.REF_NUMBER;
			case NAME -> sortedColumn = Transaction.DESCRIPTION;
			case MEMO -> sortedColumn = Transaction.MEMO;
			case AMOUNT -> sortedColumn = Transaction.AMOUNT;
			case CAT -> sortedColumn = Transaction.CATEGORY;
			default -> { }
		}
		return getNewView();
	}

	public static void main(String[] args) {

	}
}

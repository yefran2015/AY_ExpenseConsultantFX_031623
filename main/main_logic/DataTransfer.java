package main_logic;

import entities.Transaction;

public class DataTransfer {


	// Transaction fields
	private String tDate;
	private String tRef;
	private String tDesc;
	private String tMemo;
	private Double tAmount;
	private String tCat;
	// parse OFX file fields
	private String fileWithPath;

	// ... Both GUI programmers and LOGIC programmers are allowed to add fields and
	// corresponding methods to convey functionality back and forth between LOGIC
	// and GUI.

	public DataTransfer() {
		reset();
	}

	/**
	 * Resets all fields to "", null, or zero.
	 */
	public void reset() {
		tDate = "";
		tRef = "";
		tDesc = "";
		tMemo = "";
		tAmount = 0.0;
		tCat = "";
		fileWithPath = "";

		// ...
	}

	public String getTDate() {
		return tDate;
	}

	public void setTDate(String tDate) {
		this.tDate = tDate;
	}

	public String getTRef() {
		return tRef;
	}

	public void setTRef(String tRef) {
		this.tRef = tRef;
	}

	public String getTDesc() {
		return tDesc;
	}

	public void setTDesc(String tDesc) {
		this.tDesc = tDesc;
	}

	public String getTMemo() {
		return tMemo;
	}

	public void setTMemo(String tMemo) {
		this.tMemo = tMemo;
	}

	public Double getTAmount() {
		return tAmount;
	}

	public void setTAmount(Double tAmount) {
		this.tAmount = tAmount;
	}

	public String getTCat() {
		return tCat;
	}

	public void setTCat(int tCatValue) {
		this.tCat = Transaction.getACategoryName(tCatValue);
	}

	public String getFileWithPath() {
		return fileWithPath;
	}

	public void setFileWithPath(String fileWithPath) {
		this.fileWithPath = fileWithPath;
	}

	// more getters and setters: ...

	public void setTFields(Transaction transaction) {
		this.tDate = Transaction.returnMMslashDDFromCalendar(transaction.getPostedDate());
		this.tRef = transaction.getRefNumber();
		this.tDesc = transaction.getDescription();
		this.tMemo = transaction.getMemo();
//		if (transaction.getAmount()<0) { this.tAmount = String.format("$%.2f", transaction.getAmount()); }
//		else { this.tAmount = String.format("$ %.2f", transaction.getAmount()); }
		this.tAmount = ((int)(transaction.getAmount() * 100))/100.0;
		this.tCat = transaction.getCategoryName();
	}

}

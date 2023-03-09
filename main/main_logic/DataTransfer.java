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
	private String accountNick;
	private String[] nickList;
	private String[] bankList;
	private String[] categoryList;

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
		accountNick = "";
		nickList = new String[0];
		bankList = new String[0];
		categoryList = new String[0];
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

	public void setTCat(String tCat) {
		this.tCat = tCat;
	}

	public String getFileWithPath() {
		return fileWithPath;
	}

	public void setFileWithPath(String fileWithPath) {
		this.fileWithPath = fileWithPath;
	}

	public String getAccountNick() { return accountNick; }

	public void setAccountNick(String accountNick) { this.accountNick = accountNick; }

	// more getters and setters: ...

	public void setTFields(Transaction transaction) {
		this.tDate = Transaction.returnYYYYMMDDFromCalendar(transaction.getPostedDate());
		this.tRef = transaction.getRefNumber();
		this.tDesc = transaction.getDescription();
		this.tMemo = transaction.getMemo();
//		if (transaction.getAmount()<0) { this.tAmount = String.format("$%.2f", transaction.getAmount()); }
//		else { this.tAmount = String.format("$ %.2f", transaction.getAmount()); }
		this.tAmount = ((int)(transaction.getAmount() * 100))/100.0;
		this.tCat = transaction.getCategory();
	}

	public String[] getNickList() {
		return nickList;
	}

	public void setNickList(String[] nickList) {
		this.nickList = nickList;
	}

	public String[] getBankList() {
		return bankList;
	}

	public void setBankList(String[] bankList) {
		this.bankList = bankList;
	}

	public String[] getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(String[] categoryList) {
		this.categoryList = categoryList;
	}

}

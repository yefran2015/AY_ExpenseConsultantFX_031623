package main_logic;

import entities.Transaction;

import java.util.Calendar;

public class Request extends DataTransfer {

	public static final String MIN_FROM = "19000101000000";
	public static final String MAX_TO = "20991231000000";

	/*
	public enum Button {
		// buttons of Main Menu
		START, PARSE_OFX, MANUAL, SUMMARY, ADVICE, SETTINGS, HELP, LOG_OUT,
		// screen columns and descending/ascending (orientation) arrow
		// on active column
		DATE, REF, NAME, MEMO, AMOUNT, CAT, ORIENTATION,
		// no button pressed
		NONE,
		// other buttons, organized by screens

		// ...
	}
 	*/

	private static Request request;
	// "button" identifies which button in GUI was pressed, and what type
	// of action is required

	// private Button button;

	// dates "from" and "to" to specify the time scope of request
	private Calendar from;
	private Calendar to;

	private Request() {
		reset();
	}

	public static Request instance() {
		if (request == null) {
			request = new Request();
		}
		return request;
	}

	public Calendar getFrom() { return from; }
	public String getOFXFrom() {
		// returns OFX format (YYYYMMDDHHMMSS)
		return Transaction.returnOFXFromCalendar(from);
	}

	public void setFrom(Calendar from) { this.from = from; }
	public void setOFXFrom(String from) {
		this.from = Transaction.returnCalendarFromOFX(from);
	}
	public void setMinFrom() { from = Transaction.returnCalendarFromOFX(MIN_FROM); }

	public Calendar getTo() { return to; }
	public String getOFXTo() {
		// returns OFX format (YYYYMMDDHHMMSS)
		return Transaction.returnOFXFromCalendar(to);
	}

	public void setTo(Calendar to) { this.to = to; }
	public void setOFXTo(String to) {
		this.to = Transaction.returnCalendarFromOFX(to);
	}
	public void setMaxTo() { to = Transaction.returnCalendarFromOFX(MAX_TO); }

	/*
	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}
	*/

	@Override
	public void reset() {
		super.reset();
		setMinFrom();
		setMaxTo();
		// button = Button.NONE;
	}

}

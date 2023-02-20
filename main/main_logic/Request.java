package main_logic;

public class Request extends DataTransfer {

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

	private static Request request;
	// "button" identifies which button in GUI was pressed, and what type
	// of action is required
	private Button button;
	// dates "from" and "to" to specify the time scope of request
	private String from;
	private String to;

	private Request() {
		reset();
	}

	public static Request instance() {
		if (request == null) {
			request = new Request();
		}
		return request;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	@Override
	public void reset() {
		super.reset();
		from = "";
		to = "";
		button = Button.NONE;
	}

}

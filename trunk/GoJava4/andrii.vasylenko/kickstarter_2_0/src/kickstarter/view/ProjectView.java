package kickstarter.view;

import static kickstarter.control.State.*;
import kickstarter.control.State;
import kickstarter.exception.IncorrectInputException;
import kickstarter.view.printer.Printer;
import kickstarter.view.reader.Reader;

public class ProjectView extends AbstractView {

	public ProjectView(Printer printer, Reader reader) {
		super(printer, reader);
	}

	@Override
	public State getDirection(int item) throws IncorrectInputException {
		if (item == 0) {
			return PROJECTS;
		} else if (item == 1) {
			return ASK_QUESTION;
		}
		throw new IncorrectInputException("Unknown item");
	}

	@Override
	protected String getHead() {
		return "---PROJECT---";
	}

	@Override
	protected String getMenu() {
		StringBuilder result = new StringBuilder();

		String format = "%d - %s\r\n";

		result.append(String.format(format, 1, "Ask a question"));
		result.append(String.format(format, 0, "EXIT"));

		return result.toString();
	}

}

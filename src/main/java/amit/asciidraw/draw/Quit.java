package amit.asciidraw.draw;

import java.util.List;

import amit.asciidraw.exception.InvalidInputException;

public class Quit extends AbstractCommand {

	@Override
	public void execute(final List<String> params) throws InvalidInputException {
		System.exit(0);
	}
}

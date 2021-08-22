package amit.asciidraw.app;

import amit.asciidraw.draw.AbstractCommand;
import amit.asciidraw.draw.Canvas;
import amit.asciidraw.draw.Fill;
import amit.asciidraw.draw.Line;
import amit.asciidraw.draw.Quit;
import amit.asciidraw.draw.Rectangle;
import amit.asciidraw.exception.InvalidInputException;
import amit.asciidraw.model.CommandInput;

public class CommandFactory {

	public final AbstractCommand getCommand(CommandInput input) throws InvalidInputException {
		var command = switch (input.getCommand()) {
		case CANVAS -> new Canvas();
		case LINE -> new Line();
		case RECTANGLE -> new Rectangle();
		case FILL -> new Fill();
		case QUIT -> new Quit();
		default -> throw new InvalidInputException("Invalid command!");
		};
		return command;
	}
}

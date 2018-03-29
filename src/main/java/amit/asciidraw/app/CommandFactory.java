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
		switch (input.getCommand()) {
		case CANVAS:
			return new Canvas();
		case LINE:
			return new Line();
		case RECTANGLE:
			return new Rectangle();
		case FILL:
			return new Fill();
		case QUIT:
			return new Quit();
		default:
			throw new InvalidInputException("Invalid command!");
		}
	}

}

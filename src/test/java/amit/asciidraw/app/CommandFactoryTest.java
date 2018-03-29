package amit.asciidraw.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import amit.asciidraw.draw.AbstractCommand;
import amit.asciidraw.draw.Canvas;
import amit.asciidraw.draw.Fill;
import amit.asciidraw.draw.Line;
import amit.asciidraw.draw.Quit;
import amit.asciidraw.draw.Rectangle;
import amit.asciidraw.exception.InvalidInputException;
import amit.asciidraw.model.CommandInput;

public class CommandFactoryTest {

	@Test
	public void testGetCommand() throws InvalidInputException {
		CommandFactory factory = new CommandFactory();
		CommandInput input = new CommandInput("C 20 10");
		AbstractCommand command = factory.getCommand(input);

		assertTrue(command instanceof Canvas);

		input = new CommandInput("L 2 10 2 5");
		command = factory.getCommand(input);

		assertTrue(command instanceof Line);

		input = new CommandInput("R 2 5 12 8");
		command = factory.getCommand(input);

		assertTrue(command instanceof Rectangle);

		input = new CommandInput("B 2 4 o");
		command = factory.getCommand(input);

		assertTrue(command instanceof Fill);

		input = new CommandInput("Q");
		command = factory.getCommand(input);

		assertTrue(command instanceof Quit);
	}
}

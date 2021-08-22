package amit.asciidraw.app;

import java.util.List;

import amit.asciidraw.draw.AbstractCommand;
import amit.asciidraw.exception.InvalidInputException;
import amit.asciidraw.model.CommandInput;

public class CommandContext {

	private AbstractCommand command;

	private final CommandFactory factory = new CommandFactory();

	public void setCommand(final CommandInput commandInput) throws InvalidInputException {
		var newCommand = factory.getCommand(commandInput);
		if (this.command != null) {
			newCommand.setHeight(this.command.getHeight());
			newCommand.setWidth(this.command.getWidth());
			newCommand.setShape(this.command.getShape());
		}
		this.command = newCommand;
	}

	public void executeCommand(final List<String> params) throws InvalidInputException {
		command.execute(params);
	}
}

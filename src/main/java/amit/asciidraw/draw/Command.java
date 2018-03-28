package amit.asciidraw.draw;

import java.util.List;

import amit.asciidraw.exception.InvalidInputException;

public interface Command {
	public void execute(List<String> params) throws InvalidInputException;
}

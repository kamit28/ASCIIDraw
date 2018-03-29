package amit.asciidraw.app;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import amit.asciidraw.draw.AbstractCommand;
import amit.asciidraw.exception.InvalidInputException;
import amit.asciidraw.model.CommandInput;
import amit.asciidraw.model.CommandType;

public class Application {

	private AbstractCommand context;

	private final Pattern pattern = Pattern.compile("[a-zA-Z]{1}(\\s\\d+)*(\\s[a-zA-z]{1})?+");
	
	public static void main(String[] args) {
		printHelp();
		Application app = new Application();
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				try {
					System.out.print("Enter command: ");
					app.executeCommnad(scanner.nextLine());
				} catch (InvalidInputException iie) {
					System.err.println(iie.getMessage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printHelp() {
		String help = "The work as follows:\n" + "1. Create a new canvas \n"
				+ "2. Draw on the canvas by issuing various commands \n" + "3. Quit \n\n\n"
				+ "|Command 		|Description|\n" + "|----|----|\n"
				+ "|C w h          | Create a new canvas of width w and height h.|\n"
				+ "|L x1 y1 x2 y2  | Draw a new line from (x1,y1) to (x2,y2). Currently, only|\n"
				+ "|               | horizontal or vertical lines are supported. Horizontal and vertical lines|\n"
				+ "|               | will be drawn using the 'x' character.|\n"
				+ "|R x1 y1 x2 y2  | Draw a rectangle whose upper left corner is (x1,y1) and|\n"
				+ "|               | lower right corner is (x2,y2). Horizontal and vertical lines will be drawn|\n"
				+ "|               | using the 'x' character.|\n"
				+ "|B x y c        | Fill the entire area connected to (x,y) with \"colour\" c. The|\n"
				+ "|               | behaviour of this is the same as that of the \"bucket fill\" tool in paint|\n"
				+ "|               | programs.|\n" + "|Q              | Quit|\n";
		System.out.println(help);
	}

	private void executeCommnad(String commandInput) throws InvalidInputException {
		Matcher matcher = pattern.matcher(commandInput);
		if (!matcher.matches()) {
			throw new InvalidInputException("Command string is invalid.");
		}
		CommandInput input = new CommandInput(commandInput);
		if (context == null) {
			if (!(input.getCommand().equals(CommandType.CANVAS) || input.getCommand().equals(CommandType.QUIT))) {
				throw new InvalidInputException("Canvas is not available for drawing. First create a canvas with C <width> <height>");
			} else {
				context = CommandFactory.getCommand(input);
			}
		} else {
			AbstractCommand command = CommandFactory.getCommand(input);
			command.setHeight(context.getHeight());
			command.setWidth(context.getWidth());
			command.setShape(context.getShape());
			context = command;
		}
		context.execute(input.getParams());
	}
}

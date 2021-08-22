package amit.asciidraw.draw;

import java.util.ArrayList;
import java.util.List;

import amit.asciidraw.exception.InvalidInputException;

public class Canvas extends AbstractCommand {

	@Override
	public void execute(final List<String> params) throws InvalidInputException {

		if (params.size() < 2) {
			throw new InvalidInputException(
					"Canvas command requires 2 parameters, " + params.size() + " params provided.");
		}

		int width = Integer.parseInt(params.get(0));
		int height = Integer.parseInt(params.get(1));

		// set properties for canvas
		setWidth(width);
		setHeight(height);

		String canvas = getCanvas();

		// clear screen
		clearConsole();

		// Draw canvas
		System.out.print(canvas);
	}

	private String getCanvas() {
		shape = new char[height + 2][width];
		// Draw upper border
		draw(0, 0, width - 1, 0, '-');
		// Draw left border
		draw(0, 1, 0, height + 1, '|');
		// Draw right border
		draw(width - 1, 1, width - 1, height + 1, '|');
		// Draw lower border
		draw(0, height + 1, width - 1, height + 1, '-');

		return getShapeAsString();
	}

	// local test
	public static void main(String[] args) throws InvalidInputException {
		Canvas canvas = new Canvas();

		List<String> params = new ArrayList<>();
		params.add("20");
		params.add("5");

		canvas.execute(params);
	}
}

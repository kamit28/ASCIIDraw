package amit.asciidraw.draw;

import java.util.ArrayList;
import java.util.List;

import amit.asciidraw.exception.InvalidInputException;

public class Rectangle extends AbstractCommand {

	@Override
	public void execute(List<String> params) throws InvalidInputException {

		if (params.size() < 4) {
			throw new InvalidInputException(
					String.format("Rectangle command requires 4 parameters, {} params provided.", params.size()));
		}

		int x1 = Integer.parseInt(params.get(0));
		int y1 = Integer.parseInt(params.get(1));
		int x2 = Integer.parseInt(params.get(2));
		int y2 = Integer.parseInt(params.get(3));

		validate(x1, y1, x2, y2);

		String rectangle = getRectangle(x1, y1, x2, y2);

		// Draw rectangle
		System.out.print(rectangle);

	}

	private String getRectangle(int x1, int y1, int x2, int y2) {
		draw(x1, y1, x2, y1, 'x');
		draw(x1, y1, x1, y2, 'x');
		draw(x2, y1, x2, y2, 'x');
		draw(x1, y2, x2, y2, 'x');

		return getShapeAsString();
	}

	// Local test.
	public static void main(String[] args) throws InvalidInputException {
		Canvas canvas = new Canvas();
		List<String> params = new ArrayList<>();
		params.add("20");
		params.add("20");

		canvas.execute(params);

		Rectangle rect = new Rectangle();
		params = new ArrayList<>();

		params.add("5");
		params.add("2");
		params.add("15");
		params.add("8");

		rect.setHeight(20);
		rect.setWidth(20);

		rect.shape = canvas.shape;

		rect.execute(params);

	}

}

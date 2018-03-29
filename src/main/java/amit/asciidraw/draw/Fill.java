package amit.asciidraw.draw;

import java.util.ArrayList;
import java.util.List;

import amit.asciidraw.exception.InvalidInputException;

public class Fill extends AbstractCommand {

	@Override
	public void execute(List<String> params) throws InvalidInputException {
		if (params.size() < 3 || !validParams(params)) {
			throw new InvalidInputException(
					"Fill command requires 3 parameters, " + params.size() + " params provided.");
		}
		int x = Integer.parseInt(params.get(0));
		int y = Integer.parseInt(params.get(1));
		char fillChar = params.get(2).charAt(0);

		String fill = fill(x, y, fillChar);

		System.out.println(fill);
	}

	private boolean validParams(List<String> params) {
		return isInteger(params.get(0)) && isInteger(params.get(1)) && params.get(2).length() == 1;
	}

	private boolean isInteger(String str) {
		return str.matches("-?\\d+?");
	}

	private String fill(int x, int y, char ch) {
		if (shape[y][x] != 0) {
			return "";
		}

		if (x > 0 || x < height || y > 0 || y < width) {
			if (shape[y][x] == 0)
				shape[y][x] = ch;
			fill(x + 1, y, ch);
			fill(x - 1, y, ch);
			fill(x, y - 1, ch);
			fill(x, y + 1, ch);
		}
		return getShapeAsString();
	}

	
	// For local test
	public static void main(String[] args) throws InvalidInputException {
		Canvas canvas = new Canvas();
		List<String> params = new ArrayList<>();
		params.add("20");
		params.add("4");

		canvas.execute(params);

		Line line = new Line();
		params = new ArrayList<>();

		params.add("1");
		params.add("2");
		params.add("6");
		params.add("2");

		line.setHeight(canvas.height);
		line.setWidth(canvas.width);

		line.shape = canvas.shape;

		line.execute(params);
		params.clear();
		params.add("6");
		params.add("3");
		params.add("6");
		params.add("4");

		line.execute(params);

		params.clear();

		Rectangle rect = new Rectangle();
		params = new ArrayList<>();

		params.add("14");
		params.add("1");
		params.add("18");
		params.add("3");

		rect.setHeight(canvas.height);
		rect.setWidth(canvas.width);

		rect.shape = canvas.shape;

		rect.execute(params);

		Fill fill = new Fill();
		params.clear();
		params.add("10");
		params.add("3");
		params.add("o");

		fill.setHeight(canvas.height);
		fill.setWidth(canvas.width);
		fill.shape = canvas.shape;

		fill.execute(params);
	}
}

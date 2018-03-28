package amit.asciidraw.draw;

import java.util.Arrays;
import java.util.List;

import amit.asciidraw.exception.InvalidInputException;

public abstract class AbstractCommand implements Command {

	protected int width;
	protected int height;
	protected char[][] shape;

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	public void draw(int x1, int y1, int x2, int y2, char drawChar) {
		if (x1 == x2) {
			// vertical line
			for (int i = y1; i <= y2; i++) {
				shape[i][x1] = drawChar;
			}
		} else if (y1 == y2) {
			// horzontal line
			Arrays.fill(shape[y1], x1, x2+1, drawChar);
		} else {
			// we have a slope
			double slope = (double) (y2 - y1) / (double) (x2 - x1);
			for (int i = y1; i <= y2; i++) {
				shape[i][(int) Math.ceil(x1 + (slope * i))] = drawChar;
			}
		}
	}

	public String getShapeAsString() {
		StringBuilder results = new StringBuilder();
		String separator = "\n";

		for (int i = 0; i < shape.length; ++i) {
			results.append(shape[i]).append(separator);
		}
		return results.toString();
	}

	protected void validate(int x1, int y1, int x2, int y2) throws InvalidInputException {
		if (x1 >= 1 && y1 >= 1 && x2 >= 1 && y2 >= 1 && x1 < width && y1 < height && x2 < width && y2 < height
				&& x1 <= x2 && y1 <= y2) {
			return;
		}
		throw new InvalidInputException("Points are beyond the canvas borders or incorrect co-ordinates");
	}

	@Override
	public abstract void execute(List<String> params) throws InvalidInputException;

	protected final void clearConsole() {
		try {
			final String os = System.getProperty("os.name");

			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (final Exception e) {
			// Handle any exceptions.
		}
	}

}

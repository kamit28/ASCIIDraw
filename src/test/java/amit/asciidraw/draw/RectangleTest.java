package amit.asciidraw.draw;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import amit.asciidraw.exception.InvalidInputException;

public class RectangleTest {

	@Test
	public void testExecute() throws InvalidInputException {
		Canvas canvas = new Canvas();
		List<String> params = new ArrayList<>();
		params.add("6");
		params.add("5");

		canvas.execute(params);

		Rectangle rect = new Rectangle();
		params = new ArrayList<>();

		params.add("1");
		params.add("1");
		params.add("4");
		params.add("4");

		rect.setHeight(canvas.height);
		rect.setWidth(canvas.width);
		rect.shape = canvas.shape;

		rect.execute(params);

		assertTrue(canvas.shape != null);
		assertTrue(canvas.height == 5);
		assertTrue(canvas.width == 6);

		char[][] expected = { { '-', '-', '-', '-', '-', '-' }, { '|', 'x', 'x', 'x', 'x', '|' },
				{ '|', 'x', 0, 0, 'x', '|' }, { '|', 'x', 0, 0, 'x', '|' }, { '|', 'x', 'x', 'x', 'x', '|' },
				{ '|', 0, 0, 0, 0, '|' }, { '-', '-', '-', '-', '-', '-' } };

		assertEquals(Arrays.deepToString(rect.shape), Arrays.deepToString(expected));
	}

	@Test(expected = InvalidInputException.class)
	public void testExecuteWhenInSufficientParams() throws InvalidInputException {
		Rectangle rect = new Rectangle();
		List<String> params = new ArrayList<>();

		params.add("1");
		params.add("1");
		params.add("4");

		rect.execute(params);
	}

	@Test(expected = InvalidInputException.class)
	public void testExecuteWhenCoordinatedOutOfCanvas() throws InvalidInputException {
		Canvas canvas = new Canvas();
		List<String> params = new ArrayList<>();
		params.add("6");
		params.add("4");

		canvas.execute(params);

		Rectangle rect = new Rectangle();
		params = new ArrayList<>();

		params.add("1");
		params.add("1");
		params.add("4");
		params.add("5");

		rect.setHeight(canvas.height);
		rect.setWidth(canvas.width);
		rect.shape = canvas.shape;

		rect.execute(params);
	}
}

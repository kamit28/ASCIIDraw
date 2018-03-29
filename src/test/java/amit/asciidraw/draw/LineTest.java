package amit.asciidraw.draw;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import amit.asciidraw.exception.InvalidInputException;

public class LineTest {

	@Test
	public void testExecute() throws InvalidInputException {
		Canvas canvas = new Canvas();
		List<String> params = new ArrayList<>();
		params.add("6");
		params.add("4");

		canvas.execute(params);

		Line line = new Line();
		params = new ArrayList<>();

		params.add("2");
		params.add("2");
		params.add("4");
		params.add("2");

		line.setHeight(canvas.height);
		line.setWidth(canvas.width);
		line.shape = canvas.shape;

		line.execute(params);
		assertTrue(canvas.shape != null);
		assertTrue(canvas.height == 4);
		assertTrue(canvas.width == 6);

		char[][] expected = { { '-', '-', '-', '-', '-', '-' }, { '|', 0, 0, 0, 0, '|' },
				{ '|', 0, 'x', 'x', 'x', '|' }, { '|', 0, 0, 0, 0, '|' }, { '|', 0, 0, 0, 0, '|' },
				{ '-', '-', '-', '-', '-', '-' } };

		assertEquals(Arrays.deepToString(line.shape), Arrays.deepToString(expected));

		// draw a vertical line
		params.clear();
		params.add("1");
		params.add("2");
		params.add("1");
		params.add("3");

		line.execute(params);

		char[][] expected1 = { { '-', '-', '-', '-', '-', '-' }, { '|', 0, 0, 0, 0, '|' },
				{ '|', 'x', 'x', 'x', 'x', '|' }, { '|', 'x', 0, 0, 0, '|' }, { '|', 0, 0, 0, 0, '|' },
				{ '-', '-', '-', '-', '-', '-' } };

		assertEquals(Arrays.deepToString(line.shape), Arrays.deepToString(expected1));
	}

	@Test(expected = InvalidInputException.class)
	public void testExecuteWhenInSufficientParams() throws InvalidInputException {
		Line line = new Line();

		List<String> params = new ArrayList<>();
		params.add("5");
		params.add("2");
		params.add("12");
		line.execute(params);
	}

	@Test(expected = InvalidInputException.class)
	public void testExecuteWhenCoordinatedOutOfCanvas() throws InvalidInputException {
		Canvas canvas = new Canvas();
		List<String> params = new ArrayList<>();
		params.add("6");
		params.add("4");

		canvas.execute(params);

		Line line = new Line();
		params = new ArrayList<>();

		params.add("2");
		params.add("2");
		params.add("6");
		params.add("2");

		line.setHeight(canvas.height);
		line.setWidth(canvas.width);
		line.shape = canvas.shape;

		line.execute(params);
	}
}

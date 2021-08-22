package amit.asciidraw.draw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import amit.asciidraw.exception.InvalidInputException;

public class FillTest {

	@Test
	public void testExecute() throws InvalidInputException {

		// create a rectangle and fill it
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

		// fill the rectangle

		Fill fill = new Fill();
		params.clear();
		params.add("2");
		params.add("2");
		params.add("o");

		fill.setHeight(canvas.height);
		fill.setWidth(canvas.width);
		fill.shape = canvas.shape;

		fill.execute(params);

		assertNotNull(canvas.shape);
		assertEquals(canvas.height, 5);
		assertEquals(canvas.width, 6);

		char[][] expected = { { '-', '-', '-', '-', '-', '-' }, { '|', 'x', 'x', 'x', 'x', '|' },
				{ '|', 'x', 'o', 'o', 'x', '|' }, { '|', 'x', 'o', 'o', 'x', '|' }, { '|', 'x', 'x', 'x', 'x', '|' },
				{ '|', 0, 0, 0, 0, '|' }, { '-', '-', '-', '-', '-', '-' } };

		assertEquals(Arrays.deepToString(rect.shape), Arrays.deepToString(expected));
	}

	@Test
	public void testExecuteWhenInSufficientParams() throws InvalidInputException {
		Fill fill = new Fill();
		List<String> params = new ArrayList<>();

		params.add("1");
		params.add("1");

		assertThrows(InvalidInputException.class, () -> {
			fill.execute(params);
		});
	}

	@Test
	public void testExecuteWhenWrongParams() throws InvalidInputException {
		Fill fill = new Fill();
		List<String> params = new ArrayList<>();

		params.add("1");
		params.add("o");
		params.add("1");

		assertThrows(InvalidInputException.class, () -> {
			fill.execute(params);
		});
	}
}

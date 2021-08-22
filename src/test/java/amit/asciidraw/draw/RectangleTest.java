package amit.asciidraw.draw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

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

		assertNotNull(canvas.shape);
		assertEquals(5, canvas.height);
		assertEquals(6, canvas.width);

		char[][] expected = { { '-', '-', '-', '-', '-', '-' }, { '|', 'x', 'x', 'x', 'x', '|' },
				{ '|', 'x', 0, 0, 'x', '|' }, { '|', 'x', 0, 0, 'x', '|' }, { '|', 'x', 'x', 'x', 'x', '|' },
				{ '|', 0, 0, 0, 0, '|' }, { '-', '-', '-', '-', '-', '-' } };

		assertEquals(Arrays.deepToString(rect.shape), Arrays.deepToString(expected));
	}

	@Test
	public void testExecuteWhenInSufficientParams() throws InvalidInputException {
		Rectangle rect = new Rectangle();
		List<String> params = new ArrayList<>();

		params.add("1");
		params.add("1");
		params.add("4");

		assertThrows(InvalidInputException.class, () -> {
			rect.execute(params);
		});
	}

	@Test
	public void testExecuteWhenCoordinatedOutOfCanvas() throws InvalidInputException {
		Canvas canvas = new Canvas();
		List<String> params = new ArrayList<>();
		params.add("6");
		params.add("4");

		canvas.execute(params);

		Rectangle rect = new Rectangle();
		List<String> rectParams = new ArrayList<>();

		rectParams.add("1");
		rectParams.add("1");
		rectParams.add("4");
		rectParams.add("5");

		rect.setHeight(canvas.height);
		rect.setWidth(canvas.width);
		rect.shape = canvas.shape;

		assertThrows(InvalidInputException.class, () -> {
			rect.execute(rectParams);
		});
	}
}

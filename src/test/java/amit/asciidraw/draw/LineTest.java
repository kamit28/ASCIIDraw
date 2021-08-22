package amit.asciidraw.draw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

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
		assertNotNull(canvas.shape);
		assertEquals(4, canvas.height);
		assertEquals(6, canvas.width);

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

	@Test
	public void testExecuteWhenInSufficientParams() throws InvalidInputException {
		Line line = new Line();

		List<String> params = new ArrayList<>();
		params.add("5");
		params.add("2");
		params.add("12");
		assertThrows(InvalidInputException.class, () -> {
		line.execute(params);
		});
	}

	@Test
	public void testExecuteWhenCoordinatedOutOfCanvas() throws InvalidInputException {
		Canvas canvas = new Canvas();
		List<String> params = new ArrayList<>();
		params.add("6");
		params.add("4");

		canvas.execute(params);
		
		Line line = new Line();
		List<String> lineParams= new ArrayList<>();

		lineParams.add("2");
		lineParams.add("2");
		lineParams.add("6");
		lineParams.add("2");

		line.setHeight(canvas.height);
		line.setWidth(canvas.width);
		line.shape = canvas.shape;

		assertThrows(InvalidInputException.class, () -> {
			line.execute(lineParams);
		});
	}
}

package amit.asciidraw.draw;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import amit.asciidraw.exception.InvalidInputException;

public class FillTest {

	@Test
	public void testExecute() throws InvalidInputException {
		
		//create a rectangle and fill it
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
		
		//fill the rectangle
		
		Fill fill = new Fill();
		params.clear();
		params.add("2");
		params.add("2");
		params.add("o");

		fill.setHeight(canvas.height);
		fill.setWidth(canvas.width);
		fill.shape = canvas.shape;

		fill.execute(params);

		assertTrue(canvas.shape != null);
		assertTrue(canvas.height == 5);
		assertTrue(canvas.width == 6);

		char[][] expected = { { '-', '-', '-', '-', '-', '-' }, { '|', 'x', 'x', 'x', 'x', '|' },
				{ '|', 'x', 'o', 'o', 'x', '|' }, { '|', 'x', 'o', 'o', 'x', '|' }, { '|', 'x', 'x', 'x', 'x', '|' },
				{ '|', 0, 0, 0, 0, '|' }, { '-', '-', '-', '-', '-', '-' } };

		assertEquals(Arrays.deepToString(rect.shape), Arrays.deepToString(expected));
	}

	@Test(expected = InvalidInputException.class)
	public void testExecuteWhenInSufficientParams() throws InvalidInputException {
		Fill fill = new Fill();
		List<String> params = new ArrayList<>();

		params.add("1");
		params.add("1");

		fill.execute(params);
	}
	
	@Test(expected = InvalidInputException.class)
	public void testExecuteWhenWrongParams() throws InvalidInputException {
		Fill fill = new Fill();
		List<String> params = new ArrayList<>();

		params.add("1");
		params.add("o");
		params.add("1");

		fill.execute(params);
	}
}

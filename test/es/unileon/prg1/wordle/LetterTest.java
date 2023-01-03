package es.unileon.prg1.wordle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LetterTest {

	public static final String ANSI_RESET = " \u001B[0m";
	public static final String ANSI_WHITE_LETTER = "\u001b[37;1m";
	public static final String ANSI_BLUE_BG = "\u001b[44m " + ANSI_WHITE_LETTER;
	public static final String ANSI_GREEN_BG = "\u001b[42;1m " + ANSI_WHITE_LETTER;
	public static final String ANSI_YELLOW_BG = "\u001b[43;1m " + ANSI_WHITE_LETTER;

	private Letter a, copyA ,c;

	@Before
	public void setUp(){
		this.a = new Letter('a');
		this.copyA = new Letter(this.a);
		this.c = new Letter('C');
	}

	@Test
	public void testLetterChar() {
		assertEquals(ANSI_BLUE_BG + "A" + ANSI_RESET, this.a.toStringColored());
		assertEquals(Colors.BLUE, this.a.getColor());
		assertEquals(ANSI_BLUE_BG + "C" + ANSI_RESET, this.c.toStringColored());
		assertEquals(Colors.BLUE, this.c.getColor());
	}

	@Test
	public void testLetterLetter() {
		assertEquals(ANSI_BLUE_BG + "A" + ANSI_RESET, this.copyA.toStringColored());
		assertEquals(Colors.BLUE, this.a.getColor());
	}

	@Test
	public void testGetColor() {
		assertEquals(Colors.BLUE, this.a.getColor());
	}

	@Test
	public void testSetColor() {
		this.a.setColor(Colors.GREEN);
		assertEquals(Colors.GREEN, this.a.getColor());
	}

	@Test
	public void testGetLetter() {
		assertEquals('A', this.a.getLetter());
		assertEquals('a', this.a.getLetter());
	}

	@Test
	public void testSetNoneColor() {
		assertEquals(Colors.BLUE, this.a.getColor());
		this.a.setColor(Colors.GREEN);
		assertEquals(Colors.GREEN, this.a.getColor());
		this.a.setNoneColor();
		assertEquals(Colors.NONE, this.a.getColor());
	}

	@Test
	public void testSetIncludedColor() {
		assertEquals(Colors.BLUE, this.a.getColor());
		this.a.setIncludedColor();
		assertEquals(Colors.YELLOW, this.a.getColor());
	}

	@Test
	public void testSetCorrectColor() {
		assertEquals(Colors.BLUE, this.a.getColor());
		this.a.setCorrectColor();
		assertEquals(Colors.GREEN, this.a.getColor());
	}

	@Test
	public void testEqualsLetter() {
		assertTrue(this.a.equals(this.copyA));
		assertFalse(this.a.equals(this.c));
	}

	@Test
	public void testIsNoneColor() {
		assertFalse(this.a.isNoneColor());
		this.a.setNoneColor();
		assertTrue(this.a.isNoneColor());
	}

	@Test 
	public void testToString() {
		assertEquals("A", this.a.toString());
	}
	
	@Test
	public void testToStringColored() {
		assertEquals(ANSI_BLUE_BG + "A" + ANSI_RESET, this.a.toStringColored());
		this.a.setIncludedColor();
		assertEquals(ANSI_YELLOW_BG + "A" + ANSI_RESET, this.a.toStringColored());
		this.a.setCorrectColor();
		assertEquals(ANSI_GREEN_BG + "A" + ANSI_RESET, this.a.toStringColored());
		this.a.setNoneColor();
		assertEquals(ANSI_BLUE_BG + "A" + ANSI_RESET, this.a.toStringColored());
	}

}

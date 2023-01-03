package es.unileon.prg1.wordle;

public class Letter {

	public static final String ANSI_RESET = " \u001B[0m";
	public static final String ANSI_WHITE_LETTER = "\u001b[37;1m";
	public static final String ANSI_BLUE_BG = "\u001b[44m " + ANSI_WHITE_LETTER;
	public static final String ANSI_GREEN_BG = "\u001b[42;1m " + ANSI_WHITE_LETTER;
	public static final String ANSI_YELLOW_BG = "\u001b[43;1m " + ANSI_WHITE_LETTER;
	

	private char letter;
	private Colors color;

	public Letter(char c){
		this.letter = Character.toUpperCase(c);
		this.color = Colors.BLUE;
	}

	public Letter(Letter another){
		this.letter = another.getLetter();
		this.color = another.getColor();
	}

	public Colors getColor(){
		return this.color;
	}

	public void setColor(Colors color){
		this.color = color;
	}

	public char getLetter() {
		return this.letter;
	}

	public String getGreenLetter() {
		return ANSI_GREEN_BG + this.letter + ANSI_RESET;
	}

	public String getYellowLetter() {
		return ANSI_YELLOW_BG + this.letter + ANSI_RESET;
	}

	public String getNoColorLetter() {
		return ANSI_BLUE_BG + this.letter + ANSI_RESET;
	}

	public void setNoneColor(){
		this.color = Colors.NONE;
	}

	public void setIncludedColor(){
		this.color = Colors.YELLOW;
	}

	public void setCorrectColor(){
		this.color = Colors.GREEN;
	}

	public boolean equals(Letter another){
		return this.letter == another.getLetter();
	}

	public boolean isNoneColor(){
		return this.color == Colors.NONE;
	}

	@Override
	public String toString() {
		return String.valueOf(this.letter);
	}
	
	private String getColoredLetter(){
		String result = null;

		switch (this.color){
		case GREEN:
			result = this.getGreenLetter();
			break;
		case YELLOW:
			result = this.getYellowLetter();
			break;
		case BLUE:
		case NONE:
			result = this.getNoColorLetter();
			break;
		}
		return result;
	}
	
	public String toStringColored() {
		return this.getColoredLetter();
	}

}

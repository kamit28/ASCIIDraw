package amit.asciidraw.draw;

public enum CommandType {

	CANVAS("C", 2), LINE("L", 4), RECTANGLE("R", 4), FILL("B", 3), QUIT("Q", 0);

	private final String commandChar;
	private final int numParams;

	private CommandType(String commandChar, int numParams) {
		this.commandChar = commandChar;
		this.numParams = numParams;
	}

	public boolean equalsCommandChar(String other) {
		return commandChar.equals(other);
	}

	public String toString() {
		return this.commandChar;
	}
}

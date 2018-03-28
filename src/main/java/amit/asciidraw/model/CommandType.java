package amit.asciidraw.model;

import java.util.HashMap;
import java.util.Map;

public enum CommandType {

	CANVAS("C", 2), LINE("L", 4), RECTANGLE("R", 4), FILL("B", 3), QUIT("Q", 0);

	private static final Map<String, CommandType> lookup = new HashMap<>();

	static {
		for (CommandType t : CommandType.values()) {
			lookup.put(t.commandChar, t);
		}
	}

	private final String commandChar;
	@SuppressWarnings("unused")
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

	public static CommandType get(String commandChar) {
		return lookup.get(commandChar);
	}
}

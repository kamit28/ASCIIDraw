package amit.asciidraw.model;

import java.util.ArrayList;
import java.util.List;

public class CommandInput {
	private CommandType command;
	private List<String> params;

	public CommandInput() {
	}

	public CommandInput(String input) {
		String[] tokens = input.split(" ");
		this.command = CommandType.get(tokens[0].toUpperCase());
		this.params = new ArrayList<String>();
		for (int i = 1; i < tokens.length; i++) {
			this.params.add(tokens[i]);
		}
	}

	/**
	 * @return the command
	 */
	public CommandType getCommand() {
		return command;
	}

	/**
	 * @param command
	 *            the command to set
	 */
	public void setCommand(CommandType command) {
		this.command = command;
	}

	/**
	 * @return the params
	 */
	public List<String> getParams() {
		return params;
	}

	/**
	 * @param params
	 *            the params to set
	 */
	public void setParams(List<String> params) {
		this.params = params;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((command == null) ? 0 : command.hashCode());
		result = prime * result + ((params == null) ? 0 : params.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommandInput other = (CommandInput) obj;
		if (command != other.command)
			return false;
		if (params == null) {
			if (other.params != null)
				return false;
		} else if (!params.equals(other.params))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommandInput [command=").append(command)
				.append(", params=").append(params).append("]");
		return builder.toString();
	}
}

package slartidan.guitar.tab.breaker;

/**
 * Type of line
 */
public enum LineType {

	CHORDS,
	STRING_E2,
	STRING_H,
	STRING_G,
	STRING_D,
	STRING_A,
	STRING_E,
	UNDEFINED;

	/**
	 * Calculates the following type of line
	 * 
	 * @return the following type of line
	 */
	public LineType next() {
		LineType[] all = values();
		int next = ordinal()+1;
		if (next >= all.length)
			throw new TabInputException("too many lines for this tab");
		return all[next];
	}
}

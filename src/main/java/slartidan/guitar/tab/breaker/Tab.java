package slartidan.guitar.tab.breaker;
import java.util.EnumMap;
import java.util.Map;

/**
 * One piece of tabs (all strings)
 */
public class Tab {

	private Map<LineType, String> lineBuffer;
	private int maxLength;

	/**
	 * @param lineBuffer the lines of this tab
	 */
	public void setLines(Map<LineType, String> lineBuffer) {
		this.lineBuffer = new EnumMap<>(lineBuffer);
		maxLength = this.lineBuffer.values().stream().mapToInt(String::length).max().orElseThrow(RuntimeException::new);
	}
	
	/**
	 * @param type the type of line
	 * @return the contents
	 */
	public String getLine(LineType type) {
		String line = lineBuffer.get(type);
		return String.format("%-"+maxLength+"s", line);
	}

}

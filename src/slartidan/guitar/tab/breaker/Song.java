package slartidan.guitar.tab.breaker;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * The complete song
 */
public class Song {

	LineType currentType = LineType.CHORDS;
	Map<LineType, String> lineBuffer = new EnumMap<>(LineType.class);
	List<Tab> tabs = new ArrayList<>();

	/**
	 * Creates new song
	 */
	public Song() {
		try {
			Files.lines(Paths.get("input.txt")).forEachOrdered(this::nextLine);
		} catch (IOException e) {
			throw new FileUnreadableException(e);
		}
		finishTab();

		write();
	}

	private void nextLine(String line) {
		String lineChopped = line.replaceAll("\\s+$", "");
		if (lineChopped.isEmpty()) {
			finishTab();
		} else {
			String lineChoppedNoTrailingStopper = lineChopped.replaceAll("\\|$", "");
			lineBuffer.put(currentType, lineChoppedNoTrailingStopper);
			currentType = currentType.next();
		}
	}

	protected void finishTab() {
		Tab tab = new Tab();
		tab.setLines(lineBuffer);
		tabs.add(tab);
		currentType = LineType.CHORDS;
	}

	private void write() {
		for (LineType lineType : LineType.values()) {
			if (lineType == LineType.UNDEFINED)
				return;
				
			tabs.stream()
			.map(t -> t.getLine(lineType))
			.forEachOrdered(Breaker.LOG::info);
			Breaker.LOG.info("");
		}
	}
}

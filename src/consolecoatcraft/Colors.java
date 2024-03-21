package consolecoatcraft;

import java.util.HashMap;
import java.util.Map;

/**
 * The Colors class provides utility methods for working with ANSI color codes
 * in the console.
 * 
 * @author github.com/Serters
 * @author github.com/DaniloIvk
 * @version 1.1
 * @since 1.0
 */
public class Colors {
	// Maps to store ANSI escape sequences for foreground and background colors
	private static final Map<String, String> foregroundColors = new HashMap<>();
	private static final Map<String, String> backgroundColors = new HashMap<>();

	// Static initializer block to populate the color maps with ANSI escape codes
	static {
		// Populate foreground color map
		foregroundColors.put("white", "\033[37m");
		foregroundColors.put("black", "\033[30m");
		foregroundColors.put("red", "\033[31m");
		foregroundColors.put("green", "\033[32m");
		foregroundColors.put("blue", "\033[34m");
		foregroundColors.put("yellow", "\033[33m");
		foregroundColors.put("purple", "\033[35m");
		foregroundColors.put("cyan", "\033[36m");
		foregroundColors.put("none", ""); // Empty string for no color

		// Populate background color map
		backgroundColors.put("white", "\033[47m");
		backgroundColors.put("black", "\033[40m");
		backgroundColors.put("red", "\033[41m");
		backgroundColors.put("green", "\033[42m");
		backgroundColors.put("blue", "\033[44m");
		backgroundColors.put("yellow", "\033[43m");
		backgroundColors.put("purple", "\033[45m");
		backgroundColors.put("cyan", "\033[46m");
		backgroundColors.put("none", ""); // Empty string for no color
	}

	/**
	 * Retrieves the ANSI escape code for the specified foreground color.
	 *
	 * @param name The name of the foreground color.
	 * @return The ANSI escape sequence for the specified foreground color, or an
	 *         empty string if the color is not found.
	 */
	public static String getForegroundColor(String name) {
		return getColor(name, foregroundColors);
	}

	/**
	 * Retrieves the ANSI escape code for the specified background color.
	 *
	 * @param name The name of the background color.
	 * @return The ANSI escape sequence for the specified background color, or an
	 *         empty string if the color is not found.
	 */
	public static String getBackgroundColor(String name) {
		return getColor(name, backgroundColors);
	}

	/**
	 * Retrieves the ANSI escape code for the specified color from the provided
	 * color map.
	 *
	 * @param name     The name of the color.
	 * @param colorMap The map containing color names and their corresponding ANSI
	 *                 escape sequences.
	 * @return The ANSI escape code for the specified color, or an empty string if
	 *         the color is not found.
	 */
	private static String getColor(String name, Map<String, String> colorMap) {
		String color = colorMap.get(name);
		if (color == null) {
			System.err.println("Invalid color name: " + name);
			return colorMap.get("none");
		}
		return color;
	}

	/**
	 * Resets the console color to the default settings.
	 */
	public static void reset() {
		System.out.println("\033[0m");
	}
}

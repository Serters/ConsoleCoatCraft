package cc.cyberdark.utils;

import java.util.Map;
import java.util.Random;
import java.util.LinkedHashMap;

/**
 * The Colors class provides utility methods for working with ANSI color codes
 * in the console.
 * 
 * This class allows users to retrieve ANSI escape codes for both foreground and
 * background colors, as well as to display available colors in a formatted
 * manner.
 * 
 * @author github.com/Serters
 * @author github.com/DaniloIvk
 * @version 1.1
 * @since 1.0
 */
public class ColorUtils {
	// Maps to store ANSI escape sequences for foreground and background colors
	private static final Map<String, String> foregroundColors = new LinkedHashMap<>();
	private static final Map<String, String> backgroundColors = new LinkedHashMap<>();

	// Static initializer block to populate the color maps with ANSI escape codes
	static {
		foregroundColors.put("black", "\033[30m");
		foregroundColors.put("dark_gray", "\033[90m");
		foregroundColors.put("light_gray", "\033[37m");
		foregroundColors.put("white", "\u001B[38;2;255;255;255m");
		foregroundColors.put("red", "\033[31m");
		foregroundColors.put("light_red", "\033[91m");
		foregroundColors.put("orange", "\033[38;5;208m");
		foregroundColors.put("light_orange", "\033[38;5;214m");
		foregroundColors.put("yellow", "\033[33m");
		foregroundColors.put("light_yellow", "\033[93m");
		foregroundColors.put("green", "\033[32m");
		foregroundColors.put("light_green", "\033[92m");
		foregroundColors.put("cyan", "\033[36m");
		foregroundColors.put("teal", "\033[36m");
		foregroundColors.put("light_cyan", "\033[96m");
		foregroundColors.put("blue", "\033[34m");
		foregroundColors.put("light_blue", "\u001B[38;2;109;169;210m");
		foregroundColors.put("purple", "\033[35m");
		foregroundColors.put("light_magenta", "\033[95m");
		foregroundColors.put("pink", "\033[38;5;206m");
		foregroundColors.put("magenta", "\033[95m");

		backgroundColors.put("black", "\033[40m");
		backgroundColors.put("dark_gray", "\033[100m");
		backgroundColors.put("light_gray", "\033[47m");
		backgroundColors.put("white", "\u001B[48;2;255;255;255m");
		backgroundColors.put("red", "\033[41m");
		backgroundColors.put("light_red", "\033[101m");
		backgroundColors.put("orange", "\033[48;5;208m");
		backgroundColors.put("light_orange", "\033[48;5;214m");
		backgroundColors.put("yellow", "\033[43m");
		backgroundColors.put("light_yellow", "\033[103m");
		backgroundColors.put("green", "\033[42m");
		backgroundColors.put("light_green", "\033[102m");
		backgroundColors.put("cyan", "\033[46m");
		backgroundColors.put("teal", "\033[46m");
		backgroundColors.put("light_cyan", "\033[106m");
		backgroundColors.put("blue", "\033[44m");
		backgroundColors.put("light_blue", "\u001B[48;2;109;169;210m");
		backgroundColors.put("purple", "\033[45m");
		backgroundColors.put("light_magenta", "\033[105m");
		backgroundColors.put("pink", "\033[48;5;206m");
		backgroundColors.put("magenta", "\033[105m");

	}

	/**
	 * Displays the available foreground and background colors along with their
	 * corresponding ANSI escape codes.
	 * 
	 * Foreground colors are displayed first, followed by background colors.
	 * 
	 * When displaying background colors, if the current color is black, it switches
	 * the foreground color to white to ensure visibility.
	 */
	public static void displayOptions() {
		reset();
		System.out.println("Foreground colors:");
		int count = 0;
		for (String colorName : foregroundColors.keySet()) {
			System.out.print(foregroundColors.get(colorName) + " " + colorName);
			count++;
			// Add padding to align the colors
			for (int i = 0; i < 20 - colorName.length(); i++) {
				System.out.print(" ");
			}
			if (count % 3 == 0) {
				System.out.println();
			}
		}
		reset();
		System.out.println("\nBackground colors:");
		System.out.print("\033[30m");
		count = 0;
		for (String colorName : backgroundColors.keySet()) {
			if (count != 0) {
				System.out.print(backgroundColors.get(colorName) + " " + colorName);
			} else {
				reset();
				System.out.print(backgroundColors.get(colorName) + " " + colorName);
			}
			System.out.print("\033[30m");
			count++;
			// Add padding to align the colors
			for (int i = 0; i < 20 - colorName.length(); i++) {
				System.out.print(" ");
			}
			if (count % 3 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		reset();
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
	 * Generates an array of random color names.
	 * 
	 * @param numberOfColors The number of random color names to generate.
	 * @return An array of random color names.
	 */
	public static String[] generateRandom(int numerOfColors) {
		String[] colorNames = backgroundColors.keySet().toArray(new String[0]);

		// Shuffle the array
		Random random = new Random();
		for (int i = colorNames.length - 1; i > 0; i--) {
			int index = random.nextInt(i + 1);
			String temp = colorNames[index];
			colorNames[index] = colorNames[i];
			colorNames[i] = temp;
		}

		String[] randomColors = new String[numerOfColors];
		System.arraycopy(colorNames, 0, randomColors, 0, numerOfColors);

		return randomColors;
	}

	/**
	 * Imports background colors data from a specified file and updates the
	 * corresponding data structure.
	 *
	 * @param file The file containing the background colors data to be imported.
	 */
	public static void importBackgroundColors(String file) {
		Utils.importData(backgroundColors, file);
	}

	/**
	 * Imports foreground colors data from a specified file and updates the
	 * corresponding data structure.
	 *
	 * @param file The file containing the foreground colors data to be imported.
	 */
	public static void importForegroundColors(String file) {
		Utils.importData(backgroundColors, file);
	}

	/**
	 * Resets the console color to the default settings.
	 */
	public static void reset() {
		System.out.print("\033[0m");
	}

}
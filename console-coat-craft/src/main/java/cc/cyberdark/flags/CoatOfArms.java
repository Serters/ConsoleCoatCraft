package cc.cyberdark.flags;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import cc.cyberdark.interfaces.Prototype;
import cc.cyberdark.interfaces.Renderable;
import cc.cyberdark.utils.ColorUtils;
import cc.cyberdark.utils.Utils;

/**
 * The CoatOfArms class represents a coat of arms pattern.
 * It implements both the Renderable and Prototype interfaces.
 * 
 * @author github.com/Serters
 * @author github.com/DaniloIvk
 * @version 1.1
 * @since 1.0
 */
public class CoatOfArms implements Renderable, Prototype<CoatOfArms> {

	private int size;
	private String symbol;
	private String color;
	private String horizontalPosition;
	private String verticalPosition;

	/**
	 * Constructs a new CoatOfArms object with the specified size, symbol, color,
	 * horizontal and vertical position.
	 *
	 * @param size               The size of the coat of arms.
	 * @param symbol             The name of the symbol image.
	 * @param color              The color of the coat of arms.
	 * @param horizontalPosition The horizontal position of the coat of arms.
	 * @param verticalPosition   The vertical position of the coat of arms.
	 */
	public CoatOfArms(int size, String symbol, String color, String horizontalPosition, String verticalPosition) {
		this.size = size;
		this.symbol = symbol;
		this.color = ColorUtils.getForegroundColor(color);
		this.horizontalPosition = horizontalPosition;
		this.verticalPosition = verticalPosition;
	}

	/**
	 * Constructs a new CoatOfArms object by cloning an existing CoatOfArms object.
	 * This constructor creates a deep copy of the original CoatOfArms object.
	 *
	 * @param original The original CoatOfArms object to be cloned.
	 */
	public CoatOfArms(CoatOfArms original) {
		this.size = original.size; // Copy the size attribute
		this.symbol = original.symbol; // Copy the symbol attribute
		this.color = ColorUtils.getForegroundColor(original.color); // Copy the color attribute
		this.horizontalPosition = original.horizontalPosition; // Copy the horizontal position attribute
		this.verticalPosition = original.verticalPosition; // Copy the vertical position attribute
	}

	/**
	 * Constructs a new CoatOfArms object with a random symbol, color, horizontal
	 * position, and vertical position, based on predefined options.
	 *
	 * @param size The size of the coat of arms.
	 */
	public CoatOfArms(int size) {
		// Symbol options: circle, crown, dolphin, eagle, fox, goat, horse
		// Horizontal position options: left, center, right
		// Vertical position options: top, middle, bottom

		// Arrays of available options for symbols, horizontal positions, and vertical
		// positions
		String[] symbols = { "circle", "crown", "dolphin", "eagle", "fox", "goat", "horse" };
		String[] horizontalPositions = { "left", "center", "right" };
		String[] verticalPositions = { "top", "middle", "bottom" };

		// Generate random indices to select random options from the arrays
		Random random = new Random();
		int symbolIndex = random.nextInt(symbols.length);
		int horizontalIndex = random.nextInt(horizontalPositions.length);
		int verticalIndex = random.nextInt(verticalPositions.length);

		// Assign the random values to the corresponding attributes of the CoatOfArms
		// object
		this.size = size;
		this.symbol = symbols[symbolIndex];
		this.horizontalPosition = horizontalPositions[horizontalIndex];
		this.verticalPosition = verticalPositions[verticalIndex];
		// Generate a random color and assign it to the coat of arms using ColorUtils
		// class
		this.color = ColorUtils.getForegroundColor(ColorUtils.generateRandom(1)[0]);
	}

	/**
	 * Generates the coat of arms pattern as an array of strings. Each string
	 * represents a row in the pattern, with characters representing the coat of
	 * arms symbol or background.
	 *
	 * The method reads the symbol image associated with the coat of arms, resizes
	 * it to the specified size, and converts it into a pattern of characters
	 * representing the image pixels. Each pixel is represented by two characters:
	 * "██" for non-transparent pixels and " " for transparent pixels.
	 *
	 * The alpha value of each pixel in the resized image is used to determine its
	 * transparency. The ARGB (Alpha, Red, Green, Blue) value of the pixel is
	 * retrieved using the {@code getRGB} method, and the alpha value is extracted
	 * by shifting the ARGB value to the right by 24 bits and then masking it with
	 * 0xFF (255 in decimal). An alpha value of 0 indicates full transparency, while
	 * an alpha value of 255 indicates full opacity.
	 * 
	 * @return The coat of arms pattern as an array of strings, where each string
	 *         represents a row in the pattern.
	 */
	public String[] generate() {
		try {
			String[] output = new String[this.size];
			BufferedImage image = Utils.resizeBufferedImage(this.symbol, this.size);

			for (int y = 0; y < image.getHeight(); y++) {
				StringBuilder row = new StringBuilder();
				for (int x = 0; x < image.getWidth(); x++) {
					int argb = image.getRGB(x, y);
					int alpha = argb >> 24 & 0xFF;
					String s = (alpha > 0) ? "██" : "  ";
					row.append(s);
				}
				output[y] = row.toString();
			}
			return output;
		} catch (IOException e) {
			System.err.println("Error generating coat of arms: " + e.getMessage());
			return new String[0];
		}
	}

	/**
	 * Method to display the coat of arms.
	 */
	public void display() {
		String[] coa = this.generate();
		ColorUtils.reset();
		System.out.print(this.color);
		// Print each row of the flag design
		for (String row : coa) {
			System.out.println(row);
		}
		ColorUtils.reset();
		System.out.println();
	}

	/**
	 * Displays information about the coat of arms, including its symbol and size.
	 */
	@Override
	public void info() {
		System.out.println(this.symbol + " coat of arms information: \n	Size: " + this.size);
	}

	/**
	 * Creates and returns a deep copy of the current coat of arms instance.
	 *
	 * @return A new CoatOfArms object that is a copy of the current instance.
	 */
	public CoatOfArms Clone() {
		return new CoatOfArms(this);
	}

	/**
	 * Gets the color of the coat of arms.
	 *
	 * @return The color of the coat of arms.
	 */
	public String getColor() {
		return this.color;
	}

	/**
	 * Retrieves the horizontal position of the symbol on the coat of arms.
	 *
	 * @return The horizontal position of the symbol, which can be "left", "center",
	 *         or "right".
	 */
	public String getHorizontalPosition() {
		return horizontalPosition;
	}

	/**
	 * Retrieves the vertical position of the symbol on the coat of arms.
	 *
	 * @return The vertical position of the symbol, which can be "top", "middle", or
	 *         "bottom".
	 */
	public String getVerticalPosition() {
		return verticalPosition;
	}

	/**
	 * Gets the size of the coat of arms.
	 *
	 * @return The size of the coat of arms.
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * Sets the size of the coat of arms to the specified value.
	 *
	 * @param size The new size of the coat of arms.
	 */
	public void setSize(int size) {
		this.size = size;
	}

}
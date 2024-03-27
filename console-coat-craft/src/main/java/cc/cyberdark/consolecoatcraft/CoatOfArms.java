package cc.cyberdark.consolecoatcraft;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * The CoatOfArms class represents a coat of arms pattern.
 * 
 * @author github.com/Serters
 * @author github.com/DaniloIvk
 * @version 1.1
 * @since 1.0
 */
public class CoatOfArms implements Renderable, Cloneable {

	private int size; // Size of the coat of arms
	private String symbol; // name of the symbol image
	private String color; // Color of the coat of arms
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
	
	public CoatOfArms(CoatOfArms original) {
        this.size = original.size;
        this.symbol = original.symbol;
        this.color = original.color;
        this.horizontalPosition = original.horizontalPosition;
        this.verticalPosition = original.verticalPosition;
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
	 * represents a row in the pattern.
	 *
	 * @return The coat of arms pattern as an array of strings.
	 */
	public String[] generate() {
		try {
			String[] output = new String[this.size];
			BufferedImage image = Utils.resizeBufferedImage(this.symbol, this.size);

			// Iterate over each row in the image
			for (int y = 0; y < image.getHeight(); y++) {
				StringBuilder row = new StringBuilder();
				// Iterate over each pixel in the row
				for (int x = 0; x < image.getWidth(); x++) {
					int argb = image.getRGB(x, y);
					int alpha = argb >> 24 & 0xFF;
					String s = (alpha > 0) ? "██" : "  "; // Use full block character for non-transparent pixels
					row.append(s);
				}
				output[y] = row.toString();
			}
			return output;
		} catch (IOException e) {
			// If an error occurs during image processing, print an error message and return
			// an empty array
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

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public void info() {
		// TODO Auto-generated method stub
	}

	public CoatOfArms Clone() {
		return new CoatOfArms(this);
	}

}
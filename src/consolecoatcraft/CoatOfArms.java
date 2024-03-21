package consolecoatcraft;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * The CoatOfArms class represents a coat of arms pattern.
 * 
 * @author github.com/Serters
 * @author github.com/DaniloIvk
 * @version 1.1
 * @since 1.0
 */
public class CoatOfArms {

	private int size; // Size of the coat of arms
	private String symbol; // name of the symbol image
	private String color; // Color of the coat of arms

	/**
	 * Constructs a new CoatOfArms object with the specified size, symbol, and
	 * color.
	 *
	 * @param size   The size of the coat of arms.
	 * @param symbol The name of the symbol image.
	 * @param color  The color of the coat of arms.
	 */
	public CoatOfArms(int size, String symbol, String color) {
		this.size = size;
		this.symbol = symbol;
		this.color = color;
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
	 * Gets the size of the coat of arms.
	 *
	 * @return The size of the coat of arms.
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * Gets the color of the coat of arms.
	 *
	 * @return The color of the coat of arms.
	 */
	public String getColor() {
		return this.color;
	}
}

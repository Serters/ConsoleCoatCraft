package consolecoatcraft;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Utility methods for image manipulation and alignment calculations.
 * 
 * @author github.com/Serters
 * @author github.com/DaniloIvk
 * @version 1.1
 * @since 1.0
 */
public class Utils {

	/**
	 * Resizes a BufferedImage to the specified height while maintaining aspect
	 * ratio.
	 *
	 * @param name   The name of the image file without extension.
	 * @param height The desired height of the resized image.
	 * @return The resized BufferedImage.
	 * @throws IOException If an error occurs while reading the image file.
	 */
	public static BufferedImage resizeBufferedImage(String name, int height) throws IOException {
		// Construct the file path
		String filePath = "src/resources/" + name + ".png";

		// Read the image from file
		BufferedImage image = ImageIO.read(new File(filePath));

		// Scale the image while maintaining aspect ratio
		Image resultingImage = image.getScaledInstance(height * image.getWidth() / image.getHeight(), height,
				Image.SCALE_DEFAULT);

		// Create a new BufferedImage to hold the scaled image
		BufferedImage outputImage = new BufferedImage(height * image.getWidth() / image.getHeight(), height,
				BufferedImage.TYPE_INT_ARGB);

		// Draw the scaled image onto the new BufferedImage
		outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);

		return outputImage;
	}

	/**
	 * Calculates the horizontal alignment position based on the specified alignment
	 * and flag width.
	 *
	 * @param alignment The horizontal alignment ("left", "center", or "right").
	 * @param flagWidth The width of the flag.
	 * @param coaSize   The size of the coat of arms.
	 * @return The horizontal alignment position.
	 */
	public static int horizontalyAlign(String alignment, int flagWidth, int coaSize) {
		switch (alignment) {
		case "left":
			return 0;
		case "center":
			return (flagWidth - coaSize) / 2;
		case "right":
			return flagWidth - coaSize;
		default:
			return 0;
		}
	}

	/**
	 * Calculates the vertical alignment position based on the specified alignment
	 * and flag height.
	 *
	 * @param alignment  The vertical alignment ("top", "middle", or "bottom").
	 * @param flagHeight The height of the flag.
	 * @param coaSize    The size of the coat of arms.
	 * @return The vertical alignment position.
	 */
	public static int verticalyAlign(String alignment, int flagHeight, int coaSize) {
		switch (alignment) {
		case "top":
			return 0;
		case "middle":
			return (flagHeight - coaSize) / 2;
		case "bottom":
			return flagHeight - coaSize;
		default:
			return 0;
		}
	}

}

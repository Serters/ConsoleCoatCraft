package cc.cyberdark.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.awt.*;

//TODO
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
		String filePath = "src/main/resources/symbols/" + name + ".png";

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

	/**
	 * Imports data from a specified file and updates the provided map with
	 * key-value pairs. Each line in the file is expected to be in the format
	 * "key=value", where key and value are separated by "=". The method reads each
	 * line, extracts the key and value, and adds them to the map. Note: This method
	 * assumes that the file is located in the "src/main/resources/colors/"
	 * directory.
	 *
	 * @param map      The map to be updated with the imported key-value pairs.
	 * @param fileName The name of the file (excluding extension) containing the
	 *                 data to be imported. The file is expected to be located in
	 *                 the "src/main/resources/colors/" directory.
	 */
	public static void importData(Map<String, String> map, String fileName) {
		String filePath = "src/main/resources/colors/" + fileName + ".txt";
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				// Split the line by ":" to separate key and value
				String[] parts = line.split("=");
				if (parts.length == 2) {
					// Add key-value pair to the map
					map.put(parts[0], "\033" + parts[1].substring(4));
				}
			}
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		}
	}

	/**
	 * Generates an image with transparent background and centers the given text or
	 * emote in the image. The generated PNG file is saved in the
	 * "src/main/resources/symbols/" directory, overwriting any existing file.
	 *
	 * @param text     The text or emote (e.g., emoji) to render in the image.
	 * @param fileName The name of the output PNG file (e.g., "output.png").
	 */
	public static void textToSymbol(String text, String fileName) {
		String outputDir = "src/main/resources/symbols/";
		File dir = new File(outputDir);
		if (!dir.exists())
			dir.mkdirs();

		File outputFile = new File(outputDir + fileName);
		int imageSize = 512;
		int fontSize = 128;

		BufferedImage image = new BufferedImage(imageSize, imageSize, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = image.createGraphics();

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setComposite(AlphaComposite.Clear);
		g2d.fillRect(0, 0, imageSize, imageSize);
		g2d.setComposite(AlphaComposite.SrcOver);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Segoe UI Emoji", Font.BOLD, fontSize));

		FontMetrics metrics = g2d.getFontMetrics();

		int textWidth = metrics.stringWidth(text);
		int textHeight = metrics.getHeight();
		int x = (imageSize - textWidth) / 2;
		int y = (imageSize - textHeight) / 2 + metrics.getAscent() - metrics.getDescent() / 2;

		g2d.drawString(text, x, y);

		g2d.dispose();

		try {
			ImageIO.write(image, "png", outputFile);
			System.out.println("Image saved to " + outputFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

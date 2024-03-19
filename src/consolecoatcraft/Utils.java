package consolecoatcraft;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Utils {
	
	public static BufferedImage resizeBufferedImage(String name, int height) throws IOException{
		String filePath = "src/resources/" + name + ".png";
		BufferedImage image = ImageIO.read(new File(filePath));
		Image resultingImage = image.getScaledInstance(height * image.getWidth() / image.getHeight(), height, Image.SCALE_DEFAULT);
		BufferedImage outputImage = new BufferedImage(height * image.getWidth() / image.getHeight(), height, BufferedImage.TYPE_INT_ARGB);
		outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
		
		return outputImage;
	}

}

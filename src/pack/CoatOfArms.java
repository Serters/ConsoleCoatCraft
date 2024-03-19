package pack;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CoatOfArms {
	private int width;
	private int height;
	private String foregroundColor;
	private String backgroundColor;
	private String[] array;
	private static String[][] colorArray;

	public CoatOfArms() throws IOException{
		this.height = 24;
		this.foregroundColor = Colors.getForeground("white");
		this.backgroundColor = Colors.getBackground("none");
		bufferedImageToStringArray("dolphin");
	}

	public CoatOfArms(int height, String foregroundColor, String backgroundColor, String imageName) throws IOException{
		this.height = height;
		this.foregroundColor = Colors.getForeground(foregroundColor);
		this.backgroundColor = Colors.getBackground(backgroundColor);
		bufferedImageToStringArray(imageName);
	}

	private void bufferedImageToStringArray(String name) throws IOException{
		BufferedImage image = resizeBufferedImage(name, this.height);
		this.array = new String[image.getHeight()];
		colorArray = new String[image.getHeight()][image.getWidth()];
		for(int y = 0; y < image.getHeight(); y++){
			String row = "";
			for(int x = 0; x < image.getWidth(); x++){
				int pixel = image.getRGB(x, y);
				int a = pixel >> 24 & 0xFF;
				int hex = pixel & 0xFFFFFF;
				String s = "  ";
				if(!name.contains("rgb") || a == 0) colorArray[y][x] = "!!!!!!";
				else colorArray[y][x] = String.format("%06X", hex);
				if(a > 0) s = "██";
				row += s;
			}
			this.array[y] = row;
		}
		this.width = image.getWidth();
	}

	private static BufferedImage resizeBufferedImage(String name, int height) throws IOException{
		String filePath = "src/resources/" + name + ".png";

		BufferedImage image = ImageIO.read(new File(filePath));
		Image resultingImage = image.getScaledInstance(height * image.getWidth() / image.getHeight(), height, Image.SCALE_DEFAULT);
		BufferedImage outputImage = new BufferedImage(height * image.getWidth() / image.getHeight(), height, BufferedImage.TYPE_INT_ARGB);
		outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
		return outputImage;
	}

	public int getSize(){ return this.height; }

	public int getWidth(){ return this.width; }

	public String getForegroundColor(){ return this.foregroundColor; }

	public String getBackgroundColor(){ return this.backgroundColor; }

	public String[] getArray(){ return this.array; }

	public static String getCellColor(int x, int y){
		return colorArray[y][x];
	}
}
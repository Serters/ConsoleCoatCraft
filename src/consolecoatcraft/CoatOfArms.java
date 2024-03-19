package consolecoatcraft;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class CoatOfArms {
	
	private int size;
	private String symbol;
	private String color;

	public CoatOfArms(int size, String symbol, String color) {
		this.size = size;
		this.symbol = symbol;
		this.color = color;
	}

	private String[] generate() throws IOException{
		String[] output = new String[this.size];
		BufferedImage image = Utils.resizeBufferedImage(this.symbol, this.size);
		
		for(int y = 0; y < image.getHeight(); y++){
			String row = "";
			for(int x = 0; x < image.getWidth(); x++){
				int argb = image.getRGB(x, y);
				int alpha = argb >> 24 & 0xFF;
				String s = (alpha > 0) ? "██" : "  ";
				row += s;
			}
			output[y] = row;
		}
		return output;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public String getColor() {
		return this.color;
	}
	
}

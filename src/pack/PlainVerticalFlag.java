package pack;

import java.io.IOException;
import java.util.Arrays;

public class PlainVerticalFlag extends Flag {
	// DEFAULT CONSTRUCTOR
	public PlainVerticalFlag() throws IOException{
		super();
		createFlag();
	}

	// FlagBuilder CONSTRUCTOR
	public PlainVerticalFlag(int width, int height, String ... colors) throws IOException{
		super(width, height, colors);
		createFlag();
	}

	public void createFlag(){
		String pad = "  ";
		flag = new String[this.height];
		Arrays.fill(flag, "");

		String line = "";
		for(int i = 0; i < colors.length; i++) line += this.colors[Math.min(i, this.colors.length - 1)] + pad.repeat(this.width / colors.length);

		for(int row = 0; row < this.height; row++){ this.flag[row] += line; }
	}
}
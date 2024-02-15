package pack;

import java.io.IOException;
import java.util.Arrays;

public class PlainHorizontalFlag extends Flag {
	// DEFAULT CONSTRUCTOR
	public PlainHorizontalFlag() throws IOException{
		super();
		createFlag();
	}

	// FlagBuilder CONSTRUCTOR
	public PlainHorizontalFlag(int width, int height, String ... colors) throws IOException{
		super(width, height, colors);
		createFlag();
	}

	public void createFlag(){
		String pad = "  ";
		flag = new String[this.height];
		Arrays.fill(flag, "");
		int color = 0;
		String line = pad.repeat(this.width);
		for(int row = 0; row < this.height; row++){
			String rowColor = this.colors[Math.min(color, this.colors.length - 1)];
			if((row + 1) % (this.height / this.colors.length) == 0) color++;
			flag[row] += rowColor;
			flag[row] += line;
		}
	}
}
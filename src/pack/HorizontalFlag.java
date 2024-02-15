package pack;

import java.io.IOException;
import java.util.Arrays;

public class HorizontalFlag extends Flag {
	// DEFAULT CONSTRUCTOR
	public HorizontalFlag() throws IOException{
		super();
		createFlag();
	}

	// FlagBuilder CONSTRUCTOR
	public HorizontalFlag(int width, int height, int symbolSize, String symbolForegroundColor, String symbolBackgroundColor, String imageName, String verticalAlignment, String horizontalAlignment, String ... colors) throws IOException{
		super(width, height, symbolSize, symbolForegroundColor, symbolBackgroundColor, imageName, verticalAlignment, horizontalAlignment, colors);
		createFlag();
	}

	public HorizontalFlag(int width, int height, int symbolSize, String symbolForegroundColor, String symbolBackgroundColor, String imageName, double verticalAlignment, double horizontalAlignment, String ... colors) throws IOException{
		super(width, height, symbolSize, symbolForegroundColor, symbolBackgroundColor, imageName, verticalAlignment, horizontalAlignment, colors);
		createFlag();
	}

	public void createFlag(){
		String pad = "  ";
		flag = new String[this.height];
		Arrays.fill(flag, "");
		flag[0] += this.symbol.getForegroundColor();

		int left = this.horizontalAlignment;
		int right = Math.max(this.width - left - this.symbol.getWidth(), 0);
		int top = this.verticalAlignment;
		int color = 0;

		String line = pad.repeat(this.width);
		String leftPadding = pad.repeat(left);
		String rightPadding = (pad.repeat(right)).substring((leftPadding.length() + this.symbol.getWidth() * 2) % pad.length());

		for(int row = 0; row < this.height; row++){
			String rowColor = this.colors[Math.min(color, this.colors.length - 1)];
			if((row + 1) % (this.height / this.colors.length) == 0) color++;
			flag[row] += rowColor;
			if(row < top){
				flag[row] += line;
			}else if(row < this.symbol.getSize() + top){
				flag[row] += leftPadding +
					this.symbol.getBackgroundColor() +
					this.symbol.getArray()[row - top] +
					rowColor +
					rightPadding;
			}else{
				flag[row] += line;
			}
		}
	}
}

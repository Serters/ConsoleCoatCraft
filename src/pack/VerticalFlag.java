package pack;

import java.io.IOException;
import java.util.Arrays;

public class VerticalFlag extends Flag {
	// DEFAULT CONSTRUCTOR
	public VerticalFlag() throws IOException{
		super();
		createFlag();
	}

	public VerticalFlag(int width, int height, int symbolSize, String symbolForegroundColor, String symbolBackgroundColor, String imageName, String verticalAlignment, String horizontalAlignment, String ... colors) throws IOException{
		super(width, height, symbolSize, symbolForegroundColor, symbolBackgroundColor, imageName, verticalAlignment, horizontalAlignment, colors);
		createFlag();
	}

	public VerticalFlag(int width, int height, int symbolSize, String symbolForegroundColor, String symbolBackgroundColor, String imageName, double verticalAlignment, double horizontalAlignment, String ... colors) throws IOException{
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

		String line = "";
		for(int i = 0; i < colors.length; i++) line += this.colors[Math.min(i, this.colors.length - 1)] + pad.repeat(this.width / colors.length);
		String leftPadding = pad.repeat(left);
		String rightPadding = (pad.repeat(right)).substring((leftPadding.length() + this.symbol.getWidth() * 2) % pad.length());

		for(int row = 0; row < this.height; row++){
			if(row < top){
				this.flag[row] += line;
			}else if(row < this.symbol.getSize() + top){
				String s = leftPadding + this.symbol.getArray()[row - top] + rightPadding;
				for(int i = 0; i < colors.length; i++) flag[row] += this.colors[Math.min(i, this.colors.length - 1)] +
					s.substring(this.width * i * pad.length() / colors.length, this.width * (i + 1) * pad.length() / colors.length);
			}else{
				this.flag[row] += line;
			}
		}
	}
}

package consolecoatcraft;

import java.util.Arrays;

public class PlainFlag extends Flag {

	public PlainFlag(int width, int height, char direction, String... colors) {
		super(width, height, direction, colors);

	}

	@Override
	protected String[] generate() {
		String[] flag = new String[this.height];
		String line;
		String pad = "  ";
		Arrays.fill(flag, "");
		if (this.direction == 'h') {
			int color = 0;
			line = pad.repeat(this.width);
			for (int row = 0; row < this.height; row++) {
				String rowColor = this.colors[Math.min(color, this.colors.length - 1)];
				if ((row + 1) % (this.height / this.colors.length) == 0)
					color++;
				flag[row] += rowColor;
				flag[row] += line;
			}
		} else if (this.direction == 'v') {
			line = "";
			for (int i = 0; i < colors.length; i++)
				line += this.colors[Math.min(i, this.colors.length - 1)] + pad.repeat(this.width / colors.length);
			for (int row = 0; row < this.height; row++) {
				flag[row] += line;
			}
		}
		return flag;
	}

}

package cc.cyberdark.flags;

import java.util.Arrays;

public class NordicCrossFlag extends Flag {
	public NordicCrossFlag(int width, int height, String... colors) {
		super(width, height, colors);
		if (colors.length != 2 && colors.length !=3) {
			throw new IllegalArgumentException(
					"Nordic Cross Flag must a background color and cross color. Cross outline color is optional");
		}
	}

	public NordicCrossFlag(NordicCrossFlag nordicCrossFlag) {
		this.width = nordicCrossFlag.width;
		this.height = nordicCrossFlag.height;
		this.colors = new String[3];
		System.arraycopy(nordicCrossFlag.colors, 0, this.colors, 0, 3);
	}

	@Override
	public String[] generate() {
		String[] flag = new String[this.height];
		String pad = "   ";
		Arrays.fill(flag, "");

		int verticalPosition = width / 7 * 2;
		int crossWidth = height / 6;
		int outlineWidth = 1;

		for (int row = 0; row < height; row++) {
			StringBuilder line = new StringBuilder();

			for (int col = 0; col < width; col++) {

				String color = colors[0];

				int horizontalStart = (height - crossWidth) / 2 - outlineWidth;
				int horizontalEnd = (height + crossWidth) / 2 + outlineWidth;
				int verticalStart = verticalPosition - crossWidth / 2 - outlineWidth;
				int verticalEnd = verticalPosition + crossWidth / 2 + outlineWidth;

				int innerHorizontalStart = horizontalStart + outlineWidth;
				int innerHorizontalEnd = horizontalEnd - outlineWidth;
				int innerVerticalStart = verticalStart + outlineWidth;
				int innerVerticalEnd = verticalEnd - outlineWidth;

				boolean inOuterCross = (row >= horizontalStart && row < horizontalEnd)
						|| (col >= verticalStart && col < verticalEnd);

				boolean inInnerCross = (row >= innerHorizontalStart && row < innerHorizontalEnd)
						|| (col >= innerVerticalStart && col < innerVerticalEnd);

				if (inInnerCross) {
					color = colors[1];
				} else if (inOuterCross) {
					if(colors.length == 3)
						color = colors[2];
					else
						color = colors[1];
				}

				line.append(color).append(pad);
			}
			flag[row] = line.toString();
		}

		return flag;
	}

	@Override
	public Flag Clone() {
		return new NordicCrossFlag(this);
	}
}
package consolecoatcraft;

import java.util.Arrays;

/**
 * The HorizontalFlag class represents a horizontal flag with a coat of arms.
 * 
 * @author github.com/Serters
 * @author github.com/DaniloIvk
 * @version 1.1
 * @since 1.0
 */
public class HorizontalFlag extends Flag {

	/** The coat of arms to be displayed on the flag. */
	CoatOfArms coatOfArms;

	/**
	 * Constructs a new HorizontalFlag object with the specified width, height, coat
	 * of arms, and colors.
	 *
	 * @param width      The width of the flag.
	 * @param height     The height of the flag.
	 * @param coatOfArms The coat of arms to be displayed on the flag.
	 * @param colors     The colors of the flag.
	 */
	public HorizontalFlag(int width, int height, CoatOfArms coatOfArms, String... colors) {
		super(width, height, colors);
		this.coatOfArms = coatOfArms;
	}

	/**
	 * Generates the string array representing the flag with the coat of arms.
	 *
	 * @return The string array representing the flag.
	 */
	@Override
	protected String[] generate() {
		String[] flag = new String[this.height];
		Arrays.fill(flag, "");
		String[] coa = coatOfArms.generate();
		flag[0] += coatOfArms.getColor();

		// Adjust flag height to ensure that it is divisible by the number of colors
		if (this.height % this.colors.length != 0) {
			this.height = (int) (Math.round(this.height / (double) this.colors.length) * this.colors.length);
			flag = new String[this.height];
			Arrays.fill(flag, "");
		}

		int left = Utils.horizontalyAlign(coatOfArms.getHorizontalPosition(), this.width, coatOfArms.getSize());
		int right = Math.max(this.width - left - this.coatOfArms.getSize(), 0);
		int top = Utils.verticalyAlign(coatOfArms.getVerticalPosition(), this.height, coatOfArms.getSize());
		int color = 0;

		String pad = "  ";
		String line = pad.repeat(this.width);
		String leftPadding = pad.repeat(left);
		String rightPadding = (pad.repeat(right))
				.substring((leftPadding.length() + this.coatOfArms.getSize() * 2) % pad.length());

		for (int row = 0; row < this.height; row++) {
			String rowColor = this.colors[Math.min(color, this.colors.length - 1)];
			if ((row + 1) % (this.height / this.colors.length) == 0)
				color++;
			flag[row] += rowColor;
			if (row < top) {
				flag[row] += line;
			} else if (row < this.coatOfArms.getSize() + top) {
				flag[row] += leftPadding + coa[row - top] + rowColor + rightPadding;
			} else {
				flag[row] += line;
			}
		}
		return flag;
	}
}

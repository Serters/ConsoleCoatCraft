package cc.cyberdark.consolecoatcraft;

import java.util.Arrays;

/**
 * Represents a vertical flag with a coat of arms.
 * 
 * @author github.com/Serters
 * @author github.com/DaniloIvk
 * @version 1.1
 * @since 1.0
 */
public class VerticalFlag extends Flag {

	/** The coat of arms associated with the flag. */
	private CoatOfArms coatOfArms;

	/**
	 * Constructs a new VerticalFlag object with the specified width, height, coat
	 * of arms, and colors.
	 *
	 * @param width      The width of the flag.
	 * @param height     The height of the flag.
	 * @param coatOfArms The coat of arms to be displayed on the flag.
	 * @param colors     The colors of the flag.
	 */
	public VerticalFlag(int width, int height, CoatOfArms coatOfArms, String... colors) {
		super(width, height, colors);
		this.coatOfArms = coatOfArms;
	}

	@Override
	/**
	 * Generates the content of the vertical flag with the coat of arms.
	 *
	 * @return An array representing the content of the vertical flag.
	 */
	public String[] generate() {
		String[] flag = new String[this.height];
		Arrays.fill(flag, "");
		String[] coa = coatOfArms.generate();
		flag[0] += coatOfArms.getColor();

		// Adjust flag width to ensure that it is divisible by the number of colors
		if (this.width % this.colors.length != 0) {
			this.width = (int) (Math.round(this.width / (double) this.colors.length) * this.colors.length);
		}

		int left = Utils.horizontalyAlign(coatOfArms.getHorizontalPosition(), this.width, coatOfArms.getSize());
		int right = Math.max(this.width - left - this.coatOfArms.getSize(), 0);
		int top = Utils.verticalyAlign(coatOfArms.getVerticalPosition(), this.height, coatOfArms.getSize());
		;

		String pad = "  ";
		String line = "";
		for (int i = 0; i < colors.length; i++)
			line += this.colors[Math.min(i, this.colors.length - 1)] + pad.repeat(this.width / colors.length);
		String leftPadding = pad.repeat(left);
		String rightPadding = (pad.repeat(right))
				.substring((leftPadding.length() + this.coatOfArms.getSize() * 2) % pad.length());

		for (int row = 0; row < this.height; row++) {
			if (row < top) {
				flag[row] += line;
			} else if (row < this.coatOfArms.getSize() + top) {
				String s = leftPadding + coa[row - top] + rightPadding;
				for (int i = 0; i < colors.length; i++)
					flag[row] += this.colors[Math.min(i, this.colors.length - 1)]
							+ s.substring(this.width * i * pad.length() / colors.length,
									this.width * (i + 1) * pad.length() / colors.length);
			} else {
				flag[row] += line;
			}
		}
		return flag;
	}

	public void resize(int width, int height, int symbolSize) {
		super.resize(height, width);
		this.coatOfArms.setSize(symbolSize);
	}

	@Override
	public void info() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Flag Clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
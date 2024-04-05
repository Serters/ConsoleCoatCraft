package cc.cyberdark.flags;

import java.util.Arrays;

import cc.cyberdark.utils.Utils;

/**
 * The HorizontalFlag class represents a horizontal flag with a coat of arms. It
 * extends the abstract class Flag.
 * 
 * @author github.com/Serters
 * @author github.com/DaniloIvk
 * @version 1.1
 * @since 1.0
 */
public class HorizontalFlag extends Flag {

	/** The coat of arms to be displayed on the flag. */
	private CoatOfArms coatOfArms;

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
	 * Constructs a new HorizontalFlag object by copying another HorizontalFlag
	 * object.
	 * 
	 * @param horizontalFlag The HorizontalFlag object to copy.
	 */
	public HorizontalFlag(HorizontalFlag horizontalFlag) {
		this.width = horizontalFlag.width;
		this.height = horizontalFlag.height;
		this.colors = new String[horizontalFlag.colors.length];
		System.arraycopy(horizontalFlag.colors, 0, this.colors, 0, horizontalFlag.colors.length);
		this.coatOfArms = horizontalFlag.getCoatOfArms();
	}

	/**
	 * Constructs a HorizontalFlag object based on the provided VerticalFlag object.
	 * This constructor initializes the width, height, colors, and coat of arms of
	 * the HorizontalFlag object using the corresponding values from the
	 * VerticalFlag object.
	 *
	 * @param verticalFlag The VerticalFlag object from which to construct the
	 *                     HorizontalFlag.
	 */
	public HorizontalFlag(VerticalFlag verticalFlag) {
		this.width = verticalFlag.width;
		this.height = verticalFlag.height;
		this.colors = new String[verticalFlag.colors.length];
		System.arraycopy(verticalFlag.colors, 0, this.colors, 0, verticalFlag.colors.length);
		this.coatOfArms = verticalFlag.getCoatOfArms();
	}

	/**
	 * Generates the string array representing the horizontal flag with the coat of
	 * arms. This method constructs the flag design by combining the coat of arms
	 * pattern with background colors, ensuring alignment and distribution of colors
	 * across the flag's height.
	 *
	 * @return The string array representing the horizontal flag.
	 */
	@Override
	public String[] generate() {
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

		// Calculate padding to align the coat of arms
		int left = Utils.horizontalyAlign(coatOfArms.getHorizontalPosition(), this.width, coatOfArms.getSize());
		int right = Math.max(this.width - left - this.coatOfArms.getSize(), 0);
		int top = Utils.verticalyAlign(coatOfArms.getVerticalPosition(), this.height, coatOfArms.getSize());
		int color = 0;

		// Define padding and line strings for flag construction
		String pad = "  ";
		String line = pad.repeat(this.width);
		String leftPadding = pad.repeat(left);
		String rightPadding = (pad.repeat(right))
				.substring((leftPadding.length() + this.coatOfArms.getSize() * 2) % pad.length());

		// Construct each row of the flag design
		for (int row = 0; row < this.height; row++) {
			String rowColor = this.colors[Math.min(color, this.colors.length - 1)];
			if ((row + 1) % (this.height / this.colors.length) == 0)
				color++;
			// Add background color to the current row
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

	/**
	 * Resizes the flag to the specified width and height and adjusts the size of
	 * the coat of arms accordingly.
	 * 
	 * @param width      The new width of the flag.
	 * @param height     The new height of the flag.
	 * @param symbolSize The new size of the coat of arms.
	 */
	public void resize(int width, int height, int symbolSize) {
		super.resize(height, width);
		this.coatOfArms.setSize(symbolSize);
	}

	/**
	 * Creates a deep copy of the HorizontalFlag object.
	 * 
	 * @return A new HorizontalFlag object with the same attributes as this one.
	 */
	@Override
	public HorizontalFlag Clone() {
		return new HorizontalFlag(this);
	}

	/**
	 * Provides information about the HorizontalFlag, including its dimensions and
	 * the coat of arms.
	 */
	@Override
	public void info() {
		System.out.println("Horizontal Flag information: ");
		System.out.println("	Height: " + this.height + "\n	Width: " + this.width);
		coatOfArms.info();
	}

	/**
	 * Retrieves the coat of arms associated with the horizontal flag.
	 * 
	 * @return The coat of arms object.
	 */
	public CoatOfArms getCoatOfArms() {
		return coatOfArms;
	}

}
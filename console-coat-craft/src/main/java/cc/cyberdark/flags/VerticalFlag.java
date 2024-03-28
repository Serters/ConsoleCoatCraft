package cc.cyberdark.flags;

import java.util.Arrays;

import cc.cyberdark.utils.Utils;

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

	public VerticalFlag(VerticalFlag verticalFlag) {
		this.width = verticalFlag.width;
		this.height = verticalFlag.height;
		this.colors = new String[verticalFlag.colors.length];
		System.arraycopy(verticalFlag.colors, 0, this.colors, 0, verticalFlag.colors.length);
		this.coatOfArms = verticalFlag.getCoatOfArms();
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
		
		// Calculate padding for the coat of arms
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
		
		// Iterate over each row of the flag
		for (int row = 0; row < this.height; row++) {
			if (row < top) {
				flag[row] += line;
			} else if (row < this.coatOfArms.getSize() + top) {
				// Add the coat of arms to the flag with proper padding
				String s = leftPadding + coa[row - top] + rightPadding;
				for (int i = 0; i < colors.length; i++)
					flag[row] += this.colors[Math.min(i, this.colors.length - 1)]
							+ s.substring(this.width * i * pad.length() / colors.length,
									this.width * (i + 1) * pad.length() / colors.length);
			} else {
				flag[row] += line; // Add the line of colors to the flag
			}
		}
		return flag;
	}

	/**
	 * Resizes the VerticalFlag object with the specified width, height, and symbol size.
	 *
	 * @param width      The new width of the flag.
	 * @param height     The new height of the flag.
	 * @param symbolSize The new size of the coat of arms symbol.
	 */
	public void resize(int width, int height, int symbolSize) {
	    super.resize(height, width); // Call the superclass method to resize the flag
	    this.coatOfArms.setSize(symbolSize); // Resize the coat of arms symbol
	}

	/**
	 * Displays information about the VerticalFlag object.
	 * This method overrides the info() method in the superclass (Flag) to provide additional information specific to VerticalFlag.
	 * It also includes information about the associated coat of arms.
	 */
	@Override
	public void info() {
	    System.out.println("Vertical Flag information: ");
	    super.info(); // Call the info() method of the superclass to display basic flag information
	    coatOfArms.info(); // Display information about the associated coat of arms
	}

	/**
	 * Creates a deep copy of the VerticalFlag object.
	 *
	 * @return A new instance of VerticalFlag with the same attributes as the original object.
	 */
	@Override
	public VerticalFlag Clone() {
	    return new VerticalFlag(this); // Create a new VerticalFlag object using the copy constructor
	}

	/**
	 * Retrieves the coat of arms associated with the VerticalFlag object.
	 *
	 * @return The coat of arms object associated with the flag.
	 */
	public CoatOfArms getCoatOfArms() {
	    return coatOfArms;
	}


}
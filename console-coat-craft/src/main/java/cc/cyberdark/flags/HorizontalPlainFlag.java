package cc.cyberdark.flags;

import java.util.Arrays;

/**
 * The HorizontalPlainFlag class represents a horizontally-oriented plain flag
 * pattern extending the Flag class. This flag pattern arranges colors
 * horizontally, with each color occupying a stripe of equal width across the
 * flag.
 * 
 * @author github.com/Serters
 * @author github.com/DaniloIvk
 * @version 1.1
 * @since 1.0
 */
public class HorizontalPlainFlag extends Flag {

	/**
	 * Constructs a new HorizontalPlainFlag object with the specified width, height,
	 * and colors.
	 * 
	 * @param width  The width of the flag.
	 * @param height The height of the flag.
	 * @param colors The colors to be used in the flag pattern.
	 */
	public HorizontalPlainFlag(int width, int height, String... colors) {
		super(width, height, colors);
	}

	/**
	 * Constructs a HorizontalPlainFlag object by copying the attributes of another
	 * HorizontalPlainFlag object. This constructor initializes the width, height,
	 * and colors array of the new HorizontalPlainFlag object using the
	 * corresponding values from the provided HorizontalPlainFlag object.
	 *
	 * @param horizontalPlainFlag The HorizontalPlainFlag object from which to copy
	 *                            the attributes.
	 */
	public HorizontalPlainFlag(HorizontalPlainFlag horizontalPlainFlag) {
		this.width = horizontalPlainFlag.width;
		this.height = horizontalPlainFlag.height;
		this.colors = new String[horizontalPlainFlag.colors.length];
		System.arraycopy(horizontalPlainFlag.colors, 0, this.colors, 0, horizontalPlainFlag.colors.length);
	}

	/**
	 * Generates the horizontal plain flag pattern as an array of strings.
	 * 
	 * @return The horizontal plain flag pattern as an array of strings, where each
	 *         string represents a row in the flag.
	 */
	@Override
	public String[] generate() {

		String[] flag = new String[this.height];
		String line;
		String pad = "  "; // Two spaces to represent empty space
		Arrays.fill(flag, "");

		// Adjust flag height to ensure that it is divisible by the number of colors
		if (this.height % this.colors.length != 0) {
			this.height = (int) (Math.round(this.height / (double) this.colors.length) * this.colors.length);
			flag = new String[this.height];
			Arrays.fill(flag, "");
		}

		int color = 0;
		line = pad.repeat(this.width); // Construct a line of empty spaces with the specified width
		for (int row = 0; row < this.height; row++) {
			String rowColor = this.colors[Math.min(color, this.colors.length - 1)]; // Get the color for the current row
			if ((row + 1) % (this.height / this.colors.length) == 0)
				color++; // Move to the next color when necessary
			flag[row] += rowColor; // Add the color to the current row
			flag[row] += line; // Add the line of empty spaces to the current row
		}

		return flag;
	}

	/**
	 * Creates a deep copy of the HorizontalPlainFlag object.
	 *
	 * @return A new instance of HorizontalPlainFlag with the same attributes as the
	 *         original object.
	 */
	@Override
	public HorizontalPlainFlag Clone() {
		return new HorizontalPlainFlag(this);
	}

	/**
	 * Displays information about the HorizontalPlainFlag object. This method
	 * overrides the info() method in the superclass (Flag) to provide additional
	 * information specific to HorizontalPlainFlag.
	 */
	public void info() {
		System.out.println("Horizontal Plain Flag information: ");
		super.info(); // Call the info() method of the superclass to display basic flag information
	}

}
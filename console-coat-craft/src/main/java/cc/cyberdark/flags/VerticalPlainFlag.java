package cc.cyberdark.flags;

import java.util.Arrays;

/**
 * The VerticalPlainFlag class represents a vertically-oriented plain flag
 * pattern extending the Flag class. This flag pattern arranges colors
 * vertically, with each color occupying a stripe of equal width across the
 * flag.
 * 
 * @author github.com/Serters
 * @author github.com/DaniloIvk
 * @version 1.1
 * @since 1.0
 */
public class VerticalPlainFlag extends Flag {

	/**
	 * Constructs a new HorizontalPlainFlag object with the specified width, height,
	 * and colors.
	 * 
	 * @param width  The width of the flag.
	 * @param height The height of the flag.
	 * @param colors The colors to be used in the flag pattern.
	 */
	public VerticalPlainFlag(int width, int height, String... colors) {
		super(width, height, colors);
	}

	public VerticalPlainFlag(VerticalPlainFlag verticalPlainFlag) {
		this.width = verticalPlainFlag.width;
		this.height = verticalPlainFlag.height;
		this.colors = new String[verticalPlainFlag.colors.length];
		System.arraycopy(verticalPlainFlag.colors, 0, this.colors, 0, verticalPlainFlag.colors.length);
	}

	/**
	 * Generates the vertical plain flag pattern as an array of strings.
	 * 
	 * @return The vertical plain flag pattern as an array of strings, where each
	 *         string represents a row in the flag.
	 */
	@Override
	public String[] generate() {

		String[] flag = new String[this.height];
		String line;
		String pad = "  "; // Two spaces to represent empty space
		Arrays.fill(flag, "");

		// Adjust flag width to ensure that it is divisible by the number of colors
		if (this.width % this.colors.length != 0) {
			this.width = (int) (Math.round(this.width / (double) this.colors.length) * this.colors.length);
		}

		line = "";
		// Construct a single line representing all colors
		for (int i = 0; i < colors.length; i++)
			line += this.colors[Math.min(i, this.colors.length - 1)] + pad.repeat(this.width / colors.length);
		// Copy the constructed line to each row of the flag
		for (int row = 0; row < this.height; row++) {
			flag[row] += line;
		}

		return flag;
	}

	/**
	 * Displays information about the VerticalPlainFlag object.
	 * This method overrides the info() method in the superclass (Flag) to provide additional information specific to VerticalPlainFlag.
	 */
	@Override
	public void info() {
	    System.out.println("Vertical Plain Flag information: ");
	    super.info(); // Call the info() method of the superclass to display basic flag information
	}

	/**
	 * Creates a deep copy of the VerticalPlainFlag object.
	 *
	 * @return A new instance of VerticalPlainFlag with the same attributes as the original object.
	 */
	@Override
	public VerticalPlainFlag Clone() {
	    return new VerticalPlainFlag(this); // Create a new VerticalPlainFlag object using the copy constructor
	}


}
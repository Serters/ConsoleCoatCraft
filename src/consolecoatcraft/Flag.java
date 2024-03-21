package consolecoatcraft;

/**
 * Abstract class representing a flag.
 * 
 * @author github.com/Serters
 * @author github.com/DaniloIvk
 * @version 1.1
 * @since 1.0
 */
public abstract class Flag {

	// Attributes
	protected int width; // Width of the flag
	protected int height; // Height of the flag
	protected char direction; // Direction of the flag's design
	protected String[] colors; // Array of colors used in the flag

	/**
	 * Constructor to initialize a Flag object with given parameters.
	 * 
	 * @param width     Width of the flag
	 * @param height    Height of the flag
	 * @param direction Direction of the flag's design
	 * @param colors    Array of color codes to be used in the flag
	 */
	public Flag(int width, int height, char direction, String... colors) {
		this.width = width;
		this.height = height;
		this.direction = direction;

		// If no colors provided, default to black
		if (colors.length < 1) {
			this.colors = new String[] { Colors.getBackgroundColor("black") };
		} else {
			int i = 0;
			this.colors = new String[colors.length];
			// Get background color codes for provided colors
			for (String code : colors) {
				this.colors[i++] = Colors.getBackgroundColor(code);
			}
		}
	}

	/**
	 * Abstract method to generate the flag design.
	 * 
	 * @return String array representing the flag design
	 */
	protected abstract String[] generate();

	/**
	 * Method to display the flag.
	 */
	protected void display() {
		String[] flag = this.generate();
		Colors.reset();
		// Print each row of the flag design
		for (String row : flag) {
			System.out.println(row);
		}
		Colors.reset();
	}
}

package cc.cyberdark.consolecoatcraft;

/**
 * Abstract class representing a flag.
 * 
 * @author github.com/Serters
 * @author github.com/DaniloIvk
 * @version 1.1
 * @since 1.0
 */
public abstract class Flag implements Renderable, Prototype {

	// Attributes
	protected int width; // Width of the flag
	protected int height; // Height of the flag
	protected String[] colors; // Array of colors used in the flag

	/**
	 * Constructor to initialize a Flag object with given parameters.
	 * 
	 * @param width  Width of the flag
	 * @param height Height of the flag
	 * @param colors Array of color codes to be used in the flag
	 */
	public Flag(int width, int height, String... colors) {
		this.width = width;
		this.height = height;

		// If no colors provided, default to a random color
		if (colors.length < 1) {
			this.colors = new String[] { ColorUtils.getBackgroundColor(ColorUtils.generateRandom(1)[0]) };
		} else {
			int i = 0;
			this.colors = new String[colors.length];
			// Get background color codes for provided colors
			for (String code : colors) {
				this.colors[i++] = ColorUtils.getBackgroundColor(code);
			}
		}
	}
	
	public Flag() {
		this.width = 0;
		this.height = 0;
		this.colors = new String[0];
	}

	/**
	 * Abstract method to generate the flag design.
	 * 
	 * @return String array representing the flag design
	 */
	public abstract String[] generate();

	/**
	 * Method to display the flag.
	 */
	public void display() {
		String[] flag = this.generate();
		ColorUtils.reset();
		// Print each row of the flag design
		for (String row : flag) {
			System.out.println(row);
		}
		ColorUtils.reset();
		System.out.println();
	}
	
	public void resize(int height, int width) {
		this.height = height;
		this.width = width;	
	}

	public String[] getColors() {
	    String[] c = new String[this.colors.length];
	    System.arraycopy(this.colors, 0, c, 0, this.colors.length);
	    return c;
	}
}
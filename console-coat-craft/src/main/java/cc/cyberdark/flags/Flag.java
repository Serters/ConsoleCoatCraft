package cc.cyberdark.flags;

import cc.cyberdark.interfaces.Prototype;
import cc.cyberdark.interfaces.Renderable;
import cc.cyberdark.utils.ColorUtils;

/**
 * Abstract class representing a flag.
 * It implements both the Renderable and Prototype interfaces.
 * This class serves as the base for specific types of flags.
 * 
 * @author github.com/Serters
 * @author github.com/DaniloIvk
 * @version 1.1
 * @since 1.0
 */
public abstract class Flag implements Renderable, Prototype<Flag> {

    // Attributes
    protected int width; // Width of the flag
    protected int height; // Height of the flag
    protected String[] colors; // Array of color codes to be used in the flag

    /**
     * Constructor to initialize a Flag object with given parameters.
     * 
     * @param width  Width of the flag.
     * @param height Height of the flag.
     * @param colors Array of color codes to be used in the flag.
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
    
    /**
     * Default constructor initializes a Flag object with zero dimensions and no colors.
     */
    public Flag() {
        this.width = 0;
        this.height = 0;
        this.colors = new String[0];
    }

    /**
     * Abstract method to generate the flag design.
     * 
     * @return String array representing the flag design.
     */
    public abstract String[] generate();

    /**
     * Method to display the flag.
     * It prints each row of the flag design to the console.
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
    
    /**
     * Resizes the flag to the specified height and width.
     * 
     * @param height The new height of the flag.
     * @param width  The new width of the flag.
     */
    public void resize(int height, int width) {
        this.height = height;
        this.width = width;    
    }

    /**
     * Retrieves an array containing the color codes used in the flag.
     * 
     * @return An array of color codes.
     */
    public String[] getColors() {
        // Create a copy of the colors array to prevent direct modification
        String[] colors = new String[this.colors.length];
        System.arraycopy(this.colors, 0, colors, 0, this.colors.length);
        return colors;
    }
    
    /**
     * Provides information about the flag, including its height and width.
     */
    public void info() {
        System.out.println("Height: " + this.height + "\nWidth: " + this.width);
    }
}
package consolecoatcraft;

import java.util.Arrays;

/**
 * The PlainFlag class represents a plain flag pattern extending the Flag class.
 * It provides functionality to generate plain flags either horizontally or vertically.
 * 
 * @author github.com/Serters
 * @author github.com/DaniloIvk
 * @version 1.1
 * @since 1.0
 */
public class PlainFlag extends Flag {

    /**
     * Constructs a new PlainFlag object with the specified width, height,
     * direction, and colors.
     *
     * @param width     The width of the flag.
     * @param height    The height of the flag.
     * @param direction The direction of the flag ('h' for horizontal, 'v' for
     *                  vertical).
     * @param colors    The colors to be used in the flag pattern.
     */
    public PlainFlag(int width, int height, char direction, String... colors) {
        super(width, height, direction, colors);
    }

    /**
     * Generates the plain flag pattern as an array of strings.
     *
     * @return The plain flag pattern as an array of strings, where each string
     *         represents a row in the flag.
     */
    @Override
    protected String[] generate() {
        String[] flag = new String[this.height];
        String line;
        String pad = "  "; // Two spaces to represent empty space
        Arrays.fill(flag, "");

        // Horizontal flag generation
        if (this.direction == 'h') {
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
        }
        // Vertical flag generation
        else if (this.direction == 'v') {
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
        }
        return flag;
    }
}

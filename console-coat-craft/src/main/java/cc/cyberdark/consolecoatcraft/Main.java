package cc.cyberdark.consolecoatcraft;

/**
 * The main class for the Console Coat of Arms Crafting application.
 * 
 * @author github.com/Serters
 * @author github.com/DaniloIvk
 * @version 1.1
 * @since 1.0
 */
public class Main {

    /**
     * The main method of the application.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {

        // Display color options
        ColorUtils.displayOptions();

        // Generate random colors
        String[] randomColors = ColorUtils.generateRandom(4);

        // Create and display a horizontal plain flag
        HorizontalPlainFlag horizontalPlainFlag = new HorizontalPlainFlag(12, 7, "white", "red");
        horizontalPlainFlag.display();

        // Create and display a vertical plain flag with random colors
        VerticalPlainFlag verticalPlainFlag = new VerticalPlainFlag(11, 8, randomColors);
        verticalPlainFlag.display();

        // Create and display a coat of arms with specified attributes
        CoatOfArms coatOfArms = new CoatOfArms(48, "eagle", "yellow", "center", "middle");
        coatOfArms.display();

        // Create and display a random coat of arms
        CoatOfArms randomCoatOfArms = new CoatOfArms(48);
        randomCoatOfArms.display();

        // Create and display a horizontal flag with a coat of arms
        HorizontalFlag horizontalCoatedFlag = new HorizontalFlag(116, 60, coatOfArms, "red", "blue", "white");
        horizontalCoatedFlag.display();

        // Create and display a vertical flag with a random coat of arms and random colors
        VerticalFlag verticalCoatedFlag = new VerticalFlag(116, 60, randomCoatOfArms, randomColors);
        verticalCoatedFlag.display();

        // Print the length of the randomColors array
        System.out.println(randomColors.length);
    }

}
package cc.cyberdark.flags;

/**
 * The FlagsCatalogue class provides a collection of predefined flags.
 * It includes flags from various countries and regions, each represented as instances of the Flag class or its subclasses.
 * Flags are stored in the 'flagsCatalogue' array and can be accessed or displayed collectively.
 * 
 * @author github.com/Serters
 * @author github.com/DaniloIvk
 * @version 1.0
 * @since 1.0
 */
public class FlagsCatalogue {

    // Predefined flags
    static VerticalPlainFlag frenchFlag = new VerticalPlainFlag(30, 20, "blue", "white", "red");
    static CoatOfArms redCircle = new CoatOfArms(8, "circle", "red", "center", "middle");
    static VerticalFlag japaneseFlag = new VerticalFlag(30, 20, redCircle, "white");
    static VerticalFlag bengaliFlag = new VerticalFlag(30, 20, redCircle, "green");
    static HorizontalPlainFlag colombianFlag = new HorizontalPlainFlag(30, 20, "yellow", "yellow", "blue", "red");
    static HorizontalPlainFlag latvianFlag = new HorizontalPlainFlag(30, 20, "red", "red", "white", "red", "red");
    static HorizontalPlainFlag thaiFlag = new HorizontalPlainFlag(30, 20, "red", "white", "blue", "blue", "white", "red");
    static HorizontalPlainFlag botswanaFlag = new HorizontalPlainFlag(30, 20, "light_blue", "light_blue", "light_blue", "light_blue", "light_blue", "light_blue", "light_blue", "light_blue", "light_blue", "white", "black", "black", "black", "black", "white", "light_blue", "light_blue", "light_blue", "light_blue", "light_blue", "light_blue", "light_blue", "light_blue", "light_blue");
    static HorizontalPlainFlag armenianFlag = new HorizontalPlainFlag(40, 20, "red", "blue", "yellow");
    static VerticalPlainFlag irishFlag = new VerticalPlainFlag(40, 20, "green", "white", "orange");

    // Array containing all predefined flags
    static Flag[] flagsCatalogue = { frenchFlag, japaneseFlag, bengaliFlag, colombianFlag, latvianFlag, thaiFlag, botswanaFlag, armenianFlag, irishFlag };

    /**
     * Displays all flags in the flags catalogue.
     */
    public static void displayAll() {
        for (Flag flag : flagsCatalogue) {
            flag.display();
        }
    }
}


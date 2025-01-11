package cc.cyberdark.consolecoatcraft;

import cc.cyberdark.flags.CoatOfArms;
import cc.cyberdark.flags.FlagsCatalogue;
import cc.cyberdark.flags.HorizontalFlag;
import cc.cyberdark.flags.HorizontalPlainFlag;
import cc.cyberdark.flags.NordicCrossFlag;
import cc.cyberdark.flags.VerticalFlag;
import cc.cyberdark.flags.VerticalPlainFlag;
import cc.cyberdark.utils.ColorUtils;
import cc.cyberdark.utils.Utils;

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

		Utils.textToSymbol("⚔️", "test.png");
		
		// Create and display a coat of arms with specified attributes
		CoatOfArms coatOfArms = new CoatOfArms(116, "test", "yellow", "center", "middle");
		coatOfArms.display();

		// Create and display a random coat of arms
		CoatOfArms randomCoatOfArms = new CoatOfArms(48);
		randomCoatOfArms.display();

		// Create and display a horizontal flag with a coat of arms
		HorizontalFlag horizontalCoatedFlag = new HorizontalFlag(116, 60, coatOfArms, "red", "blue", "white");
		horizontalCoatedFlag.display();

		// Create and display a vertical flag with a random coat of arms and random
		// colors
		VerticalFlag verticalCoatedFlag = new VerticalFlag(116, 60, randomCoatOfArms, randomColors);
		verticalCoatedFlag.display();

		// Clone
		CoatOfArms randomCoatOfArms2 = new CoatOfArms(8);
		HorizontalFlag flagToClone = new HorizontalFlag(15, 15, randomCoatOfArms2, randomColors);
		flagToClone.display();

		HorizontalFlag clonedFlag = flagToClone.Clone();
		clonedFlag.resize(30, 30, 15);
		clonedFlag.display();
		clonedFlag.info();

		FlagsCatalogue.displayAll();

		ColorUtils.importBackgroundColors("baltic_flags_bg");
		HorizontalPlainFlag lithuniaFlag = new HorizontalPlainFlag(30, 20, "lithuania_yellow", "lithuania_green",
				"lithuania_red");
		lithuniaFlag.display();

		String hexCode = "#FFDF00";
		String colorName = "golden_yellow";
		ColorUtils.convertHexToAnsi(hexCode, colorName);

		ColorUtils.importBackgroundColors("my_colors");
		ColorUtils.displayOptions();
		
		NordicCrossFlag ncf = new NordicCrossFlag(56, 32, "white", "red", "blue");
		ncf.display();


	}

}
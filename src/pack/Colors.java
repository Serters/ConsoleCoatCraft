package pack;

import java.util.Arrays;

public class Colors {
	private static String[] names = new String[]{
		"white",
		"black",
		"red",
		"green",
		"blue",
		"yellow",
		"purple",
		"cyan",
		"none"
		// white, black, red, green, blue, yellow, purple, cyan
	};

	private static String[] foreground = {
		"\033[37m", // white
		"\033[30m", // black
		"\033[31m", // red
		"\033[32m", // green
		"\033[34m", // blue
		"\033[33m", // yellow
		"\033[35m", // purple
		"\033[36m", // cyan
		"" // none
			// \033[37m" white,"\033[30m" black,"\033[31m" red,"\033[32m" green,"\033[34m" blue,"\033[33m"
			// yellow,\033[35m purple,\033[36m cyan
	};

	private static String[] background = {
		"\033[47m", // white
		"\033[40m", // black
		"\033[41m", // red
		"\033[42m", // green
		"\033[44m", // blue
		"\033[43m", // yellow
		"\033[45m", // purple
		"\033[46m", // cyan
		"" // none
	};

	public static String getForeground(String name){
		int i = 0;
		while(i < names.length && !names[i++].equals(name));
		return foreground[--i];
	}

	public static String getBackground(String name){
		int i = 0;
		while(i < names.length && !names[i++].equals(name));
		return background[--i];
	}

	public static String getForegroundName(String code){
		int i = 0;
		while(i < foreground.length && !foreground[i++].equals(code));
		return names[--i];
	}

	public static String getBackgroundName(String code){
		int i = 0;
		while(i < background.length && !background[i++].equals(code));
		return names[--i];
	}

	public static void reset(){
		System.out.println("\033[0m");
	}

	public static String RGBForeground(int red, int green, int blue){
		return new String("\033[38;2;" + red + ";" + green + ";" + blue + "m");
	}

	public static String RGBBackground(int red, int green, int blue){
		return new String("\033[48;2;" + red + ";" + green + ";" + blue + "m");
	}

	public static String HEXForeground(int colorCode){
		int red = colorCode / 65536;
		int green = colorCode % 65536 / 256;
		int blue = colorCode % 256;
		return RGBForeground(red, green, blue);
	}

	public static String HEXBackground(int colorCode){
		int red = colorCode / 65536;
		int green = colorCode % 65536 / 256;
		int blue = colorCode % 256;
		return RGBBackground(red, green, blue);
	}

	public static String[] getFGColors(){ return Arrays.copyOf(foreground, foreground.length - 1); }

	public static String[] getBGColors(){ return Arrays.copyOf(background, background.length - 1); }
}
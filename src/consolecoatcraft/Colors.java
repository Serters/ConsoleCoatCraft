package consolecoatcraft;

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

	public static void reset(){
		System.out.println("\033[0m");
	}

}
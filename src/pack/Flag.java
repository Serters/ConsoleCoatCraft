package pack;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Flag {
	protected int width;
	protected int height;
	protected String[] colors;

	protected int symbolSize;
	protected int verticalAlignment;
	protected int horizontalAlignment;
	protected CoatOfArms symbol;
	protected String[] flag;

	// Default values
	public Flag() throws IOException{
		this.width = 32;
		this.height = 32;
		this.colors = new String[]{
			Colors.getBackground("black")
		};

		this.symbolSize = 24;
		this.symbol = new CoatOfArms();
		this.verticalAlignment = verticalAlignment("middle");
		this.horizontalAlignment = horizontalAlignment("center");
	}

	// Plain flag
	public Flag(int width, int height, String ... colors) throws IOException{
		this.width = Math.max(width, symbolSize);
		this.height = Math.max(height, symbolSize);
		if(colors.length < 1){
			this.colors = new String[]{
				Colors.getBackground("black")
			};
		}else{
			int i = 0;
			this.colors = new String[colors.length];
			for(String code : colors){ this.colors[i++] = Colors.getBackground(code); }
		}
	}

	// Flag with coat of arms (String alignment)
	public Flag(int width, int height, int symbolSize, String symbolForegroundColor, String symbolBackgroundColor, String imageName, String verticalAlignment, String horizontalAlignment, String ... colors) throws IOException{

		this.width = Math.max(width, symbolSize);
		this.height = Math.max(height, symbolSize);
		if(colors.length < 1){
			this.colors = new String[]{
				Colors.getBackground("black")
			};
		}else{
			int i = 0;
			this.colors = new String[colors.length];
			for(String code : colors){ this.colors[i++] = Colors.getBackground(code); }
		}

		this.symbolSize = symbolSize;
		this.symbol = new CoatOfArms(symbolSize, symbolForegroundColor, symbolBackgroundColor, imageName);
		this.verticalAlignment = verticalAlignment(verticalAlignment);
		this.horizontalAlignment = horizontalAlignment(horizontalAlignment);
	}

	// Flag with coat of arms (double alignment)
	public Flag(int width, int height, int symbolSize, String symbolForegroundColor, String symbolBackgroundColor, String imageName, double verticalAlignment, double horizontalAlignment, String ... colors) throws IOException{
		this.width = Math.max(width, symbolSize);
		this.height = Math.max(height, symbolSize);
		if(colors.length < 1){
			this.colors = new String[]{
				Colors.getBackground("black")
			};
		}else{
			int i = 0;
			this.colors = new String[colors.length];
			for(String code : colors){ this.colors[i++] = Colors.getBackground(code); }
		}

		this.symbolSize = symbolSize;
		this.symbol = new CoatOfArms(symbolSize, symbolForegroundColor, symbolBackgroundColor, imageName);
		this.verticalAlignment = (int) (verticalAlignment * (this.height - this.symbol.getSize()));
		this.horizontalAlignment = (int) (horizontalAlignment * (this.width - this.symbol.getWidth()));
	}

	public void print(){
		Colors.reset();
		for(String row : this.flag){ System.out.println(row); }
		Colors.reset();
	}

	private int verticalAlignment(String alignment){
		switch(alignment){
			case "top":
				return 0;
			case "middle":
				return (this.height - this.symbol.getSize()) / 2;
			case "bottom":
				return this.height - this.symbol.getSize();
			default:
				return 0;
		}
	}

	private int horizontalAlignment(String alignment){
		switch(alignment){
			case "left":
				return 0;
			case "center":
				return (this.width - this.symbol.getWidth()) / 2;
			case "right":
				return this.width - this.symbol.getWidth();
			default:
				return 0;
		}
	}

	abstract void createFlag();

	public String getHTML(){
		String html = """
		<!DOCTYPE html>
		<html lang="rs">
			<head>
				<meta charset="UTF-8">
				<title>Home</title>
				<style>
					body{
						background-color: #333;
					}
					div,span{
						font-family:"Cascadia Mono";
						font-size: 5px;
						white-space: pre;
						/* fontColor */
					}
				</style>
			</head>
			<body>
		""";

		int r = 0;
		for(String row : flag) html += "\t\t" + convertColorTags(row, r++) + "\n";

		html += """
			</body>
		</html>
		""";

		for(String code : Colors.getFGColors()){
			if(html.contains(code)){
				html = html.replace(code, "");
				html = html.replace("/* fontColor */", "color: " + Colors.getForegroundName(code) + ";");
			}
		}

		return html;
	}

	private String convertColorTags(String text, int row){
		String output = text;
		if(text.contains("██")){
			int offset = (countBackgrounds(text) - 2) * this.colors[0].length();
			int left = this.horizontalAlignment * 2 + this.colors[0].length();
			int right = left + this.symbol.getWidth() * 2 + offset;
			int col = 0;
			String[] subs = symbol.getArray()[row - this.verticalAlignment].split("(?<=\\G.{2})");
			String replacement = "";
			for(String sub : subs){
				String color = CoatOfArms.getCellColor(col++, row - this.verticalAlignment);
				if(!color.equals("!!!!!!")) replacement += "<span style=\"background-color: #" + color + ";\">  </span>";
				else if(sub.equals("██")) replacement += "<span style=\"background-color: " +
					Colors.getForegroundName(this.symbol.getForegroundColor()) +
					";\">  </span>";
				else replacement += "<span style=\"background-color: " +
					Colors.getBackgroundName(findLastBackground(text, left + col * 2 - 2)) +
					";\">  </span>";
			}
			if(findLastBackground(text, right + 1) != null) output = text.substring(0, left) + replacement +
				"<span style=\"background-color: " +
				Colors.getBackgroundName(findLastBackground(text, left + col * 2 - 2)) +
				";\">" +
				text.substring(right, text.length()) +
				"</span>";
			else output = text.substring(0, left) + replacement + text.substring(right, text.length());
		}

		for(String code : Colors.getBGColors()){
			if(output.contains(code)){
				String replacement = "<span style=\"background-color: " + Colors.getBackgroundName(code) + ";\">";
				output = output.replace(code, replacement);
			}
		}

		return "<div>" + output + "</div>";
	}

	public String findLastBackground(String inputString, int index){
		String closestColor = null;
		int closestIndex = -1;
		for(String color : Colors.getBGColors()){
			if(inputString.contains(color)){
				int colorIndex = inputString.lastIndexOf(color, index);
				if(colorIndex != -1 && (closestIndex == -1 || colorIndex > closestIndex)){
					closestIndex = colorIndex;
					closestColor = color;
				}
			}
		}
		return closestColor;
	}

	public static int countBackgrounds(String input){
		int count = 0;
		for(String color : Colors.getBGColors()){
			int index = input.indexOf(color);
			while(index != -1){
				count++;
				index = input.indexOf(color, index + 1);
			}
		}
		return count;
	}
}
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
}
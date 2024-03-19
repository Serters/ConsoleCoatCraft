package consolecoatcraft;

public abstract class Flag {

	protected int width;
	protected int height;
	protected char direction;
	protected String[] colors;

	public Flag(int width, int height, char direction, String... colors) {
		this.width = width;
		this.height = height;
		this.direction = direction;
		
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

	protected abstract String[] generate();

	protected void display() {
		String[] flag = this.generate();
		Colors.reset();
		for (String element : flag) {
			System.out.println(element);
		}
		Colors.reset();
	}

}

package consolecoatcraft;

public class Test {

	public static void main(String[] args) {

		PlainFlag verticalPlainFlag = new PlainFlag(11, 8, 'v', "green", "yellow", "green");
		verticalPlainFlag.display();

		PlainFlag horizontalPlainFlag = new PlainFlag(12, 7, 'h', "purple", "yellow", "purple", "yellow");
		horizontalPlainFlag.display();

	}

}

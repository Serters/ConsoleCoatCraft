package pack;

import java.io.IOException;
import java.util.Scanner;

public class FlagBuilder {

	private int width = 0;
	private int height = 0;

	private int symbolSize = 0;
	private String symbolForegroundColor = "none";
	private String symbolBackgroundColor = "none";
	private String imageName = "none";
	private String verticalAlignment = "none";
	private String horizontalAlignment = "none";

	private String[] colors;

	private String direction = "none";
	private String plainOrCOA = "none";

	Scanner scan = new Scanner(System.in);

	public FlagBuilder(){
		FlagType(scan);
	}

	public void FlagType(Scanner scan){

		System.out.print("Do you want a horizontal or a vertical flag? ");
		this.direction = scan.nextLine();
		System.out.print("Do you want a coat of arms on your flag? ");
		this.plainOrCOA = scan.nextLine();

	}

	public void plainFlagBuilder(Scanner scan){
		// Basic
		System.out.print("Please input flag width: ");
		this.width = scan.nextInt();

		System.out.print("Please input flag height: ");
		this.height = scan.nextInt();
		// Colors
		System.out.print("\nPlease input number of colors: ");
		int numberOfColors = scan.nextInt();
		String temp = scan.nextLine();
		this.colors = new String[numberOfColors];
		System.out.println("Options: \033[37m white, \033[30m black,\033[31m red, \033[32m green,\033[34m blue,\033[33m yellow,\033[35m purple,\033[36m cyan\033[0m.");
		for(int i = 0; i < numberOfColors; i++){
			System.out.print("Please input " + (i + 1) + ". color: ");
			this.colors[i] = scan.nextLine();

		}

	}

	public void coaBuilder(Scanner scan){

		// Coat of Arms
		System.out.print("\nPlease input coat of arms size: ");
		this.symbolSize = scan.nextInt();
		String temp = scan.nextLine();

		System.out.print("Please input coat of arms symbor color: ");
		this.symbolForegroundColor = scan.nextLine();

		System.out.print("Please input coat of arms background color: ");
		this.symbolBackgroundColor = scan.nextLine();

		System.out.print("Please input coat of arms symbol: ");
		this.imageName = scan.nextLine();
		// Alignment
		System.out.print("\nPlease input vertical alignment of the coat of arms: ");
		this.verticalAlignment = scan.nextLine();

		System.out.print("Please input horizontal alignment of the coat of arms: ");
		this.horizontalAlignment = scan.nextLine();

	}

	public Flag flagBuilder() throws IOException{

		Flag flag = null;
		// NON PLAIN HORIZONTAL / VERTICAL
		if(this.plainOrCOA.equals("No")){
			plainFlagBuilder(scan);

			if(this.direction.equals("Horizontal")){
				flag = new PlainHorizontalFlag(width, height, colors);

			}else if(this.direction.equals("Vertical")){ flag = new PlainVerticalFlag(width, height, colors); }
		}
		// PLAIN HORIZONTAL / VERTICAL
		if(this.plainOrCOA.equals("Yes")){

			plainFlagBuilder(scan);
			coaBuilder(scan);

			if(this.direction.equals("Horizontal")){
				flag = new HorizontalFlag(width, height, symbolSize, symbolForegroundColor, symbolBackgroundColor, imageName, verticalAlignment, horizontalAlignment, colors);

			}else if(this.direction.equals("Vertical")){
				flag = new VerticalFlag(width, height, symbolSize, symbolForegroundColor, symbolBackgroundColor, imageName, verticalAlignment, horizontalAlignment, colors);
			}
		}

		return flag;

	}

}
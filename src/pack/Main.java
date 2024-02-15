package pack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class Main {
	public static void main(String[] Args) throws IOException{
		Flag flag = null;
		if(Args.length >= 4){
			String[] colors;
			if(Integer.parseInt(Args[0]) < 2){
				int c = 0;
				colors = new String[Args.length - 9];
				while(c < colors.length) colors[c] = Args[c++ + 9];
			}else{
				int c = 0;
				colors = new String[Args.length - 3];
				while(c < colors.length) colors[c] = Args[c++ + 3];
			}

			switch(Integer.parseInt(Args[0])){
				case 0:
					flag = new HorizontalFlag(Integer.parseInt(Args[1]), Integer.parseInt(Args[2]), Integer.parseInt(Args[3]), Args[4], Args[5], Args[6], Double.valueOf(Args[7]), Double.valueOf(Args[8]), colors);
				break;
				case 1:
					flag = new VerticalFlag(Integer.parseInt(Args[1]), Integer.parseInt(Args[2]), Integer.parseInt(Args[3]), Args[4], Args[5], Args[6], Double.valueOf(Args[7]), Double.valueOf(Args[8]), colors);
				break;
				case 2:
					flag = new PlainHorizontalFlag(Integer.parseInt(Args[1]), Integer.parseInt(Args[2]), colors);
				break;
				case 3:
					flag = new PlainVerticalFlag(Integer.parseInt(Args[1]), Integer.parseInt(Args[2]), colors);
				break;
			}
		}else flag = new HorizontalFlag(90, 60, 45, "yellow", "none", "eagle", 20. / 52., 21. / 56., "red", "blue", "white");
		flag.print();
	}
}
package consolecoatcraft;

import java.io.File;

public class Test {

	public static void main(String[] args) {

		String filePath = "src/resources/horse.png";

		// Create a File object
		File file = new File(filePath);

		// Check if the file exists
		if (file.exists() && file.isFile()) {
			// Get the size of the file in bytes
			long fileSizeInBytes = file.length();

			// Convert bytes to kilobytes (1 kilobyte = 1024 bytes)
			double fileSizeInKB = fileSizeInBytes / 1024.0;

			// Print the size of the file
			System.out.println("Size of cat.png: " + fileSizeInKB + " KB");
		} else {
			System.out.println("File not found!");
		}
	}

}

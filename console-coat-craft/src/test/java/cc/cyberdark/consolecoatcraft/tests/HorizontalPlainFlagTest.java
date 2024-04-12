package cc.cyberdark.consolecoatcraft.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import cc.cyberdark.flags.HorizontalPlainFlag;

public class HorizontalPlainFlagTest {

	/**
	 * Test to ensure that the generate() method of HorizontalFlag returns a
	 * non-null result.
	 * 
	 * This test creates a new instance of HorizontalFlag with specific parameters
	 * and then calls the generate() method. It verifies that the result is not
	 * null, indicating that the generation process was successful.
	 */
	@Test
	public void testGenerateReturnsNotNull() {
		// Arrange: Create an instance of HorizontalPlainFlag with specific parameters
		HorizontalPlainFlag horizontalPlainFlag = new HorizontalPlainFlag(20, 10, "red", "white", "blue");

		// Act: Call the generate() method
		String[] result = horizontalPlainFlag.generate();

		// Assert: Verify that the result is not null
		assertNotNull(result);
	}

	/**
	 * Test to ensure that the length of the result array generated by
	 * HorizontalPlainFlag is as expected.
	 * 
	 * This test creates a new instance of HorizontalPlainFlag with
	 * specific parameters and then calls the generate() method. It verifies that
	 * the length of the result array is as expected.
	 */
	@Test
	public void testGenerateResultLengthIsExpected() {
		// Arrange: Create an instance of HorizontalPlainFlag with specific parameters
		HorizontalPlainFlag horizontalPlainFlag = new HorizontalPlainFlag(64, 24, "red", "white", "blue");

		// Act: Call the generate() method
		String[] result = horizontalPlainFlag.generate();

		// Assert: Verify that the length of the result array is as expected
		assertEquals(24, result.length);
	}
}
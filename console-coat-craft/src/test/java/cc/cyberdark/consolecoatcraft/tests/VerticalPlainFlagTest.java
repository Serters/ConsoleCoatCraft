package cc.cyberdark.consolecoatcraft.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import cc.cyberdark.flags.VerticalPlainFlag;

public class VerticalPlainFlagTest {

	/**
	 * Test to ensure that the generate() method of HorizontalFlag returns a
	 * non-null result.
	 * 
	 * This test creates a new instance of VerticalPlainFlag with specific parameters
	 * and then calls the generate() method. It verifies that the result is not
	 * null, indicating that the generation process was successful.
	 */
	@Test
	public void testGenerateReturnsNotNull() {
		// Arrange: Create an instance of VerticalPlainFlag with specific parameters
		VerticalPlainFlag verticalPlainFlag = new VerticalPlainFlag(20, 10, "red", "white", "blue");

		// Act: Call the generate() method
		String[] result = verticalPlainFlag.generate();

		// Assert: Verify that the result is not null
		assertNotNull(result);
	}

	/**
	 * Test to ensure that the length of the result array generated by
	 * VerticalPlainFlag is as expected.
	 * 
	 * This test creates a new instance of VerticalPlainFlag with
	 * specific parameters and then calls the generate() method. It verifies that
	 * the length of the result array is as expected.
	 */
	@Test
	public void testGenerateResultLengthIsExpected() {
		// Arrange: Create an instance of VerticalPlainFlag with specific parameters
		VerticalPlainFlag verticalPlainFlag = new VerticalPlainFlag(64, 24, "red", "white", "blue");

		// Act: Call the generate() method
		String[] result = verticalPlainFlag.generate();

		// Assert: Verify that the length of the result array is as expected
		assertEquals(24, result.length);
	}
}
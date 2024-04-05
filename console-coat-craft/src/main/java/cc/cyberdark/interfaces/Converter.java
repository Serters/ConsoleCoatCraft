package cc.cyberdark.interfaces;

/**
 * The Converter interface defines methods for converting between horizontal and
 * vertical flag representations.
 * 
 * @author github.com/Serters
 * @author github.com/DaniloIvk
 * @version 1.1
 * @since 1.0
 * 
 * @param <H> The type representing a horizontal flag.
 * @param <V> The type representing a vertical flag.
 */
public interface Converter<H, V> {

	/**
	 * Converts a vertical flag representation to a horizontal flag representation.
	 *
	 * @param verticalFlag The vertical flag to be converted.
	 * @return A horizontal flag representation.
	 */
	public H convertToHorizontal(V verticalFlag);

	/**
	 * Converts a horizontal flag representation to a vertical flag representation.
	 *
	 * @param horizontalFlag The horizontal flag to be converted.
	 * @return A vertical flag representation.
	 */
	public V convertToVertical(H horizontalFlag);

}

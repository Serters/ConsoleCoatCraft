package cc.cyberdark.flags;

import cc.cyberdark.interfaces.Converter;

/**
 * The FlagConverter class implements the Converter interface to convert between
 * HorizontalFlag and VerticalFlag objects. It provides methods to convert a
 * VerticalFlag object to a HorizontalFlag object, and vice versa.
 * 
 * @author github.com/Serters
 * @author github.com/DaniloIvk
 * @version 1.1
 * @since 1.0
 */
public class FlagConverter implements Converter<HorizontalFlag, VerticalFlag> {

	/**
	 * Converts a VerticalFlag object to a HorizontalFlag object.
	 *
	 * @param verticalFlag The VerticalFlag object to be converted.
	 * @return A new HorizontalFlag object converted from the provided VerticalFlag.
	 */
	@Override
	public HorizontalFlag convertToHorizontal(VerticalFlag verticalFlag) {
		return new HorizontalFlag(verticalFlag);
	}

	/**
	 * Converts a HorizontalFlag object to a VerticalFlag object.
	 *
	 * @param horizontalFlag The HorizontalFlag object to be converted.
	 * @return A new VerticalFlag object converted from the provided HorizontalFlag.
	 */
	@Override
	public VerticalFlag convertToVertical(HorizontalFlag horizontalFlag) {
		return new VerticalFlag(horizontalFlag);
	}

}

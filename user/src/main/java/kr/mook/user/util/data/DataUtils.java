package kr.mook.user.util.data;

/**
 * DataUtils changes Object type data into primitive type data or reference type data.<br/>
 * Additionally, if the value is Null, the default value is returned according to the data in the return type.
 * 
 * @since 2024.03.06
 * @author In-mook, Jeong
 * @version 0.0.1
 */
public class DataUtils {
	
	/**
	 * This method changes object type data to boolean type data.<br/>
	 * If the value of object type is Null, false is returned.
	 * 
	 * @param object : Data before changes
	 * @return <i>(Primitive type)</i> Data converted to boolean type or false.
	 * @since 2024.03.06
	 * @author In-mook, Jeong
	 */
	public static boolean objectToBoolean(final Object object) {
		return objectToBoolean(object, false);
	}
	
	/**
	 * This method changes object type data to boolean type data.<br/>
	 * If the value of the object type is Null, the value entered by the user is returned.
	 * 
	 * @param object : Data before changes
	 * @param defaultValue : Data returned when Null
	 * @return <i>(Primitive type)</i> Data converted to boolean type or defaultValue.
	 * @since 2024.03.06
	 * @author In-mook, Jeong
	 */
	public static boolean objectToBoolean(final Object object, final boolean defaultValue) {
		if(object == null) return defaultValue;
		return (boolean) object;
	}
	
	/**
	 * This method changes object type data to int type data.<br/>
	 * If the value of object type is Null, 0 is returned.
	 * 
	 * @param object : Data before changes
	 * @return <i>(Primitive type)</i> Data converted to int type or zero.
	 * @since 2024.03.06
	 * @author In-mook, Jeong
	 */
	public static int objectToInt(final Object object) {
		return objectToInt(object, 0);
	}
	
	/**
	 * This method changes object type data to int type data.<br/>
	 * If the value of the object type is Null, the value entered by the user is returned.
	 * 
	 * @param object : Data before changes
	 * @param defaultValue : Data returned when Null
	 * @return <i>(Primitive type)</i> Data converted to int type or defaultValue.
	 * @since 2024.03.06
	 * @author In-mook, Jeong
	 */
	public static int objectToInt(final Object object, final int defaultValue) {
		if(object == null) return defaultValue;
		return (int) object;
	}
}

import java.util.HashMap;
import java.util.Map;

/*
 * This utility class converts a String to integer by taking
 * String as an input.
 * 
 * */
public class StringToInt {
	
	
	/**
	 * This function takes String as an input and prints out an integer, this method will throw a
	 * NullPointerException in case of input is null.
	 * @param number
	 */
	public static void printInt(String number) {
		if (number == null)
			throw new NullPointerException("Cannot convert null to integer"); //$NON-NLS-1$
		try {
			System.out.println(Integer.parseInt(number));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		Map<String,String> map = new HashMap<String,String>();
		map.size();

	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		StringToInt.printInt(null);
		StringToInt.printInt("abcd"); //$NON-NLS-1$
		StringToInt.printInt("123456789"); //$NON-NLS-1$
		StringToInt.printInt("1"); //$NON-NLS-1$
		StringToInt.printInt("1234"); //$NON-NLS-1$
		StringToInt.printInt("-1234"); //$NON-NLS-1$
		
	}

}
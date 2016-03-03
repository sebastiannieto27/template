package co.com.core.commons;

public class ValidationUtil {

	public static String cleanString(String input) {
		String output = null;
		
		output = input.replaceAll("['\"\\\\]", "");
		output = output.trim();
		return output;
	}
}

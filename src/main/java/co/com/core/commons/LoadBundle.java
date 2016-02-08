package co.com.core.commons;

import java.util.Locale;
import java.util.ResourceBundle;

public class LoadBundle {

	private static Locale currentLocale = Locale.getDefault();
	private static ResourceBundle bundle = ResourceBundle.getBundle("label", currentLocale);
	
	
	public static String geProperty(String key) {
		return bundle.getString(key);
	}
	
}

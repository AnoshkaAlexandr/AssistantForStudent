package by.itstep.bobruisk.nosha.runner.initSetting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

/**
 * @author nosha work whit setting properties
 */
public class SetSetting {

	public static Properties property = new Properties();

	/**
	 * initialize start setting
	 */
	public void initDefaultSettings() {

		File fileDefaultSetting = new File("settings" + File.separator + "default.properties");
		try (FileInputStream inputStream = new FileInputStream(fileDefaultSetting)) {
			property.load(inputStream);
		} catch (IOException e) {
			System.out.println("File not found load default prop");
		}
		Locale currentLocale = Locale.getDefault();
		if (getProperty("LANG").isEmpty()) {
			Locale.setDefault(new Locale(currentLocale.getLanguage()));

		} else {
			Locale.setDefault(new Locale(getProperty("LANG")));
		}
	}

	/**
	 * @param key
	 * @param value
	 * @param file
	 *            write property in file properties
	 */
	public void writeProperty(String key, String value, String file) {
		File fileDefaultSetting = new File("settings" + File.separator + file + ".properties");
		try (FileInputStream inputStream = new FileInputStream(fileDefaultSetting)) {
			property.load(inputStream);
		} catch (IOException e) {
			System.out.println("File not found write input");
		}

		property.setProperty(key, value);

		try (FileOutputStream outputStream = new FileOutputStream(fileDefaultSetting)) {
			property.store(outputStream, null);
		} catch (IOException e) {
			System.out.println("File not found write output");
		}
	}

	/**
	 * @param key
	 * @return string from file properties in to key
	 */
	public String getProperty(String key) {
		File fileDefaultSetting = new File(
				"settings" + File.separator + property.getProperty("PROPERTY") + ".properties");
		try (FileInputStream inputStream = new FileInputStream(fileDefaultSetting)) {
			property.load(inputStream);
		} catch (IOException e) {
			System.out.println("File not found read");
		}

		return property.getProperty(key);
	}

}

package by.itstep.bobruisk.nosha.controler.translate;

@SuppressWarnings("serial")
public class YandexAPIexception extends Exception {
	public static String code;
	

	public YandexAPIexception(String code2) {
		YandexAPIexception.code = code2;
	}

}

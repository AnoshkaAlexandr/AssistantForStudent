package by.itstep.bobruisk.nosha.controler.translate;

/**
 * @author nosha translate string from Russian
 */
public interface Translatable {

	/**
	 * @param string
	 *            to translate
	 * @param lang
	 *            to translate
	 * @return string translate to language from variable lang
	 * @throws TranslatableException 
	 */
	public String getString(String string, String lang) throws TranslatableException;

}

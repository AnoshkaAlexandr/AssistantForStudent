package by.itstep.bobruisk.nosha.controler.transform;

/**
 * @author nosha
 *
 *         transform string to syntaxes some languages
 */
public interface Transformable {

	/**
	 * @param string
	 * @return string like constant
	 */
	public String toConstant(String string);

	/**
	 * @param string
	 * @return string like class name
	 */
	public String toClassName(String string);

	/**
	 * @param string
	 * @return string like variables
	 */
	public String toVariable(String string);

	/**
	 * @param string
	 * @return string like comments
	 */
	public String toComment(String string);
}

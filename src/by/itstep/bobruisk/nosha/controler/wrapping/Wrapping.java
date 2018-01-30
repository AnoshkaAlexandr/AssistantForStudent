package by.itstep.bobruisk.nosha.controler.wrapping;

/**
 * @author nosha wrap variables in some characters
 */
public interface Wrapping {

	/**
	 * @param string
	 * @return string wrapping for constant
	 */
	public String wrapConstant(String string);

	/**
	 * @param string
	 * @return string wrapping for class name
	 */
	public String wrapClassName(String string);

	/**
	 * @param string
	 * @return string wpapping like variable
	 */
	public String wrapVariable(String string);

	/**
	 * @param string
	 * @return string wrapping like comment
	 */
	public String wrapComment(String string);
}

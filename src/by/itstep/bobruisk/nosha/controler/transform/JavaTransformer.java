package by.itstep.bobruisk.nosha.controler.transform;

public class JavaTransformer implements Transformable {

	/**
	 * @param string
	 *            line to create a constant
	 * @return string in the form of constants for JAVA
	 */
	@Override
	public String toConstant(String string) {
		return string.replaceAll(" ", "_").toUpperCase();
	}

	/**
	 * @param string
	 *            line to create a class name
	 * @return string in the form of class name for JAVA
	 */
	@Override
	public String toClassName(String string) {
		return firstWordInUpperCase(allWordInUppreCase(string));
	}

	/**
	 * @param string
	 *            string line to create a variable
	 * @return string in the form of variable for JAVA
	 */
	@Override
	public String toVariable(String string) {
		return firstWorldInLowerCase(allWordInUppreCase(string));
	}

	/**
	 * @param string
	 *            string line to create a comment
	 * @return string in the form of comment for JAVA
	 */
	@Override
	public String toComment(String string) {
		return firstWordInUpperCase(string);
	}

	/**
	 * @param string
	 * @return first word in upper case
	 */
	private String firstWordInUpperCase(String string) {
		StringBuilder sb = new StringBuilder(string);
		return sb.substring(0, 1).toUpperCase() + sb.substring(1);

	}

	/**
	 * @param string
	 * @return all word in upper case
	 */
	private String allWordInUppreCase(String string) {
		StringBuilder stringBuilder = new StringBuilder();
		for (String word : string.split(" ")) {

			stringBuilder.append(word.substring(0, 1).toUpperCase() + word.substring(1));
		}
		return stringBuilder.toString();

	}

	/**
	 * @param string
	 * @return first word in lower case
	 */
	private String firstWorldInLowerCase(String string) {
		StringBuffer sb = new StringBuffer(string);
		return sb.substring(0, 1).toLowerCase() + sb.substring(1);
	}

}

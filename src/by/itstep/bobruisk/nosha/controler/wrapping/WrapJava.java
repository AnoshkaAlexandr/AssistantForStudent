package by.itstep.bobruisk.nosha.controler.wrapping;

import by.itstep.bobruisk.nosha.runner.initSetting.SetSetting;

/**
 * @author nosha Wrapind variables for java
 */
public class WrapJava implements Wrapping {

	static SetSetting setSetting = new SetSetting();

	public static String constantPrefix = setSetting.getProperty("CONSTANT_PREFIX");
	public static String constantPostfix = setSetting.getProperty("CONSTANT_POSTFIX");

	public static String classNamePrefix = setSetting.getProperty("CLASS_NAME_PREFIX");
	public static String classNamePostfix = setSetting.getProperty("CLASS_NAME_POSTFIX");

	public static String variablePrefix = setSetting.getProperty("CLASS_NAME_PREFIX");
	public static String variablePostfix = setSetting.getProperty("CLASS_NAME_POSTFIX");

	public static String commentPrefix = setSetting.getProperty("COMMENT_PREFIX");
	public static String commentPostfix = setSetting.getProperty("COMMENT_POSTFIX");

	@Override
	public String wrapConstant(String string) {
		return new StringBuilder().append(constantPrefix).append(string).append(constantPostfix).toString();
	}

	@Override
	public String wrapClassName(String string) {

		return new StringBuilder().append(classNamePrefix).append(string).append(classNamePostfix).toString();
	}

	@Override
	public String wrapVariable(String string) {
		return new StringBuilder().append(variablePrefix).append(string).append(variablePostfix).toString();
	}

	@Override
	public String wrapComment(String string) {
		return new StringBuilder().append(commentPrefix).append(string).append(commentPostfix).toString();
	}

}

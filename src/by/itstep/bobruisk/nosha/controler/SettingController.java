package by.itstep.bobruisk.nosha.controler;

import by.itstep.bobruisk.nosha.controler.wrapping.WrapJava;
import by.itstep.bobruisk.nosha.runner.Main;
import by.itstep.bobruisk.nosha.runner.initSetting.SetSetting;
import by.itstep.bobruisk.nosha.view.Menu;

public class SettingController {

	private static final String NOTHING = "";
	private String propertyName = "default";

	Menu menu = Main.menu;
	SetSetting setSetting = new SetSetting();

	/**
	 * initialize listeners from wrap setting window
	 */
	public void initListenerSetting() {
		menu.getSaveButton().addActionListener(klickEvent -> saveButtonRunner());
		menu.getClassNameCheckBox().addActionListener(klickEvent -> classNameCheckBoxRunner());

		menu.getCommentsCheckBox().addActionListener(klickEvent -> commentsCheckBoxRunner());
		menu.getConstantCheckBox().addActionListener(klickEvent -> constantCheckBoxRunner());
		menu.getVariableCheckBox().addActionListener(klickEvent -> variableCheckBoxRunner());

	}

	/**
	 * realize save button from wrap setting getting value from text fields prefix
	 * and postfix and write to properties
	 */
	private void saveButtonRunner() {

		setSetting.writeProperty("CLASS_NAME_CHECKBOX", Boolean.toString(menu.getClassNameCheckBox().isSelected()),
				propertyName);
		setSetting.writeProperty("CLASS_NAME_PREFIX", menu.getClassNamePrefixField().getText(), propertyName);
		setSetting.writeProperty("CLASS_NAME_POSTFIX", menu.getClassNamePostfixField().getText(), propertyName);

		setSetting.writeProperty("COMMENT_CHECKBOX", Boolean.toString(menu.getCommentsCheckBox().isSelected()),
				propertyName);
		setSetting.writeProperty("COMMENT_PREFIX", menu.getCommentsPrefixField().getText(), propertyName);
		setSetting.writeProperty("COMMENT_POSTFIX", menu.getCommentsPostfixField().getText(), propertyName);

		setSetting.writeProperty("CONSTANT_CHECKBOX", Boolean.toString(menu.getConstantCheckBox().isSelected()),
				propertyName);
		setSetting.writeProperty("CONSTANT_PREFIX", menu.getConstantPrefixField().getText(), propertyName);
		setSetting.writeProperty("CONSTANT_POSTFIX", menu.getConstantPostfixField().getText(), propertyName);

		setSetting.writeProperty("VARIABLE_CHECKBOX", Boolean.toString(menu.getVariableCheckBox().isSelected()),
				propertyName);
		setSetting.writeProperty("VARIABLE_PREFIX", menu.getVariablePrefixField().getText(), propertyName);
		setSetting.writeProperty("VARIABLE_POSTFIX", menu.getVariablePostfixField().getText(), propertyName);

		writeWrap();
	}

	/**
	 * check checkboxes and refresh data in wrap fields
	 */
	public void writeWrap() {
		classNameCheckBoxRunner();
		commentsCheckBoxRunner();
		constantCheckBoxRunner();
		variableCheckBoxRunner();
	}

	/**
	 * check checkboxes and refresh data in wrap fields
	 */
	private void classNameCheckBoxRunner() {
		if (menu.getClassNameCheckBox().isSelected()) {
			WrapJava.classNamePrefix = setSetting.getProperty("CLASS_NAME_PREFIX");
			WrapJava.classNamePostfix = setSetting.getProperty("CLASS_NAME_POSTFIX");

		} else {
			WrapJava.classNamePrefix = NOTHING;
			WrapJava.classNamePostfix = NOTHING;
		}
	}

	/**
	 * check checkboxes and refresh data in wrap fields
	 */
	private void commentsCheckBoxRunner() {
		if (menu.getCommentsCheckBox().isSelected()) {
			WrapJava.commentPrefix = setSetting.getProperty("COMMENT_PREFIX");
			WrapJava.commentPostfix = setSetting.getProperty("COMMENT_POSTFIX");
		} else {
			WrapJava.commentPrefix = NOTHING;
			WrapJava.commentPostfix = NOTHING;
		}
	}

	/**
	 * check checkboxes and refresh data in wrap fields
	 */
	private void constantCheckBoxRunner() {
		if (menu.getConstantCheckBox().isSelected()) {

			WrapJava.constantPrefix = setSetting.getProperty("CONSTANT_PREFIX");
			WrapJava.constantPostfix = setSetting.getProperty("CONSTANT_POSTFIX");
		} else {
			WrapJava.constantPrefix = NOTHING;
			WrapJava.constantPostfix = NOTHING;
		}
	}

	/**
	 * check checkboxes and refresh data in wrap fields
	 */
	private void variableCheckBoxRunner() {
		if (menu.getVariableCheckBox().isSelected()) {
			WrapJava.variablePrefix = setSetting.getProperty("VARIABLE_PREFIX");
			WrapJava.variablePostfix = setSetting.getProperty("VARIABLE_POSTFIX");
		} else {
			WrapJava.variablePrefix = NOTHING;
			WrapJava.variablePostfix = NOTHING;
		}
	}
}

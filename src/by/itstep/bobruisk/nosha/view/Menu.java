package by.itstep.bobruisk.nosha.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import by.itstep.bobruisk.nosha.controler.SettingController;
import by.itstep.bobruisk.nosha.runner.initSetting.SetSetting;

/**
 * @author nosha menu for GUI
 */
public class Menu {

	private static Locale currentLocale = Locale.getDefault();
	private static ResourceBundle res = ResourceBundle.getBundle("resurses" + File.separator + "local", currentLocale);

	SetSetting setSetting = new SetSetting();

	private static final String LANGUAGE = res.getString("LANGUAGE");
	private static final String ENGLISH_LANGUAGE = res.getString("ENGLISH_LANGUAGE");
	private static final String RUSSIAN_LANGUAGE = res.getString("RUSSIAN_LANGUAGE");
	private static final String BELARUSIAN_LANGUAGE = res.getString("BELARUSIAN_LANGUAGE");
	private static final String WINDOW = res.getString("WINDOW");
	private static final String ALWAYS_ON_TOP = res.getString("ALWAYS_ON_TOP");
	private static final String WARNING_CHOOSE_LANGUIGE_TEXT = res.getString("WARNING_CHOOSE_LANGUIGE_TEXT");
	private static final String SETTING_MENU_TEXT = res.getString("SETTING_MENU_TEXT");
	private static final String WRAP_SETTINGS_TEXT = res.getString("WRAP_SETTINGS_TEXT");

	private static final String CLASS_NAME_LABEL_TEXT = res.getString("CLASS_NAME_LABEL_TEXT");
	private static final String COMMENTS_LABEL_TEXT = res.getString("COMMENTS_LABEL_TEXT");
	private static final String CONSTANT_LABEL_TEXT = res.getString("CONSTANT_LABEL_TEXT");
	private static final String VARIABLE_LABEL_TEXT = res.getString("VARIABLE_LABEL_TEXT");
	private static final String SAVE_BUTTON_TEXT = res.getString("SAVE_BUTTON_TEXT");
	private static final String CURRENT_LANGUAGE = res.getString("CURRENT_LANGUAGE");;

	private JMenuItem englishLanguage;
	private JMenuItem russianLanguage;
	private JMenuItem belarusianLanguage;
	private JMenuItem currentLanguage;

	private JCheckBoxMenuItem alwaysOnTop;
	private JMenuItem wrapSettings;

	private JCheckBox classNameCheckBox;

	private JCheckBox commentsCheckBox;
	private JCheckBox constantCheckBox;
	private JCheckBox variableCheckBox;

	private JTextField classNamePrefixField;
	private JTextField classNamePostfixField;
	private JTextField commentsPrefixField;
	private JTextField commentsPostfixField;
	private JTextField constantPrefixField;
	private JTextField constantPostfixField;
	private JTextField variablePrefixField;
	private JTextField variablePostfixField;

	private JButton saveButton;

	/**
	 * @return menu bar to GUI
	 */
	public JMenuBar initMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		menuBar.add(initializeWindowMenu());
		menuBar.add(initializeLanguageMenu());
		menuBar.add(initializeSettingMenu());

		return menuBar;
	}

	/**
	 * @return menu always on top for menu bar
	 */
	private JMenu initializeWindowMenu() {
		JMenu windowMenu = new JMenu(WINDOW);
		alwaysOnTop = new JCheckBoxMenuItem(ALWAYS_ON_TOP);

		windowMenu.add(alwaysOnTop);
		return windowMenu;

	}

	/**
	 * @return language menu for menu bar
	 */
	private JMenu initializeLanguageMenu() {

		JMenu languageMenu = new JMenu(LANGUAGE);
		JLabel warningChooseLanguige = new JLabel(WARNING_CHOOSE_LANGUIGE_TEXT);
		warningChooseLanguige.setForeground(Color.red);
		currentLanguage = new JMenuItem(CURRENT_LANGUAGE);
		englishLanguage = new JMenuItem(ENGLISH_LANGUAGE);
		russianLanguage = new JMenuItem(RUSSIAN_LANGUAGE);
		belarusianLanguage = new JMenuItem(BELARUSIAN_LANGUAGE);
		languageMenu.add(warningChooseLanguige);
		languageMenu.addSeparator();
		languageMenu.add(currentLanguage);
		languageMenu.add(englishLanguage);
		languageMenu.add(russianLanguage);
		languageMenu.add(belarusianLanguage);

		return languageMenu;
	}

	/**
	 * @return setting menu for menu bar
	 */
	private JMenu initializeSettingMenu() {
		JMenu settingMenu = new JMenu(SETTING_MENU_TEXT);
		wrapSettings = new JMenuItem(WRAP_SETTINGS_TEXT);
		settingMenu.add(wrapSettings);
		return settingMenu;
	}

	/**
	 * @return panel whit wrap setting for JOptionPane
	 */
	public JPanel initSettings() {
		JPanel panelSetting = new JPanel(new GridBagLayout());

		classNameCheckBox = new JCheckBox();
		classNameCheckBox.setSelected(Boolean.valueOf(setSetting.getProperty("CLASS_NAME_CHECKBOX")));
		classNamePrefixField = new JTextField(setSetting.getProperty("CLASS_NAME_PREFIX"));
		classNamePostfixField = new JTextField(setSetting.getProperty("CLASS_NAME_POSTFIX"));
		JLabel classNameLabel = new JLabel(CLASS_NAME_LABEL_TEXT);

		commentsCheckBox = new JCheckBox();
		commentsCheckBox.setSelected(Boolean.valueOf(setSetting.getProperty("COMMENT_CHECKBOX")));
		commentsPrefixField = new JTextField(setSetting.getProperty("COMMENT_PREFIX"));
		commentsPostfixField = new JTextField(setSetting.getProperty("COMMENT_POSTFIX"));
		JLabel commentsLabel = new JLabel(COMMENTS_LABEL_TEXT);

		constantCheckBox = new JCheckBox();
		constantCheckBox.setSelected(Boolean.valueOf(setSetting.getProperty("CONSTANT_CHECKBOX")));
		constantPrefixField = new JTextField(setSetting.getProperty("CONSTANT_PREFIX"));
		constantPostfixField = new JTextField(setSetting.getProperty("CONSTANT_POSTFIX"));
		JLabel constantLabel = new JLabel(CONSTANT_LABEL_TEXT);

		variableCheckBox = new JCheckBox();
		variableCheckBox.setSelected(Boolean.valueOf(setSetting.getProperty("VARIABLE_CHECKBOX")));
		variablePrefixField = new JTextField(setSetting.getProperty("VARIABLE_PREFIX"));
		variablePostfixField = new JTextField(setSetting.getProperty("VARIABLE_POSTFIX"));
		JLabel variableLabel = new JLabel(VARIABLE_LABEL_TEXT);

		saveButton = new JButton(SAVE_BUTTON_TEXT);

		panelSetting.add(classNameCheckBox, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

		panelSetting.add(classNamePrefixField, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 160, 0));

		panelSetting.add(classNameLabel, new GridBagConstraints(2, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

		panelSetting.add(classNamePostfixField, new GridBagConstraints(3, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 160, 0));

		panelSetting.add(commentsCheckBox, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

		panelSetting.add(commentsPrefixField, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 160, 0));

		panelSetting.add(commentsLabel, new GridBagConstraints(2, 1, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

		panelSetting.add(commentsPostfixField, new GridBagConstraints(3, 1, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 160, 0));

		panelSetting.add(constantCheckBox, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

		panelSetting.add(constantPrefixField, new GridBagConstraints(1, 2, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 160, 0));

		panelSetting.add(constantLabel, new GridBagConstraints(2, 2, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

		panelSetting.add(constantPostfixField, new GridBagConstraints(3, 2, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 160, 0));

		panelSetting.add(variableCheckBox, new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

		panelSetting.add(variablePrefixField, new GridBagConstraints(1, 3, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 160, 0));

		panelSetting.add(variableLabel, new GridBagConstraints(2, 3, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

		panelSetting.add(variablePostfixField, new GridBagConstraints(3, 3, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 160, 0));

		panelSetting.add(saveButton, new GridBagConstraints(4, 0, 1, 4, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 70));

		new SettingController().initListenerSetting();
		new SettingController().writeWrap();
		;
		return panelSetting;
	}

	public JMenuItem getEnglishLanguage() {
		return englishLanguage;
	}

	public void setEnglishLanguage(JMenuItem englishLanguage) {
		this.englishLanguage = englishLanguage;
	}

	public JMenuItem getRussianLanguage() {
		return russianLanguage;
	}

	public void setRussianLanguage(JMenuItem russianLanguage) {
		this.russianLanguage = russianLanguage;
	}

	public JMenuItem getBelarusianLanguage() {
		return belarusianLanguage;
	}

	public void setBelarusianLanguage(JMenuItem belarusianLanguage) {
		this.belarusianLanguage = belarusianLanguage;
	}

	public JCheckBoxMenuItem getAlwaysOnTop() {
		return alwaysOnTop;
	}

	public void setAlwaysOnTop(JCheckBoxMenuItem alwaysOnTop) {
		this.alwaysOnTop = alwaysOnTop;
	}

	public JMenuItem getWrapSettings() {
		return wrapSettings;
	}

	public void setWrapSettings(JMenuItem wrapSettings) {
		this.wrapSettings = wrapSettings;
	}

	public JCheckBox getClassNameCheckBox() {
		return classNameCheckBox;
	}

	public JCheckBox getCommentsCheckBox() {
		return commentsCheckBox;
	}

	public JCheckBox getConstantCheckBox() {
		return constantCheckBox;
	}

	public JCheckBox getVariableCheckBox() {
		return variableCheckBox;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public JTextField getClassNamePrefixField() {
		return classNamePrefixField;
	}

	public JTextField getClassNamePostfixField() {
		return classNamePostfixField;
	}

	public JTextField getCommentsPrefixField() {
		return commentsPrefixField;
	}

	public JTextField getCommentsPostfixField() {
		return commentsPostfixField;
	}

	public JTextField getConstantPrefixField() {
		return constantPrefixField;
	}

	public JTextField getConstantPostfixField() {
		return constantPostfixField;
	}

	public JTextField getVariablePrefixField() {
		return variablePrefixField;
	}

	public JTextField getVariablePostfixField() {
		return variablePostfixField;
	}

	public void setClassNameCheckBox(JCheckBox classNameCheckBox) {
		this.classNameCheckBox = classNameCheckBox;
	}

	public void setCommentsCheckBox(JCheckBox commentsCheckBox) {
		this.commentsCheckBox = commentsCheckBox;
	}

	public void setConstantCheckBox(JCheckBox constantCheckBox) {
		this.constantCheckBox = constantCheckBox;
	}

	public void setVariableCheckBox(JCheckBox variableCheckBox) {
		this.variableCheckBox = variableCheckBox;
	}

	public JMenuItem getCurrentLanguage() {
		return currentLanguage;
	}
}

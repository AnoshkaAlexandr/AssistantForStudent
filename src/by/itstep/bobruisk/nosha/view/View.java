package by.itstep.bobruisk.nosha.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author nosha nain GUI window
 */
@SuppressWarnings("serial")

public class View extends JFrame {

	/**
	 * @param menu
	 */
	public View(JMenuBar menu) {
		initFrame(menu);
	}

	private static Locale currentLocale = Locale.getDefault();
	private static ResourceBundle res = ResourceBundle.getBundle("resurses" + File.separator + "local", currentLocale);

	private static final String FIRST_TABLE_PANEL_NAME = res.getString("FIRST_TABLE_PANEL_NAME");
	private static final String SECOND_TABLE_PANEL_NAME = res.getString("SECOND_TABLE_PANEL_NAME");
	private static final String LABEL_FOR_FIELD_INPUT_VAR_TEXT = res.getString("LABEL_FOR_FIELD_INPUT_VAR_TEXT");
	private static final String BUTTON_FOR_VAR_TEXT = res.getString("BUTTON_FOR_VAR_TEXT");
	private static final String BUTTON_FOR_CONSTANT_TEXT = res.getString("BUTTON_FOR_CONSTANT_TEXT");
	private static final String BUTTON_FOR_COMMENT_TEXT = res.getString("BUTTON_FOR_COMMENT_TEXT");
	private static final String LABEL_FOR_TRANSLATE_TEXT = res.getString("LABEL_FOR_TRANSLATE_TEXT");
	private static final String TRANSLATE_TEXT_TEXT = res.getString("TRANSLATE_TEXT_TEXT");
	private static final String TITLE_FOR_WINDOW = res.getString("TITLE_FOR_WINDOW");
	private static final String BUTTON_TRANSLATE_TEXT = res.getString("BUTTON_TRANSLATE_TEXT");
	private static final String BUTTON_OPEN_OTHER_WINDOW_TEXT = res.getString("BUTTON_OPEN_OTHER_WINDOW_TEXT");
	private static final String BUTTON_FOR_CLASS_NAME_TEXT = res.getString("BUTTON_FOR_CLASS_NAME_TEXT");
	private static final String BUTTON_CLEAR_TEXT = res.getString("BUTTON_CLEAR_TEXT");

	private JTextField fieldForInputVar;
	private JButton buttonForVar;
	private JButton buttonForConstant;
	private JButton buttonForComment;
	private JButton buttonForClassName;
	private JButton buttonClearText;

	private JTextArea areaForInput;
	private JButton buttonTranslate;
	private JTextArea areaForOutput;
	private JButton buttonOpenOtherWindow;

	/**
	 * initialize the main window
	 */
	public void initFrame(JMenuBar menu) {

		setLayout(new BorderLayout());
		add(initMainPanel(), BorderLayout.NORTH);
		setJMenuBar(menu);
		setDefaultLookAndFeelDecorated(true);
		setTitle(TITLE_FOR_WINDOW);
		setSize(new Dimension(400, 285));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}

	/**
	 * @return created the main panel
	 */
	private Component initMainPanel() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(initTablePanel(), BorderLayout.NORTH);
		return mainPanel;
	}

	/**
	 * @return the panel tabular view with two tabs
	 */
	private Component initTablePanel() {
		JTabbedPane mainTablePanel = new JTabbedPane();
		mainTablePanel.add(FIRST_TABLE_PANEL_NAME, initFirstTablePanel());
		mainTablePanel.add(SECOND_TABLE_PANEL_NAME, initSecondTablePanel());

		return mainTablePanel;
	}

	/**
	 * @return panel with user interface for creating variables
	 */
	private Component initFirstTablePanel() {
		JPanel panelToCreate = new JPanel(new GridBagLayout());

		JLabel labelForFieldInputVar = new JLabel(LABEL_FOR_FIELD_INPUT_VAR_TEXT);
		fieldForInputVar = new JTextField(20);

		buttonForVar = new JButton(BUTTON_FOR_VAR_TEXT);
		buttonForConstant = new JButton(BUTTON_FOR_CONSTANT_TEXT);
		buttonForComment = new JButton(BUTTON_FOR_COMMENT_TEXT);
		buttonForClassName = new JButton(BUTTON_FOR_CLASS_NAME_TEXT);

		panelToCreate.add(labelForFieldInputVar, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, -10, 2), 0, 0));

		panelToCreate.add(fieldForInputVar, new GridBagConstraints(0, 1, 1, 2, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(-0, 2, -10, 2), 0, 10));

		panelToCreate.add(buttonForVar, new GridBagConstraints(0, 3, 2, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(0, 2, 0, 2), 0, 0));

		panelToCreate.add(buttonForConstant, new GridBagConstraints(0, 4, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(-15, 2, 0, 2), 0, 00));

		panelToCreate.add(buttonForComment, new GridBagConstraints(0, 5, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(-15, 2, 0, 2), 0, 00));

		panelToCreate.add(buttonForClassName, new GridBagConstraints(0, 6, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(-15, 2, 0, 2), 0, 00));

		return panelToCreate;
	}

	/**
	 * @return panel with interface for translation of the text
	 */
	private Component initSecondTablePanel() {
		JPanel panelForTranslate = new JPanel(new GridBagLayout());

		JLabel labelForTranslate = new JLabel(LABEL_FOR_TRANSLATE_TEXT);

		areaForInput = new JTextArea(3, 5);
		areaForInput.setLineWrap(true);

		JScrollPane scrollForInput = new JScrollPane(areaForInput);

		buttonTranslate = new JButton(BUTTON_TRANSLATE_TEXT);
		buttonClearText = new JButton(BUTTON_CLEAR_TEXT);

		JLabel translateText = new JLabel(TRANSLATE_TEXT_TEXT);

		areaForOutput = new JTextArea(3, 5);
		areaForOutput.setLineWrap(true);
		areaForOutput.setEditable(false);

		JScrollPane scrollForOutput = new JScrollPane(areaForOutput);

		buttonOpenOtherWindow = new JButton(BUTTON_OPEN_OTHER_WINDOW_TEXT);

		panelForTranslate.add(labelForTranslate, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 30, 0));

		panelForTranslate.add(buttonTranslate, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

		panelForTranslate.add(buttonClearText, new GridBagConstraints(2, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 10, 0));

		panelForTranslate.add(scrollForInput, new GridBagConstraints(0, 1, 3, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 20));

		panelForTranslate.add(translateText, new GridBagConstraints(0, 2, 2, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

		panelForTranslate.add(buttonOpenOtherWindow, new GridBagConstraints(2, 2, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

		panelForTranslate.add(scrollForOutput, new GridBagConstraints(0, 3, 3, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 10, 2), 0, 20));

		return panelForTranslate;
	}

	/**
	 * @param volue
	 *            realizes always on top
	 */
	public void setOnTop(boolean volue) {
		setAlwaysOnTop(volue);

	}

	/**
	 * to open a new window with the translated text
	 */
	public void openOtherWindow() {
		String text = areaForOutput.getText().replaceAll("\n", " @@@@@ ");

		JPanel popUpPanel = new JPanel();
		JTextArea newWindow = new JTextArea(20, 50);
		JScrollPane scrolForNewWindow = new JScrollPane(newWindow);
		newWindow.setEditable(false);

		newWindow.setText(text.replaceAll(" @@@@@ ", "\n"));
		newWindow.setLineWrap(true);
		popUpPanel.add(scrolForNewWindow);
		JOptionPane.showMessageDialog(this, popUpPanel);
	}

	public JTextArea getAreaForInput() {
		return areaForInput;
	}

	public JButton getButtonOpenOtherWindow() {
		return buttonOpenOtherWindow;
	}

	public JTextArea getAreaForOutput() {
		return areaForOutput;
	}

	public JButton getButtonForVar() {
		return buttonForVar;
	}

	public JButton getButtonForConstant() {
		return buttonForConstant;
	}

	public JButton getButtonForComment() {
		return buttonForComment;
	}

	public JTextField getFieldForInputVar() {
		return fieldForInputVar;
	}

	public JButton getButtonTranslate() {
		return buttonTranslate;
	}

	public JButton getButtonForClassName() {
		return buttonForClassName;
	}

	public JButton getButtonClearText() {
		return buttonClearText;
	}
}

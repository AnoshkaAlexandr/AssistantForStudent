package by.itstep.bobruisk.nosha.controler;

import javax.swing.JOptionPane;

import by.itstep.bobruisk.nosha.runner.initSetting.SetSetting;
import by.itstep.bobruisk.nosha.view.Menu;
import by.itstep.bobruisk.nosha.view.View;

public class MenuController {

	Menu menu;
	View view;

	SetSetting setting = new SetSetting();

	/**
	 * @param menu
	 * @param view
	 */
	public MenuController(Menu menu, View view) {
		this.menu = menu;
		this.view = view;

		initMenuListener();
	}

	/**
	 * initialization listener from menu
	 */
	public void initMenuListener() {

		menu.getWrapSettings()
				.addActionListener(klickEvent -> JOptionPane.showMessageDialog(view, menu.initSettings()));

		menu.getCurrentLanguage()
				.addActionListener(klickEvent -> setting.writeProperty("LANG", "", setting.getProperty("PROPERTY")));
		menu.getBelarusianLanguage()
				.addActionListener(klickEvent -> setting.writeProperty("LANG", "by", setting.getProperty("PROPERTY")));
		menu.getRussianLanguage()
				.addActionListener(klickEvent -> setting.writeProperty("LANG", "ru", setting.getProperty("PROPERTY")));
		menu.getEnglishLanguage()
				.addActionListener(klickEvent -> setting.writeProperty("LANG", "en", setting.getProperty("PROPERTY")));

		menu.getAlwaysOnTop().addActionListener(klickEvent -> getAlwaysOnTopRunner());

	}

	/**
	 * realizes always on top
	 */
	private void getAlwaysOnTopRunner() {
		if (menu.getAlwaysOnTop().isSelected()) {
			view.setOnTop(true);
		} else {
			view.setOnTop(false);
		}
	}

}

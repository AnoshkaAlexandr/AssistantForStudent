package by.itstep.bobruisk.nosha.runner;

import javax.swing.JOptionPane;

import by.itstep.bobruisk.nosha.controler.Controller;
import by.itstep.bobruisk.nosha.controler.ControllerException;
import by.itstep.bobruisk.nosha.controler.MenuController;
import by.itstep.bobruisk.nosha.runner.initSetting.SetSetting;
import by.itstep.bobruisk.nosha.view.Menu;
import by.itstep.bobruisk.nosha.view.View;

public class Main {

	public static View view;
	public static Menu menu;

	/**
	 * @param args
	 *            NO ARGS
	 */
	public static void main(String[] args) {

		new SetSetting().initDefaultSettings();
		menu = new Menu();
		view = new View(menu.initMenuBar());
		try {
			new Controller(view);
		} catch (ControllerException e) {
			JOptionPane.showMessageDialog(view, e);
		}
		new MenuController(menu, view);

	}

}
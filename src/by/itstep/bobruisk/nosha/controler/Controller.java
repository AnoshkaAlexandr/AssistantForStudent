package by.itstep.bobruisk.nosha.controler;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import by.itstep.bobruisk.nosha.controler.transform.JavaTransformer;
import by.itstep.bobruisk.nosha.controler.transform.Transformable;
import by.itstep.bobruisk.nosha.controler.translate.Translatable;
import by.itstep.bobruisk.nosha.controler.translate.YandexTranslator;
import by.itstep.bobruisk.nosha.controler.wrapping.WrapJava;
import by.itstep.bobruisk.nosha.controler.wrapping.Wrapping;
import by.itstep.bobruisk.nosha.view.View;

public class Controller implements KeyListener {

	private static final String TO_ENGLISH = "ru-en";
	private static final String TO_RUSSIAN = "en-ru";

	View view;

	Translatable translate = new YandexTranslator();
	Transformable toJava = new JavaTransformer();
	Wrapping wrap = new WrapJava();

	/**
	 * @param View
	 *            view
	 */
	public Controller(View view) {
		this.view = view;
		initLstener();
	}

	/**
	 * initialization listeners for component from panel with create variables
	 */
	private void initLstener() {

		view.getFieldForInputVar().addKeyListener(this);

		view.getButtonForConstant().addActionListener(
				klickEvent -> setClipboard(wrap.wrapConstant(view.getButtonForConstant().getText())));

		view.getButtonForVar()
				.addActionListener(klickEvent -> setClipboard(wrap.wrapVariable(view.getButtonForVar().getText())));

		view.getButtonForComment()
				.addActionListener(klickEvent -> setClipboard(wrap.wrapComment(view.getButtonForComment().getText())));

		view.getButtonForClassName().addActionListener(
				klickEvent -> setClipboard(wrap.wrapClassName(view.getButtonForClassName().getText())));

		view.getButtonTranslate()
				.addActionListener(klickEvent -> view.getAreaForOutput()
						.setText(translate
								.getString(view.getAreaForInput().getText().replaceAll("\n", " @@@@@ "), TO_RUSSIAN)
								.replaceAll(" @@@@@ ", "\n")));

		view.getButtonOpenOtherWindow().addActionListener(klickEvent -> view.openOtherWindow());

		view.getButtonClearText().addActionListener(klickEvent -> view.getAreaForInput().setText(null));
	}

	@Override
	public void keyPressed(KeyEvent e) {

		// create variables after pushing enter button

		if (e.getKeyCode() == KeyEvent.VK_ENTER && e.getSource().equals(view.getFieldForInputVar())) {
			String var = view.getFieldForInputVar().getText();
			view.getButtonForConstant().setText(toJava.toConstant(translate.getString(var, TO_ENGLISH)));
			view.getButtonForVar().setText(toJava.toVariable(translate.getString(var, TO_ENGLISH)));
			view.getButtonForComment().setText(toJava.toComment(translate.getString(var, TO_ENGLISH)));
			view.getButtonForClassName().setText(toJava.toClassName(translate.getString(var, TO_ENGLISH)));

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * @param string
	 *            from button put to clipboard
	 */
	public static void setClipboard(String str) {
		StringSelection ss = new StringSelection(str);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	}

}

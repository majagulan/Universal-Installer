package konfiguracioniRezim.actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.KeyStroke;

import konfiguracioniRezim.view.MyApp;



public class QuitAction extends AbstractActionIcon{
	
	public QuitAction(Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
		putValue(SMALL_ICON, iconGetter("/quit.png", d));
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("Quit"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("Quit"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MyApp.getInstance().dispatchEvent(new WindowEvent(MyApp.getInstance(), WindowEvent.WINDOW_CLOSING));
	}
	
	public void initComponents() {
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("Quit"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("Quit"));
	}

}
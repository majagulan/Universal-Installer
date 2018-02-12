package konfiguracioniRezim.actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import konfiguracioniRezim.model.Wizard;
import konfiguracioniRezim.view.DialogParametar;
import konfiguracioniRezim.view.MyApp;

@SuppressWarnings("serial")
public class NewParameterAction extends AbstractActionIcon {

	public NewParameterAction(Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_R);
		putValue(SMALL_ICON, iconGetter("/newParameter.png", d));
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("newPar"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("newPar"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		Object selectedNode = MyApp.getInstance().getTree().getLastSelectedPathComponent();

		if (selectedNode instanceof Wizard) {

			DialogParametar dpar = new DialogParametar(MyApp.getInstance(), "New Parameter", true);
			dpar.setVisible(true);

		}
	}
	
	public void initComponents() {
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("newPar"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("newPar"));
	}

}

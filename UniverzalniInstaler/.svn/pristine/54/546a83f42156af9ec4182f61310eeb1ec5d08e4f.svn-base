package konfiguracioniRezim.actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import konfiguracioniRezim.model.Product;
import konfiguracioniRezim.view.DialogWizard;
import konfiguracioniRezim.view.MyApp;

public class NewWizardAction extends AbstractActionIcon{

	public NewWizardAction(Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_W);
		putValue(SMALL_ICON, iconGetter("/newWizard.jpg", d));
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("newWizard"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("newWizard"));

		// setEnabled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Object selectedNode = MyApp.getInstance().getTree().getLastSelectedPathComponent();
		if(selectedNode instanceof Product) {
			
			Product prod =  (Product) selectedNode;
			DialogWizard dw = new DialogWizard(MyApp.getInstance(), "New Wizard", true);
			dw.initComponents();
			dw.setVisible(true);
            
		}
	}
	
	public void initComponents() {
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("newWizard"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("newWizard"));
	}

	
	

}

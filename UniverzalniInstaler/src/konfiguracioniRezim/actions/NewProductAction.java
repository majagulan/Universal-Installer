package konfiguracioniRezim.actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import konfiguracioniRezim.model.Workspace;
import konfiguracioniRezim.view.DialogProduct;
import konfiguracioniRezim.view.MyApp;

@SuppressWarnings("serial")
public class NewProductAction extends AbstractActionIcon {

	public NewProductAction(Dimension d) {

		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_P);
		putValue(SMALL_ICON, iconGetter("/newProduct.jpg", d));
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("newProd"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("newProd"));

		// setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		Object selectedNode = MyApp.getInstance().getTree().getLastSelectedPathComponent();

		if (selectedNode instanceof Workspace) {
			DialogProduct dp = new DialogProduct(MyApp.getInstance(), "New Product", true);
			dp.initComponents();
			dp.setVisible(true);

			System.out.println("Iz dijaloga: " + dp.getTxtname().getText());

		}

	}

	public void initComponents() {
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("newProd"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("newProd"));
	}

}

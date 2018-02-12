package konfiguracioniRezim.actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import konfiguracioniRezim.model.Parameter;
import konfiguracioniRezim.model.Product;
import konfiguracioniRezim.model.Wizard;
import konfiguracioniRezim.model.Workspace;
import konfiguracioniRezim.view.MyApp;

public class RemoveAction extends AbstractActionIcon {

	// private JTree tree;

	public RemoveAction(Dimension d) {

		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_R);
		putValue(SMALL_ICON, iconGetter("/remove.jpg", d));
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("Remove"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("Remove"));

		// setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Object selectedNode = MyApp.getInstance().getTree().getLastSelectedPathComponent();

		if (selectedNode instanceof Product) {
			Product prod = (Product) selectedNode;

			Workspace parent = prod.getParent();
			for (int i = 0; i < prod.getWizardCount(); i++) {
				prod.getWizards().clear();
				System.out.println("Izbrisani svi wizardi"); // RADIIIII
			}
			parent.izbrisi(prod);
			
			System.out.println("Izbrisan proizvod " + prod);
			MyApp.getInstance().getTree().clearSelection();

			// parent.azurirajLokacije();

		} else if (selectedNode instanceof Wizard) {

			Wizard delWiz = (Wizard) selectedNode;

			Product parent = delWiz.getParent();
			delWiz.getListParameters().clear();
			parent.izbrisi(delWiz);
			System.out.println("Brise se wizard " + delWiz);
			MyApp.getInstance().getTree().clearSelection();
		}
		
		else if(selectedNode instanceof Parameter) {
			
			Parameter delPar = (Parameter) selectedNode;
			Wizard parent = delPar.getParent();
			parent.izbrisi(delPar);
			System.out.println("Izbrisan parametar" + delPar.getParamName());
			
			MyApp.getInstance().getTree().clearSelection();
			MyApp.getInstance().getTree().revalidate();
		}

	}
	
	public void initComponents() {
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("Remove"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("Remove"));
	}

}

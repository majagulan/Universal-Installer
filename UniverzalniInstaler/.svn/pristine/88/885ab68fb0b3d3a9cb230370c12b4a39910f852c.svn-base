package konfiguracioniRezim.actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import konfiguracioniRezim.model.Product;
import konfiguracioniRezim.model.Workspace;
import konfiguracioniRezim.view.MyApp;

public class SaveAction extends AbstractActionIcon{
	
	private ResourceBundle resourceBundle = ResourceBundle.getBundle("MessageResources.MessageResources", Locale.getDefault());
	private JFrame frame;
	
	public SaveAction(Dimension d) {

		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_S);
		putValue(SMALL_ICON, iconGetter("/save.jpg", d));
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("Save"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("Save"));
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//cuvanje workspace-a
		Object selectedNode = MyApp.getInstance().getTree().getLastSelectedPathComponent();

		if (selectedNode instanceof Workspace) {
			File f = new File("datWorkspace.txt");

			ObjectOutputStream oos = null;
			try {
				oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(frame, resourceBundle.getString("upozorenjeNeuspesno"), resourceBundle.getString("upozorenje3"),2);
				e1.printStackTrace();
			}

			try {
				oos.writeObject(selectedNode);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame, resourceBundle.getString("upozorenjeNeuspesno"), resourceBundle.getString("upozorenje3"),2);
				e.printStackTrace();
			} finally {
				try {
					oos.close();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(frame, resourceBundle.getString("upozorenjeNeuspesno"), resourceBundle.getString("upozorenje3"),2);
					e.printStackTrace();
				}
			}
			System.out.println("sacuvan workspace " + selectedNode);
			JOptionPane.showMessageDialog(frame, resourceBundle.getString("upozorenjeUspesno"), resourceBundle.getString("upozorenje3"),JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		
		else if (selectedNode instanceof Product) {
			Product pSave = (Product)selectedNode;
			//proizvod se cuva u datoteci sa imenom proizvoda i ekstenzijom .pro
			String name = pSave.getName();
			File f = new File(name + ".pro");

			ObjectOutputStream oos = null;
			try {
				oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(frame, resourceBundle.getString("upozorenjeNeuspesno"), resourceBundle.getString("upozorenje1"),2);
				e1.printStackTrace();
			}

			try {
				oos.writeObject(selectedNode);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame, resourceBundle.getString("upozorenjeNeuspesno"), resourceBundle.getString("upozorenje3"),2);
				e.printStackTrace();
			} finally {
				try {
					oos.close();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(frame, resourceBundle.getString("upozorenjeNeuspesno"), resourceBundle.getString("upozorenje3"),2);
					e.printStackTrace();
				}
			}
			System.out.println("sacuvan workspace " + selectedNode);
			JOptionPane.showMessageDialog(frame, resourceBundle.getString("upozorenjeUspesno"), resourceBundle.getString("upozorenje3"),JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}
	
	public void initComponents() {
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("Save"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("Save"));
		resourceBundle.getString("upozorenjeNeuspesno");
		resourceBundle.getString("upozorenjeUspesno");
		resourceBundle.getString("upozorenje3");
	}

}

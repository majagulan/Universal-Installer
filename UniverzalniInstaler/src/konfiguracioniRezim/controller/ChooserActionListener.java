package konfiguracioniRezim.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import konfiguracioniRezim.view.MyApp;

public class ChooserActionListener implements ActionListener {

	private JTextField txtDest;

	public ChooserActionListener(JTextField txt) {
		txtDest = txt;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		File filter = null;
		int returnVal = chooser.showOpenDialog(MyApp.getInstance());
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			filter = chooser.getSelectedFile();
			
			//provjera fajla koji je korisnik unio
		//	File f = new File(txtDest.getText());
		/*	if (!(f.isFile())) {
				JOptionPane.showMessageDialog(null, MyApp.getInstance().getResourceBundle().getString("fileNePostoji"),
						MyApp.getInstance().getResourceBundle().getString("upozorenje"), JOptionPane.WARNING_MESSAGE);

			}*/
			txtDest.setText(filter.getAbsolutePath());
		}
	}

}

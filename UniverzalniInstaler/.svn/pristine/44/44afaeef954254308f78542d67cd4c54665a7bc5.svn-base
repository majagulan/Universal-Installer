package konfiguracioniRezim.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

import konfiguracioniRezim.model.Product;
import konfiguracioniRezim.model.Wizard;
import konfiguracioniRezim.view.DialogWizard;
import konfiguracioniRezim.view.MyApp;

public class OKActionListener implements ActionListener {

	private JTextField txtName;
	private DialogWizard dw;
	private ImageIcon icon;
	
	public OKActionListener(JTextField txtName, DialogWizard dw) {
		super();
		this.txtName = txtName;
		dw = dw;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Product prod = (Product) MyApp.getInstance().getTree().getLastSelectedPathComponent();
		Wizard wiz = new Wizard(txtName.getText(), prod);
		wiz.addObserver(MyApp.getInstance().getModelTree());
		wiz.setIkonica(icon);
		prod.dodaj(wiz);
		
		dw.setVisible(false);
	}



}

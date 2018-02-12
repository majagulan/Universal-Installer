package konfiguracioniRezim.controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class MyFocusListener implements FocusListener {

	private JTextField jtf;
	
	public MyFocusListener(JTextField j) {
		jtf = j;
	}
	
	@Override
	public void focusGained(FocusEvent arg0) {
			if(!jtf.getText().equals("Uneti ovde..."))
				jtf.setForeground(Color.black);
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		if(jtf.getText().equals("Uneti ovde...")) {
			jtf.setForeground(Color.RED);
			jtf.requestFocus();
		} else if(jtf.getText().equals("")) {
			jtf.setText("Uneti ovde...");
			jtf.setForeground(Color.RED);
			jtf.requestFocus();
		} else {
			jtf.setForeground(Color.black);
		}
	}

}

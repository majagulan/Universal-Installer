package konfiguracioniRezim.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

public class MyMouseListener implements MouseListener {

	private JTextField jtf;
	
	public MyMouseListener(JTextField j) {
		jtf = j;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(jtf.getText().equals("Uneti ovde...")) {
			jtf.setText("");
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}

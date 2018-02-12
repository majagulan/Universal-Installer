package konfiguracioniRezim.view;


import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import konfiguracioniRezim.actions.AbstractActionIcon;
import konfiguracioniRezim.actions.ActionManager;
import konfiguracioniRezim.actions.RemoveAction;
import konfiguracioniRezim.actions.SaveAction;
import konfiguracioniRezim.actions.UpdateAction;

@SuppressWarnings("serial")
public class SouthPanel extends JPanel{

	private JButton delete;
	private JButton save;
	private JButton update;
	
	@SuppressWarnings("deprecation")
	public SouthPanel() {
		delete = new JButton(ActionManager.getInstance().getRemove());
		save = new JButton(ActionManager.getInstance().getSave());
		
		update = new JButton(ActionManager.getInstance().getUpdate());
	
	
		save.disable();

		setLayout(new FlowLayout(FlowLayout.RIGHT));
		setBackground(new Color(159,182,205));
		add(update);
		add(save);
		add(delete);
		
		
	}
}
	

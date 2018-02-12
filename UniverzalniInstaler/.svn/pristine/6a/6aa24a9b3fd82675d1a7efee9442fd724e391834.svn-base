package konfiguracioniRezim.segments;

import javax.swing.JToolBar;

import konfiguracioniRezim.actions.AbstractActionIcon;
import konfiguracioniRezim.actions.ActionManager;
import konfiguracioniRezim.actions.NewParameterAction;
import konfiguracioniRezim.actions.NewProductAction;
import konfiguracioniRezim.actions.NewWizardAction;
import konfiguracioniRezim.actions.RemoveAction;
import konfiguracioniRezim.actions.SaveAction;

public class MyToolBar extends JToolBar {

	public MyToolBar() {
		super(JToolBar.HORIZONTAL);
		
		
		setFloatable(false);
		
		add(ActionManager.getInstance().getNewProd());
		add(ActionManager.getInstance().getNewWiz());
		add(ActionManager.getInstance().getNewPar());
		
		addSeparator();
		
		add(ActionManager.getInstance().getSave());
		add(ActionManager.getInstance().getRemove());
		
	}
}

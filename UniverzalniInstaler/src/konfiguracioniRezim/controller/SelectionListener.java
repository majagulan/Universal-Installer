package konfiguracioniRezim.controller;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import konfiguracioniRezim.actions.ActionManager;
import konfiguracioniRezim.model.Parameter;
import konfiguracioniRezim.model.Product;
import konfiguracioniRezim.model.Wizard;
import konfiguracioniRezim.model.Workspace;
import konfiguracioniRezim.view.DialogParametar;
import konfiguracioniRezim.view.DialogProduct;
import konfiguracioniRezim.view.DialogWizard;
import konfiguracioniRezim.view.MyApp;


public class SelectionListener implements TreeSelectionListener {
	
	private MyApp ma;
	private JPanel panZero;
	private DialogParametar npar;
	private DialogWizard nwiz;
	private DialogProduct prod;



	public SelectionListener(MyApp ma, JPanel panZero, DialogParametar npar, DialogWizard nwiz) {
		super();
		this.ma = ma;
		this.panZero = panZero;
		this.npar = npar;
		this.nwiz = nwiz;
	}


	@Override
	public void valueChanged(TreeSelectionEvent tse) {
	
		JTree tree = (JTree) tse.getSource();
		Object selectedNode = tree.getLastSelectedPathComponent();

		
		//u zavisnosti od toga sta je selektovano u stablu,
		//akcije postaju omogucene/onemogucene
		if (selectedNode instanceof Workspace) {

			ActionManager.getInstance().getNewProd().setEnabled(true);
			ActionManager.getInstance().getNewWiz().setEnabled(false);
			ActionManager.getInstance().getNewPar().setEnabled(false);
			ActionManager.getInstance().getSave().setEnabled(true);
			ActionManager.getInstance().getRemove().setEnabled(false);

		} else if (selectedNode instanceof Product) {

			ActionManager.getInstance().getNewProd().setEnabled(false);
			ActionManager.getInstance().getNewWiz().setEnabled(true);
			ActionManager.getInstance().getNewPar().setEnabled(false);
			ActionManager.getInstance().getSave().setEnabled(true);
			ActionManager.getInstance().getRemove().setEnabled(true);
			
		}

		else if (selectedNode instanceof Wizard) {

			ActionManager.getInstance().getNewProd().setEnabled(false);
			ActionManager.getInstance().getNewWiz().setEnabled(false);
			ActionManager.getInstance().getNewPar().setEnabled(true);
			ActionManager.getInstance().getSave().setEnabled(false);
			
			Wizard wiz = (Wizard)selectedNode;
			if(wiz.getName().equals("default")){
				
				ActionManager.getInstance().getRemove().setEnabled(false);
			}
			else
			ActionManager.getInstance().getRemove().setEnabled(true);
		

		} else if (selectedNode instanceof Parameter) {

			ActionManager.getInstance().getNewProd().setEnabled(false);
			ActionManager.getInstance().getNewWiz().setEnabled(false);
			ActionManager.getInstance().getNewPar().setEnabled(false);
			ActionManager.getInstance().getSave().setEnabled(false);
			ActionManager.getInstance().getRemove().setEnabled(true);

		}

	}

}

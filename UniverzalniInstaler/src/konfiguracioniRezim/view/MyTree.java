package konfiguracioniRezim.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import konfiguracioniRezim.model.Parameter;
import konfiguracioniRezim.model.Product;
import konfiguracioniRezim.model.Wizard;
import konfiguracioniRezim.model.Workspace;




public class MyTree implements TreeModel, Observer {

	Workspace root;
	JTree treeComponent;

	public MyTree(Workspace root, JTree treeComponent) {
		super();
		this.root = root;
		this.treeComponent = treeComponent;
		treeComponent.setCellRenderer(new TreeCellRendered());
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		SwingUtilities.updateComponentTreeUI(treeComponent);
	}

	@Override
	public void addTreeModelListener(TreeModelListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getChild(Object parent, int index) {
		// TODO Auto-generated method stub
		if (parent instanceof Workspace) {
			return ((Workspace) parent).getProductAt(index);
		} 
		else if (parent instanceof Product) {
			return ((Product) parent).getWizardAt(index);
		}
		else if(parent instanceof Wizard){
			return ((Wizard) parent).getParamAt(index);
			
		}
		return null;

	}

	@Override
	public int getChildCount(Object parent) {

		if (parent instanceof Workspace) {
			return ((Workspace) parent).getProductCount();
		} else if (parent instanceof Product) {
			return ((Product) parent).getWizardCount();
		}
		else if(parent instanceof Wizard){
			return ((Wizard) parent).getParamCount();
		}
		return 0;
	
	}

	@Override
	public int getIndexOfChild(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getRoot() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public boolean isLeaf(Object node) {
		// TODO Auto-generated method stub
		if (node instanceof Parameter)
			return true;
		return false;
	}

	@Override
	public void removeTreeModelListener(TreeModelListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void valueForPathChanged(TreePath arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

}

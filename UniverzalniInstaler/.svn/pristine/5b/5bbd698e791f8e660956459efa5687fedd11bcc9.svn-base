package konfiguracioniRezim.view;

import java.awt.Component;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import konfiguracioniRezim.model.Parameter;
import konfiguracioniRezim.model.Product;
import konfiguracioniRezim.model.Wizard;
import konfiguracioniRezim.model.Workspace;


@SuppressWarnings("serial")
public class TreeCellRendered extends DefaultTreeCellRenderer{
	
	public TreeCellRendered() {
		
	}
	public Component getTreeCellRendererComponent(
		JTree tree,
		Object value,
		boolean sel,
		boolean expended, 
		boolean leaf,
		int row,
		boolean hasFocus) {
		
		super.getTreeCellRendererComponent(tree, value, sel, expended, leaf, row, hasFocus);
		
		if (value instanceof Workspace) {
			ImageIcon icon = new ImageIcon("images/rsz_systemicon.png");
			setIcon(icon);
		} 
		else if (value instanceof Product) {
	
			ImageIcon icon = new ImageIcon("images/subsystemIcon.png");
			setIcon(icon);
		}
		else if (value instanceof Wizard) {
			
			ImageIcon	icon = new ImageIcon("images/packageIcon.png");
			setIcon(icon);
		}
		else if (value instanceof Parameter) {
			
		
			ImageIcon	icon = new ImageIcon("images/rsz_tablesNode.png");
			setIcon(icon);
		}
		return this;
		
	}
	
}

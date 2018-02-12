package konfiguracioniRezim.actions;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import konfiguracioniRezim.model.Parameter;
import konfiguracioniRezim.model.Product;
import konfiguracioniRezim.model.Wizard;
import konfiguracioniRezim.model.Workspace;
import konfiguracioniRezim.view.DialogParametar;
import konfiguracioniRezim.view.DialogProduct;
import konfiguracioniRezim.view.DialogWizard;
import konfiguracioniRezim.view.MyApp;

public class UpdateAction extends AbstractActionIcon {

	public UpdateAction(Dimension d) {

		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_U);
		putValue(SMALL_ICON, iconGetter("/edit.jpg", d));
		putValue(NAME, "Update");
		putValue(SHORT_DESCRIPTION, "Update");

		// setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object selectedNode = MyApp.getInstance().getTree().getLastSelectedPathComponent();
		if (selectedNode instanceof Product) {
			DialogProduct dp = new DialogProduct(MyApp.getInstance(), "Edit Product", true);
			dp.setTxtname(((Product) selectedNode).getName());
			dp.setTxtdest(((Product) selectedNode).getDestination());
			dp.setVisible(true);
			
		}
		
		if (selectedNode instanceof Wizard) {
			DialogWizard dw = new DialogWizard(MyApp.getInstance(), "Edit wizard", true);
			dw.setTxtname(((Wizard) selectedNode).getName());
			
			dw.setVisible(true);
			
		}
		
		if (selectedNode instanceof Parameter) {
			DialogParametar dp = new DialogParametar(MyApp.getInstance(), "Edit Parameter", true);
			Parameter p = (Parameter)selectedNode;
			
		
			dp.getImet().setText(p.getParamName());
			dp.getCbx().setSelected(p.isRo());
			dp.getCbx1().setSelected(p.isJeVidljiv());
			dp.getCbx2().setSelected(p.isObaveznoPopunjavanje());
			if(p.getParamType() == 0){
				dp.getVredt().setText((String)p.getValue());
			}
			else if (p.getParamType() == 1){
				dp.getArea().setText((String) p.getValue());
			}else if(p.getParamType() == 2) {
				if((Boolean)p.getValue()){
				dp.getTrueBtn().setSelected(true);
				dp.getFalseBtn().setSelected(false);
				}else{
					dp.getTrueBtn().setSelected(false);
					dp.getFalseBtn().setSelected(true);
				}
				
			}else if(p.getParamType() == 4){
				/////
				Image image = p.getSlika().getImage();
				image = image.getScaledInstance(50, 80, Image.SCALE_SMOOTH);
				dp.getLabel().setIcon(new ImageIcon(image));
				p.setValue(dp.getLabel().toString());
			}else if(p.getParamType() == 3) {
				
				dp.getVredt().setText((String)p.getValue());
				dp.getDodajFile().setVisible(true);
			
			}else{
				dp.getVredt().setText((String) p.getValue());
			}
			
			dp.getCbxTipParametra().setSelectedIndex(p.getParamType());
			dp.setVisible(true);
			
		}
	}
	
	public void initComponents() {
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("Update"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("Update"));
	}


}

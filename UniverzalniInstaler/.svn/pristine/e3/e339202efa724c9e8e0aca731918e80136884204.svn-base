package konfiguracioniRezim.segments;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Locale;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import konfiguracioniRezim.view.MyApp;
import konfiguracioniRezim.actions.AbstractActionIcon;
import konfiguracioniRezim.actions.ActionManager;
import konfiguracioniRezim.actions.NewParameterAction;
import konfiguracioniRezim.actions.NewProductAction;
import konfiguracioniRezim.actions.NewWizardAction;
import konfiguracioniRezim.actions.QuitAction;
import konfiguracioniRezim.actions.RemoveAction;
import konfiguracioniRezim.actions.SaveAction;

public class MyMenuBar extends JMenuBar {

	private JMenu file; //
	private JMenu edit;//
	private JMenu language;
	
	private JMenuItem srpski;
	private JMenuItem engleski;

	public MyMenuBar() {
		super();
		// TODO Auto-generated constructor stub

		file = new JMenu(MyApp.getInstance().getResourceBundle().getString("file"));
		file.setMnemonic(KeyEvent.VK_F);
		
		file.add(ActionManager.getInstance().getNewProd());
		file.add(ActionManager.getInstance().getNewWiz());
		file.add(ActionManager.getInstance().getNewPar());
		
		file.addSeparator();
		
		file.add(ActionManager.getInstance().getQuit());		
		
		edit = new JMenu(MyApp.getInstance().getResourceBundle().getString("edit"));
		edit.setMnemonic(KeyEvent.VK_E);
		edit.add(ActionManager.getInstance().getSave());
		edit.add(ActionManager.getInstance().getRemove());
		
		language = new JMenu(MyApp.getInstance().getResourceBundle().getString("language"));
		language.setMnemonic(KeyEvent.VK_L);
		srpski = new JMenuItem(MyApp.getInstance().getResourceBundle().getString("meniSrpski"));
		engleski = new JMenuItem(MyApp.getInstance().getResourceBundle().getString("meniEngleski"));
		
		language.add(srpski);
		language.addSeparator();
		language.add(engleski);

		
		add(file);
		add(edit);
		add(language);
		
		srpski.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Locale.setDefault(new Locale("sr", "RS"));
				MyApp.getInstance().changeLanguage();
				
			}
			
		});
		
		engleski.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Locale.setDefault(new Locale("en", "US"));
				MyApp.getInstance().changeLanguage();
				
			}
			
		});
		
		
	}
	
	public void initComponents(){
		
		srpski.setText(MyApp.getInstance().getResourceBundle().getString("meniSrpski"));
		engleski.setText(MyApp.getInstance().getResourceBundle().getString("meniEngleski"));
		file.setText(MyApp.getInstance().getResourceBundle().getString("file"));
		edit.setText(MyApp.getInstance().getResourceBundle().getString("edit"));
		language.setText(MyApp.getInstance().getResourceBundle().getString("language"));
		ActionManager.getInstance().getSave().initComponents();
		ActionManager.getInstance().getNewPar().initComponents();
		ActionManager.getInstance().getNewProd().initComponents();
		ActionManager.getInstance().getNewWiz().initComponents();
		ActionManager.getInstance().getQuit().initComponents();
		ActionManager.getInstance().getRemove().initComponents();
		ActionManager.getInstance().getUpdate().initComponents();
		
		
	}

}

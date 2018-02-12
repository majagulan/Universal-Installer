package instalacioniRezim;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import konfiguracioniRezim.model.Parameter;
import konfiguracioniRezim.model.Product;
import konfiguracioniRezim.model.Wizard;

public class MyFrame extends JFrame {

	private LanguageDialogInstalacioni languageDialog;
	private static ResourceBundle resourceBundle;

	private JButton next;
	private JButton back;
	private JButton finish;
	CardLayout cl = new CardLayout();
	private int counter = 0;
	private static MyFrame instance = null;	
	private ChooseDialog cd;
	private Product izabraniProizvod;
	private String destinacijaPromenjena;
	private String pomocZaText;

	private JScrollPane scroll = null;
	JButton promeni = null;

	private MyFrame() {
		Locale.setDefault(new Locale("en", "US"));
		resourceBundle = ResourceBundle.getBundle("MessageResources.MessageResources", Locale.getDefault());
	}

	public static MyFrame getInstance() {

		if (instance == null) {
			instance = new MyFrame();
			instance.initialise();
			MyFrame.getInstance().changeLanguage();
		}
		return instance;
	}

	void initialise() {

		

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth / 4, screenHeight / 2);
		setTitle(MyFrame.getInstance().getResourceBundle().getString("naslovApp"));
		setResizable(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Image img = kit.getImage("images/main.png");
		setIconImage(img);
		
		languageDialog = new LanguageDialogInstalacioni(this, true);
		languageDialog.setVisible(true);

		cd = new ChooseDialog(this, true);
		cd.initComponents();
		cd.setVisible(true);
		
		pomocZaText = "pomoc";

		// Gornji deo frame koji se ne menja
		// To je panel s imenom softvera
		JPanel jpanel1 = new JPanel();
		jpanel1.setLayout(new FlowLayout());
		JLabel jlabel1 = new JLabel("UnGeIn");
		jpanel1.add(jlabel1);
		add(jpanel1, BorderLayout.NORTH);

		// south panel za dugmice
		final JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		next = new JButton(MyFrame.getInstance().getResourceBundle().getString("next"));
		back = new JButton(MyFrame.getInstance().getResourceBundle().getString("back"));
		finish = new JButton(MyFrame.getInstance().getResourceBundle().getString("installandfinish"));
		south.add(back);
		south.add(next);
		south.add(finish);
		back.setEnabled(false);
		finish.setEnabled(false);
		add(south, BorderLayout.SOUTH);

		izabraniProizvod = cd.getIzabraniProizvod();
		// contener je sredisnji deo koji sadrzi wizarde
		final JPanel contener = new JPanel();
		contener.setLayout(cl);
		ArrayList<Wizard> wizards = new ArrayList<>();
		wizards = izabraniProizvod.getWizards();
		final int brWizarda = wizards.size();

		// kreiram onoliko panela koliko izabrani proizvod ima wizarda
		JPanel[] paneliWizarda = new JPanel[brWizarda];
		for (int i = 0; i < brWizarda; i++) {
			paneliWizarda[i] = new JPanel();
		}

		// dodajem sve panele u kontejner
		for (int i = 0; i < brWizarda; i++) {
			paneliWizarda[i].setLayout(new BoxLayout(paneliWizarda[i], BoxLayout.Y_AXIS));
			contener.add(paneliWizarda[i], "" + (i + 1));
			setEnabled(true);
		}

		add(contener, BorderLayout.CENTER);
		cl.show(contener, "0");
		
		if (brWizarda == 1){
			next.setEnabled(false);
			finish.setEnabled(true);
		}
		System.out.println("Lokacija proizvoda je " + izabraniProizvod.getLocation());
		System.out.println("Destinacija proizvoda je " + izabraniProizvod.getDestination());
		
		next.addActionListener(new ActionListener() {
			
			
			
			@Override
			public void actionPerformed(ActionEvent e) {

				ArrayList<Parameter> parameters = izabraniProizvod.getWizardAt(counter).getListParameters();
				int sumaNepopunjenih = 0;
				for(int i = 0 ; i < parameters.size() ; i++) {
					System.out.println(parameters.get(i).isObaveznoPopunjavanje());
					/*if(parameters.get(i).isObaveznoPopunjavanje()) {
						
						if(parameters.get(i).getParamType() == 0 && pomocZaText=="") {
							System.out.println("usao");
							sumaNepopunjenih++;
						}
						if(parameters.get(i).getParamType() == 1 && parameters.get(i).getValue().equals("")) {
							sumaNepopunjenih++;
							System.out.println("usao");
						}

						
					}
					*/
				}
				
				if(sumaNepopunjenih==0) {
				if(counter==0) {
					
					if(destinacijaPromenjena!=null) {
					System.out.println(destinacijaPromenjena);
					finish.addActionListener(new InstalacijaActionListener(izabraniProizvod.getLocation(),destinacijaPromenjena,izabraniProizvod.getName()));
					} else {
						finish.addActionListener(new InstalacijaActionListener(izabraniProizvod.getLocation(),izabraniProizvod.getDestination(),izabraniProizvod.getName()));
					}
				}
				
				if (counter < (brWizarda - 2)) {
					counter++;
					cl.next(contener);
					back.setEnabled(true);
				} else if (counter == (brWizarda - 2)) {
					counter++;
					back.setEnabled(true);
					cl.next(contener);
					next.setEnabled(false);
					finish.setEnabled(true);
				}
			}
			}
		});
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (counter > 1) {
					counter--;
					cl.previous(contener);
					finish.setEnabled(false);
					next.setEnabled(true);
				} else if (counter == 1) {
					counter--;
					cl.previous(contener);
					back.setEnabled(false);
					finish.setEnabled(false);
					next.setEnabled(true);
				}
			}
		});

		// dodajparametre
		for (int i = 0; i < wizards.size(); i++) { // on ide kroz listu i vraca
													// wizard
			for (int j = 0; j < wizards.get(i).getListParameters().size(); j++) {
				dodaj(paneliWizarda[i], wizards.get(i).getParamAt(j), wizards.get(i).getListParameters().get(j).getParamName(),
						wizards.get(i).getListParameters().get(j).getParamType(),
						wizards.get(i).getListParameters().get(j).getValue(),
						wizards.get(i).getListParameters().get(j).getSlika());
			}
		}

	}

	public void dodaj(JPanel p, Parameter par, String ime, int tip, Object vrednost, ImageIcon icon) {
		// kraci tekst
		if (tip == 0 && par.isJeVidljiv()==true) {
			Box boxCentar = Box.createVerticalBox();
			boxCentar.add(Box.createVerticalStrut(0));
			JPanel jp = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel j = new JLabel(ime);
			JTextField jt = new JTextField((String) vrednost);
			jt.setEditable(!(par.isRo()));
			j.setPreferredSize(new Dimension(100, 30));
			jt.setPreferredSize(new Dimension(200, 20));
			jp.add(j);
			jp.add(jt);
			boxCentar.add(jp);
			p.add(boxCentar);
			
			
		
			// tekst
		} else if (tip == 1 && par.isJeVidljiv()==true) {
			Box boxCentar = Box.createVerticalBox();
			boxCentar.add(Box.createVerticalStrut(0));
			JPanel jp = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel j = new JLabel(ime);
			JTextArea jt = new JTextArea((String) vrednost, 7, 20);
			jt.setEditable(!(par.isRo()));
			scroll = new JScrollPane(jt);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scroll.setBackground(new Color(94, 14, 14));
			scroll.setMinimumSize(new Dimension(1, 1));
			JRadioButton rb = new JRadioButton("I agree", true);
			JRadioButton rb1 = new JRadioButton("I don't agree", false);
			ButtonGroup group = new ButtonGroup();
			group.add(rb);
			group.add(rb1);
			jp.add(j);
			jp.add(scroll);
			jp.add(rb);
			jp.add(rb1);
			boxCentar.add(jp);
			p.add(boxCentar);
		} else if (tip == 4 && par.isJeVidljiv()==true) {
			Box boxCentar = Box.createVerticalBox();
			boxCentar.add(Box.createVerticalStrut(0));
			JPanel jp = new JPanel(new FlowLayout(FlowLayout.LEFT));
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(90, 130, Image.SCALE_SMOOTH);
			ImageIcon newIcon = new ImageIcon(newimg);
			JLabel l = new JLabel(newIcon);
			l.setPreferredSize(new Dimension(200, 200));
			jp.add(l);
			boxCentar.add(jp);
			p.add(boxCentar);
		} else if (tip == 2 && par.isJeVidljiv()==true) {
			Box boxCentar = Box.createVerticalBox();
			boxCentar.add(Box.createVerticalStrut(0));
			JPanel jp = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel j = new JLabel(ime);
			JRadioButton trueBtn;
			JRadioButton falseBtn;
			ButtonGroup group;
			trueBtn = new JRadioButton("true");
			falseBtn = new JRadioButton("false");
			j.setPreferredSize(new Dimension(100, 30));
			if((Boolean)vrednost == true){
				
				trueBtn.setSelected(true);
				group = new ButtonGroup();
				group.add(trueBtn);
				group.add(falseBtn);
			}else{
				falseBtn.setSelected(true);
				group = new ButtonGroup();
				group.add(trueBtn);
				group.add(falseBtn);
			}
				
			jp.add(j);
			jp.add(trueBtn);
			jp.add(falseBtn);
			
			boxCentar.add(jp);
			p.add(boxCentar);
			
		} else if (tip == 3 && par.isJeVidljiv()==true) {
			Box boxCentar = Box.createVerticalBox();
			boxCentar.add(Box.createVerticalStrut(0));
			JPanel jp = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel j = new JLabel(ime);
			final JTextField jt = new JTextField((String) vrednost);
			j.setPreferredSize(new Dimension(100, 30));
			jt.setEditable(!(par.isRo()));
			promeni = new JButton("+");
			promeni.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JFileChooser chooser = new JFileChooser();
					chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					File filter = null;
					int returnVal = 0;
					returnVal = chooser.showOpenDialog(MyFrame.getInstance());
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						filter = chooser.getSelectedFile();
						jt.setText(filter.getAbsolutePath());
						
					}
					if(jt.getText() != izabraniProizvod.getDestination())
						destinacijaPromenjena = jt.getText();
				}
			});
			jp.add(j);
			jp.add(jt);
			jp.add(promeni);
			boxCentar.add(jp);
			p.add(boxCentar);
		}

	}
	
	public void initComponents(){
		setTitle(resourceBundle.getString("naslovApp"));
		next.setText(MyFrame.getInstance().getResourceBundle().getString("next"));
		back.setText(MyFrame.getInstance().getResourceBundle().getString("back"));
		finish.setText(MyFrame.getInstance().getResourceBundle().getString("installandfinish"));
		
	
}

	public void changeLanguage() {
		resourceBundle = ResourceBundle.getBundle("MessageResources.MessageResources", Locale.getDefault());
		initComponents();
	}

	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	public void setResourceBundle(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
	}

}

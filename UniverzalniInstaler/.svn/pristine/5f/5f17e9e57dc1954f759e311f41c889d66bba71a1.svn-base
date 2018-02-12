package konfiguracioniRezim.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import konfiguracioniRezim.controller.CancelActionListener;
import konfiguracioniRezim.controller.MyFocusListener;
import konfiguracioniRezim.controller.MyMouseListener;
import konfiguracioniRezim.model.Parameter;
import konfiguracioniRezim.model.Product;
import konfiguracioniRezim.model.Wizard;
import konfiguracioniRezim.model.Workspace;

public class DialogParametar extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private JButton save;
	private JButton cancel;
	private JTextField imet;
	private JTextField tipt;
	private JTextField vredt;
	final JPanel vrednost;
	private JTextField brpant;
	final JComboBox<String> cbxTipParametra;
	private JButton ok;
	private JLabel imel;
	private JLabel labela;
	private JLabel readOnly;
	JLabel labVidljiv;
	JLabel labMandatory;
	private JButton dodaj;
	private JButton dodajFile;
	private JTextArea area;
	private JLabel tipl;
	private JLabel vredl;
	private JLabel brpanl;
	private JLabel label;
	private BufferedImage image;
	private ImageIcon icon;
	private JScrollPane scroll;
	private JRadioButton trueBtn;
	public JRadioButton getTrueBtn() {
		return trueBtn;
	}

	public void setTrueBtn(JRadioButton trueBtn) {
		this.trueBtn = trueBtn;
	}

	private JRadioButton falseBtn;
	public JRadioButton getFalseBtn() {
		return falseBtn;
	}

	public void setFalseBtn(JRadioButton falseBtn) {
		this.falseBtn = falseBtn;
	}

	private ButtonGroup group;
	JCheckBox cbx; // za readonly
	JCheckBox cbx1; // za visibility
	JCheckBox cbx2; // za filling mandatory

	private static ResourceBundle resourceBundle;
	
	public JCheckBox getCbx() {
		return cbx;
	}

	public void setCbx(JCheckBox cbx) {
		this.cbx = cbx;
	}

	public JCheckBox getCbx1() {
		return cbx1;
	}

	public void setCbx1(JCheckBox cbx1) {
		this.cbx1 = cbx1;
	}

	public JCheckBox getCbx2() {
		return cbx2;
	}

	public void setCbx2(JCheckBox cbx2) {
		this.cbx2 = cbx2;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public JPanel getVrednost() {
		return vrednost;
	}

	public JLabel getLabel() {
		return label;
	}

	public JButton getSave() {
		return save;
	}

	public void setSave(JButton save) {
		this.save = save;
	}

	public JButton getCancel() {
		return cancel;
	}

	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}

	public JTextField getImet() {
		return imet;
	}

	public JTextField getTipt() {
		return tipt;
	}

	public JTextField getVredt() {
		return vredt;
	}

	public JTextField getBrpant() {
		return brpant;
	}

	public JComboBox<String> getCbxTipParametra() {
		return cbxTipParametra;
	}

	public JButton getDodaj() {
		return dodaj;
	}

	public void setDodaj(JButton dodaj) {
		this.dodaj = dodaj;
	}

	public JButton getDodajFile() {
		return dodajFile;
	}

	public void setDodajFile(JButton dodajFile) {
		this.dodajFile = dodajFile;
	}

	public JTextArea getArea() {
		return area;
	}

	public void setArea(JTextArea area) {
		this.area = area;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DialogParametar(Frame parent, String title, boolean modal) {
		
		super(parent, MyApp.getInstance().getResourceBundle().getString("titleParameter"), modal);
		setSize(450, 600);
		setLocationRelativeTo(parent);
		label = new JLabel();
		setLayout(new BorderLayout());
		resourceBundle = ResourceBundle.getBundle("MessageResources.MessageResources", Locale.getDefault());

		JPanel gornji = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		gornji.setPreferredSize(new Dimension(400, 50));
		add(gornji, BorderLayout.NORTH);

		JPanel donji = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		donji.setPreferredSize(new Dimension(400, 35));
		add(donji, BorderLayout.SOUTH);

		cancel = new JButton(MyApp.getInstance().getResourceBundle().getString("btnCancel"));
		ok = new JButton(MyApp.getInstance().getResourceBundle().getString("btnOk"));
		donji.add(ok);
		donji.add(cancel);
		JPanel ime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		imel = new JLabel(MyApp.getInstance().getResourceBundle().getString("namPar"));
		imet = new JTextField("Uneti ovde...", 20);
		imet.setName("ime");
		imet.addFocusListener(new MyFocusListener(imet));
		imet.addMouseListener(new MyMouseListener(imet));

		ime.add(imel);
		ime.add(imet);

		JPanel atributi = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    readOnly = new JLabel(MyApp.getInstance().getResourceBundle().getString("rOnly"));
		cbx = new JCheckBox(MyApp.getInstance().getResourceBundle().getString("Yes"));
		atributi.add(readOnly);
		atributi.add(cbx);

		JPanel panVidljiv = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    labVidljiv = new JLabel(MyApp.getInstance().getResourceBundle().getString("visibility"));
		cbx1 = new JCheckBox(MyApp.getInstance().getResourceBundle().getString("Yes"));
		panVidljiv.add(labVidljiv);
		panVidljiv.add(cbx1);

		JPanel panMandatory = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    labMandatory = new JLabel(MyApp.getInstance().getResourceBundle().getString("filling"));
		cbx2 = new JCheckBox(MyApp.getInstance().getResourceBundle().getString("Yes"));
		panMandatory.add(labMandatory);
		panMandatory.add(cbx2);

		JPanel tip = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tipl = new JLabel(MyApp.getInstance().getResourceBundle().getString("type"));
		tip.add(tipl);
		cbxTipParametra = new JComboBox();
		cbxTipParametra.addItem("short text");
		cbxTipParametra.addItem("text");
		cbxTipParametra.addItem("boolean");
		cbxTipParametra.addItem("filechooser");
		cbxTipParametra.addItem("image");

		// kl = new KeyListenerDialog();
		cbxTipParametra.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					int temp = cbxTipParametra.getSelectedIndex();
					if (temp == 0) {
						dodajFile.setVisible(false);
						dodaj.setVisible(false);
						vredt.setVisible(true);
						scroll.setVisible(false);
						label.setVisible(false);
						trueBtn.setVisible(false);
						falseBtn.setVisible(false);
					} else if (temp == 1) {
						scroll.setVisible(true);
						dodaj.setVisible(false);
						vredt.setVisible(false);
						dodajFile.setVisible(false);
						label.setVisible(false);
						trueBtn.setVisible(false);
						falseBtn.setVisible(false);
					} else if (temp == 4) {
						scroll.setVisible(false);
						dodaj.setVisible(true);
						vredt.setVisible(false);
						dodajFile.setVisible(false);
						label.setVisible(true);
					} else if (temp == 3) {
						scroll.setVisible(false);
						dodaj.setVisible(false);
						vredt.setVisible(true);
						dodajFile.setVisible(true);
						label.setVisible(false);
						trueBtn.setVisible(false);
						falseBtn.setVisible(false);
					} else if (temp == 2) {
						scroll.setVisible(false);
						dodaj.setVisible(false);
						vredt.setVisible(false);
						dodajFile.setVisible(false);
						label.setVisible(false);
						trueBtn.setVisible(true);
						falseBtn.setVisible(true);
					}
				}
			}
		});
		tip.add(cbxTipParametra);
		dodaj = new JButton("+");
		dodaj.setVisible(false);
		dodajFile = new JButton("+");
		dodajFile.setVisible(false);
		area = new JTextArea("!!!", 4, 20);
		scroll = new JScrollPane(area);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(false);

		labela = new JLabel(MyApp.getInstance().getResourceBundle().getString("defaultLabel"));
		labela.setFont(new Font("Times New Roman", 35, 12));
		tip.add(labela);	

		vrednost = new JPanel(new FlowLayout(FlowLayout.LEFT));
		//vrednost.setBackground(new Color(255, 238, 238));
		vredl = new JLabel(MyApp.getInstance().getResourceBundle().getString("vrPar"));
		vredt = new JTextField(20);

		trueBtn = new JRadioButton(MyApp.getInstance().getResourceBundle().getString("true"));
		falseBtn = new JRadioButton(MyApp.getInstance().getResourceBundle().getString("false"));
		group = new ButtonGroup();
		group.add(trueBtn);
		group.add(falseBtn);
		trueBtn.setVisible(false);
		falseBtn.setVisible(false);
		
		vrednost.add(vredl);
		vrednost.add(label);
		vrednost.add(scroll);
		vrednost.add(vredt);
		vrednost.add(dodaj);
		vrednost.add(dodajFile);
		vrednost.add(trueBtn);
		vrednost.add(falseBtn);

		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(0));
		boxCentar.add(ime);
		boxCentar.add(atributi);
		boxCentar.add(panVidljiv);
		boxCentar.add(panMandatory);
		boxCentar.add(tip);
		boxCentar.add(vrednost);
		// boxCentar.add(brPanela);
		boxCentar.add(Box.createGlue());
		add(boxCentar, BorderLayout.CENTER);

		cancel.addActionListener(new CancelActionListener(this));

		dodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// deo za dodavanje slike
				JFileChooser chooser = new JFileChooser();
				chooser.addChoosableFileFilter(
						new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes()));
				int returnVal = chooser.showOpenDialog(MyApp.getInstance());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File slika = chooser.getSelectedFile();
					try {
						image = ImageIO.read(slika);
						Image img = (Image) image;
						icon = new ImageIcon(img);
						img = img.getScaledInstance(50, 80, Image.SCALE_SMOOTH);
						ImageIcon temp = new ImageIcon(img);
						label.setIcon(temp);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					vrednost.revalidate();
					vrednost.repaint();
				}
			}
		});
		
		dodajFile.addActionListener(new ActionListener() {
			// deo za dodavanje fajla i foldera
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				File filter = null;
				int returnVal = chooser.showOpenDialog(MyApp.getInstance());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					filter = chooser.getSelectedFile();
					vredt.setText(filter.getAbsolutePath());
				}
			}
		});

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object selectedNode = MyApp.getInstance().getTree().getLastSelectedPathComponent();
				// ako je selektovan wizard onda je u pitanju dodavanje novog
				// parametra
				// ako je selektovan parametar u pitanju je izmjena postojeceg
				// parametra
				if (checkFields(selectedNode)) {
					Wizard w = (Wizard) MyApp.getInstance().getTree().getLastSelectedPathComponent();
					String namePar = imet.getText();
					ArrayList<Parameter> params = new ArrayList<>();
					params = w.getListParameters();
					// ime mora biti jedinstveno
					for (Parameter pmt : params) {
						if (pmt.getParamName().equals(namePar)) {
							
							JOptionPane.showMessageDialog(frame, resourceBundle.getString("upozorenje2"), resourceBundle.getString("upozorenje3"),2);

						}
					}

					Parameter par = new Parameter(namePar);
					par.setParent(w);

					par.setParamType(cbxTipParametra.getSelectedIndex());
					par.setRo(cbx.isSelected());
					par.setJeVidljiv(cbx1.isSelected());
					par.setObaveznoPopunjavanje(cbx2.isSelected());
					// postavljanje vrijednosti u zavisnosti od tipa
					if (par.getParamType() == 0) {
						par.setValue(vredt.getText());
					} else if (par.getParamType() == 1) {
						par.setValue(area.getText());
					} else if (par.getParamType() == 2) {
						par.setValue(trueBtn.isSelected());
					} else if (par.getParamType() == 3) {
						par.setValue(vredt.getText());
					} else if (par.getParamType() == 4) {
						// par.setValue(image);
						par.setSlika(icon);
					}

					par.addObserver(MyApp.getInstance().getModelTree());
					w.dodaj(par);

					System.out.println(vredt.getText());
					System.out.println("dodat je parametar sa sledecim vrijednostima: ");
					System.out.println("ime " + par.getParamName());
					System.out.println("tip " + par.getParamType());
					System.out.println("vrijednost " + par.getValue());
					System.out.println("read only " + par.isRo());
					System.out.println("vidljiv" + par.isJeVidljiv());
					System.out.println("obavezno popunjavanje " + par.isObaveznoPopunjavanje());

					setVisible(false);
				}

			

				else if (selectedNode instanceof Parameter) {

					Parameter parUpdate = (Parameter) selectedNode;
					parUpdate.setParamName(imet.getText());
					parUpdate.setParamType(cbxTipParametra.getSelectedIndex());
					parUpdate.setRo(cbx.isSelected());
					parUpdate.setJeVidljiv(cbx1.isSelected());
					parUpdate.setObaveznoPopunjavanje(cbx2.isSelected());
					// postavljanje vrijednosti u zavisnosti od tipa
					if (parUpdate.getParamType() == 0) {
						parUpdate.setValue(vredt.getText());
					} else if (parUpdate.getParamType() == 1) {
						parUpdate.setValue(area.getText());
					} else if (parUpdate.getParamType() == 2) {
						parUpdate.setValue(trueBtn.isSelected());
					} else if (parUpdate.getParamType() == 3) {
						if(parUpdate.getParent().getParent().getWizards().get(0).getListParameters().get(0)==parUpdate) {
							parUpdate.getParent().getParent().setDestination(vredt.getText());
							System.out.println("promenjena destinacija instalacije");
						}
						if(parUpdate.getParent().getParent().getWizards().get(0).getListParameters().get(1)==parUpdate) {
							parUpdate.getParent().getParent().setLocation(vredt.getText());
							System.out.println("promenjena lokacija za instalaciju");
						}
	
						parUpdate.setValue(vredt.getText());
					} else if (parUpdate.getParamType() == 4) {
						// par.setValue(image);
						parUpdate.setSlika(icon);
					}
					setVisible(false);
				}
			}

		});

	}

	public boolean checkFields(Object sn) {
		if (imet.getText().equals("") || imet.getText().equals("Uneti ovde...")) {
			
			JOptionPane.showMessageDialog(frame, resourceBundle.getString("upozorenje1"), resourceBundle.getString("upozorenje3"),2);
			return false;
			
		} else if (sn instanceof Wizard) {
			return true;
		} else {
			return false;
		}

	}
	
	public void initComponents() {
		
		labela.setText(resourceBundle.getString("defaultLabel"));
		ok.setText(resourceBundle.getString("btnOk"));
		cancel.setText(resourceBundle.getString("btnCancel"));
		setTitle(resourceBundle.getString("titleParameter"));
		imel.setText(resourceBundle.getString("namPar"));
		readOnly.setText(resourceBundle.getString("rOnly"));
		labVidljiv.setText(resourceBundle.getString("visibility"));
		labMandatory.setText(resourceBundle.getString("filling"));
		tipl.setText(resourceBundle.getString("type"));
		vredl.setText(resourceBundle.getString("vrPar"));
		resourceBundle.getString("upozorenje1");
		resourceBundle.getString("upozorenje2");
		resourceBundle.getString("upozorenje3");
		cbx.setText(resourceBundle.getString("Yes"));
		cbx1.setText(resourceBundle.getString("Yes"));
		cbx2.setText(resourceBundle.getString("Yes"));
		trueBtn.setText(resourceBundle.getString("true"));
		falseBtn.setText(resourceBundle.getString("false"));
	}

}

package konfiguracioniRezim.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import konfiguracioniRezim.controller.CancelActionListener;
import konfiguracioniRezim.controller.MyFocusListener;
import konfiguracioniRezim.controller.MyMouseListener;
import konfiguracioniRezim.model.Product;
import konfiguracioniRezim.model.Wizard;

@SuppressWarnings("serial")
public class DialogWizard extends JDialog {
	
	private ResourceBundle resourceBundle = ResourceBundle.getBundle("MessageResources.MessageResources",
			Locale.getDefault());
	
	JFrame frame;

	JButton ok;
	JButton cancel;
	JLabel name;
	private JTextField txtname;
	private BufferedImage image;
	private JLabel label;

	public JButton getOk() {
		return ok;
	}

	public void setOk(JButton ok) {
		this.ok = ok;
	}

	public JButton getCancel() {
		return cancel;
	}

	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}

	public void setName(JLabel name) {
		this.name = name;
	}

	public JTextField getTxtname() {
		return txtname;
	}

	public void setTxtname(String string) {
		this.txtname.setText(string);
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public DialogWizard(Frame parent, String title, boolean modal) {

		super(parent, MyApp.getInstance().getResourceBundle().getString("titleWizard"), modal);
		setSize(400, 300);
		setLocationRelativeTo(parent);

		setLayout(new BorderLayout());

		JPanel gornji = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		gornji.setPreferredSize(new Dimension(400, 50));
		add(gornji, BorderLayout.NORTH);

		JPanel donji = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		add(donji, BorderLayout.SOUTH);

		cancel = new JButton(MyApp.getInstance().getResourceBundle().getString("btnCancel"));
		cancel.addActionListener(new CancelActionListener(this));
		ok = new JButton(MyApp.getInstance().getResourceBundle().getString("btnOk"));
		donji.add(ok);
		donji.add(cancel);

		JPanel ime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		name = new JLabel(MyApp.getInstance().getResourceBundle().getString("nameWiz"));
		txtname = new JTextField("Uneti ovde...", 20);
		txtname.setName("name");
		txtname.addFocusListener(new MyFocusListener(txtname));
		txtname.addMouseListener(new MyMouseListener(txtname));
		
		ime.add(name);
		ime.add(txtname);

		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(0));
		boxCentar.add(ime);
		// boxCentar.add(ikonica);
		boxCentar.add(Box.createGlue());
		add(boxCentar, BorderLayout.CENTER);

		// dodaj.addActionListener(new ChooserImgActionListener(icon, image,
		// lblIkonica));
		
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object selectedNode = MyApp.getInstance().getTree().getLastSelectedPathComponent();
				//ako je selektovan proizvod onda je u pitanju dodavanje novog wizarda
				//ako je selektovan wizard u pitanju je izmjena postojeceg wizarda
				if(checkFields(selectedNode)){
					Product prod = (Product) MyApp.getInstance().getTree().getLastSelectedPathComponent();
					Wizard wiz = new Wizard(txtname.getText(), prod);
					wiz.addObserver(MyApp.getInstance().getModelTree());
					prod.dodaj(wiz);
	
					setVisible(false);
				}
				else if(selectedNode instanceof Wizard){
					Wizard wUpdate = (Wizard)selectedNode;
					wUpdate.setName(txtname.getText());
					setVisible(false);
				}
			}

		});
	}
	
	public boolean checkFields(Object sn) {
		if(sn instanceof Product &&  (txtname.getText().equals("") || txtname.getText().equals("Uneti ovde..."))) {
			
			JOptionPane.showMessageDialog(frame, resourceBundle.getString("upozorenje1"), resourceBundle.getString("upozorenje3"),2);
			return false;
			
		} else {
			return true;
		}
	}
	
	public void initComponents(){
		ok.setText(resourceBundle.getString("btnOk"));
		cancel.setText(resourceBundle.getString("btnCancel"));
		setTitle(resourceBundle.getString("titleWizard"));
		name.setText(resourceBundle.getString("nameWiz"));
		resourceBundle.getString("upozorenje1");
		resourceBundle.getString("upozorenje3");
		
	}

}

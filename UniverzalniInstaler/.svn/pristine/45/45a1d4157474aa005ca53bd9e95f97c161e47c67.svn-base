package konfiguracioniRezim.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.UUID;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import konfiguracioniRezim.controller.CancelActionListener;
import konfiguracioniRezim.controller.ChooserActionListener;
import konfiguracioniRezim.controller.MyFocusListener;
import konfiguracioniRezim.controller.MyMouseListener;
import konfiguracioniRezim.model.Parameter;
import konfiguracioniRezim.model.Product;
import konfiguracioniRezim.model.Wizard;
import konfiguracioniRezim.model.Workspace;

@SuppressWarnings("serial")
public class DialogProduct extends JDialog {

	private ResourceBundle resourceBundle = ResourceBundle.getBundle("MessageResources.MessageResources",
			Locale.getDefault());
	
	private JFrame frame = null;

	JButton ok;
	JButton cancel;
	JLabel name;
	JLabel dest;
	JLabel loc;
	JTextField txtname;
	JTextField txtloc;
	JButton dodaj;
	JButton dodajLoc;

	public JTextField getTxtname() {
		return txtname;
	}

	public void setTxtname(String string) {
		this.txtname.setText(string);
	}

	public JTextField getTxtdest() {
		return txtloc;
	}

	public void setTxtdest(String string) {
		this.txtloc.setText(string);
	}

	public DialogProduct(Frame parent, String title, boolean modal) {
		super(parent, MyApp.getInstance().getResourceBundle().getString("titleProduct"), modal);
		setSize(400, 300);
		setLocationRelativeTo(parent);

		setLayout(new BorderLayout());

		JPanel gornji = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		gornji.setPreferredSize(new Dimension(400, 50));
		add(gornji, BorderLayout.NORTH);

		JPanel donji = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		add(donji, BorderLayout.SOUTH);

		ok = new JButton(MyApp.getInstance().getResourceBundle().getString("btnOk"));
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Object selectedNode = MyApp.getInstance().getTree().getLastSelectedPathComponent();

				// ako je selektovan workspace onda je u pitanju dodavanje novog
				// proizvoda
				// ako je selektovan proizvod u pitanju je izmjena postojeceg
				// proizvoda

				if (checkFields(selectedNode)) {
					Workspace w = (Workspace) MyApp.getInstance().getTree().getLastSelectedPathComponent();
					System.out.println("trenutno selektovani workspace je " + w);
					String se1 = txtname.getText();
					UUID uuid = UUID.randomUUID();
					Product p = new Product(new ArrayList<Wizard>(), se1, uuid);
					p.addObserver(MyApp.getInstance().getModelTree());
					p.setParent(w);
					p.setDestination(txtloc.getText()); // lokacija proizvoda,
														// koja se ne menja u
														// instalacionom rezimu
					// lokacija proizvoda, koja se ne menja u instalacionom
					// rezimu
					// setuj destinacije i lokacije
					// odavde

					Wizard temp = new Wizard("default", p);
					p.dodaj(temp);

					Parameter par = new Parameter("destinacija proizvoda");
					par.setJeVidljiv(true);
					par.setObaveznoPopunjavanje(false);
					par.setParamType(3);
					par.setParent(temp);
					par.setValue("D:/"+txtname.getText());
					p.setDestination("D:/"+txtname.getText());

					p.getWizardAt(0).dodaj(par);

					Parameter par2 = new Parameter("lokacija proizvoda");
					par2.setJeVidljiv(false);
					par2.setObaveznoPopunjavanje(false);
					par2.setParamType(3);
					par2.setParent(temp);
					par2.setValue(txtloc.getText());
					p.setLocation(txtloc.getText());

					p.getWizardAt(0).dodaj(par2);

					System.out.println("Lokacija: " + p.getLocation());
					System.out.println("Destinacija: " + p.getDestination());
					// do ovde

					w.dodaj(p);
					w.azurirajLokacije();

					System.out.println("U workspace " + w + "  je dodat proizvod " + p);

					setVisible(false);
				} else if (selectedNode instanceof Product) {
					Product pUpdate = (Product) selectedNode;
					pUpdate.setName(txtname.getText());
					pUpdate.setDestination(txtloc.getText());
					setVisible(false);
				}
			}
		});

		cancel = new JButton(MyApp.getInstance().getResourceBundle().getString("btnCancel"));
		cancel.addActionListener(new CancelActionListener(this));
		donji.add(ok);
		donji.add(cancel);

		JPanel ime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		name = new JLabel(MyApp.getInstance().getResourceBundle().getString("nameProduct"));
		txtname = new JTextField("Uneti ovde...", 20);
		txtname.setName("name");
		txtname.addFocusListener(new MyFocusListener(txtname));
		txtname.addMouseListener(new MyMouseListener(txtname));

		ime.add(name);
		ime.add(txtname);

		JPanel destPan = new JPanel(new FlowLayout(FlowLayout.LEFT));
		dest = new JLabel(MyApp.getInstance().getResourceBundle().getString("loc"));
		txtloc = new JTextField(20);
		txtloc.setName("txtdest");
		dodaj = new JButton("+");
		dodaj.addActionListener(new ChooserActionListener(txtloc));
		destPan.add(dest);
		destPan.add(txtloc);
		destPan.add(dodaj);

		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(0));
		boxCentar.add(ime);
		boxCentar.add(destPan);
		boxCentar.add(Box.createGlue());
		add(boxCentar, BorderLayout.CENTER);

	}

	public boolean checkFields(Object sn) {
		if (txtname.getText().equals("") || txtname.getText().equals("Uneti ovde...") || txtloc.getText().equals("")) {
			
			JOptionPane.showMessageDialog(frame, resourceBundle.getString("upozorenje1"), resourceBundle.getString("upozorenje3"),2);
			return false;
			
		} else if (sn instanceof Workspace) {
			return true;
		} else {
			return false;
		}

	}
	
	public void initComponents() {
		setTitle(resourceBundle.getString("titleProduct"));
		ok.setText(resourceBundle.getString("btnOk"));
		cancel.setText(resourceBundle.getString("btnCancel"));
		name.setText(resourceBundle.getString("nameProduct"));
		dest.setText(resourceBundle.getString("loc"));
		resourceBundle.getString("upozorenje1");
		resourceBundle.getString("upozorenje3");
	}

}

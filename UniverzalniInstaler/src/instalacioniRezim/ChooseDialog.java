package instalacioniRezim;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import konfiguracioniRezim.model.Product;
import konfiguracioniRezim.model.Workspace;
import konfiguracioniRezim.view.MyApp;

public class ChooseDialog extends JDialog {
	
	private ResourceBundle resourceBundle =  ResourceBundle.getBundle("MessageResources.MessageResources", Locale.getDefault());
	private Locale locale;
	
	private JFrame frame;
	private JLabel labelChoose;
	private JButton btnOk;
	private JButton btnCancel;
	private final JLabel labelWarning;
	private ArrayList<Product> products = new ArrayList<>();
	private Product izabraniProizvod = null;
	

	public Product getIzabraniProizvod() {
		return izabraniProizvod;
	}

	public void setIzabraniProizvod(Product izabraniProizvod) {
		this.izabraniProizvod = izabraniProizvod;
	}

	public ChooseDialog() {

		this(null, true);
		

	}

	public ChooseDialog(final JFrame parent, boolean modal) {

		super(parent, modal);

		setSize(new Dimension(300,150));
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);		
		
		setTitle(MyFrame.getInstance().getResourceBundle().getString("choose"));
		
		
		labelChoose = new JLabel(MyFrame.getInstance().getResourceBundle().getString("labelChoose"));

		btnOk = new JButton(MyFrame.getInstance().getResourceBundle().getString("btnOk"));
		btnCancel = new JButton(MyFrame.getInstance().getResourceBundle().getString("btnCancel"));
		labelWarning = new JLabel("");
		izabraniProizvod = null;
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel lpan = new JPanel();
		lpan.add(labelChoose);
		JPanel btnAndWarPan = new JPanel(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(btnOk);
		buttonPanel.add(btnCancel);
		btnAndWarPan.add(buttonPanel, BorderLayout.CENTER);
		btnAndWarPan.add(labelWarning, BorderLayout.SOUTH);

		@SuppressWarnings("rawtypes")

		JComboBox chooseList = new JComboBox();


		Workspace w;
		try {
			FileInputStream fis = new FileInputStream("datWorkspace.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			w = (Workspace) ois.readObject();
			products = w.getListProducts();
			fis.close();

		} catch (Exception e) {
		}
		
		for (int i = 0; i < products.size(); i++)
			chooseList.addItem(products.get(i));

		chooseList.setSelectedIndex(-1);
		chooseList.addItemListener(new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			if (arg0.getStateChange() == ItemEvent.SELECTED) {
				izabraniProizvod = (Product) chooseList.getSelectedItem();
				
			}
		}
		});

		JPanel centralPanel = new JPanel(new GridLayout(1, 2));

		centralPanel.add(chooseList);

		mainPanel.add(lpan, BorderLayout.NORTH);

		mainPanel.add(btnAndWarPan, BorderLayout.SOUTH);

		mainPanel.add(centralPanel, BorderLayout.CENTER);

		setLayout(new BorderLayout());

		add(mainPanel);

		setLocationRelativeTo(null);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		

		addWindowListener(new WindowAdapter() {  
	        @Override
	        public void windowClosing(WindowEvent e) {  
	        	//setVisible(false);
	        	parent.dispose();
	            System.exit(0);  
	        }  
	    });

		btnCancel.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				//parent.setVisible(false);
				parent.dispose();

				System.exit(0);

			}

		});

		btnOk.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				if (izabraniProizvod != null) 
					setVisible(false);
				else 
					JOptionPane.showMessageDialog(frame, resourceBundle.getString("upozorenje4"), resourceBundle.getString("upozorenje3"),2);

			}

		});

	}
	
	
	public void initComponents(){

		setTitle(resourceBundle.getString("choose"));
		labelChoose.setText(resourceBundle.getString("labelChoose"));
		btnOk.setText(resourceBundle.getString("btnOk"));
		btnCancel.setText(resourceBundle.getString("btnCancel"));
		labelWarning.setText(resourceBundle.getString("labelWarning"));	
		resourceBundle.getString("upozorenje4");
		resourceBundle.getString("upozorenje3");
		
	}
	
}

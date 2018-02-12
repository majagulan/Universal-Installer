package instalacioniRezim;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class LanguageDialogInstalacioni extends JDialog{
	
	ChooseDialog chooseDialog = new ChooseDialog();
	
	private ResourceBundle resourceBundle =  ResourceBundle.getBundle("MessageResources.MessageResources", Locale.getDefault());
	private Locale locale;

	private JRadioButton srpski;
	private JRadioButton engleski;
	private JButton ok;
	private JButton cancel;
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private ButtonGroup jezici;
	
	
	public LanguageDialogInstalacioni() {
		this(null, true);
	}
	
	public LanguageDialogInstalacioni(final JFrame parent, boolean modal) {
		
		super(parent, modal);
		
		setSize(new Dimension(180,180));
		setLocationRelativeTo(null);
		setResizable(false);
		
		setTitle(MyFrame.getInstance().getResourceBundle().getString("naslovIzaberiteOpcije"));
		
		srpski = new JRadioButton(MyFrame.getInstance().getResourceBundle().getString("btnSrpski"));
		engleski = new JRadioButton(MyFrame.getInstance().getResourceBundle().getString("btnEngleski"));
		jezici = new ButtonGroup();
		ok = new JButton(MyFrame.getInstance().getResourceBundle().getString("btnOk"));
		cancel = new JButton(MyFrame.getInstance().getResourceBundle().getString("btnCancel"));
		ok.setEnabled(false);
		
		panel1 = new JPanel(new GridLayout(2,1));
		panel1.add(srpski);
		panel1.add(engleski);
		panel1.setBorder(new EmptyBorder(10,5,10,70));
		
		panel2 = new JPanel(new GridLayout(1,2));		
		jezici.add(srpski);
		jezici.add(engleski);
		
		panel2 = new JPanel(new GridLayout(1,2));		
		panel2.add(ok);
		panel2.add(cancel);
		
		panel = new JPanel(new BorderLayout());
		panel.add(panel1, BorderLayout.NORTH);
		panel.add(panel2, BorderLayout.SOUTH);
		add(panel);
		

		addWindowListener(new WindowAdapter() {  
	        @Override
	        public void windowClosing(WindowEvent e) {  
	        	//parent.dispose();
	            System.exit(0);  
	        }  
	    });
		
		srpski.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				ok.setEnabled(true);
				Locale.setDefault(new Locale("sr", "RS"));
				locale = new Locale("sr", "RS");
				resourceBundle = ResourceBundle.getBundle("MessageResources.MessageResources", locale);
				initComponents();
				
			}
			
		});
		
		engleski.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				ok.setEnabled(true);
				Locale.setDefault(new Locale("en", "US"));
				locale = new Locale("en", "US");
				resourceBundle = ResourceBundle.getBundle("MessageResources.MessageResources", locale);
				initComponents();
				
			}
			
		});
		
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {	
				//chooseDialog.initComponents();
				//chooseDialog.setVisible(true);	
				
                parent.setVisible(true);
                setVisible(false);

			}
			
		});
		
		cancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				  setVisible(false);
		          //parent.dispose();
		          System.exit(0);
				
			}
			
		});
		
	}
		
	public void initComponents(){
		
		setTitle(resourceBundle.getString("naslovIzaberiteOpcije"));
		srpski.setText(resourceBundle.getString("btnSrpski"));
		engleski.setText(resourceBundle.getString("btnEngleski"));
		ok.setText(resourceBundle.getString("btnOk"));
		cancel.setText(resourceBundle.getString("btnCancel"));
	
	}

	
}


package konfiguracioniRezim.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.WindowConstants;

import konfiguracioniRezim.controller.ReadFromFile;
import konfiguracioniRezim.controller.SelectionListener;
import konfiguracioniRezim.model.Parameter;
import konfiguracioniRezim.model.Product;
import konfiguracioniRezim.model.Wizard;
import konfiguracioniRezim.model.Workspace;
import konfiguracioniRezim.segments.MyMenuBar;
import konfiguracioniRezim.segments.MyToolBar;

@SuppressWarnings("serial")
public class MyApp extends JFrame {

	// MyApp je singletone klasa, dakle moze postojati nijedna ili jedna
	// instanca
	// klase MyApp
	private static MyApp instance = null;

	private LanguageDialogKonfiguracioni languageDialog;

	private static ResourceBundle resourceBundle;

	private MyMenuBar menu;
	private MyToolBar tBar;
	private SouthPanel sp;
	private DialogWizard nwp;
	private DialogParametar npp;
	private DialogProduct nprop;
	private JTree tree;
	private JPanel panZero;
	private MyTree modelTree;

	private Workspace work;

	public Workspace getWork() {
		return work;
	}

	public void setWork(Workspace work) {
		this.work = work;
	}

	public MyTree getModelTree() {
		return modelTree;
	}

	public void setModelTree(MyTree modelTree) {
		this.modelTree = modelTree;
	}

	public JPanel getPanZero() {
		return panZero;

	}

	public void setPanZero(JPanel panZero) {
		this.panZero = panZero;
	}

	public void addNewPanelToPanzero(JPanel newPanel) {
		panZero.removeAll();
		panZero.add(newPanel);
		panZero.revalidate();
		panZero.repaint();
	}

	public JTree getTree() {
		return tree;
	}

	public void setTree(JTree tree) {
		this.tree = tree;
	}


	// singletone konstruktor
	public static MyApp getInstance() {
		if (instance == null) {
			instance = new MyApp();
			instance.initialise();
			MyApp.getInstance().changeLanguage();
		}
		return instance;
	}

	private MyApp() {
		Locale.setDefault(new Locale("en", "US"));
		resourceBundle = ResourceBundle.getBundle("MessageResources.MessageResources", Locale.getDefault());
	}

	private void initialise() {

		languageDialog = new LanguageDialogKonfiguracioni(this, true);
		languageDialog.setVisible(true);

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth / 2, screenHeight / 2);
		setTitle(resourceBundle.getString("naslovApp"));
		setResizable(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Image img = kit.getImage("images/main.png");
		setIconImage(img);

		menu = new MyMenuBar();
		this.setJMenuBar(menu);

		tBar = new MyToolBar();
		add(tBar, BorderLayout.NORTH);

		sp = new SouthPanel();
		add(sp, BorderLayout.SOUTH);

		panZero = new JPanel();
		panZero.setBorder(BorderFactory.createLineBorder(Color.red));

		add(panZero, BorderLayout.CENTER);

		/*
		 * JPanel panCenter = new JPanel();
		 * panCenter.setBorder(BorderFactory.createLineBorder(Color.yellow));
		 * 
		 * BoxLayout boxCenter = new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		 * panCenter.setLayout(boxCenter);
		 */

		work = ReadFromFile.readFromFile();

		tree = new JTree();
		modelTree = new MyTree(work, tree);
		work.addObserver(modelTree);
		//dodavanje observera na ucitane podatke iz datoteke
		ArrayList<Product> products = work.getListProducts();
		for (Product p : products) {
			p.addObserver(modelTree);
			ArrayList<Wizard> wizards = p.getWizards();
			for (Wizard wiz : wizards) {
				wiz.addObserver(modelTree);
				ArrayList<Parameter> parameters = wiz.getListParameters();
				for (Parameter par : parameters) {
					par.addObserver(modelTree);
				}
			}

		}

		tree.setModel(modelTree);
		tree.setCellRenderer(new TreeCellRendered());
		tree.addTreeSelectionListener(new SelectionListener(this, panZero, npp,
				nwp));

		JScrollPane scrollPane = new JScrollPane(tree,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(200, 325));
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.gray));
		add(scrollPane, BorderLayout.WEST);

	}

	public void changeLanguage() {
		resourceBundle = ResourceBundle.getBundle("MessageResources.MessageResources", Locale.getDefault());
		setTitle(resourceBundle.getString("naslovApp"));
		menu.initComponents();
	}

	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	public void setResourceBundle(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
	}

}

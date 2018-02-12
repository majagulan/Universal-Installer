package konfiguracioniRezim.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;
import java.util.UUID;

import javax.swing.tree.TreeNode;



@SuppressWarnings("serial")
public class Workspace extends Observable implements TreeNode, Serializable {

	private ArrayList<Product> listProducts = new ArrayList<>();
	private static Workspace instance = null;

	public Workspace() {
		super();
	}

	public ArrayList<Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(ArrayList<Product> listProducts) {
		this.listProducts = listProducts;
	}

	public Workspace(ArrayList<Product> listProducts) {
		super();
		this.listProducts = listProducts;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Workspace";
	}

	@Override
	public Enumeration children() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TreeNode getChildAt(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildCount() {

		return listProducts.size();
	}

	@Override
	public int getIndex(TreeNode arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

	public void dodaj(Product p) {

		listProducts.add(p);
		setChanged();
		notifyObservers();

	}

	public void dodajNaLok(Product p, int i) {
		listProducts.add(i, p);
		notifyObservers();
	}

	public void izbrisi(Product p) {
		listProducts.remove(p);
		setChanged();
		notifyObservers();
		System.out.println("pozvana metoda izbrisi iz Workspace-a");
	}

	public void reload() {
		setChanged();
		notifyObservers();

	}

	public int getProductCount() {
		return listProducts.size();
	}

	public Product getProductAt(int index) {
		return listProducts.get(index);
	}

	public Product getProductUsingID(UUID id) {
		for (int i = 0; i < listProducts.size(); i++) {
			if (listProducts.get(i).getId().equals(id))
				return listProducts.get(i);
		}
		return null;
	}

	public void printWC() {
		for (int i = 0; i < listProducts.size(); i++) {
			System.out.println(listProducts.get(i).ispisi());
		}
	}

	public static Workspace getInstance() {
		if (instance == null) {

			instance = new Workspace();
		}
		return instance;
	}
	
	public void azurirajLokacije() {
		for (int i = 0; i < listProducts.size(); i++) {
			ArrayList<Wizard> listWiz = listProducts.get(i).getWizards();
			for (int j = 0; j < listWiz.size(); j++) {
				listWiz.get(j).setWizLoc(i);
			}
		}
	}

}

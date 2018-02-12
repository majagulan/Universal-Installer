package konfiguracioniRezim.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;
import java.util.UUID;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.tree.TreeNode;



public class Wizard extends Observable implements Serializable, TreeNode{
	
	private UUID id;
	private String name;
	private ArrayList<Parameter> listParameters = new ArrayList<>();
	private ImageIcon ikonica;
	private int wizLoc;
	private Product parent;
	
	
	
	
	
	
	

	public void setParent(Product parent) {
		this.parent = parent;
	}

	public int getWizLoc() {
		return wizLoc;
	}

	public void setWizLoc(int wizLoc) {
		this.wizLoc = wizLoc;
	}

	public Wizard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Wizard(String name, Product parent) {
		super();
		this.name = name;
		this.parent = parent;
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}

	public Icon getIkonica() {
		return ikonica;
	}

	public void setIkonica(ImageIcon ikonica) {
		this.ikonica = ikonica;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Parameter> getListParameters() {
		return listParameters;
	}

	public void setListParameters(ArrayList<Parameter> listParameters) {
		this.listParameters = listParameters;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Override
	public Enumeration children() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public TreeNode getChildAt(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIndex(TreeNode arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product getParent() {
		// TODO Auto-generated method stub
		return parent;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void dodaj(Parameter p) {
		listParameters.add(p);
		setChanged();
		hasChanged();
		notifyObservers();
	}
	
	public void izbrisi(Parameter p) {
		listParameters.remove(p);
		setChanged();
		notifyObservers();
	}
	
	public int getParamCount() {
		return listParameters.size();
	}

	public Parameter getParamAt(int index) {
		return listParameters.get(index);
	}

	public String ispisi() {
		String str = name + "\n";

		for (int i = 0; i < listParameters.size(); i++) {
			str = str + listParameters.get(i).toString() + "\n";
		}
		return str;

	}

	
}

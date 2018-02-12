package konfiguracioniRezim.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;
import java.util.UUID;

import javax.swing.tree.TreeNode;

public class Product extends Observable implements Serializable, TreeNode {

	private ArrayList<Wizard> wizards = new ArrayList<>();
	private String name;
	private UUID id;
	private Workspace parent;
	private String destination; //mjesto gdje se kopira proizvod
	private String location; //lokacija fajla sa koga se instalira
	//dodaj ikonicu
	
	

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setParent(Workspace parent) {
		this.parent = parent;
	}

	public Product(String string, int i) {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(ArrayList<Wizard> wizards, String name, UUID id) {
		super();
		this.wizards = wizards;
		this.name = name;
		this.id = id;
	}

	public Product(String name) {
		super();
		this.name = name;
	}

	public ArrayList<Wizard> getWizards() {
		return wizards;
	}

	public void setWizards(ArrayList<Wizard> wizards) {
		this.wizards = wizards;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Wizard getWizardAt(int index) {
		return wizards.get(index);
	}

	public int getWizardCount() {
		return wizards.size();
	}

	public void reload() {
		setChanged();
		notifyObservers();

	}

	public void dodaj(Wizard w) {
		wizards.add(w);
		setChanged();
		hasChanged();
		notifyObservers();
	}

	public void izbrisi(Wizard w) {
		wizards.remove(w);
		setChanged();
		notifyObservers();
	}

	public Wizard getWizAt(int index) {
		return wizards.get(index);
	}

	public String ispisi() {
		String str = name + "\n";

		for (int i = 0; i < wizards.size(); i++) {
			str = str + wizards.get(i).toString() + "\n";
		}
		return str;

	}

	public Wizard getWizardUsingID(UUID id) {
		for (int i = 0; i < wizards.size(); i++) {
			if (wizards.get(i).getId().equals(id))
				return wizards.get(i);
		}
		return null;
	}

	@Override
	public String toString() {
		return name;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIndex(TreeNode arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Workspace getParent() {
		// TODO Auto-generated method stub
		return parent;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

}

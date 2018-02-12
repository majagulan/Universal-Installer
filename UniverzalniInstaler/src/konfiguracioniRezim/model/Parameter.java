package konfiguracioniRezim.model;



import java.io.Serializable;
import java.util.Observable;

import javax.swing.ImageIcon;

public class Parameter extends Observable implements Serializable {

	private String paramName; //jedinstven
	private int paramType;
	//0=kraci tekst
	//1=tekst
	//2=boolean
	//3=filechooser
	//4=image
	private int paramLoc;
	private Object value; //u zavisnosti od tipa
	private boolean ro; //read only
	private Wizard parent;
	private boolean jeVidljiv;
	private boolean obaveznoPopunjavanje;
	private ImageIcon slika;
	
	
	
	

	public ImageIcon getSlika() {
		return slika;
	}

	public void setSlika(ImageIcon slika) {
		this.slika = slika;
	}

	public Wizard getParent() {
		return parent;
	}

	public void setParent(Wizard parent) {
		this.parent = parent;
	}

	
	
	public Parameter(String paramName, int paramType, int paramLoc, Object value, boolean ro, Wizard parent,
			boolean jeVidljiv, boolean obaveznoPopunjavanje) {
		super();
		this.paramName = paramName;
		this.paramType = paramType;
		this.paramLoc = paramLoc;
		this.value = value;
		this.ro = ro;
		this.parent = parent;
		this.jeVidljiv = jeVidljiv;
		this.obaveznoPopunjavanje = obaveznoPopunjavanje;
	}

	public Parameter(String name){
		this.paramName = name;
	}
	
	

	public boolean isRo() {
		return ro;
	}



	public void setRo(boolean ro) {
		this.ro = ro;
	}



	public boolean isJeVidljiv() {
		return jeVidljiv;
	}

	public void setJeVidljiv(boolean jeVidljiv) {
		this.jeVidljiv = jeVidljiv;
	}

	public boolean isObaveznoPopunjavanje() {
		return obaveznoPopunjavanje;
	}

	public void setObaveznoPopunjavanje(boolean obaveznoPopunjavanje) {
		this.obaveznoPopunjavanje = obaveznoPopunjavanje;
	}

	public Parameter(String paramName, int paramLoc) {
		super();
		this.paramName = paramName;
		this.paramLoc = paramLoc;
	}


	@Override
	public String toString() {
		return paramName;
	}

	public String getParamName() {
		return paramName;
	}
	

	public void setParamName(String paramName) {
		this.paramName = paramName;
		setChanged();
		hasChanged();
		notifyObservers();
	}

	public int getParamType() {
		return paramType;
	}
	
	public void reload(){
		setChanged();
		notifyObservers();
		
	}

	public void setParamType(int paramType) {
		this.paramType = paramType;
		setChanged();
		hasChanged();
		notifyObservers();
	}
	
	public void setLok(int i) {
		this.paramLoc = i;
	}

	public int getParamLoc() {
		return paramLoc;
	}

	public void setParamLoc(int paramLoc) {
		this.paramLoc = paramLoc;
		setChanged();
		hasChanged();
		notifyObservers();
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		
		this.value = value;
		setChanged();
		hasChanged();
		notifyObservers();
	}

}

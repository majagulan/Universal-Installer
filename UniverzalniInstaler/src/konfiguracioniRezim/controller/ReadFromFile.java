package konfiguracioniRezim.controller;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import konfiguracioniRezim.model.Product;
import konfiguracioniRezim.model.Workspace;
import konfiguracioniRezim.view.MyApp;


public class ReadFromFile {
	
	private static Workspace w = MyApp.getInstance().getWork();
	
	
	
	public ReadFromFile() {
		super();
	}



	public static Workspace readFromFile() {

		try {
			FileInputStream fis = new FileInputStream("datWorkspace.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			w = (Workspace) ois.readObject();
			
			fis.close();
			

		} catch (Exception e) { }

		return w;
	}

}

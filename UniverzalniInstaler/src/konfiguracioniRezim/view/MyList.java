package konfiguracioniRezim.view;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class MyList extends JList<String> {
	
	MyList() {
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

}

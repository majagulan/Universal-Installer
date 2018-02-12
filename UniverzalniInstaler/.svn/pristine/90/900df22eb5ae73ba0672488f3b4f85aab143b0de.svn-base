package instalacioniRezim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InstalacijaActionListener implements ActionListener {

	private File src;
	private File dst;
	
	public InstalacijaActionListener(String st1, String st2, String name) {
		
		//baca exception ako se ne odradi da lokacija bude ovakve strukture
		String disk1 = st1.substring(0, 1);
		String disk2 = st2.substring(0, 1);
	
		st1 = st1.substring(3, st1.length());
		st1 = disk1+":/"+st1;
		
		st2 = st2.substring(3, st2.length());
		
		String st3 = disk2+":/"+st2;
		
		
		File dst1 = new File(st3);
		if(!dst1.exists())
			dst1.mkdir();
		
		
		st2 = disk2+":/"+st2+"/"+name;
		
		System.out.println("Instalira se sa " + st1);
		System.out.println("instalira se na " + st2);
		
		
		
		src = new File(st1);
		dst = new File(st2);
		
		
	}
	


	private void copyDirectory(File sr, File ds) throws IOException {
	    if (!ds.exists()) {
	        ds.mkdir();
	    }
	    
	    for (String f : src.list()) {
	        copyFile(new File(sr, f), new File(ds, f));
	    }
	}

	
	
	private void copyFile(File sr, File ds) throws IOException {        
	    try (
	            InputStream in = new FileInputStream(sr);
	            OutputStream out = new FileOutputStream(ds)
	    ) {
	        byte[] buf = new byte[1024];
	        int length;
	        while ((length = in.read(buf)) > 0) {
	            out.write(buf, 0, length);
	        }
	    }
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//instalacija....

		if (src.isDirectory()) {
	        try {
				copyDirectory(src,dst);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    } else {
	        try {
				copyFile(src,dst);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }	
		MyFrame.getInstance().dispose();
	}

}

package konfiguracioniRezim.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

import konfiguracioniRezim.view.MyApp;

public class ChooserImgActionListener implements ActionListener {

	private ImageIcon icon;
	private BufferedImage image;
	private JLabel label;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// deo za dodavanje slike
		JFileChooser chooser = new JFileChooser();
		chooser.addChoosableFileFilter(
				new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes()));
		int returnVal = chooser.showOpenDialog(MyApp.getInstance());
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File slika = chooser.getSelectedFile();
			try {
				image = ImageIO.read(slika);
				Image img = (Image) image;
				icon = new ImageIcon(img);
				img = img.getScaledInstance(50, 80, Image.SCALE_SMOOTH);
				ImageIcon temp = new ImageIcon(img);
				label.setIcon(temp);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
	}

	

	public ChooserImgActionListener(ImageIcon icon, BufferedImage image, JLabel label) {
		super();
		this.icon = icon;
		this.image = image;
		this.label = label;
	}

}

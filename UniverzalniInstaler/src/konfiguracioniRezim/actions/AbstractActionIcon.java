package konfiguracioniRezim.actions;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class AbstractActionIcon extends AbstractAction {

	private static final String PATH = "images/";
	public static final Dimension small = new Dimension(30, 30);
	public static final Dimension larger = new Dimension(32, 32);

	protected Icon iconGetter(String iconPath, Dimension size) {
		// size = new Dimension(24, 24);

		Icon i = new ImageIcon(new ImageIcon(PATH + iconPath).getImage()

				.getScaledInstance(size.height, size.width, Image.SCALE_SMOOTH));

		return i;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}

package omok.util;

import javax.swing.JOptionPane;

import omok.view.GUI;

public class MessageDialog {
	private GUI gui;
	
	public void winMessage(GUI gui, int color) {
		this.gui = gui;
		String colorKor = (color == 1)? "��" : "��";
		message(String.format("%s�� �¸�!", colorKor));
	}
	
	public void message(String msg) {
		JOptionPane.showMessageDialog(this.gui, msg, "", JOptionPane.INFORMATION_MESSAGE);
	}

}

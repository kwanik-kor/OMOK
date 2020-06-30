package omok.util;

import javax.swing.JOptionPane;

import omok.view.GUI;

public class MessageDialog {
	private GUI gui;
	
	public void winMessage(GUI gui, int color) {
		this.gui = gui;
		String colorKor = (color == 1)? "Èæ" : "¹é";
		message(String.format("%sµ¹ ½Â¸®!", colorKor));
	}
	
	public void sixStonesMessage(GUI gui) {
		this.gui = gui;
		message("À°¸ñÀº µÑ ¼ö ¾ø½À´Ï´Ù!");
	}
	
	public void message(String msg) {
		JOptionPane.showMessageDialog(this.gui, msg, "", JOptionPane.INFORMATION_MESSAGE);
	}

}

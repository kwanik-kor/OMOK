package omok.view;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GUI extends JFrame{
	private Container container;
	
	public GUI(String title) {
		container = getContentPane();
		container.setLayout(null);
		Dimension dim = new Dimension(700, 700);
		setTitle(title);
		setLocation(300, 100);
		setPreferredSize(dim);
		pack();
		setContentPane(new Board());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

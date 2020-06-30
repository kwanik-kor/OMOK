package omok.view;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

import omok.controller.GameController;
import omok.controller.MouseController;

@SuppressWarnings("serial")
public class GUI extends JFrame{
	private Container container;
	private MapSize size = new MapSize();
	private GameController gmc = new GameController();
	
	public GUI(String title) {
		container = getContentPane();
		container.setLayout(null);
		Dimension dim = new Dimension(650, 680);
		setTitle(title);
		setLocation(300, 100);
		setPreferredSize(dim);
		pack();
		Board board = new Board(size, gmc);
		setContentPane(board);
		MouseController mouse_event = new MouseController(gmc, size, board, this);
		addMouseListener(mouse_event);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

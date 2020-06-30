package omok.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import omok.controller.GameController;

@SuppressWarnings("serial")
public class Board extends JPanel {
	private MapSize size;
	private GameController gmc;
	private final int STONE_SIZE = 28;
	private int[][] map = new int[20][20];
	
	public Board(MapSize ms, GameController gmc) {
		setBackground(new Color(206, 167, 61));
		size = ms;
		this.gmc = gmc;
		setLayout(null);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		board(g);
		putStones(g);
	}
	
	public void board(Graphics g) {
		for(int i = 1; i<=size.getSize(); i++) {
			g.drawLine(size.getCell(), i*size.getCell(), size.getCell()*size.getSize(), i*size.getCell());
			g.drawLine(i*size.getCell(), size.getCell(), i*size.getCell(), size.getCell()*size.getSize());
		}
	}
	
	public void putStones(Graphics g) {
		for(int y = 0; y<size.getSize(); y++) {
			for(int x = 0; x<size.getSize(); x++) {
				int stoneType = gmc.getMap()[y][x];
				if(stoneType == 1)
					putBlack(g, y, x);
				else if(stoneType == 2)
					putWhite(g, y, x);
			}
		}
	}
	
	public void putBlack(Graphics g, int y, int x) {
		g.setColor(Color.BLACK);
		g.fillOval(x*size.getCell() + 15, y*size.getCell() + 15, STONE_SIZE, STONE_SIZE);
	}
	
	public void putWhite(Graphics g, int y, int x) {
		g.setColor(Color.WHITE);
		g.fillOval(x*size.getCell() + 15, y*size.getCell() + 15, STONE_SIZE, STONE_SIZE);
	}
}

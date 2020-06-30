package omok.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import omok.dto.Stone;
import omok.util.MessageDialog;
import omok.view.Board;
import omok.view.GUI;
import omok.view.MapSize;

public class MouseController extends MouseAdapter {
	private GameController gmc;
	private MapSize ms;
	private Board board;
	private GUI gui;
	private MessageDialog md = new MessageDialog();
	
	public MouseController(GameController gmc, MapSize ms, Board board, GUI gui) {
		this.ms = ms;
		this.board = board;
		this.gui = gui;
		this.gmc = gmc;
	}
	
	@Override
	public void mousePressed(MouseEvent me) {
		int x = (int)Math.round(me.getX()/(double)ms.getCell()) - 1;
		int y = (int)Math.round(me.getY()/(double)ms.getCell()) - 2;
		
		if(!gmc.isPossibleToPut(y, x)) {
			return;
		}
		
		//흑돌: 1, 백돌: 2 - cur_player 필드는  0, 1로 토글
		int cur_player = (gmc.getCurPlayer() == 0)? 2 : 1;
		Stone stone = new Stone(y, x, cur_player);
		gmc.placeStone(stone);
		gmc.togglePlayer();
		board.repaint();
		
		if(gmc.winCheck(stone)) {
			md.winMessage(gui, stone.getColor());
			gmc.init();
			board.repaint();
		}
		System.out.println("over");
	}
}

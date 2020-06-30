package omok.controller;

import java.util.LinkedList;
import java.util.Queue;

import omok.dto.Stone;
import omok.util.MessageDialog;
import omok.view.GUI;

public class GameController {
	private GUI gui;
	private final int MaxSize = 20;
	private int map[][] = new int[MaxSize][MaxSize];
	//y = -x / y = x / y = 0 / x = 0
	private int[] dy = {-1, 1, 1, -1, 0, 0, -1, 1};
	private int[] dx = {-1, 1, -1, 1, -1, 1, 0, 0};
	private int cur_player = 1; //»Êµπ Ω√¿€
	private MessageDialog message = new MessageDialog();
	
	public void init(GUI gui) {
		this.gui = gui;
		for(int i = 0; i<MaxSize; i++) {
			for(int j = 0; j<MaxSize; j++) {
				map[i][j] = 0;
			}
		}
	}
	
	public boolean winCheck(Stone stone) {
		int color = stone.getColor();
		for(int dir = 0; dir < 8; dir += 2) {
			int stoneCnt = 1;
			int ny = stone.getY();
			int nx = stone.getX();
			for(int i = 0; i < 4; i++) {
				ny += dy[dir];
				nx += dx[dir];
				if(ny < 0 || nx < 0 || ny >= MaxSize || nx >= MaxSize || map[ny][nx] != color) break;
				if(map[ny][nx] == color)
					stoneCnt++;
			}
			ny = stone.getY();
			nx = stone.getX();
			for(int i = 0; i < 4; i++) {
				ny += dy[dir + 1];
				nx += dx[dir + 1];
				if(ny < 0 || nx < 0 || ny >= MaxSize || nx >= MaxSize || map[ny][nx] != color) break;
				if(map[ny][nx] == color)
					stoneCnt++;
			}
			if(stoneCnt == 5)
				return true;
		}
		return false;
	}
	
	public void placeStone(Stone stone) {
		map[stone.getY()][stone.getX()] = stone.getColor();
	}
	
	public boolean isPossibleToPut(Stone stone) {
		int y = stone.getY();
		int x = stone.getX();
		if(y < 0 || x < 0 || y >= MaxSize || x >= MaxSize || map[y][x] != 0) 
			return false;
		if(isSixthStone(stone))
			return false;
		//ªÔªÔ, ¿∞∏Ò ∏∑æ∆æﬂµ 
		return true;
	}
	
	public boolean isSixthStone(Stone stone) {
		for(int dir = 0; dir < 8; dir += 2) {
			int length = 1;
			//«—¬ πÊ«‚ count
			Queue<Stone> q = new LinkedList<Stone>();
			q.add(stone);
			while(!q.isEmpty()) {
				Stone now = q.poll();
				int ny = now.getY() + dy[dir];
				int nx = now.getX() + dx[dir];
				int color = now.getColor();
				if(ny < 0 || nx < 0 || ny >= MaxSize || nx >= MaxSize || map[ny][nx] != color)
					break;
				if(map[ny][nx] == stone.getColor()) {
					length++;
					q.add(new Stone(ny, nx, color));
				}
			}
			
			if(length > 5) {
				message.sixStonesMessage(gui);
				return true;
			}
			
			//π›¥ÎπÊ«‚ count
			q.clear();
			q.add(stone);
			while(!q.isEmpty()) {
				Stone now = q.poll();
				int ny = now.getY() + dy[dir + 1];
				int nx = now.getX() + dx[dir + 1];
				int color = now.getColor();
				if(ny < 0 || nx < 0 || ny >= MaxSize || nx >= MaxSize || map[ny][nx] != color)
					break;
				if(map[ny][nx] == stone.getColor()) {
					length++;
					q.add(new Stone(ny, nx, color));
				}
			}
			
			if(length > 5) {
				message.sixStonesMessage(gui);
				return true;
			}
		}
		return false;
	}
	
	public void togglePlayer() {
		this.cur_player ^= 1;
	}

	//getter, setter
	public int[][] getMap() {
		return this.map;
	}
	
	public int getCurPlayer() {
		return this.cur_player;
	}
	
	public void setCurPlayer(int player) {
		this.cur_player = player;
	}
}

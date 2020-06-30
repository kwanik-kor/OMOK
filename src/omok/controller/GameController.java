package omok.controller;

import omok.dto.Stone;

public class GameController {
	private final int MaxSize = 20;
	private int map[][] = new int[MaxSize][MaxSize];
	private int cur_player = 1; //»Êµπ Ω√¿€
	
	public void init() {
		for(int i = 0; i<MaxSize; i++) {
			for(int j = 0; j<MaxSize; j++) {
				map[i][j] = 0;
			}
		}
	}
	
	public boolean winCheck(Stone stone) {
		int color = stone.getColor();
		//y = -x / y = x / y = 0 / x = 0
		int[] dy = {-1, 1, 1, -1, 0, 0, -1, 1};
		int[] dx = {-1, 1, -1, 1, -1, 1, 0, 0};
		
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
	
	public void togglePlayer() {
		this.cur_player ^= 1;
	}
	
	public boolean isPossibleToPut(int y, int x) {
		if(y < 0 || x < 0 || y >= MaxSize || x >= MaxSize || map[y][x] != 0) return false;
		//ªÔªÔ, ¿∞∏Ò ∏∑æ∆æﬂµ 
		return true;
	}
	
	public int[][] getMap() {
		return this.map;
	}
	
	public int getCurPlayer() {
		return this.cur_player;
	}
}

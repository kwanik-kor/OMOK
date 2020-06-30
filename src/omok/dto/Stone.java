package omok.dto;

public class Stone {
	private int y;
	private int x;
	private int color;
	
	public Stone(int y, int x, int color) {
		super();
		this.y = y;
		this.x = x;
		this.color = color;
	}
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Stone [y=" + y + ", x=" + x + ", color=" + color + "]";
	}
	
}

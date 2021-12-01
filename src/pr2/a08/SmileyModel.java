package pr2.a08;

import java.awt.Point;

public class SmileyModel {
	
	protected int head;
	protected int eyes;
	protected int pupils;
	protected boolean smile;
	protected Point background;
	
	public SmileyModel(int head, int eyes, int pupils, boolean smile, Point background) {
		super();
		this.head = head;
		this.eyes = eyes;
		this.pupils = pupils;
		this.smile = smile;
		this.background = background;
	}

	public int getHead() {
		return head;
	}

	public void setHead(int head) {
		this.head = head;
	}

	public int getEyes() {
		return eyes;
	}

	public void setEyes(int eyes) {
		this.eyes = eyes;
	}

	public int getPupils() {
		return pupils;
	}

	public void setPupils(int pupils) {
		this.pupils = pupils;
	}

	public boolean isSmile() {
		return smile;
	}

	public void setSmile(boolean smile) {
		this.smile = smile;
	}

	public Point getBackground() {
		return background;
	}

	public void setBackground(Point background) {
		this.background = background;
	}
}

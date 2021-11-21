package pr2.a05;

import java.awt.Color;
import java.awt.Graphics;

public class Gitter {
	protected Color color;
	protected int dx;
	protected int dy;

	public Gitter(Color color, int dx, int dy) {
		this.color = color;
		this.dx = dx;
		this.dy = dy;
	}

	public Gitter(int dx, int dy) {
		this(Color.YELLOW, dx, dy);
	}

	public Gitter() {
		this(Color.YELLOW, 100, 100);
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color colour) {
		this.color = colour;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		for (int i = 0; i <= 1000; i += dx) {
			g.drawLine(i, 0, i, 1000);
		}
		for (int a = 0; a <= 1000; a += dy) {
			g.drawLine(0, a, 1000, a);
		}
		g.setColor(Color.BLUE);
		g.drawLine(0, 0, 0, 1000);
		g.drawLine(0, 0, 1000, 0);
	}
}
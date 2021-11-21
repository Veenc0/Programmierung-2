package pr2.a05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GitterTest {

	public static void main(String[] args) {
		DrawFrame frame = new DrawFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}

	private static class DrawFrame extends JFrame {
		public DrawFrame() {
			setTitle("Gitter");
			setLayout(new BorderLayout());
			add(new OOPDrawingPanel(), BorderLayout.CENTER);
		}
	}

	private static class OOPDrawingPanel extends JPanel {
		protected Gitter gitter;
		protected Gitter secondgitter;
		protected Rectangle2D rect;
		protected Ellipse2D oval;
		protected Ellipse2D oval2;

		public OOPDrawingPanel() {
			gitter = new Gitter(Color.BLUE, 100, 100);
			secondgitter = new Gitter(Color.MAGENTA, 25, 25);
			rect = new Rectangle2D.Double(100, 100, 400, 50);
			oval = new Ellipse2D.Double(100, 300, 100, 100);
			oval2 = new Ellipse2D.Double(20, 420, 160, 160);
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setPaint(Color.BLUE);
			g2.fill(oval);
			g2.setPaint(Color.BLACK);
			g2.draw(oval);
			g2.setPaint(Color.YELLOW);
			g2.fill(oval2);
			g2.setPaint(Color.RED);
			g2.draw(oval2);
			secondgitter.draw(g);
			gitter.draw(g);
			g2.setPaint(Color.GREEN);
			g2.draw(rect);
		}
	}
}
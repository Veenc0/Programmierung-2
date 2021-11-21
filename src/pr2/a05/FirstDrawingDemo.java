package pr2.a05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FirstDrawingDemo {

	public static void main(String[] args) {
		DrawFrame frame = new DrawFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}

	private static class DrawFrame extends JFrame {
		public DrawFrame() {
			setTitle("Simple Drawing Frame");
			setLayout(new BorderLayout());
//			add(new ProceduralDrawingPanel(), BorderLayout.CENTER); // prozedurale
			add(new OOPDrawingPanel(), BorderLayout.CENTER); // objektorientierte
		}
	}

//	private static class ProceduralDrawingPanel extends JPanel {  // prozedurale Programmierstil
//		@Override
//		protected void paintComponent(Graphics g) {
//			super.paintComponent(g);
//			g.setColor(Color.GREEN);
//			g.drawRect(100, 100, 400, 50);
//			g.setColor(Color.GREEN);
//			g.drawOval(100, 300, 100, 100);
//			g.setColor(Color.BLUE);
//			g.fillOval(100, 300, 100, 100);
//			g.setColor(Color.BLACK);
//			g.drawOval(100, 500, 160, 160);
//			g.setColor(Color.YELLOW);
//			g.fillOval(100, 500, 160, 160);
//			g.setColor(Color.RED);
//			g.drawOval(100, 500, 160, 160);
//		}
//	}

	private static class OOPDrawingPanel extends JPanel { // objektorientierte Programmierstil
		protected Rectangle2D rect;
		protected Ellipse2D oval;
		protected Ellipse2D oval2;

		public OOPDrawingPanel() {
			rect = new Rectangle2D.Double(100, 100, 400, 50);
			oval = new Ellipse2D.Double(100, 300, 100, 100);
			oval2 = new Ellipse2D.Double(100, 500, 160, 160);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setPaint(Color.GREEN);
			g2.draw(rect);
			g2.setPaint(Color.BLUE);
			g2.fill(oval);
			g2.setPaint(Color.BLACK);
			g2.draw(oval);
			g2.setPaint(Color.YELLOW);
			g2.fill(oval2);
			g2.setPaint(Color.RED);
			g2.draw(oval2);
			drawingShapes(g2);
		}

		protected void drawingShapes(Graphics2D g2) {
			g2.translate(600, 100);
			g2.setPaint(Color.MAGENTA);
			g2.fill(oval);
			g2.setPaint(Color.RED);
			g2.draw(oval);
		}
	}
}
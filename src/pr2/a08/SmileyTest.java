package pr2.a08;

import java.awt.BorderLayout;
import java.awt.Point;
import javax.swing.JFrame;

public class SmileyTest {
	
	public static void main(String[] args) {
		DrawFrame frame = new DrawFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}

	private static class DrawFrame extends JFrame {
		public DrawFrame() {
			Point point = new Point (100, 100);
			SmileyModel smileyModel = new SmileyModel(400, 30, true, point);
			setTitle("Smiley Drawing");
			setLayout(new BorderLayout());
			add(new SmileyView(smileyModel), BorderLayout.CENTER);
		}
	}
}
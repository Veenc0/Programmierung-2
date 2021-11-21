package pr2.a06;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class ColorPanelTest {
	
	public static void main(String[] args) {
		DrawFrame frame = new DrawFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}

	private static class DrawFrame extends JFrame {
		public DrawFrame() {
			setTitle("RGB VALUES");
			setLayout(new BorderLayout());
			add(new ColorPanel(Colors.farbmap), BorderLayout.CENTER);
		//	add(new ColorPanel(new String [] {"Babyblue"}),BorderLayout.CENTER); um zu probieren, dass bei unbekannten Namen Magenta als Farbe ausgegeben wird
		}
	}
}
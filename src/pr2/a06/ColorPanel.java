package pr2.a06;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JPanel;

public class ColorPanel extends JPanel {

	public Map<String, Color> secondmap;

	public ColorPanel(Map<String, Color> colormap) {
		this.secondmap = colormap;
	}

	public ColorPanel(String[] cssColorNames) {
		this.secondmap = Colors.createMapByName(cssColorNames);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ArrayList<String> farbtabelle = new ArrayList<String>();
		int x = 0;
		int y = 40;
		for (String key : secondmap.keySet()) {
			farbtabelle.add(key);
		}
		for (int i = 0; i < secondmap.size(); i++) {
			g.setColor(Colors.createByName(farbtabelle.get(i)));
			g.fillRect(150, y, 60, 20);
			g.drawString(farbtabelle.get(i), 240, y + 15);
			x += 50;
			y += 20;
		}
	}
}
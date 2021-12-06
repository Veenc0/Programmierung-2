package pr2.a08;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import pr2.a06.Colors;

public class SmileyView extends JPanel{

	SmileyModel smileyModel;
	public SmileyView(SmileyModel smileyModel) {
		this.smileyModel = smileyModel;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawHead(g);
		drawEyes(g);
		drawPupils(g);
		drawSmile(g);
//		drawGlasses(g,Color.BLACK, smileyModel.getBackground());
		drawHat(g); // frewillig zum testen
	}
	
	protected void drawHead(Graphics g) {
		g.setColor(Color.ORANGE);
		int head = smileyModel.getHead() * 2;
		g.fillOval((int) smileyModel.getBackground().getX(), (int) smileyModel.getBackground().getY(), head, head);	
	} 
	
	protected void drawEyes(Graphics g) {
		g.setColor(Color.WHITE);
		int eyes = smileyModel.getEyes() * 2;   // Durchmesser von Augenradius
		int head = smileyModel.getHead();		// Kopfradius 
		int x = (int) (smileyModel.getBackground().getX() + head - head /3 - eyes/2);   // x position von linke Auge
		int x2 = (int) (smileyModel.getBackground().getX() + head + head /3 - eyes/2);  // x position von rechte Auge
		int y = (int) (smileyModel.getBackground().getY() + head- head /2);	   // y position von beide Augen
		g.fillOval(x, y, eyes, eyes);
		g.fillOval(x2, y , eyes, eyes);
	}
	
	protected void drawPupils(Graphics g) {
		g.setColor(Color.GREEN);
		int eyes = smileyModel.getEyes()/3; 
		int head = smileyModel.getHead();
		int pupils = smileyModel.getPupils()/3;
		int x = (int) (smileyModel.getBackground().getX() + head - head/3 + pupils); // x position von linke pupile
		int x2= (int) (smileyModel.getBackground().getX() + head + head/3 - eyes );  // x position von rechte pupile
		int y = (int) (smileyModel.getBackground().getY() + head - head/2 + eyes - pupils); // y position von beide Pupilen
		g.fillOval(x, y, eyes, eyes);
		g.fillOval(x2, y, eyes, eyes);
	}
	
	protected void drawSmile(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		int head = smileyModel.getHead();
		int x = (int) smileyModel.getBackground().getX() + head - head/3;
		int y = (int) smileyModel.getBackground().getY() + head + head/3;
		int smilewidth = (head / 3) * 2;
		int smileheight = head / 3;
		if (smileyModel.isSmile()) {
			g.fillArc(x, y, smilewidth, smileheight, 180, 180);    //smile
		} else {
			g.fillArc(x, y, smilewidth, smileheight, 180, -180);   // frawn
		}
	}
	
	protected void drawHat(Graphics g) {    // nur so zum testen
		g.setColor(Color.BLUE);
		int head = smileyModel.getHead();
		int x = (int) (smileyModel.getBackground().getX() + head/3);
		int y = (int) (smileyModel.getBackground().getY());
		int hatwidth  = (int) ((head *2) * 0.67); // 0.67 von Formel für Arc Länge: 2*r * sin(winkel/2)
		int hatheight = head/2;
		g.fillArc(x, y, hatwidth, hatheight, 180, -180);
	}	
}

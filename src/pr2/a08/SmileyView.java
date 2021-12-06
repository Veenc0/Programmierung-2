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
	// SmileyModel als Attribut 
	// paintComponent Methode implementieren mit der das SmileyModel gezeichnet wird
	// Funktionale Dekomposition : Die Zeichenmethode in Teilmethoden aufteilen (drawEyes())
		
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawHead(g);
		drawEyes(g);
		drawPupils(g);
		drawSmile(g);
//		drawGlasses(g,Color.BLACK, smileyModel.getBackground());
//		drawHat(g,Color.BLACK, smileyModel.getBackground());
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
		int x = (int) (smileyModel.getBackground().getX() + (int) head - (int) head /3);   // x position von linke Auge
		int x2 = (int) (smileyModel.getBackground().getX() + (int) head + (int) head /3);  // x position von rechte Auge
		int y = (int) (smileyModel.getBackground().getY() + (int) head- (int) head /2);		// y position von beide Augen
		g.fillOval(x - smileyModel.getEyes(), y, eyes, eyes);
		g.fillOval(x2 - smileyModel.getEyes(), y , eyes, eyes);
	}
	
	protected void drawPupils(Graphics g) {
		g.setColor(Color.GREEN);
		int eyes = smileyModel.getEyes() / 3;
		int head = smileyModel.getHead();
		int x = (int) (smileyModel.getBackground().getX() + (int) head - (int)head/3 + (int) smileyModel.getPupils()/3);
		int x2= (int) (smileyModel.getBackground().getX() + (int) head + (int)head/3 - (int) smileyModel.getEyes()/3 );
		int y = (int) (smileyModel.getBackground().getY() + (int) head - (int) head/2 + (int) smileyModel.getEyes()/3 - (int) smileyModel.getPupils()/3 );
		g.fillOval(x, y, eyes, eyes);
		g.fillOval(x2, y, eyes, eyes);
//		g.fillOval(background.x+148, background.y+90 , eyes, eyes);
	}
	
	protected void drawSmile(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		int head = smileyModel.getHead();
		int x = (int) smileyModel.getBackground().getX() + head - head/3;
		int y = (int) smileyModel.getBackground().getY() + head + head/3;
		int smilewidth = (head/3)*2;
		int smileheight = head/3;
		if (smileyModel.isSmile()) {
		g.fillArc(x, y, smilewidth, smileheight, 180, 180);
		} else {
			g.fillArc(x, y, smilewidth, smileheight, 180, -180);
		}
	}
	
//	protected void drawGlasses(Graphics g, Color color, Point background) {
//		g.setColor(color);
//		g.drawOval(background.x+135, background.y+65 , 7 * smileyModel.getEyes() , 7 * smileyModel.getEyes());
//		g.drawOval(background.x+60, background.y+65 , 7 * smileyModel.getEyes() , 7 * smileyModel.getEyes());
//		g.drawLine(background.x+10, background.y+84, 110, 150);
//		g.drawLine(background.x+205, background.y+97, 296, 140);
//		g.drawLine(background.x+135, background.y+100, 180, 150);
//	}
//	
//	protected void drawHat(Graphics g, Color color, Point background) {
//		g.setColor(color);
//		g.fillArc(background.x+20, background.y, 200, 100, 190, -180);
//		g.fillOval(background.x+90, background.y-8, 12, 12);
//	}
//	
}

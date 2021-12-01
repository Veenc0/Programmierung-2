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
	//paintComponent Methode implementieren mit der das SmileyModel gezeichnet wird
	// Funktionale Dekomposition : Die Zeichenmethode in Teilmethoden aufteilen (drawEyes())
		
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawHead(g, Color.ORANGE, smileyModel.getBackground());
		drawEyes(g, Color.WHITE, smileyModel.getBackground());
		drawPupils(g, Color.GREEN, smileyModel.getBackground());
		drawSmile(g, Color.DARK_GRAY, smileyModel.getBackground(), smileyModel.isSmile());
		drawGlasses(g,Color.BLACK, smileyModel.getBackground());
		drawHat(g,Color.BLACK, smileyModel.getBackground());
		
	}
	
	protected void drawHead(Graphics g, Color color, Point background) {
		g.setColor(color);
		g.fillOval(background.x, background.y, 250, 250);	
	}
	
	protected void drawEyes(Graphics g, Color color, Point background) {
		g.setColor(color);
		g.fillOval(background.x+140, background.y+70 , 5 * smileyModel.getEyes() , 5 * smileyModel.getEyes());
		g.fillOval(background.x+70, background.y+70 , 5 * smileyModel.getEyes() , 5 * smileyModel.getEyes());
	}
	
	protected void drawPupils(Graphics g, Color color, Point background) {
		g.setColor(color);
		g.fillOval(background.x+98, background.y+90 , 1 * smileyModel.getEyes() , 1 * smileyModel.getEyes());
		g.fillOval(background.x+148, background.y+90 , 1 * smileyModel.getEyes() , 1 * smileyModel.getEyes());

	}
	
	protected void drawSmile(Graphics g, Color color, Point background, Boolean frawn) {
		g.setColor(color);
		if (frawn ==true) {
		g.fillArc(background.x+100, background.y+140, 50, 100, 180, -180);
		} else {
			g.fillArc(background.x+100, background.y+125, 50, 100, 180, 180);
		}
	}
	
	protected void drawGlasses(Graphics g, Color color, Point background) {
		g.setColor(color);
		g.drawOval(background.x+135, background.y+65 , 7 * smileyModel.getEyes() , 7 * smileyModel.getEyes());
		g.drawOval(background.x+60, background.y+65 , 7 * smileyModel.getEyes() , 7 * smileyModel.getEyes());
		g.drawLine(background.x+10, background.y+84, 110, 150);
		g.drawLine(background.x+205, background.y+97, 296, 140);
		g.drawLine(background.x+135, background.y+100, 180, 150);
	}
	
	protected void drawHat(Graphics g, Color color, Point background) {
		g.setColor(color);
		g.fillArc(background.x+20, background.y, 200, 100, 190, -180);
		g.fillOval(background.x+90, background.y-8, 12, 12);
	}
	
}

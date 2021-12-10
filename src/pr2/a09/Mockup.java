package pr2.a09;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import a08.SmileyModel;
import a08.SmileyView;

public class Mockup {
	
	public static void main(String[] args) {
		DrawFrame frame = new DrawFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}

	private static class DrawFrame extends JFrame {
		public DrawFrame() {
			Point point = new Point (200, 200);      
			SmileyModel smileyModel = new SmileyModel(150, 40, true, point);
			setTitle("Smiley Drawing");
			setLayout(new BorderLayout());
			getContentPane().add(new Buttons(), BorderLayout.WEST);
//			getContentPane().add(new Buttons(), BorderLayout.CENTER);
//			getContentPane().add(Menubar(), BorderLayout.NORTH);
//			getContentPane().add(new Toolbar(Color.YELLOW), BorderLayout.SOUTH);
			getContentPane().add(new SmileyView(smileyModel), BorderLayout.CENTER);
			getContentPane().add(new Slider(), BorderLayout.EAST);
			getContentPane().add(Toolbar(), BorderLayout.SOUTH);	
//		    getContentPane().add(new Menubar(getMenuBar()), BorderLayout.NORTH);
		    setJMenuBar(Menubar());

		}

	}
	
	public static JMenuBar Menubar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu x = new JMenu("File");
		JMenu x2 = new JMenu("Edit");
		JMenu x3 = new JMenu("Window");
		JMenu x4 = new JMenu("Help");
		JMenuItem speichern = new  JMenuItem("Speichern");
		JMenuItem editMenu = new  JMenuItem("Edit"); 
		JMenuItem aboutMenu = new  JMenuItem("About");
		JMenuItem linkMenu = new  JMenuItem("Links");
		JMenuItem undoTyping = new  JMenuItem("Undo Typing");
		JMenuItem newWindow = new  JMenuItem("New Window");
		JMenuItem Preferences = new  JMenuItem("Preferences");
		JMenuItem Search = new  JMenuItem("Search");
	    x.add(linkMenu);
	    x.add(speichern);
	    x.add(aboutMenu);
	    x.add(editMenu);
	    x2.add(undoTyping);
	    x3.add(newWindow);
	    x3.add(Preferences);
	    x4.add(Search);
		menuBar.add(x);
		menuBar.add(x2);
		menuBar.add(x3);
		menuBar.add(x4);
		return menuBar;
	}
	
	@SuppressWarnings("unchecked")
	public static JToolBar Toolbar() {
		JToolBar tb = new JToolBar();
        JPanel p = new JPanel();
        JComboBox<Object> x = new JComboBox<Object>(new String[] {"Complete Face", "Hat", "Left Eye", "Right Eye" });
        JButton b1 = new JButton("Undo");
        JButton b2 = new JButton("Redo");
        p.add(b1);
        p.add(b2);
        p.add(x);
        tb.add(p);
        return tb;
	}
	
	
	public static class Buttons extends JPanel {
		public Buttons() {
			setPreferredSize(new Dimension(200,100));
			setLayout(new GridLayout(4,1));
			setBackground(Color.BLUE);
			JButton button = new JButton();
			button.setText("SMILE");
			button.setFont(new Font("Comic Sans", Font.BOLD, 25));
			add(button);
			JButton button2 = new JButton();
			button2.setText("FRAWN");
			button2.setFont(new Font("Comic Sans", Font.BOLD, 25));
			add(button2);
//			add(new JButton("FRAWN"));
			add(new JButton("ZOOM IN"));
			add(new JButton("ZOOM OUT"));

		}
	}
	
//	public static class Menubar extends JPanel {
//		public Menubar(Color color) {
//			setPreferredSize(new Dimension(800,50));
//			setBackground(color);
//			setLayout(new FlowLayout());
//			add(new JLabel(""));
//			add(new JLabel("frawn"));
//			add(new JLabel("neutral"));		
//		}	
//	}
//	
//	public static class Toolbar extends JPanel {
//		public Toolbar(Color color) {
//			setPreferredSize(new Dimension(800,50));
//			setBackground(color);
//			setLayout(new FlowLayout());
//			add(new JLabel("File"));
//			add(new JLabel("frawn"));
//			add(new JLabel("neutral"));		
//		}	
//	}
	
	public static class Slider extends JPanel {
		public Slider() {
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 10, 100, 30);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(20);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		add(slider);  
		
		}
	}
	public static class MenuMy extends JPanel {   //not fucking working
	 JMenuBar menubar = new JMenuBar();

	  JMenu file = new JMenu("File");

	  public MenuMy() {
	    file.setMnemonic(KeyEvent.VK_F);

	    JMenuItem fileClose = new JMenuItem("Close");
	    fileClose.setMnemonic(KeyEvent.VK_C);
	    fileClose.setToolTipText("Exit application");
	    fileClose.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent event) {
	        System.exit(0);
	      }
	    });

	    file.add(fileClose);
	    menubar.add(file);

	    setSize(800, 50);
//	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setVisible(true);
	  }
	}
	
//	public static class Menubar extends JMenu {
//		public Menubar(Object object) {
//			JMenuBar menuBar = new JMenuBar();
//			JMenu x = new JMenu("File");
//			JMenu x2 = new JMenu("Edit");
//			JMenu x3 = new JMenu("Window");
//			JMenu x4 = new JMenu("Help");
//			JMenuItem speichern = new  JMenuItem("Speichern");
//			JMenuItem editMenu = new  JMenuItem("Edit"); 
//			JMenuItem aboutMenu = new  JMenuItem("About");
//			JMenuItem linkMenu = new  JMenuItem("Links");
//			JMenuItem undoTyping = new  JMenuItem("Undo Typing");
//			JMenuItem newWindow = new  JMenuItem("New Window");
//			JMenuItem Preferences = new  JMenuItem("Preferences");
//			JMenuItem Search = new  JMenuItem("Search");
//		    x.add(linkMenu);
//		    x.add(speichern);
//		    x.add(aboutMenu);
//		    x.add(editMenu);
//		    x2.add(undoTyping);
//		    x3.add(newWindow);
//		    x3.add(Preferences);
//		    x4.add(Search);
//			menuBar.add(x);
//			menuBar.add(x2);
//			menuBar.add(x3);
//			menuBar.add(x4);
//		}
//	}
}

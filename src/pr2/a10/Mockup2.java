package pr2.a10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import pr2.a08.SmileyModel;
import pr2.a08.SmileyView;
import pr2.a09.Mockup.Buttons;
import pr2.a09.Mockup.Slider;

public class Mockup2 {
	
	private static class Command {
		public final static String HEAD_SIZE_INC = "HEAD_SIZE_INC";
		public final static String HEAD_SIZE_DEC = "HEAD_SIZE_DEC";
		public final static String SMILE = "SMILE";
		public final static String FROWN = "FROWN";
		public final static String SLIDER = "SLIDER";
		public final static String SECOND_SLIDER = "SECOND_SLIDER";
	}
	
	public static void main(String[] args) {
		MockupFrame frame = new MockupFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 800);
		frame.setVisible(true);
	}

	private static class MockupFrame extends JFrame {
		public MockupFrame() {
			Point point = new Point(200, 200);
			SmileyModel smileyModel = new SmileyModel(150, 40, true, point);
			SmileyView smileyView = new SmileyView(smileyModel);
			
			setTitle("Smiley Drawing");
			setLayout(new BorderLayout());
			getContentPane().add(new ControlPanel(smileyModel, smileyView), BorderLayout.WEST);
			getContentPane().add(smileyView, BorderLayout.CENTER);
			getContentPane().add(Toolbar(), BorderLayout.SOUTH);
			setJMenuBar(Menubar());
//			getContentPane().add(new SliderAction(smileyModel, smileyView), BorderLayout.EAST);
//			getContentPane().add(getMenuBar(), BorderLayout.SOUTH);
//			setJMenuBar(getJMenuBar());
//			BorderLayout baba = new BorderLayout();
//			add(new SliderAction, BorderLayout.EAST);
//			getContentPane().add(new ControlPanel(smileyModel, smileyView),BorderLayout.EAST);
		//	getContentPane().add(new CommandAction(smileyModel, smileyView), BorderLayout.EAST);
//			getContentPane().add(Toolbar(), BorderLayout.SOUTH);
//			setJMenuBar(Menubar());
		}
	}
	
	public static JToolBar Toolbar() { // Toolbar
		JToolBar tb = new JToolBar();
		JPanel p = new JPanel();
		JComboBox<Object> x = new JComboBox<Object>(new String[] { "Complete Face", "Hat", "Left Eye", "Right Eye" });
		JButton b1 = new JButton("Undo");
		JButton b2 = new JButton("Redo");
		p.add(b1);
		p.add(b2);
		p.add(x);
		tb.add(p);
		return tb;
	}
	
	public static JMenuBar Menubar() { // Menubar
		JMenuBar menuBar = new JMenuBar();
		JMenu x = new JMenu("File");
		JMenu x2 = new JMenu("Edit");
		JMenu x3 = new JMenu("Window");
		JMenu x4 = new JMenu("Help");
		JMenuItem speichern = new JMenuItem("Speichern");
		JMenuItem editMenu = new JMenuItem("Edit");
		JMenuItem aboutMenu = new JMenuItem("About");
		JMenuItem linkMenu = new JMenuItem("Links");
		JMenuItem undoTyping = new JMenuItem("Undo Typing");
		JMenuItem newWindow = new JMenuItem("New Window");
		JMenuItem Preferences = new JMenuItem("Preferences");
		JMenuItem Search = new JMenuItem("Search");
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
	
	private static class ControlPanel extends JPanel {
		protected JButton incSize;
		protected JButton decSize;
		protected JButton smile;
		protected JButton frown;
		protected JSlider sliderSize;
		protected JSlider secondslider;
		protected SmileyModel model;
		protected SmileyView view;
	
	public ControlPanel(SmileyModel model, SmileyView view) {
		this.model = model;
		this.view = view;
		ActionListener listener = new CommandAction(model, view); // Buttons
		incSize = new JButton ("Increase Size");
		incSize.setActionCommand(Command.HEAD_SIZE_INC);
		incSize.addActionListener(listener);
		decSize = new JButton ("Decrease Size");
		decSize.setActionCommand(Command.HEAD_SIZE_DEC);
		decSize.addActionListener(listener);
		smile = new JButton ("Smile");
		smile.setActionCommand(Command.SMILE);
		smile.addActionListener(listener);
		frown = new JButton ("Frown");
		frown.setActionCommand(Command.FROWN);
		frown.addActionListener(listener);
		setLayout (new GridLayout(4,1));
		add(incSize);
		add(decSize);
		add(smile);
		add(frown);
		ChangeListener sliderListener = new SliderAction(model,view); // First Slider
		sliderSize = new JSlider (JSlider.VERTICAL, 10, 100, 30);
		sliderSize.setMajorTickSpacing(10);
		sliderSize.setMinorTickSpacing(1);
		sliderSize.setPaintTicks(true);
		sliderSize.setPaintLabels(true);
		sliderSize.setName(Command.SLIDER);
		sliderSize.addChangeListener(sliderListener);
		add(new JLabel ("Increase Head Size"));
		add(sliderSize);
		ChangeListener sliderListener2 = new SliderAction(model,view); // Second Slider
		secondslider = new JSlider (JSlider.VERTICAL, 10, 100, 100);
		secondslider.setMajorTickSpacing(10);
		secondslider.setMinorTickSpacing(1);
		secondslider.setPaintTicks(true);
		secondslider.setPaintLabels(true);
		secondslider.setName(Command.SECOND_SLIDER);
		secondslider.addChangeListener(sliderListener2);
		add(new JLabel ("Decrease Eyes Size"));
		add(secondslider);
		setBackground(Color.white);
	}		
}
	
	private static class CommandAction implements ActionListener {
		protected SmileyModel model;
		protected SmileyView view;
		
		public CommandAction (SmileyModel model, SmileyView view) {
			this.model = model;
			this.view = view;
		}
		public void actionPerformed(ActionEvent event) {
			String command = event.getActionCommand();
			
			switch (command) {
			case Command.HEAD_SIZE_INC:
			model.setHead((int) (model.getHead() * 1.5));
			view.repaint();
			break;
			case Command.HEAD_SIZE_DEC:
			model.setHead((int) (model.getHead() /1.5));
			view.repaint();	
			break;
			case Command.SMILE:
			model.setSmile(true);
			view.repaint();
			break;
			case Command.FROWN:
			model.setSmile(false);
			view.repaint();
			break;
		}
	}
}
	
	private static class SliderAction implements ChangeListener {
		protected SmileyModel model;
		protected SmileyView view;
		
		public SliderAction (SmileyModel model, SmileyView view) {
			this.model = model;
			this.view = view;
		}
		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider) e.getSource();
			JSlider source2 = (JSlider) e.getSource();
//			if (! (source instanceof JSlider)) {
//				return;
//			}
			JSlider slider = (JSlider) source;
			JSlider secondslider = (JSlider) source2;
			
			int value = slider.getValue();
			int value2 = secondslider.getValue();
//			String slidername2 = secondslider.getName();
			String slidername = slider.getName();
			int head = model.getHead();
			switch (slidername) {
				case Command.SLIDER:
				model.setHead((int) (value * 3));
				
				view.repaint();
			    break;
				case Command.SECOND_SLIDER:
//				model.setBackground((int) (model.getBackground().getX()));
				model.getHead();
				model.setEyes(value2);
				view.repaint();
				break;	
			}
		}
	}
}

package pr2.a10;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class Mockup2 {

	public static class Command {
		public final static String HEAD_SIZE_INC = "HEAD_SIZE_INC";
		public final static String HEAD_SIZE_DEC = "HEAD_SIZE_DEC";
		public final static String EYE_SIZE_INC = "EYE_SIZE_INC";
		public final static String EYE_SIZE_DEC = "EYE_SIZE_INC";
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
			JMenuBar menu = new MenuBar();
			JToolBar toolBar = new ToolBar();
			setTitle("Smiley Drawing");
			setLayout(new BorderLayout());
			getContentPane().add(new ControlPanel(smileyModel, smileyView), BorderLayout.WEST);
			getContentPane().add(smileyView, BorderLayout.CENTER);
			getContentPane().add(menu, BorderLayout.NORTH);
			getContentPane().add(toolBar, BorderLayout.SOUTH);
		}
	}

	public static class ToolBar extends JToolBar {
		protected JPanel panel;
		protected JToolBar toolBar;
		protected JButton firstButton;
		protected JButton secondButton;

		public ToolBar() {
			JComboBox<Object> x = new JComboBox<Object>(
					new String[] { "Complete Face", "Hat", "Left Eye", "Right Eye" });
			add(panel = new JPanel());
			add(toolBar = new JToolBar());
			panel.add(firstButton = new JButton("Zoom In"));
			panel.add(secondButton = new JButton("Zoom Out"));
			panel.add(x);
			toolBar.add(panel);
		}
	}

	public static class MenuBar extends JMenuBar { // Menubar
		protected JMenu firstmenu;
		protected JMenu secondmenu;
		protected JMenu thirdmenu;
		protected JMenu fourthmenu;
		protected JMenuItem speichern;
		protected JMenuItem editMenu;
		protected JMenuItem aboutMenu;
		protected JMenuItem linkMenu;
		protected JMenuItem undoTyping;
		protected JMenuItem newWindow;
		protected JMenuItem preferences;
		protected JMenuItem search;

		public MenuBar() {
			add(firstmenu = new JMenu("File"));
			add(secondmenu = new JMenu("Edit"));
			add(thirdmenu = new JMenu("Window"));
			add(fourthmenu = new JMenu("Help"));
			firstmenu.add(speichern = new JMenuItem("Speichern"));
			firstmenu.add(editMenu = new JMenuItem("Edit"));
			firstmenu.add(aboutMenu = new JMenuItem("About"));
			firstmenu.add(linkMenu = new JMenuItem("Links"));
			secondmenu.add(undoTyping = new JMenuItem("Undo Typing"));
			thirdmenu.add(newWindow = new JMenuItem("New Window"));
			thirdmenu.add(preferences = new JMenuItem("Preferences"));
			fourthmenu.add(search = new JMenuItem("Search"));
		}
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
			incSize = new JButton("Increase Size");
			incSize.setActionCommand(Command.HEAD_SIZE_INC);
			incSize.addActionListener(listener);
			decSize = new JButton("Decrease Size");
			decSize.setActionCommand(Command.HEAD_SIZE_DEC);
			decSize.addActionListener(listener);
			smile = new JButton("Smile");
			smile.setActionCommand(Command.SMILE);
			smile.addActionListener(listener);
			frown = new JButton("Frown");
			frown.setActionCommand(Command.FROWN);
			frown.addActionListener(listener);
			setLayout(new GridLayout(4, 1));
			add(incSize);
			add(decSize);
			add(smile);
			add(frown);
			ChangeListener sliderListener = new SliderAction(model, view);
			sliderSize = new JSlider(JSlider.VERTICAL, 10, 100, 30);
			sliderSize.setMajorTickSpacing(10);
			sliderSize.setMinorTickSpacing(1);
			sliderSize.setPaintTicks(true);
			sliderSize.setPaintLabels(true);
			sliderSize.setName(Command.SLIDER);
			sliderSize.addChangeListener(sliderListener);
			add(new JLabel("Increase Head Size"));
			add(sliderSize);
			setBackground(Color.white);
		}
	}

	public static class CommandAction implements ActionListener {
		protected SmileyModel model;
		protected SmileyView view;

		public CommandAction(SmileyModel model, SmileyView view) {
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
				model.setHead((int) (model.getHead() / 1.5));
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
			case Command.EYE_SIZE_INC:
				model.setEyes((int) (model.getEyes() * 1.5));
				view.repaint();
				break;
			}
		}
	}

	private static class SliderAction implements ChangeListener {
		protected SmileyModel model;
		protected SmileyView view;

		public SliderAction(SmileyModel model, SmileyView view) {
			this.model = model;
			this.view = view;
		}

		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider) e.getSource();
			if (!(source instanceof JSlider)) {
				return;
			}
			JSlider slider = (JSlider) source;
			int value = slider.getValue();
			String slidername = slider.getName();
			switch (slidername) {
			case Command.SLIDER:
				model.setHead((int) (value * 3));
				view.repaint();
				break;
			}
		}
	}
}
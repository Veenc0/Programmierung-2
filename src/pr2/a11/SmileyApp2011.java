package pr2.a11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
import pr2.a10.Mockup2.CommandAction;

// https://www.flaticon.com/free-icon/button_983907 PLUS ZEICHEN
//https://www.flaticon.com/premium-icon/minus_1665663?term=minus&page=1&position=3&page=1&position=3&related_id=1665663&origin=search MINUS ZEICHEN
//https://www.flaticon.com/free-icon/smile_747402?term=smile&page=1&position=2&page=1&position=2&related_id=747402&origin=search SMILE ICON
//https://www.flaticon.com/premium-icon/sad_158398?term=sad%20smiley&page=1&position=2&page=1&position=2&related_id=158398&origin=search SAD ICON

public class SmileyApp2011 {

	private static class Command {
		public final static String HEAD_SIZE_INC = "HEAD_SIZE_INC";
		public final static String HEAD_SIZE_DEC = "HEAD_SIZE_DEC";
		public final static String EYE_SIZE_INC = "EYE_SIZE_INC";
		public final static String EYE_SIZE_DEC = "EYE_SIZE_INC";
		public final static String SMILE = "SMILE";
		public final static String FROWN = "FROWN";
		public final static String SLIDER = "SLIDER";
	}

	public static void main(String[] args) {
		SmileyFrame frame = new SmileyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 800);
		frame.setVisible(true);
	}

	private static class SmileyFrame extends JFrame {
		public SmileyFrame() {
			Point point = new Point(200, 200);
			SmileyModel smileyModel = new SmileyModel(150, 40, true, point);
			SmileyView smileyView = new SmileyView(smileyModel);
			JMenuBar menu = new MenuBar(smileyModel, smileyView);
			JToolBar toolBar = new ToolBar(smileyModel, smileyView);
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
		protected JButton thirdButton;
		protected JButton fourthButton;
		protected SmileyModel model;
		protected SmileyView view;

		public ToolBar(SmileyModel model, SmileyView view) {
			this.model = model;
			this.view = view;
			ActionListener listener = new CommandAction(model, view);
			JComboBox<Object> x = new JComboBox<Object>(
					new String[] { "Complete Face", "Hat", "Left Eye", "Right Eye" });
			add(panel = new JPanel());
			add(toolBar = new JToolBar());
			Icon icon = new ImageIcon("C:\\pr2\\java.project\\PR2AG\\icons\\plus.png");
			panel.add(firstButton = new JButton("Zoom In", icon));
			firstButton.setActionCommand(Command.HEAD_SIZE_INC);
			firstButton.addActionListener(listener);
			Icon icon2 = new ImageIcon("C:\\pr2\\java.project\\PR2AG\\icons\\minus.png");
			panel.add(secondButton = new JButton("Zoom Out", icon2));
			secondButton.setActionCommand(Command.HEAD_SIZE_DEC);
			secondButton.addActionListener(listener);
			Icon icon3 = new ImageIcon("C:\\pr2\\java.project\\PR2AG\\icons\\smile.png");
			panel.add(thirdButton = new JButton("Smile", icon3));
			thirdButton.setActionCommand(Command.SMILE);
			thirdButton.addActionListener(listener);
			Icon icon4 = new ImageIcon("C:\\pr2\\java.project\\PR2AG\\icons\\sad.png");
			panel.add(fourthButton = new JButton("Sad", icon4));
			fourthButton.setActionCommand(Command.FROWN);
			fourthButton.addActionListener(listener);
			panel.add(x);
			toolBar.add(panel);
		}
	}

	public static class MenuBar extends JMenuBar { // Menubar
		protected JMenu firstmenu;
		protected JMenu secondmenu;
		protected JMenu thirdmenu;
		protected JMenu fourthmenu;
		protected JMenuItem save;
		protected JMenuItem load;
		protected JMenuItem exit;
		protected JMenuItem smile;
		protected JMenu head;
		protected JMenuItem eyes;
		protected JMenuItem pleased;
		protected JMenuItem sad;
		protected JMenuItem reset;
		protected JMenuItem incRadius;
		protected JMenuItem decRadius;
		protected SmileyModel model;
		protected SmileyView view;

		public MenuBar(SmileyModel model, SmileyView view) {
			this.model = model;
			this.view = view;
			ActionListener listener = new CommandAction(model, view);
			add(firstmenu = new JMenu("File"));
			add(secondmenu = new JMenu("Smiley"));
			firstmenu.add(save = new JMenuItem("save"));
			firstmenu.add(load = new JMenuItem("load"));
			firstmenu.add(exit = new JMenuItem("exit"));
			secondmenu.add(smile = new JMenuItem("0 smile"));
			secondmenu.add(head = new JMenu("head"));
			JMenuItem incRadius = new JMenuItem("inc Radius");
			head.add(incRadius);
			incRadius.setActionCommand(Command.HEAD_SIZE_INC);
			incRadius.addActionListener(listener);
			JMenuItem decRadius = new JMenuItem("dec Radius");
			head.add(decRadius);
			decRadius.setActionCommand(Command.HEAD_SIZE_DEC);
			decRadius.addActionListener(listener);
			secondmenu.add(eyes = new JMenu("eyes"));
			JMenuItem eyesbigger = new JMenuItem("bigger");
			eyes.add(eyesbigger);
			eyesbigger.setActionCommand(Command.EYE_SIZE_INC);
			eyesbigger.addActionListener(listener);
			JMenuItem eyessmaller = new JMenuItem("smaller");
			eyes.add(eyessmaller);
			eyesbigger.setActionCommand(Command.EYE_SIZE_DEC);
			eyesbigger.addActionListener(listener);
			secondmenu.addSeparator();
			secondmenu.add(pleased = new JMenuItem("pleased"));
			pleased.setActionCommand(Command.SMILE);
			pleased.addActionListener(listener);
			secondmenu.add(sad = new JMenuItem("sad"));
			sad.setActionCommand(Command.FROWN);
			sad.addActionListener(listener);
			secondmenu.addSeparator();
			secondmenu.add(reset = new JMenuItem("reset"));
		}
	}

	private static class ControlPanel extends JPanel {
		protected JSlider sliderSize;

		public ControlPanel(SmileyModel model, SmileyView view) {
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

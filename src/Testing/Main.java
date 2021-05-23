package Testing;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SpinnerListModel;
import javax.swing.UIManager;
import javax.swing.plaf.SeparatorUI;
import javax.swing.plaf.basic.BasicSeparatorUI;
import javax.swing.plaf.metal.MetalSeparatorUI;
import javax.swing.plaf.metal.MetalSliderUI;
import javax.swing.plaf.synth.SynthSeparatorUI;

import UI.NITButtonUI;
import UI.NITLaF;
import UI.NITListUI;
import UI.NITSliderUI;

public class Main {
	static void addAll(JPanel p, JComponent... cs){ for(JComponent c : cs) p.add(c); }
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NITLaF());
		JFrame w = new JFrame();
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setLocationRelativeTo(null);
        w.setSize(640, 480);
		JTabbedPane tabs = new JTabbedPane();
    	JPanel tab1 = new JPanel(); tab1.setLayout(new BoxLayout(tab1, BoxLayout.Y_AXIS));
    	JPanel tab1row1 = new JPanel(); tab1.add(tab1row1);
    	JButton button1 = new JButton("Button");
    	JButton button2 = new JButton("Pressed");
    	button2.getModel().setPressed(true);
    	JButton button3 = new JButton("Armed");
    	button3.getModel().setPressed(true);
    	button3.getModel().setArmed(true);
    	JButton button4 = new JButton("Rollover");
    	button4.getModel().setRollover(true);
    	JButton button5 = new JButton("Disabled");
    	button5.getModel().setEnabled(false);
    	JSeparator separator1 = new JSeparator(1);
    	JToggleButton button6 = new JToggleButton("Toggle");
    	button6.setUI(new NITButtonUI());
    	addAll(tab1row1, button1, button2, button3, button4, button5, separator1, button6);
    	JPanel tab1row2 = new JPanel(); tab1.add(tab1row2);
    	JTextField textField1 = new JTextField("");
    	textField1.setPreferredSize(new Dimension(200, 40));
    	textField1.putClientProperty("placeholder", "Placeholder");
    	JPasswordField textField2 = new JPasswordField("Password");
    	JSpinner textField3 = new JSpinner(new SpinnerListModel(new Object[]{"El1", "El2"}));
    	JComboBox<String> textField4 = new JComboBox<>(new String[]{"First", "Second", "Third"});
    	textField4.setSize(150, 50);
    	addAll(tab1row2, textField1, textField2, textField3, textField4);
    	JPanel tab1row3 = new JPanel(); tab1.add(tab1row3);
    	JCheckBox checkBox1 = new JCheckBox("Checkbox");
    	JRadioButton radioButton1 = new JRadioButton("Radio 1");
    	JRadioButton radioButton2 = new JRadioButton("Radio 2");
    	ButtonGroup radioButtonGroup = new ButtonGroup(); radioButtonGroup.add(radioButton1); radioButtonGroup.add(radioButton2);
    	JSlider slider1 = new JSlider(0, 100, 15);
    	slider1.setPaintTicks(true);
    	slider1.setMajorTickSpacing(25);
    	slider1.setMinorTickSpacing(5);
    	addAll(tab1row3, checkBox1, radioButton1, radioButton2, slider1);
    	JPanel tab1row4 = new JPanel(); tab1.add(tab1row4);
    	JList<String> list1 = new JList<>(new String[]{"This", "is", "a list."});
    	list1.setUI(new NITListUI());
    	addAll(tab1row4, list1);
    	tabs.addTab("Basic", tab1);
    	tabs.addMouseListener(new MouseAdapter(){ @Override public void mousePressed(MouseEvent e) {
				System.out.println(e.getX()+":"+e.getY());
				super.mouseClicked(e);
		} });
    	w.add(tabs);
    	w.setVisible(true);
    }
}

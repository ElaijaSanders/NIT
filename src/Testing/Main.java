package Testing;

import java.awt.Dimension;

import javax.swing.*;
import UI.NITLaF;

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
    	addAll(tab1row1, button1, button2, button3, button4, button5);
    	JPanel tab1row2 = new JPanel(); tab1.add(tab1row2);
    	JTextField textField1 = new JTextField("");
    	textField1.setPreferredSize(new Dimension(200, 40));
    	textField1.putClientProperty("placeholder", "Placeholder");
    	addAll(tab1row2, textField1);
    	tabs.addTab("Basic", tab1);
    	w.add(tabs);
    	w.setVisible(true);
    }
}

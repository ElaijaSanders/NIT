package UI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicLabelUI;

public class NITLabelUI extends BasicLabelUI {
	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
        c.setFocusable(false);
	}
	@Override
	public void paint(Graphics g, JComponent c) {
		((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		super.paint(g, c);
	}
	public static ComponentUI createUI(JComponent c){ return new NITLabelUI(); }
}
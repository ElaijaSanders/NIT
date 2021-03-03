package UI;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonUI;

public class NITButtonUI extends BasicButtonUI { //TODO own style, yeah?
	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		AbstractButton button = (AbstractButton)c;
        button.setOpaque(false);
        button.setFocusable(true);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
	}
	@Override
	public void paint(Graphics g, JComponent c) {
		Graphics2D d = (Graphics2D)g;
		d.setPaint(new GradientPaint(0, 0, Color.WHITE, 0, c.getHeight(), new Color(200, 200, 200)));
		d.fillRoundRect(0, 0, c.getWidth (), c.getHeight(), 8, 8);
		d.setPaint(Color.GRAY);
		d.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, 6, 6);
		if(((AbstractButton)c).getModel().isPressed()) d.translate(1, 1);
		super.paint(g, c);
	}
	public static ComponentUI createUI ( JComponent c ) {
	    return new NITButtonUI();
	}
}
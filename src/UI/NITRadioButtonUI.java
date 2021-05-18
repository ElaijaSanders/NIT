package UI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicCheckBoxUI;

import UI.Icons.NITRadioButtonIcon;

public class NITRadioButtonUI extends BasicCheckBoxUI {
	@Override
	public void installUI(JComponent c) {
		JRadioButton ch = (JRadioButton)c;
		NITRadioButtonIcon graphics = new NITRadioButtonIcon();
		ch.setIcon(graphics);
		ch.setSelectedIcon(graphics);
		super.installUI(c);
	}
	@Override
	protected void paintFocus(Graphics g, Rectangle textRect, Dimension size){}
	
	public static ComponentUI createUI(JComponent c){ return new NITRadioButtonUI(); }
}

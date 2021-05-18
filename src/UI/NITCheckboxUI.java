package UI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicCheckBoxUI;

import UI.Icons.NITCheckboxIcon;

public class NITCheckboxUI extends BasicCheckBoxUI {
	@Override
	public void installUI(JComponent c) {
		JCheckBox ch = (JCheckBox)c;
		NITCheckboxIcon graphics = new NITCheckboxIcon();
		ch.setIcon(graphics);
		ch.setSelectedIcon(graphics);
		super.installUI(c);
	}
	@Override
	protected void paintFocus(Graphics g, Rectangle textRect, Dimension size){}
	
	public static ComponentUI createUI(JComponent c){ return new NITCheckboxUI(); }
}

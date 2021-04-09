package UI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonUI;

public class NITButtonUI extends BasicButtonUI {
	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		AbstractButton button = (AbstractButton)c;
        button.setFocusable(true);
        button.setMargin(NITTheme.basicInsets);
        button.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        button.setRolloverEnabled(true);
	}
	@Override
	public void paint(Graphics g, JComponent c) {
		Graphics2D d = (Graphics2D)g;
		d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ButtonModel state = ((AbstractButton)c).getModel();
		if(state.isRollover()) d.setPaint(NITTheme.buttonHover());
		else if(state.isPressed()) d.setPaint(NITTheme.buttonPressedNotOver(c.getHeight()));
		else if(!state.isEnabled()) d.setPaint(NITTheme.buttonDisabled());
		else d.setPaint(NITTheme.button(c.getHeight()));
		d.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 12, 12);
		d.setPaint(NITTheme.borderColor);
		d.drawRoundRect(0, 0, c.getWidth()-1, c.getHeight()-1, 10, 10);
		super.paint(g, c);
	}
	@Override
	protected void paintButtonPressed(Graphics g, AbstractButton b) {
		Graphics2D d = (Graphics2D)g;
		d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		d.setPaint(NITTheme.buttonPressed(b.getHeight()));
		d.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), 12, 12);
		d.setPaint(NITTheme.borderColor);
		d.drawRoundRect(0, 0, b.getWidth()-1, b.getHeight()-1, 10, 10);
		super.paintButtonPressed(g, b);
	}
	@Override
	protected void paintFocus(Graphics g, AbstractButton c, Rectangle viewRect, Rectangle textRect, Rectangle iconRect){
		Graphics2D d = (Graphics2D)g;
		d.setPaint(NITTheme.selectedBorderColor);
		d.drawRoundRect(0, 0, c.getWidth()-1, c.getHeight()-1, 10, 10);
		super.paintFocus(g, c, viewRect, textRect, iconRect);
	}
	public static ComponentUI createUI(JComponent c){ return new NITButtonUI(); }
}
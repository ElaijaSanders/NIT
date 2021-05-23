package UI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
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
		button.setOpaque(false);
        button.setFocusable(true);
        button.setMargin(NITTheme.basicInsets);
        button.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        button.setRolloverEnabled(true);
        button.putClientProperty("connectedLeft", false);
        button.putClientProperty("connectedUp", false);
        button.putClientProperty("connectedDown", false);
	}
	@Override
	public void paint(Graphics g, JComponent c) {
		Graphics2D d = (Graphics2D)g;
		d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ButtonModel state = ((AbstractButton)c).getModel();
		if(state.isSelected()) d.setPaint(NITTheme.toggleButtonSelected);
		else if(state.isRollover()) d.setPaint(NITTheme.buttonHover());
		else if(state.isPressed()) d.setPaint(NITTheme.buttonPressedNotOver(c.getHeight()));
		else if(!state.isEnabled()) d.setPaint(NITTheme.buttonDisabled());
		else d.setPaint(NITTheme.button(c.getHeight()));
		Area back = new Area(new RoundRectangle2D.Double(0, 0, c.getWidth(), c.getHeight(), 12, 12));
		if((Boolean)c.getClientProperty("connectedLeft")) back.add(new Area( new Rectangle2D.Double(0, 0, 12, c.getHeight()) ));
		if((Boolean)c.getClientProperty("connectedUp")) back.add(new Area( new Rectangle2D.Double(0, 0, c.getWidth(), 12) ));
		if((Boolean)c.getClientProperty("connectedDown")) back.add(new Area( new Rectangle2D.Double(0, c.getHeight()-10, c.getWidth(), 12) ));
		d.fill(back);
		d.setPaint(NITTheme.borderColor);
		Area front = new Area(new RoundRectangle2D.Double(0, 0, c.getWidth()-1, c.getHeight()-1, 10, 10));
		if((Boolean)c.getClientProperty("connectedLeft")) front.add(new Area(
			new Rectangle2D.Double(0, 0, 10, c.getHeight()-1)
		)); if((Boolean)c.getClientProperty("connectedUp")) front.add(new Area(
			new Rectangle2D.Double(0, 0, c.getWidth()-1, 10)
		)); if((Boolean)c.getClientProperty("connectedDown")) front.add(new Area(
			new Rectangle2D.Double(0, c.getHeight()-10, c.getWidth()-1, 10)
		));
		d.draw(front);
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
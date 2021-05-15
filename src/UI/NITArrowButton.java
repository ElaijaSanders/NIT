package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.plaf.basic.BasicArrowButton;

@SuppressWarnings("serial")
class NITArrowButton extends BasicArrowButton {
	public byte variant = 0; //0 = Triangle
	public NITArrowButton(int direction){
		super(direction, Color.WHITE, NITTheme.arrowColor, NITTheme.arrowColor, NITTheme.arrowDisabled);
		this.setOpaque(false);
		this.setBorder(null);
	}
	@Override
	public void paint(Graphics g) {
		Graphics2D d = (Graphics2D)g;
		d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ButtonModel state = ((AbstractButton)this).getModel();
		if(state.isRollover()) d.setPaint(NITTheme.buttonHover());
		else if(state.isPressed()) d.setPaint(NITTheme.buttonPressedNotOver(getHeight()));
		else if(!state.isEnabled()) d.setPaint(NITTheme.buttonDisabled());
		else d.setPaint(NITTheme.button(getHeight()));
		Area back = new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 12, 12));
		if((Boolean)this.getClientProperty("connectedLeft")) back.add(new Area( new Rectangle2D.Double(0, 0, 12, getHeight()) ));
		if((Boolean)this.getClientProperty("connectedUp")) back.add(new Area( new Rectangle2D.Double(0, 0, getWidth(), 12) ));
		if((Boolean)this.getClientProperty("connectedDown")) back.add(new Area( new Rectangle2D.Double(0, getHeight()-10, getWidth(), 12) ));
		d.fill(back);
		d.setPaint(NITTheme.borderColor);
		Area front = new Area(new RoundRectangle2D.Double(0, 0, getWidth()-1, getHeight()-1, 10, 10));
		if((Boolean)this.getClientProperty("connectedLeft")) front.add(new Area(
			new Rectangle2D.Double(0, 0, 10, getHeight()-1)
		)); if((Boolean)this.getClientProperty("connectedUp")) front.add(new Area(
			new Rectangle2D.Double(0, 0, getWidth()-1, 10)
		)); if((Boolean)this.getClientProperty("connectedDown")) front.add(new Area(
			new Rectangle2D.Double(0, getHeight()-10, getWidth()-1, 10)
		)); d.draw(front);
		int polW = getWidth(), polH = getHeight();
		this.paintTriangle(g, polW/4, polH/3, getWidth()/2, this.direction, isEnabled());
	}
	@Override
	public void paintTriangle(Graphics g, int x, int y, int size, int direction, boolean isEnabled) {
		Polygon pol = new Polygon();
		if(getModel().isPressed()) g.setColor(NITTheme.arrowPressed);
		else if(isEnabled) g.setColor(NITTheme.arrowColor);
		else g.setColor(NITTheme.arrowDisabled);
		if(direction == BasicArrowButton.SOUTH){
			pol.addPoint(x, y);
			pol.addPoint(x+size, y);
			pol.addPoint(x+size/2, y/2+size);
		} else if(direction == BasicArrowButton.NORTH){
			pol.addPoint(x+size/2, y);
			pol.addPoint(x, y/2+size);
			pol.addPoint(x+size, y/2+size);
		} else {
			y -= y/4;
			pol.addPoint(x+size/2, y);
			pol.addPoint(x+size, y+size/2);
			pol.addPoint(x+size/2, y+size);
			pol.addPoint(x, y+size/2);
		} g.fillPolygon(pol);
	}
}
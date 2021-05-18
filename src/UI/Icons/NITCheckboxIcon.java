package UI.Icons;

import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Path2D;

import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.plaf.UIResource;

import UI.NITTheme;

public class NITCheckboxIcon implements Icon, UIResource{
	public int scale = 4;
	@Override
	public int getIconWidth(){
		return 6*scale;
	}
	@Override
	public int getIconHeight(){
		return (scale<=3?5:(scale>=14?7:6))*scale;
	}
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D d = (Graphics2D)g;
		d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if( ((JCheckBox)c).getModel().isPressed() ) d.setColor(NITTheme.checkboxBasePressed);
		else d.setColor(NITTheme.checkboxBase);
		d.fillRect(1*scale, 1*scale, 5*scale, 5*scale); //3,3,15,15
		if(c.hasFocus()) d.setColor(NITTheme.selectedBorderColor);
		else d.setColor(NITTheme.borderColor);
		d.drawRect(1*scale, 1*scale, 5*scale, 5*scale); //3,3,15,15
		if(((JCheckBox)c).isSelected()){
			d.setColor(NITTheme.checkboxCheck);
			Stroke prevStroke = d.getStroke();
			d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
			Path2D checkmark = new Path2D.Double();
			checkmark.moveTo(2*scale, 3*scale); //7,10
			checkmark.lineTo(3*scale, 5*scale); //10,15
			checkmark.lineTo(5*scale, 2*scale); //14,7
			d.draw(checkmark);
			d.setStroke(prevStroke);
		}
	}
}

package UI.Icons;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.JRadioButton;
import javax.swing.plaf.UIResource;

import UI.NITTheme;

public class NITRadioButtonIcon implements Icon, UIResource{
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
		if( ((JRadioButton)c).getModel().isPressed() ) d.setColor(NITTheme.radioButtonBasePressed);
		else d.setColor(NITTheme.radioButtonBase);
		d.fillOval(1*scale, 1*scale, 5*scale, 5*scale); //3,3,15,15
		if(c.hasFocus()) d.setColor(NITTheme.selectedBorderColor);
		else d.setColor(NITTheme.borderColor);
		d.drawOval(1*scale, 1*scale, 5*scale, 5*scale); //3,3,15,15
		if(((JRadioButton)c).isSelected()){
			d.setColor(NITTheme.radioButtonSelection);
			d.fillOval((int)Math.ceil(1.8*scale), (int)Math.ceil(1.8*scale), (int)Math.floor(3.4*scale), (int)Math.floor(3.4*scale));
		}
	}
}

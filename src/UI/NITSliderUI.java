package UI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSliderUI;

public class NITSliderUI extends BasicSliderUI {
	boolean isPressed = false;
	public NITSliderUI(JSlider b){ super(b); }
	@Override
	protected void installListeners(JSlider slider) {
		super.installListeners(slider);
		slider.addMouseListener(new MouseAdapter(){
			@Override public void mousePressed(MouseEvent e){ isPressed = true; super.mousePressed(e); slider.repaint(); }
			@Override public void mouseReleased(MouseEvent e){ isPressed = false; super.mouseReleased(e); slider.repaint(); }
		});
	}
	@Override
	public void paintFocus(Graphics g){}
	@Override
	public void paintThumb(Graphics g) {
		Graphics2D d = (Graphics2D)g;
		d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(this.isPressed) d.setColor(NITTheme.sliderThumbBasePressed);
		else d.setColor(NITTheme.sliderThumbBase);
		int x = (int)this.thumbRect.getX(); int y = (int)this.thumbRect.getY();
		int w = this.getThumbSize().width; int h = this.getThumbSize().height;
		d.fillRoundRect(x, y, w, h, 8, 8);
		if(this.slider.hasFocus()) d.setColor(NITTheme.selectedBorderColor);
		else d.setColor(NITTheme.borderColor);
		d.drawRoundRect(x, y, w-1, h-1, 7, 7);
	}
	@Override
	public void paintTrack(Graphics g) {
		Graphics2D d = (Graphics2D)g;
		d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		d.setColor(NITTheme.sliderTrackBase);
		d.fillRoundRect(this.trackRect.x, this.trackRect.y+6, this.trackRect.width, 7, 6, 6);
		d.setColor(NITTheme.borderColor);
		d.drawRoundRect(this.trackRect.x, this.trackRect.y+6, this.trackRect.width, 7, 6, 6);
	}
	public static ComponentUI createUI(JComponent c){ return new NITSliderUI((JSlider)c); }
}

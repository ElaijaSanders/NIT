package UI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class NITProgressbarUI extends BasicProgressBarUI {
	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		this.progressBar.setBorderPainted(false);
	}
	@Override
	public void paint(Graphics g, JComponent c) {
		JProgressBar pr = (JProgressBar)c;
		Graphics2D d = (Graphics2D)g;
		d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		d.setColor(NITTheme.progressBase);
		d.fillRoundRect(0, 0, pr.getWidth(), pr.getHeight(), 12, 12);
		if(pr.hasFocus()) d.setColor(NITTheme.selectedBorderColor);
		else d.setColor(NITTheme.borderColor);
		d.drawRoundRect(0, 0, pr.getWidth()-1, pr.getHeight()-1, 10, 10);
		if(pr.isIndeterminate()){
			this.boxRect = this.getBox(this.boxRect);
			d.setColor(NITTheme.progressIndefinite);
			d.fillRoundRect(this.boxRect.x, 3, 24, pr.getHeight()-6, 6, 6);
		} else {
			d.setColor(NITTheme.progressDefinite);
			d.fillRoundRect(4, 4, this.getAmountFull(pr.getInsets(), pr.getWidth()-8, pr.getHeight()), pr.getHeight()-8, 6, 6);
		} if(pr.isStringPainted()) super.paintString(g, 0, 0, pr.getWidth(), pr.getHeight(), 
				this.getAmountFull(pr.getInsets(), pr.getWidth(), pr.getHeight()), pr.getInsets());
	}
	public static ComponentUI createUI(JComponent c){ return new NITProgressbarUI(); }
}

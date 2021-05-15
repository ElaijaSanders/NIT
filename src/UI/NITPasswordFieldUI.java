package UI;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicPasswordFieldUI;
import javax.swing.text.JTextComponent;

public class NITPasswordFieldUI extends BasicPasswordFieldUI {
	@Override
	public void installUI(JComponent c){
		super.installUI(c);
		JPasswordField textField = (JPasswordField)c;
		textField.setFocusable(true);
		textField.setMargin(NITTheme.basicInsets);
        textField.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        textField.setSelectionColor(NITTheme.textSelection);
        textField.setEchoChar('\u2022');
	}
	@Override
	protected void paintSafely(Graphics g) {
		Graphics2D d = (Graphics2D)g;
		d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		paintBackground(g, getComponent());
		if(getComponent().getText().isEmpty()) if(getComponent().getClientProperty("placeholder")!=null) paintPlaceholder(d, getComponent());
		super.paintSafely(g);
	}
	@Override
	protected void paintBackground(Graphics g){}
	protected void paintBackground(Graphics g, JTextComponent c) {
		Graphics2D d = (Graphics2D)g;
		d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		d.setPaint(NITTheme.textFieldBase);
		d.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 12, 12);
		if(c.hasFocus()) d.setPaint(NITTheme.selectedBorderColor);
		else d.setPaint(NITTheme.borderColor);
		d.drawRoundRect(0, 0, c.getWidth()-1, c.getHeight()-1, 10, 10);
	}
	protected void paintPlaceholder(Graphics2D d, JTextComponent c) {
		//Referenced from FlatTextFieldUI.java @ GitHub
		Insets phInsets = c.getInsets();
		FontMetrics phFont = c.getFontMetrics(c.getFont());
		int x = phInsets.left;
		int y = phInsets.top + phFont.getAscent() + (c.getHeight()-phInsets.top-phInsets.bottom-phFont.getHeight())/2;
		d.setPaint(NITTheme.textPlaceholder);
		d.drawString((String)c.getClientProperty("placeholder"), x, y);
	}
	@Override
	protected void installListeners() {
		super.installListeners();
		getComponent().addFocusListener(new FocusListener() {
			@Override public void focusLost(FocusEvent e){getComponent().repaint();}
			@Override public void focusGained(FocusEvent e){getComponent().repaint();}
		});
	}
	public static ComponentUI createUI(JComponent c){ return new NITPasswordFieldUI(); }
}

package UI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class NITDropdownUI extends BasicComboBoxUI {
	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = (JComboBox)c;
		comboBox.setFocusable(true);
		comboBox.setOpaque(false);
		comboBox.setEditable(true);
	}
	@Override
	protected JButton createArrowButton() {
		JButton button = new NITArrowButton(BasicArrowButton.SOUTH);
		button.putClientProperty("connectedLeft", Boolean.TRUE);
		return button;
	}
	@Override
	protected ComboBoxEditor createEditor() {
		ComboBoxEditor editor = super.createEditor();
		JTextField field = (JTextField)editor.getEditorComponent();
		field.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
		field.putClientProperty("connectedRight", Boolean.TRUE);
		return editor;
	}
	@Override
	public void paint(Graphics g, JComponent c) {
		Graphics2D d = (Graphics2D)g;
		d.setColor(NITTheme.borderColor);
		d.fillRect(arrowButton.getX()-6, 0, 12, c.getHeight());
		super.paint(g, c);
	}
	public static ComponentUI createUI(JComponent c){ return new NITDropdownUI(); }
}

package UI;

import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicSpinnerUI;

public class NITSpinnerUI extends BasicSpinnerUI {
	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		JSpinner comboBox = (JSpinner)c;
		comboBox.setFocusable(true);
		comboBox.setOpaque(false);
	}
	@Override
	protected Component createNextButton() {
		JButton button = new NITArrowButton(BasicArrowButton.NORTH);
		button.putClientProperty("connectedLeft", Boolean.TRUE);
		button.putClientProperty("connectedDown", Boolean.TRUE);
		installNextButtonListeners(button);
		return button;
	}
	@Override
	protected Component createPreviousButton() {
		JButton button = new NITArrowButton(BasicArrowButton.SOUTH);
		button.putClientProperty("connectedLeft", Boolean.TRUE);
		button.putClientProperty("connectedUp", Boolean.TRUE);
		installPreviousButtonListeners(button);
		return button;
	}
	@Override
	protected JComponent createEditor() {
		//NITSpinnerEditor editor = new NITSpinnerEditor(this.spinner);
		JTextField editor = new JTextField();
		this.spinner.addChangeListener(e -> {
			editor.setText(this.spinner.getValue().toString());
		});
		this.spinner.setBorder(BorderFactory.createEmptyBorder());
		editor.putClientProperty("connectedRight", Boolean.TRUE);
		editor.setText(this.spinner.getValue().toString());
		return editor;
	}
	/*@Override
	public void paint(Graphics g, JComponent c) {
		Graphics2D d = (Graphics2D)g;
		d.setColor(NITTheme.borderColor);
		d.fillRect(this.spinner.getX()+this.spinner.getWidth()-6, 0, 12, c.getHeight());
		super.paint(g, c);
	}*/
	public static ComponentUI createUI(JComponent c){ return new NITSpinnerUI(); }
}

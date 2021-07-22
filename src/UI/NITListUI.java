package UI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicListUI;

public class NITListUI extends BasicListUI {
	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		JList<?> list = (JList<?>)c;
		list.setOpaque(false);
	}
	@Override
	protected void installListeners() {
		super.installListeners();
		this.list.addMouseListener(new MouseAdapter(){ @Override public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			if(e.getButton()==MouseEvent.BUTTON3) list.clearSelection();
		} });
	}
	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);
		Graphics2D d = (Graphics2D)g;
		d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(this.list.hasFocus()) this.list.setBorder(BorderFactory.createLineBorder(NITTheme.selectedBorderColor));
		else this.list.setBorder(BorderFactory.createLineBorder(NITTheme.borderColor));
	}
	@Override
	protected void paintCell(Graphics g, int row, Rectangle rowBounds, ListCellRenderer<Object> renderer,
			ListModel<Object> listModel, ListSelectionModel selectionModel, int leapIndex) {
		Graphics2D d = (Graphics2D)g;
		d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(selectionModel.isSelectedIndex(row)) d.setColor(NITTheme.listBaseSelected);
		else if(row%2==1) d.setColor(NITTheme.listBaseAlt);
		else d.setColor(NITTheme.listBase);
		d.fillRect(0, row*rowBounds.height, rowBounds.width+1, rowBounds.height+1);
		if(selectionModel.isSelectedIndex(row)) d.setColor(NITTheme.listTextSelected);
		else d.setColor(NITTheme.listText);
		d.drawString(listModel.getElementAt(row).toString(), 2, (row+1)*rowBounds.height-3);
	}
	public static ComponentUI createUI(JComponent c){ return new NITListUI(); }
}

package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D.Double;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.plaf.basic.BasicListUI;

public class NITListUI extends BasicListUI {
	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		JList<?> list = (JList<?>)c;
		list.setOpaque(false);
	}
	@Override
	protected void paintCell(Graphics g, int row, Rectangle rowBounds, ListCellRenderer<Object> renderer,
			ListModel<Object> listModel, ListSelectionModel selectionModel, int leapIndex) {
		Graphics2D d = (Graphics2D)g;
		d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Area base;
		if(row == 0){
			base = new Area(new RoundRectangle2D.Double(0, 0, rowBounds.width-1, rowBounds.height, 10, 10));
			base.add(new Area(new Rectangle(0, rowBounds.height-10, rowBounds.width-1, 10)));
		} else if(row == listModel.getSize()-1){
			base = new Area(new RoundRectangle2D.Double(0, row*rowBounds.height, rowBounds.width-1, rowBounds.height-1, 10, 10));
			base.add(new Area(new Rectangle(0, row*rowBounds.height, rowBounds.width-1, 10)));
		} else base = new Area(new Rectangle(0, row*rowBounds.height, rowBounds.width-1, rowBounds.height));
		if(selectionModel.isSelectedIndex(row)) d.setColor(NITTheme.listBaseSelected);
		else d.setColor(NITTheme.listBase);
		d.fill(base);
		d.setColor(NITTheme.borderColor);
		d.draw(base);
		if(selectionModel.isSelectedIndex(row)) d.setColor(Color.LIGHT_GRAY);
		else d.setColor(Color.BLACK);
		d.drawString(listModel.getElementAt(row).toString(), 2, (row+1)*rowBounds.height-3);
		//super.paintCell(g, row, rowBounds, renderer, listModel, selectionModel, leapIndex);
	}
}

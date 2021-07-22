package UI;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NITTableUI extends BasicTableUI {
    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
		this.table.setGridColor(NITTheme.tableGrid);
		this.table.setDefaultRenderer(Object.class, new StringCellRenderer()); //TODO more renderers, e.g. colo(u)r, boolean, etc.
		this.table.getTableHeader().setUI(new GeneralHeaderUI());
		this.table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
    }
    @Override
	protected void installListeners() {
		super.installListeners();
		this.table.addMouseListener(new MouseAdapter(){ @Override public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			if(e.getButton()==MouseEvent.BUTTON3) table.clearSelection();
		} });
	}
	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);
		if(this.table.hasFocus()) this.table.getTableHeader().setBorder(BorderFactory.createLineBorder(NITTheme.selectedBorderColor));
		else this.table.getTableHeader().setBorder(BorderFactory.createLineBorder(NITTheme.borderColor));
	}
	@SuppressWarnings("serial")
	static class StringCellRenderer extends DefaultTableCellRenderer {
    	@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column){
			if(isSelected) this.setBackground(NITTheme.tableBaseSelected);
			else this.setBackground(NITTheme.tableBase);
			if(isSelected) this.setForeground(NITTheme.tableTextSelected);
			else this.setForeground(NITTheme.tableText);
			this.setFont(table.getFont());
			this.setText(value.toString());
			this.setEnabled(table.isEnabled());
			return this;
		}
    }
    static class GeneralHeaderUI extends BasicTableHeaderUI { //TODO replace with some CellRenderer
		@Override
		public void paint(Graphics g, JComponent c) {
			Graphics2D d = (Graphics2D)g;
			d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			d.setPaint(NITTheme.tableHeaderBase(c.getHeight()));
			d.fillRect(0, 0, c.getWidth(), c.getHeight());
			d.setColor(NITTheme.borderColor);
			d.drawRect(0, 0, c.getWidth()-1, c.getHeight()-1);
			TableColumnModel tcm = ((JTableHeader)c).getColumnModel();
			int totalX = 0;
			int height = ((JTableHeader)c).getHeight();
			int baseY = height-4;
			for(int i = 0; i < tcm.getColumnCount(); i++){
				String text = tcm.getColumn(i).getHeaderValue().toString();
				d.setColor(NITTheme.tableText);
				d.drawString(text, totalX+(tcm.getColumn(i).getWidth()/2)-(d.getFontMetrics().stringWidth(text)/2), baseY);
				totalX += tcm.getColumn(i).getWidth();
				d.setColor(NITTheme.borderColor);
				if(i < tcm.getColumnCount()-1) d.drawLine(totalX-1, 0, totalX-1, height);
			}
		}
    }
    public static ComponentUI createUI(JComponent c){ return new NITTableUI(); }
}

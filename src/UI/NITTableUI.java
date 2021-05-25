package UI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.table.TableCellRenderer;

import java.awt.*;

public class NITTableUI extends BasicTableUI {
    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        Container container;
		if((container = this.table.getParent()) instanceof JViewport) if((container = container.getParent()) instanceof JScrollPane){
			JScrollPane pane = (JScrollPane)container;
			pane.setBorder(new LineBorder(NITTheme.borderColor, 1, true));
		} this.table.setGridColor(NITTheme.tableGrid);
		this.table.setBackground(NITTheme.tableBase);
		this.table.setSelectionBackground(NITTheme.tableBaseSelected);
		this.table.setDefaultRenderer(Object.class, new CellRenderer());
    }
    static class CellRenderer extends JLabel implements TableCellRenderer {
    	@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column){
			if(isSelected) super.setBackground(NITTheme.tableBaseSelected); //TODO make this render colo(u)rs properly.
			else super.setBackground(NITTheme.tableBase);
			super.setFont(table.getFont());
			super.setText(value.toString());
			super.setEnabled(table.isEnabled());
			return this;
		}
    }
}

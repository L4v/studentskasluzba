package studentskasluzba.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class StudentTable extends JTable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TableRowSorter<TableModel> sorter;
	
	public StudentTable()
	{
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudent());
		new ButtonColumnPredmetiStudenta(this, 11);
		sorter = new TableRowSorter<TableModel>((AbstractTableModelStudent)this.getModel());
		this.setRowSorter(sorter);
	}
	
	public void clearFilter() {
		sorter.setRowFilter(RowFilter.regexFilter("", 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
	}
	
	public void setFilter(String s, int i) {
		String regex = s;
		sorter.setRowFilter(RowFilter.regexFilter(regex, i));
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) 
			c.setBackground(new Color(160, 220, 250));
		else 
			c.setBackground(Color.WHITE);
		
		return c;
	}
}

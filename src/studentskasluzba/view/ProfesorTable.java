package studentskasluzba.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ProfesorTable extends JTable{

	private static final long serialVersionUID = -2586123662210414078L;
	private TableRowSorter<TableModel> sorter;
	public ProfesorTable()
	{
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfesor());
		new ButtonColumnPredmetiProfesora(this,10);
		sorter = new TableRowSorter<TableModel>((AbstractTableModelProfesor)this.getModel());
		this.setRowSorter(sorter);
	}
	
	public void clearFilter()
	{
		sorter.setRowFilter(RowFilter.regexFilter("", 0, 1, 2));
	}
	
	public void setFilter(String s, int i)
	{
		// NOTE(Jovan): Da bude case-insensitive
		String regex = "(?i)" + s + "(?-i)";
		sorter.setRowFilter(RowFilter.regexFilter(regex, i));
	}
	
	// NOTE(Jovan): Menja boju selektovane torke	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(new Color(160, 220, 250));
		} 
		else
		{
			c.setBackground(Color.WHITE);
		}
		return c;
	}
}

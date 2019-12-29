package studentskasluzba.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class ProfesorTable extends JTable{

	private static final long serialVersionUID = -2586123662210414078L;

	public ProfesorTable()
	{
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfesor());
		// TODO(Jovan): Da li je ovo dovoljno?
		this.setAutoCreateRowSorter(true);
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

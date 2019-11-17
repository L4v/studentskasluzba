package studentskasluzba;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class StudentTable extends JTable{

	private static final long serialVersionUID = -2586123662210414078L;

	public StudentTable()
	{
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		new AbstractTableModel() {
			private static final long serialVersionUID = -3588998810155657304L;

			@Override
			public int getColumnCount() {
				return 6;
			}

			@Override
			public int getRowCount() {
				return BazaStudenata.getInstance().getStudents().size();
			}

			@Override
			public Object getValueAt(int row, int column) {
				return BazaStudenata.getInstance().getValueAt(row, column);
			}};
	}
	
	// NOTE(Jovan): Menja boju selektovane torke	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
}

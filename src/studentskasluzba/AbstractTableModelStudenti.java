package studentskasluzba;

import javax.swing.table.AbstractTableModel;

public class AbstractTableModelStudenti extends AbstractTableModel{

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
	}
	
	@Override
	public String getColumnName(int column)
	{
		return BazaStudenata.getInstance().getColumnName(column);
	}
}

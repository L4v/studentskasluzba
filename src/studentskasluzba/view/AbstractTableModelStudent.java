package studentskasluzba.view;

import javax.swing.table.AbstractTableModel;

import studentskasluzba.model.BazaStudenata;

public class AbstractTableModelStudent extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getColumnCount() {
		return BazaStudenata.getInstance().getBrojAtributa();
	}

	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getBrojTorki();
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

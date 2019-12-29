package studentskasluzba.view;

import javax.swing.table.AbstractTableModel;

import studentskasluzba.model.BazaProfesor;

public class AbstractTableModelProfesor extends AbstractTableModel{

	private static final long serialVersionUID = -3588998810155657304L;

	@Override
	public int getColumnCount() {
		return BazaProfesor.getInstance().getBrojObelezja();
	}

	@Override
	public int getRowCount() {
		return BazaProfesor.getInstance().getBrojTorki();
	}

	@Override
	public Object getValueAt(int row, int column) {
		return BazaProfesor.getInstance().getValueAt(row, column);
	}
	
	@Override
	public String getColumnName(int column)
	{
		return BazaProfesor.getInstance().getColumnName(column);
	}
}

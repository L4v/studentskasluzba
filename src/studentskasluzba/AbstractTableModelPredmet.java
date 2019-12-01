package studentskasluzba;

import javax.swing.table.AbstractTableModel;

public class AbstractTableModelPredmet extends AbstractTableModel{
	private static final long serialVersionUID = 6578321466970727429L;

	@Override
	public int getColumnCount() {
		return BazaPredmet.getInstance().getBrojObelezja();
	}

	@Override
	public int getRowCount() {
		return BazaPredmet.getInstance().getBrojTorki();
	}

	@Override
	public Object getValueAt(int row, int column) {
		return BazaPredmet.getInstance().getValueAt(row, column);
	}
	
	@Override
	public String getColumnName(int column)
	{
		return BazaProfesor.getInstance().getColumnName(column);
	}

}

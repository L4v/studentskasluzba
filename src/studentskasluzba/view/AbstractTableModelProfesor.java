package studentskasluzba.view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import studentskasluzba.model.BazaProfesor;

public class AbstractTableModelProfesor extends AbstractTableModel{

	private static final long serialVersionUID = -3588998810155657304L;

	@Override
	public boolean isCellEditable(int row, int col)
	{
		return col == BazaProfesor.getInstance().getBrojObelezja();
	}
	
	@Override
	public int getColumnCount() {
		return BazaProfesor.getInstance().getBrojObelezja() + 1;
	}

	@Override
	public int getRowCount() {
		return BazaProfesor.getInstance().getBrojTorki();
	}

	@Override
	public Object getValueAt(int row, int column) {
		if (column == BazaProfesor.getInstance().getBrojObelezja())
		{
			return new JButton("Prika\u170ei");
		}
		return BazaProfesor.getInstance().getValueAt(row, column);
	}
	
	@Override
	public Class<?> getColumnClass(int col)
	{
		if(col == BazaProfesor.getInstance().getBrojObelezja())
		{
			return JButton.class;
		}
		return String.class;
	}
	
	@Override
	public String getColumnName(int column)
	{
		if(column == BazaProfesor.getInstance().getBrojObelezja())
		{
			return "Predmeti";
		}
		return BazaProfesor.getInstance().getColumnName(column);
	}
}

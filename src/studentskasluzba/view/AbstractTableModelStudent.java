package studentskasluzba.view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import studentskasluzba.model.BazaStudenata;

public class AbstractTableModelStudent extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean isCellEditable(int row, int col)
	{
		return col == BazaStudenata.getInstance().getBrojAtributa();
	}
	
	@Override
	public int getColumnCount() {
		return BazaStudenata.getInstance().getBrojAtributa() +1 ;
	}

	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getBrojTorki();
	}
	
	@Override
	public Class<?> getColumnClass(int col)
	{
		if(col == BazaStudenata.getInstance().getBrojAtributa())
		{
			return JButton.class;
		}
		return String.class;
	}

	@Override
	public Object getValueAt(int row, int column) {
		if (column == BazaStudenata.getInstance().getBrojAtributa()) {
			return new JButton("Prika\u017ei");
		}
		return BazaStudenata.getInstance().getValueAt(row, column);
	}
	
	@Override
	public String getColumnName(int column)
	{
		if (column == BazaStudenata.getInstance().getBrojAtributa()) {
			return "Predmeti";
		}
		return BazaStudenata.getInstance().getColumnName(column);
	}
}

package studentskasluzba;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

public class AbstractTableModelPredmet extends AbstractTableModel{
	private static final long serialVersionUID = 6578321466970727429L;

	@Override
	public int getColumnCount() {
		return BazaPredmet.getInstance().getBrojObelezja() + 1;
	}

	@Override
	public int getRowCount() {
		return BazaPredmet.getInstance().getBrojTorki();
	}

	@Override
	public Object getValueAt(int row, int column) {
		if (column == BazaPredmet.getInstance().getBrojObelezja())
		{
			return new JButton("Prikazi");
		}
		return BazaPredmet.getInstance().getValueAt(row, column);
	}
	
	@Override
	public Class<?> getColumnClass(int col)
	{
		if(col == BazaPredmet.getInstance().getBrojObelezja())
		{
			return JButton.class;
		}
		return String.class;
	}
	
	@Override
	public String getColumnName(int column)
	{
		if(column == BazaPredmet.getInstance().getBrojObelezja())
		{
			return "Studenti";
		}
		return BazaPredmet.getInstance().getColumnName(column);
	}

}

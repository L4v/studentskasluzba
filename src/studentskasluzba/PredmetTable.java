package studentskasluzba;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class PredmetTable extends JTable {
	private static final long serialVersionUID = 3435744544875490220L;

	public PredmetTable()
	{
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPredmet());
		
	}
	
	// NOTE(Jovan): Promena boje prilikom selekcije torke
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int col)
	{
		Component c = super.prepareRenderer(renderer, row, col);
		if(isRowSelected(row))
		{
			c.setBackground(new Color(160, 220, 250));
		}
		else
		{
			c.setBackground(Color.WHITE);
		}
		return c;
	}
}

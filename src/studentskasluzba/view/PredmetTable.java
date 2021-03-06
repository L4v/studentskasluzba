package studentskasluzba.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class PredmetTable extends JTable {
	private static final long serialVersionUID = 3435744544875490220L;
	private TableRowSorter<TableModel> sorter;
	public PredmetTable()
	{
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPredmet());
		new ButtonColumnStudenti(this, 5);
		sorter = new TableRowSorter<TableModel>((AbstractTableModelPredmet)this.getModel());
		this.setRowSorter(sorter);
	}
	
	public void clearFilter()
	{
		sorter.setRowFilter(RowFilter.regexFilter("", 0, 1));
	}
	
	public void setFilter(String s, int i)
	{
		// NOTE(Jovan): Da bude case-insensitive
		String regex = s;
		sorter.setRowFilter(RowFilter.regexFilter(regex, i));
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

package studentskasluzba.view;

import javax.swing.JScrollPane;

public class PredmetTab extends JScrollPane{
	private static final long serialVersionUID = 5244473018970087368L;
	private PredmetTable tabelaPredmeta;
	
	public PredmetTab()
	{
		super();
		// TODO(Jovan): Da li je potreban ceo tab?
		tabelaPredmeta = new PredmetTable();
		// NOTE(Jovan): Podesavamo da tabela zauzme celu visinu
		// iako nije popunjena
		tabelaPredmeta.setFillsViewportHeight(true);
		this.setViewportView(tabelaPredmeta);
		
	}
	
	public PredmetTable getTable()
	{
		return this.tabelaPredmeta;
	}
	
	public int getSelektovanuTorku()
	{
		int row = tabelaPredmeta.getSelectedRow();
		if(row == -1)
		{
			return row;
		}
		else
		{
			return this.tabelaPredmeta.convertRowIndexToModel(row);
		}
	}
	
	public AbstractTableModelPredmet getModel()
	{
		return (AbstractTableModelPredmet)this.tabelaPredmeta.getModel();
	}
	
}

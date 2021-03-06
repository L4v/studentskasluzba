package studentskasluzba.view;

import javax.swing.JScrollPane;

public class ProfesorTab extends JScrollPane{
	private static final long serialVersionUID = -6138361184893356221L;
	private ProfesorTable tabelaProfesora;
	public ProfesorTab()
	{
		super();
		// TODO(Jovan): Da li je potreban StudentTab ili je dovoljan JScrollPane?
		tabelaProfesora = new ProfesorTable(); 
		// NOTE(Jovan): Podesavamo da tabela zauzme celu visinu
		// iako nije popunjena
		tabelaProfesora.setFillsViewportHeight(true);
		this.setViewportView(tabelaProfesora);
	}
	
	public int getSelektovanuTorku()
	{
		int row = tabelaProfesora.getSelectedRow();
		if(row == -1)
		{
			return row;
		}
		else
		{
			return this.tabelaProfesora.convertRowIndexToModel(row);
		}
	}
	
	public ProfesorTable getTable()
	{
		return this.tabelaProfesora;
	}
	
	public AbstractTableModelProfesor getModel()
	{
		return (AbstractTableModelProfesor)this.tabelaProfesora.getModel();
	}
}

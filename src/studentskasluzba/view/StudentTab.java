package studentskasluzba.view;

import javax.swing.JScrollPane;

public class StudentTab extends JScrollPane{
	private static final long serialVersionUID = 1L;
	private StudentTable tabelaStudenata;
	public StudentTab()
	{
		super();
		tabelaStudenata = new StudentTable(); 
		tabelaStudenata.setFillsViewportHeight(true);
		this.setViewportView(tabelaStudenata);
	}
	
	public int getSelektovanuTorku()
	{
		return this.tabelaStudenata.getSelectedRow();
	}
	public AbstractTableModelStudent getModel()
	{
		return (AbstractTableModelStudent)this.tabelaStudenata.getModel();
	}
	
	public StudentTable getTable() {
		return this.tabelaStudenata;
	}
}

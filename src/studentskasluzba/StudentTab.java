package studentskasluzba;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StudentTab extends JScrollPane{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tabelaStudenata;
	public StudentTab()
	{
		super();
		tabelaStudenata = new StudentTable(); 
		tabelaStudenata.setFillsViewportHeight(true);
		this.setViewportView(tabelaStudenata);
	}
	
	public AbstractTableModelStudent getModel()
	{
		return (AbstractTableModelStudent)this.tabelaStudenata.getModel();
	}
}

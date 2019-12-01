package studentskasluzba;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ProfesorTab extends JScrollPane{
	private static final long serialVersionUID = -6138361184893356221L;
	private JTable tabelaProfesora;
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
}

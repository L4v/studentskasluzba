package studentskasluzba;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StudentTab extends JPanel{
	private static final long serialVersionUID = -6138361184893356221L;
	private JTable tabelaStudenata;
	public StudentTab()
	{
		super();
		
		tabelaStudenata = new StudentTable(); 
		
		JScrollPane scrollPane = new JScrollPane(tabelaStudenata);
		tabelaStudenata.setFillsViewportHeight(true);
		add(scrollPane, BorderLayout.CENTER);
	}
}

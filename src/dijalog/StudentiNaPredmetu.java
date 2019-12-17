package dijalog;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;

import studentskasluzba.BazaPredmet;
import studentskasluzba.Student;

public class StudentiNaPredmetu extends JDialog{
	private static final long serialVersionUID = -4775434477795635244L;

	private JPanel studentsPanel;
	private JPanel buttonsPanel;
	private JButton ukloniButton, otkaziButton;
	private JComboBox<String> studenti;
	// NOTE(Jovan): Sluzi za odredjivanje kog studenta treba prikazati
	private int row;
	public StudentiNaPredmetu(int row)
	{
		super();
		this.row = row;
		this.setSize(450, 250);
		this.setMinimumSize(new Dimension(450, 250));
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setTitle("Studenti na predmetu: " + 
		BazaPredmet.getInstance().getValueAt(this.row, 1));
		
		this.studentsPanel = new JPanel();
		this.buttonsPanel = new JPanel(new GridLayout(1, 2));
		
		this.studenti = new JComboBox<String>();
		for(Student s : BazaPredmet.getInstance().getPredmet(row).getStudenti())
		{
			StringBuilder sb = new StringBuilder();
			sb.append(s.getIndeks());
			sb.append(" ");
			sb.append(s.getIme());
			sb.append(" ");
			sb.append(s.getPrezime());
			studenti.addItem(sb.toString());
		}
		studentsPanel.add(this.studenti);
		
		this.ukloniButton = new JButton("Obrisi");
		this.otkaziButton = new JButton("Otkazi");
		
		// TODO(Jovan -> Krisian): Dodati funkcionalnost
		this.buttonsPanel.add(ukloniButton);
		this.buttonsPanel.add(otkaziButton);
	}
}

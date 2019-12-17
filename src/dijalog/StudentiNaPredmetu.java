package dijalog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import studentskasluzba.BazaPredmet;
import studentskasluzba.GlavniProzor;
import studentskasluzba.Student;

public class StudentiNaPredmetu extends JDialog{
	private static final long serialVersionUID = -4775434477795635244L;

	private JPanel studentsPanel;
	private JPanel buttonsPanel;
	private JButton ukloniButton, otkaziButton;
	private JScrollPane studenti;
	private JList<String> list;
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
		
		ArrayList<String> listaStudenata = new ArrayList<String>();
		for(Student s : BazaPredmet.getInstance().getPredmet(row).getStudenti())
		{
			StringBuilder sb = new StringBuilder();
			sb.append(s.getIndeks());
			sb.append(" ");
			sb.append(s.getIme());
			sb.append(" ");
			sb.append(s.getPrezime());
			listaStudenata.add(sb.toString());
		}
		this.list = new JList<String>(listaStudenata.toArray(new String[0]));
		this.studenti = new JScrollPane(list);
		studentsPanel.add(this.studenti);
		
		this.ukloniButton = new JButton("Obrisi");
		this.otkaziButton = new JButton("Otkazi");
		
		// TODO(Jovan -> Krisian): Dodati funkcionalnost
		this.buttonsPanel.add(ukloniButton);
		this.buttonsPanel.add(otkaziButton);
		
		ukloniButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		
		
		otkaziButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				
			}
		});
		
		
		
		
		
		this.add(studentsPanel, BorderLayout.CENTER);
		this.add(buttonsPanel, BorderLayout.SOUTH);
	}
}

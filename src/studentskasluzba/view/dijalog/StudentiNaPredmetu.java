package studentskasluzba.view.dijalog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import studentskasluzba.model.BazaPredmet;
import studentskasluzba.model.Student;
import studentskasluzba.view.listeners.BrisanjeStudentaSaPredmetaListener;

public class StudentiNaPredmetu extends JDialog{
	private static final long serialVersionUID = -4775434477795635244L;

	private JPanel studentsPanel;
	private JPanel buttonsPanel;
	private JButton ukloniButton, otkaziButton;
	private JScrollPane studenti;
	private JList<String> list;
	
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
		studenti.setPreferredSize(new Dimension(250,150));
		studentsPanel.add(this.studenti);
		
		this.ukloniButton = new JButton("Obri\u0161i");
		this.otkaziButton = new JButton("Nazad");
		
		FlowLayout layout = new FlowLayout();
		this.buttonsPanel.setLayout(layout);
		layout.setAlignment(FlowLayout.RIGHT);
		
		
		this.buttonsPanel.add(ukloniButton);
		this.buttonsPanel.add(otkaziButton);
		
		ukloniButton.addActionListener(new BrisanjeStudentaSaPredmetaListener(this));
		
		otkaziButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		this.add(studentsPanel, BorderLayout.CENTER);
		this.add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	
	public JList<String> getList() {
		return list;
	}

	public int getRow() {
		return row;
	}

	
	
}

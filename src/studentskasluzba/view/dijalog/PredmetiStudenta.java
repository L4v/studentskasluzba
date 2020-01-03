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

import studentskasluzba.model.BazaStudenata;
import studentskasluzba.model.Predmet;
import studentskasluzba.view.listeners.PredmetiStudentaListener;

public class PredmetiStudenta extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel predmetiPanel;
	private JScrollPane predmeti;
	private JPanel buttonsPanel;
	private JButton obrisiButton, otkaziButton;
	private JList<String> list;
	private int row;

	public PredmetiStudenta(int row) {
		super();
		this.row=row;
		this.setSize(450,250);
		this.setMinimumSize(new Dimension(450,250));
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setTitle("Predmeti studenta: " + BazaStudenata.getInstance().getValueAt(this.row, 0));
		
		this.predmetiPanel = new JPanel();
		this.buttonsPanel = new JPanel(new GridLayout(1, 2));
		
		ArrayList<String> listaPredmeta = new ArrayList<String>();
		for(Predmet p : BazaStudenata.getInstance().getStudent(row).getPredmeti()) {
			listaPredmeta.add(p.getNaziv());
		}
		
		this.list = new JList<String>(listaPredmeta.toArray(new String[0]));
		this.predmeti = new JScrollPane(list);
		
		predmeti.setPreferredSize(new Dimension(250,150));
		predmetiPanel.add(this.predmeti);
		
		this.obrisiButton = new JButton("Obri\u0161i");
		this.otkaziButton = new JButton("Nazad");
		
		FlowLayout layout = new FlowLayout();
		this.buttonsPanel.setLayout(layout);
		layout.setAlignment(FlowLayout.RIGHT);
		
		this.buttonsPanel.add(obrisiButton);
		this.buttonsPanel.add(otkaziButton);
		
		this.add(predmetiPanel, BorderLayout.CENTER);
		this.add(buttonsPanel, BorderLayout.SOUTH);
		
		otkaziButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		obrisiButton.addActionListener(new PredmetiStudentaListener(this));
		
	}
	
	public JList<String> getList() {
		return list;
	}
	public int getRow() {
		return row;
	}

}

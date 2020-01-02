package studentskasluzba.view.dijalog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import studentskasluzba.model.BazaProfesor;
import studentskasluzba.model.Predmet;
import studentskasluzba.model.Profesor;
import studentskasluzba.view.GlavniProzor;

public class PredmetiProfesora extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel predmetiPanel;
	private JScrollPane predmeti;
	private JList<String> list;
	private JPanel buttonsPanel;
	private JButton obrisiButton, otkaziButton;
	private int row;
	
	public PredmetiProfesora(int row) {
		super();
		this.row=row;
		this.setSize(450,250);
		this.setMinimumSize(new Dimension(450,250));
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setTitle("Predmeti profesora (broj li\u010dne karte): " + BazaProfesor.getInstance().getValueAt(this.row, 0));
		
		this.predmetiPanel = new JPanel();
		this.buttonsPanel = new JPanel(new GridLayout(1, 2));
		
		ArrayList<String> listaPredmeta = new ArrayList<String>();
		for(Predmet p : BazaProfesor.getInstance().getProfesor(row).getPredmeti()) {
			listaPredmeta.add(p.getNaziv());
		}
		
		this.list = new JList<String>(listaPredmeta.toArray(new String[0]));
		this.predmeti = new JScrollPane(list);
		
		predmeti.setPreferredSize(new Dimension(250,150));
		predmetiPanel.add(this.predmeti);
		
		this.obrisiButton = new JButton("Obri\u0161i");
		this.otkaziButton = new JButton("Otka\u017ei");
		
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
		
		obrisiButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = list.getSelectedIndex();
				if (i==-1) {
					JOptionPane.showMessageDialog(null, "Niste selektovali predmet!","Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				int choise = JOptionPane.showConfirmDialog(null,"Da li ste sigurni da \u017Eelite da obri\u0161ete predmet?","Brisanje predmeta profesora",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if (choise==JOptionPane.YES_OPTION) {
					Predmet p = BazaProfesor.getInstance().getProfesor(PredmetiProfesora.this.row).getPredmet(i);
					Profesor prof = BazaProfesor.getInstance().getProfesor(PredmetiProfesora.this.row);
					p.removeProfesor();
					prof.removePredmet(p);
					GlavniProzor.getInstance().azurirajPrikaz();
					GlavniProzor.getInstance().saveAllDBs();
					dispose();
				}
			}
		});
		
	}
}

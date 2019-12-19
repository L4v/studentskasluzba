package dijalog;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import studentskasluzba.BazaProfesor;
import studentskasluzba.Predmet;

public class PredmetiProfesora extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel predmetiPanel;
	private JScrollPane predmeti;
	private JList<String> list;
	private int row;
	
	public PredmetiProfesora(int row) {
		super();
		this.row=row;
		this.setSize(450,250);
		this.setMinimumSize(new Dimension(450,250));
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setTitle("Predmeti profesora (broj li\u010dne karte): " + BazaProfesor.getInstance().getValueAt(row, 0));
		
		this.predmetiPanel = new JPanel();
		
		ArrayList<String> listaPredmeta = new ArrayList<String>();
		for(Predmet p : BazaProfesor.getInstance().getProfesor(row).getPredmeti()) {
			listaPredmeta.add(p.getNaziv());
		}
		
		this.list = new JList<String>(listaPredmeta.toArray(new String[0]));
		this.predmeti = new JScrollPane(list);
		predmetiPanel.add(this.predmeti);
		
		this.add(predmetiPanel);
		
	}
}

package dijalog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import studentskasluzba.BazaPredmet;
import studentskasluzba.BazaProfesor;
import studentskasluzba.FocusListenerObaveznoTxt;
import studentskasluzba.Predmet;
import studentskasluzba.Profesor;

@SuppressWarnings("serial")
public class DodavanjePredmeta extends JDialog{

	private JPanel fieldsPanel;
	private JPanel buttonsPanel;
	private JLabel warningLabel;
	private JButton dodajButton, otkaziButton;
	private JTextField sifra, naziv;
	private JComboBox<Profesor> profesori;
	private JComboBox<Integer> godina, semestar;
	
	public DodavanjePredmeta()
	{
		super();
		this.setSize(450, 250);
		this.setMinimumSize(new Dimension(450, 250));
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setModal(true);
		this.setTitle("Dodavanje predmeta");
		
		warningLabel = new JLabel("POPUNITI SVA POLJA");
		warningLabel.setForeground(Color.RED);
		warningLabel.setVisible(false);
		sifra = new JTextField();
		sifra.addFocusListener(new FocusListenerObaveznoTxt(0));
		
		naziv = new JTextField();
		naziv.addFocusListener(new FocusListenerObaveznoTxt(0));
		
		godina = new JComboBox<Integer>();
		semestar = new JComboBox<Integer>();
		for(int i = 1; i <= 8; ++i)
		{
			semestar.addItem(i);
			if(i <= 4)
			{
				godina.addItem(i);
			}
		}
		
		
		profesori = new JComboBox<Profesor>();
		for (Profesor p : BazaProfesor.getInstance().getProfesore())
		{
			profesori.addItem(p);
		}
		// NOTE(Jovan): Dodajemo "nema" kako bi imali mogucnost
		// da ne odaberemo jos profesora za predmet
		Profesor nema = new Profesor("NEMA", "", "", "", "", "", "", "", "", "");
		profesori.addItem(nema);
		
		this.add(warningLabel, BorderLayout.NORTH);
		fieldsPanel = new JPanel(new GridLayout(5, 2));
		fieldsPanel.add(new JLabel("Sifra predmeta*"));
		fieldsPanel.add(sifra);
		fieldsPanel.add(new JLabel("Naziv predmeta*"));
		fieldsPanel.add(naziv);
		fieldsPanel.add(new JLabel("Godina*"));
		fieldsPanel.add(godina);
		fieldsPanel.add(new JLabel("Semestar*"));
		fieldsPanel.add(semestar);
		fieldsPanel.add(new JLabel("Profesor*"));
		fieldsPanel.add(profesori);
		this.add(fieldsPanel, BorderLayout.CENTER);
		buttonsPanel = new JPanel(new GridLayout(1, 2));
		dodajButton = new JButton("Dodaj");
		otkaziButton = new JButton("Otkazi");
		buttonsPanel.add(dodajButton);
		buttonsPanel.add(otkaziButton);
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		this.add(buttonsPanel, BorderLayout.SOUTH);
		
		dodajButton.addMouseListener(new MouseListener() {

			// TODO(Jovan): Mozda dodati shake? :D
			// TODO(Jovan): isEmpty() ne radi na nekim sistemima, zasto o Boze zasto
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(sifra.getText().isEmpty() || naziv.getText().isEmpty())
				{
					warningLabel.setVisible(true);
				}
				else
				{
					String sifraPredmeta = sifra.getText();
					String nazivPredmeta = naziv.getText();
					int semestarPredmeta = (int) semestar.getSelectedItem();
					int godinaPredmeta = (int) godina.getSelectedItem();
					Profesor profesorPredmeta = (Profesor)profesori.getSelectedItem();
					Predmet p = new Predmet(sifraPredmeta, nazivPredmeta, semestarPredmeta,
							godinaPredmeta, profesorPredmeta);
					
					if(!BazaPredmet.getInstance().addPredmet(p)) {
						JOptionPane.showMessageDialog(null, "Predmet sa tom \u0161ifrom ve\u0107 postoji!","Warning", JOptionPane.WARNING_MESSAGE);
					}
					
					dispose();
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		otkaziButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
}

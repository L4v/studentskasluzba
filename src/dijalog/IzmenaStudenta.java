package dijalog;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import studentskasluzba.BazaStudenata;
import studentskasluzba.FocusListenerObaveznoBroj;
import studentskasluzba.FocusListenerObaveznoTxt;
import studentskasluzba.GlavniProzor;
import studentskasluzba.StatusStudent;
import studentskasluzba.Student;

public class IzmenaStudenta extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IzmenaStudenta() {
		
		setTitle("Izmena studenta");
		setSize(450,550);
		setLocationRelativeTo(null);
		this.setModal(true);
		
		GridBagLayout layout = new GridBagLayout();
		getContentPane().setLayout(layout);
		
		JLabel ime = new JLabel("Ime*");
		JLabel prezime = new JLabel("Prezime*");
		JLabel datRodj = new JLabel("Datum ro\u0111enja*");
		JLabel adresa = new JLabel("Adresa stanovanja*");
		JLabel brTelefona = new JLabel("Broj telefona*");
		JLabel brIndeksa = new JLabel("Broj Indeksa*");
		JLabel trenutnaGod = new JLabel("Trenutna godina*");
		
		//dodatno
		JLabel email = new JLabel("Email*");
		JLabel datumUpisa = new JLabel("Datum upisa*");
		JLabel prosek = new JLabel("Prosek*");
		
		JButton potvrdi = new JButton("Potvrdi");
		JButton otkazi = new JButton("Otka\u017ei");
		
		JPanel panel = new JPanel();
		panel.add(otkazi);
		panel.add(potvrdi);
		
		JComboBox<String> trenGod = new JComboBox<String>(new String[] { "I (prva)", "II (druga)", "III (tre\u0107a)", "IV (\u010Detvrta)"});
			
		JRadioButton radBtnB = new JRadioButton("Bud\u017Eet");
		JRadioButton radBtnS = new JRadioButton("Samofinansiranje");
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(radBtnB);
		btnGroup.add(radBtnS);
		
		JTextField imeT = new JTextField();
		JTextField prezimeT = new JTextField();
		JTextField datRodjT = new JTextField();
		JTextField adresaT = new JTextField();
		JTextField brTelefonaT = new JTextField();
		JTextField brIndeksaT = new JTextField();
		
		//dodatno
		JTextField emailT = new JTextField();
		JTextField datumUpisaT = new JTextField();
		JTextField prosekT = new JTextField();
		
		JLabel warningLabel = new JLabel("Niste popunili sva polja"); 
		warningLabel.setForeground(Color.RED);
		warningLabel.setVisible(false);
		
		imeT.addFocusListener(new FocusListenerObaveznoTxt(0));      
		prezimeT.addFocusListener(new FocusListenerObaveznoTxt(0));
		datRodjT.addFocusListener(new FocusListenerObaveznoTxt(-2));
		adresaT.addFocusListener(new FocusListenerObaveznoTxt(0));
		brTelefonaT.addFocusListener(new FocusListenerObaveznoBroj(-1));
		brIndeksaT.addFocusListener(new FocusListenerObaveznoTxt(-1));
		emailT.addFocusListener(new FocusListenerObaveznoTxt(-3));
		datumUpisaT.addFocusListener(new FocusListenerObaveznoTxt(-2));
		prosekT.addFocusListener(new FocusListenerObaveznoBroj(-2));
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(15, 2, 2, 2);
		c.anchor = GridBagConstraints.WEST;
		getContentPane().add(ime, c);
		
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 1;
		c1.gridy = 0;
		c1.weightx = 1;
		c1.insets = new Insets(15, 2, 2, 2);
		c1.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(imeT, c1);
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 0;
		c2.gridy = 1;
		c2.insets = new Insets(15, 2, 2, 2);
		c2.anchor = GridBagConstraints.WEST;
		getContentPane().add(prezime, c2);
		
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 1;
		c3.gridy = 1;
		c3.insets = new Insets(15, 2, 2, 2);
		c3.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(prezimeT, c3);
		
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridx = 0;
		c4.gridy = 2;
		c4.insets = new Insets(15, 2, 2, 2);
		c4.anchor = GridBagConstraints.WEST;
		getContentPane().add(datRodj, c4);
		
		GridBagConstraints c5 = new GridBagConstraints();
		c5.gridx = 1;
		c5.gridy = 2;
		c5.insets = new Insets(15, 2, 2, 2);
		c5.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(datRodjT, c5);
		
		GridBagConstraints c6 = new GridBagConstraints();
		c6.gridx = 0;
		c6.gridy = 3;
		c6.insets = new Insets(15, 2, 2, 2);
		c6.anchor = GridBagConstraints.WEST;
		getContentPane().add(adresa, c6);
		
		GridBagConstraints c7 = new GridBagConstraints();
		c7.gridx = 1;
		c7.gridy = 3;
		c7.insets = new Insets(15, 2, 2, 2);
		c7.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(adresaT, c7);
		
		GridBagConstraints c8 = new GridBagConstraints();
		c8.gridx = 0;
		c8.gridy = 4;
		c8.insets = new Insets(15, 2, 2, 2);
		c8.anchor = GridBagConstraints.WEST;
		getContentPane().add(brTelefona, c8);
		
		GridBagConstraints c9 = new GridBagConstraints();
		c9.gridx = 1;
		c9.gridy = 4;
		c9.insets = new Insets(15, 2, 2, 2);
		c9.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(brTelefonaT, c9);
		
		GridBagConstraints c10 = new GridBagConstraints();
		c10.gridx = 0;
		c10.gridy = 5;
		c10.insets = new Insets(15, 2, 2, 2);
		c10.anchor = GridBagConstraints.WEST;
		getContentPane().add(brIndeksa, c10);
		
		GridBagConstraints c11 = new GridBagConstraints();
		c11.gridx = 1;
		c11.gridy = 5;
		c11.insets = new Insets(15, 2, 2, 2);
		c11.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(brIndeksaT, c11);
		
		GridBagConstraints c12 = new GridBagConstraints();
		c12.gridx = 0;
		c12.gridy = 6;
		c12.insets = new Insets(15, 2, 2, 2);
		c12.anchor = GridBagConstraints.WEST;
		getContentPane().add(email, c12);
		
		GridBagConstraints c13 = new GridBagConstraints();
		c13.gridx = 1;
		c13.gridy = 6;
		c13.insets = new Insets(15, 2, 2, 2);
		c13.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(emailT, c13);
		
		GridBagConstraints c14 = new GridBagConstraints();
		c14.gridx = 0;
		c14.gridy = 7;
		c14.insets = new Insets(15, 2, 2, 2);
		c14.anchor = GridBagConstraints.WEST;
		getContentPane().add(datumUpisa, c14);
		
		GridBagConstraints c15 = new GridBagConstraints();
		c15.gridx = 1;
		c15.gridy = 7;
		c15.insets = new Insets(15, 2, 2, 2);
		c15.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(datumUpisaT, c15);
		
		GridBagConstraints c16 = new GridBagConstraints();
		c16.gridx = 0;
		c16.gridy = 8;
		c16.insets = new Insets(15, 2, 2, 2);
		c16.anchor = GridBagConstraints.WEST;
		getContentPane().add(prosek, c16);
		
		GridBagConstraints c17 = new GridBagConstraints();
		c17.gridx = 1;
		c17.gridy = 8;
		c17.insets = new Insets(15, 2, 2, 2);
		c17.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(prosekT, c17);
		
		GridBagConstraints c18 = new GridBagConstraints();
		c18.gridx = 0;
		c18.gridy = 9;
		c18.insets = new Insets(15, 2, 2, 2);
		c18.anchor = GridBagConstraints.WEST;
		getContentPane().add(trenutnaGod, c18);
		
		GridBagConstraints c19 = new GridBagConstraints();
		c19.gridx = 1;
		c19.gridy = 9;
		c19.fill = GridBagConstraints.HORIZONTAL;
		c19.insets = new Insets(15, 2, 2, 2);
		getContentPane().add(trenGod, c19);
		
		GridBagConstraints c20 = new GridBagConstraints();
		c20.gridx = 0;
		c20.gridy = 10;
		c20.insets = new Insets(15, 2, 2, 2);
		c20.anchor = GridBagConstraints.WEST;
		getContentPane().add(radBtnB, c20);
		
		GridBagConstraints c21 = new GridBagConstraints();
		c21.gridx = 0;
		c21.gridy = 11;
		c21.insets = new Insets(2, 2, 2, 2);
		c21.anchor = GridBagConstraints.WEST;
		getContentPane().add(radBtnS, c21);
		
		GridBagConstraints c22 = new GridBagConstraints();
		c22.gridx = 0;
		c22.gridy = 12;
		c22.insets = new Insets(15, 2, 2, 2);
		getContentPane().add(warningLabel, c22);
		
		GridBagConstraints c23 = new GridBagConstraints();
		c23.gridx = 1;
		c23.gridy = 13;
		c23.insets = new Insets(15, 2, 2, 2);
		c23.anchor = GridBagConstraints.EAST;
		getContentPane().add(panel, c23);
		
		//NOTE(Kristian): popunjavanje polja sa izabranim studentom
		Student s = BazaStudenata.getInstance().getStudent(GlavniProzor.getInstance().getSelektovanuTorku());
		
		imeT.setText(s.getIme());
		prezimeT.setText(s.getPrezime());
		datRodjT.setText(s.getDatumRodjenja());
		adresaT.setText(s.getAdresaStanovanja());
		brTelefonaT.setText(s.getKontaktTelefon());
		brIndeksaT.setText(s.getIndeks());
		emailT.setText(s.getEmail());
		datumUpisaT.setText(s.getDatumUpisa());
		prosekT.setText(Double.toString(s.getProsecnaOcena()));
		trenGod.setSelectedIndex(Integer.parseInt(s.getTrenutnaGodina())-1);
		
		if (s.getStatusStudenta()==StatusStudent.S) {   
			radBtnS.setSelected(true);
			radBtnB.setSelected(false);
		} else
			radBtnB.setSelected(true);
			radBtnS.setSelected(false);
	
		
		potvrdi.addMouseListener(new MouseListener() {
			
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
				if(imeT.getText().isEmpty() || prezimeT.getText().isEmpty() || datRodjT.getText().isEmpty() || adresaT.getText().isEmpty() || brTelefonaT.getText().isEmpty() || brIndeksaT.getText().isEmpty() || emailT.getText().isEmpty() || datumUpisaT.getText().isEmpty() || prosekT.getText().isEmpty())
				{
					warningLabel.setVisible(true);
				}
				else
				{
					String ime = imeT.getText();
					String prezime = prezimeT.getText();
					String datRodj = datRodjT.getText();
					String adresa = adresaT.getText();
					String brTelefona = brTelefonaT.getText();
					String brIndeksa = brIndeksaT.getText();
					String email = emailT.getText();
					String datumUpisa = datumUpisaT.getText();
					double prosek = Double.parseDouble(prosekT.getText());
					String trenutnaGod  = String.valueOf(trenGod.getSelectedIndex()+1);
					
					StatusStudent statusStud;
					
					if (radBtnS.isSelected()) {
						 statusStud = StatusStudent.S;
					} else {
						 statusStud = StatusStudent.B;
					}
					
					BazaStudenata.getInstance().izmeniStudenta(ime, prezime, datRodj, adresa, brTelefona, email, brIndeksa, datumUpisa, trenutnaGod, statusStud, prosek);
					
					
					dispose();
				}
				
			}
		});
		
		otkazi.addMouseListener(new MouseListener() {
			
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
		
	}

}

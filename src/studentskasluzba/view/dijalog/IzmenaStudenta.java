package studentskasluzba.view.dijalog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import studentskasluzba.controller.StudentController;
import studentskasluzba.model.Student;
import studentskasluzba.view.GlavniProzor;
import studentskasluzba.view.StatusStudent;
import studentskasluzba.view.listeners.IzmenaStudentaFocus;
import studentskasluzba.view.listeners.IzmenaStudentaListener;

public class IzmenaStudenta extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel ime, prezime, datRodj, adresa, brTelefona, brIndeksa, trenutnaGod, email, datumUpisa, prosek;
	JButton potvrdi, otkazi;
	
	JTextField imeT;
	JTextField prezimeT;
	JTextField datRodjT;
	JTextField adresaT;
	JTextField brTelefonaT;
	JTextField brIndeksaT;
	
	//dodatno
	JTextField emailT;
	JTextField datumUpisaT;
	JTextField prosekT;
	
	JComboBox<String> trenGod;
	
	JRadioButton radBtnB;
	JRadioButton radBtnS;

	public IzmenaStudenta() {
		
		setTitle("Izmena studenta");
		setSize(450,550);
		setLocationRelativeTo(null);
		this.setModal(true);
		
		GridBagLayout layout = new GridBagLayout();
		getContentPane().setLayout(layout);
		
		ime = new JLabel("Ime*");
		prezime = new JLabel("Prezime*");
		datRodj = new JLabel("Datum ro\u0111enja*");
		adresa = new JLabel("Adresa stanovanja*");
		brTelefona = new JLabel("Broj telefona*");
		brIndeksa = new JLabel("Broj Indeksa*");
		trenutnaGod = new JLabel("Trenutna godina*");
		
		//dodatno
		email = new JLabel("Email*");
		datumUpisa = new JLabel("Datum upisa*");
		prosek = new JLabel("Prosek*");
		
		potvrdi = new JButton("Potvrdi");
		otkazi = new JButton("Otka\u017ei");
		
		JPanel panel = new JPanel();
		panel.add(otkazi);
		panel.add(potvrdi);
		
		trenGod = new JComboBox<String>(new String[] { "I (prva)", "II (druga)", "III (tre\u0107a)", "IV (\u010Detvrta)"});
			
		radBtnB = new JRadioButton("Bud\u017Eet");
		radBtnS = new JRadioButton("Samofinansiranje");
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(radBtnB);
		btnGroup.add(radBtnS);
		
		imeT = new JTextField();
		prezimeT = new JTextField();
		datRodjT = new JTextField();
		adresaT = new JTextField();
		brTelefonaT = new JTextField();
		brIndeksaT = new JTextField();
		
		//dodatno
		emailT = new JTextField();
		datumUpisaT = new JTextField();
		prosekT = new JTextField();
		
		imeT.addFocusListener(new IzmenaStudentaFocus(this,0));      
		prezimeT.addFocusListener(new IzmenaStudentaFocus(this,0));
		datRodjT.addFocusListener(new IzmenaStudentaFocus(this,-2));
		adresaT.addFocusListener(new IzmenaStudentaFocus(this,0));
		brTelefonaT.addFocusListener(new IzmenaStudentaFocus(this,-1));
		brIndeksaT.addFocusListener(new IzmenaStudentaFocus(this,-1));
		emailT.addFocusListener(new IzmenaStudentaFocus(this,-3));
		datumUpisaT.addFocusListener(new IzmenaStudentaFocus(this,-2));
		prosekT.addFocusListener(new IzmenaStudentaFocus(this,-2));
		
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
		c22.gridx = 1;
		c22.gridy = 13;
		c22.insets = new Insets(15, 2, 2, 2);
		c22.anchor = GridBagConstraints.EAST;
		getContentPane().add(panel, c22);
		
		
		
		//NOTE(Kristian): popunjavanje polja sa izabranim studentom
		Student s = StudentController.getInstance().getStudent(GlavniProzor.getInstance().getSelektovanuTorku());
		
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
	
		potvrdi.addActionListener(new IzmenaStudentaListener(this));
		
		otkazi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}


	public JButton getPotvrdi() {
		return potvrdi;
	}

	public JTextField getImeT() {
		return imeT;
	}

	public JTextField getPrezimeT() {
		return prezimeT;
	}
	public JTextField getDatRodjT() {
		return datRodjT;
	}

	public JTextField getAdresaT() {
		return adresaT;
	}

	public JTextField getBrTelefonaT() {
		return brTelefonaT;
	}

	public JTextField getBrIndeksaT() {
		return brIndeksaT;
	}

	public JTextField getEmailT() {
		return emailT;
	}

	public JTextField getDatumUpisaT() {
		return datumUpisaT;
	}

	public JTextField getProsekT() {
		return prosekT;
	}

	public JComboBox<String> getTrenGod() {
		return trenGod;
	}

	public JRadioButton getRadBtnB() {
		return radBtnB;
	}

	public JRadioButton getRadBtnS() {
		return radBtnS;
	}

}

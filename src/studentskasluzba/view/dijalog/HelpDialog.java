package studentskasluzba.view.dijalog;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelpDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HelpDialog() {
		
		setTitle("Help");
		setSize(750,700);
		setLocationRelativeTo(null);
		this.setModal(true);
		
		BorderLayout layout = new BorderLayout();
		getContentPane().setLayout(layout);
		
		JPanel bttn = new JPanel();
		
		JLabel labela = new JLabel( 
				  "<html><b>POMO\u0106 ZA KORISNIKE:</b><br/>"
				+ "<br/><br/>"
				+ "Klikom na tab 'Studenti' je prikazana tabela svih studenata. Kada se odabere tab 'Profesori' prikazuje se tabela sa svim profesorima, "
				+ "a kada se odabere tab 'Predmeti' prikazuje se tabela sa listom svih predmeta.<br/><br/>"
				+ "Za dodavanje novog studenta/profesora/predmeta kliknuti na odgovaraju\u0107e dugme (prvo dugme, kod odgovaraju\u0107eg tab-a) ili "
				+ "iz Menu Bar-a (File -> New) ili samo Ctrl + N, pojavi\u0107e se dijalog gde korisnik mo\u017ee uneti podatke. <br/><br/>" 
				+ "Za izmenu studenta/profesora/predmeta kliknuti na odgovaraju\u0107e dugme (drugo dugme, kod odgovaraju\u0107eg tab-a) ili iz Menu "
				+ "Bar-a (Edit -> Edit) ili samo Ctrl + E (i naravno treba selektovati odgovaraju\u0107eg studenta/predmeta/profesora), pojavi\u0107e se dijalog gde korisnik mo\u017ee uneti podatke. <br/><br/>"
				+ "Za brisanje studenta/profesora/predmeta kliknuti na odgovaraju\u0107e dugme (tre\u0107e dugme, kod odgovaraju\u0107eg tab-a) ili iz Menu "  
				+ "Bar-a (Edit -> Delete) ili samo Ctrl + D (i naravno treba selektovati odgovaraju\u0107eg studenta/predmeta/profesora). <br/><br/>"
				+ "Za dodavanje studenta na predmet potrebeno je oti\u0107i na tab 'Predmeti' i kliknuti na poslednje dugme i u dijalogu uneti broj indeksa studenta kojeg \u017eelimo dodati. "
				+ "Za ukljanjanje studenta sa predmeta, klikom na dugme 'Prika\u017ei' u dijalogu treba selektovati studenta i kliknuti na dugme 'Obri\u0161i'. <br/><br/>"
				+ "Za dodavanje profesora na predmet potrebeno je oti\u0107i na tab 'Predmeti' i kliknuti na \u010detvrto dugme i u dijalogu uneti broj li\u010dne karte profesora kojeg \u017eelimo dodati. "
				+ "Za ukljanjanje profesora sa predmeta, potrebno je kliknuti na pretposlednje dugme (i naravno treba selektovati predmet sa kojeg uklanjamo profesor). <br/><br/>"
				+ "Za pretragu studenta/profesora/predmeta uneti podatke odnosno kriterijum pretrage u formatu koji je naveden u odgovaraju\u0107em polju za pretragu u zavisnosti od izabranog tab-a. "
				+ "u tabeli \u0107ee ostati entiteti koji zadovoljavaju zadati kriterijum.<br/><br/>"
				+ "Klikom u Menu Bar-u na Help -> About ili samo Ctrl + O, mo\u017ete na\u0107i kratak opis aplikacije kao i kratku biografiju dva autora.<br/>"
				);
		
		JButton ok = new JButton("OK");
		bttn.add(ok);
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();			
			}
		});
		
		this.add(labela, BorderLayout.CENTER);
		this.add(bttn,BorderLayout.SOUTH);
	}
}

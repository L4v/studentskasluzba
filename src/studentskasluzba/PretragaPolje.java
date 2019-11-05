package studentskasluzba;


import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PretragaPolje extends JTextField{
	// NOTE(Jovan): Tekst koji se pojavi kao hint ukoliko je polje pretrage prazno
	private String DefaultTekst = "ime:<ime>;prezime:<prezime>;indeks:<XX-Y-WWWW>";
	
	public PretragaPolje()
	{
		super();
		this.setText(DefaultTekst);
		
		// NOTE(Jovan): Listener za izmenu teksta pri fokusu
		this.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// NOTE(Jovan): Ako tekst polje nije editovano
				// kada se selektuje, ukloni hint
				if(PretragaPolje.this.getText().equals(PretragaPolje.this.DefaultTekst))
				{
					PretragaPolje.this.setText("");
				}
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// NOTE(Jovan): Kada se izbugi fokus, ako tekst polje
				// nije editovano, vrati nazad hint
				if(PretragaPolje.this.getText().equals(""))
				{
					PretragaPolje.this.setText(PretragaPolje.this.GetDefaultTekst());
				}
				
			}
			
		});;
	}
	
	public String GetDefaultTekst()
	{
		return this.DefaultTekst;
	}
}

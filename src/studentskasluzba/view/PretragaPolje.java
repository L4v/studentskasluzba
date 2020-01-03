package studentskasluzba.view;


import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PretragaPolje extends JTextField{
	// NOTE(Jovan): Tekst koji se pojavi kao hint ukoliko je polje pretrage prazno
	private String defaultTekst = "";
	private boolean inFocus;
	
	public PretragaPolje()
	{
		super();
		this.setText(defaultTekst);
		// NOTE(Jovan): Da ne bi kolabiralo
		this.setColumns(80);
		this.inFocus = false;
		// NOTE(Jovan): Listener za izmenu teksta pri fokusu
		this.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// NOTE(Jovan): Ako tekst polje nije editovano
				// kada se selektuje, ukloni hint
				if(PretragaPolje.this.getText().equals(PretragaPolje.this.defaultTekst))
				{
					PretragaPolje.this.setText("");
					PretragaPolje.this.inFocus = true;
				}
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// NOTE(Jovan): Kada se izbugi fokus, ako tekst polje
				// nije editovano, vrati nazad hint
				if(PretragaPolje.this.getText().equals(""))
				{
					PretragaPolje.this.setText(PretragaPolje.this.getDefaultTekst());
					PretragaPolje.this.inFocus = false;
				}
				
			}
			
		});
	}
	
	public String getDefaultTekst()
	{
		return this.defaultTekst;
	}
	
	public void setDefaultText(String s)
	{
		this.defaultTekst = s;
		if(!this.inFocus)
		{
			this.setText(s);
		}
	}
}

package dijalog;

import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DodajPredmet extends JDialog{

	public DodajPredmet()
	{
		super();
		this.setLayout(new GridLayout(5, 2));
		this.setSize(450, 250);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.add(new JLabel("Sifra predmeta"));
		this.add(new JTextField());
		this.add(new JLabel("Naziv predmeta"));
		this.add(new JTextField());
		this.add(new JLabel("Godina"));
		this.add(new JTextField());
		this.add(new JLabel("Semestar"));
		this.add(new JTextField());
		
	}
	
}

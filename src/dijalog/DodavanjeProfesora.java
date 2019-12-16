package dijalog;

import java.awt.Dimension;

import javax.swing.JDialog;

public class DodavanjeProfesora extends JDialog{
	private static final long serialVersionUID = -7033252007876580812L;

	
	public DodavanjeProfesora()
	{
		super();
		this.setSize(450, 250);
		this.setMinimumSize(new Dimension(450, 250));
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setModal(true);
		this.setTitle("Dodavanje profesora");
		
		
		
	}
}

package studentskasluzba;

import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class Toolbar extends JToolBar{
	public Toolbar()
	{
		super();
		this.add(new DodajDugme());
	}
}

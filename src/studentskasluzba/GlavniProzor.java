package studentskasluzba;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GlavniProzor extends JFrame{
	public GlavniProzor()
	{
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(ScreenSize.width * 3/4, ScreenSize.height * 3/4);
		this.setLocationRelativeTo(null);
		
		Toolbar GlavniToolbar = new Toolbar(); 
		this.add(GlavniToolbar, BorderLayout.NORTH);
	}
}

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
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize.width * 3/4, screenSize.height * 3/4);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		Toolbar glavniToolbar = new Toolbar(); 
		this.add(glavniToolbar, BorderLayout.NORTH);
		
		MojMenuBar menu = new MojMenuBar();
		this.setJMenuBar(menu);
		
		StatusBar st_bar=new StatusBar();
		this.add(st_bar, BorderLayout.SOUTH);
	}
}

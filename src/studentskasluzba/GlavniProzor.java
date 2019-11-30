package studentskasluzba;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class GlavniProzor extends JFrame{
	
	private JTabbedPane tabbedPane;
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
		
		// TODO(Jovan): Srediti izgled i dodati Profesor i Predemet
		tabbedPane = new JTabbedPane();
		StudentTab studentTab = new StudentTab();
		StudentTab studentTab2 = new StudentTab();
		tabbedPane.addTab("Student", studentTab);
		tabbedPane.addTab("Student2", studentTab2);
		this.add(tabbedPane, BorderLayout.CENTER);
	}
}

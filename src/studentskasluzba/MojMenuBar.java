package studentskasluzba;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MojMenuBar extends JMenuBar{

	public MojMenuBar() {
		
		JMenu file=new JMenu("File");
		
		JMenuItem miNew = new JMenuItem("New");
		JMenuItem miClose = new JMenuItem("Close");
		
		file.add(miNew);
		file.add(miClose);
		
		JMenu edit=new JMenu("Edit");
		
		JMenuItem miEdit = new JMenuItem("Edit");
		JMenuItem miDelete = new JMenuItem("Delete");
		
		edit.add(miEdit);
		edit.add(miDelete);
		
		JMenu help=new JMenu("Help");
		
		JMenuItem miHelp = new JMenuItem("Help");
		JMenuItem miAbout = new JMenuItem("About");
		
		help.add(miHelp);
		help.add(miAbout);
		
		add(file);
		add(edit);
		add(help);
		
		
	}
}

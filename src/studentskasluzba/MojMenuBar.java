package studentskasluzba;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class MojMenuBar extends JMenuBar{

	public MojMenuBar() {
		
		JMenu file=new JMenu("File");
		
		JMenuItem miNew = new JMenuItem("New");
		JMenuItem miClose = new JMenuItem("Close");
		
		miNew.setIcon(new ImageIcon("res/icons/plus.png"));
		miClose.setIcon(new ImageIcon("res/icons/delete-button.png"));
		
		miNew.setMnemonic(KeyEvent.VK_N);
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
		
		file.add(miNew);
		file.add(miClose);
		
		
		
		//EDIT
		JMenu edit=new JMenu("Edit");
		
		JMenuItem miEdit = new JMenuItem("Edit");
		JMenuItem miDelete = new JMenuItem("Delete");
		
		miEdit.setIcon(new ImageIcon("res/icons/edit.png"));
		miDelete.setIcon(new ImageIcon("res/icons/delete.png"));
		
		edit.add(miEdit);
		edit.add(miDelete);
		
		
		//HELP
		JMenu help=new JMenu("Help");
		
		JMenuItem miHelp = new JMenuItem("Help");
		JMenuItem miAbout = new JMenuItem("About");
		
		miHelp.setIcon(new ImageIcon("res/icons/information.png"));
		miAbout.setIcon(new ImageIcon("res/icons/about.png"));
		
		help.add(miHelp);
		help.add(miAbout);
		
		add(file);
		add(edit);
		add(help);
		
		
	}
}

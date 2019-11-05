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
		
		//FILE
		JMenu file=new JMenu("File");
		
		JMenuItem miNew = new JMenuItem("New");
		JMenuItem miClose = new JMenuItem("Close");
		
		miNew.setIcon(new ImageIcon("res/icons/plus.png"));	 
		miNew.setMnemonic(KeyEvent.VK_N);
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
		miClose.setIcon(new ImageIcon("res/icons/delete-button.png"));
		miClose.setMnemonic(KeyEvent.VK_C);
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		file.add(miNew);
		file.add(miClose);
		
		
		
		//EDIT
		JMenu edit=new JMenu("Edit");
		
		JMenuItem miEdit = new JMenuItem("Edit");
		JMenuItem miDelete = new JMenuItem("Delete");
		
		miEdit.setIcon(new ImageIcon("res/icons/edit.png"));
		miEdit.setMnemonic(KeyEvent.VK_E);
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		
		miDelete.setIcon(new ImageIcon("res/icons/delete.png"));
		miDelete.setMnemonic(KeyEvent.VK_D);
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		edit.add(miEdit);
		edit.add(miDelete);
		
		
		//HELP
		JMenu help=new JMenu("Help");
		
		JMenuItem miHelp = new JMenuItem("Help");
		JMenuItem miAbout = new JMenuItem("About");
		
		miHelp.setIcon(new ImageIcon("res/icons/information.png"));
		miHelp.setMnemonic(KeyEvent.VK_H);
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		
		miAbout.setIcon(new ImageIcon("res/icons/about.png"));
		miAbout.setMnemonic(KeyEvent.VK_A);
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		help.add(miHelp);
		help.add(miAbout);
		
		add(file);
		add(edit);
		add(help);
		
		
	}
}

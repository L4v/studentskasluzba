package studentskasluzba.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import studentskasluzba.view.dijalog.AboutDialog;
import studentskasluzba.view.dijalog.HelpDialog;
import studentskasluzba.view.listeners.MenuBarDeleteListener;
import studentskasluzba.view.listeners.MenuBarEditListener;
import studentskasluzba.view.listeners.MenuBarNewListener;

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
		miClose.setMnemonic(KeyEvent.VK_Q);
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		
		//dodavanje funkcionalnosti new
		miNew.addActionListener(new MenuBarNewListener());
		
		//dodavanje funkcionalnosti close
		miClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int choise = JOptionPane.showConfirmDialog(null,"Da li ste sigurni da \u017Eelite da zatvorite aplikaciju?","Zatvaranje aplikacije",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if (choise==JOptionPane.YES_OPTION) {
					GlavniProzor.getInstance().saveAllDBs();
					System.exit(0);
				}
			}
		});	
		
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
		
		//dodavanje funkcionalnosti edit		
		miEdit.addActionListener(new MenuBarEditListener());
		
		//dodavanje funkcionalnosti delete
		miDelete.addActionListener(new MenuBarDeleteListener());
		
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
		miAbout.setMnemonic(KeyEvent.VK_O);
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		
		//dodavanje funkcionalnosti help
		miHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HelpDialog miHelp = new HelpDialog();
				miHelp.setVisible(true);
			}
		});
		
		//dodavanje funkcionalnosti about
		miAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AboutDialog miAbout = new AboutDialog();
				miAbout.setVisible(true);
				
			}
		});
	
		
		help.add(miHelp);
		help.add(miAbout);
		
		add(file);
		add(edit);
		add(help);
	}
}

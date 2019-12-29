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

import studentskasluzba.view.dijalog.BrisanjePredmeta;
import studentskasluzba.view.dijalog.BrisanjeProfesora;
import studentskasluzba.view.dijalog.BrisanjeStudenta;
import studentskasluzba.view.dijalog.DodavanjePredmeta;
import studentskasluzba.view.dijalog.DodavanjeProfesora;
import studentskasluzba.view.dijalog.DodavanjeStudenta;
import studentskasluzba.view.dijalog.IzmenaProfesora;
import studentskasluzba.view.dijalog.IzmenaStudenta;

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
		miClose.setMnemonic(KeyEvent.VK_X);
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		
		//dodavanje funkcionalnosti new
		miNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(GlavniProzor.getInstance().getSelektovanTab())
				{
				 case STUDENT:
				 {
					DodavanjeStudenta miNew = new DodavanjeStudenta();
					miNew.setVisible(true);
					break;
				 }
				 case PROFESOR:
				 {
					 DodavanjeProfesora miNew = new DodavanjeProfesora();
					 miNew.setVisible(true);
					 break;
				 }
				 case PREDMET:
				 {
					DodavanjePredmeta miNew = new DodavanjePredmeta();
					miNew.setVisible(true);
					break;
				 }
				 default:
				 {
					 return;
				 }
				}
				
			}
		});
		
		//dodavanje funkcionalnosti close
		miClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int choise = JOptionPane.showConfirmDialog(null,"Da li ste sigurni da \u017Eelite da zatvorite aplikaciju?","Zatvaranje aplikacije",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if (choise==JOptionPane.YES_OPTION) {
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
		miEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(GlavniProzor.getInstance().getSelektovanTab())
				{
					case STUDENT:
					{
						if (GlavniProzor.getInstance().getSelektovanuTorku()==-1) {
							JOptionPane.showMessageDialog(null, "Niste selektovali studenta!");
							return;
						}
						IzmenaStudenta miEdit = new IzmenaStudenta();
						miEdit.setVisible(true);
						break;
					}
					case PROFESOR:
					{
						if (GlavniProzor.getInstance().getSelektovanuTorku()==-1) {
							JOptionPane.showMessageDialog(null, "Niste selektovali profesora!");
							return;
						}
						IzmenaProfesora miEdit = new IzmenaProfesora();
						miEdit.setVisible(true);
						break;
					}
					case PREDMET:
					{
						// dodati!!
						break;
					}
				}
				
			}
		});
		
		//dodavanje funkcionalnosti delete
		miDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(GlavniProzor.getInstance().getSelektovanTab())
				{
					case STUDENT:
					{
						if (GlavniProzor.getInstance().getSelektovanuTorku()==-1) {
							JOptionPane.showMessageDialog(null, "Niste selektovali studenta!");
							return;
						}
						BrisanjeStudenta miDelete = new BrisanjeStudenta();
						miDelete.setVisible(true);
						break;
					}
					case PROFESOR:
					{
						if (GlavniProzor.getInstance().getSelektovanuTorku()==-1) {
							JOptionPane.showMessageDialog(null, "Niste selektovali profesora!");
							return;
						}
						BrisanjeProfesora miDelete = new BrisanjeProfesora();
						miDelete.setVisible(true);
						break;
					}
					case PREDMET:
					{
						if (GlavniProzor.getInstance().getSelektovanuTorku()==-1) {
							JOptionPane.showMessageDialog(null, "Niste selektovali predmet!");
							return;
						}
						BrisanjePredmeta miDelete = new BrisanjePredmeta();
						miDelete.setVisible(true);
						break;
					}
				}
				
			}
		});
		
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

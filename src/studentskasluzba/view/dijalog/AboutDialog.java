package studentskasluzba.view.dijalog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AboutDialog() {
		
		setTitle("About");
		setSize(850,750);
		setLocationRelativeTo(null);
		this.setModal(true);
		this.setMinimumSize(new Dimension(850,750));
		
		BorderLayout layout = new BorderLayout();
		getContentPane().setLayout(layout);
		
		JPanel stud = new JPanel(new GridLayout(3,2));
		JPanel bttn = new JPanel();
		
		ImageIcon icon=null;
		try {
			icon = new ImageIcon(ImageIO.read(getClass().getResource("/icons/faculty.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel tmp = new JLabel();
		tmp.setIcon(icon);
		tmp.setHorizontalAlignment(JLabel.CENTER);
		
		stud.add(tmp);
		stud.add(new JLabel(
				"<html><b>KRATAK OPIS APLIKACIJE:</b><br/>"
				+ "<br/>"
				+ "Ova aplikacija predstavlja zajedni\u010dki trud Jovana Ivo\u0161evi\u0107a i Kristiana Farka\u0161a u vidu predmetnog projekta \u010diji "
				+ "cilj jeste da simulira hipoteti\u010dku studentsku slu\u017ebu. <br/>"
				+ "Aplikacija se sastoji od grafi\u010dkog korisni\u010dkog interfejsa pomo\u0107u kojeg korisnik mo\u017ee da komunicira sa bazom podataka studentske "
				+ "slu\u017ebe i izvr\u0161ava odre\u0111ene komande, poput: <br/>"
				+ " - Dodavanje studenta/profesora/predmeta u bazu, odnosno uklanjanje iz baze <br/>"
				+ " - Dodavanje/uklanjanje studenta/profesora na/sa predmet/a <br/>"
				+ " - Izmena podataka postoje\u0107ih studenta, profesora ili predmeta<br></html> " 
				));
		
		ImageIcon icon1=null;
		try {
			icon1 = new ImageIcon(ImageIO.read(getClass().getResource("/icons/stud1.jpg")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel tmp1 = new JLabel();
		tmp1.setIcon(icon1);
		tmp1.setHorizontalAlignment(JLabel.CENTER);
		
		stud.add(tmp1);
		stud.add(new JLabel(
				"<html><b>KRATKA BIOGRAFIJA STUDENTA 1:</b><br/>"
				+ "<br/>"
				+ "Kristian Farka\u0161 je ro\u0111en 27.10.1998. u Novom Sadu. Osnovnu "
				+ "\u0161kolu 'Sonja Marinkovi\u0107' je zavr\u0161io 2013. godine u Novom Sadu. "
				+ "Gimnaziju  'Svetozar Markovi\u0107' je zavr\u0161io 2017. godine.  "  
				+ "Trenutno je student tre\u0107e godine Fakulteta tehni\u010dkih nauka, "
				+ "na smeru Ra\u010dunarstvo i automatika.</html>"));
		
		
		ImageIcon icon2=null;
		try {
			icon2 = new ImageIcon(ImageIO.read(getClass().getResource("/icons/stud2.jpg")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel tmp2 = new JLabel();
		tmp2.setIcon(icon2);
		tmp2.setHorizontalAlignment(JLabel.CENTER);
		
		stud.add(tmp2);
		stud.add(new JLabel("<html><b>KRATKA BIOGRAFIJA STUDENTA 2:</b><br/><br/>Jovan Ivo\u0161evi\u0107 (i njegov ma\u010Dak), ro\u0111en 10.03.1998. (Jovan, ne ma\u010Dak) u Novom Sadu."
				+ "I\u0161ao u O\u0160 '\u017Darko Zrenjanin' i zavr\u0161io T\u0160 'Pavle Savi\u0107' kao Tehni\u010dar za industrijsku farmaceutsku tehnologiju. "
				+ "Trenutno je zajedno sa kolegom Kristianom student tre\u0107e godine na Fakultetu tehni\u010dkih nauka na smeru Ra\u010dunarstvo i automatika."
				+ "Hvala na kori\u0161\u0107enju na\u0161e aplikacije :)</html>"));
		
				
		
		JButton ok = new JButton("OK");
		bttn.add(ok);
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();			
			}
		});
		
		this.add(bttn,BorderLayout.SOUTH);
		this.add(stud,BorderLayout.CENTER);
	}
}

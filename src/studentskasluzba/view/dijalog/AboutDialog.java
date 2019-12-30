package studentskasluzba.view.dijalog;

import java.awt.BorderLayout;
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
		setSize(800,700);
		setLocationRelativeTo(null);
		this.setModal(true);
		
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
				+ "<br/>"));
		
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
				+ "Kristian Farka\u0161 je ro\u0111en 27.10.1998. u Novom Sadu. Osnovnu <br/>"
				+ "\u0161kolu 'Sonja Marinkovi\u0107' je zavr\u0161io 2013. godine u Novom Sadu. <br/>"
				+ "Gimnaziju  'Svetozar Markovi\u0107' je zavr\u0161io 2017. godine.  <br/>"  
				+ "Trenutno je student tre\u0107e godine Fakulteta tehni\u010dkih nauka, <br/>"
				+ "na smeru Ra\u010dunarstvo i automatika."));
		
		
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
		stud.add(new JLabel("<html><b>KRATKA BIOGRAFIJA STUDENTA 2:</b><br/>"
				+ "<br/>"));
		
				
		
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

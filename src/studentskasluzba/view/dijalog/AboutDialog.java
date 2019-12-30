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
		setSize(650,550);
		setLocationRelativeTo(null);
		this.setModal(true);
		
		BorderLayout layout = new BorderLayout();
		getContentPane().setLayout(layout);
		
		JPanel stud = new JPanel(new GridLayout(2,2));
		JPanel bttn = new JPanel();
		
		ImageIcon icon=null;
		try {
			icon = new ImageIcon(ImageIO.read(getClass().getResource("/icons/student1.jpg")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel tmp = new JLabel();
		tmp.setIcon(icon);
		
		stud.add(tmp);
		stud.add(new JLabel("heeej"));
		
		
		ImageIcon icon2=null;
		try {
			icon2 = new ImageIcon(ImageIO.read(getClass().getResource("/icons/student2.jpg")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel tmp2 = new JLabel();
		tmp2.setIcon(icon2);
		
		stud.add(tmp2);
		stud.add(new JLabel("heeej drugari!"));
		
		
		
		
		
		
				
		
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

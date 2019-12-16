package dijalog;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BrisanjeStudenta extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BrisanjeStudenta() {
	
		setTitle("Brisanje studenta");
		setSize(350,150);
		setLocationRelativeTo(null);
		this.setModal(true);
		
		getContentPane().setLayout(new BorderLayout());
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		
		JLabel message = new JLabel("Da li ste sigurni da \u017elite da obri\u0160ete studenta?");
		JButton potvrda = new JButton("Potvrda");
		JButton odustanak = new JButton("Odustanak");
		
		ImageIcon Icon = new ImageIcon("/icons/add-user.png");
		JLabel tmp = new JLabel();
		tmp.setIcon(Icon);
		
		panel1.add(tmp, BorderLayout.WEST);
		panel1.add(message, BorderLayout.CENTER);
		
		panel2.add(odustanak, BorderLayout.EAST);
		panel2.add(potvrda, BorderLayout.EAST);
		
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.SOUTH);
		
	}
}

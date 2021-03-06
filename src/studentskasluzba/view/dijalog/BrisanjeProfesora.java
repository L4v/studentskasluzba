package studentskasluzba.view.dijalog;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

import studentskasluzba.controller.ProfesorController;
import studentskasluzba.view.GlavniProzor;

public class BrisanjeProfesora extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BrisanjeProfesora() {
		
		setTitle("Brisanje profesora");
		setSize(400,150);
		setLocationRelativeTo(null);
		this.setModal(true);
		this.setMinimumSize(new Dimension(400,150));
		
		getContentPane().setLayout(new GridBagLayout());
		
		JLabel message = new JLabel("Da li ste sigurni da \u017eelite da obri\u0161ete profesora?");
		JButton potvrda = new JButton("Potvrda");
		JButton odustanak = new JButton("Odustanak");
		
		ImageIcon icon=null;
		try {
			icon = new ImageIcon(ImageIO.read(getClass().getResource("/icons/delete.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel tmp = new JLabel();
		tmp.setIcon(icon);
		
		JPanel p = new JPanel();
		p.add(odustanak);
		p.add(potvrda);
		
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(2, 2, 2, 30);
		c.anchor = GridBagConstraints.WEST;
		getContentPane().add(tmp, c);
		
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 1;
		c1.gridy = 0;
		c1.insets = new Insets(2, 2, 2, 30);
		c1.anchor = GridBagConstraints.WEST;
		getContentPane().add(message, c1);
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 1;
		c2.gridy = 1;
		c2.insets = new Insets(30, 2, 2, 2);
		c2.anchor = GridBagConstraints.EAST;
		getContentPane().add(p, c2);
		
		potvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProfesorController.getInstance().removeProfesor(GlavniProzor.getInstance().getSelektovanuTorku());
				dispose();
			}
		});
		// NOTE(Jovan): Default opcija za enter
		JRootPane root = SwingUtilities.getRootPane(potvrda);
		root.setDefaultButton(potvrda);
		odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		
	}
}

package studentskasluzba.view.dijalog;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class HelpDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HelpDialog() {
		
		setTitle("Help");
		setSize(650,550);
		setLocationRelativeTo(null);
		this.setModal(true);
		
		BorderLayout layout = new BorderLayout();
		getContentPane().setLayout(layout);
		
		JPanel bttn = new JPanel();
		
		
		JButton ok = new JButton("OK");
		bttn.add(ok);
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();			
			}
		});
		
		this.add(bttn,BorderLayout.SOUTH);
	}
}

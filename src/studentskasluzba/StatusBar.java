package studentskasluzba;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private JLabel lblTime = new JLabel();
	private JLabel lblDate = new JLabel();
	//private JLabel lblText = new JLabel();
	private DateFormat formatter;
	private String today;
	private JPanel pnlContent;

    public StatusBar() {
        setLayout(new BorderLayout());
        
        pnlContent = new JPanel(new GridBagLayout()); 
      
        formatter = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.getDefault());
        today = formatter.format(new Date());
        lblDate.setText(today);
        
        pnlContent.add(lblDate, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
        
        pnlContent.setBackground(Color.cyan);
        
        this.add(pnlContent, BorderLayout.CENTER);
    }
    
    public void changeDate() {
    	formatter = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.getDefault());
        today = formatter.format(new Date());
        lblDate.setText(today);
    }
}

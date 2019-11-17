package studentskasluzba;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StatusBar extends JPanel{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StatusBar() {
        setLayout(new BorderLayout());
        
        JPanel statBar=new JPanel();
        Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension scSize = tk.getScreenSize();
		int width = scSize.width;
		statBar.setPreferredSize(new Dimension(width,30));
        
        
        statBar.setLayout(new BorderLayout());
        statBar.setBackground(Color.CYAN);
        
        JLabel text=new JLabel("Studentska slu\u017eba");
        JLabel datum=new JLabel();
        
        statBar.add(text, BorderLayout.WEST);
        statBar.add(datum,BorderLayout.EAST);
        
        Timer current=new Timer(0, new ActionListener() {
        	
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		Date today = new Date();
        		String currentTime=DateFormat.getDateTimeInstance().format(today);
        		datum.setText(currentTime);
        	}
        });
        
        current.start();
        
        add(statBar);        
}

}

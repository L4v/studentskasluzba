package studentskasluzba.view.dugmici;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PretraziDugme  extends JButton{
	private static final long serialVersionUID = -7782168700173673178L;
	public PretraziDugme(String tooltip)
	{
		super();
		try {
			this.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/icons/search.png"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setToolTipText(tooltip);
	}
}

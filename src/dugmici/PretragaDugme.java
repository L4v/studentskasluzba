package dugmici;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class PretragaDugme extends JButton{
	public PretragaDugme()
	{
		super();
		try {
			Image Icon = ImageIO.read(getClass().getResource("/icons/search.png"));
			this.setIcon(new ImageIcon(Icon));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setToolTipText("Pretraga");
	}
}

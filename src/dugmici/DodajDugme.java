package dugmici;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class DodajDugme extends JButton{
	public DodajDugme(String tooltip)
	{
		super();
		try {
			Image Icon = ImageIO.read(getClass().getResource("/icons/add-user.png"));
			this.setIcon(new ImageIcon(Icon));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setToolTipText(tooltip);
	}
}

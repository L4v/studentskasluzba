package studentskasluzba.view.dugmici;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class ObrisiDugme extends JButton{
	public ObrisiDugme()
	{
		super();
		try {
			Image Icon = ImageIO.read(getClass().getResource("/icons/delete.png"));
			this.setIcon(new ImageIcon(Icon));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setToolTipText("Obrisi");
	}
}

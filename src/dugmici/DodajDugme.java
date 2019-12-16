package dugmici;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import studentskasluzba.SelektovanTab;

@SuppressWarnings("serial")
public class DodajDugme extends JButton{
	private ImageIcon dodajStudenta;
	private ImageIcon dodajProfesora;
	private ImageIcon dodajPredmet;
	private ImageIcon current;
	public DodajDugme(String tooltip)
	{
		super();
		try {
			dodajStudenta = new ImageIcon(ImageIO.read(getClass().getResource("/icons/add-user.png")));
			dodajProfesora = new ImageIcon(ImageIO.read(getClass().getResource("/icons/add-prof.png")));
			dodajPredmet = new ImageIcon(ImageIO.read(getClass().getResource("/icons/add-subj.png")));
			current = dodajStudenta;
			this.setIcon(current);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setToolTipText(tooltip);
	}
	
	public void updateIcon(SelektovanTab s)
	{
		switch(s)
		{
			case STUDENT:
			{
				current = dodajStudenta;
				break;
			}
			case PROFESOR:
			{
				current = dodajProfesora;
				break;
			}
			case PREDMET:
			{
				current = dodajPredmet;
				break;
			}
			default:
			{
				return;
			}
		}
		this.setIcon(current);
	}
}

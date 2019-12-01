package studentskasluzba;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ComboBoxRendererProfesor extends JLabel implements ListCellRenderer<Profesor>{
	private static final long serialVersionUID = -1677021645261965090L;

	public ComboBoxRendererProfesor()
	{
		setBackground(Color.WHITE);
	}

	@Override	
	public Component getListCellRendererComponent(JList<? extends Profesor> arg0, Profesor arg1, int arg2, boolean arg3, boolean arg4) {
		setText(arg1.toString());
		return null;
	}



	
}

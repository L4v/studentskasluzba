package studentskasluzba.view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import studentskasluzba.view.dijalog.IzmenaPredmeta;

// NOTE(Jovan): Proverava da li je popunjeno polje, ako
// nije, osenci ga
public class IzmenaPredmetaFocusTxt implements FocusListener{

	private IzmenaPredmeta view;
	public IzmenaPredmetaFocusTxt(IzmenaPredmeta view)
	{
		this.view = view;
	}
	@Override
	public void focusGained(FocusEvent arg0) {
		JTextField text = (JTextField) arg0.getComponent();
		text.setBackground(Color.WHITE);
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		JTextField text = (JTextField)arg0.getComponent();
		if(text.getText().isEmpty())
		{
			text.setBackground(new Color(231, 76, 60));
			view.getPotvrdiButton().setEnabled(false);
		}
		else
		{
			view.getPotvrdiButton().setEnabled(true);
		}
	}

}

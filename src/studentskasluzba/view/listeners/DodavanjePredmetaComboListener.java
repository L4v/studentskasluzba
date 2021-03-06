package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import studentskasluzba.view.dijalog.DodavanjePredmeta;

public class DodavanjePredmetaComboListener implements ActionListener{
	private DodavanjePredmeta view;
	
	public DodavanjePredmetaComboListener(DodavanjePredmeta view)
	{
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// NOTE(jovan): Postavlja semestre u zavisnosti od selektovane godine
		int godina = (int)this.view.getGodina().getSelectedItem();
		this.view.getSemestar().removeAllItems();
		this.view.getSemestar().addItem(godina*2-1);
		this.view.getSemestar().addItem(godina*2);
	}

}

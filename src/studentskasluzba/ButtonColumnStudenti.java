package studentskasluzba;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import dijalog.StudentiNaPredmetu;

public class ButtonColumnStudenti extends AbstractCellEditor 
	implements TableCellRenderer, TableCellEditor
{
	private static final long serialVersionUID = -5505740600574406111L;
	private JButton renderButton;
	private JButton editorButton;
	private JTable table;
	
	public ButtonColumnStudenti(JTable table, int column)
	{
		this.table = table;
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		
		this.renderButton = new JButton("Prikazi");
		this.editorButton = new JButton("Prikazi");
		
		this.editorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentiNaPredmetu dialog = new StudentiNaPredmetu(column);
				dialog.setVisible(true);
			}
		});
	}
	
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTableCellEditorComponent(JTable arg0, Object arg1, boolean arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

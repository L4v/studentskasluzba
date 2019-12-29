package studentskasluzba.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import studentskasluzba.view.dijalog.StudentiNaPredmetu;

public class ButtonColumnStudenti extends AbstractCellEditor 
	implements TableCellRenderer, TableCellEditor, MouseListener
{
	private static final long serialVersionUID = -5505740600574406111L;
	private JButton renderButton;
	private JButton editorButton;
	private JTable table;
	private boolean isEditorActive = false;
	
	public ButtonColumnStudenti(JTable table, int column)
	{
		this.table = table;
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		this.table.getColumnModel().getColumn(column).setCellEditor(this);
		this.table.addMouseListener(this);
		
		this.renderButton = new JButton("Prikazi");
		this.editorButton = new JButton("Prikazi");
		
		this.editorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
				StudentiNaPredmetu dialog = new StudentiNaPredmetu(table.getSelectedRow());
				dialog.setVisible(true);
			}
		});
		this.isEditorActive = false;
	}
	
	@Override
	public Object getCellEditorValue() {
		
		return null;
	}

	@Override
	public Component getTableCellEditorComponent(JTable arg0, Object arg1, boolean arg2, int arg3, int arg4) {
		return this.editorButton;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		return this.renderButton;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(table.isEditing() && table.getCellEditor() == this)
		{
			isEditorActive = true;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(isEditorActive && table.isEditing())
		{
			table.getCellEditor().stopCellEditing();
		}
		isEditorActive = false;
		
	}
	
}

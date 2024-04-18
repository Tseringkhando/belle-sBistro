package View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import Controller.ListManagersController;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;

public class ListManagersView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tblMangers;
	private JScrollPane scrollPaneManagers ;
	/**
	 * Create the panel.
	 */
	public ListManagersView() {
		setLayout(null);
		
		ListManagersController controller = new ListManagersController(this);
		controller.viewLists();

		scrollPaneManagers.setBounds(10, 36, 631, 206);
		add(getScrollPane());


		JLabel lblNewLabel = new JLabel("Managers");
		lblNewLabel.setFont(new Font("Bell MT", Font.PLAIN, 14));
		lblNewLabel.setBounds(294, 21, 119, 14);
		add(lblNewLabel);
		
		
	}
	public JTable getEmpTable() {
		return tblMangers;
	}

	public JScrollPane getScrollPane() {
		return scrollPaneManagers;
	}

	public void setEmpTable(JTable tb) {
		tblMangers=tb;
	}

	public void setScrollPane(JScrollPane s) {
		scrollPaneManagers = s;
	}

}

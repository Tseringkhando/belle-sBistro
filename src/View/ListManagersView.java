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
	private JTextField textField;
	private JTextField txtManagerUsername;
	private JTable tblMangers;
	JButton btnGrantAccess, btnRevoke;
	JScrollPane scrollPaneManagers ;
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
		lblNewLabel.setBounds(295, 11, 119, 14);
		add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(255, 344, 223, 40);
		add(textField);
		textField.setColumns(10);

		JLabel txtManagerPassword = new JLabel("Password");
		txtManagerPassword.setFont(new Font("Bell MT", Font.PLAIN, 12));
		txtManagerPassword.setBounds(197, 357, 57, 14);
		add(txtManagerPassword);

		btnGrantAccess = new JButton("Grant Access");
		btnGrantAccess.setToolTipText("Grant manager access to login");
		btnGrantAccess.setForeground(Color.WHITE);
		btnGrantAccess.setFont(new Font("Bell MT", Font.PLAIN, 14));
		btnGrantAccess.setFocusPainted(false);
		btnGrantAccess.setBorder(null);
		btnGrantAccess.setBackground(new Color(0, 153, 102));
		btnGrantAccess.setBounds(188, 426, 122, 35);
		add(btnGrantAccess);

		btnRevoke = new JButton("Revoke");
		btnRevoke.setToolTipText("Revoke Access from Manager");
		btnRevoke.setForeground(Color.WHITE);
		btnRevoke.setFont(new Font("Bell MT", Font.PLAIN, 14));
		btnRevoke.setFocusPainted(false);
		btnRevoke.setBorder(null);
		btnRevoke.setBackground(new Color(64, 0, 0));
		btnRevoke.setBounds(362, 426, 116, 35);
		add(btnRevoke);

		JLabel lblNewLabel_1_1 = new JLabel(" Username");
		lblNewLabel_1_1.setFont(new Font("Bell MT", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(188, 294, 66, 14);
		add(lblNewLabel_1_1);

		txtManagerUsername = new JTextField();
		txtManagerUsername.setColumns(10);
		txtManagerUsername.setBounds(255, 281, 223, 40);
		add(txtManagerUsername);
		
		
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

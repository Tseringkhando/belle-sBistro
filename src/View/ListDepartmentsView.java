package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controller.ListDepartmentsController;

import javax.swing.JButton;
import java.awt.Color;

public class ListDepartmentsView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTable tblDept;
	JScrollPane scrollPaneDept;
	private JTextField txtDeptID;
	private JTextField txtDeptName;
	private JPanel panelDeptDetails;
	private JButton btnUpdateDept, btnDeleteDept;

	private int indexArray;
	/**
	 * Create the panel.
	 */
	public ListDepartmentsView() {
		setLayout(null);
		ListDepartmentsController c= new ListDepartmentsController(this);
		c.viewLists();


		JLabel lblNewLabel = new JLabel("List of Departments");
		lblNewLabel.setFont(new Font("Bell MT", Font.PLAIN, 14));
		lblNewLabel.setBounds(228, 11, 197, 38);
		add(lblNewLabel);


		scrollPaneDept.setBounds(33, 44, 529, 172);
		add(getPane());


		panelDeptDetails = new JPanel();
		panelDeptDetails.setBounds(33, 227, 529, 248);
		add(panelDeptDetails);
		panelDeptDetails.setLayout(null);

		JLabel lblDeptName = new JLabel("Dept ID");
		lblDeptName.setFont(new Font("Bell MT", Font.PLAIN, 12));
		lblDeptName.setBounds(10, 40, 101, 14);
		panelDeptDetails.add(lblDeptName);

		txtDeptID = new JTextField();
		txtDeptID.setEditable(false);
		txtDeptID.setBounds(101, 33, 234, 29);
		panelDeptDetails.add(txtDeptID);
		txtDeptID.setColumns(10);

		JLabel lblId = new JLabel("Dept Name");
		lblId.setFont(new Font("Bell MT", Font.PLAIN, 12));
		lblId.setBounds(10, 80, 101, 14);
		panelDeptDetails.add(lblId);

		txtDeptName = new JTextField();
		txtDeptName.setBorder(null);
		txtDeptName.setColumns(10);
		txtDeptName.setBounds(102, 72, 234, 30);
		panelDeptDetails.add(txtDeptName);

		btnUpdateDept = new JButton("Update");
		btnUpdateDept.setForeground(new Color(255, 255, 255));
		btnUpdateDept.setFont(new Font("Bell MT", Font.PLAIN, 12));
		btnUpdateDept.setBorderPainted(false);
		btnUpdateDept.setBorder(null);
		btnUpdateDept.setBackground(new Color(58, 139, 109));
		btnUpdateDept.setToolTipText("Update Data");
		btnUpdateDept.setBounds(102, 134, 101, 30);
		panelDeptDetails.add(btnUpdateDept);

		btnDeleteDept = new JButton("Delete");
		btnDeleteDept.setToolTipText("Delete Data");
		btnDeleteDept.setForeground(Color.WHITE);
		btnDeleteDept.setFont(new Font("Bell MT", Font.PLAIN, 12));
		btnDeleteDept.setBorderPainted(false);
		btnDeleteDept.setBorder(null);
		btnDeleteDept.setBackground(new Color(148, 50, 50));
		btnDeleteDept.setBounds(234, 134, 101, 30);
		panelDeptDetails.add(btnDeleteDept);
		rowSelected();
		setVisible(true);
		c.updateDepts(this);
		c.deleteDept(this);
	}

	
	// getters and setters for scrollpane and table as the data are pulled from model
	public void setScrollPane(JScrollPane js) {
		scrollPaneDept = js;
	}

	public void setTable(JTable t) {
		tblDept = t;
	}
	public JTable getDeptTable()
	{
		return tblDept;
	}
	public JScrollPane getPane()
	{	
		return scrollPaneDept;
	}
	
	public JButton getUpdateBtn() {
		return btnUpdateDept;
	}

	//To select each row and updata data we need getters and setters to find rows of table and index of row along with field values
	public void setIndex(int i) {
		indexArray= i;
	}

	public void fieldValue(String id, String n)
	{
		txtDeptID.setText(id);
		txtDeptName.setText(n);
	}

	public int getIndex() { return indexArray;}
	public String getID() {return txtDeptID.getText();}
	public String getName() { return txtDeptName.getText();}

	/**
	 * 
	 */
	public void rowSelected()
	{
		//getting current table 
		tblDept.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e)
			{
				int rowNum;
				// getting all values from selected row, store them and send those values to fill the form
				String id,name;
				DefaultTableModel m = (DefaultTableModel)tblDept.getModel();
				rowNum=tblDept.getSelectedRow();
				id= m.getValueAt(rowNum, 0).toString();
				name= m.getValueAt(rowNum,1).toString();

				fieldValue(id,name);
				setIndex(tblDept.getSelectedRow());
			}
		});
	}
	
	 public void addActionUpdateDepartment(ActionListener a)
	  {
	    btnUpdateDept.addActionListener(a);
	  }
	 
	 public void addActionDeleteDepartment(ActionListener a)
	  {
	    btnDeleteDept.addActionListener(a);
	  }
	
	
}

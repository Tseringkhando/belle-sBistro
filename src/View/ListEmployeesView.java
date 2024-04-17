package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;

import Controller.ListEmployeesController;
import Model.Employees;
import Model.ListEmployeesModel;

public class ListEmployeesView extends JPanel {

  private static final long serialVersionUID = 1L;
  private JTable tblEmployees;
  private JScrollPane scrollPaneEmployees;
  private int indexArray, empId;
  private Employees employees;
  private JTextField txtFname;
  private JTextField txtLname;
  private JTextField txtSin;
  private JTextField txtAddres;
  private JTextField txtEmail;
  private JButton btnUpdate, btnDelete;
  private JComboBox cmbRole, cmbType, cmbDept;
  private JSpinner paySpinner, hireDateSpinner, dobSpinner;
  /**
   * Create the panel.
   */
  public ListEmployeesView() {
    setLayout(null);
    //      sending view to controller
    ListEmployeesController controller = new ListEmployeesController(this);
    controller.viewLists();
    
    JLabel lblNewLabel = new JLabel("Employees");
    lblNewLabel.setFont(new Font("Bell MT", Font.PLAIN, 14));
    lblNewLabel.setBounds(278, 11, 153, 14);
    add(lblNewLabel);

    scrollPaneEmployees.setBounds(10, 31, 586, 185);
    add(getScrollPane());

    JPanel panel = new JPanel();
    panel.setBounds(10, 217, 592, 446);
    add(panel);
    panel.setLayout(null);

    JLabel lblNewLabel_1 = new JLabel("Employee Details");
    lblNewLabel_1.setFont(new Font("Bell MT", Font.PLAIN, 14));
    lblNewLabel_1.setBounds(234, 11, 163, 14);
    panel.add(lblNewLabel_1);

    JLabel lblFname = new JLabel("First Name");
    lblFname.setForeground(new Color(0, 0, 64));
    lblFname.setFont(new Font("Bell MT", Font.PLAIN, 12));
    lblFname.setBounds(90, 36, 76, 23);
    panel.add(lblFname);

    JLabel lblLastName = new JLabel("Last Name");
    lblLastName.setForeground(new Color(0, 0, 64));
    lblLastName.setFont(new Font("Bell MT", Font.PLAIN, 12));
    lblLastName.setBounds(90, 66, 76, 23);
    panel.add(lblLastName);

    JLabel lblDateOfBirth = new JLabel("Date of Birth");
    lblDateOfBirth.setForeground(new Color(0, 0, 64));
    lblDateOfBirth.setFont(new Font("Bell MT", Font.PLAIN, 12));
    lblDateOfBirth.setBounds(90, 100, 76, 23);
    panel.add(lblDateOfBirth);

    JLabel lblSin = new JLabel("SIN");
    lblSin.setForeground(new Color(0, 0, 64));
    lblSin.setFont(new Font("Bell MT", Font.PLAIN, 12));
    lblSin.setBounds(90, 136, 76, 23);
    panel.add(lblSin);

    JLabel lblAddress = new JLabel("Address");
    lblAddress.setForeground(new Color(0, 0, 64));
    lblAddress.setFont(new Font("Bell MT", Font.PLAIN, 12));
    lblAddress.setBounds(90, 167, 76, 23);
    panel.add(lblAddress);

    JLabel lblHiredDate = new JLabel("Hired Date");
    lblHiredDate.setForeground(new Color(0, 0, 64));
    lblHiredDate.setFont(new Font("Bell MT", Font.PLAIN, 12));
    lblHiredDate.setBounds(90, 201, 76, 23);
    panel.add(lblHiredDate);

    JLabel lblHiredDate_1 = new JLabel("Email");
    lblHiredDate_1.setForeground(new Color(0, 0, 64));
    lblHiredDate_1.setFont(new Font("Bell MT", Font.PLAIN, 12));
    lblHiredDate_1.setBounds(90, 235, 76, 23);
    panel.add(lblHiredDate_1);

    JLabel lblRole = new JLabel("Role");
    lblRole.setForeground(new Color(0, 0, 64));
    lblRole.setFont(new Font("Bell MT", Font.PLAIN, 12));
    lblRole.setBounds(90, 269, 76, 23);
    panel.add(lblRole);

    JLabel lblType = new JLabel("Type");
    lblType.setForeground(new Color(0, 0, 64));
    lblType.setFont(new Font("Bell MT", Font.PLAIN, 12));
    lblType.setBounds(90, 295, 233, 23);
    panel.add(lblType);

    JLabel lblHourlyPayRate = new JLabel("Hourly Pay ");
    lblHourlyPayRate.setForeground(new Color(0, 0, 64));
    lblHourlyPayRate.setFont(new Font("Bell MT", Font.PLAIN, 12));
    lblHourlyPayRate.setBounds(343, 296, 66, 27);
    panel.add(lblHourlyPayRate);

    txtFname = new JTextField();
    txtFname.setEditable(false);
    txtFname.setSelectionColor(new Color(255, 128, 128));
    txtFname.setFont(new Font("Bell MT", Font.PLAIN, 12));
    txtFname.setColumns(10);
    txtFname.setBounds(176, 36, 319, 23);
    panel.add(txtFname);

    txtLname = new JTextField();
    txtLname.setSelectionColor(new Color(255, 128, 128));
    txtLname.setFont(new Font("Bell MT", Font.PLAIN, 12));
    txtLname.setColumns(10);
    txtLname.setBounds(176, 65, 319, 23);
    panel.add(txtLname);

    SpinnerDateModel dobModel = new SpinnerDateModel();
    // Setting the date editor with the desired format
    dobSpinner = new JSpinner(dobModel);
    dobSpinner.setEditor(new JSpinner.DateEditor(dobSpinner, "MMM dd, yyyy"));
    dobSpinner.setBounds(176, 100, 319, 20);
    panel.add(dobSpinner);

    txtSin = new JTextField();
    txtSin.setSelectionColor(new Color(255, 128, 128));
    txtSin.setFont(new Font("Bell MT", Font.PLAIN, 12));
    txtSin.setColumns(10);
    txtSin.setBounds(176, 136, 319, 23);
    panel.add(txtSin);

    txtAddres = new JTextField();
    txtAddres.setSelectionColor(new Color(255, 128, 128));
    txtAddres.setFont(new Font("Bell MT", Font.PLAIN, 12));
    txtAddres.setColumns(10);
    txtAddres.setBounds(176, 167, 319, 23);
    panel.add(txtAddres);


    SpinnerDateModel hireModel = new SpinnerDateModel();
    hireDateSpinner = new JSpinner(hireModel);
    hireDateSpinner.setEditor(new JSpinner.DateEditor(hireDateSpinner, "MMM dd, yyyy"));
    hireDateSpinner.setBounds(176, 201, 319, 20);
    panel.add(hireDateSpinner);

    txtEmail = new JTextField();
    txtEmail.setSelectionColor(new Color(255, 128, 128));
    txtEmail.setFont(new Font("Bell MT", Font.PLAIN, 12));
    txtEmail.setColumns(10);
    
    txtEmail.setBounds(176, 235, 319, 23);
    panel.add(txtEmail);

    cmbRole = new JComboBox();
    cmbRole.setModel(new DefaultComboBoxModel(new String[] {"Employee", "Manager"}));
    cmbRole.setBounds(174, 268, 149, 22);
    panel.add(cmbRole);

    cmbType = new JComboBox();
    cmbType.setModel(new DefaultComboBoxModel(new String[] {"Full - Time", "Part - Time","Contract"}));
    cmbType.setBounds(174, 295, 149, 22);
    panel.add(cmbType);

    SpinnerNumberModel paySpinnerModel = new SpinnerNumberModel(16.55, 1.0, null, 0.1);  
    paySpinner = new JSpinner(paySpinnerModel);
    paySpinner.setEditor(new JSpinner.NumberEditor(paySpinner, "#.##"));
    paySpinner.setFont(new Font("Bell MT", Font.PLAIN, 11));
    paySpinner.setFont(new Font("Bell MT", Font.PLAIN, 11));
    paySpinner.setBounds(419, 295, 141, 29);
    panel.add(paySpinner);

    btnDelete = new JButton("Delete");
    btnDelete.setToolTipText("Delete the employee details");
    btnDelete.setForeground(Color.WHITE);
    btnDelete.setFont(new Font("Bell MT", Font.PLAIN, 14));
    btnDelete.setFocusPainted(false);
   
    btnDelete.setBackground(new Color(64, 0, 0));
    btnDelete.setBounds(364, 351, 116, 35);
    panel.add(btnDelete);

    btnUpdate = new JButton("Update");
    btnUpdate.setToolTipText("Save details");
    btnUpdate.setForeground(Color.WHITE);
    btnUpdate.setFont(new Font("Bell MT", Font.PLAIN, 14));
    btnUpdate.setFocusPainted(false);
    
    btnUpdate.setBackground(new Color(0, 153, 102));
    btnUpdate.setBounds(193, 351, 122, 35);
    panel.add(btnUpdate);
    
    JLabel lblDepartment = new JLabel("Department");
    lblDepartment.setForeground(new Color(0, 0, 64));
    lblDepartment.setFont(new Font("Bell MT", Font.PLAIN, 12));
    lblDepartment.setBounds(337, 269, 76, 23);
    panel.add(lblDepartment);
    
    cmbDept = new JComboBox();
    cmbDept.setBounds(413, 269, 147, 22);
    panel.add(cmbDept);


    
    // Listen for row selection in the table
    tblEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent e)
      {
        updateFieldsFromSelectedRow();
      }
    });

    disableFields();
    setVisible(true);
    controller.initializeComponents();
    controller.updateEmployeeData(this);
    controller.deleteEmp(this);
    
  }

  public void addUpdateEmpListener(ActionListener a) {
    btnUpdate.addActionListener(a);
  }
  public void addDeleteEmpListener(ActionListener a)
  {
    btnDelete.addActionListener(a);
  }
  public JTable getEmpTable() {
    return tblEmployees;
  }

  public JScrollPane getScrollPane() {
    return scrollPaneEmployees;
  }

  public void setEmpTable(JTable tb) {
    tblEmployees=tb;
  }

  public void setScrollPane(JScrollPane s) {
    scrollPaneEmployees = s;
  }

  public Employees getEmployees() {
    return employees;
  }

  public int getIndex() {
    return indexArray;
  }
  
//Getters
  public JTextField getTxtFname() {
      return txtFname;
  }

  public JTextField getTxtLname() {
      return txtLname;
  }

  public JTextField getTxtSin() {
      return txtSin;
  }

  public JTextField getTxtAddres() {
      return txtAddres;
  }

  public JTextField getTxtEmail() {
      return txtEmail;
  }

  public JComboBox getCmbRole() {
      return cmbRole;
  }

  public JComboBox getCmbType() {
      return cmbType;
  }

  public JSpinner getPaySpinner() {
      return paySpinner;
  }

  public JSpinner getHireDateSpinner() {
      return hireDateSpinner;
  }

  public JSpinner getDobSpinner() {
      return dobSpinner;
  }
public JButton getBtnUpdate() {
  return btnUpdate;
}

public JButton getBtnDelete() {
  return btnDelete;
}

private void setEmpID(int id) {
  empId = id;

}

public JComboBox getDepartmentComboBox() {
  return cmbDept;
}

public int getEmpid() {
  return empId;
}

  /**
   * This method lets user to get the full details of employee and update it
   * specifically done by Tsering
   * 
   */
  private void updateFieldsFromSelectedRow() {
    int selectedRow = tblEmployees.getSelectedRow();

    if (selectedRow >= 0) {
      enableFields();
      indexArray = selectedRow;
      // all rows
      empId = Integer.parseInt(tblEmployees.getValueAt(selectedRow, 0).toString());
      String firstName = tblEmployees.getValueAt(selectedRow, 1).toString();
      String lastName = tblEmployees.getValueAt(selectedRow, 2).toString();
      String sin = tblEmployees.getValueAt(selectedRow, 3).toString();
      String address = tblEmployees.getValueAt(selectedRow, 4).toString();
      String email = tblEmployees.getValueAt(selectedRow, 5).toString();
      String role = tblEmployees.getValueAt(selectedRow, 6).toString();
      String type = tblEmployees.getValueAt(selectedRow, 7).toString();
      String dob = tblEmployees.getValueAt(selectedRow, 8).toString();
      String hireDate = tblEmployees.getValueAt(selectedRow, 9).toString();
      String hourlyPay = tblEmployees.getValueAt(selectedRow, 10).toString();
      String deptName  = tblEmployees.getValueAt(selectedRow, 11).toString();


      // Update fields
      getTxtFname().setText(firstName);
      getTxtLname().setText(lastName);
      getTxtSin().setText(sin);
      getTxtEmail().setText(email);
      getTxtAddres().setText(address);
      getCmbRole().setSelectedItem(role);
      getCmbType().setSelectedItem(type);
      getDepartmentComboBox().setSelectedItem(deptName);
      // Setup date format to parse the input date/ format from spinner is  EEE MMM dd HH:mm:ss zzz yyyy
      SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
      SimpleDateFormat spinnerFormat = new SimpleDateFormat("MMM dd, yyyy");

      try {
        // Parse the dates and set them in the spinners
        Date dobDate = inputFormat.parse(dob);
        Date hireDateDate = inputFormat.parse(hireDate);

        getDobSpinner().setValue(spinnerFormat.parse(spinnerFormat.format(dobDate)));
        getHireDateSpinner().setValue(spinnerFormat.parse(spinnerFormat.format(hireDateDate)));
      } catch (Exception e) {
        System.err.println("Error parsing dates: " + e.getMessage());
      }

      // Parse and set the hourly pay
      try {
        Double payDouble = Double.parseDouble(hourlyPay);
        getPaySpinner().setValue(payDouble);
        
      } catch (NumberFormatException e) {
        System.err.println("Error parsing hourly pay: " + e.getMessage());
      }
    }else {disableFields();}
  }
  
  
  private void enableFields() {
      txtFname.setEditable(true);
      txtLname.setEditable(true);
      txtSin.setEditable(true);
      txtAddres.setEditable(true);
      txtEmail.setEditable(true);
      cmbRole.setEnabled(true);
      cmbType.setEnabled(true);
      dobSpinner.setEnabled(true);
      hireDateSpinner.setEnabled(true);
      paySpinner.setEnabled(true);
      btnUpdate.setEnabled(true);
      btnDelete.setEnabled(true);
      cmbDept.setEnabled(true);
  }
  
  
  private void disableFields() {
      txtLname.setEditable(false);
      txtSin.setEditable(false);
      txtAddres.setEditable(false);
      txtEmail.setEditable(false);
      cmbRole.setEnabled(false);
      cmbType.setEnabled(false);
      dobSpinner.setEnabled(false);
      hireDateSpinner.setEnabled(false);
      paySpinner.setEnabled(false);
      btnUpdate.setEnabled(false);
      btnDelete.setEnabled(false);
      cmbDept.setEnabled(false);
  }
}

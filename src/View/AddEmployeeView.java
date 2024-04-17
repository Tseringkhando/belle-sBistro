package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.text.Format;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.SpinnerNumberModel;

import Controller.AddEmployeeController;
import Model.DepartmentLoader;
import Model.Employees;

import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

public class AddEmployeeView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtSin;
	private JTextField txtAddres;
	private JTextField txtEmail;
	private JButton btnSaveEmp, btnClear;
	private JComboBox cmbRole, cmbType;
	private JSpinner paySpinner, hireDateSpinner, dobSpinner;
	private JLabel lblTitle ;
	private JLabel lblDepartment;
	private JComboBox cmbDept;
	/**
	 * Create the panel.
	 */
	public AddEmployeeView() {
		setLayout(null);
		
		lblTitle= new JLabel("Add New Employee");
		lblTitle.setFont(new Font("Bell MT", Font.PLAIN, 14));
		lblTitle.setBounds(253, 26, 138, 14);
		add(lblTitle);
		
		JLabel lblFname = new JLabel("First Name");
		lblFname.setForeground(new Color(0, 0, 64));
		lblFname.setFont(new Font("Bell MT", Font.PLAIN, 12));
		lblFname.setBounds(86, 62, 76, 23);
		add(lblFname);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(new Color(0, 0, 64));
		lblLastName.setFont(new Font("Bell MT", Font.PLAIN, 12));
		lblLastName.setBounds(86, 92, 76, 23);
		add(lblLastName);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setForeground(new Color(0, 0, 64));
		lblDateOfBirth.setFont(new Font("Bell MT", Font.PLAIN, 12));
		lblDateOfBirth.setBounds(86, 126, 76, 23);
		add(lblDateOfBirth);
		
		JLabel lblSin = new JLabel("SIN");
		lblSin.setForeground(new Color(0, 0, 64));
		lblSin.setFont(new Font("Bell MT", Font.PLAIN, 12));
		lblSin.setBounds(86, 162, 76, 23);
		add(lblSin);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(new Color(0, 0, 64));
		lblAddress.setFont(new Font("Bell MT", Font.PLAIN, 12));
		lblAddress.setBounds(86, 193, 76, 23);
		add(lblAddress);
	
		JLabel lblRole = new JLabel("Role");
		lblRole.setForeground(new Color(0, 0, 64));
		lblRole.setFont(new Font("Bell MT", Font.PLAIN, 12));
		lblRole.setBounds(86, 295, 76, 23);
		add(lblRole);
		
		JLabel lblHiredDate = new JLabel("Hired Date");
		lblHiredDate.setForeground(new Color(0, 0, 64));
		lblHiredDate.setFont(new Font("Bell MT", Font.PLAIN, 12));
		lblHiredDate.setBounds(86, 227, 76, 23);
		add(lblHiredDate);
		
		JLabel lblHiredDate_1 = new JLabel("Email");
		lblHiredDate_1.setForeground(new Color(0, 0, 64));
		lblHiredDate_1.setFont(new Font("Bell MT", Font.PLAIN, 12));
		lblHiredDate_1.setBounds(86, 261, 76, 23);
		add(lblHiredDate_1);
		
		JLabel lblType = new JLabel("Type");
		lblType.setForeground(new Color(0, 0, 64));
		lblType.setFont(new Font("Bell MT", Font.PLAIN, 12));
		lblType.setBounds(86, 322, 76, 23);
		add(lblType);
		
		txtFname = new JTextField();
		txtFname.setSelectionColor(new Color(255, 128, 128));
		txtFname.setFont(new Font("Bell MT", Font.PLAIN, 12));
		txtFname.setBorder(null);
		txtFname.setBounds(174, 63, 319, 23);
		add(txtFname);
		txtFname.setColumns(10);
		
		txtLname = new JTextField();
		txtLname.setSelectionColor(new Color(255, 128, 128));
		txtLname.setFont(new Font("Bell MT", Font.PLAIN, 12));
		txtLname.setColumns(10);
		txtLname.setBorder(null);
		txtLname.setBounds(174, 92, 319, 23);
		add(txtLname);
		
		
		txtSin = new JTextField();
		txtSin.setSelectionColor(new Color(255, 128, 128));
		txtSin.setFont(new Font("Bell MT", Font.PLAIN, 12));
		txtSin.setColumns(10);
		txtSin.setBorder(null);
		txtSin.setBounds(174, 163, 319, 23);
		add(txtSin);
		
		txtAddres = new JTextField();
		txtAddres.setSelectionColor(new Color(255, 128, 128));
		txtAddres.setFont(new Font("Bell MT", Font.PLAIN, 12));
		txtAddres.setColumns(10);
		txtAddres.setBorder(null);
		txtAddres.setBounds(174, 194, 319, 23);
		add(txtAddres);
		
		txtEmail = new JTextField();
		txtEmail.setSelectionColor(new Color(255, 128, 128));
		txtEmail.setFont(new Font("Bell MT", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBounds(174, 262, 319, 23);
		add(txtEmail);
		
		cmbRole = new JComboBox();
		cmbRole.setModel(new DefaultComboBoxModel(new String[] {"Employee", "Manager"}));
		cmbRole.setBounds(172, 295, 167, 22);
		add(cmbRole);
		
		cmbType = new JComboBox();
		cmbType.setModel(new DefaultComboBoxModel(new String[] {"Full - Time", "Part - Time", "Contract"}));
		cmbType.setBounds(172, 322, 167, 22);
		add(cmbType);
		
		 // button customization
		btnSaveEmp = new JButton("Save");
        btnSaveEmp.setBackground(new Color(0, 153, 102)); 
        btnSaveEmp.setForeground(Color.WHITE); 
        btnSaveEmp.setFont(new Font("Bell MT", Font.PLAIN, 14));
        btnSaveEmp.setFocusPainted(false);
        btnSaveEmp.setBorder(null);
        btnSaveEmp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
        btnSaveEmp.setBounds(203, 432, 122, 35); 
        add(btnSaveEmp);
		
		btnClear = new JButton("Clear");
		btnClear.setToolTipText("Reset");
		btnClear.setBounds(377, 432, 116, 35);
		btnClear.setBackground(new Color(64, 0, 0)); 
		btnClear.setForeground(Color.WHITE); 
        btnClear.setFont(new Font("Bell MT", Font.PLAIN, 14)); 
        btnClear.setFocusPainted(false); 
        btnClear.setBorder(null); // No border
        btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnClear);
	
		
		
		JLabel lblHourlyPayRate = new JLabel("Hourly Pay ");
		lblHourlyPayRate.setForeground(new Color(0, 0, 64));
		lblHourlyPayRate.setFont(new Font("Bell MT", Font.PLAIN, 12));
		lblHourlyPayRate.setBounds(86, 356, 61, 23);
		add(lblHourlyPayRate);
		
		
		// (initial, min, max, step)
		SpinnerNumberModel paySpinnerModel = new SpinnerNumberModel(16.55, 1.0, null, 0.1);  
		paySpinner = new JSpinner(paySpinnerModel);
		paySpinner.setEditor(new JSpinner.NumberEditor(paySpinner, "#.##"));
		paySpinner.setFont(new Font("Bell MT", Font.PLAIN, 11));
		paySpinner.setBounds(174, 355, 165, 20);
		add(paySpinner);
		
		SpinnerDateModel dobModel = new SpinnerDateModel();
		// Setting the date editor with the desired format
		dobSpinner = new JSpinner(dobModel);
		dobSpinner.setEditor(new JSpinner.DateEditor(dobSpinner, "MMM dd, yyyy"));
		dobSpinner.setBounds(174, 127, 319, 20);
		
		add(dobSpinner);

	
		SpinnerDateModel hireModel = new SpinnerDateModel();
		hireDateSpinner = new JSpinner(hireModel);
		hireDateSpinner.setEditor(new JSpinner.DateEditor(hireDateSpinner, "MMM dd, yyyy"));
		hireDateSpinner.setBounds(174, 228, 319, 20);
		add(hireDateSpinner);
		
		// sending the view to controller 
		AddEmployeeController controller = new AddEmployeeController(this);
		
		lblDepartment = new JLabel("Department");
		lblDepartment.setForeground(new Color(0, 0, 64));
		lblDepartment.setFont(new Font("Bell MT", Font.PLAIN, 12));
		lblDepartment.setBounds(86, 387, 76, 23);
		add(lblDepartment);
		
		cmbDept = new JComboBox();
		cmbDept.setBounds(172, 387, 167, 22);
		controller.initializeDepartments();
		add(cmbDept);
		controller.empController();
	}
	
	/**
	 * method to add action listener to buttons
	 */
	
	public void addSaveEmpAction(ActionListener a) {
		getBtnSaveEmp().addActionListener(a);
	}
	
	public void addClearAction(ActionListener a) {
		getBtnClear().addActionListener(a);
	}
	
	// Getters
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

    public JButton getBtnSaveEmp() {
        return btnSaveEmp;
    }

    public JButton getBtnClear() {
        return btnClear;
    }
    
    public JLabel getLblTitle() {
    	return lblTitle;
    }
    
    public JComboBox getDepartmentComboBox() {
		return cmbDept;
	}
    // Setters
    
   
    public void setTxtFname(JTextField txtFname) {
        this.txtFname = txtFname;
    }

    public void setTxtLname(JTextField txtLname) {
        this.txtLname = txtLname;
    }

    public void setTxtSin(JTextField txtSin) {
        this.txtSin = txtSin;
    }

    public void setTxtAddres(JTextField txtAddres) {
        this.txtAddres = txtAddres;
    }

    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public void setCmbRole(JComboBox cmbRole) {
        this.cmbRole = cmbRole;
    }

    public void setCmbType(JComboBox cmbType) {
        this.cmbType = cmbType;
    }

    public void setPaySpinner(JSpinner paySpinner) {
        this.paySpinner = paySpinner;
    }

    public void setHireDateSpinner(JSpinner hireDateSpinner) {
        this.hireDateSpinner = hireDateSpinner;
    }

    public void setDobSpinner(JSpinner dobSpinner) {
        this.dobSpinner = dobSpinner;
    }

    public void setBtnSaveEmp(JButton btnSaveEmp) {
        this.btnSaveEmp = btnSaveEmp;
    }

    public void setBtnClear(JButton btnClear) {
        this.btnClear = btnClear;
    }
    
    public void setDepartmentComboBox(JComboBox cmb)  {
		cmbDept = cmb;
	}
}

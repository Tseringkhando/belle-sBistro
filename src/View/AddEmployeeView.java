package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.text.Format;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class AddEmployeeView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtSin;
	private JTextField txtAddres;
	private JTextField txtEmail;

	/**
	 * Create the panel.
	 */
	public AddEmployeeView() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add New Employee");
		lblNewLabel.setFont(new Font("Bell MT", Font.PLAIN, 14));
		lblNewLabel.setBounds(253, 26, 138, 14);
		add(lblNewLabel);
		
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
		
		// Create a DateFormatter for the date format we want
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        JFormattedTextField txtDob = new JFormattedTextField(format);
        txtDob.setText("yyyy-mm-dd");
        txtDob.setToolTipText("yyyy-MM-dd");
        txtDob.setBorder(null);
        txtDob.setColumns(10); 
		txtDob.setBounds(174, 123, 319, 29);
		add(txtDob);
		
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
		
		JFormattedTextField txtHireDate = new JFormattedTextField((Format) null);
		txtHireDate.setToolTipText("yyyy-MM-dd");
		txtHireDate.setText("yyyy-mm-dd");
		txtHireDate.setColumns(10);
		txtHireDate.setBorder(null);
		txtHireDate.setBounds(174, 228, 319, 29);
		add(txtHireDate);
		
		txtEmail = new JTextField();
		txtEmail.setSelectionColor(new Color(255, 128, 128));
		txtEmail.setFont(new Font("Bell MT", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBounds(174, 262, 319, 23);
		add(txtEmail);
		
		JComboBox cmbRole = new JComboBox();
		cmbRole.setModel(new DefaultComboBoxModel(new String[] {"Employee", "Manager"}));
		cmbRole.setBounds(172, 295, 167, 22);
		add(cmbRole);
		
		JComboBox cmbType = new JComboBox();
		cmbType.setModel(new DefaultComboBoxModel(new String[] {"Full - Time", "Part - Time"}));
		cmbType.setBounds(172, 322, 167, 22);
		add(cmbType);
		
		JButton btnSaveEmp = new JButton("Save");
		btnSaveEmp.setToolTipText("Add new employee");
		btnSaveEmp.setBorder(null);
		btnSaveEmp.setBounds(174, 381, 107, 29);
		add(btnSaveEmp);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setToolTipText("Reset");
		btnClear.setBorder(null);
		btnClear.setBounds(386, 384, 107, 29);
		add(btnClear);

	}
}

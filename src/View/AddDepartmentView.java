package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Controller.AddDepartmentController;
import java.awt.SystemColor;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

/**
 * A panel for adding new departments, part of the department management module.
 */
public class AddDepartmentView extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtDeptID, txtDeptName;
    private JButton btnAddDept;

    /**
     * Constructs the AddDepartmentView panel.
     */
    public AddDepartmentView() {
        setBackground(Color.WHITE);
        setLayout(null);

        // Department title label
        JLabel lblNewDept = new JLabel("Add Department");
        lblNewDept.setFont(new Font("Bell MT", Font.PLAIN, 21));
        lblNewDept.setBounds(241, 95, 160, 34);
        add(lblNewDept);

        // Button for adding a new department
        btnAddDept = new JButton("Save");
        setupSaveButton();

        // Labels and fields for department code
        JLabel lblDeptId = new JLabel("Department Code");
        lblDeptId.setBounds(164, 152, 160, 34);
        add(lblDeptId);
        
        txtDeptID = new JTextField();
        txtDeptID.setBorder(new LineBorder(new Color(171, 173, 179)));
        txtDeptID.setOpaque(false);
        txtDeptID.setBounds(164, 181, 291, 34);
        add(txtDeptID);
        txtDeptID.setColumns(10);

        // Labels and fields for department name
        JLabel lblDepartmentName = new JLabel("Department Name");
        lblDepartmentName.setBounds(164, 215, 160, 34);
        add(lblDepartmentName);
        
        txtDeptName = new JTextField();
        txtDeptName.setOpaque(false);
        txtDeptName.setColumns(10);
        txtDeptName.setBorder(new LineBorder(new Color(171, 173, 179)));
        txtDeptName.setBounds(164, 247, 291, 34);
        add(txtDeptName);

        // Initialize the controller which handles adding departments
        initController();
    }

    /**
     * Initializes the department controller and sets up the button to handle saving.
     */
    private void initController() {
        AddDepartmentController deptControl = new AddDepartmentController(this);
        deptControl.deptCheckButton();
    }

    /**
     * Configures the properties of the save button.
     */
    private void setupSaveButton() {
        btnAddDept.setBorder(null);
        btnAddDept.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAddDept.setBackground(SystemColor.inactiveCaption);
        btnAddDept.setToolTipText("Add department");
        btnAddDept.setForeground(Color.WHITE);
        btnAddDept.setFont(new Font("Bell MT", Font.PLAIN, 14));
        btnAddDept.setFocusPainted(false);
        btnAddDept.setBounds(164, 331, 291, 40);
        add(btnAddDept);
    }

    /**
     * Adds an action listener to the save button.
     * @param a The action listener to attach to the save button.
     */
    public void addActionSave(ActionListener a) {
        btnAddDept.addActionListener(a);
    }

    /**
     * Gets the department ID text field.
     * @return the JTextField for department ID.
     */
    public JTextField getDeptID() {
        return txtDeptID;
    }

    /**
     * Gets the department name text field.
     * @return the JTextField for department name.
     */
    public JTextField getDeptName() {
        return txtDeptName;
    }
}

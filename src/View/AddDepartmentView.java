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

import Controller.*;
import java.awt.SystemColor;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class AddDepartmentView extends JPanel {

  private static final long serialVersionUID = 1L;
  private JTextField txtDeptID, txtDeptName;
  private JButton btnAddDept;

  /**
   * Create the panel.
   */
  public AddDepartmentView() {
    setBackground(new Color(255, 255, 255));
    setLayout(null);
    
    JLabel lblNewDept = new JLabel("Add Department");
    lblNewDept.setFont(new Font("Bell MT", Font.PLAIN, 21));
    lblNewDept.setBounds(241, 95, 160, 34);
    add(lblNewDept);
    
    btnAddDept = new JButton("Save");
    btnAddDept.setBorder(null);
    btnAddDept.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnAddDept.setBackground(SystemColor.inactiveCaption);
    btnAddDept.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    btnAddDept.setToolTipText("Add department");
    btnAddDept.setForeground(Color.WHITE);
    btnAddDept.setFont(new Font("Bell MT", Font.PLAIN, 14));
    btnAddDept.setFocusPainted(false);
    btnAddDept.setBounds(164, 331, 291, 40);
    add(btnAddDept);
    
    JLabel lblDeptId = new JLabel("Department ID");
    lblDeptId.setBounds(164, 152, 160, 34);
    add(lblDeptId);
    
    txtDeptID = new JTextField();
    txtDeptID.setBorder(new LineBorder(new Color(171, 173, 179)));
    txtDeptID.setOpaque(false);
    txtDeptID.setBounds(164, 181, 291, 34);
    add(txtDeptID);
    txtDeptID.setColumns(10);
    
    JLabel lblDepartmentName = new JLabel("Department Name");
    lblDepartmentName.setBounds(164, 215, 160, 34);
    add(lblDepartmentName);
    
    txtDeptName = new JTextField();
    txtDeptName.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    txtDeptName.setOpaque(false);
    txtDeptName.setColumns(10);
    txtDeptName.setBorder(new LineBorder(new Color(171, 173, 179)));
    txtDeptName.setBounds(164, 247, 291, 34);
    add(txtDeptName);
    setVisible(true);
//    calling controller to save data
    AddDepartmentController deptControl = new AddDepartmentController(this);
    deptControl.deptCheckButton();
  }
  
  public void addActionSave(ActionListener a)
  {
    btnAddDept.addActionListener(a);
  }
  
  
  //accessors and mutators
  public JTextField getDeptID()
	{
		return txtDeptID;
	}
	
	public JTextField getDeptName() {
		return txtDeptName;
	}
	
  

  

}

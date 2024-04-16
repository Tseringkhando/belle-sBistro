package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.function.ToDoubleBiFunction;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;

public class AdminView extends JFrame {

	private static final long serialVersionUID = 1L;
	ImageIcon icon = new ImageIcon("icon.jpg");
	private JPanel contentPane, jpSideBar, jpContent;
	private JButton btnHome, btnDepartments, btnManagers, btnEmployees, btnAddEmployee, btnAddDepartment, btnLogout, btnCredentials;
	private JLabel lblNewLabel;
	private JMenuItem mntmExit ;

	/**
	 * Create the frame.
	 */
	public AdminView() {
		setTitle("Belle's System");
		setIconImage(icon.getImage());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 900, 700);
		getContentPane().setBackground(new Color(231, 231, 231));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Home");
		menuBar.add(mnNewMenu);

		mntmExit = new JMenuItem("Exit");
		mnNewMenu.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				confirmAndExit();
			}
		});
		setContentPane(contentPane);
		contentPane.setLayout(null);

		jpSideBar = new JPanel();
		jpSideBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jpSideBar.setBackground(new Color(183, 9, 21));
		jpSideBar.setBounds(0, 0, 234, 665);
		contentPane.add(jpSideBar);
		jpSideBar.setLayout(null);

		btnHome = new JButton("Home");
		btnHome.setToolTipText("Go to homepage");
		btnHome.setForeground(new Color(255, 255, 255));
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setFocusPainted(false);
		btnHome.setFont(new Font("Bell MT", Font.PLAIN, 14));
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setBounds(-13, 156, 257, 40);
		jpSideBar.add(btnHome);
		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				homeScreen();

			}
		});

		btnManagers = new JButton("Managers");
		btnManagers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnManagers.setToolTipText("View Managers Page");
		btnManagers.setForeground(Color.WHITE);
		btnManagers.setFont(new Font("Bell MT", Font.PLAIN, 14));
		btnManagers.setFocusPainted(false);
		btnManagers.setContentAreaFilled(false);
		btnManagers.setBorderPainted(false);
		btnManagers.setBounds(-13, 197, 257, 40);
		jpSideBar.add(btnManagers);

		btnDepartments = new JButton("Departments");
		btnDepartments.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDepartments.setToolTipText("View Departments");
		btnDepartments.setForeground(Color.WHITE);
		btnDepartments.setFont(new Font("Bell MT", Font.PLAIN, 14));
		btnDepartments.setFocusPainted(false);
		btnDepartments.setContentAreaFilled(false);
		btnDepartments.setBorderPainted(false);
		btnDepartments.setBounds(-13, 236, 257, 40);
		jpSideBar.add(btnDepartments);

		btnEmployees = new JButton("Employees");
		btnEmployees.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEmployees.setToolTipText("Go to Employees page");
		btnEmployees.setForeground(Color.WHITE);
		btnEmployees.setFont(new Font("Bell MT", Font.PLAIN, 14));
		btnEmployees.setFocusPainted(false);
		btnEmployees.setContentAreaFilled(false);
		btnEmployees.setBorderPainted(false);
		btnEmployees.setBounds(-13, 276, 257, 40);
		jpSideBar.add(btnEmployees);

		btnLogout = new JButton("Log Out");
		btnLogout.setToolTipText("Sign out ");
		btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogout.setBackground(new Color(128, 128, 128));
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Bell MT", Font.PLAIN, 14));
		btnLogout.setFocusPainted(false);
		btnLogout.setBorderPainted(false);
		btnLogout.setBounds(-13, 499, 257, 40);
		jpSideBar.add(btnLogout);

		btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.setToolTipText("Add new Employees page");
		btnAddEmployee.setForeground(Color.WHITE);
		btnAddEmployee.setFont(new Font("Bell MT", Font.PLAIN, 14));
		btnAddEmployee.setFocusPainted(false);
		btnAddEmployee.setContentAreaFilled(false);
		btnAddEmployee.setBorderPainted(false);
		btnAddEmployee.setBounds(-13, 316, 257, 40);
		jpSideBar.add(btnAddEmployee);

		btnAddDepartment = new JButton("Add Department");

		btnAddDepartment.setToolTipText("Add New Department");
		btnAddDepartment.setForeground(Color.WHITE);
		btnAddDepartment.setFont(new Font("Bell MT", Font.PLAIN, 14));
		btnAddDepartment.setFocusPainted(false);
		btnAddDepartment.setContentAreaFilled(false);
		btnAddDepartment.setBorderPainted(false);
		btnAddDepartment.setBounds(-13, 356, 257, 40);

		jpSideBar.add(btnAddDepartment);


		jpContent = new JPanel();
		jpContent.setBounds(233, 0, 655, 665);
		contentPane.add(jpContent);

		jpContent.setLayout(null);

		lblNewLabel = new JLabel("You are logged in as Admin");
		lblNewLabel.setBounds(270, 207, 235, 48);
		jpContent.add(lblNewLabel);

	}

	/**
	 *  methods created to add eventlistner to buttons
	 * @param ActionListener
	 */

	public void addViewDeptListener(ActionListener a) {
		btnDepartments.addActionListener(a);
	}
	public void addDeptListener(ActionListener a)
	{
		btnAddDepartment.addActionListener(a);
	}
	public void addEmployeeListener(ActionListener a){
		btnAddEmployee.addActionListener(a);
	}
	public void addListEmployeesListener(ActionListener a) {
		btnEmployees.addActionListener(a);
	}
	public void addListManagerListener(ActionListener a) {
		btnManagers.addActionListener(a);
	}
	public void addLogOutListener(ActionListener a) {btnLogout.addActionListener(a);}



	/**
	 * Switches to the 'Add Department' view.
	 */
	public void addDepartmentView() {
		// Clear the current view
		jpContent.removeAll();
		// Initialize and configure the new 'Add Department' view
		AddDepartmentView v = new AddDepartmentView();
		configureAndAddView(v);
	}

	/**
	 * Switches to the 'List Departments' view.
	 */
	public void listDepartmentView() {
		jpContent.removeAll();
		ListDepartmentsView v = new ListDepartmentsView();
		configureAndAddView(v);
	}

	/**
	 * Switches to the 'Add Employee' view.
	 */
	public void addEmployeeView() {
		jpContent.removeAll();
		AddEmployeeView v = new AddEmployeeView();
		configureAndAddView(v);
	}

	/**
	 * Switches to the 'List Employees' view.
	 */
	public void listEmployeesView() {
		jpContent.removeAll();
		ListEmployeesView v = new ListEmployeesView();
		configureAndAddView(v);
	}

	/**
	 * Switches to the 'List Managers' view.
	 */
	public void listManagersView() {
		jpContent.removeAll();
		ListManagersView v = new ListManagersView();
		configureAndAddView(v);
	}

	/**
	 * Helper method to configure and add a view to the content panel.
	 * @param v The view to be added to the content panel.
	 */
	private void configureAndAddView(JPanel v) {
		v.setSize(jpContent.getSize()); // Set the view's size to match the content panel's size
		v.setOpaque(false); // Ensure the view maintains the background properties of the content panel

		// Add the view to the content panel and update the UI
		jpContent.add(v);
		jpContent.revalidate();
		jpContent.repaint();
	}

	/**
	 * Prompts the user with a confirmation dialog before exiting the application.
	 * This method ensures that the user does not exit the application accidentally.
	 */
	private void confirmAndExit() {
	    // Display a confirmation dialog to the user and capture their response
	    int confirm = JOptionPane.showConfirmDialog(
	            this,
	            "Are you sure you want to exit?", // The text asking the user for confirmation
	            "Exit Confirmation", // The title of the confirmation dialog
	            JOptionPane.YES_NO_OPTION, // The options, which are Yes and No
	            JOptionPane.QUESTION_MESSAGE // The type of message to be displayed
	    );

	    // Check the user's response
	    if (confirm == JOptionPane.YES_OPTION) {
	        System.exit(0); // Exit the application if the user confirms
	    }
	}
	
	/**
	 * Displays the home screen of the application after a user successfully logs in.
	 * The home screen includes a greeting message indicating the user is logged in as an admin.
	 */
	public void homeScreen() {
		jpContent.removeAll();
		lblNewLabel = new JLabel("You are logged in as Admin");
		lblNewLabel.setBounds(270, 207, 235, 48);
		jpContent.add(lblNewLabel);
		jpContent.revalidate();
		jpContent.repaint();
	}

}

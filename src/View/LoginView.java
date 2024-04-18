package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * This class represents the login window for Belle's Bistro Management system.
 * It provides a user interface for entering username and password, and selecting a role.
 */
public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private ImageIcon icon = new ImageIcon("login.png");
	private GradientPanel contentPane;
	private JPanel jpTop, jpContent;
	private JLabel lblTitle, userIconLabel, lblUsername, lblPassword;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JComboBox cmbDept; 
	private int mouseX, mouseY; // Variables to store mouse position
	/**
     * Constructs a new LoginTest frame.
     * Initializes the frame, sets its bounds, and adds all necessary components.
     */
	public LoginView() {
		setIconImage(icon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 467);

		// Use the GradientPanel for the content pane
		contentPane = new GradientPanel();
		contentPane.setAutoscrolls(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0)); // Required to maintain transparent bg
		getContentPane().setLayout(null);

		// Mouse listener to make the frame movable
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});

		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});

		jpTop= new JPanel();
		jpTop.setOpaque(false);
		jpTop.setBounds(0, 0, 745, 52);
		getContentPane().add(jpTop);
		jpTop.setLayout(null);

		lblTitle = new JLabel("Belle's Bistro - Management");
		lblTitle.setFont(new Font("Vivaldi", Font.PLAIN, 24));
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setBounds(10, 11, 345, 54);
		jpTop.add(lblTitle);

		// Custom close button
		JButton closeButton = new JButton("X");
		closeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		closeButton.setToolTipText("Close Window");
		closeButton.setContentAreaFilled(false);
		closeButton.setForeground(Color.WHITE);
		closeButton.setBackground(Color.LIGHT_GRAY);
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setFont(new Font("Arial Black", Font.BOLD, 10));
		closeButton.setOpaque(false);
		closeButton.setBounds(694, 0, 51, 45);
		jpTop.add(closeButton);
		JButton minimizeButton = new JButton("-");
		minimizeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		minimizeButton.setToolTipText("Minimize Window");
		minimizeButton.setFocusPainted(false);
		minimizeButton.setForeground(Color.WHITE);
		minimizeButton.setFont(new Font("Arial Black", Font.BOLD, 10));
		minimizeButton.setContentAreaFilled(false);
		minimizeButton.setBorderPainted(false);
		minimizeButton.setBackground(Color.WHITE);
		minimizeButton.setBounds(643, 0, 51, 45);
		jpTop.add(minimizeButton);
		minimizeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				setState(JFrame.ICONIFIED);
			}
		});
		closeButton.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});



		jpContent = new JPanel();
		jpContent.setOpaque(false);
		jpContent.setBounds(0, 50, 745, 446);
		getContentPane().add(jpContent);
		jpContent.setLayout(null);


		// Load the user icon
		ImageIcon originalIcon = new ImageIcon("user.png"); // Replace with your image path
		Image originalImage = originalIcon.getImage();

		// Scale the icon to fit the label
		Image scaledImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		// Create the label and set the scaled icon
		userIconLabel = new JLabel(scaledIcon);
		userIconLabel.setOpaque(false);
		

		// Center the label on the panel
		int x = (jpContent.getWidth() - 50) / 2;
		int y = (jpContent.getHeight() - 50) / 2;
		userIconLabel.setBounds(370, 26, 65, 62);

		jpContent.add(userIconLabel);


		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Bell MT", Font.PLAIN, 11));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(228, 99, 284, 29);
		lblUsername.setVisible(true);
		jpContent.add(lblUsername);

		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Bell MT", Font.PLAIN, 11));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(228, 181, 290, 21);
		jpContent.add(lblPassword);

		txtUsername = new JTextField();
		txtUsername.setToolTipText("Username");
		txtUsername.setForeground(new Color(255, 255, 255));
		txtUsername.setOpaque(false);
		txtUsername.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
		txtUsername.setBounds(228, 123, 284, 41);
		jpContent.add(txtUsername);

		txtPassword = new JPasswordField();
		txtPassword.setForeground(new Color(255, 255, 255));
		txtPassword.setOpaque(false);
		txtPassword.setToolTipText("Password");
		txtPassword.setBorder(new TitledBorder(null, "", TitledBorder.TRAILING, TitledBorder.BOTTOM, null, null));
		txtPassword.setBounds(228, 201, 284, 41);
		jpContent.add(txtPassword);

		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Bell MT", Font.PLAIN, 11));
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setBounds(423, 293, 89, 41);
		btnLogin.setBackground(new Color(255, 255, 255)); // Set a flat background color
		btnLogin.setForeground(new Color(0, 0, 64)); // Set text color to white
		btnLogin.setFocusPainted(false); // Remove focus border
		btnLogin.setBorderPainted(false); // Remove borders
		btnLogin.setOpaque(true); // Needed for setting background color

		// To change background color on hover
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(25, 118, 210)); 
				btnLogin.setForeground(Color.white); 
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(new Color(255, 255, 255)); 
				btnLogin.setForeground(new Color(0, 0, 64));
			}
		});

		jpContent.add(btnLogin);

		cmbDept = new JComboBox();
		cmbDept.setPreferredSize(new Dimension(30, 25));
		cmbDept.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Manager"}));
		cmbDept.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbDept.setToolTipText("Select Role");
		cmbDept.setBounds(228, 258, 118, 21);

		cmbDept.setBackground(new Color(255, 255, 255)); // Set background color
		cmbDept.setForeground(new Color(0, 0, 64)); // Set text color
		cmbDept.setFont(new Font("Bell MT", Font.BOLD, 11)); // Set font
		cmbDept.setBorder(new EmptyBorder(0, 0, 0, 0)); // Set border

		jpContent.add(cmbDept);


	}

	/**
     * Inner class that defines a JPanel with a gradient background.
     */	
	class GradientPanel extends JPanel {
		
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			int width = getWidth();
			int height = getHeight();
			Color startColor = new Color(120, 10, 45); 
			Color endColor = new Color(224, 220, 222);
			GradientPaint gp = new GradientPaint(0, 0, startColor, 0, height, endColor);
			g2d.setPaint(gp);
			g2d.fillRect(0, 0, width, height);
			g2d.dispose();
		}
	}
	
	
	//gives username
		public String getUsername() {
			return txtUsername.getText();
		}
		
		//gives password
		public char[] getUserPassword() {
			return txtPassword.getPassword();
		}
		
		//adding button functionality
		public void addActionToBtn(ActionListener a) {
			btnLogin.addActionListener(a);
		}
		
		public JComboBox getUserType() {
			return cmbDept;
		}
}

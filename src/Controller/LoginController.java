package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.Login;
import View.*;

public class LoginController {
	LoginView view;
	Login model;

	 public LoginController(LoginView vw, Login mdl)  {   
		view=vw;
		model=mdl;
	}

//the functionality of the login button is here
	 
	public void loginData() {
		System.out.println("Controller worked");
		view.addActionToBtn(new ActionListener () {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println(view.getUsername());
				if(view.getUserType().getSelectedItem().equals("Admin"))
				{
					model.setType("AD");
					model.loginAdmin();
					if(model.verify(view.getUsername(), view.getUserPassword())) {
							view.dispose();
								AdminView adminView = new AdminView();
								adminView.setVisible(true);
								AdminController adminController= new AdminController(adminView);
								adminController.checkbutton();
								System.out.println("Logged in Successfully.");
				}
					else {
						JOptionPane.showMessageDialog(null, "Username or Password Incorrect!");
					}
				 
				
				}
				if(view.getUserType().getSelectedItem().equals("Department Secretary")) {
					model.setType("DS");
//					if(model.loginDepartment(view)) {
//						view.dispose();
////						DepartmentView v= new DepartmentView();
////						v.setVisible(true);
////						DepartmentController c = new DepartmentController(v);
////						c.checkbutton();
//				}
//					else {
//						JOptionPane.showMessageDialog(null, "Username or Password Incorrect!");
//					}
					
				}
			}
		});
	}
}

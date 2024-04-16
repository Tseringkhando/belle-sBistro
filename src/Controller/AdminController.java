package Controller;
import java.awt.event.*;

import View.*;

public class AdminController {
	AdminView view;
	
	public AdminController(AdminView v)
	{
		view=v;
	}
	
	
	public void checkbutton() {
	    
		// For viewing departments
		view.addViewDeptListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.listDepartmentView();
				
			}
		});
		// For adding new department
	    view.addDeptListener(new ActionListener() 
	    {
	      
	      public void actionPerformed(ActionEvent e)
	      { 
	    	  view.addDepartmentView();
	      	
	      }
	    });
	    
	    //adding new employee button
	    view.addEmployeeListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.addEmployeeView();
				
			}
		});
	    
	    // list employees
	    view.addListEmployeesListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.listEmployeesView();
				
			}
		});
	    

	      view.addListManagerListener(new ActionListener() {

	        public void actionPerformed(ActionEvent e)
	        {view.listManagersView();}
	        
	      });
//
//
//	    view.gotoHome(new ActionListener() {
//	      public void actionPerformed(ActionEvent e) {
//	        view.home();
//	      }
//	    });
//	    
//	    view.listDeptListener(new ActionListener() {
//	      public void actionPerformed(ActionEvent e) {
//	        view.listDepartment();
//	      }
//	    });
//	    
//	    view.listContract(new ActionListener() {
//	      public void actionPerformed(ActionEvent e) {
//	        view.listContractView();
//	      }
//	    });
//	    
//	    view.listFull(new ActionListener() {
//	      public void actionPerformed(ActionEvent e) {
//	      view.listFullTimeView();
//	        
//	      }
//	    });
//	    
//	    view.listPart(new ActionListener() {
//	      public void actionPerformed(ActionEvent e) {
//	        view.listPartView();
//	      }
//	    });
//	    
//	    
//	    view.logOut(new ActionListener() {
//	      public void actionPerformed(ActionEvent e) {
//	        view.dispose();
//	        LoginView v = new LoginView();
//	          Login m = new Login();
//	          LoginController c = new LoginController(v,m);
//	          c.loginData();
//	          v.setVisible(true);
//	      }
//	    });
//	    
//	    view.exit(new ActionListener() {
//	      public void actionPerformed(ActionEvent e) {
//	      System.exit(0);
//	        
//	      }
//	    });

	  }
}

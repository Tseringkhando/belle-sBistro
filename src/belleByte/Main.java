package belleByte;
import java.awt.*;

//import Controller.HumanResourceController;
import Controller.LoginController;
import Model.Login;
import View.*;
public class Main {
	public static void main(String[] args) {

        LoginView view = new LoginView();
        view.setVisible(true);
        Login model= new Login();
		LoginController con = new LoginController(view, model);
		con.loginData();
        
    }
}

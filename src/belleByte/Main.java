package belleByte;
import java.awt.*;
/**
 * The {@code Main} class serves as the entry point for the belleByte application.
 * It sets up the necessary components for the login process including the view, model,
 * and controller.
 * <p>
 * This class specifically handles the creation and visibility of the login GUI,
 * and the initialization of the MVC components required for login functionality.
 * </p>
 * @author Tsering 
 */

//import Controller.HumanResourceController;
import Controller.LoginController;
import Model.Login;
import View.*;
public class Main {
	 /**
     * The main method that initiates the application.
     * <p>
     * This method performs the following operations:
     * <ol>
     *     <li>Creates an instance of {@link LoginView} and makes it visible to the user.</li>
     *     <li>Creates an instance of {@link Login} model to manage the login data.</li>
     *     <li>Creates an instance of {@link LoginController}, linking the model and view,
     *         and starts the login process.</li>
     * </ol>
     * </p>
     * 
     * @param args command-line arguments (not used)
     */
	public static void main(String[] args) {
		 // Create an instance of LoginView
        LoginView view = new LoginView();

        // Make the LoginView window visible
        view.setVisible(true);

        // Create an instance of Login model
        Login model = new Login();

        // Create an instance of LoginController, passing the view and model
        LoginController con = new LoginController(view, model);

        // Invoke the loginData method to initialize the login process
        con.loginData();
        
    }
}

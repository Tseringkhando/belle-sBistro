package belleByte;
/**
 * This is the class UserSession 
 * that holds the current user role logged in into the system.
 * It will help while limiting and granting access to users according to their roles.-
 */
public class UserSession {
    private static UserSession instance;

    private String userType;

    private UserSession(String userType) {
        this.userType = userType;
    }

    public static UserSession getInstance(String userType) {
        if (instance == null) {
            instance = new UserSession(userType);
        }
        return instance;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}


/**
 * plan to use usersesion in login 
 * // Set the user type at login
	UserSession.getInstance("admin");

// Access the user type elsewhere in your application
	String userType = UserSession.getInstance().getUserType();

 */


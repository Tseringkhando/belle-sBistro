package Model;
import java.io.Serializable; 
public class Users implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username, role;
	private char[] password;

	public Users(String user, char[] pw, String rl) { 
		username = user; 
		password = pw;
		role=rl;
	} 

	public String getUsername() {  return username; } 

	public void setName(String user) {  username = user; } 

	public char[] getPassword() {  return password; } 

	public void setAddress(char[] pw) {  password = pw; } 

	public String getType() {return role;}
	public void setType(String rl) {role=rl;}

}

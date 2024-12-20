package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import View.LoginView;
public class Login {
	private String username, type;
	private char[] password;
	private String file;
	
//	for department login
	ArrayList<Departments> deps = new ArrayList<Departments>();

	public Login() {
		
	}
	
	public void loginAdmin()
	{
		try {
			FileInputStream fis = new FileInputStream("users.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Users obj = null;
			while ((obj=(Users)ois.readObject())!=null)
			{  
				setUserName(obj.getUsername());
				setPassword(obj.getPassword());
			}        
			ois.close(); 

		}catch (Exception e) {
		}
	}

	//checking user entered correct credentials or not
	public boolean verify(String username, char[] password) {
		String u= getUsername();
		char[] p = getPassword();
		if(u.equals(username)) {
			if(Arrays.equals(p,password)) {
				
				return true;
			}
			else 
				return false;
		}
		else
			return false;

	}

	//setter methods

	public void setUserFile(String file) {
		this.file= file;	
	}
	public String getFile() {
		return file;	
	}


	public void setUserName(String username) {
		this.username= username;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public char[] getPassword() {
		return this.password;
	}
	public void setType(String type) {
		this.type=type;
	}

	public String getType() {
		return this.type; }



}
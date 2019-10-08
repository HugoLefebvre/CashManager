//Java Program to illustrate reading from FileReader 
//using BufferedReader 
import java.io.*; 
public class User {
	String LastName, FirstName;
	int age;
	
	public Boolean login(String name,String password) {
	    boolean isLogged = true;
	    return isLogged;
	}
	public void ViewSettings() throws Exception {
		//We need to provide file path as the parameter: 
		//double backquote is to avoid compiler interpret words 
		//like \test as \t (ie. as a escape sequence) 
		File file = new File("/home/rezig/eclipse-workspace/Project01/Settings.txt"); 
		
		
		BufferedReader br = new BufferedReader(new FileReader(file)); 

		String st; 
		while ((st = br.readLine()) != null) 
			System.out.println(st); 
		} 
}
 

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		User user1 = new User();
		Admin admin =new Admin();
		user1.login("Ibtissem", "000");
		user1.ViewSettings();
		admin.changeSettings("Settings0.txt", "Hello Ibtissem");
		
	}
}

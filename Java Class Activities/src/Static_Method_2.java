public class Static_Method_2{
 
	//static method to validate email format
	
	public static boolean isValidEmail(String email)
	{
		return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
	}
}
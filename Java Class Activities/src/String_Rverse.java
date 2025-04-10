
public class String_Rverse {
	public static void main(String args[]) 
	{
		String input="Hexaware";
		
		String reverse="";
		
		for(int i=input.length()-1;i>=0;i--) 
		{
			reverse=reverse+input.charAt(i);
		}
		
		System.out.println("Reversed String: "+reverse);
	}
}

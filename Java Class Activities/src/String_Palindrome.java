
public class String_Palindrome {
	public static void main(String args[]) 
	{
		String input1="madam";
		String input2="hello";
		
		String rev1="";
		String rev2="";
		
		for(int i=input1.length()-1;i>=0;i--)
		{
			rev1+=input1.charAt(i);
		}
		
		for(int i=input2.length()-1;i>=0;i--)
		{
			rev2+=input2.charAt(i);
		}
		
		if(rev1.equals(input1)) {
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
		}
		
		if(rev2.equals(input2)) {
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
		}
	}
}

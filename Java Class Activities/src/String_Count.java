
public class String_Count {
	public static void main(String args[]) 
	{
		String input1="Hexaware";
		int vowels=0; 
		int consonant=0;
		
		for(int i=0;i<input1.length();i++) 
		{
			if(input1.charAt(i)=='a' || input1.charAt(i)=='e' || input1.charAt(i)=='i' ||
					input1.charAt(i)=='o' || input1.charAt(i)=='u')
			{
				vowels++;
			}
			else
			{
				consonant++;
			}
		}
		
		System.out.println("No. of Vowles:"+vowels);
		System.out.println("No. of Consonants:"+consonant);
	}
}

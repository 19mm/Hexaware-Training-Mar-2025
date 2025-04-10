
public class Most_Frequent {
	public static void main(String[] args) {
        String str = "success";
        int[] freq = new int[256]; 

        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }
        
        char maxChar = str.charAt(0);
        int maxCount = 0;
        
        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] > maxCount) {
                maxCount = freq[str.charAt(i)];
                maxChar = str.charAt(i);
            }
        }
        
        System.out.println("Most frequent character: " + maxChar);
	}
}

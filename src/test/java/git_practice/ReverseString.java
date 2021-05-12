package git_practice;

public class ReverseString {
public static void main(String[] args) {
	String name = "Shreekrishna";
	char[] n1 = name.toCharArray();
	String reverse ="";
	
	for(int i =name.length()-1;i>=0;i--)
	{
		reverse = reverse +n1[i];
	}
	System.out.println(reverse);
}
}

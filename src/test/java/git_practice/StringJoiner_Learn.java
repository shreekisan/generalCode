package git_practice;

import java.util.StringJoiner;

public class StringJoiner_Learn {

	public static void main(String[] args) {
		StringJoiner sj = new StringJoiner("*", "(", ")");
		StringJoiner listname = sj.add("ram").add("Shyam").add("hari").add("number");
		System.out.println(listname.toString());

	}

}

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class MkModel {
	public static void main(String[] args) throws IOException {
		String fname = args[0];
		Scanner in = new Scanner(new File(fname));
		String next = in.nextLine();
		while (in.hasNext() && !next.contains("OPTIMAL"))
			next = in.nextLine();

		next = in.nextLine();
		String[] s = next.split(" ");
		String ret = s[1].substring(1, s[1].length()-1) + "~" + (s[3].contains("not") ? "0" : "1") + ";";
		while (in.hasNext() && !next.isEmpty()) {
			next = in.nextLine();
			if (next.contains("else ("))
				break;
			s = next.split(" ");
			ret += s[2].substring(1, s[2].length()-1) + "~" + (s[4].contains("not") ? "0" : "1") + ";";
		}

		s = next.split(" ");
		ret += "default" + "~" + (s[1].contains("not") ? "0" : "1");

		System.out.println(ret);
	}
}

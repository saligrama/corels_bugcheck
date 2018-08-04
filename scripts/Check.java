import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Check {
	public static void main(String[] args) throws IOException {
		String fname = args[0];
		
		Scanner crin = new Scanner(new File("../rule_lists_cold/" + fname));
		Scanner wrin = new Scanner(new File("../rule_lists_warm/" + fname));
		String cr = crin.nextLine(), wr = wrin.nextLine();
		if (cr.equals(wr)) {
			System.out.println(fname + " RULE LISTS IDENTICAL");
			return;
		}
		Scanner cin = new Scanner(new File("../proc-logs-cold/" + fname));
		Scanner win = new Scanner(new File("../proc-logs-warm/" + fname));
		String cnext = cin.nextLine();
		while (cin.hasNext() && !cnext.contains("final min_objective"))
			cnext = cin.nextLine();
		String wnext = win.nextLine();
		while (win.hasNext() && !wnext.contains("final min_objective"))
			wnext = win.nextLine();

		if (cnext.equals(wnext))
			System.out.println(fname + " OBJECTIVES EQUAL");
		else
			System.out.println(fname + " PROBLEM");
	
		crin.close(); wrin.close(); cin.close(); win.close();		
	}
}

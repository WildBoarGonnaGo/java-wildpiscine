import java.util.Scanner;

public class Program {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		byte[]	weekEval = new byte[18];
		String	weekMatch;
		byte 	order = -1;

		for (int i = 0; i < 18; ++i)
			weekEval[i] = 10;
		while (++order < 18 & !(weekMatch = sc.next()).equals("42")) {
			byte 	tmpRes = 10;
			byte	count = 5;
			weekMatch += ' ';
			if (sc.hasNextByte())
				weekMatch += sc.nextByte();
			Scanner	scInScope = new Scanner(weekMatch);

			weekMatch = scInScope.findInLine("Week \\d+");
			if (weekMatch == null) {
				System.err.println("Illegal Argument");
				sc.close();
				System.exit(-1);
			}
			String	orderMatch = "Week " + (order + 1);
			if (!orderMatch.equals(weekMatch)) {
				System.err.println("Illegal argument");
				sc.close();
				System.exit(-1);
			}
			weekMatch = "";
			for (byte readData = 0; readData < 5; ++readData) {
				if (sc.hasNext())
					weekMatch += sc.next();
				else {
					System.err.println("Illegal argument");
					sc.close();
					scInScope.close();
					System.exit(-1);
				}
				weekMatch += ' ';
			}
			scInScope = new Scanner(weekMatch);
			weekMatch = scInScope.findInLine("\\d \\d \\d \\d \\d");
			if (weekMatch == null) {
				System.err.println("Illegal Argument");
				sc.close();
				System.exit(-1);
			}
			scInScope = new Scanner(weekMatch);
			while (count-- > 0) {
				tmpRes = scInScope.nextByte();
				if (weekEval[order] > tmpRes)
					weekEval[order] = tmpRes;
			}
		}
		for (int i = 0; i < 18 && weekEval[i] != 10; ++i) {
			System.out.print("Week " + (i + 1) + ' ');
			while (weekEval[i]-- > 0)
				System.out.printf("=");
			System.out.println(">");
		}
		sc.close();
	}
}

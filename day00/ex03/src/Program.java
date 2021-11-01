import java.util.Scanner;

public class Program {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		byte[]	weekEval = new byte[18];
		String	weekMatch;
		byte 	order = 0;

		/*String match = sc.findInLine("Week \\d+");
		if (match == null)
			System.out.println("Illegal string");
		else {
			Scanner kek = new Scanner(match);
			kek.next();
			order = kek.nextByte();
			String kakrot = "order = " + order;
			System.out.println(match);
			System.out.println(kakrot);
			System.out.println(order); output "order = 2"
			kek.close();
		}*/
		while (order++ < 18 && (weekMatch = sc.toString()) != "42") {
			byte 	tmpRes = Byte.MAX_VALUE;
			byte	count = 5;
			Scanner	scInScope = new Scanner(weekMatch);

			weekMatch = scInScope.findInLine("Week \\d+");
			if (weekMatch == null) {
				System.err.println("Illegal Argument");
				sc.close();
				System.exit(-1);
			}
			String	orderMatch = "Week " + order;
			if (!orderMatch.equals(weekMatch)) {
				System.err.println("Illegal argument");
				sc.close();
				System.exit(-1);
			}
			weekMatch = sc.findInLine("\\d \\d \\d \\d \\d");
			if (weekMatch == null) {
				System.err.println("Illegal Argument");
				sc.close();
				System.exit(-1);
			}
			scInScope.close();
			scInScope = new Scanner(weekMatch);
		}
		sc.close();
	}
}

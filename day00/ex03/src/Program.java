import java.util.Scanner;

public class Program {
	public static void main(String args[]) {
		Scanner	sc = new Scanner(System.in);
		byte	roll = 0;
		long	multModif = 1;
		long	result = 0;

		sc.useDelimiter("\\u000A");
		while (roll < 18) {
			byte	tool = 0;

			if (sc.hasNext("(42)|(Week(\\s)(\\d))")) {
				sc.useDelimiter("\\s");

				String verify = sc.next();
				if (verify.equals("42"))
					break ;
				tool = sc.nextByte();
				sc.useDelimiter("\\u000A");
			}
			else {
				System.err.println("Illegal Argument");
				sc.close();
				System.exit(-1);
			}
			if (tool != ++roll) {
				System.err.println("Illegal Argument");
				sc.close();
				System.exit(-1);
			}
			tool = 10;
			if (sc.hasNext("(\\d)(\\s)(\\d)(\\s)(\\d)(\\s)(\\d)(\\s)(\\d)")) {
				sc.useDelimiter("\\s+");
				for (byte i = 0; i < 5; ++i) {
					byte toolTmp = sc.nextByte();
					if (tool > toolTmp)
						tool = toolTmp;
				}
				sc.useDelimiter("\\u000A");
			} else {
				System.err.println("Illegal Argument");
				sc.close();
				System.exit(-1);
			}
			result += tool * multModif;
			multModif *= 10;
		}
		for (byte i = 0; i < roll; ++i) {
			byte weekRes;

			weekRes = (byte)(result % 10);
			result /= 10;
			System.out.print("Week ");
			System.out.print(i + 1);
			System.out.print(' ');
			for (byte j = 0; j < weekRes; ++j)
				System.out.print('=');
			System.out.println('>');
		}
	}
}

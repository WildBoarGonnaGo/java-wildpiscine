import java.util.Scanner;

public class Program {
	private static void 	valAssign(char[][] target, char[] arrOfChars, char idx, char occur) {
		target[idx][0] = occur;
		target[idx][1] = (arrOfChars[occur] > 999) ? 999 : arrOfChars[occur];
	}

	private static String	stringNum(int num) {
		String result = "";

		if (num > 10)
			result = (stringNum(num / 10));
		result += (char)(num % 10 + 48);
		return (result);
	}

	private static byte 	printHistogramRow(char[][] target, byte idx, byte[] length, byte floor) {
		boolean ifFirst = false;

		for (byte i = 0; i < idx; ++i) {
			for (byte j = 0; j < length[i]; ++j)
				System.out.print(' ');
			System.out.print('#');
		}
		while (idx < 10 && floor == 0 && (target[idx][1] * 10 / target[0][1]) == 10 - floor) {
			int		num = (int)target[idx][1];
			String	numStr = stringNum(num);
			System.out.print(' ');
			System.out.print(numStr);
			length[idx++] = (byte)(numStr.length());
			ifFirst = true;
		}
		if (ifFirst) {
			System.out.print('\n');
			for (byte i = 0; i < idx; ++i) {
				for (byte j = 0; j < length[i]; ++j)
					System.out.print(' ');
				System.out.print('#');
			}
		}
		while (idx < 10 && (target[idx][1] * 10 / target[0][1]) + 1 == 10 - floor && target[idx][1] > 0) {
			int		num = (int)target[idx][1];
			String	numStr = stringNum(num);
			System.out.print(' ');
			System.out.print(numStr);
			length[idx++] = (byte)(numStr.length());
		}
		System.out.print('\n');
		return (idx);
	}

	private static void		printBaseChars(char[][] target, byte[] length, byte numOfChars) {
		for (byte i = 0; i < numOfChars; ++i) {
			for (byte j = 0; j < length[i]; ++j)
				System.out.print(' ');
			System.out.print(target[i][0]);
		}
		System.out.print("\n");
	}

	private static boolean	isPrevIter(char[][] iter, char match, char curIdx) {
		for (char i = 0; i < curIdx; ++i) {
			if (iter[i][0] == match)
				return (true);
		}
		return (false);
	}
	public static void 		main(String[] args) {
		char[]		occur = new char[0xFFFF];
		char[][]	result = new char[10][2];
		byte[]		numLength = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		byte		numOfOccurs = 0;
		Scanner	sc = new Scanner(System.in);

		sc.useDelimiter("\\u000A");
		char[]	destruct = sc.next().toCharArray();
		for (char c : destruct)
			++occur[c];
		for (char c : occur) {
			if (c != 0)
				++numOfOccurs;
		}
		for (char i = 0; i < numOfOccurs && i < 10; ++i) {
			for (char j = 0; j < 0xFFFF ; ++j) {
				if (i == 0 && result[i][1] < occur[j])
					valAssign(result, occur, i, j);
				else if (i != 0 && !isPrevIter(result, j, i) && result[i][1] <= result[i - 1][1]
					&& result[i][1] < occur[j])
					valAssign(result, occur, i, j);
			}
		}
		byte	number = 0;
		for (byte i = 0; i < 10; ++i)
			number = printHistogramRow(result, number, numLength, i);
		printBaseChars(result, numLength, (numOfOccurs < 10) ? numOfOccurs : 10);
	}
}

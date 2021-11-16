import java.util.Random;

public class Program {
	public static int		invokeInterger(String numberStr) {
		int	endOfStr;
		int	beginNumber;

		endOfStr = numberStr.length();
		for (beginNumber = endOfStr - 1; beginNumber > 0
			&& Character.isDigit(numberStr.charAt(beginNumber)); --beginNumber)
			;
		++beginNumber;
		String	subStr = numberStr.substring(beginNumber, endOfStr);
		return (Integer.valueOf(subStr));
	}

	public static Integer[]	arrGenSumOutput(Integer	size) {
		Random		randomGen = new Random();
		Integer[]	resArray = new Integer[size];
		long		Sum = 0;

		for (int i = 0; i < size; ++i) {
			resArray[i] = randomGen.nextInt() % 1001;
			if (resArray[i] < 0)
				resArray[i] *= -1;
			Sum += resArray[i];
		}
		System.out.println("Sum = " + Sum);
		return (resArray);
	}

	public static void		main(String[] args) {
		Integer		Sum;
		Integer[]	arrArgs = new Integer[2];
		Integer[]	target = null;

		if (args.length != 2) {
			System.err.println("Not enough arguments");
			System.exit(-1);
		}
		if (!args[0].matches("--arraySize=(\\d+)") || !args[1].matches("--threadsCount=(\\d+)")) {
			System.err.println("Usage of Program: Program --arraySize=<some_number_that_>_0_and_<=_2000000>"
				+ " --threadsCount=<some_number_that_>_0_and_<_arraySize>");
			System.exit(-1);
		}
		arrArgs[0] = invokeInterger(args[0]);
		arrArgs[1] = invokeInterger(args[1]);
 		if (arrArgs[0] > 2000000) {
			System.err.println("Number of elements must be less or equal than 2000000");
			System.exit(-1);
		}
		if (arrArgs[1] > arrArgs[0]) {
			System.err.println("Number of threads can't be greater than number of elements in array");
			System.exit(-1);
		}
		target = arrGenSumOutput(arrArgs[0]);
	}
}

package edu.school21.numbers;

public class NumberWorker {
	public class IllegalNumberException extends Exception {
		public IllegalNumberException() {
			System.err.println(getMessage());
		}

		@Override
		public String getMessage() {
			return "Invalid number: it's negative, 0 or 1 digit";
		}
	}

	public boolean	isPrime(int number) throws IllegalNumberException {
		boolean	state = true;
		int		i = 1, factor = 3;

		if (number <= 0 || number == 1)
			throw new IllegalNumberException();
		if (number % 2 == 0 && number > 2)
			state = false;
		else {
			while (factor * factor <= number && state == true) {
				++i;
				if ((number % factor) == 0)
					state = false;
				++factor;
			}
			if (state == true)
				++i;
		}
		return (state);
	}

	public int		digitsSum(int number) {
		int result = 0;

		while (number != 0) {
			result += number % 10;
			number /= 10;
		}

		return (result *= ( result < 0 ) ? -1 : 1);
	}
}

package edu.school21.numbers;

import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {
	@ParameterizedTest
	@ValueSource (ints = {2, 3, 11, 61, 263, 7, 5})
	void	isPrimeForPrimes(int number) throws NumberWorker.IllegalNumberException {
		NumberWorker test = new NumberWorker();
		Assert.assertTrue(test.isPrime(number));
	}

	@ParameterizedTest
	@ValueSource (ints = {12, 24, 87, 98, 69, 112, Integer.MAX_VALUE} )
	void	isPrimeForNotPrimes(int number) throws NumberWorker.IllegalNumberException {
		NumberWorker test = new NumberWorker();
		Assert.assertFalse(test.isPrime(number));
	}

	@ParameterizedTest
	@ValueSource ( ints = {0, 1, -233, Integer.MIN_VALUE} )
	void	isPrimeForIncorrectNumbers(int number) {
		NumberWorker test = new NumberWorker();
		Exception exception = Assertions.assertThrows(
			NumberWorker.IllegalNumberException.class, () -> test.isPrime(number));

		String expect = "Invalid number: it's negative, 0 or 1 digit";
		String whatYouGot = exception.getMessage();

		Assert.assertEquals(expect, whatYouGot);
	}

	@ParameterizedTest
	@CsvFileSource ( files = "src/test/resources/data.csv" )
	void	testDigitsSum(int number, int correct) {
		NumberWorker test = new NumberWorker();
		Assert.assertEquals(test.digitsSum(number), correct);
	}
}


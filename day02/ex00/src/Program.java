import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Scanner;

public class Program {

	private static int						maxLength = 0;

	private static char						byteCodeBase(String input, int base) {
		String	baseStr = "0123456789ABCDF";
		int		inputLength = input.length();
		char	res = 0;

		for (int i = 0; i < input.length(); ++i) {
			res *= base;
			res += baseStr.indexOf(input.charAt(i));
		}
		return (res);
	}

	private static HashMap<String, String>	fillHash(FileInputStream inStream) {
		int						i = 0;
		String					key = "";
		String					value = "";
		String					hexStr = "";
		boolean					readKey = true;
		HashMap<String, String>	res = new HashMap<>();

		if (inStream == null)
			return null;
		try {
			while (i != -1) {
				i = inStream.read();
				if (i == -1)
					break ;
				if (i == ',')
					readKey = false;
				if (readKey)
					key += (char)i;
				else if (!readKey && i != ' ' && i != '\n')
					hexStr += (char)i;
				else if (!readKey && (i == ' ' || i == '\n')) {
					value += byteCodeBase(hexStr, 16);
					hexStr = "";
				}
				if (!readKey && i == '\n') {
					int	tmpLength = value.length();
					if (maxLength < tmpLength)
						maxLength = tmpLength;
					res.put(key, value);
					key = "";
					value = "";
					readKey = true;
				}
			}
		} catch (IOException e) {
			System.err.println("Error, while reading the file");
		}
		int	tmpLength = value.length();
		if (maxLength < tmpLength)
			maxLength = tmpLength;
		res.put(key, value);
		key = "";
		value = "";
		readKey = true;
		return (res);
	}

	public static void	main(String[] args) {
		HashMap<String, String>	hashSigna;
		FileInputStream	fileInput = null;
		FileOutputStream fileOutput;

		try {
			fileInput = new FileInputStream("signatures.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		hashSigna = fillHash(fileInput);
		try {
			fileInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		fileInput = null;
		Scanner	sc = new Scanner(System.in);
		String	readFileStr = "";

		sc.useDelimiter("\\u000A");
		while (!sc.hasNext("42")) {
			readFileStr = sc.next();
			try {
				fileInput = new FileInputStream(readFileStr);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.exit(-1);
			}
			int[]	arrSignature = new int[maxLength];
			try {
				for (int i = 0; i < maxLength; ++i)
					arrSignature[i] = fileInput.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String	result = arrSignature.toString();
			System.out.println("PROCESSED");
			Iterator it = hashSigna.keySet().iterator();
			while (it.hasNext()) {
				String keyTmp= (String)it.next();
				String valueTmp = hashSigna.get(keyTmp);
				if (result.contains(valueTmp)) {
					System.out.println(valueTmp);
					break;
				}
			}
		}
		sc.close();
	}
}

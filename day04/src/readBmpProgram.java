public class readBmpProgram {
	public static void main(String[] args) {
		char	blackChar;
		char	whiteChar;

		if (args.length != 3) {
			System.err.println("Not enough arguments");
			System.exit(-1);
		}
		if (!args[0].matches("--white=(\\S)")
			|| !args[1].matches("--black=(\\S)")) {
			System.err.println("Usage of Program: Program --white=<some_single_char> "
				+ "--black=<some_single_char_other_than_white> "
				+ "</path/to/bmp_file.bmp>");
			System.exit(-1);
		}

		blackChar = args[1].charAt(args[1].length() - 1);
		whiteChar = args[0].charAt(args[0].length() - 1);
		readBmp obj = new readBmp(args[2], blackChar, whiteChar);
		int[]		data = obj.getMetaData();
		char[][]	image;
		int			imageWidth = obj.getImageWidth();
		int			imageHeight = obj.getImageHeight();

		image = obj.getRawImage();
		if (image == null) {
			System.exit(-1);
		}
		for (int i = 0; i < imageHeight; ++i) {
			for (int j = 0; j < imageWidth; ++j) {
				System.out.print(image[j][i]);
			}
			System.out.print('\n');
		}
	}
}
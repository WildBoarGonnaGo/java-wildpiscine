import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;

public class readBmp {
	String			_fileToRead;
	int[]			_bmpMeta;
	FileInputStream	_bmpInputStream;
	int				_imageHeight;
	int				_imageWidth;
	char[][]		_rawImage;
	char			_blackChar;
	char			_whiteChar;

	class NotBMPException extends Exception {
		NotBMPException() {
			System.err.println("This file doesn't have bmp signature");
		}
	}

	private int	readRegion(int length, FileInputStream tool) throws IOException {
		int result = 0;

		for (int i = 0; i < length; ++i)
			result += tool.read();
		return (result);
	}

	public readBmp(String fileToRead, char blackChar, char whiteChar) {
		_fileToRead = fileToRead;
		_bmpMeta = new int[17];
		BufferedImage	someImage;

		try {
			_bmpInputStream = new FileInputStream(fileToRead);
		} catch (FileNotFoundException exc) { exc.printStackTrace(); }
		try {
			_bmpMeta[0] = _bmpInputStream.read();
			_bmpMeta[1] = _bmpInputStream.read();
			_bmpMeta[2] = readRegion(4, _bmpInputStream);
			_bmpMeta[3] = readRegion(2, _bmpInputStream);
			_bmpMeta[4] = readRegion(2, _bmpInputStream);
			for (int i = 5; i < 9; ++i)
				_bmpMeta[i] = readRegion(4, _bmpInputStream);
			for (int i = 9; i < 11; ++i)
				_bmpMeta[i] = readRegion(2, _bmpInputStream);
			for (int i = 11; i < 17; ++i)
				_bmpMeta[i] = readRegion(4, _bmpInputStream);

			_bmpInputStream.close();
		} catch (IOException exc) { exc.printStackTrace(); }
		_bmpInputStream = null;

		try {
			someImage = ImageIO.read(new File(fileToRead));
			_imageWidth = someImage.getWidth();
			_imageHeight = someImage.getHeight();
			_blackChar = blackChar;
			_whiteChar = whiteChar;

			_rawImage = new char[_imageWidth][_imageHeight];

			for (int i = 0; i < _imageWidth; ++i) {
				for (int j = 0; j < _imageHeight; ++j) {
					int	pixelColor = someImage.getRGB(i, j);
					_rawImage[i][j] = (pixelColor == -1) ? whiteChar : blackChar;
				}
			}
		} catch (IOException exc) { exc.printStackTrace(); }

	}

	public int[]	getMetaData() {
		return	_bmpMeta;
	}

	public int		getImageWidth() {
		return	_imageWidth;
	}

	public int		getImageHeight() {
		return	_imageHeight;
	}

	public char[][]	getRawImage() {
		return _rawImage;
	}
}
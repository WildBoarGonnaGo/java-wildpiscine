package edu.school21.spring.printer;

public class PrinterWithPrefixImpl implements Printer {
	String		prefix;
	Renderer	renderer;

	public PrinterWithPrefixImpl(Renderer renderer) {
		this.renderer = renderer;
	}

	@Override
	public void	setPrefix(String prefix) {
		this.prefix = prefix;
	}

	@Override
	public void	print(String message) {
		String	result;

		result = renderer.getPreProcessor().preProcessedMessage(prefix + ' ' + message);
		renderer.getOutputStream().println(result);
	}
}

package edu.school21.spring.printer;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer{
	Renderer		renderer;

	public PrinterWithDateTimeImpl(Renderer renderer) {
		this.renderer = renderer;
	}

	@Override
	@Deprecated
	public void		setPrefix(String prefix) { ; }

	@Override
	public void	print(String message) {
		SimpleDateFormat	sqlDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp			timestamp = Timestamp.valueOf(LocalDateTime.now());
		String				result;

		result = renderer.getPreProcessor().preProcessedMessage(sqlDateTimeFormat.format(timestamp) + ' ' + message);
		renderer.getOutputStream().println(result);
	}
}

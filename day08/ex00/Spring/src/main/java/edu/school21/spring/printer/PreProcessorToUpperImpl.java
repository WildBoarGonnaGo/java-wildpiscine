package edu.school21.spring.printer;

import java.util.Locale;

public class PreProcessorToUpperImpl implements PreProcessor {
	public PreProcessorToUpperImpl() {}

	@Override
	public String	preProcessedMessage(String message) {
		return message.toUpperCase(Locale.ENGLISH);
	}
}

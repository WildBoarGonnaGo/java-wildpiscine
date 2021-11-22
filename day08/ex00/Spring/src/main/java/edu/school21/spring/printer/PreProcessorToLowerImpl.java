package edu.school21.spring.printer;

import java.util.Locale;

public class PreProcessorToLowerImpl implements PreProcessor {
	public PreProcessorToLowerImpl() { ; }

	@Override
	public String	preProcessedMessage(String message) {
		return (message.toLowerCase(Locale.ENGLISH));
	}
}

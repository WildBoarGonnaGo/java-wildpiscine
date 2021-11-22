package edu.school21.spring.printer;

import java.io.PrintStream;

public class RendererStandardImpl implements Renderer {
	PreProcessor	preProcessor;

	public 			RendererStandardImpl(PreProcessor preProcessor) {
		this.preProcessor = preProcessor;
	}

	@Override
	public PrintStream	getOutputStream() {
		return System.out;
	}

	@Override
	public PreProcessor	getPreProcessor() { return this.preProcessor; }
}

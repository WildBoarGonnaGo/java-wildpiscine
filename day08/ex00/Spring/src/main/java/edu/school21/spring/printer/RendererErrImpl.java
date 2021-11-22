package edu.school21.spring.printer;

import java.io.PrintStream;

public class RendererErrImpl implements Renderer {
	PreProcessor	preProcessor;

	public 				RendererErrImpl(PreProcessor preProcessor) {
		this.preProcessor = preProcessor;
	}

	@Override
	public PrintStream	getOutputStream() {
		return System.err;
	}

	@Override
	public PreProcessor	getPreProcessor() { return this.preProcessor; }
}

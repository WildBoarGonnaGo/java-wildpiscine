package edu.school21.spring.printer;
import java.io.PrintStream;

public interface Renderer {
	PrintStream		getOutputStream();
	PreProcessor	getPreProcessor();
}

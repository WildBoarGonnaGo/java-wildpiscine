package edu.school21.spring.app;
import edu.school21.spring.printer.*;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("src/main/resources/context.xml");
		Printer printer = context.getBean("renderWithPrefix", Printer.class);
		printer.setPrefix("Prefix");
		printer.print("hello");

	}
}

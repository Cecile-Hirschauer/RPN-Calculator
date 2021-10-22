package rpnCalc;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleUserInterface implements Runnable, CommandListener {
	private static final String HELP = "Some help about RPN";
	private static final String GOODBYE = "Goodbye !!";
	private static final String PROMPT = "RPN calculator > ";
	Calculator calculator = new Calculator();
	Parser parser = new Parser(calculator, this);
	private InputStream inputStream;
	private PrintStream printStream;
	private Scanner scanner;
	private boolean shouldExit = false;
	
	public ConsoleUserInterface(InputStream in, PrintStream out) {
		this.inputStream = in;
		this.printStream = out;
		this.scanner = new Scanner(inputStream);
	}
	@Override
	public void exit() {
		shouldExit = true;
		
	}
	@Override
	public void help() {
		System.out.println(HELP);
		
	}
	@Override
	public void run() {
		while (shouldExit  == false) {
			printPrompt();
			String expression = readLine();
			try {
				evaluate(expression);				
			}
			catch (Exception e) {
				printError(e);
			}
		}
		goodbye();
	}
	private void goodbye() {
		System.out.println(GOODBYE);
	}
	private void printError(Exception e) {
		System.out.println("syntax error " + e.getMessage());
	}
	private void evaluate(String expression) {
		Double result = parser.parse(expression);
		if (result != null) {
			printResult(result);
		}
	}
	private void printResult(Double result) {
		printStream.println(result);
	}
	private String readLine() {
		return scanner.nextLine();
	}
	
	private void printPrompt() {
		printStream.print(PROMPT);
	}

}

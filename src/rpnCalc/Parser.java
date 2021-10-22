package rpnCalc;

import java.util.EmptyStackException;

public class Parser {

	private static final String TK_ADD = "+";
	private static final String TK_SUB = "-";
	private static final String TK_MUL = "*";
	private static final String TK_DIV = "/";
	private static final String TK_CLEAR = "clear";
	private static final String TK_HELP = "help";
	private static final String TK_EXIT = "exit";
	private Calculator calculator;
	private CommandListener listener;
	

	public Parser(Calculator calculator, CommandListener listener) {
		this.calculator = calculator;
		this.listener = listener;
	}

	public Double parse(String expression) {
		if (expression.isEmpty() || expression.isBlank()) {
			return null;
		}
		String[] tokens = expression.split(" ");
		for (String token: tokens) {
			parseToken(token);
		}
		
		return getResult();
		
					
	}

	private Double getResult() {
		try {
			return calculator.push(calculator.pop());
		}
		catch (EmptyStackException e) {
			// do nothing
		}
		return null;
	}

	private Double parseToken(String token) {
		switch (token) {	
			case TK_ADD: {
				return add();	
			}
			case TK_SUB: {
				return sub();
			}
			case TK_MUL: {
				return mul();
			}
			case TK_DIV: {
				return div();
			}
			case TK_CLEAR: {
				return clear();
			}
			case TK_HELP: {
				return help();
			}
			case TK_EXIT: {
				return exit();
			}
			default:
				break;
		}
		return pushNumber(token);				
	}


	private Double parseNumber(String expression) {
		return Double.parseDouble(expression);
	}

	private Double pushNumber(String token) {
		return this.calculator.push(parseNumber(token));
	}

	
	private Double exit() {
		listener.exit();
		return null;
	}
	private Double help() {
		listener.help();
		return null;
	}
	
	private Double clear() {
		return calculator.clear();
	}

	private Double div() {
		return calculator.div();
	}

	private Double mul() {
		return calculator.mult();
	}

	private Double sub() {
		return calculator.sub();
	}

	private Double add() {
		return calculator.add();
	}



}

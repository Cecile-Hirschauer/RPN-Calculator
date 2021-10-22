package rpnCalc;

import java.util.Stack;

public class Calculator {

	public Stack<Double> operand = new Stack<>();

	public Double push(double number) {
		return operand.push(number);		
	}

	public Double pop() {
		return operand.pop();
	}

	public Double add() {
		Double operand2 = pop();
		Double operand1 = pop();
		Double result = operand1 + operand2;
		push(result);
		return result;
	}

	public Double sub() {
		Double operand2 = pop();
		Double operand1 = pop();
		Double result = operand1 - operand2;
		push(result);
		return result;
	}

	public Double mult() {
		Double operand2 = pop();
		Double operand1 = pop();
		Double result = operand1 * operand2;
		push(result);
		return result;
	}

	public Double div() {
		Double operand2 = pop();
		Double operand1 = pop();
		Double result = operand1 / operand2;
		push(result);
		return result;
	}

	public Double clear() {
		operand.clear();
		return null;	
	}

}

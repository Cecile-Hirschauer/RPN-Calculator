package rpnCalc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParserTest implements CommandListener {

	private Calculator calculator = new Calculator();
	private Parser parser = new Parser(calculator, this);
	boolean helpHasBeenCalled = false;
	boolean exitHasBeenCalled = false;

	@Test
	void should_return_null_when_empty() {
		assertNull(parser.parse(""));
	}
	
	@Test
	void should_return_null_when_blank() {
		assertNull(parser.parse(" "));
	}

	@Test
	void should_get_0_when_operand_is_0() {
		assertEquals(0, parser.parse("0"));
	}
	
	@Test
	void should_get_7_when_operator_is_plus_and_operand1_is_3_and_operand2_is_4() {
		assertEquals(3., parser.parse("3"));
		assertEquals(4., parser.parse("4"));
		assertEquals(7., parser.parse("+"));
	}
	
	@Test
	void should_get_4_when_operator_is_minus_and_operand1_is_7_and_operand2_is_3() {
		assertEquals(7., parser.parse("7"));
		assertEquals(3., parser.parse("3"));
		assertEquals(4., parser.parse("-"));
	}
	
	@Test
	void should_get_15_when_operator_is_multiply_and_operand1_is_5_and_operand2_is_3() {
		assertEquals(5., parser.parse("5"));
		assertEquals(3., parser.parse("3"));
		assertEquals(15., parser.parse("*"));
	}
	
	//	20 5 /          => renvoie 4
	@Test
	void should_get_4_when_expression_is_20_space_5_space_divide() {
		assertEquals(4., parser.parse("20 5 /"));	
	}
	
	// 4 2 + 3 -       => renvoie 3
	@Test
	void should_get_3_when_expression_is_4_space_2_space_plus_space_3_space_minus() {
		assertEquals(3., parser.parse("4 2 + 3 -"));	
	}
	
	//	3 5 8 * 7 + *   => renvoie 141
	@Test
	void should_get_141_when_expression_is_3_space_5_space_8_space_multiply_space_7_space_plus_space_multiply() {
		assertEquals(141., parser.parse("3 5 8 * 7 + *"));	
	}
	
	//	12 3 - 3 /      => renvoie 3
	@Test
	void should_get_3_when_expression_is_12_space_3_space_minus_space_3_space_divide() {
		assertEquals(3., parser.parse("12 3 - 3 /"));	
	}
	
	//	-2 3 11 + 5 - * => renvoie -18
	@Test
	void should_get_minus_18_when_expression_is_minus_2_space_3_space_11_space_plus_space_5_space_minus_space_multiply() {
		assertEquals(-18., parser.parse("-2 3 11 + 5 - *"));
	}
	
	@Test
	void should_get_null_when_expression_is_clear() {
		assertNull( parser.parse("clear"));		
	}
	
	@Test
	void should_get_null_when_expression_is_help() {
		assertNull( parser.parse("help"));		
		assertTrue(helpHasBeenCalled);
	}
	
	@Test
	void should_get_null_when_expression_is_exit() {
		assertNull( parser.parse("exit"));		
		assertTrue(exitHasBeenCalled);
	}
	
	@Test
	void should_get_positive_infini_when_operator_is_divide_and_operand1_is_15_and_operand2_is_0() {
		assertEquals(15., parser.parse("15"));
		assertEquals(0., parser.parse("0"));
		assertEquals(Double.POSITIVE_INFINITY, parser.parse("/"));
	}

	@Override
	public void exit() {
		exitHasBeenCalled = true;
	}

	@Override
	public void help() {
		helpHasBeenCalled = true;
	}
	
}

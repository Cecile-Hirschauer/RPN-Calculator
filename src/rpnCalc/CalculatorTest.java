package rpnCalc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {
	Calculator calc = new Calculator();

	@Test
	void should_get_0_when_pushing_or_pop_0() {
		assertEquals(0, calc.push(0));
		assertEquals(0, calc.pop());
	}
	
	@Test
	void should_get_5_when_adding_3_and_2() {
		assertEquals(3., calc.push(3.));
		assertEquals(2., calc.push(2.));
		assertEquals(5., calc.add());
		assertEquals(5., calc.pop());
	}

	@Test
	void should_get_3_when_substracting_2_from_5() {
		assertEquals(5., calc.push(5.));
		assertEquals(2., calc.push(2.));
		assertEquals(3., calc.sub());
		assertEquals(3., calc.pop());
	}
	
	@Test
	void should_get_10_when_multiplying_2_and_5() {
		assertEquals(2., calc.push(2.));
		assertEquals(5., calc.push(5.));
		assertEquals(10., calc.mult());
		assertEquals(10., calc.pop());
	}
	
	@Test
	void should_clear_parser() {
		assertEquals(2., calc.push(2.));
		assertEquals(5., calc.push(5.));
		assertNull(calc.clear());
	}
	
	
	@Test
	void should_get_5_when_dividing_2_from_10() {
		assertEquals(10., calc.push(10.));
		assertEquals(2., calc.push(2.));
		assertEquals(5., calc.div());
		assertEquals(5., calc.pop());
	}
	
	@Test
	void should_get_positive_infini_when_dividing_by_0() {
		assertEquals(6., calc.push(6.));
		assertEquals(0., calc.push(0.));
		assertEquals(Double.POSITIVE_INFINITY, calc.div());
		assertEquals(Double.POSITIVE_INFINITY, calc.pop());
	}
	
	
	
}

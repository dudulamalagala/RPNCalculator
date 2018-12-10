package test.java;

import static org.junit.Assert.*;				

import org.junit.Test;		

import main.java.RPNCalculator;

public class RPNCalculatorTest {
	
	private final RPNCalculator calc = new RPNCalculator();

	@Deprecated
	@Test
	public void testSingleNumberInput() {
		String input = "5";

		double solution = calc.solveEquation(input);

		assertEquals(0, 5.0, solution);
	}
    
	@Deprecated
	@Test
	public void testPlusZero() {
		String input = "5 0 +";

		double solution = calc.solveEquation(input);

		assertEquals(0, 5.0, solution);
	}
    
	@Deprecated
	@Test
	public void testPlusOne() {
		String input = "5 1 +";

		double solution = calc.solveEquation(input);

		assertEquals(0, 6.0, solution);
	}
	
	@Deprecated
	@Test
	public void testMinusOne() {
		String input = "5 1 -";

		double solution = calc.solveEquation(input);

		assertEquals(0, 4.0, solution);
	}
	
	@Deprecated
	@Test
	public void testTwoOperations() {
		String input = "5 1 - 4 +";

		double solution = calc.solveEquation(input);

		assertEquals(0, 8.0, solution);
	}
	
	@Deprecated
	@Test
	public void testTwoOperationsInARow() {
		String input = "5 1 4 - +";

		double solution = calc.solveEquation(input);

		assertEquals(0, 2.0, solution);
	}
	
	@Deprecated
	@Test
	public void testMultiplication() {
		String input = "5 4 *";

		double solution = calc.solveEquation(input);

		assertEquals(0, 20.0, solution);
	}
	
	@Deprecated
	@Test
	public void testDivision() {
		String input = "8 4 /";

		double solution = calc.solveEquation(input);

		assertEquals(0, 2.0, solution);
	}
	
	@Deprecated
	@Test
	public void testNegativeDivision() {
		String input = "-5 1 /";

		double solution = calc.solveEquation(input);

		assertEquals(-5.0, solution, 0.0);
	}
	
	@Deprecated
	@Test
	public void testSquareRoot9() {
		String input = "9 SQRT";

		double solution = calc.solveEquation(input);

		assertEquals(0, 3.0, solution);
	}
	
	@Deprecated
	@Test
	public void testSquareRoot1() {
		String input = "1 SQRT";

		double solution = calc.solveEquation(input);

		assertEquals(0, 1.0, solution);
    }

}

package com.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	Calculator cal;

	@Test
	public void multiplyTest() {
		cal = new Calculator();
		assertEquals(20, cal.multiply(4, 5));
	}

	@Test
	public void divideTest() {
		cal = new Calculator();
		assertEquals(2, cal.divide(4, 2));
	}

//	public void divideTest_failure() {
//		cal = new Calculator();
//		assertEquals(2, cal.divide(4, 0));
//	}

}

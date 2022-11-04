package com.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest( Calculator.class )
public class StaticMocks {
		
	private Calculator calc;
	 
	   @Before
	   public void setUp() {
	      calc = new Calculator();
	 
	      PowerMockito.mockStatic(Calculator.class);
	      PowerMockito.when(Calculator.add(1, 1)).thenReturn(2);
	      PowerMockito.when(Calculator.add(2, 2)).thenReturn(4);
	   }
	 
	   @Test 
	   public void shouldCalculateInAStrangeWay() {
	      assertEquals(0, calc.add(1, 1) );
	      assertEquals(1, calc.add(2, 2) );
	   }
}

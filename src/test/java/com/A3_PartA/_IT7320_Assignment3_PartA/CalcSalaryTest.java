package com.A3_PartA._IT7320_Assignment3_PartA;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class CalcSalaryTest {
	
	CalcSalary calcSalaryObj;
	Employee empObj; 
	double income;
	double expectedTax, expectedWeeklySalary, expectedFortnightSalary, expectedKiwiSaver;
	double actualTax, actualWeeklySalary, actualFortnightSalary, actualKiwiSaver;
	
	ISalary mockObj; 

	@Before
	public void setUp() throws Exception {
		calcSalaryObj = new CalcSalary();
		empObj = new Employee();
		income = 110000.00; 
		expectedTax = 33.0;
		expectedWeeklySalary = (income - (income * (expectedTax/100))) / 52;
		expectedFortnightSalary = expectedWeeklySalary * 2;
		
		/* Compute Tax */
		mockObj = Mockito.mock(ISalary.class);
		Mockito.when(mockObj.computeTax(income)).thenReturn(income);
		calcSalaryObj.setObj(mockObj);
		
		System.out.println("Income from CalcSalaryTest: " + income);
		actualTax = calcSalaryObj.computeTax(income);
		
		empObj = new Employee(income, actualTax, 0.00, 0.00, 0.00);
		
		/* Compute actualWeeklySalary */
		Mockito.when(mockObj.weeklySalary(empObj)).thenReturn(empObj.getWeeklySalary());
		calcSalaryObj.setObj(mockObj);
	
		actualWeeklySalary = calcSalaryObj.weeklySalary(empObj);
		
		empObj = new Employee(income, actualTax, actualWeeklySalary, 0.00, 0.00);
		
		/* Compute actualForthnightSalary */
		Mockito.when(mockObj.weeklySalary(empObj)).thenReturn(empObj.getFortnightSalary());
		calcSalaryObj.setObj(mockObj);
	
		actualFortnightSalary = calcSalaryObj.weeklySalary(empObj);
	}


	@Test
	public void testCalcSalary() {
		assertEquals(expectedTax, actualTax, 0);
		
	}
		
	@Test
	public void testWeeklySalary() {
		assertEquals(expectedWeeklySalary, actualWeeklySalary, 0);
	}
	
	@Test
	public void testFortnightSalary() {
		assertEquals(expectedFortnightSalary, actualFortnightSalary, 0);
	}
	
	@After
	public void tearDown() throws Exception {
		calcSalaryObj = null;
		empObj = null;
	}
	



}

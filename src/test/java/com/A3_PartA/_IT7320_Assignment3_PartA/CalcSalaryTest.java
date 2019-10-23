package com.A3_PartA._IT7320_Assignment3_PartA;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CalcSalaryTest {

	CalcSalary calcSalaryObj;
	CalcSalaryCompute calcSalaryComputeObj;
	Employee empObj;
	double income, kiwiSaverPer;
	double expectedTax, expectedWeeklySalary, expectedFortnightSalary, expectedKiwiSaver;
	double actualTax, actualWeeklySalary, actualFortnightSalary, actualKiwiSaver;

	ISalary mockObj;

	@Before
	public void setUp() throws Exception {
		calcSalaryObj = new CalcSalary();
		calcSalaryComputeObj = new CalcSalaryCompute();
		empObj = new Employee();
		income = 110000.00;
		expectedTax = 33.0;
		kiwiSaverPer = 3.0;
		expectedWeeklySalary = (income - (income * (expectedTax / 100))) / 52;
		expectedFortnightSalary = expectedWeeklySalary * 2;
		expectedKiwiSaver = income * (kiwiSaverPer / 100);

		/* Compute Tax */
		mockObj = Mockito.mock(ISalary.class);
		Mockito.when(mockObj.computeTax(income)).thenReturn(calcSalaryComputeObj.computeTax(income));
		calcSalaryObj.setObj(mockObj);

		actualTax = calcSalaryObj.computeTax(income);

		empObj = new Employee(income, actualTax, 0.00, 0.00, kiwiSaverPer);

		
		  //Compute actualWeeklySalary
		  Mockito.when(mockObj.weeklySalary(empObj)).thenReturn(calcSalaryComputeObj.weeklySalary(empObj)); 
		  calcSalaryObj.setObj(mockObj);
		  
		  actualWeeklySalary = calcSalaryObj.weeklySalary(empObj);
		  
		  empObj = new Employee(income, actualTax, actualWeeklySalary, 0.00,
		  kiwiSaverPer);
		  
		  //Compute actualForthnightSalary
		  Mockito.when(mockObj.fortnightSalary(empObj)).thenReturn(calcSalaryComputeObj.fortnightSalary(empObj)); 
		  calcSalaryObj.setObj(mockObj);
		  
		  actualFortnightSalary = calcSalaryObj.fortnightSalary(empObj);
		  
		  //Compute actualKiwiSaver
		  Mockito.when(mockObj.computeKiwiSaver(empObj)).thenReturn(calcSalaryComputeObj.computeKiwiSaver(empObj)); 
		  calcSalaryObj.setObj(mockObj);
		  
		  actualKiwiSaver = calcSalaryObj.computeKiwiSaver(empObj);	 

	}

	@Test
	public void testComputeTax() {
		assertEquals(expectedTax, actualTax, 0);

	}

	
	  @Test public void testWeeklySalary() { assertEquals(expectedWeeklySalary,
	  actualWeeklySalary, 0); }
	  
	  @Test public void testFortnightSalary() {
	  assertEquals(expectedFortnightSalary, actualFortnightSalary, 0); }
	  
	  @Test public void testComputeKiwiSaver() { assertEquals(expectedKiwiSaver,
	  actualKiwiSaver, 0); }
	 

	@After
	public void tearDown() throws Exception {
		calcSalaryObj = null;
		empObj = null;
	}

}

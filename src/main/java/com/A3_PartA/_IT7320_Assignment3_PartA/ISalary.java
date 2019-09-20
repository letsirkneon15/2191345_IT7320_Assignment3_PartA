package com.A3_PartA._IT7320_Assignment3_PartA;

public interface ISalary {
	
	public double computeTax(double income);
	
	public double weeklySalary(Employee income);
	
	public double fortnightSalary(Employee income);
	
	public double computeKiwiSaver(Employee income);
	
}

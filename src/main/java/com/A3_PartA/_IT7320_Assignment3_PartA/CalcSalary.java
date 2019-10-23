package com.A3_PartA._IT7320_Assignment3_PartA;

public class CalcSalary implements ISalary {
	
	ISalary obj = null; 
	Employee emp = new Employee();

	public double computeTax(double income) {

		return obj.computeTax(income);
	}

	public double weeklySalary(Employee income) {
	
		
		return obj.weeklySalary(income);
	}

	public double fortnightSalary(Employee income) {
	
		return obj.fortnightSalary(income);
	}

	/* Calculate KiwiSaver */
	public double computeKiwiSaver(Employee income) {

		return obj.computeKiwiSaver(income);
	}

	public void setObj(ISalary obj) {
		this.obj = obj;
	}
}

package com.A3_PartA._IT7320_Assignment3_PartA;

import java.util.HashMap;
import java.util.Map;

public class CalcSalary_backup implements ISalary {
	
	ISalary obj = null; 
	Employee emp = new Employee();

	public double computeTax(double income) {
		
		System.out.println("Income from CalcSalary: " + income);
		
		double tax = 0.0; 
		
		if(income >= 0 && income <=14000) {
			tax = 10.5; 
		}else if(income >= 14001 && income <= 48000){
			tax = 17.5;	
		}else if(income >= 48001 && income <= 70000){
			tax = 30.0;	
		}else if(income > 70000){
			tax = 33.0;	
		}
			
		System.out.println("Tax from CalcSalary: " + tax);
		return obj.computeTax(tax);
	}

	public double weeklySalary(Employee income) {
	
		double weeklySalary = 0; 
		
		weeklySalary = (income.getAnnualSalary() - (income.getAnnualSalary()* (income.getTax()/100))) / 52;
		income = new Employee(income.getAnnualSalary(), income.getTax(), weeklySalary, 
				income.getFortnightSalary(), income.getKiwiSaver());
		
		return obj.weeklySalary(income);
	}

	public double fortnightSalary(Employee income) {
		
		double fornightSalary = 0; 
		
		fornightSalary = income.getWeeklySalary() * 2;
		income = new Employee(income.getAnnualSalary(), income.getTax(), income.getWeeklySalary(), 
				fornightSalary, income.getKiwiSaver());
	
		return obj.fortnightSalary(income);
	}

	/* Calculate KiwiSaver */
	public double computeKiwiSaver(Employee income) {
		
		double kiwiSaver = 0.0;
		
		Map<Double, Double> kiwiSaverMap = new HashMap<Double, Double>();
		
		kiwiSaverMap.put(3.0, 3.0);
		kiwiSaverMap.put(4.0, 4.0);
		kiwiSaverMap.put(6.0, 6.0);
		kiwiSaverMap.put(8.0, 8.0);
		kiwiSaverMap.put(10.0, 10.0);
		
		kiwiSaver = kiwiSaverMap.get(income.getKiwiSaver());
		kiwiSaver = income.getAnnualSalary() * (kiwiSaver / 100);
		income = new Employee(income.getAnnualSalary(), income.getTax(), income.getWeeklySalary(), 
				income.getFortnightSalary(), kiwiSaver);

		return obj.computeKiwiSaver(income);
	}

	public void setObj(ISalary obj) {
		this.obj = obj;
	}
}

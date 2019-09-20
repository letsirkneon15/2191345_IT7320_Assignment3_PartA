package com.A3_PartA._IT7320_Assignment3_PartA;

import java.io.Serializable;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private double annualSalary;
	private double tax; 
	private double weeklySalary; 
	private double fortnightSalary; 
	private double kiwiSaver;
	
	public Employee(double annualSalary, double tax, double weeklySalary, double fortnightSalary, double kiwiSaver) {
		super();
		this.annualSalary = annualSalary;
		this.tax = tax;
		this.weeklySalary = weeklySalary;
		this.fortnightSalary = fortnightSalary;
		this.kiwiSaver = kiwiSaver;
	}
	
	public Employee() {
		
	}

	public double getAnnualSalary() {
		return annualSalary;
	}
	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getWeeklySalary() {
		return weeklySalary;
	}
	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}
	public double getFortnightSalary() {
		return fortnightSalary;
	}
	public void setFortnightSalary(double fortnightSalary) {
		this.fortnightSalary = fortnightSalary;
	}
	public double getKiwiSaver() {
		return kiwiSaver;
	}
	public void setKiwiSaver(double kiwiSaver) {
		this.kiwiSaver = kiwiSaver;
	} 
}

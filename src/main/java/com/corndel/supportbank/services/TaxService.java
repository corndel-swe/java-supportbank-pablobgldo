package com.corndel.supportbank.services;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "tax")
public class TaxService implements Runnable {

    @Parameters(index = "0")
    private double salary;

    @Override
    public void run() {
        double netSalary = calculateNetSalary(salary);
        System.out.printf("Net salary for a salary of £%.2f is £%.2f%n", salary, netSalary);
    }

    private double calculateNetSalary(double salary) {
        if (salary <= 12570) {
            return salary;
        } else if (salary <= 50270) {
            return salary * 0.8;
        } else if (salary <= 125140) {
            return salary * 0.6;
        } else {
            return salary * 0.55;
        }
    }
}


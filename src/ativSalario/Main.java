/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ativSalario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner scn = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = scn.nextLine();
        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String workerName = scn.nextLine();
        System.out.print("Level: ");
        String workerLevel = scn.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = scn.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

        System.out.print("How many contracts to this worker? ");
        int n = scn.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter contract #" + i + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(scn.next());
            System.out.print("Value per hour: ");
            double valuePerHour = scn.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = scn.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = scn.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
    }
}

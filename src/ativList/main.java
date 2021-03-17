/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ativList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("How many employees will be registered?");
        int n = scn.nextInt();//numero de funcionarios
        List<funcionario> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Emplyoo #" + (i + 1));
            System.out.println("Id:");
            int id = scn.nextInt();

            System.out.println("Name: ");
            scn.nextLine();
            String name = scn.nextLine();

            System.out.println("Salary; ");
            double salary = scn.nextDouble();

            list.add(new funcionario(id, name, salary));
        }
        System.out.println("Enter the employee id that will have salary increase: ");
        int id = scn.nextInt();
        funcionario emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("This id does not exist!");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percentage = scn.nextDouble();
			emp.aumentSalary(percentage);
		}
        
        for (funcionario x : list){
            System.out.println(x);
        }
    }
}

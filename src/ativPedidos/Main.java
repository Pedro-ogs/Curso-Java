/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ativPedidos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner scn = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter cliente data: ");
        System.out.print("Name:");
        String name = scn.nextLine();
        System.out.print("Email: ");
        String email = scn.next();
        System.out.print("Birth date (DD/MM/YYYY):");
        Date birthDate = sdf.parse(scn.next());

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(scn.next());

        Order order = new Order(new Date(), status, client);

        System.out.println("How many items to this order? ");
        int num = scn.nextInt();
        for (int i = 1; i <= num; i++) {
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            scn.nextLine();
            String productName = scn.nextLine();
            System.out.print("Product price: ");
            Double productPrice = scn.nextDouble();

            Product product = new Product(productName, productPrice);

            System.out.println("Quantity: ");
            int quantity = scn.nextInt();

            OrderItem orderItem = new OrderItem(quantity, productPrice, product);

            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println(order);
    }
}

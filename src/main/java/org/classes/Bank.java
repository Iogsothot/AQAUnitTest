package org.classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank {

    private static double amount = 0;
    public Map<String, Customer> customerMap;

    public Bank() {
        customerMap = new HashMap<String, Customer>();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Customer customer;
        Bank bank = new Bank();
        int choice;
        outer:
        while (true) {

            System.out.println("Transaction");
            System.out.println("1. Registrar cont.");
            System.out.println("2. Login.");
            System.out.println("3. Exit.");
            System.out.print("\nEnter your choice : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter First Name : ");
                    String firstName = sc.nextLine();
                    System.out.print("Enter Last Name : ");
                    String lastName = sc.nextLine();
                    System.out.print("Enter Address : ");
                    String address = sc.nextLine();
                    System.out.print("Enter contact number : ");
                    String phone = sc.nextLine();
                    System.out.println("Set Username : ");
                    String username = sc.next();
                    while (bank.customerMap.containsKey(username)) {
                        System.out.println("Username already exists");
                        username = sc.next();
                    }
                    System.out.println("Set a password:");
                    String password = sc.next();
                    sc.nextLine();

                    customer = new Customer(firstName, lastName, address, phone, username, password);
                    bank.customerMap.put(username, customer);
                    break;

                case 2:
                    System.out.println("Enter username : ");
                    username = sc.next();
                    sc.nextLine();
                    System.out.println("Enter password : ");
                    password = sc.next();
                    sc.nextLine();
                    if (bank.customerMap.containsKey(username)) {
                        customer = bank.customerMap.get(username);
                        if (customer.getPassword().equals(password)) {
                            while (true) {

                                System.out.println("1. Deposit.");
                                System.out.println("2. Transfer.");
                                System.out.println("3. Last 3 transactions.");
                                System.out.println("4. User information.");
                                System.out.println("5. Log out.");
                                System.out.print("\nEnter your choice : ");
                                choice = sc.nextInt();
                                sc.nextLine();
                                switch (choice) {
                                    case 1:
                                        System.out.print("Enter amount : ");
                                        while (!sc.hasNextDouble()) {
                                            System.out.println("Invalid amount. Enter again :");
                                            sc.nextLine();
                                        }
                                        amount = sc.nextDouble();
                                        sc.nextLine();
                                        customer.deposit(amount);
                                        break;

                                    case 2:
                                        System.out.print("Enter beneficiary username : ");
                                        username = sc.next();
                                        sc.nextLine();
                                        System.out.println("Enter amount : ");
                                        while (!sc.hasNextDouble()) {
                                            System.out.println("Invalid amount. Enter again :");
                                            sc.nextLine();
                                        }
                                        amount = sc.nextDouble();
                                        sc.nextLine();

                                        if (bank.customerMap.containsKey(username)) {
                                            Customer payee = bank.customerMap.get(username);
                                            payee.deposit(amount);
                                            customer.withdraw(amount);
                                        } else {
                                            System.out.println("Username doesn't exist.");
                                        }
                                        break;

                                    case 3:
                                        for (String transactions : customer.getTransactions()) {
                                            System.out.println(transactions);
                                        }
                                        break;

                                    case 4:
                                        System.out.println("The account holder with the Firstname: " + customer.getFirstName());
                                        System.out.println("The account holder with the Lastname : " + customer.getLastName());
                                        System.out.println("The account holder with the Username : " + customer.getUsername());
                                        System.out.println("The account holder with the address : " + customer.getAddress());
                                        System.out.println("The account holder with the Phone : " + customer.getPhone());
                                        break;
                                    case 5:
                                        continue outer;
                                    default:
                                        System.out.println("Wrong choice !");
                                }
                            }
                        } else {
                            System.out.println("Wrong username/password.");
                        }
                    } else {
                        System.out.println("Wrong username/password.");
                    }
                    break;

                case 3:

                    System.exit(1);
                    break;
                default:
                    System.out.println("Wrong choice !");
            }
        }
    }
}
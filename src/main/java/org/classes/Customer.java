package org.classes;

import org.Interface.SavingsAccount;
import java.text.NumberFormat;
import java.util.ArrayList;


public class Customer extends Person implements SavingsAccount {

    private String username;

    private String password;

    private double balance;

    private ArrayList<String> transactions = new ArrayList<>(3);

    public Customer(String firstName, String lastName, String address, String phone, String username, String password, double balance, ArrayList<String> transactions) {
        super(firstName, lastName, address, phone);
        this.username = username;
        this.password = password;
        this.balance = balance;
        addTransaction(String.format("Initial deposit - " + NumberFormat.getCompactNumberInstance()));
    }

    public Customer(String firstName, String lastName, String address, String phone, String username, String password) {
        super(firstName, lastName, address, phone);
        this.username = username;
        this.password = password;
    }

    public Customer() {
    }

    private void addTransaction(String message) {

        transactions.add(0, message);
        if (transactions.size() > 3) {
            transactions.remove(3);
            transactions.trimToSize();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<String> transactions) {
        this.transactions = transactions;
    }

    @Override
    public void deposit(double amount) {

        balance += amount;
        addTransaction(String.format(NumberFormat.getCurrencyInstance().format(amount) + " credited to your account. Balance - " + balance));
    }

    @Override
    public void withdraw(double amount) {

        balance -= amount;
        addTransaction(String.format(NumberFormat.getCurrencyInstance().format(amount) + " debited from your account. Balance - " + balance));
    }

    @Override
    public String toString() {
        return "Customer{" + "username='" + username + '\'' + ", password='" + password + '\'' + ", balance=" + balance + ", transactions=" + transactions + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (Double.compare(customer.getBalance(), getBalance()) != 0) return false;
        if (getUsername() != null ? !getUsername().equals(customer.getUsername()) : customer.getUsername() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(customer.getPassword()) : customer.getPassword() != null)
            return false;
        return getTransactions() != null ? getTransactions().equals(customer.getTransactions()) : customer.getTransactions() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getUsername() != null ? getUsername().hashCode() : 0;
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        temp = Double.doubleToLongBits(getBalance());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getTransactions() != null ? getTransactions().hashCode() : 0);
        return result;
    }
}
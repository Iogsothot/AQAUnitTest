import org.classes.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerTest {

    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer("John", "Doe", "123 Main Street", "123-456-7890", "jdoe", "password", 100.0, new ArrayList<>());
    }

    @Test
    public void testDeposit() {

        double amount = 100.0;


        customer.deposit(amount);


        assertEquals(200, customer.getBalance(), 0.0);
        assertEquals(2, customer.getTransactions().size());
    }

    @Test
    public void testWithdraw() {

        double amount = 100.0;


        customer.withdraw(amount);


        assertEquals(0.0, customer.getBalance(), 0.0);
        assertEquals(2, customer.getTransactions().size());

    }

    @Test
    public void testTransactions() {

        double amount1 = 100.0;
        double amount2 = 200.0;
        double amount3 = 300.0;


        customer.deposit(amount1);
        customer.deposit(amount2);
        customer.withdraw(amount3);


        assertEquals(amount1 + amount2 - amount3 + 100, customer.getBalance(), 0.0);
        assertEquals(3, customer.getTransactions().size());


    }


    @Test
    public void testEqualsAndHashCode() {

        Customer customer1 = new Customer("John", "Doe", "123 Main Street", "123-456-7890", "jdoe", "password", 100.0, new ArrayList<>());
        Customer customer2 = new Customer("John", "Doe", "123 Main Street", "123-456-7890", "jdoe", "password", 100.0, new ArrayList<>());
        Customer customer3 = new Customer("John", "Doe", "123 Main Street", "123-456-7890", "jdoe", "password", 100.0, new ArrayList<>());
        Customer customer4 = new Customer("John", "Doe", "123 Main Street", "123-456-7890", "jdoe", "password", 100.0, new ArrayList<>());
        Customer customer5 = new Customer("John", "Doe", "123 Main Street", "123-456-7890", "jdoe", "password", 100.0, new ArrayList<>());
        Customer customer6 = new Customer("John", "Doe", "123 Main Street", "123-456-7890", "jdoe", "password", 100.0, new ArrayList<>());


        boolean equals1 = customer1.equals(customer2);
        boolean equals2 = customer1.equals(customer3);
        boolean equals3 = customer1.equals(customer4);
        boolean equals4 = customer1.equals(customer5);
        boolean equals5 = customer1.equals(customer6);

        assertTrue(equals1);
        assertTrue(equals2);
        assertTrue(equals3);
        assertTrue(equals4);
        assertTrue(equals5);


        int hashCode1 = customer1.hashCode();
        int hashCode2 = customer2.hashCode();
        int hashCode3 = customer3.hashCode();
        int hashCode4 = customer4.hashCode();
        int hashCode5 = customer5.hashCode();
        int hashCode6 = customer6.hashCode();


        assertEquals(hashCode1, hashCode2);
        assertEquals(hashCode1, hashCode3);
        assertEquals(hashCode1, hashCode4);
        assertEquals(hashCode1, hashCode5);
        assertEquals(hashCode1, hashCode6);
    }
}
import org.classes.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testConstructor() {

        String firstName = "John";
        String lastName = "Doe";
        String address = "123 Main Street";
        String phone = "123-456-7890";


        Person person = new Person(firstName, lastName, address, phone);

        assertEquals(firstName, person.getFirstName());
        assertEquals(lastName, person.getLastName());
        assertEquals(address, person.getAddress());
        assertEquals(phone, person.getPhone());
    }

    @Test
    public void testGettersAndSetters() {

        String firstName = "John";
        String lastName = "Doe";
        String address = "123 Main Street";
        String phone = "123-456-7890";
        Person person = new Person();


        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAddress(address);
        person.setPhone(phone);


        assertEquals(firstName, person.getFirstName());
        assertEquals(lastName, person.getLastName());
        assertEquals(address, person.getAddress());
        assertEquals(phone, person.getPhone());
    }

    @Test
    public void testToString() {

        String firstName = "John";
        String lastName = "Doe";
        String address = "123 Main Street";
        String phone = "123-456-7890";
        Person person = new Person(firstName, lastName, address, phone);


        String expected = "Person{firstName='John', lastName='Doe', address='123 Main Street', phone='123-456-7890'}";


        assertEquals(expected, person.toString());
    }

    @Test
    public void testEqualsAndHashCode() {

        String firstName = "John";
        String lastName = "Doe";
        String address = "123 Main Street";
        String phone = "123-456-7890";
        Person person1 = new Person(firstName, lastName, address, phone);
        Person person2 = new Person(firstName, lastName, address, phone);
        Person person3 = new Person("Jane", "Doe", "123 Main Street", "123-456-7890");
        Person person4 = new Person("John", "Doe", "123 Main Street", "123-456-7890");
        Person person5 = new Person("John", "Doe", "456 Main Street", "123-456-7890");
        Person person6 = new Person("John", "Doe", "123 Main Street", "987-654-3210");


        boolean equals1 = person1.equals(person2);
        boolean equals2 = person1.equals(person3);
        boolean equals3 = person1.equals(person4);
        boolean equals4 = person1.equals(person5);
        boolean equals5 = person1.equals(person6);


        assertTrue(equals1);
        assertFalse(equals2);
        assertTrue(equals3);
        assertFalse(equals4);
        assertFalse(equals5);


        int hashCode1 = person1.hashCode();
        int hashCode2 = person2.hashCode();
        int hashCode3 = person3.hashCode();
        int hashCode4 = person4.hashCode();
        int hashCode5 = person5.hashCode();
        int hashCode6 = person6.hashCode();

        assertEquals(hashCode1, hashCode2);
        assertNotEquals(hashCode1, hashCode3);
    }
}
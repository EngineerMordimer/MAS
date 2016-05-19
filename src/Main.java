import domain.Address;
import domain.Company;
import domain.IndividualCustomer;
import domain.Person;

import java.io.*;
import java.util.Date;

/**
 * Created by maciek on 13/04/16.
 */
public class Main {
    public static void main (String[] args) throws FileNotFoundException {
        Person person1 = new Person("Jacek" , "Kowalski");
        Person person2 = new Person("Paweł" , "Nowak" , new Date(91,11,26));
        Person person3 = new Person("Ewa" , "Odeszła" , new Date(22,10,26));

        Person.showExtension();
        System.out.println("Najstarsza osoba urodziła się " + Person.getTheOldestBirthDate().toLocaleString() );

        IndividualCustomer customer1 = new IndividualCustomer(person3);

        System.out.println("Rabat dla " + customer1 + ", wynosi: " + customer1.getDiscount());
        customer1.setMaidenName("Larwa");
        System.out.println("Rabat dla " + customer1 + ", wynosi: " + customer1.getDiscount());

        person3.getName().add("Janina");
        System.out.println(customer1);

        customer1.setAddress(new Address("Jagiellońska 12" , "Kraków" , "05-321" ));
        System.out.println(customer1.getAddress());

        Company customer2 = new Company("Orange Polska","123 123 123");
        System.out.println("Rabat dla " + customer2 + ", wynosi: " + customer2.getDiscount());

        System.out.println("Stawka podstawowa wynosi: " + customer1.getSalary() + "  -  " + customer2.getSalary());



        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("extension.txt"));

            Person.saveExtension(outputStream);
            outputStream.close();
            Person person5 = new Person("Janek" , "DodanyJeszczeRaz" );
            System.out.println("odczyt ekstensji wersja prawidłowa:");

            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("extension.txt"));

            Person.readExtension(inputStream);

            inputStream.close();
            Person.showExtension();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Najstarsza osoba w bazie to "+ Person.getTheOldestPerson());

    }
}

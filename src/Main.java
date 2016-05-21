import domain.*;

import java.io.*;
import java.util.Date;

/**
 * Created by maciek on 13/04/16.
 */
public class Main {
    public static void main (String[] args) throws FileNotFoundException , Exception{


//        Mini projekt nr 1.
//
//
//        Person person1 = new Person("Jacek", "Kowalski");
//        Person person2 = new Person("Paweł", "Nowak", new Date(91, 11, 26));
//        Person person3 = new Person("Ewa", "Odeszła", new Date(22, 10, 26));
//        Person.showExtension();
//        System.out.println("Najstarsza osoba urodziła się " + Person.getTheOldestBirthDate().toLocaleString() );
//
//        IndividualCustomer customer1 = new IndividualCustomer(person3);
//
//        System.out.println("Rabat dla " + customer1 + ", wynosi: " + customer1.getDiscount());
//        customer1.setMaidenName("Larwa");
//        System.out.println("Rabat dla " + customer1 + ", wynosi: " + customer1.getDiscount());
//
//        person3.getName().add("Janina");
//        System.out.println(customer1);
//
//        customer1.setAddress(new Address("Jagiellońska 12" , "Kraków" , "05-321" ));
//        System.out.println(customer1.getAddress());
//
//        Company customer2 = new Company("Orange Polska","123 123 123");
//        System.out.println("Rabat dla " + customer2 + ", wynosi: " + customer2.getDiscount());
//
//        System.out.println("Stawka podstawowa wynosi: " + customer1.getSalary() + "  -  " + customer2.getSalary());
//
//        try {
//            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("extension.txt"));
//
//            Person.saveExtension(outputStream);
//            outputStream.close();
//            Person person5 = new Person("Janek" , "DodanyJeszczeRaz" );
//            System.out.println("odczyt ekstensji wersja prawidłowa:");
//
//            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("extension.txt"));
//
//            Person.readExtension(inputStream);
//
//            inputStream.close();
//            Person.showExtension();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Najstarsza osoba w bazie to "+ Person.getTheOldestPerson());
//


//        Mini projekt 2

        Employee emp1 = new Employee("Janusz" , "Jankowy" , "Janur");
        Employee emp2 = new Employee("Wiesław" , "Wiesławowy" , "Wies");
        Employee emp3 = new Employee("Mirek" , "Mirosław" , "Miro");

        LegalCase lc1 = new LegalCase(1,"Pobicie żony Jarosława W.");
        LegalCase lc2 = new LegalCase(2,"Napad na bank w Kozienicach");
        LegalCase lc3 = new LegalCase(3,"Atak Isis na tramwaj");

        emp1.addCase(lc1,new Date(16 , 11, 23));
        emp1.addCase(lc3,new Date(16 , 1, 11));

        lc2.addEmployee(emp2 , new Date(16 , 1, 11));
        lc3.addEmployee(emp3 , new Date(16 , 1, 11));

        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);

        System.out.println(lc1);
        System.out.println(lc2);
        System.out.println(lc3);


        System.out.println("\n\nKompozycja");

        Task.createTask(lc1 , new Date() , "Spotkanie");
        Task.createTask(lc2 , new Date() , "Spotkanie");
        Task.createTask(lc1 , new Date() , "Rozmowa");


        System.out.println(lc1.showTasks());



        System.out.println("\n\nBinarna");

        Workstation w1 = new Workstation( 11 , 2);
        Workstation w2 = new Workstation( 22 , 4);
        Workstation w3 = new Workstation( 24 , 1);

        emp1.setWorkstation(w1);
        w2.addEmployee(emp3);
        w2.addEmployee(emp2);

        System.out.println(w2.toString());
        System.out.println(emp1.showWorkstation());


        System.out.println("\n\nKwalifikowana");
        Floor f1 = new Floor(1);
        Floor f2 = new Floor(2);

        w1.setFloor(f1);
        w2.setFloor(f2);
        w3.setFloor(f2);

        System.out.println(w1);
        System.out.println(f2.findWorkstation(w3.getRoomNumber()).toString());
        System.out.println(f2.findWorkstation(22).toString());
    }
}

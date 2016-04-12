package domain;

import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Person {
    private int id;
    private List<String> name;                                                                   // atrybut powtarzalny
    private String surname;
    private Date birthDate;

    public Person(){
        addPerson(this);
    }

    private static Vector<Person> extensionPerson = new Vector<Person>();                                     // ekstensja

    private static void addPerson(Person person){
        extensionPerson.add(person);
    }
    private static void deletePerson(Person person){
        extensionPerson.remove(person);
    }

    public static void showExtension(){
        System.out.println("Ekstensja klasy domain.Person: ");
        for (Person person : extensionPerson){
            System.out.println(person);
        }
    }

    public String toString(){
        String text ="";
        text += "Nazwisko: " + this.surname+", imię: ";
        for (String n : this.name){
            text += n + ", ";
        }
        return text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public static Vector<Person> getExtensionPerson() {
        return extensionPerson;
    }

    public static void setExtensionPerson(Vector<Person> extensionPerson) {
        Person.extensionPerson = extensionPerson;
    }
}
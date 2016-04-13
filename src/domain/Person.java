package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Person {
    private int id;
    private List<String> name;                                                                   // atrybut powtarzalny
    private String surname;
    private Date birthDate;
    private static Vector<Person> extensionPerson = new Vector<Person>();                        // ekstensja



    // przeciążanie
    public Person(){
        addPerson(this);
    }
    public Person ( String name , String surname){
        this();
        this.setName( new ArrayList<String>() );
        this.getName().add(name);
        this.setSurname(surname);
    }
    public Person(String name , String surname , Date birthDate){
        this(name,surname);
        this.setBirthDate(birthDate);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate;}

    public List<String> getName() { return name; }
    public void setName(List<String> name) { this.name = name;}

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public static Vector<Person> getExtensionPerson() {
        return extensionPerson;
    }
    public static void setExtensionPerson(Vector<Person> extensionPerson) {
        Person.extensionPerson = extensionPerson;
    }

    public String toString(){
        String text ="";
        text += "Nazwisko: " + this.surname+", imię: ";
        for (String n : this.name){
            text += n + ", ";
        }
        return text;
    }

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

    // metoda klasowa
    public static Date getTheOldestBirthDate(){
        Date minDate = new Date();
        for (Person person : extensionPerson){
            if ( person.getBirthDate() != null ) {
                if (person.getBirthDate().compareTo(minDate) < 0) {
                    minDate = person.getBirthDate();
                }
            }
        }
        return minDate;
    }


}
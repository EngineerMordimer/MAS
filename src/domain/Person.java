package domain;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Person implements Serializable {
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
    private static void setExtensionPerson(Vector<Person> extensionPerson) {
        Person.extensionPerson = extensionPerson;
    }

    public static void saveExtension(){
        try {
            FileOutputStream fos = new FileOutputStream("extension.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(extensionPerson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Vector<Person> readFromFile(){
        Vector<Person> personList = new Vector<>();
        try{
            FileInputStream fis = new FileInputStream("extension.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            personList = (Vector<Person>) ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return personList;
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

    public static void saveExtension(ObjectOutputStream oos)throws Exception{
        oos.writeObject(extensionPerson);
    }

    public static void readExtension(ObjectInputStream ois) throws Exception{
        Vector<Person> personList = new Vector<>();
        personList = (Vector<Person>) ois.readObject();
        setExtensionPerson(personList);
    }


    public static Person getTheOldestPerson(){
        Date minDate = new Date();
        Person oldestPerson = null;
        for (Person person : extensionPerson){
            if ( person.getBirthDate() != null ) {
                if (person.getBirthDate().compareTo(minDate) < 0) {
                    minDate = person.getBirthDate();
                    oldestPerson = person;
                }
            }
        }
        return oldestPerson;
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
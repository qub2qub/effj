package effj.ch02.item03.serializable.j5examples;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PersonObscured implements Serializable {

    private void writeObject(ObjectOutputStream stream) throws IOException {
        // "Encrypt"/obscure the sensitive data
        age = age << 2;
        stream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        // "Decrypt"/de-obscure the sensitive data
        age = age >> 2;
    }

    public PersonObscured(String fn, String ln, int a) {
        this.firstName = fn;
        this.lastName = ln;
        this.age = a;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setFirstName(String value) {
        firstName = value;
    }

    public void setLastName(String value) {
        lastName = value;
    }

    public void setAge(int value) {
        age = value;
    }

    public void setSpouse(Person value) {
        spouse = value;
    }

    public String toString() {
        return "[Person: firstName=" + firstName +
                " lastName=" + lastName +
                " age=" + age +
                " spouse=" + (spouse != null ? spouse.getFirstName() : "[null]") +
                "]";
    }

    private String firstName;
    private String lastName;
    private int age;
    private Person spouse;
}

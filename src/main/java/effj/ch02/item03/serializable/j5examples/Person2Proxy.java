package effj.ch02.item03.serializable.j5examples;


import java.io.ObjectStreamException;
import java.io.Serializable;

public class Person2Proxy implements Serializable {

    private String firstName;
    private String lastName;
    private int age;
    private Person2Proxy spouse;

    public Person2Proxy(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new PersonProxy(this);
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

    public Person2Proxy getSpouse() {
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

    public void setSpouse(Person2Proxy value) {
        spouse = value;
    }

    public String toString() {
        return "[Person: firstName=" + firstName +
                " lastName=" + lastName +
                " age=" + age +
                " spouse=" + spouse.getFirstName() +
                "]";
    }


    /**
     * в классе PersonProxy необходимо отслеживать все данные класса Person.
     * Часто это означает, что прокси должен быть внутренним классом класса Person,
     * чтобы иметь доступ к его закрытым полям.
     * Также в прокси иногда нужно отслеживать ссылки на другие объекты
     * и сериализовывать их вручную, например супругу(а) нашего объекта класса Person.
     */
    class PersonProxy implements Serializable {

        public String dataInOneLine;

        public PersonProxy(Person2Proxy orig) {
            dataInOneLine = orig.getFirstName() + "," + orig.getLastName() + "," + orig.getAge();
            if (orig.getSpouse() != null) {
                Person2Proxy spouse = orig.getSpouse();
                dataInOneLine = dataInOneLine + "," + spouse.getFirstName() + "," + spouse.getLastName() + "," + spouse.getAge();
            }
        }

        private Object readResolve() throws ObjectStreamException {
            String[] pieces = dataInOneLine.split(",");
            Person2Proxy result = new Person2Proxy(pieces[0], pieces[1], Integer.parseInt(pieces[2]));
            if (pieces.length > 3) {
                result.setSpouse(new Person2Proxy(pieces[3], pieces[4], Integer.parseInt(pieces[5])));
                result.getSpouse().setSpouse(result);
            }
            return result;
        }
    }

}

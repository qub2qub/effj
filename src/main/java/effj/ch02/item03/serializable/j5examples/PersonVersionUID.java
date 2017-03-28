package effj.ch02.item03.serializable.j5examples;

public class PersonVersionUID implements java.io.Serializable {

    public static final long serialVersionUID = -2673055080994583949L;

    public PersonVersionUID(String fn, String ln, int a) {
        this.firstName = fn;
        this.lastName = ln;
        this.age = a;
    }

    public PersonVersionUID(String fn, String ln, int a, Gender g) {
        this.firstName = fn;
        this.lastName = ln;
        this.age = a;
        this.gender = g;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public PersonVersionUID getSpouse() {
        return spouse;
    }

    public void setFirstName(String value) {
        firstName = value;
    }

    public void setLastName(String value) {
        lastName = value;
    }

    public void setGender(Gender value) {
        gender = value;
    }

    public void setAge(int value) {
        age = value;
    }

    public void setSpouse(PersonVersionUID value) {
        spouse = value;
    }

    public String toString() {
        return "[Person: firstName=" + firstName +
                " lastName=" + lastName +
                " gender=" + gender +
                " age=" + age +
                " spouse=" + spouse.getFirstName() +
                "]";
    }

    private String firstName;
    private String lastName;
    private int age;
    private PersonVersionUID spouse;
    private Gender gender;
}

package effj.ch02.item03.serializable.j5examples;

public class PersonRWObjectMethods implements java.io.Serializable {

    private void readObject(java.io.ObjectInputStream ois)
            throws java.io.IOException, ClassNotFoundException {

        java.io.ObjectInputStream.GetField fields = ois.readFields();
        firstName = (String) fields.get("firstName", "(Nobody)");
        lastName = (String) fields.get("lastName", "(Nobody)");
        age = fields.get("age", 0);
        spouse = (Person) fields.get("spouse", (Person) null);
    }

    private void writeObject(java.io.ObjectOutputStream oos)
            throws java.io.IOException {

        java.io.ObjectOutputStream.PutField fields = oos.putFields();
        fields.put("firstName", firstName);
        fields.put("lastName", lastName);
        fields.put("age", age);
        fields.put("spouse", spouse);
        oos.writeFields();
    }

    public PersonRWObjectMethods(String fn, String ln, int a) {
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
                " spouse=" + spouse.getFirstName() +
                "]";
    }

    private String firstName;
    private String lastName;
    private int age;
    private Person spouse;
}
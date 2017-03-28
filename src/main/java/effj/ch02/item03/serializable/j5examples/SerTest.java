package effj.ch02.item03.serializable.j5examples;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SerTest {

    private static final String fileName = "E:\\Git\\github_qub2qub\\effj\\src\\main\\java\\effj\\ch02\\"
            + "item03\\serializable\\j5examples\\tempdata.ser";

    private static final String fileName2 = "E:\\Git\\github_qub2qub\\effj\\src\\main\\java\\effj\\ch02\\"
            + "item03\\serializable\\j5examples\\proxyPers.ser";

    @Test
    public void serializeToDisk() {
        try {
            Person ted = new Person("Ted", "Neward", 39);
            Person charl = new Person("Charlotte", "Neward", 38);

            ted.setSpouse(charl);
            charl.setSpouse(ted);

            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ted);
            oos.close();
        } catch (Exception ex) {
            fail("Exception thrown during test: " + ex.toString());
        }

        try {

            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Person ted = (Person) ois.readObject();
            ois.close();

            assertEquals(ted.getFirstName(), "Ted");
            assertEquals(ted.getSpouse().getFirstName(), "Charlotte");

            // Clean up the file
//            new File("tempdata.ser").delete();
        } catch (Exception ex) {
            fail("Exception thrown during test: " + ex.toString());
        }
    }


    @Test
    public void proxyPerson() {
        try {
            Person p1 = new Person("Ted11", "Neward11", 39);
            Person p2 = new Person("Charlotte22", "Neward22", 38);

            p1.setSpouse(p2);
            p2.setSpouse(p1);

            FileOutputStream fos = new FileOutputStream(fileName2);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(p1);
            oos.close();
        } catch (Exception ex) {
            fail("Exception thrown during test: " + ex.toString());
        }

        try {

            FileInputStream fis = new FileInputStream(fileName2);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Person ted = (Person) ois.readObject();
            ois.close();

            assertEquals(ted.getFirstName(), "Ted11");
            assertEquals(ted.getSpouse().getFirstName(), "Charlotte22");

            // Clean up the file
//            new File("tempdata.ser").delete();
        } catch (Exception ex) {
            fail("Exception thrown during test: " + ex.toString());
        }
    }
}
package effj.ch02.item03.serializable.j5examples;

import java.io.*;

public class Deserialize {
    public static void main(String[] args) throws Exception {

        FileInputStream fis = new FileInputStream(args[0]);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person ted = (Person) ois.readObject();
        ois.close();

        System.out.println(ted);
    }
}
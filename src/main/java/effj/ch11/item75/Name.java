package effj.ch11.item75;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

// Good candidate for default serialized form
public class Name implements Serializable {

    /**Last name. Must be non-null. @serial*/
    private final String lastName = "";
    /**First name. Must be non-null. @serial*/
    private final String firstName = "";
    /** Middle name, or null if there is none. @serial*/
    private final String middleName = "";

    private void readObject(ObjectInputStream s) throws IOException,
        ClassNotFoundException {
        // ....
    }

    //... // Remainder omitted
}

// Bogus Period attack - Page 303
package effj.ch11.item76;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Date;

public class BogusPeriod {

    // Byte stream could not have come from real Period instance!
    private static final byte[] serializedForm = new byte[]{(byte) 0xac,
        (byte) 0xed, 0x00, 0x05, 0x73, 0x72, 0x00, 0x06, 0x50, 0x65, 0x72,
        0x69, 0x6f, 0x64, 0x40, 0x7e, (byte) 0xf8, 0x2b, 0x4f, 0x46,
        (byte) 0xc0, (byte) 0xf4, 0x02, 0x00, 0x02, 0x4c, 0x00, 0x03, 0x65,
        0x6e, 0x64, 0x74, 0x00, 0x10, 0x4c, 0x6a, 0x61, 0x76, 0x61, 0x2f,
        0x75, 0x74, 0x69, 0x6c, 0x2f, 0x44, 0x61, 0x74, 0x65, 0x3b, 0x4c,
        0x00, 0x05, 0x73, 0x74, 0x61, 0x72, 0x74, 0x71, 0x00, 0x7e, 0x00,
        0x01, 0x78, 0x70, 0x73, 0x72, 0x00, 0x0e, 0x6a, 0x61, 0x76, 0x61,
        0x2e, 0x75, 0x74, 0x69, 0x6c, 0x2e, 0x44, 0x61, 0x74, 0x65, 0x68,
        0x6a, (byte) 0x81, 0x01, 0x4b, 0x59, 0x74, 0x19, 0x03, 0x00, 0x00,
        0x78, 0x70, 0x77, 0x08, 0x00, 0x00, 0x00, 0x66, (byte) 0xdf, 0x6e,
        0x1e, 0x00, 0x78, 0x73, 0x71, 0x00, 0x7e, 0x00, 0x03, 0x77, 0x08,
        0x00, 0x00, 0x00, (byte) 0xd5, 0x17, 0x69, 0x22, 0x00, 0x78};

    private static final byte[] serializedForm2 = {-84, -19, 0, 5, 115, 114, 0, 23, 101, 102, 102,
        106, 46, 99, 104, 49, 49, 46, 105, 116, 101, 109, 55, 54, 46, 80, 101, 114, 105, 111, 100,
        -25, 89, 20, -113, 115, -102, 30, -26, 2, 0, 2, 76, 0, 3, 101, 110, 100, 116, 0, 16, 76,
        106, 97, 118, 97, 47, 117, 116, 105, 108, 47, 68, 97, 116, 101, 59, 76, 0, 5, 115, 116, 97,
        114, 116, 113, 0, 126, 0, 1, 120, 112, 115, 114, 0, 14, 106, 97, 118, 97, 46, 117, 116, 105,
        108, 46, 68, 97, 116, 101, 104, 106, -127, 1, 75, 89, 116, 25, 3, 0, 0, 120, 112, 119, 8, 0,
        0, 1, 96, 24, 10, -113, -21, 120, 115, 113, 0, 126, 0, 3, 119, 8, 0, 0, 1, 96, 24, 10, -105,
        -68, 120};

    public static void main(String[] args) throws IOException, InterruptedException {

        /*ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        Date start = new Date();
        Thread.sleep(2000);
        Date end = new Date();
        out.writeObject(new Period(end, start));
        System.out.println(Arrays.toString(bos.toByteArray()));
        System.out.println("================================");*/

        Period p = (Period) deserialize(serializedForm2);
        System.out.println(p);
    }

    // Returns the object with the specified serialized form
    private static Object deserialize(byte[] sf) {
        try {
            InputStream is = new ByteArrayInputStream(sf);
            ObjectInputStream ois = new ObjectInputStream(is);
            return ois.readObject();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}

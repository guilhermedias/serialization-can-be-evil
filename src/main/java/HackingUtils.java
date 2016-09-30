import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class HackingUtils {
    public static final byte[] EVIL_HACKER_BYTE_ARRAY = {
            -84,  -19,    0,    5,  115,  114,    0,    6,   80,
            101,  114,  105,  111,  100,   95,  -43,  -31,   93,
           -104, -114,  -51,   13,    2,    0,    2,   76,    0,
              3,  101,  110,  100,  116,    0,   16,   76,  106,
             97,  118,   97,   47,  117,  116,  105,  108,   47,
             68,   97,  116,  101,   59,   76,    0,    5,  115,
            116,   97,  114,  116,  113,    0,  126,    0,    1,
            120,  112,  115,  114,    0,   14,  106,   97,  118,
             97,   46,  117,  116,  105,  108,   46,   68,   97,
            116,  101,  104,  106, -127,    1,   75,   89,  116,
             25,    3,    0,    0,  120,  112,  119,    8,    0,
              0,    0,  -94, -117,   92, -117, -128,  120,  115,
            113,    0,  126,    0,    3,  119,    8,    0,    0,
              0,  -94,  -91,   28,   87, -128,  120
    };

    public static String evilHackerMethod(Period period) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

        objectOutputStream.writeObject(period);
        objectOutputStream.close();

        StringBuilder builder = new StringBuilder();
        int counter = 0;
        for(byte b : byteArrayOutputStream.toByteArray()) {
            if(counter % 9 == 0) {
                builder.append('\n');
            }

            builder.append(String.format("%4d", b));
            builder.append(", ");

            counter++;
        }

        return builder.toString();
    }
}

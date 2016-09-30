import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class SerialKiller {
    public static void main(String[] args) throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(HackingUtils.EVIL_HACKER_BYTE_ARRAY);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Period period = (Period) objectInputStream.readObject();
        System.out.println(period);
    }
}

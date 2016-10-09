import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

import static java.lang.String.format;

public class Period implements Serializable {
    private Date start;
    private Date end;

    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if(this.start.after(this.end)) {
            throw new IllegalArgumentException("Start date is past end date");
        }
    }

    public Date getStart() {
        return new Date(start.getTime());
    }

    public Date getEnd() {
        return new Date(end.getTime());
    }

    @Override
    public String toString() {
        return format("FROM [%s] TO [%s]", start, end);
    }

    private void readObject(ObjectInputStream objectInputStream)
        throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();

        if(this.start.after(this.end)) {
            throw new InvalidObjectException("Start date is past end date");
        }
    }
}

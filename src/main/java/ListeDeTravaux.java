import com.google.gson.annotations.Expose;
import java.util.ArrayList;

public class ListeDeTravaux {

    @Expose ArrayList<Travail> records;

    public ArrayList<Travail> getRecords() {
        return records;
    }

    @Override
    public String toString() {
        return "result{" +
                "records=" + records +
                '}';
    }
}

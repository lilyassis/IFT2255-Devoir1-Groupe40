import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class ListeDeEntraves {
    @Expose
    ArrayList<Entrave> records;

    public ArrayList<Entrave> getRecords() {
        return records;
    }
}

import com.google.gson.annotations.Expose;

public class Travaux {
    @Expose private ListeDeTravaux result;

    public ListeDeTravaux getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Travaux{" +
                "result=" + result +
                '}';
    }
}



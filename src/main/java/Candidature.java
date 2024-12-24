import org.jetbrains.annotations.Nullable;

public class Candidature {
    private String requete;

    public Candidature(String requete) {
        this.requete = requete;
    }

    public String getRequete() {
        return requete;
    }

    @Override
    public String toString() {
        return "Candidature{" +
                "requete='" + requete + '\'' +
                '}';
    }
}

import org.jetbrains.annotations.Nullable;

public class Candidature {
    transient private Requete requete;

    public Candidature(Requete requete) {
        this.requete = requete;
    }

    public Requete getRequete() {
        return requete;
    }

    @Override
    public String toString() {
        return "Candidature{" +
                "requete=" + requete.getTitreDuTravail() +
                '}';
    }
}

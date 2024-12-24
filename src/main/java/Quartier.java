import java.util.List;

public class Quartier {
    private String nom;
    private String codePostal;
    private List<Resident> residentsDansLeQuartier;

    public Quartier(String nom, String codePostal) {
        this.nom = nom;
        this.codePostal = codePostal;
    }

    @Override
    public String toString() {
        return "Quartier{" +
                "nom='" + nom + '\'' +
                '}';
    }
}

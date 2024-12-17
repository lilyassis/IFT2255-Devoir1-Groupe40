import java.util.List;

public class Quartier {
    private String nom;
    private String codePostal;
    private List<Resident> residentsDansLeQuartier;

    public Quartier(String nom, String codePostal) {
        this.nom = nom;
        this.codePostal = codePostal;
    }

    // Méthodes
    public String afficherDetails() {
        return "Quartier: " + nom + ", Code Postal: " + codePostal;
    }

    public List<Projet> afficherProjets() {
        // Retourner les projets associés au quartier
        return null; // À implémenter selon le besoin
    }
}

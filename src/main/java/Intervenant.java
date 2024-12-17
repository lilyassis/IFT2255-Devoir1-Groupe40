import java.util.List;

public class Intervenant extends User{
    IntervenantType type;
    int Identifiant;
    List<Projet> projets;
    List<Candidature> candidatures;

    public int getIdentifiant() {
        return Identifiant;
    }

    public void setIdentifiant(int identifiant) {
        Identifiant = identifiant;
    }

    public Intervenant(String Nom, String AdresseCourriel, String MotDePasse, IntervenantType Type, int Identifiant){
        this.nom = Nom;
        this.courriel = AdresseCourriel;
        this.password = MotDePasse;
        this.type = Type;
        this.Identifiant = Identifiant;
    }

    public void setProjet(Projet projet) {
        this.projets.add(projet);
    }

    public List<Candidature> getCandidatures() {
        return candidatures;
    }
}

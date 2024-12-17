import java.util.Date;
import java.util.List;

public class Projet {
    private String titre;
    private String description;
    private TypeTravaux typeTravaux;
    private StatutProjet statutProjet;
    private Date dateDebut;
    private Date dateFin;
    private Quartier quartierAffectés;

    public Projet(String titre, String description, TypeTravaux typeTravaux, Date dateDebut, Date dateFin, Quartier quartierAffectés) {
        this.titre = titre;
        this.description = description;
        this.typeTravaux = typeTravaux;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.quartierAffectés = quartierAffectés;
        this.statutProjet = StatutProjet.Prévu;
    }

    public String getTitre() {
        return titre;
    }

    @Override
    public String toString() {
        return "Projet{" +
                "titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", typeTravaux=" + typeTravaux +
                ", statutProjet=" + statutProjet +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", quartiersAffectés=" + quartierAffectés +
                '}';
    }

    public void changerStatut(StatutProjet statut) {
        this.statutProjet = statut;
        System.out.println("Statut a ete change");
    }
}


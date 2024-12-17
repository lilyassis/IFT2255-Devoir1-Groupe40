import org.jetbrains.annotations.Nullable;

public class Requete {
    private Resident proprietaire;
    private String TitreDuTravail, Description, DateDeDébut;
    private WorkType TypeDeTravaux;
    private Boolean Open;
    @Nullable
    private Candidature candidature;


    public Requete(Resident proprietaire, String titreDuTravail, String description, String dateDeDébut, WorkType typeDeTravaux, Boolean open) {
        this.proprietaire = proprietaire;
        TitreDuTravail = titreDuTravail;
        Description = description;
        DateDeDébut = dateDeDébut;
        TypeDeTravaux = typeDeTravaux;
        Open = open;
    }

    public String getTitreDuTravail() {
        return TitreDuTravail;
    }

    public void setCandidature(@Nullable Candidature candidature) {
        this.candidature = candidature;
    }

    public Resident getProprietaire() {
        return proprietaire;
    }

    @Override
    public String toString() {
        return "Requete{" +
                "TitreDuTravail='" + TitreDuTravail + '\'' +
                ", Description='" + Description + '\'' +
                ", DateDeDébut='" + DateDeDébut + '\'' +
                ", TypeDeTravaux=" + TypeDeTravaux +
                ", Open=" + Open +
                '}';
    }
}

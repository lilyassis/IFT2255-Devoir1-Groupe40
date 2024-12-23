import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Requete {
    private String proprietaire;
    private String TitreDuTravail, Description, DateDeDébut;
    private WorkType TypeDeTravaux;
    private Boolean Open;
    @Nullable
    transient private List<Candidature> candidatures;


    public Requete(String proprietaire, String titreDuTravail, String description, String dateDeDébut, WorkType typeDeTravaux, Boolean open) {
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

    public void addCandidature(@Nullable Candidature candidature) {
        List<Candidature> candidatures = new ArrayList<>();
        candidatures.add(candidature);
        this.candidatures = candidatures;
    }

    public void removeCandicature(Candidature candidature){
        this.candidatures.remove(candidature);
    }

    public List<Candidature> getCandidature() {
        return candidatures;
    }

    @Override
    public String toString() {
        return "Requete{" +
                " proprietaire=" + proprietaire +
                ", TitreDuTravail='" + TitreDuTravail + '\'' +
                ", Description='" + Description + '\'' +
                ", DateDeDébut='" + DateDeDébut + '\'' +
                ", TypeDeTravaux=" + TypeDeTravaux +
                ", Open=" + Open +
                ", candidature=" + candidatures +
                '}';
    }
}

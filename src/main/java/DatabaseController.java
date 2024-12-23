import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DatabaseController {
    @Nullable
    List<Resident> residents;
    @Nullable
    List<Intervenant> intervenants;
    @Nullable
    List<Projet> projets;
    @Nullable
    List<Requete> requetes;
    @Nullable
    transient List<Travail> travaux;
    @Nullable
    transient List<Entrave> entraves;

    public DatabaseController(@Nullable List<Resident> residents, @Nullable List<Intervenant> intervenants,@Nullable List<Projet> projets, @Nullable List<Requete> requetes, @Nullable List<Travail> travaux, @Nullable List<Entrave> entraves) {
        this.residents = residents;
        this.intervenants = intervenants;
        this.projets = projets;
        this.requetes = requetes;
        this.travaux = travaux;
        this.entraves = entraves;
    }

    public void consulterProjets() {
        assert projets != null;
        if (projets.isEmpty()){
            System.out.print("Pas de travaux à venir \n");
        }else{
        for(int i = 0; i < projets.size(); i++) {
            System.out.print(projets.get(i));
        }
        }
    }

    public void consulterTravaux(){
        for(int i = 0; i < travaux.size(); i++) {
            System.out.print(travaux.get(i));
        }
    }
    public void consulterEntraves(){
        for(int i = 0; i < entraves.size(); i++) {
            System.out.print(entraves.get(i));
        }
    }

    public void consulterTravailParQuartier(String quartier){
        Travail travail = null;
        for(int i = 0; i < travaux.size(); i++) {
            travail = travaux.get(i);
            if(travail.getBoroughid().trim().toLowerCase().equals(quartier)){
                System.out.println(travail);
            } else if (i == travaux.size() - 1){
                System.out.println("nom de quartier pas trouve ou mal ecrite");
            }
        }
    }

    public void ConsulterEntraveParRue(String rue) {
        Entrave entrave = null;
        for (int i = 0; i < entraves.size(); i++) {
            entrave = entraves.get(i);
            if (entrave.getShortname().trim().toLowerCase().equals(rue)) {
                System.out.println(entrave);
            }
            else if (i == entraves.size() - 1){
                System.out.println("nom de rue pas trouve ou mal ecrite");
            }
        }

    }

    @Override
    public String toString() {
        return "DatabaseController{" +
                "residents=" + residents +
                ", intervenants=" + intervenants +
                ", projets=" + projets +
                ", requetes=" + requetes +
                ", travaux=" + travaux +
                ", entraves=" + entraves +
                '}';
    }
}

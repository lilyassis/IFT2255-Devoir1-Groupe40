import java.util.List;

public class DatabaseController {
    List<Object> users;
    List<Projet> projets;
    List<Requete> requetes;
    List<Travail> travaux;
    List<Entrave> entraves;

    public DatabaseController(List<Object> users, List<Projet> projets, List<Requete> requetes, List<Travail> travaux, List<Entrave> entraves) {
        this.users = users;
        this.projets = projets;
        this.requetes = requetes;
        this.travaux = travaux;
        this.entraves = entraves;
    }

    public void consulterProjets() {
        for(int i = 0; i < projets.size(); i++) {
            System.out.print(projets.get(i));
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
        }

    }

    }

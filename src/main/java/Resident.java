import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Resident extends User {
    private Date dateNaissance;
    @Nullable
    private Requete Requete;
    private String adresseRésidentielle;
    @Nullable
    private List<Notification> notifications;
    private List<Horaire> horaires;

    public Resident(String Nom, String AdresseCourriel, String MotDePasse, Date DateNaissance,String adresse){
        this.nom = Nom;
        this.courriel = AdresseCourriel;
        this.password = MotDePasse;
        this.dateNaissance = DateNaissance;
        this.adresseRésidentielle = adresse;
        this.Requete = null;
        initialiserHoraires();
    }

    private void initialiserHoraires() {
        List<Horaire> horaires = new ArrayList<Horaire>();
        for (JourDeLaSemaine jour : JourDeLaSemaine.values()) {
            Horaire horaire = new Horaire(jour);
            horaires.add(horaire);
        }
    }

    public void setRequete(Requete requete) {
        Requete = requete;
        System.out.println("Votre requête de travail a été soumise");
    }

    public @Nullable Requete getRequete() {
        return Requete;
    }

    public void consulterNotifications(){
        List<Notification> notifications = new ArrayList<Notification>();
        if (!notifications.isEmpty()){
            for(int i = 0; i < notifications.size(); i++) {
                Notification notification = notifications.get(i);
                if(!notification.read){
                    System.out.println(notification);
                    notification.setRead(true);
                }
            }
        }else {
            System.out.println("Pas de notifications non vue");
        }
    }

    public void ajouterNotification(String id,String message){
        Notification notification = new Notification(id,message);
        notifications.add(notification);
    }

    public void modifierHoraire(JourDeLaSemaine jour, String nouvelleHeureDebut, String nouvelleHeureFin) {
        for (Horaire horaire : horaires) {
            if (horaire.getJourDeLaSemaine() == jour) {
                horaire.modifierHoraire(nouvelleHeureDebut, nouvelleHeureFin);
                System.out.println("Horaire modifié pour " + jour + " : de " + nouvelleHeureDebut + " à " + nouvelleHeureFin);
                return;
            }
        }
        System.out.println("Jour non trouvé dans la liste des horaires.");
    }

    public List<Horaire> getHoraires() {
        return horaires;
    }
}

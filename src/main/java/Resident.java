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

    public void initialiserHoraires() {
        List<Horaire> horaires = new ArrayList<Horaire>();
        for (JourDeLaSemaine jour : JourDeLaSemaine.values()) {
            Horaire horaire = new Horaire(jour);
            horaires.add(horaire);
            this.horaires = horaires;
        }
    }

    public void setRequete(@Nullable Requete requete) {
        this.Requete = requete;
        System.out.println("Votre requête de travail a été soumise");
    }

    public @Nullable Requete getRequete() {
        return this.Requete;
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

    public void modifierHoraire(String jour, String nouvelleHeureDebut, String nouvelleHeureFin) {
        JourDeLaSemaine journee = null;
        try {
            journee = JourDeLaSemaine.valueOf(jour.toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            System.out.println("Jour non trouvé dans la liste des horaires: " + jour);
        }
        for (Horaire horaire : horaires) {
            if (horaire.getJourDeLaSemaine() == journee) {
                horaire.modifierHoraire(nouvelleHeureDebut, nouvelleHeureFin);
                System.out.println("Horaire modifié pour " + jour + " : de " + nouvelleHeureDebut + " à " + nouvelleHeureFin);
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Resident{" +
                "dateNaissance=" + dateNaissance +
                ", Requete=" + Requete +
                ", adresseRésidentielle='" + adresseRésidentielle + '\'' +
                ", notifications=" + notifications +
                ", horaires=" + horaires +
                '}';
    }

    public List<Horaire> getHoraires() {
        return horaires;
    }
}

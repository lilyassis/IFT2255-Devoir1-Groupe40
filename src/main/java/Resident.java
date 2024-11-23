import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Resident {
    String Nom;
    String AdresseCourriel;
    String MotDePasse;
    String DateDeNaissance;
    String Telephone;
    String AdresseResidentiel;
    @Nullable
    Requete Requete;

    public Resident(String Nom,String DateDeNaissance,String AdresseCourriel,String MotDePasse,String Telephone,String AdresseResidentiel){
        this.Nom = Nom;
        this.DateDeNaissance = DateDeNaissance;
        this.AdresseCourriel = AdresseCourriel;
        this.MotDePasse = MotDePasse;
        this.Telephone = Telephone;
        this.AdresseResidentiel = AdresseResidentiel;
    }

    public void Menu(){
        System.out.println(" Consulter les travaux en cours ou à venir [1]"
                +"\n Consulter les entraves routières causées par les travaux en cours [2]"
                +"\n Rechercher des travaux [3]"
                +"\n Recevoir des notifications personnalisées [4]"
                +"\n Permettre une planification participative [5]"
                +"\n Soumettre ou suivre une requête de travail résidentiel [6]"
                +"\n Déconnexion [7]");
    }

    public void ConsulterTravaux(String choix){
        if (choix.equals("1")) {
            System.out.println("Voici liste des projets par quartier:"
                    +"\n *Example*"
                    +"\n ---------------------------"
                    +"\n ---------------------------"
                    +"\n ---------------------------");
        }
        else if (choix.equals("2")) {
            System.out.println("Voici liste des projets par type de travaux:"
                    +"\n *Example*"
                    +"\n ---------------------------"
                    +"\n ---------------------------"
                    +"\n ---------------------------");
        }
        else if (choix.equals("3")) {
            System.out.println("Voici liste des projets par rue:"
                    +"\n *Example*"
                    +"\n ---------------------------"
                    +"\n ---------------------------"
                    +"\n ---------------------------");
        }
        else if (choix.equals("4")) {
            System.out.println("Retour au menu");
        }else {
            System.out.println("Mauvaise commande!!!");
        }
    }

    public Entrave ConsulterEntraveParID(List<Entrave> liste,String id){
        Entrave entrave = null;
        for(int i = 0; i < liste.size(); i++) {
            entrave = liste.get(i);
            if(entrave.getId_request().equals(id)){
               return entrave;
            }
        }
        return entrave;
    }

    public Entrave ConsulterEntraveParRue(List<Entrave> liste,String rue){
        Entrave entrave = null;
        for(int i = 0; i < liste.size(); i++) {
            entrave = liste.get(i);
            if(entrave.getShortname().trim().equals(rue)){
                return entrave;
            }
        }
        return entrave;
    }

    public String RechercheTravaux(String choix){
        if (choix.equals("1")) {
            return "Voici liste des travaux par titre:"
                    +"\n *Example*"
                    +"\n ---------------------------"
                    +"\n ---------------------------"
                    +"\n ---------------------------";
        }
        else if (choix.equals("2")) {
           return "Voici liste des travaux par type de travaux:"
                    +"\n *Example*"
                    +"\n ---------------------------"
                    +"\n ---------------------------"
                    +"\n ---------------------------";
        }
        else if (choix.equals("3")) {
            return "Voici liste des travaux par quartier:"
                    +"\n *Example*"
                    +"\n ---------------------------"
                    +"\n ---------------------------"
                    +"\n ---------------------------";

        }
        else if (choix.equals("4")) {
            return "Retour au menu";
        }else {
            return "Mauvaise commande!!!";
        }
    }

    public String RecevoirNotifications(String choix){
        if (choix.equals("1")) {
            return "*Example*"
                    +"\n Vous êtes maintenant abonnés!"
                    +"\n ---------------------------";
        }
        else if (choix.equals("2")) {
            return "*Example*"
                    +"\n Vous êtes maintenant abonnés!"
                    +"\n ---------------------------";
        }
        else if (choix.equals("3")) {
            return "Retour au menu";
        }else {
            return "Mauvaise commande!!!";
        }
    }

    public String Planification(String choix){
        if (choix.equals("1")) {
            return "*Example*"
                    +"\n Veuillez indiquer les plages horaires préférables:"
                    +"\n ---------------------------";
        }
        else if (choix.equals("2")) {
            return "*Example*"
                    +"\n Voici les préférences des autres résidents de mon quartier:"
                    +"\n ---------------------------";
        }
        else if (choix.equals("3")) {
            return "*Example*"
                    +"\n Quel est votre avis sur les travaux et l'intervenant:"
                    +"\n ---------------------------";
        }
        else if (choix.equals("4")) {
            return "Retour au menu";
        }else {
            return "Mauvaise commande!!!";
        }
    }

    public void setRequete(Requete requete) {
        Requete = requete;
    }

    public @Nullable Requete getRequete() {
        return Requete;
    }

    /*public void Requete(String choix){
        if (choix.equals("1")) {
            System.out.println("*Example*"
                    +"\n Quelle est votre requête de travail?"
                    +"\n ---------------------------");

        }
        else if (choix.equals("2")) {
            System.out.println("*Example*"
                    +"\n Voici le suivi de votre requête de travail:"
                    +"\n ---------------------------");
        }
        else if (choix.equals("3")) {
            System.out.println("Retour au menu");
        }else {
            System.out.println("Mauvaise commande!!!");
        }
    }*/  //utiser devoir 3

    public List<Object> Ajouter(List<Object> Liste){
        Liste.add(this);
        return Liste;
    }
    public List<Object> Enlever(List<Object> Liste){
        Liste.remove(this);
        return Liste;
    }
}

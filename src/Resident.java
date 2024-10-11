public class Resident {
    String Nom;
    String AdresseCourriel;
    String MotDePasse;
    String DateDeNaissance;
    String Telephone;
    String AdresseResidentiel;

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
                            +"\n Rechercher des travaux [2]"
                            +"\n Recevoir des notifications personnalisées [3]"
                            +"\n Permettre une planification participative [4]"
                            +"\n Soumettre une requête de travail [5]"
                            +"\n Signaler un problème à la ville [6]"
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

    public void RechercheTravaux(String choix){
        if (choix.equals("1")) {
            System.out.println("Voici liste des travaux par titre:"
            +"\n *Example*"
            +"\n ---------------------------"
            +"\n ---------------------------"
            +"\n ---------------------------");       
        }
        else if (choix.equals("2")) {
            System.out.println("Voici liste des travaux par type de travaux:"
            +"\n *Example*"
            +"\n ---------------------------"
            +"\n ---------------------------"
            +"\n ---------------------------");
        }
        else if (choix.equals("3")) {
            System.out.println("Voici liste des travaux par quartier:"
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

    public void RecevoirNotifications(String choix){
        if (choix.equals("1")) {
            System.out.println("*Example*"
            +"\n Vous êtes maintenant abonnés!"
            +"\n ---------------------------");      
        }
        else if (choix.equals("2")) {
            System.out.println("*Example*"
            +"\n Vous êtes maintenant abonnés!"
            +"\n ---------------------------"); 
        }
        else if (choix.equals("3")) {
            System.out.println("Retour au menu"); 
        }else {
            System.out.println("Mauvaise commande!!!");
        }    
    }

    public void Planification(String choix){
        if (choix.equals("1")) {
            System.out.println("*Example*"
            +"\n Veuillez indiquer les plages horaires préférables:"
            +"\n ---------------------------"); 
        }
        else if (choix.equals("2")) {
            System.out.println("*Example*"
            +"\n Voici les préférences des autres résidents de mon quartier:"
            +"\n ---------------------------");
        }
        else if (choix.equals("3")) {
            System.out.println("*Example*"
            +"\n Quel est votre avis sur les travaux et l'intervenant:"
            +"\n ---------------------------");
        }
        else if (choix.equals("4")) {
            System.out.println("Retour au menu"); 
        }else {
            System.out.println("Mauvaise commande!!!");
        }    
    }

    public void Requete(String choix){
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
    }

    public void Signaler(String choix){
        if (choix.equals("1")) {
            System.out.println("*Example*"
            +"\n Quel est le problème?"
            +"\n ---------------------------");      
        }
        else if (choix.equals("2")) {
            System.out.println("Retour au menu"); 
        }else {
            System.out.println("Mauvaise commande!!!");
        }    
    }
}


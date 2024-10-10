public class Intervenant {
    String Nom;
    String AdresseCourriel;
    String MotDePasse;
    String Type;
    int Identifiant;

    public Intervenant(String Nom,String AdresseCourriel,String MotDePasse,String Type,int Identifiant){
        this.Nom = Nom;
        this.AdresseCourriel = AdresseCourriel;
        this.MotDePasse = MotDePasse;
        this.Type = Type;
        this.Identifiant = Identifiant;
    }

    public void Menu(){
        System.out.println("Consulter la liste des requêtes de travail [1]"
                            +"\n Soumettre un nouveau projet de travaux [2]"
                            +"\n Mettre à jour les informations d'un chantier [3]"
                            +"\n Déconnexion [4]");
    }

    public void Requetes(String choix){
        if (choix.equals("1")) {
            System.out.println("Voici la liste des requêtes de travail par type:"
            +"\n *Example*"
            +"\n ---------------------------"
            +"\n ---------------------------"
            +"\n ---------------------------");
                 
        }
        else if (choix.equals("2")) {
            System.out.println("Voici la liste des requêtes de travail par quartier:"
            +"\n *Example*"
            +"\n ---------------------------"
            +"\n ---------------------------"
            +"\n ---------------------------");
        }
        else if (choix.equals("3")) {
            System.out.println("Voici la liste des requêtes de travail par date de début:"
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

    public void Soumission(String choix){
        if (choix.equals("1")) {
            System.out.println("Quel est votre nouveau projet?"
            +"\n *Example*"
            +"\n ---------------------------");       
        }
        else if (choix.equals("2")) {
            System.out.println("Voici les préférences des résidents:"
            +"\n *Example*"
            +"\n ---------------------------"
            +"\n ---------------------------"
            +"\n ---------------------------");
        }
        else if (choix.equals("3")) {
            System.out.println("Retour au menu"); 
        }else {
            System.out.println("Mauvaise commande!!!");
        } 
    }

    public void MaJ(String choix){
        if (choix.equals("1")) {
            System.out.println("*Example*"
            +"\n Mise à jour de la description du projet a été faite"
            +"\n ---------------------------");      
        }
        else if (choix.equals("2")) {
            System.out.println("*Example*"
            +"\n Mise à jour de la date de fin prévue a été faite"
            +"\n ---------------------------"); 
        }
        else if (choix.equals("3")) {
            System.out.println("*Example*"
            +"\n Le changement au statut du projet a été fait"
            +"\n ---------------------------");
        }
        else if (choix.equals("4")) {
            System.out.println("Retour au menu"); 
        }else {
            System.out.println("Mauvaise commande!!!");
        } 
    }
}

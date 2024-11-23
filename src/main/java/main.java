import com.google.gson.Gson;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        HttpClientApi api = new HttpClientApi();

        String resourceIdTravaux = "cc41b532-f12d-40fb-9f55-eb58c9a2b12b";
        String resourceIdEntraves = "a2bc8014-488c-495d-941b-e7ae1999d1bd";
        ApiResponse ResponseTravaux = api.getData(resourceIdTravaux);
        ApiResponse ResponseEntraves = api.getData(resourceIdEntraves);
        Gson gson = new Gson();

        List<Requete> Requetes = new ArrayList<Requete>(); // Liste de Requetes
        // 3 requetes
        Requete requete1 = new Requete("Construction d'un immeuble résidentiel de 8 étages","Cette construction est un immeuble résidentiel de 8 étages situé dans un quartier central d'une grande ville. Il comprend des appartements modernes allant de 40 à 90 m², avec des commerces (boulangerie, pharmacie, café) au rez-de-chaussée.","Construction","2022-03-04",true);
        Requete requete2 = new Requete("Construction d'un centre commercial de trois niveaux","Il s'agit d'un centre commercial moderne de trois niveaux, situé en périphérie d'une ville en expansion. Le bâtiment offre une large gamme de commerces, de restaurants, de cinémas et d'espaces de loisirs","Construction","2023-07-12",true);
        Requete requete3 = new Requete("Rénovation d'un entrepôt en espace mixte","transformation d’un ancien bâtiment industriel en un espace polyvalent comprenant des bureaux, des appartements et des commerces","Rénovation","2023-01-23",false);
        Requetes.add(requete1);
        Requetes.add(requete2);
        Requetes.add(requete3);

        List<Object> Users = new ArrayList<>(); // Liste de usagers
        // 3 Residents
        Resident Bob = new Resident("bob", "2002/23/01", "bob@gmail.com", "123", "514-123-4567", "2900 Edouard Montpetit Blvd");
        Resident Sophie = new Resident("Sophie", "2003/12/4", "sophie@gmail.com", "123", "514-123-4567", "2900 Edouard Montpetit Blvd");
        Resident Emma = new Resident("Emma", "2001/04/07", "emma@gmail.com", "123", "514-123-4567", "2900 Edouard Montpetit Blvd");
        // 3 Intervenants
        Intervenant Alice = new Intervenant("alice", "alice@gmail.com", "123","public", 001);
        Intervenant Angie = new Intervenant("angie", "angie@gmail.com", "123","public", 002);
        Intervenant Alex = new Intervenant("alex", "alex@gmail.com", "123","public", 003);
        // creation des usagers
        Bob.Ajouter(Users);
        Sophie.Ajouter(Users);
        Emma.Ajouter(Users);
        Alice.Ajouter(Users);
        Angie.Ajouter(Users);
        Alex.Ajouter(Users);

        String Input;
        String Adresse;
        String MotDePasse;

        Scanner scanner = new Scanner(System.in);
        application:  // boucle en charge de tout le processus tant que l'application est en marche
        while (true) {
            System.out.println("Entrez [1] pour connexion [2] pour inscription ou [3] pour quitter");
            Input = scanner.nextLine().trim();
            if ("1".equals(Input)) {

                System.out.println("Entrez votre adresse courriel:");
                Adresse = scanner.nextLine().trim().toLowerCase();
                System.out.println("Entrez votre mot de passe:");
                MotDePasse = scanner.nextLine().trim();

                for(Object Utilisateur: Users){  // boucle qui itere sur tout les utilisateurs sur la base de donnes

                    if (Utilisateur.getClass() == Resident.class) {
                        Resident resident = (Resident) Utilisateur;  // creation temporaire d'un objet resident afin de pouvoir l'authentifier
                        if (resident.AdresseCourriel.equals(Adresse)) {
                            if (MotDePasse.equals(resident.MotDePasse)) {

                                while (true) {
                                    System.out.println("Entrez le numero de votre choix:");
                                    resident.Menu();  // afiche le menu
                                    Input = scanner.nextLine().trim();

                                    if ("1".equals(Input)) {
                                        /*System.out.println(" Consulter liste des projets par quartier [1]"
                                                            +"\n Consulter liste des projets par type de travaux [2]"
                                                            +"\n Consulter liste des projets par rue [3]"
                                                            +"\n Retour au menu [4]");
                                        Input = scanner.nextLine().trim();
                                        resident.ConsulterTravaux(Input);  // appel a la fontion*/    // plus tard
                                        Travaux travaux = gson.fromJson(ResponseTravaux.getBody(),Travaux.class);
                                        ArrayList<Travail> ListeDeTravaux = travaux.getResult().getRecords();
                                        for(int i = 0; i < ListeDeTravaux.size(); i++) {
                                            System.out.print(ListeDeTravaux.get(i));
                                        }

                                    }else if ("2".equals(Input)) {
                                        Entraves entraves = gson.fromJson(ResponseEntraves.getBody(),Entraves.class);
                                        ArrayList<Entrave> ListeDeEntraves = entraves.getResult().getRecords();
                                        System.out.println(" Consulter liste de entraves [1]"
                                                +"\n Consulter liste de entraves par un travail en particulier [2]"
                                                +"\n Consulter liste de entraves par rue [3]"
                                                +"\n Retour au menu [4]");
                                        Input = scanner.nextLine().trim();
                                        if (Input.equals("1")){
                                            for(int i = 0; i < ListeDeEntraves.size(); i++) {
                                                System.out.print(ListeDeEntraves.get(i));
                                            }
                                        } else if (Input.equals("2")){
                                            System.out.println("id du travail en particulier?");
                                            System.out.println(resident.ConsulterEntraveParID(ListeDeEntraves,scanner.nextLine().trim()));
                                        } else if (Input.equals("3")){
                                            System.out.println("Rue du travail en particulier?");
                                            System.out.println(resident.ConsulterEntraveParRue(ListeDeEntraves,scanner.nextLine().trim()));
                                        } else if (Input.equals("4")) {
                                            System.out.println("Retour au menu");
                                        } else {
                                            System.out.println("Mauvaise commande!!!");
                                        }
                                    }else if ("3".equals(Input)) {
                                        System.out.println(" Consulter liste des travaux par titre [1]"
                                                +"\n Consulter liste des travaux par type de travaux [2]"
                                                +"\n Consulter liste des travaux par quartier [3]"
                                                +"\n Retour au menu [4]");
                                        Input = scanner.nextLine().trim();
                                        System.out.println(resident.RechercheTravaux(Input)); // appel a la fontion

                                    }else if ("4".equals(Input)) {
                                        System.out.println(" S'abonner aux notifications pour des projets affectant une rue [1]"
                                                +"\n S'abonner aux notifications pour des projets affectant un quartier donné [2]"
                                                +"\n Retour au menu [3]");
                                        Input = scanner.nextLine().trim();
                                        System.out.println(resident.RecevoirNotifications(Input));    // appel a la fontion

                                    }else if ("5".equals(Input)) {
                                        System.out.println(" Fournir mes plages horaires préférables dans mon quartier [1]"
                                                +"\n Consulter les préférences des autres résidents de mon quartier [2]"
                                                +"\n Partager mon avis sur les travaux et l'intervenant. [3]"
                                                +"\n Retour au menu [4]");
                                        Input = scanner.nextLine().trim();
                                        System.out.println(resident.Planification(Input)); // appel a la fontion

                                    }else if ("6".equals(Input)) {
                                        System.out.println(" Soumettre une requête de travail [1]"
                                                +"\n Faire le suivi de ma requête [2]"
                                                +"\n Retour au menu [3]");
                                        Input = scanner.nextLine().trim();
                                        if(Input.equals("1")){
                                            String[] reponses = new String[4];
                                            System.out.println("Titre du travail a réaliser? ");
                                            reponses[0] = scanner.nextLine().trim();
                                            System.out.println("Veuillez fournir une description détaillée");
                                            reponses[1] = scanner.nextLine().trim();
                                            System.out.println("Veuillez fournir le type de travaux");
                                            reponses[2] = scanner.nextLine().trim();
                                            System.out.println("Veuillez fournir la date de début espéré");
                                            reponses[3] = scanner.nextLine().trim();
                                            Requete requete = new Requete(reponses[0],reponses[1],reponses[2],reponses[3],true);
                                            Requetes.add(requete);
                                            resident.setRequete(requete);
                                            System.out.println("Votre requête de travail a été soumise");
                                        }else if(Input.equals("2")){
                                            if(resident.getRequete()!= null){
                                                System.out.println(Requetes.get(Requetes.size()-1));
                                            } else {
                                                System.out.println("Pas de requête en cours");
                                            }
                                        }

                                    }else if ("7".equals(Input)) {
                                        break application;  // Déconnexion de l'application

                                    }else {
                                        System.out.println("Mauvais Input!!");
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                    }

                    else if (Utilisateur.getClass() == Intervenant.class) {
                        Intervenant Intervenant = (Intervenant) Utilisateur; //creation temporaire d'un objet Intervenant afin de pouvoir l'authentifier
                        if (Intervenant.AdresseCourriel.equals(Adresse)) {
                            if (MotDePasse.equals(Intervenant.MotDePasse)) {

                                while (true) {
                                    System.out.println("Entrez le numero de votre choix:");
                                    Intervenant.Menu();
                                    Input = scanner.nextLine().trim();

                                    if ("1".equals(Input)) {
                                        System.out.println(" Consulter la liste des requêtes de travail par type [1]"
                                                +"\n Consulter la liste des requêtes de travail par quartier [2]"
                                                +"\n Consulter la liste des requêtes de travail par date de début [3]"
                                                +"\n Retour au menu [4]");
                                        Input = scanner.nextLine().trim();
                                        if (Input.equals("1")){
                                            for(int i = 0; i < Requetes.size(); i++) {
                                                System.out.print("Requete " + (i+1) + ":\n" );
                                                System.out.print(Requetes.get(i));
                                            }
                                        } else if (Input.equals("2") || Input.equals("3")){
                                            System.out.println("Cette commande n'est pas encore disponible");
                                        } else if (Input.equals("4")) {
                                            System.out.println("Retour au menu");
                                        } else {
                                            System.out.println("Mauvaise commande!!!");
                                        }
                                    }else if ("2".equals(Input)) {
                                        System.out.println(" Soumettre un nouveau projet de travaux [1]"
                                                +"\n Consulter les préférences des résidents [2]"
                                                +"\n Retour au menu [3]");
                                        Input = scanner.nextLine().trim();
                                        Intervenant.Soumission(Input); // appel a la fontion
                                    }else if ("3".equals(Input)) {
                                        System.out.println(" Mettre à jour la description du projet [1]"
                                                +"\n Mettre à jour la date de fin prévue [2]"
                                                +"\n Changer le statut du projet [3]"
                                                +"\n Retour au menu [4]");
                                        Input = scanner.nextLine().trim();
                                        Intervenant.MaJ(Input); // appel a la fontion
                                    }else if ("4".equals(Input)) {
                                        break application; // Déconnexion de l'application
                                    }else {
                                        System.out.println("Mauvais Input!!");
                                    }
                                }
                            }
                        }
                    }
                } System.out.println("Mauvais courriel ou mot de passe");
            } else if ("2".equals(Input)){
                System.out.println("la creation du compte est indisponible");
            } else if ("3".equals(Input)){
                System.out.println("quitter");
                break;
            } else {
                System.out.println("Input invalide!");
            }
        }
        scanner.close();

    }
}
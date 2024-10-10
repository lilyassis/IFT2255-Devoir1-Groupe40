import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        List<Object> Users = new ArrayList<Object>();
        Resident Bob = new Resident("bob", "2002/23/01", "bob@gmail.com", "123", "514-123-4567", "2900 Edouard Montpetit Blvd");
        Intervenant Alice = new Intervenant("alice", "alice@gmail.com", "123","public", 001);
        Users.add(Alice);
        Users.add(Bob);
        String Input;
        String Adresse;
        String MotDePasse;

        Scanner scanner = new Scanner(System.in);
        application:
        while (true) {
        System.out.println("Entrez [1] pour connection ou [2] pour inscription ou [3] pour quitter");
        Input = scanner.nextLine().trim();
        if ("1".equals(Input)) {

                System.out.println("Entrez votre adresse courriel:");
                Adresse = scanner.nextLine().trim();
                System.out.println("Entrez votre mot de passe:");
                MotDePasse = scanner.nextLine().trim();

                for(Object Utilisateur: Users){

                    if (Utilisateur.getClass() == Resident.class) {
                        Resident resident = (Resident) Utilisateur;
                        if (resident.AdresseCourriel.equals(Adresse)) {
                            if (MotDePasse.equals(resident.MotDePasse)) {
    
                                while (true) {
                                    System.out.println("Entrez le numero de votre choix:");
                                    resident.Menu();
                                    Input = scanner.nextLine().trim();

                                    if ("1".equals(Input)) {
                                        System.out.println(" Consulter liste des projets par quartier [1]"
                                                            +"\n Consulter liste des projets par type de travaux [2]"
                                                            +"\n Consulter liste des projets par rue [3]"
                                                            +"\n Retour au menu [4]");

                                        Input = scanner.nextLine().trim();
                                        resident.ConsulterTravaux(Input);
                                        continue;

                                    }else if ("2".equals(Input)) {
                                        System.out.println(" Consulter liste des travaux par titre [1]"
                                                            +"\n Consulter liste des travaux par type de travaux [2]"
                                                            +"\n Consulter liste des travaux par quartier [3]"
                                                            +"\n Retour au menu [4]");
                                        Input = scanner.nextLine().trim();
                                        resident.RechercheTravaux(Input);
                                    }else if ("3".equals(Input)) {
                                        System.out.println(" S'abonner aux notifications pour des projets affectant une rue [1]"
                                                            +"\n S'abonner aux notifications pour des projets affectant un quartier donné [2]"
                                                            +"\n Retour au menu [3]");
                                        Input = scanner.nextLine().trim(); 
                                        resident.RecevoirNotifications(Input);                                   
                                    }else if ("4".equals(Input)) {
                                        System.out.println(" Fournir mes plages horaires préférables dans mon quartier [1]"
                                                            +"\n Consulter les préférences des autres résidents de mon quartier [2]"
                                                            +"\n Partager mon avis sur les travaux et l'intervenant. [3]"
                                                            +"\n Retour au menu [4]");
                                        Input = scanner.nextLine().trim();
                                        resident.Planification(Input);
                                    }else if ("5".equals(Input)) {
                                        System.out.println(" Soumettre une requête de travail [1]"
                                                            +"\n Faire le suivi de ma requête [2]"
                                                            +"\n Retour au menu [3]");
                                        Input = scanner.nextLine().trim();
                                        resident.Requete(Input);
                                    }else if ("6".equals(Input)) {
                                        System.out.println(" Signaler un problème à la ville [1]"
                                                             +"\n Retour au menu [2]");
                                        Input = scanner.nextLine().trim();
                                        resident.Signaler(Input);
                                    }else if ("7".equals(Input)) {
                                        break application;
                                    }else {
                                        System.out.println("Mauvais Input!!");
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                    } 
                    
                    if (Utilisateur.getClass() == Intervenant.class) {
                        Intervenant Intervenant = (Intervenant) Utilisateur;
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
                                    Intervenant.Requetes(Input);
                                }else if ("2".equals(Input)) {
                                    System.out.println(" Soumettre un nouveau projet de travaux [1]"
                                                        +"\n Consulter les préférences des résidents [2]"
                                                        +"\n Retour au menu [3]");
                                    Input = scanner.nextLine().trim();
                                    Intervenant.Soumission(Input);
                                }else if ("3".equals(Input)) {
                                    System.out.println(" Mettre à jour la description du projet [1]"
                                                        +"\n Mettre à jour la date de fin prévue [2]"
                                                        +"\n Changer le statut du projet [3]"
                                                        +"\n Retour au menu [4]");
                                    Input = scanner.nextLine().trim();
                                    Intervenant.MaJ(Input);
                                }else if ("4".equals(Input)) {
                                    break application;
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

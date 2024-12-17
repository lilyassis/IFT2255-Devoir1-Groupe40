import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws ParseException {
        Menu menu = new Menu();
        AccountController comptes = new AccountController();
        HttpClientApi api = new HttpClientApi();

        String resourceIdTravaux = "cc41b532-f12d-40fb-9f55-eb58c9a2b12b";
        String resourceIdEntraves = "a2bc8014-488c-495d-941b-e7ae1999d1bd";
        ApiResponse ResponseTravaux = api.getData(resourceIdTravaux);
        ApiResponse ResponseEntraves = api.getData(resourceIdEntraves);
        Gson gson = new Gson();

        List<Projet> projetsAVenir = new ArrayList<Projet>();
        List<Requete> Requetes = new ArrayList<Requete>(); // Liste de Requetes
        List<Object> Users = new ArrayList<>(); // Liste de usagers
        Travaux travaux = gson.fromJson(ResponseTravaux.getBody(),Travaux.class);
        ArrayList<Travail> ListeDeTravaux = travaux.getResult().getRecords();
        Entraves entraves = gson.fromJson(ResponseEntraves.getBody(),Entraves.class);
        ArrayList<Entrave> ListeDeEntraves = entraves.getResult().getRecords();

        DatabaseController database = new DatabaseController(Users,projetsAVenir,Requetes,ListeDeTravaux,ListeDeEntraves);
      /*  // 3 requetes
        Requete requete1 = new Requete("Construction d'un immeuble résidentiel de 8 étages","Cette construction est un immeuble résidentiel de 8 étages situé dans un quartier central d'une grande ville. Il comprend des appartements modernes allant de 40 à 90 m², avec des commerces (boulangerie, pharmacie, café) au rez-de-chaussée.","Construction","2022-03-04",true);
        Requete requete2 = new Requete("Construction d'un centre commercial de trois niveaux","Il s'agit d'un centre commercial moderne de trois niveaux, situé en périphérie d'une ville en expansion. Le bâtiment offre une large gamme de commerces, de restaurants, de cinémas et d'espaces de loisirs","Construction","2023-07-12",true);
        Requete requete3 = new Requete("Rénovation d'un entrepôt en espace mixte","transformation d’un ancien bâtiment industriel en un espace polyvalent comprenant des bureaux, des appartements et des commerces","Rénovation","2023-01-23",false);
        Requetes.add(requete1);
        Requetes.add(requete2);
        Requetes.add(requete3);
*/      DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
        // 3 Residents
        Resident Bob = new Resident("bob", "bob@gmail.com", "123", df.parse("2003/12/4"),  "2900 Edouard Montpetit Blvd");
        Resident Sophie = new Resident("Sophie", "sophie@gmail.com", "123", df.parse("2003/12/4"),"2900 Edouard Montpetit Blvd");
        Resident Emma = new Resident("Emma", "emma@gmail.com", "123", df.parse("2003/12/4"),"2900 Edouard Montpetit Blvd");
        // 3 Intervenants
       // Intervenant Alice = new Intervenant("alice", "alice@gmail.com", "123","public", 001);
     //   Intervenant Angie = new Intervenant("angie", "angie@gmail.com", "123","public", 002);
      //  Intervenant Alex = new Intervenant("alex", "alex@gmail.com", "123","public", 003);
        // creation des usagers
        Users.add(Bob);
     //   Alice.Ajouter(Users);
    //    Angie.Ajouter(Users);
      //  Alex.Ajouter(Users);
        try (Writer writer = new FileWriter("Output.json")) {
            Gson ggson = new GsonBuilder().create();
            ggson.toJson(Users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String Input;
        String Adresse;
        String MotDePasse;

        Scanner scanner = new Scanner(System.in);
        application:  // boucle en charge de tout le processus tant que l'application est en marche
        while (true) {
            menu.start();
            Input = scanner.nextLine().trim();
            if ("1".equals(Input)) {

                System.out.println("Entrez votre adresse courriel:");
                Adresse = scanner.nextLine().trim().toLowerCase();
                System.out.println("Entrez votre mot de passe:");
                MotDePasse = scanner.nextLine().trim();

                for(Object Utilisateur: Users){  // boucle qui itere sur tout les utilisateurs sur la base de donnes

                    if (Utilisateur.getClass() == Resident.class) {
                        Resident resident = (Resident) Utilisateur;  // creation temporaire d'un objet resident afin de pouvoir l'authentifier
                        if (resident.courriel.equals(Adresse)) {
                            if (MotDePasse.equals(resident.password)) {

                                while (true) {
                                    System.out.println("Entrez le numero de votre choix:");
                                    menu.menuResident();  // afiche le menu
                                    Input = scanner.nextLine().trim();

                                    if ("1".equals(Input)) {
                                        menu.menuConsulterTravaux();
                                        Input = scanner.nextLine().trim();
                                        if (Input.equals("1")){
                                            database.consulterTravaux();
                                        } else if (Input.equals("2")){
                                            database.consulterProjets();
                                        } else if (Input.equals("3")){
                                            System.out.println("Quartier du travail en particulier?");
                                            menu.quartiers();
                                            database.consulterTravailParQuartier(scanner.nextLine().trim().toLowerCase());
                                        } else if (Input.equals("4")) {
                                            System.out.println("Retour au menu");
                                        } else {
                                            System.out.println("Mauvaise commande!!!");
                                        }
                                    }else if ("2".equals(Input)) {
                                        menu.menuConsulterEntraves();
                                        Input = scanner.nextLine().trim();
                                        if (Input.equals("1")){
                                            database.consulterEntraves();
                                        } else if (Input.equals("2")){
                                            System.out.println("Rue du travail en particulier?");
                                            database.ConsulterEntraveParRue(scanner.nextLine().trim().toLowerCase());
                                        } else if (Input.equals("3")) {
                                            System.out.println("Retour au menu");
                                        } else {
                                            System.out.println("Mauvaise commande!!!");
                                        }
                                    }else if ("3".equals(Input)) {
                                        resident.consulterNotifications();
                                    }else if ("4".equals(Input)) {
                                        menu.menuPlagesHoraires();
                                        Input = scanner.nextLine().trim();
                                        if (Input.equals("1")){
                                            System.out.println(resident.getHoraires());
                                        } else if (Input.equals("2")){
                                            System.out.println("Veuillez fournir toutes les informations demandées en une ligne dans ce format :");
                                            System.out.println("(Jour de la semaine, heure de début, heure de fin)");
                                            String input = scanner.nextLine();
                                            String[] inputs = input.split(",");
                                            resident.modifierHoraire(JourDeLaSemaine.valueOf(inputs[0].trim().toUpperCase()),inputs[1].trim(),inputs[2].trim());
                                        } else if (Input.equals("3")) {
                                            System.out.println("Retour au menu");
                                        } else {
                                            System.out.println("Mauvaise commande!!!");
                                        }
                                    }else if ("5".equals(Input)) {
                                        System.out.println(" Soumettre une requête de travail [1]"
                                                +"\n Faire le suivi de ma requête [2]"
                                                +"\n Retour au menu [3]");
                                        Input = scanner.nextLine().trim();
                                        if(Input.equals("1")){
                                            System.out.println("Veuillez fournir toutes les informations demandées en une ligne dans ce format :");
                                            System.out.println("(Titre du travail, description détaillée, date de début espéré,type de travaux conforme aux travaux possibles)");
                                            String input = scanner.nextLine();
                                            String[] inputs = input.split(",");
                                            Requete requete = new Requete(resident,inputs[0],inputs[1],inputs[2],WorkType.valueOf(inputs[3]),true);
                                            Requetes.add(requete);
                                            resident.setRequete(requete);
                                        }else if(Input.equals("2")){ // a faire
                                            if(resident.getRequete()!= null){
                                                System.out.println(resident.getRequete());
                                            } else {
                                                System.out.println("Pas de requête en cours");
                                            }
                                        }

                                    }else if ("6".equals(Input)) {
                                        continue application;
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
                        if (Intervenant.courriel.equals(Adresse)) {
                            if (MotDePasse.equals(Intervenant.password)) {

                                while (true) {
                                    System.out.println("Entrez le numero de votre choix:");
                                    menu.menuIntervenant();
                                    Input = scanner.nextLine().trim();

                                    if ("1".equals(Input)) {
                                        Input = scanner.nextLine().trim();
                                        if (Input.equals("1")){
                                            for(int i = 0; i < Requetes.size(); i++) {
                                                System.out.print("Requete " + (i+1) + ":\n" );
                                                System.out.print(Requetes.get(i));
                                            }
                                        }
                                    }else if ("2".equals(Input)) {
                                        System.out.println("Veuillez fournir toutes les informations demandées en une ligne dans ce format :");
                                        System.out.println("(titre, description,typeTravaux, dateDebut, dateFin,quartierAffectés)");
                                        String input = scanner.nextLine();
                                        String[] inputs = input.split(",");
                                        Quartier quartier = new Quartier(inputs[5],"0000");
                                        Projet projet = new Projet(inputs[0],inputs[1],TypeTravaux.valueOf(inputs[2]),df.parse(inputs[3].trim()),df.parse(inputs[4].trim()),quartier);
                                        Intervenant.setProjet(projet);
                                        database.projets.add(projet);
                                    }else if ("3".equals(Input)) {
                                        System.out.println("Veuillez fournir le titre du projet a modifier:");
                                        Input = scanner.nextLine().trim();
                                        System.out.println("Veuillez fournir le nouveau statut:");
                                        StatutProjet statut = StatutProjet.valueOf(scanner.nextLine().trim());
                                        for (Projet projet: Intervenant.projets){
                                            if (Input.equals(projet.getTitre())){
                                                projet.changerStatut(statut);
                                            }
                                        }
                                    }else if ("4".equals(Input)) {
                                        System.out.println(database.requetes);
                                        System.out.println("Veuillez fournir le titre du projet a postuler:");
                                        Input = scanner.nextLine().trim();
                                        for (Requete requete : database.requetes){
                                            if (Input.equals(requete.getTitreDuTravail())){
                                                System.out.println("message pour la candidature(facultatif):");
                                                String message = scanner.nextLine().trim();
                                                Candidature candidature = new Candidature(requete);
                                                requete.setCandidature(candidature);
                                                // mettre notif
                                            }
                                        }
                                    }else if ("5".equals(Input)) {
                                        System.out.println(Intervenant.candidatures);
                                        System.out.println("Veuillez fournir le titre de la requete:");
                                        Input = scanner.nextLine().trim();
                                        for (Candidature candidature : Intervenant.candidatures){
                                            if (Input.equals(candidature.getRequete().getTitreDuTravail())){
                                                candidature.getRequete().setCandidature(null);
                                                System.out.println("Votre candidature a ete soustraite!");
                                            }
                                        }
                                    }else if ("6".equals(Input)) {
                                        continue application;
                                    }else {
                                        System.out.println("Mauvais Input!!");
                                    }
                                }
                            }
                        }
                    }
                } System.out.println("Mauvais courriel ou mot de passe");
            } else if ("2".equals(Input)){
                System.out.println("Créer un compte Resident [1] ");
                System.out.println("Créer un compte Intervenant [2] ");
                Input = scanner.nextLine().trim();
                if ("1".equals(Input)){
                    System.out.println("Veuillez fournir toutes les informations demandées en une seule ligne dans ce format :");
                    System.out.println("(Nom complet, Date de naissance (MM/dd/yyyy), Adresse courriel, Mot de passe, Adresse résidentielle)");
                    String[] inputs = scanner.nextLine().split(",");
                    if (inputs.length >= 5) {
                        try {
                            // Valider la date
                            java.util.Date dateNaissance = df.parse(inputs[1].trim());
                            comptes.CreationResident(Users,inputs[0].trim(),inputs[2].trim(),inputs[3].trim(),dateNaissance,inputs[4].trim(),null);
                        } catch (ParseException e) {
                            System.out.println("Erreur : La date de naissance n'est pas dans le format correct (MM/dd/yyyy).");
                        }
                    } else {
                        System.out.println("Erreur : Informations insuffisantes. Veuillez suivre le format requis.");
                    }
                } else if ("2".equals(Input)){
                    System.out.println("Veuillez fournir toutes les informations demandées en une ligne dans ce format :");
                    System.out.println("(Nom complet, Type d'intervenant, Adresse courriel, Mot de passe, Identifiant de la ville (code à 8 chiffres))");
                    String input = scanner.nextLine();
                    String[] inputs = input.split(",");
                    if (inputs.length >= 5) {
                        int identifiant = Integer.parseInt(inputs[4].trim());
                        while ( VerifierIdentifiantVille(Users, identifiant)) {
                            System.out.println("Identifiant de la ville fourni est déjà attribué à un autre intervenant, veuillez fournir un autre identifiant :");
                            identifiant = Integer.valueOf(scanner.nextLine().trim());
                        }
                        comptes.CreationIntervenant(Users,inputs[0].trim(),inputs[2].trim(),inputs[3].trim(),IntervenantType.PARTICULIER,identifiant);
                    } else {
                        System.out.println("Erreur : Vous n'avez pas fourni toutes les informations demandées !");
                    }}
                } else if ("3".equals(Input)){
                System.out.println("quitter");
                break;
            } else {
                System.out.println("Input invalide!");
            }
        }
        scanner.close();

    }

    static boolean VerifierIdentifiantVille(List<Object> Users,int Identifiant) {
        for(Object Utilisateur: Users){
            if (Utilisateur.getClass().equals(Intervenant.class)){
                Intervenant resident = (Intervenant) Utilisateur;
               if (resident.getIdentifiant() == Identifiant){
                   return true;
               }
            }
        }
        return false;
    }
}

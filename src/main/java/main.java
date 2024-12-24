import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

        DatabaseController database = new DatabaseController(null,null,null,null,null,null);

        try (Reader reader = new FileReader("data/DatabaseController.json")) {
            database = gson.fromJson(reader, DatabaseController.class);
        } catch (FileNotFoundException e) {
            System.out.println("fichier pas trouver");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Travaux travaux = gson.fromJson(ResponseTravaux.getBody(),Travaux.class);
        database.travaux = travaux.getResult().getRecords();
        Entraves entraves = gson.fromJson(ResponseEntraves.getBody(),Entraves.class);
        database.entraves = entraves.getResult().getRecords();

        List<Object> Users = new ArrayList<>();
        for (Resident resident: database.residents){
            resident.initialiserHoraires();
            Users.add(resident);
        }
        for (Intervenant intervenant:database.intervenants){
            Users.add(intervenant);
        }

      DateFormat df = new SimpleDateFormat("mm/dd/yyyy");

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
                                            resident.modifierHoraire(inputs[0],inputs[1].trim(),inputs[2].trim());
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
                                            System.out.println("(Titre du travail, description détaillée, date de début espéré,type de travail conforme aux travaux possibles)");
                                            String input = scanner.nextLine();
                                            String[] inputs = input.split(",");
                                            if (inputs.length >= 4) {
                                                try {
                                                    WorkType type = WorkType.valueOf(inputs[3].trim().toUpperCase());
                                                    Requete requete = new Requete(resident.nom,inputs[0],inputs[1],inputs[2],type,true);
                                                    resident.setRequete(requete);
                                                    database.requetes.add(requete);
                                                }catch (IllegalArgumentException e) {
                                                   System.out.println("type de travail n'est pas conforme aux travaux possibles");
                                                }
                                            }else {
                                                System.out.println("Les informations demandées sont incompletes");
                                            }
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
                                        if (!database.requetes.isEmpty()){
                                            for(int i = 0; i < database.requetes.size(); i++) {
                                                System.out.print("Requete " + (i+1) + ":\n" );
                                                System.out.print(database.requetes.get(i) + ":\n");
                                            }
                                        }else {
                                            System.out.println("Pas de requetes");
                                        }
                                    }else if ("2".equals(Input)) {
                                        System.out.println("Veuillez fournir toutes les informations demandées en une ligne dans ce format :");
                                        System.out.println("(titre, description,typeTravaux, date de debut ((MM/dd/yyyy), date de fin ((MM/dd/yyyy),quartier Affecté)");
                                        String input = scanner.nextLine();
                                        String[] inputs = input.split(",");
                                        if (inputs.length >= 6) {
                                            try {
                                                Quartier quartier = new Quartier(inputs[5],"0000");
                                                Projet projet = new Projet(inputs[0],inputs[1],TypeTravaux.valueOf(inputs[2]),df.parse(inputs[3].trim()),df.parse(inputs[4].trim()),quartier);
                                                Intervenant.addProjet(projet);
                                                database.projets.add(projet);
                                            }catch (IllegalArgumentException e) {
                                                System.out.println("type de travail n'est pas dans le bon format");
                                            }catch (ParseException e) {
                                                System.out.println("Erreur : La date n'est pas dans le format correct (MM/dd/yyyy).");
                                            }
                                        }
                                    }else if ("3".equals(Input)) {
                                        System.out.println(Intervenant.projets);
                                        System.out.println("Veuillez fournir le titre du projet a modifier:");
                                        Input = scanner.nextLine().trim();
                                        System.out.println("Veuillez fournir le nouveau statut (Prévu,EnCours,Suspendu,Terminé): ");
                                        try {
                                            StatutProjet statut = StatutProjet.valueOf(scanner.nextLine().trim());
                                            for (Projet projet: Intervenant.projets){
                                                if (Input.equals(projet.getTitre())){
                                                    projet.changerStatut(statut);
                                                }else {
                                                    System.out.println("Projet inexistant ");
                                                }
                                            }
                                        } catch (IllegalArgumentException e){
                                            System.out.println("Statut de projet n'est pas dans le bon format");
                                        }
                                    }else if ("4".equals(Input)) {
                                        System.out.println(database.requetes);
                                        System.out.println("Veuillez fournir le titre du projet a postuler:");
                                        Input = scanner.nextLine().trim();
                                        for (Requete requete : database.requetes){
                                            if (Input.equals(requete.getTitreDuTravail())){
                                                Candidature candidature = new Candidature(requete.getTitreDuTravail());
                                                requete.addCandidature(candidature);
                                                Intervenant.addCandicature(candidature);
                                                System.out.println("Votre candidature a ete envoyee!");
                                            }
                                        }
                                    }else if ("5".equals(Input)) {
                                        System.out.println(Intervenant.candidatures);
                                        System.out.println("Veuillez fournir le titre de la requete:");
                                        Input = scanner.nextLine().trim();
                                        try {
                                            Iterator<Candidature> iterator = Intervenant.candidatures.iterator();
                                            while (iterator.hasNext()) {
                                                Candidature candidature = iterator.next();
                                                if (Input.equals(candidature.getRequete())) {
                                                    for (Requete requete : database.requetes) {
                                                        if (Input.equals(requete.getTitreDuTravail())) {
                                                            requete.removeCandidature(candidature);
                                                            iterator.remove();
                                                            System.out.println("Votre candidature a ete soustraite!");
                                                        }
                                                    }
                                                }
                                            }
                                        }catch (NullPointerException e){
                                            System.out.println("pas de candidatures");
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
                            comptes.CreationResident(database.residents,inputs[0].trim(),inputs[2].trim(),inputs[3].trim(),dateNaissance,inputs[4].trim(),null);
                            Users.add(database.residents.get(database.residents.size()-1));
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
                        comptes.CreationIntervenant(database.intervenants,inputs[0].trim(),inputs[2].trim(),inputs[3].trim(),IntervenantType.PARTICULIER,identifiant);
                        Users.add(database.intervenants.get(database.intervenants.size()-1));
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
        Gson gsonn = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("data/DatabaseController.json")) {
            gsonn.toJson(database, writer);
            System.out.println("DatabaseController saved to JSON.");
        } catch (IOException e) {
            System.err.println("Error saving the DatabaseController to JSON: " + e.getMessage());
            e.printStackTrace();
        }
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

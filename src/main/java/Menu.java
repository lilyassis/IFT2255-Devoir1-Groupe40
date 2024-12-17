public class Menu {
    public void start(){
        System.out.println("Entrez [1] pour connexion [2] pour inscription ou [3] pour quitter");
    }

    public void menuResident(){
        System.out.println(" Consulter les travaux en cours ou à venir [1]"
                +"\n Consulter les entraves routières causées par les travaux en cours [2]"
                +"\n Voir ses notifications [3]"
                +"\n Modifier ses préférences horaires [4]"
                +"\n Soumettre ou suivre une requête de travail résidentiel [5]"
                +"\n Déconnexion [6]");
    }

    public void menuIntervenant(){
        System.out.println(" Consulter la liste des requêtes de travail [1]"
                +"\n Soumettre un nouveau projet de travaux [2]"
                +"\n Modifier le statut d'un projet [3]"
                +"\n Soumettre sa candicature pour une requête de travail  [4]"
                +"\n Soustraire sa candicature pour une requête de travail  [5]"
                +"\n Déconnexion [6]");
    }

    public void menuConsulterTravaux(){
        System.out.println(" Consulter les travaux en cours [1]"
                +"\n Consulter les travaux à venir [2]"
                +"\n Consulter liste des travaux par quartier [3]"
                +"\n Retour au menu [4]");
    }

    public void menuConsulterEntraves(){
        System.out.println(" Consulter liste de entraves [1]"
                +"\n Consulter liste de entraves par rue [2]"
                +"\n Retour au menu [3]");
    }

    public void quartiers(){
        System.out.println("Le Sud-Ouest\n" +
                "Villeray-Saint-Michel-Parc-Extension\n" +
                "LaSalle\n" +
                "Ville-Marie\n" +
                "Ahuntsic-Cartierville\n" +
                "Verdun\n" +
                "Mercier-Hochelaga-Maisonneuve\n" +
                "Saint-Léonard\n" +
                "Pierrefonds-Roxboro\n" +
                "Montréal-Nord\n" +
                "Côte-des-Neiges-Notre-Dame-de-Grâce\n" +
                "Le Plateau-Mont-Royal\n" +
                "Rosemont-La Petite-Patrie\n" +
                "Outremont");
    }

    public void menuPlagesHoraires(){
        System.out.println(" Consulter mes préférences horaires [1]"
                +"\n Modifier mes préférences horaires [2]"
                +"\n Retour au menu [3]");
    }

}

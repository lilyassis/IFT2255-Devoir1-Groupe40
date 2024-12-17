public class Horaire {
    private JourDeLaSemaine jourDeLaSemaine;
    private String heureDebut;
    private String heureFin;

    public Horaire(JourDeLaSemaine jourDeLaSemaine) {
        this.jourDeLaSemaine = jourDeLaSemaine;
        this.heureDebut = "Pas spécifié";
        this.heureFin = "Pas spécifié";
    }

    public void modifierHoraire(String heureDebut, String heureFin) {
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public JourDeLaSemaine getJourDeLaSemaine() {
        return jourDeLaSemaine;
    }

    @Override
    public String toString() {
        return "Horaire : " + jourDeLaSemaine + " de " + heureDebut + " à " + heureFin;
    }
}


public class Requete {
    private String TitreDuTravail, Description, TypeDeTravaux, DateDeDébut;
    private Boolean EtatDeRequete;

    public Requete(String titreDuTravail, String description, String typeDeTravaux, String dateDeDébut, Boolean etatDeRequete) {
        TitreDuTravail = titreDuTravail;
        Description = description;
        TypeDeTravaux = typeDeTravaux;
        DateDeDébut = dateDeDébut;
        EtatDeRequete = etatDeRequete;
    }

    @Override
    public String toString() {
        return
                " Titre du travail a réaliser = " + TitreDuTravail + '\n' +
                " Description détaillée = " + Description + '\n' +
                " Type de travaux = " + TypeDeTravaux + '\n' +
                " Date de début espéré = " + DateDeDébut + '\n' +
                " Etat de la requete (Ouverte = true) = " + EtatDeRequete +
                '\n';
    }
}

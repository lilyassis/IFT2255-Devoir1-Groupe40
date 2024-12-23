import java.util.Date;
import java.util.List;

public class AccountController {

    public void CreationResident(List<Resident> residents,String Nom, String AdresseCourriel, String MotDePasse, Date DateNaissance, String adresse, Requete requete){
        Resident resident = new Resident(Nom, AdresseCourriel,MotDePasse, DateNaissance,adresse);
        residents.add(resident);
        System.out.println("votre compte a été créé");
    }

    public void CreationIntervenant(List<Intervenant> intervenants,String Nom, String AdresseCourriel, String MotDePasse, IntervenantType Type, int Identifiant){
        Intervenant intervenant = new Intervenant( Nom, AdresseCourriel,  MotDePasse, Type,Identifiant);
        intervenants.add(intervenant);
        System.out.println("votre compte a été créé");
    }
}

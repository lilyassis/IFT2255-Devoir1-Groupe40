import java.util.Date;
import java.util.List;

public class AccountController {

    public void CreationResident(List<Object> Users,String Nom, String AdresseCourriel, String MotDePasse, Date DateNaissance, String adresse, Requete requete){
        Resident resident = new Resident(Nom, AdresseCourriel,MotDePasse, DateNaissance,adresse);
        Users.add(resident);
        System.out.println("votre compte a été créé");
    }

    public void CreationIntervenant(List<Object> Users,String Nom, String AdresseCourriel, String MotDePasse, IntervenantType Type, int Identifiant){
        Intervenant intervenant = new Intervenant( Nom, AdresseCourriel,  MotDePasse, Type,Identifiant);
        Users.add(intervenant);
        System.out.println("votre compte a été créé");
    }
}

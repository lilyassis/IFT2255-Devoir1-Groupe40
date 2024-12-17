import com.google.gson.annotations.Expose;

public class Travail {

    @Expose private String id,boroughid,currentstatus,reason_category,submittercategory,organizationname;

    public String getBoroughid() {
        return boroughid;
    }

    @Override
    public String toString() {
        return
                "Identifiant du travail='" + id + '\'' +
                ", Arrondissement='" + boroughid + '\'' +
                ", Identifiant du travail='" + currentstatus + '\'' +
                ", Motif du travail='" + reason_category + '\'' +
                ", Catégorie d'intervenant='" + submittercategory + '\'' +
                ", Nom de l'intervenant='" + organizationname + '\'' +
                '\n';
    }
}

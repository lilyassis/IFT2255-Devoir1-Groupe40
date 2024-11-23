import com.google.gson.annotations.Expose;

public class Entrave {
    @Expose
    private String id_request, streetid, shortname, streetimpacttype;

    public String getId_request() {
        return id_request;
    }

    public Entrave(String id_request, String streetid, String shortname, String streetimpacttype) {
        this.id_request = id_request;
        this.streetid = streetid;
        this.shortname = shortname;
        this.streetimpacttype = streetimpacttype;
    }

    public String getStreetid() {
        return streetid;
    }

    public String getShortname() {
        return shortname;
    }

    @Override
    public String toString() {
        return
                "Identifiant du travail ='" + id_request + '\'' +
                ", Identifiant de la rue ='" + streetid + '\'' +
                ", Nom de la rue ='" + shortname + '\'' +
                ", Impact du travail sur la rue ='" + streetimpacttype + '\'' +
                '\n';
    }
}
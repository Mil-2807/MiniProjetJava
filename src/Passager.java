import java.util.ArrayList;
import java.util.List;

public class Passager extends Personne{
    private String passeport;

    public Passager(String identifiant, String nom, String adresse, String contact, String passeport) {
        super(identifiant, nom, adresse, contact);
        this.passeport = passeport;
        List<Vol> volsReserve = new ArrayList<Vol>();
    }

    public String getPasseport() {
        return passeport;
    }

    public void setPasseport(String passeport) {
        this.passeport = passeport;
    }

    public void reserverVol() {
        System.out.println("Reserver vol " + this.getPasseport());
    }

    public void annulerReservation() {
        System.out.println("Annuler vol " + this.getPasseport());
    }

    public void obtenirReservation() {
        System.out.println("Obtenir reservation " + this.getPasseport());
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Passager extends Personne{
    private String passeport;
    private List<Vol> volsReserve;

    // Gestion CRUD
    private static Map<String, Passager> passagers = new HashMap<>();

    public Passager(String identifiant, String nom, String adresse, String contact, String passeport) {
        super(identifiant, nom, adresse, contact);
        this.passeport = passeport;
        this.volsReserve = new ArrayList<>();
        passagers.put(identifiant, this);
    }

    public String getPasseport() {
        return passeport;
    }

    public void setPasseport(String passeport) {
        this.passeport = passeport;
        passagers.put(this.getIdentifiant(), this);
    }

    public List<Vol> getVolsReserve() {
        return volsReserve;
    }

    public void reserverVol(Vol vol, List<Reservation> reservations) {
        System.out.println("\n-------- Reserver vol  : ---------");
        System.out.println("Nom : " +getNom());
        System.out.println("Vol : " +vol.getNumeroVol());
        System.out.println("Passeport : " +getPasseport());
    }

    public void annulerReservation(String numeroReservation, List<Reservation> reservations) {
        System.out.println("\n------- Annuler le réservation  : -----------");
        System.out.println("Nom : " +getNom());
        System.out.println("Numéro de reservation : " +numeroReservation);
        System.out.println("Passeport : " +getPasseport());

    }

    public void obtenirReservation(String numeroReservation, List<Reservation> reservations) {
        System.out.println("\n--------- Obtenir la reservation : ----------");
        System.out.println("Nom : " +getNom());
        System.out.println("Numero de reservation : " +numeroReservation);
        System.out.println("Passeport : " +getPasseport());
    }

    @Override
    public String obtenirRole() {
        return "Passager";
    }

    @Override
    public void obtenirInfos() {
        super.obtenirInfos();
        System.out.println("Passeport: " + passeport);
        System.out.println("Vols Reserve: " + volsReserve);
    }

    public static void ajouterPassager(Passager passager) {
        if (passagers.containsKey(passager.getIdentifiant())) {
            passagers.put(passager.getIdentifiant(), passager);
            System.out.println("Passager : " + passager.getIdentifiant() + " est bien ajouté");
        } else {
            System.out.println("Erreur : Un passager " + passager.getIdentifiant() + " existe déjà");
        }
    }

    public static Passager chercherPassager(String identifiant) {
        if(passagers.containsKey(identifiant)) {
            System.out.println("\n------ Information du passager " +identifiant + "--------");
            passagers.get(identifiant).obtenirInfos();
            return passagers.get(identifiant);
        } else {
            System.out.println("Information du passager " +identifiant + " n'existe pas");
            return null;
        }
    }

    public static void modifierPassager(String identifiant, String nouveauNom, String nouvelleAdresse, String nouveauContact, String nouveauPasseport) {
        if (passagers.containsKey(identifiant)) {
            Passager passagerAModifier = passagers.get(identifiant);
            passagerAModifier.setNom(nouveauNom);
            passagerAModifier.setAdresse(nouvelleAdresse);
            passagerAModifier.setContact(nouveauContact);
            passagerAModifier.setPasseport(nouveauPasseport);
            passagers.put(identifiant, passagerAModifier); // Mettre à jour dans la map
            System.out.println("Informations du passager avec l'identifiant " + identifiant + " met à jour.");
        } else {
            System.out.println("Passager avec l'identifiant " + identifiant + " non trouvé.");
        }
    }

    public static void supprimerPassager(String identifiant) {
        if (passagers.containsKey(identifiant)) {
            passagers.remove(identifiant);
            System.out.println("Passager avec l'identifiant " +identifiant + " est supprimé");
        } else {
            System.out.println("Passager avec l'identifiant " + identifiant + " n'existe pas");
        }
    }
}

import java.util.Date;

public class Pilote extends Employe{

    private String licence;
    private int heuresDeVol;

    public Pilote(String identifiant, String nom, String adresse, String contact, String numeroEmploye, Date dateEmbauche, String licence, int heuresDeVol ) {
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.licence = licence;
        this.heuresDeVol = heuresDeVol;
    }

    public String getLicence() {
        return licence;
    }

    public double getHeuresDeVol() {
        return heuresDeVol;
    }

    public void affecterVol() {
        System.out.println("Le pilote " + getNom() +" a été affecté au vol ");
    }

    public void obtenirVol() {
        System.out.println("Informations du vol pour la pilote " + getNom());
    }

}

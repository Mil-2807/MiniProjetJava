import java.util.Date;

public class PersonnelCabine extends Employe {
    private String qualification;

    public PersonnelCabine(String identifiant, String nom, String adresse, String contact, String numeroEmploye, Date dateEmbauche, String qualification) {
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }

    public void affecterVol(Vol vol) {
        System.out.println( "Le personnel de cabine " + getNom() + "a été affecté au vol ");
    }

    public void obtenirVol() {
        System.out.println("Informations du vol pour le personnel de cabine " + getNom() + ".");
    }

}

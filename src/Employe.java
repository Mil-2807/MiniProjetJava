import java.util.Date;

public class Employe extends Personne {
    private String numeroEmploye;
    private Date dateEmbauche;

    public Employe(String identifiant, String nom, String adresse, String contact, String numeroEmploye, Date dateEmbauche) {
        super(identifiant, nom, adresse, contact);
        this.numeroEmploye = numeroEmploye;
        this.dateEmbauche = dateEmbauche;
    }

    public String getNumeroEmploye() {
        return numeroEmploye;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void obtenirRole(String role) {
        role = "Employé";
        return;
    }

}

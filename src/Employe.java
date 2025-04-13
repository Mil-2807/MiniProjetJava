import java.util.HashMap;
import java.util.Map;

public class Employe extends Personne {
    private String numeroEmploye;
    private String dateEmbauche;

    // Gestion CRUD
    private static Map<String, Employe> employes = new HashMap<>();

    public Employe(String identifiant, String nom, String adresse, String contact, String numeroEmploye, String dateEmbauche) {
        super(identifiant, nom, adresse, contact);
        this.numeroEmploye = numeroEmploye;
        this.dateEmbauche = dateEmbauche;
        employes.put(identifiant, this);
    }

    public String getNumeroEmploye() {
        return numeroEmploye;
    }

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
        employes.put(this.getIdentifiant(), this);
    }

    public void setNumeroEmploye(String numeroEmploye) {
        this.numeroEmploye = numeroEmploye;
        employes.put(this.getIdentifiant(), this);
    }

    @Override
    public String obtenirRole() {
        return "Employé";
    }

    @Override
    public void obtenirInfos() {
        super.obtenirInfos();
        System.out.println("Numéro Employé: " + this.numeroEmploye);
        System.out.println("Date d'Embauche: " + this.dateEmbauche);
    }

    public static void ajouterEmploye(Employe employee) {
        if (!employes.containsKey(employee.getIdentifiant())) {
            employes.put(employee.getIdentifiant(), employee);
            System.out.println("Employé " + employee.getIdentifiant() + " ajouté");
        } else {
            System.out.println("Erreur : l'employe " + employee.getIdentifiant() + " existe déjà");
        }
    }

    public static Employe chercherEmploye(String identifiant) {
        if (employes.containsKey(identifiant)) {
            System.out.println("Information de l'employe : " + identifiant);
            employes.get(identifiant).obtenirInfos();
            return employes.get(identifiant);
        } else {
            System.out.println("Erreur : l'employe n'existe pas");
            return null;
        }
    }

    public static void modifierEmploye(String identifiant, String nouveauNom, String nouvelleAdresse, String nouveauContact, String nouvelleDateEmbauche, String nouveauNumeroEmploye) {
        if (employes.containsKey(identifiant)) {
            Employe employeAModifier = employes.get(identifiant);
            employeAModifier.setNom(nouveauNom);
            employeAModifier.setAdresse(nouvelleAdresse);
            employeAModifier.setContact(nouveauContact);
            employeAModifier.dateEmbauche = nouvelleDateEmbauche;
            employeAModifier.numeroEmploye = nouveauNumeroEmploye;
            employes.put(identifiant, employeAModifier);
            System.out.println("Informations de l'employé avec l'identifiant " + identifiant + " mises à jour.");
        } else {
            System.out.println("Employé avec l'identifiant " + identifiant + " non trouvé.");
        }
    }

    public static void supprimerEmploye(String identifiant) {
        if (employes.containsKey(identifiant)) {
            employes.remove(identifiant);
            System.out.println("Employe " + identifiant + " supprimé");
        } else {
            System.out.println("Erreur : l'employe n'existe pas");
        }
    }
}

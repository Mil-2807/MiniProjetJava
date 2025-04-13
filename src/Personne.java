import java.util.HashMap;
import java.util.Map;

public abstract class Personne {
    private String identifiant;
    private String nom;
    private String adresse;
    private String contact;

    // Gestion CRUD
    private static Map<String, Personne> personnes = new HashMap<>();

    public Personne(String identifiant, String nom, String adresse, String contact) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.adresse = adresse;
        this.contact = contact;
        personnes.put(this.identifiant, this);
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setNom(String nom) {
        this.nom = nom;
        personnes.put(this.identifiant, this);
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
        personnes.put(this.identifiant, this);
    }

    public void setContact(String contact) {
        this.contact = contact;
        personnes.put(this.identifiant, this);
    }

    public abstract String obtenirRole();

    public void obtenirInfos() {
        System.out.println("Identifiant: " + this.identifiant);
        System.out.println("Nom: " + this.nom);
        System.out.println("Adresse: " + this.adresse);
        System.out.println("Contact: " + this.contact);
    }

    public static Personne ajouterPersonne(Personne personne) {
        if (!personnes.containsKey(personne.getIdentifiant())) {
            personnes.put(personne.getIdentifiant(), personne);
            System.out.println("Identifiant " + personne.getIdentifiant() + " ajoutée.");
        } else {
            System.out.println("Erreur : " + personne.getIdentifiant() + " existe déjà.");
        }
        return personne;
    }

    public static Personne chercherPersonne(String identifiant) {
        if (personnes.containsKey(identifiant)) {
            System.out.println("Informations de l'identifiant : " + identifiant);
            personnes.get(identifiant).obtenirInfos();
            return personnes.get(identifiant);
        } else {
            System.out.println("L'identifiant " + identifiant + " n'existe pas");
            return null;
        }
    }

    public static void modifierPersonne(String identifiant, String nouveauNom, String nouvelleAdresse, String nouveauContact) {
        if (personnes.containsKey(identifiant)) {
            Personne personneAModifier = personnes.get(identifiant);
            personneAModifier.nom = nouveauNom;
            personneAModifier.adresse = nouvelleAdresse;
            personneAModifier.contact = nouveauContact;
            personnes.put(identifiant, personneAModifier);
            System.out.println("Informations de l'identifiant : " + identifiant + " mise à jour");
        } else {
            System.out.println("L'identifiant " + identifiant + " n'existe pas");
        }
    }

    public static void supprimerPersonne(String identifiant) {
        if (personnes.containsKey(identifiant)) {
            personnes.remove(identifiant);
            System.out.println("Informations de l'identifiant : " + identifiant + " supprimée");
        } else {
            System.out.println("L'identifiant " + identifiant + " n'existe pas");
        }
    }
}

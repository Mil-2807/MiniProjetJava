import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
        personnes.put(this.identifiant, this);
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

    // Méthode statique pour lire les attributs communs d'une personne depuis une ligne CSV
    protected static Personne lireAttributsPersonne(String line) {
        String[] data = line.split(",");
        if (data.length >= 4) {
            // NOTE: On ne peut pas créer directement une instance de Personne.
            // Les classes concrètes devront appeler cette méthode et compléter la création de l'objet.
            // Ceci est un objet Personne "factice" pour stocker temporairement les attributs communs.
            return new Personne(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim()) {
                @Override
                public String obtenirRole() {
                    return "Inconnu"; // Role par défaut ou indication
                }
            };
        }
        return null;
    }

    // Méthode statique pour écrire les attributs communs d'une personne dans un BufferedWriter
    protected static void ecrireAttributsPersonne(Personne personne, BufferedWriter writer) throws IOException {
        writer.write(personne.getIdentifiant() + "," + personne.getNom() + "," +
                personne.getAdresse() + "," + personne.getContact());
    }

    public static Personne ajouterPersonne(Personne personne) {
        if (personnes.containsKey(personne.getIdentifiant())) {
            personnes.put(personne.getIdentifiant(), personne);
            System.out.println("Identifiant " + personne.getIdentifiant() + " est bien ajoutée.");
        } else {
            System.out.println("Erreur : " + personne.getIdentifiant() + " existe déjà.");
        }
        return personne;
    }

    public static Personne chercherPersonne(String identifiant) {
        if (personnes.containsKey(identifiant)) {
            System.out.println("\n------- Informations de l'identifiant : " + identifiant + "---------");
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
            System.out.println("Informations de l'identifiant : " + identifiant + " met à jour");
        } else {
            System.out.println("L'identifiant " + identifiant + " n'existe pas");
        }
    }

    public static void supprimerPersonne(String identifiant) {
        if (personnes.containsKey(identifiant)) {
            personnes.remove(identifiant);
            System.out.println("Informations de l'identifiant : " + identifiant + " est supprimée");
        } else {
            System.out.println("L'identifiant " + identifiant + " n'existe pas");
        }
    }
}

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

    public static List<Personne> readPersonnesFromFile(String filePath) {
        List<Personne> personnes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length == 4) {
                    Personne personne = null;
                    personne.setIdentifiant(data[0].trim());
                    personne.setNom(data[1].trim());
                    personne.setAdresse(data[2].trim());
                    personne.setContact(data[3].trim());
                    personnes.add(personne);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading Personnes: " + e.getMessage());
        }
        return personnes;
    }

    public static void writePersonnesToFile(String filePath, List<Personne> personnes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Identifiant|Nom|Adresse|Contact\n"); // Header
            for (Personne personne : personnes) {
                writer.write(personne.getIdentifiant() + "|" + personne.getNom() + "|" +
                        personne.getAdresse() + "|" + personne.getContact() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing Personnes: " + e.getMessage());
        }
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

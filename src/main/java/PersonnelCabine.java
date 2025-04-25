import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PersonnelCabine extends Employe {
    private String qualification;

    //Gestion CRUD
    private static Map<String, PersonnelCabine> personnelCabines = new HashMap<>();

    public PersonnelCabine(String identifiant, String nom, String adresse, String contact, String numeroEmploye, String dateEmbauche, String qualification) {
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.qualification = qualification;
        personnelCabines.put(identifiant, this);
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
        personnelCabines.put(qualification, this);
    }

    public void affecterVol(Vol vol) {
        System.out.println( "Le personnel de cabine " + getNom() + "a été affecté au vol ");
    }

    public void obtenirVol() {
        System.out.println("Informations du vol pour le personnel de cabine " + getNom() + ".");
    }

    @Override
    public String obtenirRole() {
        return "Personnel de Cabine";
    }

    @Override
    public void obtenirInfos() {
        super.obtenirInfos();
        System.out.println("Informations du personnel de cabine " + getNom() + ".");
        System.out.println("Qualification: " + qualification);
    }

    public static void lirePersonnelCabine(String filePath) {
        personnelCabines.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 7) {
                    String identifiant = data[0].trim();
                    String nom = data[1].trim();
                    String adresse = data[2].trim();
                    String contact = data[3].trim();
                    String numeroEmploye = data[4].trim();
                    String dateEmbauche = data[5].trim();
                    String qualification = data[6].trim();
                    new PersonnelCabine(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche, qualification);
                } else {
                    System.err.println("Ligne invalide dans le fichier PersonnelCabine : " + line);
                }
            }
            System.out.println("Le personnel de cabine a été chargé depuis le fichier : " + filePath);
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier PersonnelCabine : " + e.getMessage());
        }
    }

    public static void ecrirePersonnelCabine(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Identifiant,Nom,Adresse,Contact,NumeroEmploye,DateEmbauche,Qualification\n"); // Header
            for (PersonnelCabine personnelCabine : personnelCabines.values()) {
                writer.write(personnelCabine.getIdentifiant() + "," + personnelCabine.getNom() + "," +
                        personnelCabine.getAdresse() + "," + personnelCabine.getContact() + "," +
                        personnelCabine.getNumeroEmploye() + "," + personnelCabine.getDateEmbauche() + "," +
                        personnelCabine.getQualification() + "\n");
            }
            System.out.println("Le personnel de cabine a été sauvegardé dans le fichier : " + filePath);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier PersonnelCabine : " + e.getMessage());
        }
    }

    public static void ajouterPersonnelCabine(PersonnelCabine personnelCabine) {
        if (personnelCabines.containsKey(personnelCabine.getIdentifiant())) {
            personnelCabines.put(personnelCabine.getIdentifiant(), personnelCabine);
            System.out.println("Personnel de cabine " + personnelCabine.getIdentifiant() + " est bien ajouté.");
        } else {
            System.out.println("Erreur: Un personnel de cabine " + personnelCabine.getIdentifiant() + " existe déjà.");
        }
    }

    public static PersonnelCabine chercherPersonnelCabine(String identifiant) {
        if (personnelCabines.containsKey(identifiant)) {
            System.out.println("\n---------- Informations du Personnel de Cabine " + identifiant + "--------");
            personnelCabines.get(identifiant).obtenirInfos();
            return personnelCabines.get(identifiant);
        } else {
            System.out.println("Personnel de cabine " + identifiant + " non trouvé.");
            return null;
        }
    }

    public static void modifierPersonnelCabine(String identifiant, String nouveauNom, String nouvelleAdresse, String nouveauContact, String nouvelleDateEmbauche, String nouveauNumeroEmploye, String nouvelleQualification) {
        if (personnelCabines.containsKey(identifiant)) {
            PersonnelCabine personnelCabineAModifier = personnelCabines.get(identifiant);
            personnelCabineAModifier.setNom(nouveauNom);
            personnelCabineAModifier.setAdresse(nouvelleAdresse);
            personnelCabineAModifier.setContact(nouveauContact);
            personnelCabineAModifier.setDateEmbauche(nouvelleDateEmbauche); // Méthode héritée
            personnelCabineAModifier.setNumeroEmploye(nouveauNumeroEmploye); // Méthode héritée
            personnelCabineAModifier.qualification = nouvelleQualification;
            personnelCabines.put(identifiant, personnelCabineAModifier); // Mettre à jour dans la map
            System.out.println("Informations du personnel de cabine " + identifiant + " met à jour.");
        } else {
            System.out.println("Personnel de cabine " + identifiant + " non trouvé.");
        }
    }

    public static void supprimerPersonnelCabine(String identifiant) {
        if (personnelCabines.containsKey(identifiant)) {
            personnelCabines.remove(identifiant);
            System.out.println("Personnel de cabine avec l'identifiant " + identifiant + " est supprimé.");
        } else {
            System.out.println("Personnel de cabine avec l'identifiant " + identifiant + " non trouvé.");
        }
    }

}

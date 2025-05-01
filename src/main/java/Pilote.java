import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Pilote extends Employe{

    private String licence;
    private double heuresDeVol;

    // Gestion CRUD
    public static Map<String, Pilote> pilotes = new HashMap<>();

    public Pilote(String identifiant, String nom, String adresse, String contact, String numeroEmploye, String dateEmbauche, String licence, int heuresDeVol ) {
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.licence = licence;
        this.heuresDeVol = heuresDeVol;
        pilotes.put(identifiant, this);
    }

    public String getLicence() {
        return licence;
    }

    public double getHeuresDeVol() {
        return heuresDeVol;
    }

    public void setHeuresDeVol(double heuresDeVol) {
        this.heuresDeVol = heuresDeVol;
        pilotes.put(this.getIdentifiant(), this);
    }

    public void setLicence(String licence) {
        this.licence = licence;
        pilotes.put(this.getIdentifiant(), this);
    }

    public void affecterVol() {
        System.out.println("Le pilote " + getNom() +" a été affecté au vol ");
    }

    public void obtenirVol() {
        System.out.println("Informations du vol pour la pilote " + getNom());
    }

    @Override
    public String obtenirRole() {
        return "Pilote";
    }

    @Override
    public void obtenirInfos() {
        super.obtenirInfos();
        System.out.println("Licence: " + licence);
        System.out.println("Heures de vol: " + heuresDeVol);
    }


    public static void lirePilotes(String filePath) {
        pilotes.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 8) {
                    try {
                        String identifiant = data[0].trim();
                        String nom = data[1].trim();
                        String adresse = data[2].trim();
                        String contact = data[3].trim();
                        String numeroEmploye = data[4].trim();
                        String dateEmbauche = data[5].trim();
                        String licence = data[6].trim();
                        double heuresDeVol = Double.parseDouble(data[7].trim());
                        new Pilote(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche, licence, (int) heuresDeVol);
                    } catch (NumberFormatException e) {
                        System.err.println("Erreur de format pour les heures de vol dans la ligne : " + line + " - " + e.getMessage());
                    }
                } else {
                    System.err.println("Ligne invalide dans le fichier Pilote : " + line);
                }
            }
            System.out.println("Les pilotes ont été chargés depuis le fichier : " + filePath);
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier Pilote : " + e.getMessage());
        }
    }

    public static void ecrirePilotes(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Identifiant,Nom,Adresse,Contact,NumeroEmploye,DateEmbauche,Licence,HeuresDeVol\n"); // Header
            for (Pilote pilote : pilotes.values()) {
                writer.write(pilote.getIdentifiant() + "," + pilote.getNom() + "," +
                        pilote.getAdresse() + "," + pilote.getContact() + "," +
                        pilote.getNumeroEmploye() + "," + pilote.getDateEmbauche() + "," +
                        pilote.getLicence() + "," + pilote.getHeuresDeVol() + "\n");
            }
            System.out.println("Les pilotes ont été chargées depuis le fichier : " + filePath);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier Pilote : " + e.getMessage());
        }
    }


    public static void ajouterPilote(Pilote pilote) {
        if (pilotes.containsKey(pilote.getIdentifiant())) {
            pilotes.put(pilote.getIdentifiant(), pilote);
            System.out.println("Pilote " + pilote.getIdentifiant() + " est bien ajouté");
        } else {
            System.out.println("Erreur : Un pilote " + pilote.getIdentifiant() + " existe déjà");
        }
    }

    public static Pilote chercherPilote(String identifiant) {
        if (pilotes.containsKey(identifiant)) {
            System.out.println("\n ------- Information du pilote " +identifiant + "---------");
            pilotes.get(identifiant).obtenirInfos();
            return pilotes.get(identifiant);
        } else {
            System.out.println("Pilote " + identifiant + " n'existe pas");
            return null;
        }
    }

    public static void modifierPilote(String identifiant, String nouveauNom, String nouvelleAdresse, String nouveauContact, String nouvelleDateEmbauche, String nouveauNumeroEmploye, String nouvelleLicence, double nouvellesHeuresDeVol) {
        if (pilotes.containsKey(identifiant)) {
            Pilote piloteAModifier = pilotes.get(identifiant);
            piloteAModifier.setNom(nouveauNom);
            piloteAModifier.setAdresse(nouvelleAdresse);
            piloteAModifier.setContact(nouveauContact);
            piloteAModifier.setDateEmbauche(nouvelleDateEmbauche);
            piloteAModifier.setNumeroEmploye(nouveauNumeroEmploye);
            piloteAModifier.licence = nouvelleLicence;
            piloteAModifier.heuresDeVol = nouvellesHeuresDeVol;
            pilotes.put(identifiant, piloteAModifier);
            System.out.println("Pilote avec l'identifiant " + identifiant + " met à jour.");
        } else {
            System.out.println("Pilote avec l'identifiant " + identifiant + " n'existe pas.");
        }
    }

    public static void supprimerPilote(String identifiant) {
        if (pilotes.containsKey(identifiant)) {
            pilotes.remove(identifiant);
            System.out.println("Pilote " + identifiant + " est supprimé");
        } else {
            System.out.println("Pilote " + identifiant + " n'existe pas");
        }
    }

}

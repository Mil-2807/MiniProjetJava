import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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

    public static List<Employe> readEmployesFromFile(String filePath) {
        List<Employe> employes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length == 6) {
                    Employe employelecture = new Employe(data[0], data[1], data[2], data[3], data[4], data[5]);
                    employelecture.setIdentifiant(data[0].trim());
                    employelecture.setNom(data[1].trim());
                    employelecture.setAdresse(data[2].trim());
                    employelecture.setContact(data[3].trim());
                    employelecture.setNumeroEmploye(data[4].trim());
                    employelecture.setDateEmbauche(data[5].trim());
                    employes.add(employelecture);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading Employes: " + e.getMessage());
        }
        return employes;
    }

    public static void writeEmployesToFile(String filePath, List<Employe> employes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Identifiant|Nom|Adresse|Contact|NumeroEmploye|DateEmbauche\n"); // Header
            for (Employe employe : employes) {
                writer.write(employe.getIdentifiant() + "|" + employe.getNom() + "|" +
                        employe.getAdresse() + "|" + employe.getContact() + "|" +
                        employe.getNumeroEmploye() + "|" + employe.getDateEmbauche() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing Employes: " + e.getMessage());
        }
    }

    public static void ajouterEmploye(Employe employee) {
        if (employes.containsKey(employee.getIdentifiant())) {
            employes.put(employee.getIdentifiant(), employee);
            System.out.println("Employé " + employee.getIdentifiant() + " est bien ajouté");
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
            System.out.println("Informations de l'employé avec l'identifiant " + identifiant + " met à jour.");
        } else {
            System.out.println("Employé avec l'identifiant " + identifiant + " non trouvé.");
        }
    }

    public static void supprimerEmploye(String identifiant) {
        if (employes.containsKey(identifiant)) {
            employes.remove(identifiant);
            System.out.println("Employe " + identifiant + " est supprimé");
        } else {
            System.out.println("Erreur : l'employe n'existe pas");
        }
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Aeroport {
    private String code;
    private String nom;
    private String ville;
    private String description;

    //Gestion CRUD
    private static Map<String, Aeroport> aeroports = new HashMap<>();

    public Aeroport(String code, String nom, String ville, String description) {
        this.code = code;
        this.nom = nom;
        this.ville = ville;
        this.description = description;
        aeroports.put(nom, this);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
        aeroports.put(code, this);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
        aeroports.put(nom, this);
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
        aeroports.put(ville, this);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        aeroports.put(description, this);
    }

    public void affecterVol() {
        System.out.println(nom + " , " + ville + " , " + description);
    }

    public void afficherInfos() {
        System.out.println("\n ------ Informations de l'aeroport ---------");
        System.out.println("Code : " + code);
        System.out.println("Nom : " + nom);
        System.out.println("Ville : " + ville);
        System.out.println("Description : " + description);
    }

    public static List<Aeroport> readAeroportsFromFile(String filePath) {
        List<Aeroport> aeroports = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length == 4) {
                    Aeroport aeroport = new Aeroport(data[0], data[1], data[2], data[3]);
                    aeroport.setCode(data[0].trim());
                    aeroport.setNom(data[1].trim());
                    aeroport.setVille(data[2].trim());
                    aeroport.setDescription(data[3].trim());
                    aeroports.add(aeroport);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading Aeroports: " + e.getMessage());
        }
        return aeroports;
    }

    public static void writeAeroportsToFile(String filePath, List<Aeroport> aeroports) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("codeIATA|Nom|Ville|Description\n"); // Header
            for (Aeroport aeroport : aeroports) {
                writer.write(aeroport.getCode() + "|" + aeroport.getNom() + "|" +
                        aeroport.getVille() + "|" + aeroport.getDescription() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing Aeroports: " + e.getMessage());
        }
    }

    public static void ajouterAeroport(Aeroport aeroport) {
        if (aeroports.containsKey(aeroport.getNom())) {
            aeroports.put(aeroport.getNom(), aeroport);
            System.out.println("Aéroport " + aeroport.getNom() + " est bien ajouté");
        } else {
            System.out.println("Erreur : Un aeroport " + aeroport.getNom() + " existe déjà");
        }
    }

    public static Aeroport chercherAeroport(String nom) {
        if (aeroports.containsKey(nom)) {
            aeroports.get(nom).afficherInfos();
            return aeroports.get(nom);
        } else {
            System.out.println("Erreur : Aeroport n'existe pas");
            return null;
        }
    }

    public static void modifierAeroport(String nom, String nouveauNom, String nouvelleVille, String nouvelleDescription) {
        if (aeroports.containsKey(nom)) {
            Aeroport aeroportAModifier = aeroports.get(nom);
            aeroportAModifier.nom = nouveauNom;
            aeroportAModifier.ville = nouvelleVille;
            aeroportAModifier.description = nouvelleDescription;
            aeroports.put(nom, aeroportAModifier);
            System.out.println("Informations de la aeroport : " + nom + " met à jour");
        } else {
            System.out.println("Erreur : Aeroport n'existe pas");
        }
    }

    public static void supprimerAeroport(String nom) {
        if (aeroports.containsKey(nom)) {
            aeroports.remove(nom);
            System.out.println("Aéroport " + nom + " est supprimé");
        } else {
            System.out.println("Erreur : Aeroport n'existe pas");
        }
    }
}

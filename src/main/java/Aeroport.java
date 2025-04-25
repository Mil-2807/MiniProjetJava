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
        aeroports.put(code, this);
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

    public static void lireAeroports(String fichierCSV) {
        aeroports.clear();
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(fichierCSV))) {
            // Lire l'en-tête (si présent) et l'ignorer
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                if (data.length == 4) {
                    String code = data[0].trim();
                    String nom = data[1].trim();
                    String ville = data[2].trim();
                    String description = data[3].trim();
                    new Aeroport(code, nom, ville, description);
                } else {
                    System.err.println("Ligne CSV invalide : " + line);
                }
            }
            System.out.println("Les aéroports ont été chargés depuis le fichier CSV : " + fichierCSV);
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier CSV : " + e.getMessage());
        }
    }

    public static void ecrireAeroports(String fichierCSV) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichierCSV))) {
            // Écrire l'en-tête
            bw.write("Code,Nom,Ville,Description");
            bw.newLine();
            for (Aeroport aeroport : aeroports.values()) {
                bw.write(String.join(",", aeroport.getCode(), aeroport.getNom(), aeroport.getVille(), aeroport.getDescription()));
                bw.newLine();
            }
            System.out.println("Les aéroports ont été sauvegardés dans le fichier CSV : " + fichierCSV);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier CSV : " + e.getMessage());
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

    public static void modifierAeroport(String code, String nouveauCode, String nouveauNom, String nouvelleVille, String nouvelleDescription) {
        if (aeroports.containsKey(code)) {
            Aeroport aeroportAModifier = aeroports.get(code);
            aeroportAModifier.code = nouveauCode;
            aeroportAModifier.nom = nouveauNom;
            aeroportAModifier.ville = nouvelleVille;
            aeroportAModifier.description = nouvelleDescription;
            aeroports.put(code, aeroportAModifier);
            System.out.println("Informations de la aeroport : " + code + " met à jour");
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

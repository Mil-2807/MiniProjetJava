import java.util.HashMap;
import java.util.Map;

public class Aeroport {
    private String nom;
    private String ville;
    private String description;

    //Gestion CRUD
    private static Map<String, Aeroport> aeroports = new HashMap<>();

    public Aeroport(String nom, String ville, String description) {
        this.nom = nom;
        this.ville = ville;
        this.description = description;
        aeroports.put(nom, this);
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
        System.out.println("Nom : " + nom);
        System.out.println("Ville : " + ville);
        System.out.println("Description : " + description);
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

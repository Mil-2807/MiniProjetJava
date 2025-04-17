import java.util.HashMap;
import java.util.Map;

public class Avion {
    private String immatriculation;
    private String modele;
    private int capacite;
    private Vol volAffecte;

    // Gestion CRUD
    private static Map<String, Avion> avions = new HashMap<>();

    public Avion(String immatriculation, String modele, int capacite) {
        this.immatriculation = immatriculation;
        this.modele = modele;
        this.capacite = capacite;
        this.volAffecte = null;
        avions.put(immatriculation, this);
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
        avions.put(immatriculation, this);
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
        avions.put(modele, this);
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
        avions.put(this.immatriculation, this);
    }

    public void affecterVol() {
        System.out.println("L'avion " + immatriculation + " est affecté à un vol.");
        if (volAffecte != null) {
            System.out.println("Vol affecté : " + volAffecte.getNumeroVol());
        } else {
            System.out.println("Aucun vol affecté pour le moment.");
        }
    }

    public void verifierDisponible() {
        if (volAffecte == null) {
            System.out.println("L'avion " + immatriculation + " est disponible.");
        } else {
            System.out.println("L'avion " + immatriculation + " est actuellement affecté au vol " + volAffecte.getNumeroVol() + ".");
        }
    }

    public Vol getVolAffecte() {
        return volAffecte;
    }

    public void setVolAffecte(Vol volAffecte) {
        this.volAffecte = volAffecte;
        avions.put(this.immatriculation, this);
    }

    public void afficherInfos() {
        System.out.println("\n----- Informations de l'Avion : " + immatriculation + "-----------");
        System.out.println("Immatriculation: " + immatriculation);
        System.out.println("Modèle: " + modele);
        System.out.println("Capacité: " + capacite + " passagers");
        if (volAffecte != null) {
            System.out.println("Vol Affecté: " + volAffecte.getNumeroVol());
        } else {
            System.out.println("Vol Affecté: Aucun");
        }
    }

    public static void ajouterAvion(Avion avion) {
        if (avions.containsKey(avion.getImmatriculation())) {
            avions.put(avion.getImmatriculation(), avion);
            System.out.println("Avion " + avion.getImmatriculation() + " est bien ajouté.");
        } else {
            System.out.println("Erreur: Un avion " + avion.getImmatriculation() + " existe déjà.");
        }
    }

    public static Avion chercherAvion(String immatriculation) {
        if (avions.containsKey(immatriculation)) {
            avions.get(immatriculation).afficherInfos();
            return avions.get(immatriculation);
        } else {
            System.out.println("Avion " + immatriculation + " non trouvé.");
            return null;
        }
    }

    public static void modifierAvion(String immatriculation, String nouveauModele, int nouvelleCapacite) {
        if (avions.containsKey(immatriculation)) {
            Avion avionAModifier = avions.get(immatriculation);
            avionAModifier.modele = nouveauModele;
            avionAModifier.capacite = nouvelleCapacite;
            avions.put(immatriculation, avionAModifier);
            System.out.println("Informations de l'avion " + immatriculation + " met à jour.");
        } else {
            System.out.println("Avion " + immatriculation + " non trouvé.");
        }
    }

    public static void supprimerAvion(String immatriculation) {
        if (avions.containsKey(immatriculation)) {
            avions.remove(immatriculation);
            System.out.println("Avion " + immatriculation + " est supprimé.");
        } else {
            System.out.println("Avion " + immatriculation + " non trouvé.");
        }
    }
}

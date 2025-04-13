import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vol {
    private String numeroVol;
    private String origine;
    private String destination;
    private String dateHeureDepart;
    private String dateHeureArrivee;
    private String etat;
    private Pilote pilote;
    private PersonnelCabine personnelCabine;
    private Avion avion;
    private Aeroport aeroportDepart;
    private Aeroport aeroportArrivee;

    //Gestion CRUD
    private static Map<String, Vol> vols = new HashMap<>();

    public Vol(String numeroVol, String origine, String destination, String dateHeureDepart, String dateHeureArrivee, String etat) {
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.etat = etat;
        this.pilote = null;
        this.personnelCabine = null;
        this.avion = null;
        this.aeroportDepart = null;
        this.aeroportArrivee = null;
        vols.put(numeroVol, this);
    }

    public String getNumeroVol() {
        return numeroVol;
    }

    public void setNumeroVol(String numeroVol) {
        this.numeroVol = numeroVol;
        vols.put(this.numeroVol, this);
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
        vols.put(this.origine, this);
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
        vols.put(this.destination, this);
    }

    public String getDateHeureDepart() {
        return dateHeureDepart;
    }

    public void setDateHeureDepart(String dateHeureDepart) {
        this.dateHeureDepart = dateHeureDepart;
        vols.put(this.dateHeureDepart, this);
    }

    public String getDateHeureArrivee() {
        return dateHeureArrivee;
    }
    public void setDateHeureArrivee(String dateHeureArrivee) {
        this.dateHeureArrivee = dateHeureArrivee;
        vols.put(this.dateHeureArrivee, this);
    }
    public String getEtat() {
        return etat;
    }
    public void setEtat(String etat) {
        this.etat = etat;
        vols.put(this.etat, this);
    }

    public Pilote getPilote() {
        return pilote;
    }

    public void setPilote(Pilote pilote) {
        this.pilote = pilote;
        vols.put(this.numeroVol, this);
    }

    public PersonnelCabine getPersonnelCabine() {
        return personnelCabine;
    }

    public void setPersonnelCabine(PersonnelCabine personnelCabine) {
        this.personnelCabine = personnelCabine;
        vols.put(this.numeroVol, this);
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
        vols.put(this.numeroVol, this);
    }

    public Aeroport getAeroportDepart() {
        return aeroportDepart;
    }

    public void setAeroportDepart(Aeroport aeroportDepart) {
        this.aeroportDepart = aeroportDepart;
        vols.put(this.numeroVol, this);
    }

    public Aeroport getAeroportArrivee() {
        return aeroportArrivee;
    }

    public void setAeroportArrivee(Aeroport aeroportArrivee) {
        this.aeroportArrivee = aeroportArrivee;
        vols.put(this.numeroVol, this);
    }

    public void planifierVol() {
        System.out.println("Vol : " + numeroVol + "\nOrigine : " + origine + "\nDestination : " + destination);
    }

    public void annulerVol() {
        etat = "Annulé";
        vols.put(this.numeroVol, this);
        System.out.println("Vol : " + numeroVol + "\nOrigine : " + origine + "\nDestination : " + destination);
    }

    public void modifierVol(String nouvelleOrigine, String nouvelleDestination, String nouvelleDateHeureDepart, String nouvelleDateHeureArrivee, String nouvelEtat) {
        this.origine = nouvelleOrigine;
        this.destination = nouvelleDestination;
        this.dateHeureDepart = nouvelleDateHeureDepart;
        this.dateHeureArrivee = nouvelleDateHeureArrivee;
        this.etat = nouvelEtat;
        vols.put(this.numeroVol, this);
        System.out.println("Vol " + numeroVol + " modifié");
    }

    public void ListingPassager(List<Reservation> reservations) {
        System.out.println("Passager : " + numeroVol + "\nReservation List : " + reservations);
        boolean aucunePassager = true;
        for (Reservation reservation : reservations) {
            if (reservation.getVol() != null && reservation.getVol().getNumeroVol().equals(numeroVol)) {
                System.out.println(" - " + reservation.getPassager().getNom() + ", Identifiant : " + reservation.getPassager().getIdentifiant());
                aucunePassager = false;
            }
        }
        if (aucunePassager) {
            System.out.println("AUCUN PASSAGER");
        }
    }

    public void affecterEquipage(Pilote pilote, PersonnelCabine personnelCabine) {
        this.pilote = pilote;
        this.personnelCabine = personnelCabine;
        vols.put(this.numeroVol, this);
        System.out.println("Équipage affecté au vol " + numeroVol + ":");
        if (pilote != null) {
            System.out.println("- Pilote: " + pilote.getNom() + " (ID: " + pilote.getIdentifiant() + ")");
        }
        if (personnelCabine != null) {
            System.out.println("- Personnel de Cabine: " + personnelCabine.getNom() + " (ID: " + personnelCabine.getIdentifiant() + ")");
        }
    }

    public void affecterAvion(Avion avion) {
        this.avion = avion;
        vols.put(this.numeroVol, this);
        if (avion != null) {
            avion.setVolAffecte(this); // Informer l'avion de son vol affecté
        }
        System.out.println("Avion " + (avion != null ? avion.getImmatriculation() : "aucun") + " affecté au vol " + numeroVol);
    }
    public void obtenirVol() {
        System.out.println("--- Informations du Vol " + numeroVol + " ---");
        System.out.println("Numéro de Vol: " + numeroVol);
        System.out.println("Origine: " + origine);
        System.out.println("Destination: " + destination);
        System.out.println("Date/Heure Départ: " + dateHeureDepart);
        System.out.println("Date/Heure Arrivée: " + dateHeureArrivee);
        System.out.println("État: " + etat);
        if (pilote != null) {
            System.out.println("Pilote: " + pilote.getNom() + " (ID: " + pilote.getIdentifiant() + ")");
        }
        if (personnelCabine != null) {
            System.out.println("Personnel de Cabine: " + personnelCabine.getNom() + " (ID: " + personnelCabine.getIdentifiant() + ")");
        }
        if (avion != null) {
            System.out.println("Avion: " + avion.getImmatriculation() + " (" + avion.getModele() + ")");
        }
        if (aeroportDepart != null) {
            System.out.println("Aéroport de Départ: " + aeroportDepart.getNom() + " (" + aeroportDepart.getVille() + ")");
        }
        if (aeroportArrivee != null) {
            System.out.println("Aéroport d'Arrivée: " + aeroportArrivee.getNom() + " (" + aeroportArrivee.getVille() + ")");
        }
    }

    public void listerVol() {
        System.out.println(" --- Vol --- ");
        obtenirVol();
    }

    // Méthodes CRUD pour la classe Vol
    public static void ajouterVol(Vol vol) {
        if (!vols.containsKey(vol.getNumeroVol())) {
            vols.put(vol.getNumeroVol(), vol);
            System.out.println("Vol " + vol.getNumeroVol() + " ajouté.");
        } else {
            System.out.println("Erreur: Un vol avec le numéro " + vol.getNumeroVol() + " existe déjà.");
        }
    }

    public static Vol chercherVol(String numeroVol) {
        if (vols.containsKey(numeroVol)) {
            System.out.println("Informations du Vol " + numeroVol);
            vols.get(numeroVol).obtenirVol();
            return vols.get(numeroVol);
        } else {
            System.out.println("Vol avec le numéro " + numeroVol + " non trouvé.");
            return null;
        }
    }

    public static void modifierVol(String numeroVol, String nouvelleOrigine, String nouvelleDestination, String nouvelleDateHeureDepart, String nouvelleDateHeureArrivee, String nouvelEtat, Pilote nouveauPilote, PersonnelCabine nouveauPersonnelCabine, Avion nouvelAvion, Aeroport nouvelAeroportDepart, Aeroport nouvelAeroportArrivee) {
        if (vols.containsKey(numeroVol)) {
            Vol volAModifier = vols.get(numeroVol);
            volAModifier.origine = nouvelleOrigine;
            volAModifier.destination = nouvelleDestination;
            volAModifier.dateHeureDepart = nouvelleDateHeureDepart;
            volAModifier.dateHeureArrivee = nouvelleDateHeureArrivee;
            volAModifier.etat = nouvelEtat;
            volAModifier.pilote = nouveauPilote;
            volAModifier.personnelCabine = nouveauPersonnelCabine;
            volAModifier.avion = nouvelAvion;
            volAModifier.aeroportDepart = nouvelAeroportDepart;
            volAModifier.aeroportArrivee = nouvelAeroportArrivee;
            vols.put(numeroVol, volAModifier);
            System.out.println("Informations du vol " + numeroVol + " mises à jour.");
        } else {
            System.out.println("Vol avec le numéro " + numeroVol + " non trouvé.");
        }
    }

    public static void supprimerVol(String numeroVol) {
        if (vols.containsKey(numeroVol)) {
            vols.remove(numeroVol);
            System.out.println("Vol " + numeroVol + " supprimé.");
        } else {
            System.out.println("Vol avec le numéro " + numeroVol + " non trouvé.");
        }
    }

}

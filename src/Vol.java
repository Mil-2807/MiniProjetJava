import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

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
    private double prix;

    //Gestion CRUD
    private static Map<String, Vol> vols = new HashMap<>();

    public Vol(String numeroVol, String origine, String destination, String dateHeureDepart, String dateHeureArrivee, String etat, double prix) {
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
        this.prix = prix;
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void planifierVol() {
        System.out.println("Vol : " + numeroVol + "\nOrigine : " + origine + "\nDestination : " + destination);
    }

    public void annulerVol() {
        etat = "Annulé";
        vols.put(this.numeroVol, this);
        System.out.println("Vol : " + numeroVol + "\nOrigine : " + origine + "\nDestination : " + destination + "\nEtat :" + etat);
    }

    public void ListingPassager(List<Reservation> reservations) {
        System.out.println("\n --- Passager du vol : " + numeroVol + " ----- ");
        boolean aucunePassager = true;
        for (Reservation reservation : reservations) {
            if (reservation.getVol() != null && reservation.getVol().getNumeroVol().equals(numeroVol)) {
                Passager passager = reservation.getPassager();
                if (passager != null) {
                    System.out.println("- " + passager.getNom() + ", Identifiant : " + passager.getIdentifiant());
                    aucunePassager = false;
                } else {
                    System.out.println("- Passager inconnu pour cette réservation.");
                }
            }
        }
        if (aucunePassager) {
            System.out.println("Aucun passager réservé sur ce vol.");
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
        System.out.println("\n --- Informations du Vol " + numeroVol + " ---");
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
        System.out.println("Prix: " + prix + " €");
    }

    public void listerVol() {
        System.out.println("\n --- Vol --- ");
        obtenirVol();
    }

    // Méthodes CRUD pour la classe Vol
    public static void ajouterVol(Vol vol) {
        if (vols.containsKey(vol.getNumeroVol())) {
            vols.put(vol.getNumeroVol(), vol);
            System.out.println("Vol " + vol.getNumeroVol() + " est bien ajouté.");
        } else {
            System.out.println("Erreur: Un vol avec le numéro " + vol.getNumeroVol() + " existe déjà.");
        }
    }

    public static Vol chercherVol(String numeroVol) {
        if (vols.containsKey(numeroVol)) {
            vols.get(numeroVol).obtenirVol();
            return vols.get(numeroVol);
        } else {
            System.out.println("Vol avec le numéro " + numeroVol + " non trouvé.");
            return null;
        }
    }

    public static void modifierVol(String numeroVol, String nouvelleOrigine, String nouvelleDestination, String nouvelleDateHeureDepart, String nouvelleDateHeureArrivee, String nouvelEtat, double nouvellePrix, Pilote nouveauPilote, PersonnelCabine nouveauPersonnelCabine, Avion nouvelAvion, Aeroport nouvelAeroportDepart, Aeroport nouvelAeroportArrivee) {
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
            volAModifier.prix = nouvellePrix;
            vols.put(numeroVol, volAModifier);
            System.out.println("Informations du vol " + numeroVol + " met à jour.");
        } else {
            System.out.println("Vol avec le numéro " + numeroVol + " non trouvé.");
        }
    }

    public static void supprimerVol(String numeroVol) {
        if (vols.containsKey(numeroVol)) {
            vols.remove(numeroVol);
            System.out.println("Vol " + numeroVol + " est supprimé.");
        } else {
            System.out.println("Vol avec le numéro " + numeroVol + " non trouvé.");
        }
    }

    // Statistiques
    public static void listerTousLesVols() {
        System.out.println("\n----- Liste de Tous les Vols -----");
        int numero = 1;
        for (Map.Entry<String, Vol> entry : vols.entrySet()) {
            System.out.println(numero + ". Vol " + entry.getValue().getNumeroVol() + " (" +
                    entry.getValue().getOrigine() + " - " +
                    entry.getValue().getDestination() + ")");
            numero++;
        }
        if (vols.isEmpty()) {
            System.out.println("Aucun vol n'est actuellement enregistré ");
        }
        System.out.println("----------------------------------");
    }


    public static Map<String, Integer> getDestinationsPopulaires(List<Reservation> reservations) {
        Map<String, Integer> destinationCounts = new HashMap<>();
        for (Reservation reservation : reservations) {
            if (reservation.getVol() != null && reservation.getStatut().equalsIgnoreCase("Confirmée")) {
                String destination = reservation.getVol().getDestination();
                destinationCounts.put(destination, destinationCounts.getOrDefault(destination, 0) + 1);
            }
        }

        return destinationCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

}

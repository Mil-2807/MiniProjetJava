import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Reservation {
    private String numeroReservation;
    private String dateReservation;
    private String statut;
    private Passager passager;
    private Vol vol;

    //Gestion CRUD
    private static Map<String, Reservation> reservations = new HashMap<>();

    public Reservation(String numeroReservation, String dateReservation, String statut, Passager passager, Vol vol) {
        this.numeroReservation = numeroReservation;
        this.dateReservation = dateReservation;
        this.statut = statut;
        this.passager = passager;
        this.vol = vol;
        reservations.put(numeroReservation, this);
    }

    public static void lireReservations(String filePath, Map<String, Passager> passagersMap, Map<String, Vol> volsMap) {
        reservations.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String numeroReservation = data[0].trim();
                    String dateReservation = data[1].trim();
                    String statut = data[2].trim();
                    String passagerIdentifiant = data[3].trim();
                    String volNumero = data[4].trim();

                    Passager passager = passagersMap.get(passagerIdentifiant);
                    Vol vol = volsMap.get(volNumero);

                    if (passager != null && vol != null) {
                        new Reservation(numeroReservation, dateReservation, statut, passager, vol);
                    } else {
                        System.err.println("Erreur : Passager (ID: " + passagerIdentifiant + ") ou Vol (N°: " + volNumero + ") non trouvé pour la réservation : " + numeroReservation);
                    }
                } else {
                    System.err.println("Ligne invalide dans le fichier Reservation : " + line);
                }
            }
            System.out.println("Les réservations ont été chargées depuis le fichier : " + filePath);
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier Reservation : " + e.getMessage());
        }
    }

    public static void ecrireReservations(String fichierCSV) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichierCSV))) {
            writer.write("NumeroReservation,DateReservation,Statut,PassagerIdentifiant,VolNumero\n"); // Header
            for (Reservation reservation : reservations.values()) {
                String passagerIdentifiant = (reservation.getPassager() != null) ? reservation.getPassager().getIdentifiant() : ""; // Handle null Passager
                String volNumero = (reservation.getVol() != null) ? reservation.getVol().getNumeroVol() : ""; // Handle null Vol
                writer.write(reservation.getNumeroReservation() + "," + reservation.getDateReservation() + "," +
                        reservation.getStatut() + "," + passagerIdentifiant + "," + volNumero + "\n");
            }
            System.out.println("Les réservations ont été sauvegardés dans le fichier CSV : " + fichierCSV);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier Reservation : " + e.getMessage());
        }
    }

    public String getNumeroReservation() {
        return numeroReservation;
    }

    public void setNumeroReservation(String numeroReservation) {
        this.numeroReservation = numeroReservation;
        reservations.put(numeroReservation, this);
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
        reservations.put(this.dateReservation, this);
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
        reservations.put(this.statut, this);
    }

    public Passager getPassager() {
        return passager;
    }

    public void setPassager(Passager passager) {
        this.passager = passager;
        reservations.put(this.numeroReservation, this);
    }

    public Vol getVol() {
        return vol;
    }

    public void setVol(Vol vol) {
        this.vol = vol;
        reservations.put(this.numeroReservation, this);
    }

    public void confirmerReservation() {
        statut = "confirmée";
        reservations.put(this.numeroReservation, this);
        System.out.println("Réservation " + numeroReservation + " est " + statut);
    }

    public void annulerReservation() {
        statut = "annulée";
        reservations.put(this.numeroReservation, this);
        System.out.println("Réservation " + numeroReservation + " est " + statut);
    }

    public static void modifierReservation(String numeroReservation, String nouvelleDateReservation, String nouveauStatut, Passager nouveauPassager, Vol nouveauVol) {
        if (reservations.containsKey(numeroReservation)) {
            Reservation reservationAModifier = reservations.get(numeroReservation);
            reservationAModifier.dateReservation = nouvelleDateReservation;
            reservationAModifier.statut = nouveauStatut;
            reservationAModifier.passager = nouveauPassager;
            reservationAModifier.vol = nouveauVol;
            reservations.put(numeroReservation, reservationAModifier);
            System.out.println("Informations de la réservation N° " + numeroReservation + " met à jour.");
        } else {
            System.out.println("Réservation avec le numéro " + numeroReservation + " non trouvée.");
        }
    }

    public void afficherInfoReservation() {
        System.out.println("Numero de reservation: " + numeroReservation);
        System.out.println("Date: " + dateReservation);
        System.out.println("Statut: " + statut);
        if (passager != null) {
            System.out.println("Passager: " + passager.getNom() + " (ID : " + passager.getIdentifiant() + " )");
        } else {
            System.out.println("Passager : non identifié");
        }
        if (vol != null) {
            System.out.println("Vol: " + vol.getNumeroVol() + " , Origine : " + vol.getOrigine() + ", Destination : " + vol.getDestination());
        } else {
            System.out.println("Vol : non identifié");
        }
    }

    public static void ajouterReservation(Reservation reservation) {
        if (reservations.containsKey(reservation.getNumeroReservation())) {
            reservations.put(reservation.getNumeroReservation(), reservation);
            System.out.println("Réservation N° " + reservation.getNumeroReservation() + " est bien ajoutée.");
        } else {
            System.out.println("Erreur: Une réservation " + reservation.getNumeroReservation() + " existe déjà.");
        }
    }

    public static void chercherReservation(String numeroReservation) {
        if (reservations.containsKey(numeroReservation)) {
            System.out.println("\n ----- Informations de la Réservation N° " + numeroReservation + " ------");
            reservations.get(numeroReservation).afficherInfoReservation();
            reservations.get(numeroReservation);
        } else {
            System.out.println("Réservation N° " + numeroReservation + " non trouvée.");
        }
    }

    public static void supprimerReservation(String numeroReservation) {
        if (reservations.containsKey(numeroReservation)) {
            reservations.remove(numeroReservation);
            System.out.println("Réservation N° " + numeroReservation + " est supprimée.");
        } else {
            System.out.println("Réservation N° " + numeroReservation + " non trouvée.");
        }
    }

    // Méthode pour statistiques
    public static int getNombreTotalPassagers(List<Reservation> reservationsList) {
        return reservationsList.size();
    }

    public static double calculerRevenusTotaux(List<Reservation> reservationsList) {
        double revenus = 0;
        for (Reservation reservation : reservationsList) {
            if (reservation.getVol() != null && reservation.getStatut().equalsIgnoreCase("Confirmée")) {
                revenus += reservation.getVol().getPrix();
            }
        }
        return revenus;
    }
}

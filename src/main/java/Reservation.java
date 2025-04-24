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

    public static List<Reservation> readReservationsFromFile(String filePath, List<Passager> passagers, List<Vol> vols) {
        List<Reservation> reservations = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length == 5) {
                    Reservation reservation = new Reservation(data[0], data[1], data[2], passagers.get(Integer.parseInt(data[3])), vols.get(Integer.parseInt(data[4])));
                    reservation.setNumeroReservation(data[0].trim());
                    reservation.setDateReservation(data[1].trim());
                    reservation.setStatut(data[2].trim());
                    String passagerIdentifiant = data[3].trim();
                    Passager passager = findPassagerByIdentifiant(passagers, passagerIdentifiant);
                    reservation.setPassager(passager);
                    String volNumero = data[4].trim();
                    Vol vol = findVolByNumero(vols, volNumero);
                    reservation.setVol(vol);
                    reservations.add(reservation);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading Reservations: " + e.getMessage());
        }
        return reservations;
    }

    private static Passager findPassagerByIdentifiant(List<Passager> passagers, String identifiant) {
        for (Passager passager : passagers) {
            if (passager.getIdentifiant().equals(identifiant)) {
                return passager;
            }
        }
        return null; // Handle case where Passager is not found
    }

    private static Vol findVolByNumero(List<Vol> vols, String numero) {
        for (Vol vol : vols) {
            if (vol.getNumeroVol().equals(numero)) {
                return vol;
            }
        }
        return null; // Handle case where Vol is not found
    }

    public static void writeReservationsToFile(String filePath, List<Reservation> reservations) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("NumeroReservation|DateReservation|Statut|PassagerIdentifiant|VolNumero\n"); // Header
            for (Reservation reservation : reservations) {
                String passagerIdentifiant = (reservation.getPassager() != null) ? reservation.getPassager().getIdentifiant() : ""; // Handle null Passager
                String volNumero = (reservation.getVol() != null) ? reservation.getVol().getNumeroVol() : ""; // Handle null Vol
                writer.write(reservation.getNumeroReservation() + "|" + reservation.getDateReservation() + "|" +
                        reservation.getStatut() + "|" + passagerIdentifiant + "|" + volNumero + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing Reservations: " + e.getMessage());
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

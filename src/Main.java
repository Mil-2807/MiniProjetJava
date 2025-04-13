import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        // Création d'instances de Personnes (et leurs sous-classes)
        Pilote pilote1 = new Pilote("ECP511", "Milan Baskara", "15 rue des Champs-Elysées", "06 99 78 16 23", "EMP-ECP-511", "07-09-2015", "PPL-2024", 1250);
        PersonnelCabine cabine1 = new PersonnelCabine("CAB148", "Alice Bourjoin", "48 avenue de Pigalle", "06 54 24 58 58", "EMP-CAB-148", "30-04-2000", "CCA");
        PersonnelCabine cabine2 = new PersonnelCabine("CAB149", "Ousmann Mamadou", "88 Bouleavard de Jules Ferry", "06 15 15 44 71", "EMP-CAB-149","11-10-2010", "CCA confirmé");
        Passager passager1 = new Passager("PAS123", "Alice Dupont", "45 rue de la Paix", "06 45 16 86 00", "SX7810");
        Passager passager2 = new Passager("PAS456", "Jacques Bouleau", "5 rue de Verdun", "06 11 11 11 11", "JN5840");

        // Ajouter les personnes via leurs classes spécifiques
        Pilote.ajouterPilote(pilote1);
        PersonnelCabine.ajouterPersonnelCabine(cabine1);
        PersonnelCabine.ajouterPersonnelCabine(cabine2);
        Passager.ajouterPassager(passager1);
        Passager.ajouterPassager(passager2);

        // Création d'instances d'Avion
        Avion avion1 = new Avion("BO-485", "Boeing 737", 180);
        Avion avion2 = new Avion("AB-102", "Airbus A320", 150);
        Avion.ajouterAvion(avion1);
        Avion.ajouterAvion(avion2);

        // Création d'instances d'Aeroport
        Aeroport parisCDG = new Aeroport("Paris Charles de Gaulle", "Principal aéroport de Paris", "...");
        Aeroport niceCoteDAzur = new Aeroport("Nice Côte d'Azur", "Aéroport desservant la Côte d'Azur", "...");
        Aeroport.ajouterAeroport(parisCDG);
        Aeroport.ajouterAeroport(niceCoteDAzur);

        // Création d'instances de Vol
        Vol vol1 = new Vol("GB475", "Paris", "Nice", "2025-04-13 15:25", "2025-04-13 16:45", "Planifié");
        vol1.setAeroportDepart(parisCDG);
        vol1.setAeroportArrivee(niceCoteDAzur);
        Vol.ajouterVol(vol1);

        // Affecter un équipage et un avion au vol
        vol1.setPilote(pilote1);
        // Si un seul membre d'équipage :
        vol1.setPersonnelCabine(cabine1);
        // Si plusieurs membres d'équipage :
        // List<PersonnelCabine> equipageVol1 = new ArrayList<>();
        // equipageVol1.add(cabine1);
        // equipageVol1.add(cabine2);
        // vol1.setPersonnelCabine(equipageVol1);
        vol1.setAvion(avion1);

        // Un passager réserve un vol
        Reservation reservation1 = new Reservation("RES001", "2025-04-10", "En attente");
        Reservation.ajouterReservation(reservation1);
        reservations.add(reservation1);
        // Si vous aviez une méthode pour ajouter la réservation à la liste du passager :
        // passager1.ajouterReservation(reservation1);

        // Afficher les informations du vol
        Vol.chercherVol("GB475");

        // Afficher les informations de la réservation
        Reservation.chercherReservation("RES001");

        // Lister les passagers du vol
        vol1.ListingPassager(reservations);

        // Annuler une réservation
        Reservation.chercherReservation("RES001").setStatut("Annulée");

        // Tenter d'afficher à nouveau les informations de la réservation
        Reservation.chercherReservation("RES001");

        // Annuler le vol
        Vol.chercherVol("GB475").annulerVol();

        // Exemple de recherche d'une personne par son ID
        Personne personneTrouvee = Personne.chercherPersonne("ECP511");
        if (personneTrouvee != null) {
            System.out.println("Rôle de la personne trouvée : " + personneTrouvee.obtenirRole());
        }

        // Exemple de recherche d'un avion par son immatriculation
        Avion avionTrouve = Avion.chercherAvion("BO-485");
        if (avionTrouve != null) {
            avionTrouve.afficherInfos();
        }

        // Exemple de recherche d'un aéroport
        Aeroport aeroportTrouve = Aeroport.chercherAeroport("Paris Charles de Gaulle");
        if (aeroportTrouve != null) {
            aeroportTrouve.afficherInfos();
        }
    }
}
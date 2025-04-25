import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {

        //-------------------- Fichier .csv ---------------
        String pilotesFilePath = "C:\\Users\\milan\\OneDrive\\Documents\\Mini_Projet\\csv\\pilote.csv";
        String employesFilePath = "C:\\Users\\milan\\OneDrive\\Documents\\Mini_Projet\\csv\\employe.csv";
        String cabinesFilePath = "C:\\Users\\milan\\OneDrive\\Documents\\Mini_Projet\\csv\\personnelCabine.csv";
        String passagersFilePath = "C:\\Users\\milan\\OneDrive\\Documents\\Mini_Projet\\csv\\passager.csv";
        String avionsFilePath = "C:\\Users\\milan\\OneDrive\\Documents\\Mini_Projet\\csv\\avion.csv";
        String aeroportsFilePath = "C:\\Users\\milan\\OneDrive\\Documents\\Mini_Projet\\csv\\aeroport.csv";
        String volsFilePath = "C:\\Users\\milan\\OneDrive\\Documents\\Mini_Projet\\csv\\vol.csv";
        String reservationsFilePath = "C:\\Users\\milan\\OneDrive\\Documents\\Mini_Projet\\csv\\reservation.csv";

        Pilote.lirePilotes(pilotesFilePath);
        Employe.lireEmployes(employesFilePath);
        PersonnelCabine.lirePersonnelCabine(cabinesFilePath);
        Passager.lirePassagers(passagersFilePath);
        Avion.lireAvions(avionsFilePath);
        Aeroport.lireAeroports(aeroportsFilePath);
        Map<String, Avion> avions = new HashMap<>();
        Vol.lireVols(volsFilePath, avions); // Important: Pass the lists!
        Map<String, Vol> vols = new HashMap<>();
        Map<String, Passager> passagers = new HashMap<>();
        Reservation.lireReservations(reservationsFilePath, passagers, vols);

        System.out.println("----------- Méthode CRUD --------------");
        // ------------ Personnes (hérité Pilote et Passager et PersonnelCabine)  -------------------
        // Création d'instances de Personnes
        // Ajouter des personnes
        System.out.println("\n----------- Personnes ---------------");
        Pilote pilote1 = new Pilote("ECP511", "Milan Baskara", "15 rue des Champs-Elysées", "06 99 78 16 23", "EMP-ECP-511", "07-09-2015", "PPL-2024", 1250);
        Pilote.ajouterPilote(pilote1);
        Pilote.chercherPilote("ECP511");
        Pilote pilote_test = new Pilote("EMP018", "Sophie Maillé", "82 rue de Paris", "07 43 56 57 00", "EMP-PIL-018", "15-01-2019", "CPL-2022", 1300);
        Pilote.ajouterPilote(pilote_test);
        Pilote.chercherPilote("EMP018");
        Pilote pilote2 = new Pilote("ECP485", "Sophie Green", "98 avenue de la Marne", "07 89 12 11 95", "EMP-ECP-485", "15-01-2019", "PPL-2022", 1300);
        Pilote.ajouterPilote(pilote_test);
        Pilote.chercherPilote("ECP485");

        Employe employe1 = new Employe("EMP845", "Karim Elamrani", "18 Boulevard de la Seine", "07 45 11 25 48", "EMP-845", "18-02-2017");
        Employe.ajouterEmploye(employe1);
        Employe.chercherEmploye("EMP845");
        Employe employe_test = new Employe("EMP213", "Daniel Débré", "121 avenue de Voltaire", "06 45 88 00 02", "EMP-213", "31-08-2009");
        Employe.ajouterEmploye(employe_test);
        Employe.chercherEmploye("EMP213");
        Employe employe2 = new Employe("EMP111", "Arthur Fugard", "19 avenue de Division Leclerc", "06 06 12 51 02", "EMP-111", "14-10-2017");
        Employe.ajouterEmploye(employe2);
        Employe.chercherEmploye("EMP111");


        PersonnelCabine cabine1 = new PersonnelCabine("CAB148", "Alice Bourjoin", "48 avenue de Pigalle", "06 54 24 58 58", "EMP-CAB-148", "30-04-2000", "CCA");
        PersonnelCabine cabine2 = new PersonnelCabine("CAB149", "Ousmann Mamadou", "88 Bouleavard de Jules Ferry", "06 15 15 44 71", "EMP-CAB-149","11-10-2010", "CCA confirmé");
        PersonnelCabine.ajouterPersonnelCabine(cabine1);
        PersonnelCabine.chercherPersonnelCabine("CAB148");
        PersonnelCabine.ajouterPersonnelCabine(cabine2);
        PersonnelCabine.chercherPersonnelCabine("CAB149");

        Passager passager1 = new Passager("PAS123", "Alice Dupont", "45 rue de la Paix", "06 45 16 86 00", "SX7810");
        Passager passager2 = new Passager("PAS456", "Jacques Bouleau", "5 rue de Verdun", "06 11 11 11 11", "JN5840");
        Passager.ajouterPassager(passager1);
        Passager.chercherPassager("PAS123");
        Passager.ajouterPassager(passager2);
        Passager.chercherPassager("PAS456");
        Passager passager3 = new Passager("PAS789", "Jean Hernandez", "2 avenue de la Stade", "06 07 06 07 06", "DFG452");
        Passager.ajouterPassager(passager3);
        Passager.chercherPassager("PAS789");

        PersonnelCabine cabine_test = new PersonnelCabine("CAB541", "Laurent Fernandez ", "7 avenue de Stalingrad", "07 98 96 23 44", "EMP-CAB-541", "2018-05-20", "CCA confirmé");
        PersonnelCabine.ajouterPersonnelCabine(cabine_test);
        PersonnelCabine.chercherPersonnelCabine("CAB541");

        Passager passager_test = new Passager("PAS056", "Valetin Pasquier", "14 rue des Vanves", "07 15 85 00 63", "AZ9876");
        Passager.ajouterPassager(passager_test);
        Passager.chercherPassager("PAS056");

        // Modifier les personnes
        System.out.println(" --- Modification du Pilote ECP511 (Milan Baskara) ---");
        Pilote.modifierPilote("ECP511", "Milan Baskara", "210 avenue de la Stalingrad", "06 65 78 10 12", "01-03-20196", "EMP-ECP-511", "PPL-2026", 1650);
        Pilote.chercherPilote("ECP511");

        System.out.println(" --- Modification du Personnel Cabine CAB148 (Alice Bourjoin) ---");
        PersonnelCabine.modifierPersonnelCabine("CAB148", "Alice Bourjoin", "48 avenue de Pigalle", "07 22 20 74 78", "10-09-2015" , "EMP-CAB-148", "CCA senior");
        PersonnelCabine.chercherPersonnelCabine("CAB148");

        System.out.println(" --- Modification du Passager PAS123 (Alice Dupont-Martin) ---");
        Passager.modifierPassager("PAS123", "Alice Ferié", "8 rue de Paradis", "06 45 16 86 00", "PO7125");
        Passager.chercherPassager("PAS123");

        System.out.println(" --- Modification d'un Employé EMP845 (Karim Elamrani) ---");
        Employe.modifierEmploye("EMP845", "Karim Elamrani", "14 rue de la Station", "07 91 14 21 63","18-02-2017", "EMP-845");
        Employe.chercherEmploye("EMP845");

        System.out.println(" --- Modification d'un Employé EMP213 (Daniel Débré) ---");
        Employe.modifierEmploye("EMP213", "Daniel Débré", "21 boulevard de Solferino", "07 91 14 21 63","21-09-2021", "EMP-213");
        Employe.chercherEmploye("EMP213");

        // Supprimer les personnes
        String idPiloteSupprimer = "EMP018";
        Pilote.supprimerPilote(idPiloteSupprimer);
        Pilote.chercherPilote(idPiloteSupprimer);

        String idCabineSupprimer = "CAB541";
        PersonnelCabine.supprimerPersonnelCabine(idCabineSupprimer);
        PersonnelCabine.chercherPersonnelCabine(idCabineSupprimer);

        String idPassagerSupprimer = "PAS056";
        Passager.supprimerPassager(idPassagerSupprimer);
        Passager.chercherPassager(idPassagerSupprimer);

        String idEmployerSupprimer = "EMP213";
        Employe.supprimerEmploye(idEmployerSupprimer);
        Employe.chercherEmploye(idEmployerSupprimer);

        // ------------- Avion ----------------------
        // Création d'instances d'Avion
        System.out.println("\n---------- Avion -----------");
        Avion avion1 = new Avion("BO-485", "Boeing 737", 180);
        Avion avion2 = new Avion("AB-102", "Airbus A320", 150);
        Avion avion3 = new Avion("ERJ-170", "Embraer E170", 85);
        Avion.ajouterAvion(avion1);
        Avion.chercherAvion("BO-485");
        Avion.ajouterAvion(avion2);
        Avion.chercherAvion("AB-102");
        Avion.ajouterAvion(avion3);
        Avion.chercherAvion("ERJ-170");

        // Ajouter d'avion
        Avion avion_test = new Avion("ERJ-175", "Embraer E175", 76);
        Avion.ajouterAvion(avion_test);
        Avion.chercherAvion("ERJ-175");

        Avion avion4 = new Avion("CRJ-900", "Bombardier CRJ900", 90);
        Avion.ajouterAvion(avion4);
        Avion.chercherAvion("CRJ-900");

        // Modifier un avion
        System.out.println(" --- Modification de l'Avion BO-485 ---");
        Avion.modifierAvion("BO-485", "Boeing 737-900", 215);
        Avion.chercherAvion("BO-485");

        System.out.println(" --- Modification de l'Avion AB-102 ---");
        Avion.modifierAvion("AB-102", "Airbus A320neo", 180);
        Avion.chercherAvion("AB-102");

        // Supprimer un avion
        System.out.println(" --- Suppression de l'Avion ERJ-175 ---");
        Avion.supprimerAvion("ERJ-175");
        Avion.chercherAvion("ERJ-175");

        // ------------------- Aeroport --------------------------
        // Création d'instances d'Aeroport
        System.out.println("\n------- Aéroport ----------");
        Aeroport parisCDG = new Aeroport("CDG","Paris Charles de Gaulle", "Roissy", "Aeroport International de Charles de Gaules Terminal 1,2 et 3");
        Aeroport niceCoteDAzur = new Aeroport("NCA","Nice Côte d'Azur", "Nice", "Aéroport Côte d'Azur Terminal 1 et 2");
        Aeroport.ajouterAeroport(parisCDG);
        Aeroport.chercherAeroport("Paris Charles de Gaulle");
        Aeroport.ajouterAeroport(niceCoteDAzur);
        Aeroport.chercherAeroport("Nice Côte d'Azur");

        // Ajouter d'un aéroport
        Aeroport lyonSaintExupery = new Aeroport("LSE","Lyon Saint-Exupéry", "Lyon", "Aéroport de la région Rhône-Alpes");
        Aeroport orly = new Aeroport("PAO","Paris-Orly", "Orly", "un aéroport international situé à 10 km au sud de Paris");
        Aeroport.ajouterAeroport(lyonSaintExupery);
        Aeroport.ajouterAeroport(orly);
        Aeroport.chercherAeroport("Lyon Saint-Exupéry");
        Aeroport.chercherAeroport("Paris-Orly");

        // Modifier d'un aéroport
        Aeroport.modifierAeroport("PAO","TOU", "Toulouse-Blagnac", "Toulouse", "Aeroport national de Toulouse");
        System.out.println(" --- Modification de l'Aéroport ---");
        Aeroport.chercherAeroport("Toulouse-Blagnac");

        // Supprimer d'un aéroport
        System.out.println(" --- Suppression de l'Aéroport ---");
        Aeroport.supprimerAeroport("Toulouse-Blagnac");
        Aeroport.chercherAeroport("Toulouse-Blagnac");

        // -------------- Vol --------------------
        // Création d'instances de Vol
        System.out.println("\n---------- Vol -------------");
        Vol vol1 = new Vol("GB475", "Paris", "Nice", "13-04-2025 15:25", "13-04-2025 16:45", "Planifié", 550.50);
        vol1.setAeroportDepart(parisCDG);
        vol1.setAeroportArrivee(niceCoteDAzur);
        Vol.ajouterVol(vol1);
        Vol.chercherVol("GB475");

        // --- Ajouter un vol ------------
        Aeroport londresHeathrow = new Aeroport("LOH","London Heathrow", "Londres", "Principal aéroport de Londres");
        Aeroport.ajouterAeroport(londresHeathrow);
        Aeroport madrid = new Aeroport("EMA", "Adolfo-Suarez Madrid-Barajas", "Madrid", "Aeroport classé 15e aéroport mondiale et 5e en Europe, situé à 13 km au nord-est du centre de Madrid");
        Aeroport.ajouterAeroport(madrid);
        Vol vol2 = new Vol("AF104", "Paris", "Lyon", "10-04-2025 09:00", "10-04-2025 09:30", "Planifié", 415.75);
        vol2.setAeroportDepart(parisCDG);
        vol2.setAeroportArrivee(madrid);
        Vol.ajouterVol(vol2);
        Vol.chercherVol("AF104");

        Vol vol3 = new Vol("MD896", "Paris", "Madrid", "01-04-2025 12:30", "01-04-2025 13:15", "Planifié", 490.00);
        vol1.setAeroportDepart(parisCDG);
        vol1.setAeroportArrivee(madrid);
        Vol.ajouterVol(vol1);
        Vol.chercherVol("GB475");

        Vol vol_test = new Vol("BA308", "Lyon", "Londres", "12-04-2025 11:00", "12-04-2025 14:00", "Annulé", 695.75);
        vol_test.setAeroportDepart(lyonSaintExupery);
        vol_test.setAeroportArrivee(londresHeathrow);
        Vol.ajouterVol(vol_test);
        Vol.chercherVol("BA308");

        // Modifier le vol
        System.out.println(" --- Modification du Vol GB475 ---");
        Vol.modifierVol("GB475", "Paris", "Nice", "13-04-2025 16:00", "13-04-2025 17:15", "Retard", 450.00, Pilote.chercherPilote("ECP511"), PersonnelCabine.chercherPersonnelCabine("CAB148"), Avion.chercherAvion("BO-485"), Aeroport.chercherAeroport("CDG"), Aeroport.chercherAeroport("NCE"));
        Vol.chercherVol("GB475");

        System.out.println(" --- Modification du Vol AF104 ---");
        Vol.modifierVol("AF104", "Paris", "Londres", "17-04-2025 09:30", "17-04-2025 10:00", "À l'heure", 685.75, Vol.chercherVol("AF104").getPilote(), Vol.chercherVol("AF104").getPersonnelCabine(), Vol.chercherVol("AF104").getAvion(), Vol.chercherVol("AF104").getAeroportDepart(), Aeroport.chercherAeroport("Londres Heathrow"));
        Vol.chercherVol("AF104");

        //---- Supprimer le vol --------------
        System.out.println("\n--- Suppression du Vol BA308 ---");
        Vol.supprimerVol("BA308");
        Vol.chercherVol("BA308");

        // Affecter un équipage et un avion au vol
        vol1.setPilote(pilote1);
        vol1.setPersonnelCabine(cabine1);
        vol2.setPilote(pilote1);
        vol2.setPersonnelCabine(cabine1);
        vol3.setPilote(pilote2);
        vol3.setPersonnelCabine(cabine2);

        // Un passager réserve un vol
        System.out.println("\n-------- Réservation ----------");
        Reservation reservation1 = new Reservation("RES001", "10-03-2025", "En attente", passager1, vol1);
        Reservation.ajouterReservation(reservation1);
        reservations.add(reservation1);

        // ---- Ajouter la réservation --------------
        Reservation reservation2 = new Reservation("RES002", "18-03-2025", "En attente", passager2, vol2);
        Reservation.ajouterReservation(reservation2);
        reservations.add(reservation2);
        Reservation.chercherReservation("RES002");

        Reservation reservation3 = new Reservation("RES003", "19-03-2025", "En attente", passager3, vol3);
        Reservation.ajouterReservation(reservation3);
        reservations.add(reservation3);
        Reservation.chercherReservation("RES002");

        Passager passager4 = new Passager("PAS012", "Pierre Martin", "5 avenue Hugo", "07 11 22 33 44", "WX5678");
        Passager.ajouterPassager(passager4);
        Vol.chercherVol("GB475"); // Assurez-vous qu'il existe

        Reservation reservation_test = new Reservation("RES003", "16-03-2025", "Confirmée", passager4, vol2);
        Reservation.ajouterReservation(reservation_test);
        reservations.add(reservation_test);
        System.out.println("Réservation ajoutée : " + reservation_test.getNumeroReservation() + " (Passager: " + reservation_test.getPassager().getNom() + ", Vol: " + (reservation_test.getVol() != null ? reservation_test.getVol().getNumeroVol() : "null") + ")");
        Reservation.chercherReservation("RES003");

        // ----- Modifier la réservation -----------
        System.out.println("\n--- Modification de la Réservation RES002 ---");
        Reservation.modifierReservation("RES002","18-03-2025", "Confirmée", passager4, vol1);
        Reservation.chercherReservation("RES002");

        System.out.println("\n--- Modification de la Réservation RES001 ---");
        Reservation.modifierReservation("RES001","10-03-2025", "Retard", passager2, vol2);
        Reservation.chercherReservation("RES001");

        // --- Suppression de Resrvation --------------
        System.out.println("\n--- Suppression de la Réservation RES003 ---");
        Reservation.supprimerReservation("RES003");
        reservations.removeIf(reservation -> reservation.getNumeroReservation().equals("RES003"));
        Reservation.chercherReservation("RES003"); // Tentative de recherche après suppression


        System.out.println(" \n------ Main ---------");
        System.out.println("\n ------ Reservations des personnes ---------");

        // Affecter un vol
        System.out.println("Aeroport : ");
        parisCDG.affecterVol();

        // Affecter un équipage et un avion au vol
        vol1.setPilote(pilote1);
        vol1.affecterEquipage(pilote1,cabine1);
        avion1.affecterVol();
        vol1.affecterAvion(avion1);

        vol2.setPilote(pilote2);
        vol2.affecterEquipage(pilote1,cabine1);
        avion2.affecterVol();
        vol2.affecterAvion(avion2);

        vol3.setPilote(pilote2);
        vol3.affecterEquipage(pilote2,cabine2);
        avion3.affecterVol();
        vol3.affecterAvion(avion3);

        // Si un seul membre d'équipage :
        vol1.setPersonnelCabine(cabine1);

        // Afficher les informations du vol
        Vol.chercherVol("GB475");

        // Afficher les informations de la réservation
        Reservation.chercherReservation("RES001");

        // Lister les passagers du vol
        vol1.ListingPassager(reservations);

        // Lister un vol
        System.out.println("\n --- Liste de Vol ---");
        vol1.listerVol();
        vol2.listerVol();
        vol3.listerVol();

        // Planifier du vol
        System.out.println("\n--- Planifié du vol ----");
        vol1.planifierVol();
        vol2.planifierVol();
        vol3.planifierVol();

        // Annuler une réservation
        System.out.println("--- Annulation de la réservation ---");
        reservation1.annulerReservation();
        Reservation.chercherReservation("RES001");

        // Confirmée la réservation
        System.out.println("--- Confirmation de la réservation ---");
        reservation2.confirmerReservation();
        Reservation.chercherReservation("RES002");

        // Annuler le vol
        Vol volAnnuler = Vol.chercherVol(vol1.getNumeroVol());
        if (volAnnuler != null) {
            volAnnuler.annulerVol();
        } else {
            System.out.println("Erreur : Vol non trouvé.");
        }

        // Vous pouvez ensuite vérifier l'état du vol si nécessaire
        Vol volVerifie = Vol.chercherVol("GB475");
        if (volVerifie != null) {
            System.out.println("État du vol GB475 après l'annulation : " + volVerifie.getEtat());
        }

        // Avion : verifie la disponibilité
        System.out.println(" ---- Verification de la disponibilité -----");
        avion1.verifierDisponible();
        avion2.verifierDisponible();
        avion3.verifierDisponible();
        avion4.verifierDisponible();

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

        System.out.println( "\n------ Bonus ---------------");
        // Affichage des statistiques et rapports
        System.out.println("\n----- Statistiques et Rapports -----");
        System.out.println("Nombre total de vols planifiés : " );
        Vol.listerTousLesVols();
        System.out.println("Nombre total de passagers transportés : " + Reservation.getNombreTotalPassagers(reservations));
        System.out.println("Revenus totaux générés (pour les vols confirmés) : " + Reservation.calculerRevenusTotaux(reservations) + " €");

        Map<String, Integer> destinationsPopulaires = Vol.getDestinationsPopulaires(reservations);
        System.out.println("\nDestinations les plus populaires :");
        int count = 0;
        for (Map.Entry<String, Integer> entry : destinationsPopulaires.entrySet()) {
            System.out.println("- " + entry.getKey() + " : " + entry.getValue() + " réservations");
            count++;
            if (count >= 5) {
                break;
            }
        }

        Pilote.ecrirePilotes(pilotesFilePath);
        Employe.ecrireEmployes(employesFilePath);
        PersonnelCabine.ecrirePersonnelCabine(cabinesFilePath);
        Passager.ecrirePassagers(passagersFilePath);
        Avion.ecrireAvions(avionsFilePath);
        Aeroport.ecrireAeroports(aeroportsFilePath);
        Vol.ecrireVols(volsFilePath);
        Reservation.ecrireReservations(reservationsFilePath);

    }
}
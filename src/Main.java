import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Pilote pilote1 = new Pilote("ECP511", "Milan Baskara", "15 rue des Champs-Elysées", "06 99 78 16 23", "EMP-ECP-511", new Date(), "PPL-2024", 1250);
        PersonnelCabine cabine1 = new PersonnelCabine("CAB148", "Alice Bourjoin", "48 avenue de Pigalle", "06 54 24 58 58", "EMP-CAB-148", new Date(), "CCA");
        PersonnelCabine cabine2 = new PersonnelCabine("CAB149", "Ousmann Mamadou", "88 Bouleavard de Jules Ferry", "06 15 15 44 71", "EMP-CAB-149",  new Date(), "CCA confirmé");
        Passager passager1 = new Passager("PAS123", "Alice Dupont", "45 rue de la Paix", "06 45 16 86 00", "SX7810");
        Passager passager2 = new Passager("PAS456", "Jacques Bouleau", "5 rue de Verdun", "06 11 11 11 11", "JN5840");


        Avion avion1 = new Avion("BO-485", "Boeing 737", 180);
        Avion avion2 = new Avion("AB-102", "Airbus A320", 150);

        Aeroport parisCDG = new Aeroport("CDG", "Paris Charles de Gaulle", "Principal aéroport de Paris");
        Aeroport niceCoteDAzur = new Aeroport("NCE", "Nice Côte d'Azur", "Aéroport desservant la Côte d'Azur");

        Vol vol1 = new Vol("GB475", "Paris", "Nice", "21-01-2024 15:25", "21-01-2024 15:45", "Planifié");
    }
}
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AeroportTest {

    @Test
    void testConstructeurEtGetters() {
        Aeroport aeroport = new Aeroport("CDG", "Paris Charles de Gaulle", "Roissy", "Description de CDG");
        assertEquals("CDG", aeroport.getCode());
        assertEquals("Paris Charles de Gaulle", aeroport.getNom());
        assertEquals("Roissy", aeroport.getVille());
        assertEquals("Description de CDG", aeroport.getDescription());
    }

    @Test
    void testSetters() {
        Aeroport aeroport = new Aeroport("CDG", "Paris Charles de Gaulle", "Roissy", "Description de CDG");
        aeroport.setNom("Aéroport de Paris-Charles de Gaulle");
        aeroport.setVille("Paris");
        aeroport.setDescription("Nouvelle description");
        assertEquals("Aéroport de Paris-Charles de Gaulle", aeroport.getNom());
        assertEquals("Paris", aeroport.getVille());
        assertEquals("Nouvelle description", aeroport.getDescription());
    }

    @Test
    void affecterVol() {
        Aeroport aeroportTest1 = new Aeroport("NYC", "Aéroport John F. Kennedy", "New York", "un aéroport international américain desservant New York et sa région");
        aeroportTest1.affecterVol();
        assertEquals("Aéroport John F. Kennedy", aeroportTest1.getNom());
    }

    @Test
    void afficherInfos() {
        Aeroport aeroportTest2 = new Aeroport("BBR", "Aéroport Willy-Brandt de Berlin-Brandebourg", "Berlin", "l'aéroport international de Berlin, situé à la frontière sud de la ville, sur la commune de Schönefeld dans le Land de Brandebourg");
        aeroportTest2.afficherInfos();
        assertEquals("BBR", aeroportTest2.getCode());
    }
}
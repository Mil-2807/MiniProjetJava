import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyJDBC {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/compagnie?serverTimezone=Europe/Paris";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "milan28";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL JDBC driver
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC driver not found", e);
        }
    }

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            System.out.println("Successfully connected to MySQL database!");

            // Exemple d'exécution d'une requête SELECT et d'affichage des résultats
            String selectSql = "SELECT idaeroport, code, nom, ville, description FROM Aeroport";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectSql)) {

                System.out.println("\nListe des aéroports:");
                while (resultSet.next()) {
                    int id = resultSet.getInt("idaeroport");
                    String code = resultSet.getString("code");
                    String nom = resultSet.getString("nom");
                    String ville = resultSet.getString("ville");
                    String description = resultSet.getString("description");
                    System.out.println("ID: " + id + ", Code: " + code + ", Nom: " + nom + ", Ville: " + ville + " Description : " + description);
                }

            } catch (SQLException e) {
                System.err.println("Erreur lors de l'exécution de la requête SELECT: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.err.println("Error connecting to MySQL database: " + e.getMessage());
        }
    }
}
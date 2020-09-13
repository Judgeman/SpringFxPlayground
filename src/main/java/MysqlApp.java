import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlApp {

    Connection conn;
    Statement stmt;

    // Verbinden und neue Datenbank erstellen wenn nicht vorhanden ist
    public void H2Connect(){
        try {
            Class.forName("org.h2.Driver");
            String url = "jdbc:h2:./PlayGround.db";
            String name = "sa";
            String pass = "";
            conn = DriverManager.getConnection(url, name, pass);
            System.out.println("Verbindung erfolgreich hergestellt");
        } catch (Exception e) {
            System.err.println(getClass().getName() +":"+ e.getMessage());
            System.exit(0);
        }
    }

    // neue Tabelle erstellen
    public void createTable(){
        try {
            stmt = conn.createStatement();
            String sql = "CREATE TABLE user"+
                    " (id INTEGER PRIMARY KEY AUTO_INCREMENT, "+
                    "datum DATETIME NOT NULL, "+
                    "name CHAR(25) NOT NULL, "+
                    "pass CHAR(25) NOT NULL, "+
                    "rolle CHAR(25) NOT NULL)";
            stmt.executeUpdate(sql);
            System.out.println("Tabelle erfolgreich angelegt");
        } catch (Exception e) {
            System.err.println(getClass().getName() +":"+ e.getMessage());
            System.exit(0);
        }
    }

}

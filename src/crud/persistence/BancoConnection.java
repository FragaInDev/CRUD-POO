package crud.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoConnection {
    public static final String URL = "jdbc:mariadb://localhost:3306/clinica";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    public static void main(String[] args) throws ClassNotFoundException{
        Class.forName("org.mariadb.jdbc.Driver");
        System.out.println("Classe carregada");

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)){
            System.out.println("Conectado ao Banco de Dados");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

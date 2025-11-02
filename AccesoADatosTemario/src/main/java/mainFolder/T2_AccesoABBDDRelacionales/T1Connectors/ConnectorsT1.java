package mainFolder.T2_AccesoABBDDRelacionales.T1Connectors;

import java.sql.*;

public class ConnectorsT1 {

    public static void main(String[] args) {

        String user = "Nacho";
        String password = "123456";
        String url = "jdbc:postgresql://localhost:5432/InstitutoFP";

        try (final Connection connection =
                     DriverManager.getConnection(url, user, password)){

            System.out.println(connection.getCatalog());

            Statement stmt = connection.createStatement();

            String q1 = "UPDATE asignaturas SET nombre = 'LENGUAJE DE MARCAS'" +
                    "WHERE nombre = 'lenguaje de marcas'";

            int x = stmt.executeUpdate(q1);

        }catch (SQLException e){
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }

    }

}

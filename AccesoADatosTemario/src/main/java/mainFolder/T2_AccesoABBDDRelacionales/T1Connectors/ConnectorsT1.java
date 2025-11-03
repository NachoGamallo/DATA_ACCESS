package mainFolder.T2_AccesoABBDDRelacionales.T1Connectors;

import java.sql.*;

public class ConnectorsT1 {

    public static void main(String[] args) {

        String user = "Nacho";
        String password = "123456";
        String url = "jdbc:postgresql://localhost:5432/InstitutoFP";

        //Ex 1 : 1. En el método main, conecta con la base de datos de tres formas diferentes, es
        //decir, construyendo el objeto Connection de tres maneras distintas.
        //Muestra un mensaje confirmando si la conexión fue exitosa.

        //Connection 1
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password)){

            System.out.println(connection.getCatalog() + ", conexión 1");


        }catch (SQLException e){
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }

        //Connection 2
        try (final Connection connection2 =
                     DriverManager.getConnection(url, user, password)){

            System.out.println(connection2.getCatalog() + ", conexión 2");


        }catch (SQLException e){
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }

        //Connection 3
        try (final Connection connection3 =
                     DriverManager.getConnection(url, user, password)){

            System.out.println(connection3.getCatalog() + ", conexión 3");


        }catch (SQLException e){
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }

        //2. Si quisiéramos conectar con una base de datos Oracle, ¿qué pasos deberíamos
        //cambiar? Añade código también.

        Connection con = null;

        try {

            String urlOracle = "jdbc:oracle:thin:@localhost:1521:XE";
            String userOracle = "usuario";
            String passwordOracle = "clave";

            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión a Oracle exitosa: " + con.getCatalog());

        } catch (SQLException e) {

            System.out.println("Error al conectar: " + e);

        }

    }

}

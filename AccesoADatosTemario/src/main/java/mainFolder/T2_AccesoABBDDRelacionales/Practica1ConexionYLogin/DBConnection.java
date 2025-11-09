package mainFolder.T2_AccesoABBDDRelacionales.Practica1ConexionYLogin;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class DBConnection {

    static Properties propBBDD = new Properties();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        generateConfigFile.loadProperties();
        propBBDD = generateConfigFile.prop;

        String server = propBBDD.getProperty("db.url");
        String user = propBBDD.getProperty("db.user");
        String password = propBBDD.getProperty("db.password");

        String localUser;
        String localPassword;

        try (Connection con = DriverManager.getConnection(server,user,password)){

            String [] paramsToPass = {server,user,password};

            System.out.println("Buenos días has ingresado a la base de datos de practicas:");
            System.out.println("============================================================");

            System.out.println("Ingresa el usuario: ");
            localUser = sc.next();
            System.out.println("Ingresa la cotraseña: ");
            localPassword = sc.next();

            if (checkUser(con,localUser,localPassword)){

                System.out.println("Inicio de sesion correcto");
                afterLogIn.run(paramsToPass, getIdFromUser(con,localUser,localPassword));

            }else {

                System.out.println("Usuario o contaseña incorrectos.");

            }


        }catch (SQLException e){

            System.out.println("SQL Exception: " + e.getMessage());
            System.out.println("State BBDD: " + e.getSQLState());
            System.out.println("ERROR: " + e.getErrorCode());

        }

    }

    public static boolean checkUser(Connection con, String user, String password) throws SQLException {

        String query = "SELECT * FROM usuarios WHERE nombre = ? AND password = ?";
        PreparedStatement select = con.prepareStatement(query);
        select.setString(1,user);
        select.setString(2,password);
        ResultSet resultSelect = select.executeQuery();

        return resultSelect.next();

    }

    //Agregado para la ampliacion, vamos a pasar el id del usuario.
    public static int getIdFromUser(Connection con , String user, String password) throws SQLException{

        String query = "SELECT id FROM usuarios WHERE nombre = ? AND password = ?";
        PreparedStatement select = con.prepareStatement(query);
        select.setString(1,user);
        select.setString(2,password);
        ResultSet resultSet = select.executeQuery();

        if (resultSet.next()){

            return resultSet.getInt("id");

        }else {

            throw new SQLException("No se encotro el usuario en bbdd");

        }

    }

}

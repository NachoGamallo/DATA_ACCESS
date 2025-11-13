package mainFolder.T2_AccesoABBDDRelacionales.EjercicioRepasoU2;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class appMoviles {

    static Properties propertiesBBDD = new Properties();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        generateConfigFile.loadProperties();
        propertiesBBDD = generateConfigFile.pr;
        String option;


        try (Connection conn = DriverManager.getConnection(propertiesBBDD.getProperty("db.url"),
                propertiesBBDD.getProperty("db.user"),
                propertiesBBDD.getProperty("db.password"))){

            conn.setAutoCommit(false);

            do {

                menu();
                System.out.println("Introduce una opción:");
                option = sc.next();

                try {

                    userOption(option,conn);
                    conn.commit();

                }catch (SQLException e2){

                    conn.rollback();
                    System.out.println("Error, revertiendo errores.");

                }

            }while (!option.equals("8"));


        }catch (SQLException e){

            System.out.println("Mensaje de error: " + e.getMessage());
            System.out.println("Estado SQL: " + e.getSQLState());
            System.out.println("Error code: " + e.getErrorCode());

        }

    }

    private static void menu(){

        System.out.println("-- AP STORE MANAGER --");
        System.out.println("1. Añadir nueva app");
        System.out.println("2. Listar todas las apps");
        System.out.println("3. Modificar app existente");
        System.out.println("4. Eliminar app por ID");
        System.out.println("5. Buscar app por nombre");
        System.out.println("6. Borrar todas las apps");
        System.out.println("7. Mostrar ranking por valoración");
        System.out.println("8. Salir");

    }

    private static void userOption(String option, Connection con) throws SQLException{

        switch (option){

            case "1" -> addNewApp(con);
            case "2" -> listAllApps(con);
            case "3" -> modifyAppRow(con);
            case "4" -> deleteRow(con);
            case "5" -> searchByName(con);
            case "6" -> deleteAllRows(con);
            case "7" -> orderByValoration(con);
            case "8" -> System.out.println("Saliendo del programa...");
            default -> System.out.println("Has introducido una opcion no válida...");

        }

    }

    private static boolean listPerID(Connection con, int id) throws SQLException{

        String query = "SELECT * FROM app WHERE id = ?";
        PreparedStatement select = con.prepareStatement(query);
        select.setInt(1,id);
        ResultSet resultSet = select.executeQuery();

        return resultSet.next();

    }
    private static void addNewApp(Connection con) throws SQLException{

        String query = "INSERT INTO app (nombre,desarrollador,categoria,descargas,valoracion,fecha_publicacion) " +
                "VALUES (?,?,?,?,?,now())";

        PreparedStatement select = con.prepareStatement(query);

        System.out.println("Introduce el nombre:");
        String nombre = sc.next();
        System.out.println("Introduce el desarrollador:");
        String desarrollador = sc.next();
        System.out.println("Introduce el categoria:");
        String categoria = sc.next();
        System.out.println("Introduce el descargas:");
        int descargas = sc.nextInt();
        System.out.println("Introduce el valoración:");
        double valoracion = sc.nextDouble();

        if (valoracion < 0.0 || valoracion > 5.0) throw new SQLException();

        select.setString(1,nombre);
        select.setString(2,desarrollador);
        select.setString(3,categoria);
        select.setInt(4,descargas);
        select.setDouble(5,valoracion);
        select.executeUpdate();

    }
    private static void listAllApps(Connection con)throws SQLException{

        String query = "SELECT * FROM app ORDER BY id";
        PreparedStatement select = con.prepareStatement(query);
        ResultSet resultSet = select.executeQuery();

        int temp = 0;

        while (resultSet.next()){

            System.out.println("ID: " + resultSet.getString("id") +
                    "; NOMBRE: " + resultSet.getString("nombre") +
                    "; DESARROLLADOR: " + resultSet.getString("desarrollador") +
                    "; CATEGORIA: " + resultSet.getString("categoria") +
                    "; DESCARGAS: " + resultSet.getInt("descargas") +
                    "; VALORACION: " + resultSet.getDouble("valoracion") +
                    "; FECHA: " + resultSet.getDate("fecha_publicacion"));
            temp++;

        }

        if (temp == 0) System.out.println("No hay datos en la tabla...");
    }
    private static void modifyAppRow(Connection con)throws SQLException{

        listAllApps(con);
        System.out.println("Introduce la linea (id) a modificar: ");
        int id = sc.nextInt();

        if (listPerID(con,id)){

            System.out.println("Introduce la categoria a modificar (nombre,desarrollador,categoria,descargas,valoracion):");
            String columnToModify = sc.next();
            System.out.println("Introduce el nuevo valor:");
            String newValue = sc.next();
            modifyParam(con,columnToModify,newValue,id);


        }else {

            System.out.println("La id introducida no existe...");

        }


    }
    private static void modifyParam(Connection con, String columToModify , String newValue, int idToModify)throws SQLException{

        String query = "UPDATE app SET " + columToModify + " = ? WHERE id = ?";
        PreparedStatement update = con.prepareStatement(query);

        switch (columToModify){

            case "nombre","desarrollador","categoria" -> update.setString(1,newValue);
            case "descargas" -> update.setInt(1,Integer.parseInt(newValue));
            case "valoracion" -> update.setDouble(1, Double.parseDouble(newValue));
            default -> {

                System.out.println("Has introducido una columna no permitida, abortando...");
                throw new SQLException();

            }

        }

        update.setInt(2,idToModify);
        update.executeUpdate();

    }
    private static void deleteRow(Connection con)throws SQLException{

        listAllApps(con);
        System.out.println("Selecciona la linea (id) a eliminar:");
        int id = sc.nextInt();

        if (listPerID(con,id)){

            String query = "DELETE FROM app WHERE id = ?";
            PreparedStatement delete = con.prepareStatement(query);
            delete.setInt(1,id);
            delete.executeUpdate();

        }else {

            System.out.println("Esa id no existe...");

        }

    }
    private static void searchByName(Connection con)throws SQLException{

        System.out.println("Introduce el nombre a buscar: ");
        String name = sc.next();

        String query = "SELECT * FROM app WHERE nombre ILIKE ? ORDER BY id";
        PreparedStatement select = con.prepareStatement(query);
        select.setString(1,"%" + name + "%");
        ResultSet resultSet = select.executeQuery();

        int temp = 0;

        while (resultSet.next()){

            System.out.println("ID: " + resultSet.getString("id") +
                    "; NOMBRE: " + resultSet.getString("nombre") +
                    "; DESARROLLADOR: " + resultSet.getString("desarrollador") +
                    "; CATEGORIA: " + resultSet.getString("categoria") +
                    "; DESCARGAS: " + resultSet.getInt("descargas") +
                    "; VALORACION: " + resultSet.getDouble("valoracion") +
                    "; FECHA: " + resultSet.getDate("fecha_publicacion"));
            temp++;

        }

        if (temp == 0) System.out.println("No hay datos en la tabla...");

    }
    private static void deleteAllRows(Connection con)throws SQLException{

        System.out.println("Estas seguro que quieres elimiar todas las apps? (SI/NO)");
        String option = sc.next();

        if (option.equalsIgnoreCase("si")){

            String query = "DELETE FROM app";
            PreparedStatement delete = con.prepareStatement(query);
            delete.executeUpdate();

        } else {

            System.out.println("Abortando operación.");

        }

    }
    private static void orderByValoration(Connection con)throws SQLException{

        String query = "SELECT * FROM app ORDER BY valoracion desc";
        PreparedStatement select = con.prepareStatement(query);
        ResultSet resultSet = select.executeQuery();

        int temp = 0;

        System.out.println("-- LINEAS ORDENADAS POR VALORACION --");

        while (resultSet.next()){

            System.out.println("ID: " + resultSet.getString("id") +
                    "; NOMBRE: " + resultSet.getString("nombre") +
                    "; DESARROLLADOR: " + resultSet.getString("desarrollador") +
                    "; CATEGORIA: " + resultSet.getString("categoria") +
                    "; DESCARGAS: " + resultSet.getInt("descargas") +
                    "; VALORACION: " + resultSet.getDouble("valoracion") +
                    "; FECHA: " + resultSet.getDate("fecha_publicacion"));
            temp++;

        }

        if (temp == 0) System.out.println("No hay datos en la tabla...");

    }


}

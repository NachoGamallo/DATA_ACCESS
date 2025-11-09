package mainFolder.T2_AccesoABBDDRelacionales.Practica1ConexionYLogin;

import java.sql.*;
import java.util.Scanner;

public class afterLogIn {

    static Scanner sc = new Scanner(System.in);
    static int actual_userId;

    public static void run(String[] params, int userId) {

        String option;
        actual_userId = userId;

        try (Connection conn = DriverManager.getConnection(params[0],params[1],params[2])){

            conn.setAutoCommit(false);

            do {

                menu();
                System.out.println("Introduce una opcion: ");
                option = sc.next();

                try {

                    userOption(option,conn);
                    conn.commit();

                }catch (SQLException e2){

                    conn.rollback();
                    System.out.println("Error en la operacion, revertiendo cambios...");

                }

            }while (!option.equals("0"));

        }catch (SQLException e){

            System.out.println("SQL Exception: " + e.getMessage());
            System.out.println("State BBDD: " + e.getSQLState());
            System.out.println("ERROR: " + e.getErrorCode());

        }

    }

    //El menu de opciones
    private static void menu(){

        System.out.println("============================");
        System.out.println("MENU PRINCIPAL:");
        System.out.println("============================");
        System.out.println("1. Insertar nuevo registro.");
        System.out.println("2. Modificar registro existente.");
        System.out.println("3. Eliminar registro.");
        System.out.println("4. Listar todos los registros.");
        System.out.println("0. Salir");

    }

    //Segun la opcion seleccionada por el usuario se lanzan x acciones.
    private static void userOption(String option, Connection con) throws SQLException {

        switch (option) {

            case "0" -> System.out.println("Saliendo del programa...");
            case "1" -> insertNewRow(con);
            case "2" -> modifyRow(con);
            case "3" -> deleteRow(con);
            case "4" -> listAllRegisters(con);
            default -> System.out.println("Has ingresado una opcion no disponible.");

        }

    }

    //Con esto listamos todas las lineas de la tabla.
    private static void listAllRegisters(Connection con) throws SQLException{

        String query = "SELECT * FROM registros ORDER BY id";
        PreparedStatement select = con.prepareStatement(query);
        ResultSet resultSet = select.executeQuery();

        int temp = 0;

        while (resultSet.next()){

            System.out.println("ID: " + resultSet.getInt("id") +
                    " NOMBRE: " + resultSet.getString("nombre") +
                    " CATEGORIA: " + resultSet.getString("categoria") +
                    " VALORANCION: " + resultSet.getDouble("valoracion") +
                    " ID_USUARIO: " + resultSet.getInt("id_user"));

            temp++;

        }

        if (temp == 0) System.out.println("No hay resultados, ingresa datos en la bbdd.");

    }

    //Con este metodo vamos a insertar una nueva linea en la tabla.
    private static void insertNewRow(Connection con) throws SQLException{

        String name;
        String category;
        double valoration;

        String query = "INSERT INTO registros (nombre,categoria,valoracion,id_user) VALUES (?,?,?,?)";
        PreparedStatement insert = con.prepareStatement(query);

        System.out.println("Introduce el nombre del juego: ");
        name = sc.next();

        System.out.println("Introduce la categoria del juego: ");
        category = sc.next();

        System.out.println("Introduce la valoracion del juego: ");
        valoration = sc.nextDouble();

        insert.setString(1,name);
        insert.setString(2,category);
        insert.setDouble(3,valoration);
        insert.setInt(4,actual_userId);

        insert.executeUpdate();

        System.out.println("Insercion realizada con exito!");

    }

    //La query con los datos a ingresar , que vienen del metodo modifyRow.
    private static void modifyQuery(Connection con, String columnToModify, String newValue, int idToModify) throws SQLException{

        String query = "UPDATE registros SET " + columnToModify + " = ? WHERE id = ?";
        PreparedStatement update = con.prepareStatement(query);

        switch (columnToModify){

            case "nombre", "categoria" -> update.setString(1,newValue);
            case "valoracion" -> update.setDouble(1, Double.parseDouble(newValue));
            default -> throw new SQLException("La columna introducida no existe...");

        }

        update.setInt(2, idToModify);
        update.executeUpdate();

        System.out.println("Modificacion realizada con exito.");

    }

    //La query con los datos a ingresar , que vienen del metodo deleteRow.
    private static void deleteQuery(Connection con , int idToDelete) throws SQLException{

        String query = "DELETE FROM registros WHERE id = ?";
        PreparedStatement delete = con.prepareStatement(query);
        delete.setInt(1,idToDelete);
        delete.executeUpdate();

    }

    //Con esto vamos a recoger los datos necesarios para realizar el delete.
    private static void deleteRow(Connection con) throws SQLException {

        int idToDelete;

        if (listUserRegisters(con,null)){

            System.out.println("Indica el id (linea) que quieres eliminar: ");

            idToDelete = sc.nextInt();
            if (listUserRegisters(con, String.valueOf(idToDelete))){

                deleteQuery(con,idToDelete);

            }else {

                System.out.println("La id seleccionada no corresponde a la lista indicada...");

            }

        }else {

            System.out.println("No hay resultados, ingresa datos en la bbdd.");

        }

    }

    //Con esto vamos a recoger los datos necesarios para realizar el update.
    private static void modifyRow(Connection con) throws SQLException{

        String columnToModify;
        String newValue;
        int idToModify;

        if (listUserRegisters(con,null)){

            System.out.println("Indica el id (linea) que quieres modificar: ");

            idToModify = sc.nextInt();
            if (listUserRegisters(con, String.valueOf(idToModify))){

                System.out.println("Introduce la columna a modificar (nombre,categoria,valoracion): ");
                columnToModify = sc.next();
                System.out.println("Introduce el nuevo valor:");
                newValue = sc.next();
                modifyQuery(con,columnToModify,newValue, idToModify);

            }else {

                System.out.println("La id seleccionada no corresponde a la lista indicada...");

            }

        }else {

            System.out.println("No hay resultados, ingresa datos en la bbdd.");

        }

    }

    //Realizamos un listado de las lineas de registro de el usuario loggeado.
    private static boolean listUserRegisters(Connection con, String filterById) throws SQLException{

        String query;
        ResultSet resultSet;

        if (filterById == null){

            query = "SELECT * FROM registros WHERE id_user = ? ORDER BY id";
            PreparedStatement select = con.prepareStatement(query);
            select.setInt(1,actual_userId);
            resultSet = select.executeQuery();

        }else {

            query = "SELECT * FROM registros WHERE id_user = ? AND id = ? ORDER BY id";
            PreparedStatement select = con.prepareStatement(query);
            select.setInt(1,actual_userId);
            select.setInt(2,Integer.parseInt(filterById));
            resultSet = select.executeQuery();

        }

        int temp = 0;

        while (resultSet.next()){

            System.out.println("ID: " + resultSet.getInt("id") +
                    " NOMBRE: " + resultSet.getString("nombre") +
                    " CATEGORIA: " + resultSet.getString("categoria") +
                    " VALORANCION: " + resultSet.getDouble("valoracion") +
                    " ID_USUARIO: " + resultSet.getInt("id_user"));

            temp++;

        }

        return temp != 0;

    }

}
package mainFolder.T2_AccesoABBDDRelacionales.A2InUpTrans;

import java.sql.*;

public class A2 {

    public static void processNewCommentsByAuthor(Comment[] comments, int idAuthor) {

        String user = "Nacho";
        String password = "123456";
        String server = "jdbc:postgresql://localhost:5432/Actividad2T2";

        double totalPoints = 0;
        int totalComments = 0;

        try (Connection connection = DriverManager.getConnection(server, user, password)) {

            connection.setAutoCommit(false); // Desactivar autocommit para transacciones

            // Preparar statement
            String insertSQLComment = "INSERT INTO comment (id, type_comment, description, created_at, author_id) " +
                    "VALUES (?, ?, ?, now(), ?)";

            PreparedStatement psInsert = connection.prepareStatement(insertSQLComment);

            String updateSQLAuthor = "UPDATE author SET points = points + ? WHERE id = ?";
            PreparedStatement psUpdate = connection.prepareStatement(updateSQLAuthor);

            // Obtener el MAX(id) de toda la tabla comment
            String maxIdSQL = "SELECT MAX(id) FROM comment";
            PreparedStatement psMaxId = connection.prepareStatement(maxIdSQL);
            ResultSet rsMax = psMaxId.executeQuery();
            int nextId = 1; // Si la tabla está vacía

            if (rsMax.next()) {

                int maxId = rsMax.getInt(1);
                nextId = maxId + 1;

            }

            // Procesar cada comentario
            for (Comment c : comments) {

                int option = c.getTypeComment();
                double value = (option == 1) ? 52.6 : (option == 2) ? 103.4 : 0.0;
                totalPoints += value;

                // INSERT comment
                psInsert.setInt(1, nextId);
                psInsert.setInt(2, option);
                psInsert.setString(3, c.getDescription());
                psInsert.setInt(4, idAuthor);
                psInsert.executeUpdate();

                // UPDATE author points
                psUpdate.setDouble(1, value);
                psUpdate.setInt(2, idAuthor);
                psUpdate.executeUpdate();

                nextId++; // Incrementar para el siguiente comentario

            }

            // Contar total de comentarios del autor
            String countSQL = "SELECT COUNT(*) FROM comment WHERE author_id = ?";

            try (PreparedStatement psCount = connection.prepareStatement(countSQL)) {

                psCount.setInt(1, idAuthor);
                ResultSet rsCount = psCount.executeQuery();

                if (rsCount.next()) {

                    totalComments = rsCount.getInt(1);

                }

            }

            connection.commit(); // Confirmar transacción

            System.out.println("El author " + idAuthor +
                    " ha sumado " + totalPoints +
                    " puntos a su ranking y tiene un total de " + totalComments +
                    " comentarios.");

        } catch (SQLException e) {

            System.out.println("Ha ocurrido un error. Se deshacen los cambios.");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("State: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());

        }

    }

}

package jmax.ad;

import java.sql.*;

public class Transac {
    static final String IP = "127.0.0.1";
    static final String PUERTO = "3306";
    static final String BBDD = "personas";
    static final String USER = "root";
    static final String PASS = "1234";
    static final String CADENA_CONEXION = "jdbc:mysql://" + IP + ":" + PUERTO + "/" + BBDD;

    public static void main(String[] args) {
        String sql = "INSERT INTO person (id, name) VALUES (500, 'Marcos')";
        Connection miConexion = null;
        try {
            miConexion = DriverManager.getConnection(CADENA_CONEXION, USER, PASS);
            miConexion.setAutoCommit(false); // --> es lo mismo que el begin de mysql

            Statement miStatement = miConexion.createStatement();
            miStatement.executeUpdate(sql);

            miConexion.commit();

        } catch (SQLException e) {
            System.out.println("Error");
            System.out.println("Hacemos el Rollback");
            try {
                miConexion.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }finally {
            try {
                miConexion.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

    }

}

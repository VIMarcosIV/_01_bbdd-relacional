package jmax.ad;

import java.sql.*;

public class Main {
    static final String IP = "127.0.0.1";
    static final String PUERTO = "3306";
    static final String BBDD = "personas";
    static final String USER = "root";
    static final String PASS = "1234";
    static final String CADENA_CONEXION = "jdbc:mysql://" + IP + ":" + PUERTO + "/" + BBDD;

    public static void main(String[] args) {
        String sql = "SELECT * FROM person ORDER BY id desc LIMIT 10";
        try {
            Connection miConexion = DriverManager.getConnection(CADENA_CONEXION, USER, PASS);
            Statement miStatement = miConexion.createStatement();
            ResultSet miResultSet = miStatement.executeQuery(sql);

            while (miResultSet.next()) {
                System.out.println(
                        miResultSet.getInt(1)
                                + " "
                                + miResultSet.getString(2)
                                + " "
                                + miResultSet.getString("last_name")
                                + " "
                                + miResultSet.getString(4)
                                + " "
                                + miResultSet.getString(5)
                                + " "
                                + miResultSet.getString(6)
                                + " "
                                + miResultSet.getFloat(7)
                );
            }
            miConexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}

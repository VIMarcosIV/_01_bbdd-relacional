package jmax.ad;

import java.sql.*;
import java.util.Scanner;

public class CRUD {
    static final String IP = "127.0.0.1";
    static final String PUERTO = "3306";
    static final String BBDD = "personas";
    static final String USER = "root";
    static final String PASS = "1234";
    static final String CADENA_CONEXION = "jdbc:mysql://" + IP + ":" + PUERTO + "/" + BBDD;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sql = "";
        //SELECT * FROM person ORDER BY id desc LIMIT 10
        String opcion = "";
        String id;
        String name;
        String last_name;
        String email;
        String gender;
        String ip_address;
        String money;
        try {
            Connection miConexion = DriverManager.getConnection(CADENA_CONEXION, USER, PASS);
            PreparedStatement miStatement;
            System.out.println("Elige una opcion:");

            System.out.println("1.- Insert");
            System.out.println("2.- Select");
            System.out.println("3.- Update");
            System.out.println("4.- Delete");

            opcion = sc.nextLine();

            if (opcion.contains("1")) {
                miStatement = miConexion.prepareStatement("INSERT INTO person (id, name, last_name, email, gender, ip_address, money) values (?,?,?,?,?,?,?)");
                System.out.println("Escribe una id");
                id = sc.nextLine();
                miStatement.setInt(1, Integer.parseInt(id));

                System.out.println("Escribe un nombre");
                name = sc.nextLine();
                miStatement.setString(2, name);

                System.out.println("Escribe un apellido");
                last_name = sc.nextLine();
                miStatement.setString(3, last_name);

                System.out.println("Escribe un email");
                email = sc.nextLine();
                miStatement.setString(4, email);

                System.out.println("Escribe un genero");
                gender = sc.nextLine();
                miStatement.setString(5, gender);

                System.out.println("Escribe una ip");
                ip_address = sc.nextLine();
                miStatement.setString(6, ip_address);

                System.out.println("Escribe un salario");
                money = sc.nextLine();
                miStatement.setDouble(7, Double.parseDouble(money));

                miStatement.executeUpdate();
            } else if (opcion == "2") {

            } else if (opcion == "3") {

            } else if (opcion == "4") {

            }
            miConexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

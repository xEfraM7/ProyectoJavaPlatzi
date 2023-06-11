package org.example;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {
    public static void CreateMessageDB(Messages message) {
        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes (MENSAJE , AUTOR_MENSAJE) VALUES (?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, message.getMessage());
                ps.setString(2, message.getMessageAuthor());
                //ejecutamos la sentencia aqui si como transaccion
                ps.executeUpdate();
                System.out.println("mensaje creado");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void ReadMessageDB() {
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conexion = db_connect.get_connection()) {
            String query = "SELECT * FROM mensajes";
            //preparamos la sentencia
            ps = conexion.prepareStatement(query);
            //ejecutamos la sentencia pero solo como consulta no como transaccion
            rs = ps.executeQuery();
            //mientras rs contenga datos se ejecuta
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID_MENSAJE"));
                System.out.println("Mensaje: " + rs.getString("MENSAJE"));
                System.out.println("Autor: " + rs.getString("AUTOR_MENSAJE"));
                System.out.println("Fecha: " + rs.getString("FECHA_MENSAJE"));
                System.out.println("");
            }
        } catch (SQLException e) {
            System.out.println("No se recuperaron Datos");
            System.out.println(e);
        }
    }

    public static void DeleteMessageDB(int id_message) {
        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;

            try {
                String query = "DELETE FROM mensajes WHERE ID_MENSAJE = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_message);
                ps.executeUpdate();
                System.out.println("el mensaje fue borrado");
            } catch (SQLException e) {
                System.out.println("no se pudo borrar el mensaje");
                System.out.println(e);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void UpdateMessageDB(Messages message) {
        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "UPDATE mensajes SET MENSAJE = ?  WHERE ID_MENSAJE = ?;";
                ps = conexion.prepareStatement(query);
                ps.setString(1, message.getMessage());
                //ps.setString(2, message.getMessageAuthor());
                ps.setInt(2, message.getId_message());
                ps.executeUpdate();
                System.out.println("el mensaje se edito correctamente");
            } catch (SQLException e) {
                System.out.println("no se pudo actualizar el mensaje");
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}




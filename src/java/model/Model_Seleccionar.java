package model;

import java.sql.*;
import estudiantes.*;
import model.pool_connection.Conexion;

/**
 *
 * @author Luigis
 */
public class Model_Seleccionar {

    private Estudiantes estudiantes = null;
    private Connection cn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public Model_Seleccionar() {
        cn = new Conexion().getConexion();
    }

    public Estudiantes setSeleccionar(String ID) throws SQLException {
        try {
            pst = cn.prepareStatement("SELECT * FROM `estudiantes` WHERE ID = ?");
            pst.setString(1, ID);
            rs = pst.executeQuery();

            if (rs.next()) {
                String Nombre = rs.getString("Nombre");
                String Apellido = rs.getString("Apellido");
                String Edad = rs.getString("Edad");
                String Numero = rs.getString("Numero");
                String Matricula = rs.getString("Matricula");
                estudiantes = new Estudiantes(Integer.parseInt(ID), Nombre, Apellido, Edad, Numero, Matricula);
            }
        } catch (SQLException e) {
            System.out.println("Error al Selecionar el Estudiante: " + e.getMessage());
        }
        return estudiantes;
    }

}

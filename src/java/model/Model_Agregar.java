package model;

import estudiantes.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.pool_connection.Conexion;

/**
 *
 * @author Luigis
 */
public class Model_Agregar {

    private Connection cn = null;
    private PreparedStatement pst = null;

    public Model_Agregar() {
        cn = new Conexion().getConexion();
    }

    public void setEstudiante(Estudiantes estudiante) throws SQLException {
        try {
            pst = cn.prepareStatement("INSERT INTO `estudiantes`(`Nombre`, `Apellido`, `Edad`, `Numero`, `Matricula`)"
                    + " VALUES ('" + estudiante.getNombre() + "','" + estudiante.getApellido() + "','"
                    + estudiante.getEdad() + "','" + estudiante.getNumero() + "','" + estudiante.getMatricula() + "')");
            pst.execute();
        } catch (SQLException e) {
            System.out.println("Error al insertar usuarios" + e.getMessage());
        }
    }
}

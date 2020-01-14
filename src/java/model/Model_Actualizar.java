package model;

import java.sql.*;
import estudiantes.*;
import model.pool_connection.Conexion;

/**
 *
 * @author Luigis
 */
public class Model_Actualizar {

    private Connection cn = null;
    private PreparedStatement pst = null;

    public Model_Actualizar() {
        cn = new Conexion().getConexion();
    }

    public void setActualizarEstudiantes(Estudiantes estudiante, String ID) throws SQLException {
        try {
            pst = cn.prepareStatement("UPDATE `estudiantes` SET `Nombre`= ?,`Apellido`= ?,"
                    + "`Edad`= ?,`Numero`= ?,`Matricula`= ? WHERE ID= ?");

            pst.setString(1, estudiante.getNombre());
            pst.setString(2, estudiante.getApellido());
            pst.setString(3, estudiante.getEdad());
            pst.setString(4, estudiante.getNumero());
            pst.setString(5, estudiante.getMatricula());
            pst.setString(6, ID);

            pst.execute();

        } catch (SQLException e) {
            System.out.println("Error al Actualizar: " + e.getMessage());
        }
    }

}

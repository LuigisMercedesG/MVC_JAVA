package model;

import java.sql.*;
import model.pool_connection.Conexion;

/**
 *
 * @author Luigis
 */
public class Model_Eliminar {

    private Connection cn = null;
    private PreparedStatement pst = null;

    public Model_Eliminar() {
        cn = new Conexion().getConexion();
    }

    public void setEliminarEstudiantes(String ID) throws SQLException {
        try {
            pst = cn.prepareStatement("DELETE FROM `estudiantes` WHERE ID = ?");
            pst.setString(1, ID);

            pst.execute();
        } catch (SQLException e) {
            System.out.println("Error en la Eliminacion: " + e.getMessage());
        }
    }

}

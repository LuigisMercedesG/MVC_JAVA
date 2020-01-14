package model;

import java.sql.*;
import java.util.List;
import estudiantes.*;
import java.util.ArrayList;
import model.pool_connection.Conexion;

/**
 *
 * @author Luigis
 */
public class Model_Resultado {

    private Connection cn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public Model_Resultado() {
        cn = new Conexion().getConexion();
    }

    public List<Estudiantes> getListadoEstudiantes() throws SQLException {
        List<Estudiantes> ListaEstudiante = new ArrayList<>();
        try {
            pst = cn.prepareStatement("SELECT * FROM `estudiantes`");
            rs = pst.executeQuery();
            while (rs.next()) {
                ListaEstudiante.add(new Estudiantes(rs.getInt("ID"), rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Edad"), rs.getString("Numero"), rs.getString("Matricula")));
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL: " + e.getMessage());
        }
        return ListaEstudiante;
    }
}

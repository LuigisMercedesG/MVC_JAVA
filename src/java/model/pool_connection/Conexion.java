package model.pool_connection;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author Luigis
 */
public class Conexion {

    private Connection conexion = null;
    private DataSource dataSource = null;
    private BasicDataSource basicDatasource = null;

    public Conexion() {
        try {
            basicDatasource = new BasicDataSource();
            basicDatasource.setUsername("root");
            basicDatasource.setPassword("");
            basicDatasource.setUrl("jdbc:mysql://localhost/universidad");
            basicDatasource.setDriverClassName("com.mysql.jdbc.Driver");
            basicDatasource.setMaxActive(50);
            basicDatasource.setMaxIdle(25);
            basicDatasource.setMaxWait(5000);
            //establecemos la conexion
            dataSource = basicDatasource;
            conexion = dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }
    }

    /**
     * @return the Connection
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     */
    public void getCloseConexion() {

        if (this.conexion != null) {
            try {
                this.conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion: " + ex.getMessage());
            }
        }
    }
}


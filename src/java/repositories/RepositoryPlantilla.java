package repositories;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Funciones;
import models.Plantilla;

public class RepositoryPlantilla {

    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new SQLServerDriver());
        String cadena
                = "jdbc:sqlserver://sqlserverjavapgs.database.windows.net:1433;databaseName=SQLAZURE";
        Connection cn
                = DriverManager.getConnection(cadena, "adminsql", "Admin123");
        return cn;
    }

    public List<Plantilla> getPlantilla() throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select * from plantilla";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Plantilla> plantillas = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("EMPLEADO_NO");
            String ape = rs.getString("APELLIDO");
            String fun = rs.getString("FUNCION");
            String t = rs.getString("T");
            int sal = rs.getInt("SALARIO");
            Plantilla p = new Plantilla(id, ape, fun, t, sal);
            plantillas.add(p);
        }
        rs.close();
        cn.close();
        return plantillas;
    }

    public Plantilla findPlantilla(int idplantilla) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select * from plantilla where empleado_no=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, idplantilla);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("EMPLEADO_NO");
            String ape = rs.getString("APELLIDO");
            String fun = rs.getString("FUNCION");
            String t = rs.getString("T");
            int sal = rs.getInt("SALARIO");
            Plantilla plantilla = new Plantilla(id, ape, fun, t, sal);
            rs.close();
            cn.close();
            return plantilla;
        } else {
            rs.close();
            cn.close();
            return null;
        }
    }

    public List<Plantilla> getPlantillaFuncion(String funcion) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select * from plantilla where lower(funcion)=lower(?)";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, funcion);
        ResultSet rs = pst.executeQuery();
        ArrayList<Plantilla> plantillas = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("EMPLEADO_NO");
            String ape = rs.getString("APELLIDO");
            String fun = rs.getString("FUNCION");
            String t = rs.getString("T");
            int sal = rs.getInt("SALARIO");
            Plantilla p = new Plantilla(id, ape, fun, t, sal);
            plantillas.add(p);
        }
        rs.close();
        cn.close();
        if (plantillas.isEmpty()) {
            return null;
        } else {
            return plantillas;
        }
    }

    public Funciones getFunciones() throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select distinct funcion from plantilla";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<String> datos = new ArrayList<>();
        Funciones funciones = new Funciones();
        while (rs.next()) {
            String funcion = rs.getString("FUNCION");
            datos.add(funcion);
        }
        rs.close();
        cn.close();
        funciones.setFuncion(datos);
        return funciones;
    }

    public List<Plantilla> getPlantillaSalario(int salario) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select * from plantilla where salario > ?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, salario);
        ResultSet rs = pst.executeQuery();
        ArrayList<Plantilla> plantillas = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("EMPLEADO_NO");
            String ape = rs.getString("APELLIDO");
            String fun = rs.getString("FUNCION");
            String t = rs.getString("T");
            int sal = rs.getInt("SALARIO");
            Plantilla p = new Plantilla(id, ape, fun, t, sal);
            plantillas.add(p);
        }
        rs.close();
        cn.close();
        if (plantillas.isEmpty()) {
            return null;
        } else {
            return plantillas;
        }
    }
}

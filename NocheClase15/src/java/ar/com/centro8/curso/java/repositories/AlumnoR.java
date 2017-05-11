package ar.com.centro8.curso.java.repositories;

import ar.com.centro8.curso.java.connector.Connector;
import ar.com.centro8.curso.java.connector.Table;
import ar.com.centro8.curso.java.entities.Alumno;
import ar.com.centro8.curso.java.util.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlumnoR {

    private Alumno alumno;
    private final String TABLE = "alumnos";

    public void save() {
        String fields = "nombre,apellido,edad,curso";
        //String values="'"+alumno.getNombre()+"','"+alumno.getApellido()+"',"+
        //        alumno.getEdad()+","+alumno.getCurso();
        //Table.insert(TABLE, fields, values);
        Connection con;
        String query = "insert into " + TABLE + " (" + fields + ") values (?,?,?,?)";
        PreparedStatement ps;
        ResultSet rs;
        try {
            con = Connector.getConnection();
            ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setInt(3, alumno.getEdad());
            ps.setInt(4, alumno.getCurso());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setId(rs.getInt(1));
            }
            con.close();
        } catch (Exception e) {
            Log.set(e);
        }
    }

    public Alumno getById(int id) {
        Alumno a = null;
        String query = "select * from " + TABLE + " where id=" + id;
        Connection con;
        ResultSet rs;
        try {
            con = Connector.getConnection();
            rs = con.createStatement().executeQuery(query);
            if (rs.next()) {
                a = new Alumno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("edad"),
                        rs.getInt("curso")
                );
            }
            con.close();
        } catch (Exception e) {
            Log.set(e);
        }
        return a;
    }

    public List<Alumno> getAll() {
        return getByFiltro("1=1");
    }

    public List<Alumno> getByFiltro(String filtro) {
        List<Alumno> lista = new ArrayList();
        Connection con;
        ResultSet rs;
        String query = "select * from " + TABLE + " where " + filtro;
        Alumno a;
        try {
            con = Connector.getConnection();
            rs = con.createStatement().executeQuery(query);
            while (rs.next()) {
                a = new Alumno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("edad"),
                        rs.getInt("curso")
                );
                lista.add(a);
            }
            con.close();
        } catch (Exception e) {
            Log.set(e);
        }
        return lista;
    }

    public List<Alumno> getByNombre(String nombre) {
        return getByFiltro("nombre='" + nombre + "'");
    }

    public List<Alumno> getByApellido(String apellido) {
        return getByFiltro("apellido='" + apellido + "'");
    }

    public void delete() {
        String query = "delete from " + TABLE + " where id=";
        Connection con;
        if (alumno != null && alumno.getId() != 0) {
            query+=alumno.getId();
            try {
                con = Connector.getConnection();
                con.createStatement().execute(query);
                con.close();
                alumno = null;
            } catch (Exception e) {
                Log.set(e);
            }
        }
    }
    
    public void update(){
        String query = "update " + TABLE + " set nombre=? , apellido=?, edad=?,curso=? where id=?";
        Connection con;
        PreparedStatement ps;
        if (alumno != null && alumno.getId() != 0) {
            try {
                con=Connector.getConnection();
                ps=con.prepareStatement(query);
                ps.setString(1, alumno.getNombre());
                ps.setString(2, alumno.getApellido());
                ps.setInt(3, alumno.getEdad());
                ps.setInt(4, alumno.getCurso());
                ps.setInt(5, alumno.getId());
                ps.execute();
                con.close();
            } catch (Exception e) {
                Log.set(e);
            }
        }
    }

    public AlumnoR() {
    }

    public AlumnoR(Alumno alumno) {
        this.alumno = alumno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

}

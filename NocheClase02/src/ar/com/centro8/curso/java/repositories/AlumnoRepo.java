
package ar.com.centro8.curso.java.repositories;
import ar.com.centro8.curso.java.connector.Connector;
import ar.com.centro8.curso.java.connector.Table;
import ar.com.centro8.curso.java.util.Log;
import ar.com.centro8.java.entities.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AlumnoRepo {
    private Alumno alumno;
    private final String TABLE="alumnos";
    
    public void save(){
          
        String fields="nombre,apellido,edad,curso";
        
        /*
        String values="'"+alumno.getNombre()+"','"+alumno.getApellido()+"',"+
                alumno.getEdad()+","+alumno.getCurso();
        Table.insert(TABLE, fields, values);
        */
        Connection con;
        String query = "insert into "+TABLE+" ("+fields+") values (?,?,?,?)";
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            con = Connector.getConnection();
            ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setInt(3, alumno.getEdad());
            ps.setInt(4, alumno.getCurso());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) alumno.setId(rs.getInt(1));
            con.close();
            
        } catch(Exception e){
            Log.set(e);
        }
    }
    
    public Alumno getById(int id){
        Alumno a = null;
        String query = "select * from "+TABLE+" where id="+id;
        ResultSet rs;
        Connection con;
        
        try{
            con = Connector.getConnection();
            rs = con.createStatement().executeQuery(query);
            if(rs.next()){
                a = new Alumno(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getInt("edad"),
                    rs.getInt("curso")
                );
            }
            
        } catch(Exception e){
            Log.set(e);
        }
        
        return a;
    }
    
    public AlumnoRepo(){
    }

    public AlumnoRepo(Alumno alumno) {
        this.alumno = alumno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
    
    
}

package ar.com.centro8.curso.java.connector;

import ar.com.centro8.curso.java.util.Log;
import ar.com.centro8.curso.java.util.X;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Table {

    private static Connection con;

    public static void connect() {
        try {
            con = Connector.getConnection();
        } catch (Exception ex) {
            Log.set(ex);
        }
    }

    public static void close() {
        try {
            con.close();
        } catch (Exception e) {
            Log.set(e);
        }
    }

    /**
     * Ejecuta consultas de actualización (insert, delete, update)
     * @param query consulta que va a ser ejecutada. 
     */
    public static void execute(String query) {
        connect();
        X.print(query);
        try {
            con.createStatement().execute(query);
        } catch (Exception e) {
            Log.set(e);
        }
        close();
    }
    private static String query;
    private static int execute(){
        connect();
        //X.print(query);
        int x=0;
        try {
            x=con.createStatement().executeUpdate(query);
            //Statement statement=con.createStatement();
            //x=statement.executeUpdate(query);
        } catch (Exception e) {
            Log.set(e);
        }
        close();
        return x;
    }
    public static int delete(String table,String filtro){
        query="delete from "+table+" where "+filtro;
        return execute();
    }
    public static int insert(String table,String fields,String values){
        query="insert into "+table+" ("+fields+") values ("+values+")";
        return execute();
    }
    public static int update(String table,String filtro,String set){
        query="update "+table+" set "+set+" where "+filtro;
        return execute();
    }
    public static ResultSet select(String table){
        return select(table,"1=1");
    }
    public static ResultSet select(String table,String filtro){
        String query="select * from "+table+" where "+filtro;
        ResultSet rs=null;
        connect();
        try {
            rs=con.createStatement().executeQuery(query);
        } catch (Exception e) {
            Log.set(e);
        }
        //close(); // El usuario es el responsable de cerrar la conexión
        return rs;
        // lo que se escribe aca nunca se ejecuta.
        //System.out.println("hola");
    }
    
    public static List<Object> getList(String table){
        return getList(table,"1=1");
    }
    
    public static List<Object> getList(String table,String filtro){
        List<Object> lista=new ArrayList();
        ResultSet rs=null;
        String query="select * from "+table+" where "+filtro;
        connect();
        int cant;
        try {
            rs=con.createStatement().executeQuery(query);
            cant=rs.getMetaData().getColumnCount();
            while(rs.next()){
                Object[] obj=new Object[cant];
                for(int a=0;a<cant;a++){
                    obj[a]=rs.getObject(a+1);
                }
                lista.add(obj);
            }
            rs.close();
        } catch (Exception e) {
            Log.set(e);
        }
        close();
        return lista;
    }
}

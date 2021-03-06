package ar.com.centro8.curso.java.repositories;

import ar.com.centro8.curso.java.connector.Connector;
import ar.com.centro8.curso.java.interfaces.GenericDAO;
import ar.com.centro8.curso.java.util.Log;
import ar.com.centro8.curso.java.util.X;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class GenericR<E>{

    public void save(E e){
        
        //X.print(e.getClass());
        //X.print(e.getClass().getName());
        //X.print(e.getClass().getSimpleName());
        
        String table = e.getClass().getSimpleName();
        String query = "insert into "+table+" (";
        
        Field[] fields = e.getClass().getDeclaredFields();
        String field;
        for(int a=0;a<fields.length;a++){
            //X.print(fields[a].getName());
            field = fields[a].getName();
            if (a!=0) query +=",";
            query += field;
        }
        
        query += ") values (";
        
        for(int a=0;a<fields.length;a++){
            field = fields[a].getName();
            if(a!=0) query +=",";
            query += "?";
        }
        query += ")";
        X.print(query);
        
        Connection con;
        PreparedStatement ps;
        String method;
        
        try {
            con = Connector.getConnection();
            ps = con.prepareStatement(query);
            
            for(int a=0;a<fields.length;a++){
                field = fields[a].getName();
                method = "get"+field.substring(0,1).toUpperCase()+field.substring(1);
                //X.print(method);
                if(a==0)
                    ps.setObject(1, null);
                else
                    ps.setObject(a+1, e.getClass().getMethod(method, null).invoke(e));
            }
            ps.execute();
        } 
        catch (Exception ex) {
            Log.set(ex);
        }
        
    }
    
    public E get(String clazz, int id){
        E e = null;
        String query = "select * from ";
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        Field[] fields;
        ResultSetMetaData rsmd;
        String method;
        String field;
        
        try {
            e = (E)Class.forName(clazz).newInstance(); 
            query += e.getClass().getSimpleName()+" where id=?";
            con = Connector.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                fields = e.getClass().getDeclaredFields();
                rsmd = rs.getMetaData();
                for (int i=1;i<rsmd.getColumnCount();i++){
                    field = rsmd.getColumnName(i);
                    method = "set"+field.substring(0,1).toUpperCase()+field.substring(1);
                    
                }
                
            }
                
        }catch (Exception ex) {
            Log.set(ex);
        }
        
        return e;
    }
}

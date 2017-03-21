package ar.com.centro8.curso.java.repositories;

import ar.com.centro8.curso.java.interfaces.GenericDAO;
import ar.com.centro8.curso.java.util.X;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GenericRepo <E> {

    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<E> getAll() {
        return get("1=1");
    }
    
    public Class getType(){
        Class clax = this.getClass();
        return clax.getClass();
    }

    public List<E> get(String filter) {
        List<E> lista = new ArrayList();
        String query = "select * from "+this.getType().getName()+" where "+filter;
        Connection con;
        ResultSet rs;
        Field[] campos = this.getType().getDeclaredField();
        
        X.line();
        X.print(query);
        
        
        return lista;
    }

    public Object getById(Serializable p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

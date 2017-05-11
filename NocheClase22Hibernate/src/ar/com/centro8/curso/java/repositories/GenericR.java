package ar.com.centro8.curso.java.repositories;

import static ar.com.centro8.curso.java.hibernate.utils.HibernateUtil.getSessionFactory;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GenericR <E, PK extends Serializable>{
    /*
    <E,PK> Defino que se trabaja con Entity y un parametro PK
    Generics esta disponible desde java 5
    <T> en C++ Template
    */
    
    private SessionFactory sessionFactory;
    
    public GenericR (SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    public Class getType(){
        Class clazz = this.getClass();
        ParameterizedType prt = (ParameterizedType) clazz.getGenericSuperclass();
        Type[] types = prt.getActualTypeArguments();
        return (Class)types[0];
    }
    
    public E getById (PK id){
        Session session = getSessionFactory().openSession();
        E e = (E) session.get(getType(), id);
        session.close();
        return e;
    }
    
    public PK save (E e){
        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Serializable id = null;
        try {
            id = session.save(e);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            throw ex;
        }
        session.close();
        return (PK) id;
    }
    
    public void update(E e){
        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(e);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            throw ex;
        }
        session.close();
    }
    
    public void remove (E e){
        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(e);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            throw ex;
        }
        session.close();
    }
    
    public List<E> getAll(){
        return get("1=1");
    }
    
    public List<E> get (String filtro){
        Session session = sessionFactory.openSession();
        String query = "from "+getType().getSimpleName()+" where "+filtro;
        List<E> lista = session.createQuery(query).list();
        session.close();
        return lista;
    }
    
    public int count(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select count(t) from "+getType().getSimpleName());
        int count = Integer.parseInt(query.uniqueResult()+"");
        session.close();
        return count;
    }
    
    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    
}

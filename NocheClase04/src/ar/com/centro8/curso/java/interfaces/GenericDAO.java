package ar.com.centro8.curso.java.interfaces;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO <E, PK extends Serializable> {
    public void save();
    public void remove();
    public void update();
    public List<E> getAll();
    public List<E> get(String filter);
    public E getById(PK p);
}

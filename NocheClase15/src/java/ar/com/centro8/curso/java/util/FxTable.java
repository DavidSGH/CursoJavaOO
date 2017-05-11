package ar.com.centro8.curso.java.util;

import java.lang.reflect.Field;
import java.util.List;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FxTable<E> {

    public void removeCol(TableView tv, int index) {
        tv.getColumns().remove(index);
    }

    public void cargar(List<E> lista, TableView tv) {
        tv.getColumns().clear();
        tv.getItems().clear();
        if (lista != null && lista.size() != 0) {
            Object obj = lista.get(0);
            Field[] campos = obj.getClass().getDeclaredFields();
            int cantidad = campos.length;
            TableColumn col;
            String nombreCol;
            for (int a = 0; a < cantidad; a++) {
                nombreCol = campos[a].getName();
                col = new TableColumn(nombreCol);
                tv.getColumns().add(col);
                col.setCellValueFactory(new PropertyValueFactory<>(nombreCol));
            }
            tv.getItems().addAll(lista);
        }
    }
}

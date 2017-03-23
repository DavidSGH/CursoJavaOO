package ar.com.centro8.curso.java.util;

import ar.com.centro8.curso.java.connector.Table;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SwingTable {
    public static void cargar(ResultSet rs, JTable jt) {
        //Para establecer el modelo al JTable
        DefaultTableModel modelo = new DefaultTableModel();
        jt.setModel(modelo);

        try {
            //Obteniendo la informacion de las columnas que estan siendo consultadas
            ResultSetMetaData rsMd = rs.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
            //Establecer como cabezeras el nombre de las colimnas
            for (int i = 1; i <= cantidadColumnas; i++) {
                modelo.addColumn(rsMd.getColumnLabel(i));
            }
			
            //Creando las filas para el JTable
            while (rs.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            rs.close();
            Table.close();

        } catch (Exception ex) {
            Log.set(ex);
        }

    }
}

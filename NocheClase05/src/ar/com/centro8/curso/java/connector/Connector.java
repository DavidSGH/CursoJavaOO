package ar.com.centro8.curso.java.connector;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static String driver="com.mysql.jdbc.Driver";
    private static String vendor="mysql";
    private static String server="localhost";
    private static String port="3306";
    private static String db="colegio";
    private static String user="root";
    private static String pass="";
    
    private static String url="jdbc:"+vendor+"://"+server+":"+port+"/"+db;
    
    public static Connection getConnection() throws Exception{
        Class.forName(driver).newInstance();
        return DriverManager.getConnection(url, user, pass);
    }
}

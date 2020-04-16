/**
 * procurar versiones 1.8 jdk y jdbc connector 5.1.48
 * para errores tipo 'client does not support authentication protocol request by server'
 * ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';
 * flush privileges;
 * */

/**
 * falta arreglar bugs
 * */
package com.alexis.conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    private String url = "jdbc:mysql://localhost:3306/";
    private Connection conection = null;

    public Connection conectar(String user,String password,String dataBase)
    {
        url += dataBase;
        try
        {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            conection = (Connection) DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null,"Conexion establecida","Alert!",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error de conexion", "Alert!",
                    JOptionPane.ERROR_MESSAGE);
        }
        return conection;
    }

    public void desconectar()
    {
        if (conection == null)
        {
            JOptionPane.showMessageDialog(null,"no se ha establecido una conexion",
                    "Alert!", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            conection = null;
            JOptionPane.showMessageDialog(null,"conexion finalizada!","Alert!",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

}



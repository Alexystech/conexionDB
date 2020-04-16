import com.alexis.conexion.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstLayout extends JFrame {
    private JButton conectarButton;
    private JButton desconectarButton;
    private JPanel rootPanel;
    private JTextField textField1;
    private JTextField textField3;
    private JPasswordField passwordField1;

    public FirstLayout() {
        //this uses the form designer form
        add(rootPanel);
        setTitle("ConnectionToMySQL");
        setSize(400,500);

        Conexion cnx = new Conexion();

        conectarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String user = textField3.getText();
                String password = passwordField1.getText();
                String dataBase = textField1.getText();

                cnx.conectar(user,password,dataBase);
            }
        });
        desconectarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cnx.desconectar();
            }
        });
    }
}

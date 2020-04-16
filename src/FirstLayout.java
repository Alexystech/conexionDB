import com.alexis.conexion.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstLayout extends JFrame {
    private JButton conectarButton;
    private JButton desconectarButton;
    private JPanel rootPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public FirstLayout() {
        //this uses the form designer form
        add(rootPanel);
        setTitle("this is my title");
        setSize(400,500);

        Conexion cnx = new Conexion();

        conectarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String user = textField3.getText();
                String password = textField2.getText();
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

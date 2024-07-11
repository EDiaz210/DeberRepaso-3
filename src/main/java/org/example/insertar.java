package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertar {
    public  JPanel insertar1;
    public JTextField textField1;
    public JButton Ingresar;
    public JTextField textField2;
    public JTextField textField3;
    public JTextField textField4;

    public insertar() {
        Ingresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Conexion con SQL
                String url = "jdbc:mysql://localhost:3306/deberepaso";
                String usuario = "root";
                String password = "123456";

                String cedula = textField1.getText().trim();
                String nombre = textField2.getText().trim();
                String b1Txt = textField3.getText().trim();
                String b2Txt = textField4.getText().trim();

                if (cedula.length() > 15) {
                    JOptionPane.showMessageDialog(null, "La cédula es demasiado larga.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double b1;
                double b2;
                try {
                    b1 = Double.parseDouble(b1Txt);
                    b2 = Double.parseDouble(b2Txt);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos para las notas.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                String sql = "INSERT INTO estudiantes (cedula, nombre, b1, b2) VALUES (?, ?, ?, ?)";

                try(Connection connection = DriverManager.getConnection(url, usuario, password)){
                    PreparedStatement cadenaPreparada = connection.prepareStatement(sql);
                    System.out.println("Conexión con Exito");
                    cadenaPreparada.setString(1,cedula);
                    cadenaPreparada.setString(2,nombre);
                    cadenaPreparada.setDouble(3,b1);
                    cadenaPreparada.setDouble(4,b2);

                    cadenaPreparada.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Datos insertados con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }catch (SQLException e3){
                    e3.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al insertar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
}

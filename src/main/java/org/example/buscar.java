package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class buscar {
    public JButton buscarCedula;
    public JButton buscarNombre;
    public JPanel buscar1;
    public JLabel nombre;
    public JLabel cedula;
    public JLabel b1TXT;
    public JTextField consultaN;
    public JLabel b2TXT;
    private JLabel resultadoF;
    public JLabel b2Txt;


    public buscar() {
        buscarNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/estudiantes2024";
                String usuario = "Lyxuz";
                String password = "123456";


                try (Connection connection = DriverManager.getConnection(url, usuario, password)) {
                    System.out.println("Conectado a la base de datos");
                    String query = "select *, round(b1+b2/2) as PromedioNotas from Estudiantes where nombre = '" + consultaN.getText() + "'";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);

                    while (resultSet.next()) {
                        System.out.print(resultSet.getString("cedula"));
                        nombre.setText(resultSet.getString("nombre"));
                        cedula.setText(resultSet.getString("cedula"));
                        b1TXT.setText(resultSet.getString("b1"));
                        b2TXT.setText(resultSet.getString("b2"));
                        b2Txt.setText(resultSet.getString("PromedioNotas"));

                    }
                } catch (SQLException e2) {
                    System.out.println(e2.getMessage());
                }

            }

        });

        buscarCedula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/deberepaso";
                String usuario = "root";
                String password = "123456";


                try (Connection connection = DriverManager.getConnection(url, usuario, password)) {
                    System.out.println("Conectado a la base de datos");
                    String query = "select *, round(b1+b2/2) as PromedioNotas from Estudiantes where cedula = '" + consultaN.getText() + "'";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);

                    while (resultSet.next()) {
                        System.out.print(resultSet.getString("cedula"));
                        nombre.setText(resultSet.getString("nombre"));
                        cedula.setText(resultSet.getString("cedula"));
                        b1TXT.setText(resultSet.getString("b1"));
                        b2TXT.setText(resultSet.getString("b2"));
                        resultadoF.setText(resultSet.getString("PromedioNotas"));

                    }
                } catch (SQLException e1) {
                    System.out.println(e1.getMessage());
                }

            }

        });
    }
}

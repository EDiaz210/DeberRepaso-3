package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form1 {

    public JButton insertar;
    public JButton buscar;
    public JPanel p1;

    public Form1() {
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame jf = new JFrame("pe");
                jf.setContentPane(new buscar().buscar1);
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.setSize(700, 700);
                jf.setPreferredSize(new Dimension(700, 700));
                jf.setMinimumSize(new Dimension(700, 700));
                jf.pack();
                jf.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(buscar)).dispose();
            }
        });
        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame jf = new JFrame("pe");
                jf.setContentPane(new insertar().insertar1);
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.setSize(700, 700);
                jf.setPreferredSize(new Dimension(700, 700));
                jf.setMinimumSize(new Dimension(700, 700));
                jf.pack();
                jf.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(insertar)).dispose();
            }
        });
    }
}

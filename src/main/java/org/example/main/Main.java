package org.example.main;

import javax.swing.*;
import org.example.view.LoginPanel;


public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Login");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300); // Puedes ajustar el tamaño según sea necesario
                frame.setLocationRelativeTo(null); // Esto centra la ventana en la pantalla
                frame.add(new LoginPanel(frame));
                frame.setVisible(true);
            }
        });
    }
}
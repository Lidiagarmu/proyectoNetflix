package org.example.view;

import javax.swing.*;
import java.awt.*;

public class ClientPanel extends JPanel {
    public ClientPanel() {
        setLayout(new BorderLayout());
        add(new JLabel("Client Panel"), BorderLayout.CENTER);
        // Añadir componentes específicos para Client
    }
}
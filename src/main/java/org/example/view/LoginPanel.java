package org.example.view;

import org.example.entity.User;
import org.example.entity.AdminUser;
import org.example.entity.ClientUser;
import org.example.util.UtilEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class LoginPanel extends JPanel {
    private JTextField emailField;
    private JButton loginButton;
    private JLabel statusLabel;
    private JFrame mainFrame;

    public LoginPanel(JFrame frame) {
        this.mainFrame = frame;
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);


        loginButton = new JButton("Iniciar Sesión");
        add(loginButton);

        statusLabel = new JLabel();
        add(statusLabel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                User user = authenticateUser(email);
                if (user != null) {
                    if (user instanceof AdminUser) {
                        statusLabel.setText("Inicio de sesión exitoso - Admin");
                        mainFrame.getContentPane().removeAll();
                        mainFrame.add(new AdminPanel());
                    } else if (user instanceof ClientUser) {
                        statusLabel.setText("Inicio de sesión exitoso - Client");
                        mainFrame.getContentPane().removeAll();
                        mainFrame.add(new ClientPanel());
                    }
                    mainFrame.revalidate();
                    mainFrame.repaint();
                } else {
                    statusLabel.setText("Usuario no encontrado");
                }
            }
        });
    }

    private User authenticateUser(String email) {
        EntityManager em = UtilEntity.getEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", email);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
}

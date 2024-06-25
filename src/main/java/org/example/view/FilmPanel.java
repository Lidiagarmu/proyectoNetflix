package org.example.view;

import org.example.entity.Film;
import org.example.util.UtilEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class FilmPanel extends JPanel {
    private JTextArea filmArea;
    private JButton refreshButton;

    public FilmPanel() {
        setLayout(new BorderLayout());

        filmArea = new JTextArea();
        add(new JScrollPane(filmArea), BorderLayout.CENTER);

        refreshButton = new JButton("Actualizar Películas");
        add(refreshButton, BorderLayout.SOUTH);

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshFilms();
            }
        });

        refreshFilms();
    }

    private void refreshFilms() {
        EntityManager em = UtilEntity.getEntityManager();
        TypedQuery<Film> query = em.createQuery("SELECT f FROM Film f", Film.class);
        List<Film> films = query.getResultList();
        filmArea.setText("");
        for (Film film : films) {
            filmArea.append(film.toString() + "\n\n");
        }
        em.close();
    }
}

package views;

import controllers.PatientsController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class ControlsPartial {
    private PatientsController controller;
    private JPanel panel = new JPanel(new GridLayout(15, 1, 0, 10));

    public ControlsPartial(PatientsController controller) {
        this.controller = controller;
        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");
        JButton deleteButton = new JButton("Delete");

        addButton.addActionListener(getAddButtonListener());

        panel.add(addButton);
        panel.add(searchButton);
        panel.add(deleteButton);
    }

    public JPanel getPanel() {
        return panel;
    }

    private ActionListener getAddButtonListener() {
        return e -> controller.newRecord();
    }
}
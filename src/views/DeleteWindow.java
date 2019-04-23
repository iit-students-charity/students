package views;

import controllers.StudentsController;
import models.Parent;
import models.Student;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class DeleteWindow {
    private StudentsController controller;
    private JFrame deleteWindow;

    public DeleteWindow(StudentsController controller) {
        this.controller = controller;
        deleteWindow = new JFrame("Delete");
        deleteWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteWindow.setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        StudentFormPartial form = new StudentFormPartial(controller);
        JPanel panel = form.getPanel();

        JButton closeButton = new JButton("Close");
        JButton deleteButton = new JButton("Delete");
        closeButton.addActionListener(getCloseButtonListener());
        deleteButton.addActionListener(getSubmitButtonListener(form));
        panel.add(closeButton);
        panel.add(deleteButton);

        contentPane.add(panel);

        deleteWindow.setContentPane(contentPane);
        deleteWindow.pack();
    }

    public void show() {
        deleteWindow.setVisible(true);
    }

    public void dispose() {
        deleteWindow.dispose();
    }

    private ActionListener getCloseButtonListener() {
        return e -> dispose();
    }

    private ActionListener getSubmitButtonListener(StudentFormPartial form) {
        return e -> {
            Student student = new Student();
            student.setName(form.getStudentName());
            student.setLastname(form.getStudentLastName());
            student.setSurname(form.getStudentSurname());

            student.setSistersCount(Boolean.parseBoolean(form.getStudentSistersCount()) ? Integer.valueOf(form.getStudentSistersCount()) : 0);
            student.setBrothersCount(Boolean.parseBoolean(form.getStudentBrothersCount()) ? Integer.valueOf(form.getStudentBrothersCount()) : 0);

            Parent mother = new Parent();
            mother.setName(form.getMotherName());
            mother.setLastName(form.getMotherLastName());
            mother.setSurname(form.getMotherSurname());
            mother.setEarnings(Boolean.parseBoolean(form.getMotherEarnings()) ? Double.valueOf(form.getMotherEarnings()) : 0);

            student.setMother(mother);

            Parent father = new Parent();
            father.setName(form.getFatherName());
            father.setLastName(form.getFatherLastName());
            father.setSurname(form.getFatherSurname());
            father.setEarnings(Boolean.parseBoolean(form.getFatherEarnings()) ? Double.valueOf(form.getFatherEarnings()) : 0);

            student.setFather(father);

            controller.remove(student);
        };
    }
}
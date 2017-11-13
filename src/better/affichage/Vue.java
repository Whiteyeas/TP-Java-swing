package better.affichage;

import javafx.application.Application;

import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingUtilities.invokeLater;

public class Vue {
    public static void main(String[] args) {
        invokeLater(Vue::window);
    }
    private static void window(){
        JFrame frame = new JFrame("Gestion");
        JPanel container = new JPanel();
        frame.setTitle("Grid Bag Layout");
        frame.setSize(720, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        //c.gridwidth = 10;
        c.weightx = 50;
        //c.weighty = 50;
        container.add(new JButton("Ajouter un Employe"), c);
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 50;
       // c.weighty = 50;
        container.add(new JButton("Afficher"), c);
        frame.setContentPane(container);
        frame.setVisible(true);
    }
}

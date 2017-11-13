package better.affichage;

import javafx.application.Application;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.Vector;

import static javax.swing.SwingConstants.SOUTH;
import static javax.swing.SwingUtilities.invokeLater;

public class Vue {
    private JFrame frame = new JFrame("Gestion");
    private JPanel panelMenu = new JPanel();
    private JPanel panelAjout = new JPanel();
    private JPanel panelAffichage = new JPanel();
    public void affichageMenu() {
        init();
        frame.setContentPane(panelMenu);
        frame.setVisible(true);
    }
    private void init(){
        //frame
        frame.setTitle("Gestion d'employes");
        frame.setSize(720, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Panel du menu
        JButton buttonAjoutEmpl = new JButton("Ajouter un Employe");
        JButton buttonAfficher = new JButton("Afficher");
        buttonAfficher.addActionListener(actionEvent -> vueAfficher());
        buttonAjoutEmpl.addActionListener(actionEvent -> vueAjout());
        panelMenu.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 10;
        c.weightx = 50;
        panelMenu.add(buttonAjoutEmpl, c);
        c.gridx = 2;
        c.gridy = 10;
        c.weightx = 50;
        panelMenu.add(buttonAfficher, c);

        // Panel d'affichage des employes
        panelAffichage.setLayout(new BorderLayout());
        JLabel titre = new JLabel("Tout les employes");
        JButton buttonRetour = new JButton("Retour au menu");
        buttonRetour.addActionListener(actionEvent -> retourMenu());
        panelAffichage.add(titre, BorderLayout.NORTH);
        panelAffichage.add(buttonRetour, BorderLayout.SOUTH);

        //Panel d'ajout d'employee
        panelAjout.setLayout(new GridBagLayout());
        JLabel prenomLabel = new JLabel("Prenom");
        JLabel nomLabel = new JLabel("Nom");
        JLabel ageLabel = new JLabel("Age");
        JLabel dateEntreeLabel = new JLabel("Date d'entree");
        JLabel paramLabel = new JLabel("Paramètre pour salaire");
        JLabel typeLabel = new JLabel("Type d'employe");
        JButton buttonRetour2 = new JButton("Retour au menu");
        buttonRetour2.addActionListener(actionEvent -> retourMenu());
        JButton buttonCreer = new JButton("Creer le nouvel employee");
        buttonCreer.addActionListener(actionEvent -> retourMenu());
        JTextField prenomField = new JTextField(40);
        JTextField nomField = new JTextField(40);
        JTextField ageField = new JTextField(40);
        JTextField dateEntreeField = new JTextField(40);
        JTextField paramField = new JTextField(40);
        JComboBox<String> typeBox = new JComboBox<>();
        typeBox.addItem("Vendeur");
        typeBox.addItem("Representant");
        typeBox.addItem("Technicien");
        typeBox.addItem("Manutentionnaire");
        typeBox.addItem("Technicien à risque");
        typeBox.addItem("Manutentionnaire à risque");
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 50;
        panelAjout.add(prenomLabel, c);
        c.gridx = 2;
        panelAjout.add(prenomField, c);
        c.gridx = 0;
        c.gridy = 1;
        panelAjout.add(nomLabel, c);
        c.gridx = 2;
        panelAjout.add(nomField, c);
        c.gridx = 0;
        c.gridy = 2;
        panelAjout.add(ageLabel, c);
        c.gridx = 2;
        panelAjout.add(ageField, c);
        c.gridx = 0;
        c.gridy = 3;
        panelAjout.add(dateEntreeLabel, c);
        c.gridx = 2;
        panelAjout.add(dateEntreeField, c);
        c.gridx = 0;
        c.gridy = 4;
        panelAjout.add(paramLabel, c);
        c.gridx = 2;
        panelAjout.add(paramField, c);
        c.gridx = 0;
        c.gridy = 5;
        panelAjout.add(typeLabel,c);
        c.gridx = 2;
        panelAjout.add(typeBox,c);
        c.gridy = 6;
        panelAjout.add(buttonCreer, c);
        c.gridx = 1;
        panelAjout.add(buttonRetour2, c);
    }
    private void retourMenu(){
        panelAffichage.setVisible(false);
        panelAjout.setVisible(false);
        panelMenu.setVisible(true);
        frame.setContentPane(panelMenu);
        frame.repaint();
    }

    private void vueAfficher(){
        panelMenu.setVisible(false);
        panelAffichage.setVisible(true);
        JTable table = new JTable(new Object[][]{
                {"a", "b"},
                {"c","d"}
        }, new String[]{"gauche","droite"});
        panelAffichage.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.setContentPane(panelAffichage);
        frame.repaint();
    }

    private void vueAjout(){
        panelMenu.setVisible(false);
        panelAjout.setVisible(true);
        frame.setContentPane(panelAjout);
        frame.repaint();
    }
}

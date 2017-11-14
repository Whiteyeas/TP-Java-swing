package better.affichage;

import better.domain.*;
import better.service.Personnel;

import javax.swing.*;
import java.awt.*;

public class PanelAjout extends JPanel{
    private JPanel panelMenu;
    private JFrame frame;
    private Personnel p;
    private GridBagConstraints c = new GridBagConstraints();
    private String attribut = new String();
    private JTextField prenomField = new JTextField(40);
    private JTextField nomField = new JTextField(40);
    private JTextField ageField = new JTextField(40);
    private JTextField dateEntreeField = new JTextField(40);
    private JTextField paramField = new JTextField(40);

    private void init (){  // parametre du panel

        this.setLayout(new GridBagLayout());  // parametre pour le positionnement des elements sur la GridBagLayout
        c.weighty = 50;
        addButton();
        addTypefield();
        addLabel();
        addTypeBox();
    }
    private void addButton (){  //Ajout des boutons
        JButton buttonRetour2 = new JButton("Retour au menu");
        buttonRetour2.addActionListener(actionEvent -> retourMenu());   //liaison d'une fonction a l'evenement click sur le bouton
        JButton buttonCreer = new JButton("Creer le nouvel employee");
        buttonCreer.addActionListener(actionEvent -> creerEmpl());
        c.gridx = 2;
        c.gridy = 6;
        this.add(buttonCreer, c);
        c.gridx = 1;
        this.add(buttonRetour2, c);
    }
    private void addLabel (){   //Ajout des labels
        String listLabel[]={"Prenom", "Nom", "Age", "Date d'entree", "paramètre pour salaire", "Type d'employe"};
        JLabel toutLabel[] = new JLabel[6];
        int i = 0;
        c.gridx = 0;
        c.gridy = 0;
        for (String label:listLabel) {
            toutLabel[i] = new JLabel(listLabel[i]);
            c.gridy = i;
            this.add(toutLabel[i], c);
            i++;
        }
    }
    private void addTypefield(){    //Ajout des typefield
        c.gridy = 0;
        c.gridx = 2;
        this.add(prenomField, c);
        c.gridy = 1;
        this.add(nomField, c);
        c.gridy = 2;
        this.add(ageField, c);
        c.gridy = 3;
        this.add(dateEntreeField, c);
        c.gridy = 4;
        this.add(paramField, c);

    }
    private void addTypeBox (){     //Ajout des typebox
        JComboBox<String> typeBox = new JComboBox<>();
        typeBox.addActionListener(actionEvent -> attribut = String.valueOf(typeBox.getSelectedItem()));
        typeBox.addItem("Vendeur");
        typeBox.addItem("Representant");
        typeBox.addItem("Technicien");
        typeBox.addItem("Manutentionnaire");
        typeBox.addItem("TechnARisque");
        typeBox.addItem("ManutARisque");
        c.gridy = 5;
        c.gridx = 2;
        this.add(typeBox,c);
    }
    private void retourMenu(){      // affichage du panel menu
        this.setVisible(false);
        panelMenu.setVisible(true);
        frame.setContentPane(panelMenu);
        frame.revalidate();
    }
    public void creerEmpl (){       // creation du nouvel employe
        try {
            Employee e = (Employee) Class.forName("better.domain."+attribut)
                    .getConstructor(String.class, String.class, int.class, String.class, double.class)
                    .newInstance((String)prenomField.getText(), (String)nomField.getText(),  Integer.parseInt(ageField.getText()), (String)dateEntreeField.getText(), Double.parseDouble(paramField.getText()));
            p.ajouterEmploye(e);
            System.out.println(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public PanelAjout (JPanel panelMenu, JFrame frame, Personnel p){
        super();
        this.panelMenu = panelMenu;
        this.frame = frame;
        this.p = p;
        init();
    }
}

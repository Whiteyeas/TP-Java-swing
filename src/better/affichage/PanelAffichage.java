package better.affichage;

import better.service.Personnel;

import javax.swing.*;
import java.awt.*;

public class PanelAffichage extends JPanel{
    private JPanel panelMenu;
    private JFrame frame;
    private Personnel p;

    private void init (){  // parametre du panel
        this.setLayout(new BorderLayout());
        JLabel titre = new JLabel("Tout les employes                                                                                          salaire moyen :    " + p.salaireMoyen());
        JButton buttonRetour = new JButton("Retour au menu");
        buttonRetour.addActionListener(actionEvent -> retourMenu());    //liaison d'une fonction a l'evenement click sur le bouton
        this.add(titre, BorderLayout.NORTH);
        this.add(buttonRetour, BorderLayout.SOUTH);
    }
    private void retourMenu(){  // affichage du panel du menu
        this.setVisible(false);
        panelMenu.setVisible(true);
        frame.setContentPane(panelMenu);
        frame.revalidate();
    }

    public PanelAffichage (JPanel panelMenu, JFrame frame, Personnel p){
        super();
        this.panelMenu = panelMenu;
        this.frame = frame;
        this.p = p;
        init();
    }

}

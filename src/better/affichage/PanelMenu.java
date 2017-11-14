package better.affichage;

import better.service.Personnel;
import com.sun.org.apache.xpath.internal.operations.String;

import javax.swing.*;
import java.awt.*;

public class PanelMenu extends JPanel {
    JFrame frame;
    JPanel panelAffichage;
    JPanel panelAjout;
    private Personnel p;

    private void init (){
        JButton buttonAjoutEmpl = new JButton("Ajouter un Employe");
        JButton buttonAfficher = new JButton("Afficher");
        buttonAfficher.addActionListener(actionEvent -> vueAfficher());
        buttonAjoutEmpl.addActionListener(actionEvent -> vueAjout());
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 10;
        c.weightx = 50;
        this.add(buttonAjoutEmpl, c);
        c.gridx = 2;
        c.weightx = 50;
        this.add(buttonAfficher, c);
    }
    private void vueAfficher(){     // affichage de la vue des employes
        java.lang.String[] type = {"Type", "Prenom", "Nom", "Age", "Date d'entree", "Salaire"};
        this.setVisible(false);
        panelAffichage = new PanelAffichage(this, frame, p);
        panelAffichage.setVisible(true);
        JTable table = new JTable(p.tableauSalaires(), type);  // recuperation des employes sous forme de tableau
        panelAffichage.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.setContentPane(panelAffichage);
        frame.revalidate();
    }

    private void vueAjout(){        // affichage de la vue de l'ajout de nouvel employe
        this.setVisible(false);
        panelAjout = new PanelAjout(this, frame, p);
        panelAjout.setVisible(true);
        frame.setContentPane(panelAjout);
        frame.revalidate();
    }

    public PanelMenu (JFrame frame, Personnel p){
        super();
        init();
        this.p = p;
        this.frame = frame;
    }
}

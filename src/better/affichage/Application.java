package better.affichage;

import better.service.Personnel;
import javax.swing.*;
import java.awt.*;

public class Application {
    // les differents containers
    private JFrame frame = new JFrame("Gestion");
    private JPanel panelMenu;
    private Personnel p;


    public void run() { // lancement de la vue et affichage du menu
        init();
        frame.setContentPane(panelMenu);
        frame.setVisible(true);
    }
    private void init(){    // paramètre de le frame
        //frame
        frame.setTitle("Gestion d'employes");
        frame.setSize(720, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public Application(Personnel p){
        this.p = p;
        panelMenu = new PanelMenu(frame, p);
    }
}

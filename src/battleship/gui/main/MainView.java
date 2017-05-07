

/** VERSION 2 - BUTTONS */

package battleship.gui.main;

/**
 * Created by arthurdeschamps on 05.05.17.
 */

import battleship.app.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.AbstractAction;
import javax.swing.*;
import java.awt.event.*;

import battleship.gui.boats.BoatSelector;
import battleship.gui.main.DrawGrid;
import net.miginfocom.swing.MigLayout;

public class MainView extends JFrame {


    // Components
    private BoatSelector boatSelector;

    public MainView(){

        super("MigLayout Basic");

        // Components initialization
        this.setBoatSelector(new BoatSelector());


        setTitle("Battleship - WarZone");
        setSize(1200,800);
        setLocationRelativeTo(null); //Center
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(getMainView());
        setVisible(true);

    }

    public class Abandon extends AbstractAction { //Actions for buttons
        public Abandon(String texte) {
            super(texte);
        }

        public void actionPerformed(ActionEvent e) {

            if (JOptionPane.showConfirmDialog(null, "Are you sure you wanna quit like a lil' coward?", "WARNING",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                GameState.abandon(); //Quit the game
            }

        }
    }

    public class Start extends AbstractAction {

        private int a = 1; //To create only one instance of player

        public Start(String texte){
            super(texte);
        }


        public void actionPerformed(ActionEvent e) {
            if (this.a == 1){
                //Player user = new Player(); //Start the game by creating a new player
                this.a = 0; //blocks player from clicking multiple times on "start" button and therefore
                            //creating multiple instances of player.
            }

        }
    }

    //Designing the board

    private JPanel getMainView(){ //Set buttons in pannel

        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("debug, fillx", "[][grow][]"));

        JButton b1 = new JButton(new Start("Start"));
        panel.add(b1, "growx, w " + this.getWidth()/5);

        //Opponent Grid
        panel.add(new DrawGrid(), "span 2 3 " + this.getWidth()/5 + ", grow, wrap, h " + this.getWidth()/4);

        JButton b2 = new JButton(new Abandon("Abandon"));
        panel.add(b2, "growx, wrap, w " + this.getWidth()/5);

        JLabel boatOrientation = new JLabel("Boat orientation select should be here");
        panel.add(boatOrientation, "w " + this.getWidth()/5 + ", grow, wrap, h " + this.getWidth()/4);

        //JLabel boatOrientation = new JLabel("Boat select should be here");
        panel.add(this.getBoatSelector(), "span 1 2 " + this.getWidth()/5 + ", grow, wrap, h " + this.getWidth()/3);

        //UserGrid
        panel.add(new DrawGrid(), "w " + this.getWidth()/5 + ", grow, wrap, h " + this.getWidth()/3);

        return panel;
    }


    public BoatSelector getBoatSelector() {
        return boatSelector;
    }

    public void setBoatSelector(BoatSelector boatSelector) {
        this.boatSelector = boatSelector;
    }
}






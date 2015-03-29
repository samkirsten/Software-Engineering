package com.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GuiMainMenu extends JFrame
{

    private JLabel welcome;
    private JButton twoPlayerButton, quitGameButton, tournamentButton;



    public GuiMainMenu()
    {
        welcome = new JLabel("Welcome to the amazing ant game ", SwingConstants.CENTER);



        //SPecify handlers for each button and add (register) ActionListeners to each button.
        twoPlayerButton = new JButton("two-player mode");

        tournamentButton = new JButton("tournament mode");

        quitGameButton = new JButton("Quit game");

        setTitle("The com.model.Ant com.model.Game");
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 2));
        //Add things to the pane in the order you want them to appear (left to right, top to bottom)
        pane.add(welcome);
        pane.add(twoPlayerButton);
        pane.add(tournamentButton);

        pane.add(quitGameButton);

        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        quitGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });


        twoPlayerButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                GuiTwoPlayerMenu menu2 = new GuiTwoPlayerMenu();
                menu2.setVisible(true);

            }
        });

        tournamentButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                GuiTournamentMenu tMenu = new GuiTournamentMenu();
                tMenu.setVisible(true);


            }
        });
    }



    public static void main(String[] args)
    {
        GuiMainMenu m = new GuiMainMenu();
    }

}

package com.view;

import com.controller.ControllerImpl;
import com.controller.GameController;
import com.model.Game;
import com.model.GameImpl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;


public class GuiTwoPlayerMenu extends JFrame {

    JPanel panel;
    JLabel instruction;
    JLabel p1BrainStatus;
    JLabel p2BrainStatus;

    //files for loading in 2 brains
    public File p1Brain ;
    public File p2Brain ;

    public Game singleGame;
    public GameController singleController;

    Boolean p1Ready ;
    Boolean p2Ready ;
    //ControllerImpl gameController ;
    public GuiTwoPlayerMenu() {
        //gameController = new ControllerImpl() ;
        initLayout();
    }

    public final void initLayout() {
        //a label for instructions
        instruction = new JLabel("Please load your brains here, and press Start Game ", SwingConstants.CENTER);
        //initialise game and controller
        singleGame = new GameImpl();
        singleController = new ControllerImpl();

        //initialise text lables
        p1BrainStatus = new JLabel("Player 1's Brain : Not loaded",SwingConstants.CENTER);
        p2BrainStatus = new JLabel("Player 2's Brain : Not loaded",SwingConstants.CENTER);

        //initialize booleans
        p1Ready = false ;
        p2Ready = false ;

        //setting up layout and panel
        panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new GridLayout(6, 1));

        //make new load brain button for player 1
        JButton player1 = new JButton("Player 1");
        player1.setPreferredSize(new Dimension(10, 10));
        player1.setBounds(50, 60, 80, 30);
        player1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFileChooser chooser = new JFileChooser();
                //chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("Brain 1");

                //check for brain goes here. if OKAY, load, if not, tell user.
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    //System.out.println("Player 1 's brain : " + chooser.getSelectedFile());
                    p1BrainStatus.setText("Player1 's Brain : [" + chooser.getName(chooser.getSelectedFile()) + " ]is loaded.");
                    p1Brain = chooser.getSelectedFile() ;
                    p1Ready = true;
                } else {
                    p1BrainStatus.setText("Your Brain is not working, retry! ");
                }

            }
        });

        //load brain button for player 2
        JButton player2 = new JButton("Player 2");
        player2.setPreferredSize(new Dimension(10, 10));
        player2.setBounds(50, 60, 80, 30);
        player2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFileChooser chooser = new JFileChooser();
                //chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("Brain 1");

                //check for brain goes here. if OKAY, load, if not, tell user.
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    //System.out.println("Player 2 's brain : " + chooser.getSelectedFile());
                    p2BrainStatus.setText("Player2 's Brain : [" + chooser.getName(chooser.getSelectedFile()) + " ]is loaded.");
                    p2Brain = chooser.getSelectedFile() ;

                    p2Ready = true;
                } else {
                    p2BrainStatus.setText("Your Brain is not working, retry! ");
                }

                //checking for the brain goes here


            }
        });

        //start game button
        JButton startGame = new JButton("START GAME");
        startGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //check brain and print out if brain is okay.
                // then runs game class
                if (p1Ready && p2Ready) {
                    // GameGUI game = new GameGUI();
                    //GuiMainMenu m = new GuiMainMenu() ;

                }



            }
        });

        panel.add(instruction);
        panel.add(player1);
        panel.add(player2);
        panel.add(p1BrainStatus);
        panel.add(p2BrainStatus);
        panel.add(startGame);

        setTitle("2-player Mode");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {


        GuiTwoPlayerMenu ex = new GuiTwoPlayerMenu();
        ex.setVisible(true);


    }
}
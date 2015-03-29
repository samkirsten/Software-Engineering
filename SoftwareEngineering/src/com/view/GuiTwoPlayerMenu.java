package com.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class GuiTwoPlayerMenu extends JFrame {

    JPanel panel;
    JLabel instruction;
    JLabel p1Brain ;
    JLabel p2Brain;

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
        p1Brain = new JLabel("Player 1's Brain : Not loaded",SwingConstants.CENTER);

        p2Brain = new JLabel("Player 2's Brain : Not loaded",SwingConstants.CENTER);
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
                    System.out.println("Player 1 's brain : " + chooser.getSelectedFile());
                    p1Brain.setText("Player1 's Brain : ["+chooser.getName(chooser.getSelectedFile())+" ]is loaded.");
                    p1Ready = true;
                } else {
                    System.out.println("Your Brain is not working, retry! ");
                }

                //checking for the brain goes here

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
                    System.out.println("Player 2 's brain : " + chooser.getSelectedFile());
                    p2Brain.setText("Player2 's Brain : ["+chooser.getName(chooser.getSelectedFile())+" ]is loaded.");
                    p2Ready = true;
                } else {
                    System.out.println("Your Brain is not working, retry! ");
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

                }

            }
        });

        panel.add(instruction);
        panel.add(player1);
        panel.add(player2);
        panel.add(p1Brain);
        panel.add(p2Brain);
        panel.add(startGame);

        setTitle("2-player Mode");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {


        GuiTwoPlayerMenu ex = new GuiTwoPlayerMenu();
        ex.setVisible(true);


    }
}
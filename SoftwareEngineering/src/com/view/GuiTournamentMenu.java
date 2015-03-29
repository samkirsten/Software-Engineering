package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GuiTournamentMenu extends JFrame {

    JPanel panel;

    JLabel instruction;
    JButton player1;
    JButton player2;
    JButton player3;
    JButton player4;
    JButton start ;

    JLabel p1Brain ;
    JLabel p2Brain;
    JLabel p3Brain ;
    JLabel p4Brain;


    Boolean p1Ready ;
    Boolean p2Ready ;
    Boolean p3Ready ;
    Boolean p4Ready ;


    public GuiTournamentMenu() {
        initLayout();
    }

    public final void initLayout() {
        //a label for instructions
        instruction = new JLabel("players, load brain for your ants ! ", SwingConstants.CENTER);
        p1Brain = new JLabel("Player 1's Brain : Not loaded",SwingConstants.CENTER);

        p2Brain = new JLabel("Player 2's Brain : Not loaded",SwingConstants.CENTER);

        p3Brain = new JLabel("Player 3's Brain : Not loaded",SwingConstants.CENTER);

        p4Brain = new JLabel("Player 4's Brain : Not loaded",SwingConstants.CENTER);

        //initialize booleans
        p1Ready = false;
        p2Ready = false;
        p3Ready = false;
        p4Ready = false;

        //setting up layout and panel
        panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new GridLayout(10, 1));

        //make new load brain button for player 1
        player1 = new JButton("Player 1");
        player1.setPreferredSize(new Dimension(10, 10));
        player1.setBounds(50, 60, 80, 30);
        player1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("Brain 1");


                //check for brain goes here. if OKAY, load, if not, tell user.
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    //System.out.println("Player 1 's brain : " + chooser.getSelectedFile());
                    p1Brain.setText("Player1 's Brain : ["+chooser.getName(chooser.getSelectedFile())+" ]is loaded.");
                    p1Ready = true;
                } else {
                    p1Brain.setText("Your Brain is not working, retry! ");
                }
            }
        });

        //load brain button for player 2
        player2 = new JButton("Player 2");
        player2.setPreferredSize(new Dimension(10, 10));
        player2.setBounds(50, 60, 80, 30);
        player2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("Brain 2");


                //check for brain goes here. if OKAY, load, if not, tell user.
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    //System.out.println("Player 2 's brain : " + chooser.getSelectedFile());
                    p2Brain.setText("Player2 's Brain : ["+chooser.getName(chooser.getSelectedFile())+" ]is loaded.");
                    p2Ready = true;
                } else {
                    p2Brain.setText("Your Brain is not working, retry! ");
                }


            }
        });


        player3 = new JButton("player3");
        player3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {



            }
        });

        player4 = new JButton("player4");
        player4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {



            }
        });

        //start game button
        start = new JButton("START GAME");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                //check if 4 brains are ready goes here
                GuiTournamentGameMenu tGame= new GuiTournamentGameMenu();
                tGame.setVisible(true);

            }
        });

        panel.add(instruction);
        panel.add(player1);
        panel.add(player2);
        panel.add(player3);
        panel.add(player4);
        panel.add(p1Brain);
        panel.add(p2Brain);
        panel.add(p3Brain);
        panel.add(p4Brain);

        panel.add(start);


        setTitle("Tournament Mode");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {


        GuiTournamentMenu ex = new GuiTournamentMenu();
        ex.setVisible(true);


    }
}
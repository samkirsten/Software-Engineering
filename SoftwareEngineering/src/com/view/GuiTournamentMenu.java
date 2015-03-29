package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class GuiTournamentMenu extends JFrame {

    JPanel panel;

    JLabel instruction;
    JButton player1;
    JButton player2;
    JButton player3;
    JButton player4;
    JButton start ;

    JLabel p1BrainStatus;
    JLabel p2BrainStatus;
    JLabel p3BrainStatus;
    JLabel p4BrainStatus;

    File p1Brain;
    File p2Brain;
    File p3Brain;
    File p4Brain;




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
        p1BrainStatus = new JLabel("Player 1's Brain : Not loaded",SwingConstants.CENTER);
        p2BrainStatus = new JLabel("Player 2's Brain : Not loaded",SwingConstants.CENTER);
        p3BrainStatus = new JLabel("Player 3's Brain : Not loaded",SwingConstants.CENTER);
        p4BrainStatus = new JLabel("Player 4's Brain : Not loaded",SwingConstants.CENTER);

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
                    p1BrainStatus.setText("Player1 's Brain : [" + chooser.getName(chooser.getSelectedFile()) + " ]is loaded.");
                    p1Brain = chooser.getSelectedFile();
                    p1Ready = true;
                } else {
                    p1BrainStatus.setText("Your Brain is not working, retry! ");
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
                    p2BrainStatus.setText("Player2 's Brain : [" + chooser.getName(chooser.getSelectedFile()) + " ]is loaded.");
                    p2Brain = chooser.getSelectedFile();

                    p2Ready = true;
                } else {
                    p2BrainStatus.setText("Your Brain is not working, retry! ");
                }


            }
        });


        player3 = new JButton("player3");
        player3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {


                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("Brain 3");


                //check for brain goes here. if OKAY, load, if not, tell user.
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    p3BrainStatus.setText("Player3 's Brain : [" + chooser.getName(chooser.getSelectedFile()) + " ]is loaded.");
                    p3Brain = chooser.getSelectedFile();

                    p3Ready = true;
                } else {
                    p3BrainStatus.setText("Your Brain is not working, retry! ");
                }


            }
        });

        player4 = new JButton("player4");
        player4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("Brain 4");


                //check for brain goes here. if OKAY, load, if not, tell user.
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    p4BrainStatus.setText("Player2 's Brain : [" + chooser.getName(chooser.getSelectedFile()) + " ]is loaded.");
                    p4Brain = chooser.getSelectedFile();

                    p4Ready = true;
                } else {
                    p4BrainStatus.setText("Your Brain is not working, retry! ");
                }



            }
        });

        //start game button
        start = new JButton("START GAME");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if (p1Ready&&p2Ready&&p3Ready&&p4Ready){

                    GuiTournamentGameMenu tGame= new GuiTournamentGameMenu(p1Brain,p2Brain,p3Brain,p4Brain);

                    tGame.setVisible(true);
                }else{
                    instruction.setText("Please make sure all brains are loaded !");
                    instruction.setForeground(Color.RED);
                }

                //check if 4 brains are ready goes here


            }
        });

        panel.add(instruction);
        panel.add(player1);
        panel.add(player2);
        panel.add(player3);
        panel.add(player4);
        panel.add(p1BrainStatus);
        panel.add(p2BrainStatus);
        panel.add(p3BrainStatus);
        panel.add(p4BrainStatus);

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
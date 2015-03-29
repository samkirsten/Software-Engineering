package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GameGUI3 extends JFrame implements ActionListener {

    JTabbedPane tab;
    JPanel gameTab;
    JPanel menuPanel;
    Boolean isSingleGame ;

    JLabel menuStatus;

    File p1Brain;
    File p2Brain;
    File p3Brain;
    File p4Brain;




    Boolean p1Ready ;
    Boolean p2Ready ;
    Boolean p3Ready ;
    Boolean p4Ready ;



    public GameGUI3() {

        setTitle("Game");
        tab = new JTabbedPane();
        getContentPane().add(tab);
        gameTab = new JPanel();
        menuPanel = new JPanel();
        createMenuPanel();




        setSize(600,400);
        menuPanel.setVisible(true);

        //tab.addTab("Tab1", gameTab);
        //tab.addTab("Tab2", menuPanel);
    }

    private void createMenuPanel(){
        //make radio buttons
        ButtonGroup gameButton = new ButtonGroup();
        JRadioButton singleGameButton = new JRadioButton("Single Game");
        JRadioButton tournamentGameButton = new JRadioButton("Tournament");
        gameButton.add(singleGameButton);
        gameButton.add(tournamentGameButton);

        menuStatus = new JLabel();
        menuPanel.setVisible(true);
        menuPanel.setLayout(new GridLayout(10, 1));

        //a label for instructions

        //initialize booleans
        p1Ready = false;
        p2Ready = false;
        p3Ready = false;
        p4Ready = false;

        //setting up layout and menuPanel
        //getContentPane().add(menuPanel);
        menuPanel.setLayout(new GridLayout(10, 1));

        if (singleGameButton.isSelected()){
            isSingleGame = true;
            menuStatus.setText("Swtiched to single game mode");
        }

        if (tournamentGameButton.isSelected()){
            isSingleGame = false;
        }

        //Button for player 1
        JButton p1 = new JButton("Player 1");
        p1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("Brain 1");

                //check for brain goes here. if OKAY, load, if not, tell user.
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    //System.out.println("Player 1 's brain : " + chooser.getSelectedFile());
                    menuStatus.setText("Player1 's Brain : [" + chooser.getName(chooser.getSelectedFile()) + " ]is loaded.");
                    p1Brain = chooser.getSelectedFile() ;
                    p1Ready = true;
                } else {
                    menuStatus.setText("Player 1's Brain is not working, retry! ");
                }
            }
        });



        //player 2 button
        JButton p2 = new JButton("Player 2");
        p1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("Brain 2");

                //check for brain goes here. if OKAY, load, if not, tell user.
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    //System.out.println("Player 2 's brain : " + chooser.getSelectedFile());
                    menuStatus.setText("Player2 's Brain : [" + chooser.getName(chooser.getSelectedFile()) + " ]is loaded.");
                    p2Brain = chooser.getSelectedFile() ;
                    p2Ready = true;
                } else {
                    menuStatus.setText("Player 2's Brain is not working, retry! ");
                }
            }
        });


        //Button for player 3
        JButton p3 = new JButton("Player 3");
        p1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("Brain 3");

                //check for brain goes here. if OKAY, load, if not, tell user.
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    //System.out.println("Player 3 's brain : " + chooser.getSelectedFile());
                    menuStatus.setText("Player3 's Brain : [" + chooser.getName(chooser.getSelectedFile()) + " ]is loaded.");
                    p3Brain = chooser.getSelectedFile() ;
                    p3Ready = true;
                } else {
                    menuStatus.setText("Player 3's Brain is not working, retry! ");
                }
            }
        });



        menuPanel.add(singleGameButton);
        menuPanel.add(tournamentGameButton);
        menuPanel.add(p1);
        menuPanel.add(p2);
        menuPanel.add(p3);
        menuPanel.add(menuStatus);


    }
    public static void main(String[] args) {

        GameGUI3 tp = new GameGUI3();
        tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tp.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Player 1")) {

        } else if (command.equals("Player2")) {


        } else if (command.equals("Tournament")) {

        }

    }

}

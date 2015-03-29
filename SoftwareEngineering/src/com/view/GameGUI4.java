package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class GameGUI4 extends JFrame {

    JPanel menuPanel;
    JLabel instruction;
    private JTable fixture, rank;
    private JPanel  tablePanel, mapPanel;
    private Container container;
    //make a java tab

    JTabbedPane tab;

    //indicates if it is a single game or not
    Boolean isSingleGame ;

    File p1Brain;
    File p2Brain;
    File p3Brain;
    File p4Brain;

    //indicates if each brain is ready to go
    Boolean p1Ready ;
    Boolean p2Ready ;
    Boolean p3Ready ;
    Boolean p4Ready ;


    public GameGUI4() {
        CreateUI();

    }
    private void CreateUI() {
        tab  = new JTabbedPane();

        container = getContentPane();
        container.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        createMenuPanel();
        //        createtablePanel();
        //      createmapPanel();

        tab.addTab("Game Page", container);
        tab.addTab("Load Brain Page", menuPanel);
        setContentPane(tab);

    }

    public final void createMenuPanel() {



        //a label for instructions
        instruction = new JLabel("players, load brain for your ants ! ", SwingConstants.CENTER);
        final JLabel p1BrainStatus = new JLabel("Player 1's Brain : Not loaded",SwingConstants.CENTER);
        final JLabel p2BrainStatus = new JLabel("Player 2's Brain : Not loaded",SwingConstants.CENTER);
        final JLabel p3BrainStatus = new JLabel("Player 3's Brain : Not loaded",SwingConstants.CENTER);
        final JLabel p4BrainStatus = new JLabel("Player 4's Brain : Not loaded",SwingConstants.CENTER);

        //initialize booleans
        p1Ready = false;
        p2Ready = false;
        p3Ready = false;
        p4Ready = false;

        //setting up layout and menuPanel
        menuPanel = new JPanel();
        //getContentPane().add(menuPanel);
        menuPanel.setLayout(new GridLayout(15, 1));

        //make new load brain button for player 1
        JButton player1 = new JButton("Player 1");
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
        JButton player2 = new JButton("Player 2");
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


        final JButton player3 = new JButton("player3");
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

        final JButton player4 = new JButton("player4");
        player4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("Brain 4");


                //check for brain goes here. if OKAY, load, if not, tell user.
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    p4BrainStatus.setText("Player4 's Brain : [" + chooser.getName(chooser.getSelectedFile()) + " ]is loaded.");
                    p4Brain = chooser.getSelectedFile();

                    p4Ready = true;
                } else {
                    p4BrainStatus.setText("Your Brain is not working, retry! ");
                }



            }
        });

        //make radio buttons
        ButtonGroup gameButton = new ButtonGroup();
        JRadioButton singleGameButton = new JRadioButton("Single Game Mode");
        singleGameButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                isSingleGame = true ;
                player3.setEnabled(false);
                player4.setEnabled(false);
                p3BrainStatus.setEnabled(false);
                p4BrainStatus.setEnabled(false);
            }
        });

        //set defalt button as single game
        singleGameButton.setSelected(true);
        isSingleGame = true ;
        player3.setEnabled(false);
        player4.setEnabled(false);
        p3BrainStatus.setEnabled(false);
        p4BrainStatus.setEnabled(false);

        JRadioButton tournamentGameButton = new JRadioButton("Tournament Mode");
        tournamentGameButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                isSingleGame = false ;
                player3.setEnabled(true);
                player4.setEnabled(true);
                p3BrainStatus.setEnabled(true);
                p4BrainStatus.setEnabled(true);

            }
        });
        gameButton.add(singleGameButton);
        gameButton.add(tournamentGameButton);


        menuPanel.add(singleGameButton, SwingConstants.CENTER);
        menuPanel.add(tournamentGameButton, SwingConstants.CENTER);

        menuPanel.add(instruction);
        menuPanel.add(player1);
        menuPanel.add(player2);
        menuPanel.add(player3);
        menuPanel.add(player4);
        menuPanel.add(p1BrainStatus);
        menuPanel.add(p2BrainStatus);
        menuPanel.add(p3BrainStatus);
        menuPanel.add(p4BrainStatus);



        setTitle("Please load your brains");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {


        GameGUI4 ex = new GameGUI4();
        ex.setVisible(true);


    }
}
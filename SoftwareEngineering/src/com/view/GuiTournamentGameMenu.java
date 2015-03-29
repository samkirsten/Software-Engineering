package com.view;

import com.controller.ControllerImpl;
import com.controller.GameController;
import com.model.Tournament;
import com.model.TournamentImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;


public class GuiTournamentGameMenu extends JFrame {

    JPanel panel;

    JLabel instruction;
    JButton game1;
    JButton game2;
    JButton game3;
    JButton game4;
    JButton game5;
    JButton game6;

    JButton start ;

    JLabel p1ScoreDisplay;
    JLabel p2ScoreDisplay;
    JLabel p3ScoreDisplay;
    JLabel p4ScoreDisplay;
    //initialise game and control
    Tournament tournament;
    GameController tController;

    //Brains
    File p1Brain;
    File p2Brain;
    File p3Brain;
    File p4Brain;

    //store the actual mark
    int p1Score;
    int p2Score;
    int p3Score;
    int p4Score;

    JLabel result;
    HashMap<File,Integer> resultScore ;

    public GuiTournamentGameMenu(File p1Brain,File p2Brain, File p3Brain, File p4Brain) {

        this.p1Brain = p1Brain ;
        this.p2Brain = p2Brain ;
        this.p3Brain = p3Brain ;
        this.p4Brain = p4Brain ;



        initLayout();
    }

    public final void initLayout() {
        //a label for instructions
        instruction = new JLabel("go for the games when ever you are ready ", SwingConstants.CENTER);
        p1ScoreDisplay = new JLabel("Player 1's Score: 0", SwingConstants.CENTER);
        p2ScoreDisplay = new JLabel("Player 2's Score: 0", SwingConstants.CENTER);
        p3ScoreDisplay = new JLabel("Player 3's Score: 0", SwingConstants.CENTER);
        p4ScoreDisplay = new JLabel("Player 4's Score: 0", SwingConstants.CENTER);
        result = new JLabel("Winner : - ");
        //set up game and tournaments
        tournament = new TournamentImpl();
        tController = new ControllerImpl() ;

        //setting up layout and panel
        panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new GridLayout(12, 1));

        //make new load brain button for player 1
        game1 = new JButton("Game 1 - P1 vs P2");
        game1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //call the game class and disable the button
                //GuiMainMenu test = new GuiMainMenu();

                //update of scores goes here
                resultScore = tController.beginTournametGame(p1Brain, p2Brain, tournament);
                p1Score = p1Score + resultScore.get(p1Brain);
                p1ScoreDisplay.setText("Player 1's Score: " + p1Score);

                p2Score = p2Score + resultScore.get(p2Brain);
                p2ScoreDisplay.setText("Player 2's Score: " + p1Score);

                //disable the button
                game1.setEnabled(false);

            }
        });

        //load brain button for player 2
        game2 = new JButton("Game 2 - P1 vs P3");
        game2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {


            }
        });


        game3 = new JButton("Game3 - P1 vs P4");
        game3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {


            }
        });

        game4 = new JButton("Game4 - P2 vs P3");
        game4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {



            }
        });

        game5 = new JButton("Game5 - P2 vs P4");
        game5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {



            }
        });

        game6 = new JButton("Game6 - P3 vs P4");
        game6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {



            }
        });


        panel.add(instruction);
        panel.add(game1);
        panel.add(game2);
        panel.add(game3);
        panel.add(game4);
        panel.add(game5);
        panel.add(game6);
        panel.add(p1ScoreDisplay);
        panel.add(p2ScoreDisplay);
        panel.add(p3ScoreDisplay);
        panel.add(p4ScoreDisplay);


        setTitle("Tournament Mode");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }


    public static void main(String[] args) {


        GuiTournamentMenu ex = new GuiTournamentMenu();
        ex.setVisible(true);


    }
}
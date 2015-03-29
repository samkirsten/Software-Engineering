package com.view;

import com.view.GuiMainMenu;
import com.view.GuiTournamentMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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

    JLabel score1;
    JLabel score2;
    JLabel score3;
    JLabel score4;

    //store the actual mark
    int score_1;
    int score_2;
    int score_3;
    int score_4;

    JLabel result;

    public GuiTournamentGameMenu() {
        initLayout();
    }

    public final void initLayout() {
        //a label for instructions
        instruction = new JLabel("go for the games when ever you are ready ", SwingConstants.CENTER);
        score1 = new JLabel("Player 1's Score: 0");
        score2 = new JLabel("Player 2's Score: 0");
        score3 = new JLabel("Player 3's Score: 0");
        score4 = new JLabel("Player 4's Score: 0");
        result = new JLabel("Winner : - ");
        //setting up layout and panel
        panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new GridLayout(12, 1));

        //make new load brain button for player 1
        game1 = new JButton("Game 1 - P1 vs P2");
        game1.setPreferredSize(new Dimension(10, 10));
        game1.setBounds(50, 60, 80, 30);
        game1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //call the game class and disable the button
                GuiMainMenu test = new GuiMainMenu();

                //update of scores goes here
                score_1 ++ ;
                score1.setText("Player 1's Score: "+score_1);

                game1.setEnabled(false);

            }
        });

        //load brain button for player 2
        game2 = new JButton("Game 2");
        game2.setPreferredSize(new Dimension(10, 10));
        game2.setBounds(50, 60, 80, 30);
        game2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {


            }
        });


        game3 = new JButton("Game3");
        game3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {


            }
        });

        game4 = new JButton("Game4");
        game4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {



            }
        });

        game5 = new JButton("Game5");
        game5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {



            }
        });

        game6 = new JButton("Game6");
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
        panel.add(score1);
        panel.add(score2);
        panel.add(score3);
        panel.add(score4);


        setTitle("Tournament Mode");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {


        GuiTournamentMenu ex = new GuiTournamentMenu();
        ex.setVisible(true);


    }
}
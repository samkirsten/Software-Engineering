package com.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class GameGUI2 extends JFrame implements ActionListener {

    private JTable fixture, rank;
    private JPanel menuPanel, tablePanel, mapPanel;
    private Container container;
    //make a java tab
    private JTabbedPane tabbedPane;



    public GameGUI2(){
        super("ss");

        CreateUI();
    }

    private void CreateUI(){
        tabbedPane = new JTabbedPane();

        container = getContentPane();
        container.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createMenuPanel();
        createtablePanel();
        createmapPanel();

        pack();
        setResizable(true);
        setVisible(true);

        tabbedPane.addTab("Game Page", container);
        tabbedPane.addTab("Load Brain Page", menuPanel);
    }

    private void createMenuPanel(){
        menuPanel = new JPanel();
        menuPanel.setVisible(true);
        menuPanel.setLayout(new BorderLayout(5,5));

        menuPanel.add(new JButton("Start Game"));
        menuPanel.add(new JButton("Single Game"));
        menuPanel.add(new JButton ("Tournament"));
        //container.add(menuPanel, BorderLayout.NORTH);

        //container.add(menuPanel, BorderLayout.NORTH);
    }

    private void createtablePanel(){
        tablePanel = new JPanel();

        fixture = new JTable();
        rank = new JTable();

        //tablePanel.add(fixture,BorderLayout.NORTH);
        //tablePanel.add(rank, BorderLayout.SOUTH);
        //container.add(tablePanel, BorderLayout.CENTER);

    }

    private void createmapPanel(){
        mapPanel = new JPanel();

       // container.add(mapPanel, BorderLayout.EAST);

    }

    public static void main(String[] args) {
        new GameGUI2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Start Game")) {
            //start game
        } else if (command.equals("Single Game")) {


        } else if (command.equals("Tournament")) {

        }

    }

}
package com.view;

import com.model.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.*;

public class GameGUI extends JFrame implements ActionListener {

    private static Cell[][] map;
    private Map Map;
    private int currentRound = 0;
    private Game game;
    private CellImg ci = new CellImg(3,map);
    private JButton b1, b2, b3, b4, b5, b6, startGame;
    private JTextField t1,t2,t3,t4;
    private JLabel l1, l2 , l3, l4, instruction, gameStatus;
    private ArrayList<JButton> Blist = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();
    private JPanel menuPanel, tablePanel, mapPanel, rankPanel,fixturePanel, loadPanel;
    private Container container;
    private JTabbedPane tab;

    public HashMap<String,File> inputBrains;

    //indicators for brain loading status
    private Boolean isSingleGame ;
    private Boolean p1Ready ;
    private Boolean p2Ready ;
    private Boolean p3Ready ;
    private Boolean p4Ready ;


    public GameGUI(){
        super("Software Engineering");

        list.add(0);
        list.add(1);
        list.add(2);
        list.add(4);

        CreateUI();
    }

    private void CreateUI(){

        container = getContentPane();
        container.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tab  = new JTabbedPane();

        createLoadPanel();
        createMenuPanel();
        createtablePanel();
        createmapPanel();

        pack();

        setResizable(false);
        setVisible(true);

        tab.addTab("Game Page", container);
        tab.addTab("Load Brain Page", loadPanel);
        setContentPane(tab);


    }



    private void createMenuPanel(){
        menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout());
        startGame = new JButton("start game");
        gameStatus = new JLabel("No Brains Loaded");
        menuPanel.add(startGame);
        menuPanel.add(gameStatus);
        menuPanel.setVisible(true);

        container.add(menuPanel, BorderLayout.NORTH);
    }



    private void createtablePanel(){
        b1 = new JButton("null");b1.setEnabled(false);
        b2 = new JButton("null");b2.setEnabled(false);
        b3 = new JButton("null");b3.setEnabled(false);
        b4 = new JButton("null");b4.setEnabled(false);
        b5 = new JButton("null");b5.setEnabled(false);
        b6 = new JButton("null");b6.setEnabled(false);
        tablePanel = new JPanel();
        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.PAGE_AXIS));

        fixturePanel = new JPanel();
        fixturePanel.setBorder(new TitledBorder (new LineBorder (Color.black, 5),"Tournament Fixture"));
        fixturePanel.setLayout (new BoxLayout (fixturePanel, BoxLayout.Y_AXIS));
        fixturePanel.add(makeButton("Setting up the Matches"));
        fixturePanel.add(b1);Blist.add(b1);
        fixturePanel.add(b2);Blist.add(b2);
        fixturePanel.add(b3);Blist.add(b3);
        fixturePanel.add(b4);Blist.add(b4);
        fixturePanel.add(b5);Blist.add(b5);
        fixturePanel.add(b6);Blist.add(b6);

        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                b1.setEnabled(false);

            }
        });
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                b2.setEnabled(false);

            }
        });
        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                b3.setEnabled(false);

            }
        });
        b4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                b4.setEnabled(false);

            }
        });
        b5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                b5.setEnabled(false);

            }
        });
        b6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                b6.setEnabled(false);


            }
        });

        rankPanel = new JPanel();
        rankPanel.setBorder(new TitledBorder (new LineBorder (Color.black, 5),"Rank"));
        rankPanel.setLayout(new GridLayout(4, 3));

        l1 = new JLabel("First");
        t1 = new JTextField("");
        t1.setEditable(false);
        rankPanel.add(l1);rankPanel.add(t1);
        l2 = new JLabel("Second");
        t2 = new JTextField("");
        t2.setEditable(false);
        rankPanel.add(l2);rankPanel.add(t2);
        l3 = new JLabel("Third");
        t3 = new JTextField("");
        t3.setEditable(false);
        rankPanel.add(l3);rankPanel.add(t3);
        l4 = new JLabel("Fourth");
        t4 = new JTextField("");
        t4.setEditable(false);
        rankPanel.add(l4);rankPanel.add(t4);



        tablePanel.add(fixturePanel,BorderLayout.NORTH);
        tablePanel.add(rankPanel, BorderLayout.SOUTH);
        tablePanel.setSize(new Dimension(400,300));
        container.add(tablePanel, BorderLayout.EAST);

    }

    private void createmapPanel(){
        //mapPanel = new JPanel();

        mapPanel = new Graphic();

        container.add(mapPanel, BorderLayout.CENTER);

    }

    private void update(Game game) {
        Map = game.getMap();
        map = Map.getMap();
        menuPanel = new Graphic();
    }

    public static void main(String[] args) {
        MapImpl m = new MapImpl();
        m.generateMap();
        map = m.getMap();
        new GameGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int k = 0; String bu = "b";
        String n = e.getActionCommand();

        if(n == "Setting up the Matches"){
            for(int a = 0; a < list.size()-1;a++){
                for(int b= a+1; b < list.size() ; b++){
                    System.out.println(a + " " + b);
                    Blist.get(k).setText(a + " vs " + b	);
                    Blist.get(k).setEnabled(true);
                    System.out.println(k);
                    k++;
                }
            }

        }

    }

    private JButton makeButton(String name){
        JButton m = new JButton(name);
        m.addActionListener(this);
        return m;
    }

    class Graphic extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            super.paintComponent(g2);
            for (int j=0;j<150;j++) {
                for (int i=0;i<150;i++) {
                    if(map[i][j].getContents() == '+'){
                        ci.drawHex(i,j,g2,Color.RED);
                    }else if(map[i][j].getContents() == '-'){
                        ci.drawHex(i,j,g2,Color.BLACK);
                    }else if(map[i][j].getContents() == '#'){
                        ci.drawHex(i,j,g2,Color.gray);
                    }else if(map[i][j].getContents() == '.'){
                        ci.drawHex(i,j,g2,Color.WHITE);
                    }else {
                        ci.drawHex(i,j,g2,Color.GREEN);
                    }
                }
            }
        }
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(610, 620);
        }


    };



    private void createLoadPanel() {



        inputBrains = new HashMap<String,File>();
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
        loadPanel = new JPanel();
        //getContentPane().add(menuPanel);
        loadPanel.setLayout(new GridLayout(15, 1));

        //make new load brain button for player 1
        JButton player1 = new JButton("Player 1");
        player1.setPreferredSize(new Dimension(10, 10));
        player1.setBounds(50, 60, 80, 30);
        player1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("Brain 1");


                Map m = new MapImpl();
                Colony c = new ColonyImpl(Colour.BLACK);
                Brain brain = new BrainImpl(m, c);

                //check if brain is syntatically correct


                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION && brain.loadBrain(chooser.getSelectedFile())) {
                    if (inputBrains.containsValue(chooser.getSelectedFile())) {
                        p1BrainStatus.setText("Your brain is duplicated, retry ! ");

                    } else {
                        p1BrainStatus.setText("Player1 's Brain : [" + chooser.getName(chooser.getSelectedFile()) + " ]is loaded.");
                        inputBrains.put("player1", chooser.getSelectedFile());
                        p1Ready = true;
                    }
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


                Map m = new MapImpl();
                Colony c = new ColonyImpl(Colour.BLACK);
                Brain brain = new BrainImpl(m, c);

                //check if brain is syntatically correct


                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION && brain.loadBrain(chooser.getSelectedFile())) {
                    if (inputBrains.containsValue(chooser.getSelectedFile())) {
                        p2BrainStatus.setText("Your brain is duplicated, retry ! ");

                    } else {
                        p2BrainStatus.setText("Player1 's Brain : [" + chooser.getName(chooser.getSelectedFile()) + " ]is loaded.");
                        inputBrains.put("player2", chooser.getSelectedFile());
                        p2Ready = true;
                    }
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

                Map m = new MapImpl();
                Colony c = new ColonyImpl(Colour.BLACK);
                Brain brain = new BrainImpl(m , c);

                //check if brain is syntatically correct

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION && brain.loadBrain(chooser.getSelectedFile())) {
                    if(inputBrains.containsValue(chooser.getSelectedFile())){
                        p3BrainStatus.setText("Your brain is duplicated, retry ! ");

                    }else {
                        p3BrainStatus.setText("Player3 's Brain : [" + chooser.getName(chooser.getSelectedFile()) + " ]is loaded.");
                        inputBrains.put("player3", chooser.getSelectedFile());
                        p3Ready = true;
                    }
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


                Map m = new MapImpl();
                Colony c = new ColonyImpl(Colour.BLACK);
                Brain brain = new BrainImpl(m , c);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION && brain.loadBrain(chooser.getSelectedFile())) {
                    if(inputBrains.containsValue(chooser.getSelectedFile())){
                        p4BrainStatus.setText("Your brain is duplicated, retry ! ");

                    }else {
                        p4BrainStatus.setText("Player3 's Brain : [" + chooser.getName(chooser.getSelectedFile()) + " ]is loaded.");
                        inputBrains.put("player3", chooser.getSelectedFile());
                        p4Ready = true;
                    }
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

                //make new brain list
                inputBrains = new HashMap<>();
                p1BrainStatus.setText("Player 1's Brain : Not loaded");
                p2BrainStatus.setText("Player 2's Brain : Not loaded");
                p3BrainStatus.setText("Player 3's Brain : Not loaded");
                p4BrainStatus.setText("Player 4's Brain : Not loaded");
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

                //make new brain list
                inputBrains = new HashMap<>();
                p1BrainStatus.setText("Player 1's Brain : Not loaded");
                p2BrainStatus.setText("Player 2's Brain : Not loaded");
                p3BrainStatus.setText("Player 3's Brain : Not loaded");
                p4BrainStatus.setText("Player 4's Brain : Not loaded");



            }
        });
        gameButton.add(singleGameButton);
        gameButton.add(tournamentGameButton);


        loadPanel.add(singleGameButton, SwingConstants.CENTER);
        loadPanel.add(tournamentGameButton, SwingConstants.CENTER);

        loadPanel.add(instruction);
        loadPanel.add(player1);
        loadPanel.add(player2);
        loadPanel.add(player3);
        loadPanel.add(player4);
        loadPanel.add(p1BrainStatus);
        loadPanel.add(p2BrainStatus);
        loadPanel.add(p3BrainStatus);
        loadPanel.add(p4BrainStatus);



        setTitle("Please load your brains");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}


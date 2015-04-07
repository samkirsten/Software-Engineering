package com.view;

import com.controller.GameController;
import com.model.*;
import com.controller.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.model.exceptions.AntNotFoundException;
import com.sun.org.apache.xpath.internal.operations.Bool;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameGUI extends JFrame implements ActionListener {

    private Map Map;
    private int currentRound = 0;
    private Game game;
    private JButton b1, b2, b3, b4, b5, b6, startGame;
    private JTextField t1, t2, t3, t4;
    private JTextField n1, n2, n3, n4;
    private JLabel l1, l2, l3, l4, instruction, gameStatus;
    private ArrayList<JButton> Blist = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();
    private JPanel menuPanel, tablePanel, rankPanel, fixturePanel, loadPanel;
    private JPanel mapPanel;
    private Container container;
    private JTabbedPane tab;
    private JDialog gameover;
    private Graphic c;
    private BufferedImage firstImage;

    private List<Game> loadedGames = new ArrayList<>();

    public HashMap<String, File> inputBrains;
    public ArrayList<String> playerNamesOrder;
    public HashMap<Integer, String> playerNames;

    //fixtures list
    private List<Game> fixtures = new ArrayList<>();

    //indicators for brain loading status
    private Boolean isSingleGame = true;
    private Boolean isRandomWorld = true;

    private Boolean p1Ready;
    private Boolean p2Ready;
    private Boolean p3Ready;
    private Boolean p4Ready;

    private File customizedWorldFile = null;
    private Tournament tournament;
    private GameController controller;


    /**
     * This constructor takes a tournament object, initialize a new controller and creates the GUI
     * @param t
     */
    public GameGUI(Tournament t) {
        super("Software Engineering");
        tournament = t;
        t.setGUI(this);
        controller = new ControllerImpl();
        CreateUI();
        setSize(1000,1000);
    }

    /**
     * This method creates the container and main panels.
     * It also put the panels that has been created into a Tab panel
     */
    private void CreateUI() {

        container = getContentPane();
        container.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tab = new JTabbedPane();

        createLoadPanel();
        createMenuPanel();
        createTablePanel();
        createMapPanel();

        pack();

        setResizable(true);
        setVisible(true);

        tab.addTab("Load Brain Page", loadPanel);
        tab.addTab("Game Page", container);
        setContentPane(tab);
        tab.setEnabledAt(1, false);


    }


    /**
     * This method creates the menu panel which contains the Start Game button
     */
    private void createMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout());
        startGame = makeButton("start game");
        gameStatus = new JLabel("No Brains Loaded");
        menuPanel.add(startGame);
        menuPanel.add(gameStatus);
        menuPanel.setVisible(true);

        container.add(menuPanel, BorderLayout.NORTH);
    }


    /**
     * This method creates the table panel which contains the tournament buttons and the result table
     */
    private void createTablePanel() {
        b1 = new JButton("null");
        b1.setEnabled(false);
        b2 = new JButton("null");
        b2.setEnabled(false);
        b3 = new JButton("null");
        b3.setEnabled(false);
        b4 = new JButton("null");
        b4.setEnabled(false);
        b5 = new JButton("null");
        b5.setEnabled(false);
        b6 = new JButton("null");
        b6.setEnabled(false);
        tablePanel = new JPanel();
        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.PAGE_AXIS));

        fixturePanel = new JPanel();
        fixturePanel.setBorder(new TitledBorder(new LineBorder(Color.black, 5), "Tournament Fixture"));
        fixturePanel.setLayout(new BoxLayout(fixturePanel, BoxLayout.Y_AXIS));

        //fixturePanel.add(makeButton("Setting up the Matches"));

        fixturePanel.add(b1);
        Blist.add(b1);
        fixturePanel.add(b2);
        Blist.add(b2);
        fixturePanel.add(b3);
        Blist.add(b3);
        fixturePanel.add(b4);
        Blist.add(b4);
        fixturePanel.add(b5);
        Blist.add(b5);
        fixturePanel.add(b6);
        Blist.add(b6);

        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(fixtures.size());
                if (fixtures.size() >= 2) {

                    loadedGames.clear();
                    loadedGames.add(fixtures.get(0));
                    loadedGames.add(fixtures.get(1));
                    game = loadedGames.get(0);
                    //  updateGUI(loadedGames.get(0));
                }
                b1.setEnabled(false);

            }
        });
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (fixtures.size() >= 4) {
                    loadedGames.clear();
                    loadedGames.add(fixtures.get(2));
                    loadedGames.add(fixtures.get(3));
                    game = fixtures.get(10);
                    updateGUI(loadedGames.get(0));
                }
                b2.setEnabled(false);

            }
        });
        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (fixtures.size() >= 6) {
                    loadedGames.clear();
                    loadedGames.add(fixtures.get(4));
                    loadedGames.add(fixtures.get(5));
                    game = fixtures.get(10);
                    updateGUI(loadedGames.get(0));
                }
                b3.setEnabled(false);

            }
        });
        b4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (fixtures.size() >= 8) {
                    loadedGames.clear();
                    loadedGames.add(fixtures.get(6));
                    loadedGames.add(fixtures.get(7));
                    game = fixtures.get(10);
                    updateGUI(loadedGames.get(0));
                }
                b4.setEnabled(false);

            }
        });
        b5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (fixtures.size() == 10) {
                    loadedGames.clear();
                    loadedGames.add(fixtures.get(8));
                    loadedGames.add(fixtures.get(9));
                    game = fixtures.get(8);
                    updateGUI(loadedGames.get(0));
                }
                b5.setEnabled(false);
            }
        });
        b6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (fixtures.size() == 12) {
                    loadedGames.clear();
                    loadedGames.add(fixtures.get(10));
                    loadedGames.add(fixtures.get(11));
                    game = fixtures.get(10);
                    updateGUI(loadedGames.get(0));
                }
                b6.setEnabled(false);
            }
        });

        rankPanel = new JPanel();
        rankPanel.setBorder(new TitledBorder(new LineBorder(Color.black, 5), "Rank"));
        rankPanel.setLayout(new GridLayout(4, 3));

        l1 = new JLabel("First");
        t1 = new JTextField("");
        t1.setEditable(false);
        rankPanel.add(l1);
        rankPanel.add(t1);
        l2 = new JLabel("Second");
        t2 = new JTextField("");
        t2.setEditable(false);
        rankPanel.add(l2);
        rankPanel.add(t2);
        l3 = new JLabel("Third");
        t3 = new JTextField("");
        t3.setEditable(false);
        rankPanel.add(l3);
        rankPanel.add(t3);
        l4 = new JLabel("Fourth");
        t4 = new JTextField("");
        t4.setEditable(false);
        rankPanel.add(l4);
        rankPanel.add(t4);


        tablePanel.add(fixturePanel, BorderLayout.NORTH);
        tablePanel.add(rankPanel, BorderLayout.SOUTH);
        tablePanel.setSize(new Dimension(400, 300));
        container.add(tablePanel, BorderLayout.EAST);

    }


    /**
     * This method creates the map panel which is where the game being displayed
     */
    private void createMapPanel() {
        //mapPanel = new JPanel();

        mapPanel = new JPanel(new BorderLayout());
        c = new Graphic();
        mapPanel.add(c,BorderLayout.CENTER);
        c.setVisible(true);
        Map map = new MapImpl();
        map.emptyMap();
        c.setMap(map.getMap(),map,firstImage);
        container.add(mapPanel, BorderLayout.CENTER);

    }

    /**
     * This method triggers what happen when a
     * @param game
     */
    public void signalGameEnd(Game game) {
        loadedGames.remove(game);
        controller.updateScores(game, tournament);
        if (loadedGames.size() == 1) {
            JOptionPane.showMessageDialog(this, "First round over, play second one? Click start game again.");
//            updateGUI(loadedGames.get(0));
//            this.game = loadedGames.get(0);
        } else {
            JOptionPane.showMessageDialog(this, "Second round over, thanks for playing!");
        }
    }

    public void updateGUI(Game game) {
        System.out.println("dirty :"+game.getMap().getDirty().size());

        BufferedImage image = c.createBufferedImage();
        c.setMap(game.getMap().getMap(), game.getMap(), image);

    }

    public static void main(String[] args) {
        Tournament t = new TournamentImpl();
        GameGUI gui = new GameGUI(t);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String n = e.getActionCommand();

        if (n == "start game") {
            RunnableGame g = new RunnableGame(game);
            Thread t = new Thread(g);
            t.start();
        }


    }

    private JButton makeButton(String name) {
        JButton m = new JButton(name);
        m.addActionListener(this);
        return m;
    }

    class Graphic extends Canvas {
        private Cell[][] map = new CellImpl[150][150];
        private CellImg ci = new CellImg(3, map);
        private Map m;
        private BufferedImage image;

        public void setMap(Cell[][] map, Map m,BufferedImage image) {
            this.map = map;
            this.m = m;
            this.image = image;
            System.out.println("being called");
            ci = new CellImg(3, map);
            repaint();

        }

        public Graphic(){
            setSize(750,753);
        }

        public BufferedImage createBufferedImage(){
            int w = this.getWidth();
            int h = this.getHeight();
            int type = BufferedImage.TYPE_INT_RGB;
            BufferedImage image1 = new BufferedImage(w,h,type);
            image1.createGraphics();
            image1 = image;
            return image1;
        }

        @Override
        public void paint(Graphics g){
            Graphics2D g2;
            g2 = (Graphics2D) g;
            g2.drawImage(image,0,0,this);

            for (int j = 0; j < 150; j++) {
                for (int i = 0; i < 150; i++) {


                    if(map[i][j].isDirty()){
                        Content checker = map[i][j].getContents();


                        try {
                            if (map[i][j].getAnt() != null) {

                                if (map[i][j].getAnt().getColour() == Colour.RED) {
                                    ci.drawHex(i, j, g2, new Color(252, 227, 39));
                                }
                                if (map[i][j].getAnt().getColour() == Colour.BLACK) {
                                    ci.drawHex(i, j, g2, new Color(205, 97, 139));
                                }


                            } else {

                                switch (checker) {

                                    case REDHILL:
                                        ci.drawHex(i, j, g2, Color.RED);
                                        break;
                                    case BLACKHILL:
                                        ci.drawHex(i,j, g2, Color.BLACK);
                                        break;
                                    case ROCKY:
                                        ci.drawHex(i,j, g2, Color.gray);
                                        break;
                                    case NINE:
                                        ci.drawHex(i,j, g2, new Color(1, 138, 5));
                                        break;
                                    case EIGHT:
                                        ci.drawHex(i,j, g2, new Color(2, 171, 23));
                                        break;
                                    case SEVEN:
                                        ci.drawHex(i,j, g2, new Color(1, 208, 31));
                                        break;
                                    case SIX:
                                        ci.drawHex(i,j,g2, new Color(0, 238, 38));
                                        break;
                                    case FIVE:
                                        ci.drawHex(i,j,g2, new Color(4, 255, 43));
                                        break;
                                    case FOUR:
                                        ci.drawHex(i,j, g2, new Color(0, 0, 0));
                                        break;
                                    case THREE:
                                        ci.drawHex(i,j, g2, new Color(147, 255, 156));
                                        break;
                                    case TWO:
                                        ci.drawHex(i,j, g2, new Color(189, 255, 194));
                                        break;
                                    case ONE:
                                        ci.drawHex(i,j, g2, new Color(0, 238, 38));
                                        break;
                                    default:
                                        ci.drawHex(i,j, g2, Color.WHITE);
                                        break;

                                }



                            }
                        } catch (AntNotFoundException e) {
                            e.printStackTrace();
                        }



                        map[i][j].setClean();

                    }

                }
            }


//            for (int i = 0; i < m.getDirty().size(); i++) {
//
//                Position p = m.getDirty().get(i);
//                Content checker = map[p.getX()][p.getY()].getContents();
//
//                try {
//                    if (map[p.getX()][p.getY()].getAnt() != null) {
//                        if (map[p.getX()][p.getY()].getAnt().getColour() == Colour.RED) {
//                            ci.drawHex(p.getX(), p.getY(), g2, new Color(252, 227, 39));
//                        }
//                        if (map[p.getX()][p.getY()].getAnt().getColour() == Colour.BLACK) {
//                            ci.drawHex(p.getX(), p.getY(), g2, new Color(205, 97, 139));
//                        }
//
//
//                    } else {
//
//                        switch (checker) {
//
//                            case REDHILL:
//                                ci.drawHex(p.getX(), p.getY(), g2, Color.RED);
//                                break;
//                            case BLACKHILL:
//                                ci.drawHex(p.getX(), p.getY(), g2, Color.BLACK);
//                                break;
//                            case ROCKY:
//                                ci.drawHex(p.getX(), p.getY(), g2, Color.gray);
//                                break;
//                            case NINE:
//                                ci.drawHex(p.getX(), p.getY(), g2, new Color(1, 138, 5));
//                                break;
//                            case EIGHT:
//                                ci.drawHex(p.getX(), p.getY(), g2, new Color(2, 171, 23));
//                                break;
//                            case SEVEN:
//                                ci.drawHex(p.getX(), p.getY(), g2, new Color(1, 208, 31));
//                                break;
//                            case SIX:
//                                ci.drawHex(p.getX(), p.getY(), g2, new Color(0, 238, 38));
//                                break;
//                            case FIVE:
//                                ci.drawHex(p.getX(), p.getY(), g2, new Color(4, 255, 43));
//                                break;
//                            case FOUR:
//                                ci.drawHex(p.getX(), p.getY(), g2, new Color(0, 0, 0));
//                                break;
//                            case THREE:
//                                ci.drawHex(p.getX(), p.getY(), g2, new Color(147, 255, 156));
//                                break;
//                            case TWO:
//                                ci.drawHex(p.getX(), p.getY(), g2, new Color(189, 255, 194));
//                                break;
//                            case ONE:
//                                ci.drawHex(p.getX(), p.getY(), g2, new Color(0, 238, 38));
//                                break;
//                            default:
//                                ci.drawHex(p.getX(), p.getY(), g2, Color.WHITE);
//                                break;
//
//                        }
//
//
//                    }
//                } catch (AntNotFoundException e) {
//                    e.printStackTrace();
//                }
//
//
//            }
            System.out.println("Before: "+m.getDirty().size());
            m.getDirty().clear();
            System.out.println("After: "+m.getDirty().size());

        }

    }



    private void createLoadPanel() {

        //lists for storing input from user
        inputBrains = new HashMap<String, File>();
        playerNamesOrder = new ArrayList<String>();

        n1 = new JTextField();
        n1.setText("player1");

        n2 = new JTextField();
        n2.setText("player2");

        n3 = new JTextField();
        n3.setText("player3");

        n4 = new JTextField();
        n4.setText("player4");

        playerNames = new HashMap<Integer, String>();

        //local variable for checking the brain
        final Map m = new MapImpl();
        final Colony c = new ColonyImpl(Colour.BLACK);
        final Brain brain = new BrainImpl(m, c);


        //a label for instructions
        instruction = new JLabel("Players, enter your names and load brain for your ants ! ", SwingConstants.CENTER);
        final JLabel p1BrainStatus = new JLabel("Player 1's Brain : Not loaded", SwingConstants.CENTER);
        final JLabel p2BrainStatus = new JLabel("Player 2's Brain : Not loaded", SwingConstants.CENTER);
        final JLabel p3BrainStatus = new JLabel("Player 3's Brain : Not loaded", SwingConstants.CENTER);
        final JLabel p4BrainStatus = new JLabel("Player 4's Brain : Not loaded", SwingConstants.CENTER);

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
        final JButton player1 = new JButton("Load Player 1's Brain");
        player1.setPreferredSize(new Dimension(10, 10));
        player1.setBounds(50, 60, 80, 30);
        player1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String name = n1.getText();
                if (!playerNames.containsValue(name)) {


                    JFileChooser chooser = new JFileChooser();
                    chooser.setCurrentDirectory(new File("."));
                    chooser.setDialogTitle("Brain 1");

                    //checking 1.if brain is correct
                    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION && brain.loadBrain(chooser.getSelectedFile())) {

                        p1BrainStatus.setText(name + " 's Brain : [" + chooser.getName(chooser.getSelectedFile()) + " ]is loaded.");
                        inputBrains.put(name, chooser.getSelectedFile());
                        p1Ready = true;
                        playerNames.put(1, name);

                    } else {
                        p1BrainStatus.setText("Your Brain is not working, retry! ");
                    }
                } else {
                    p1BrainStatus.setText("Duplicated player, retry or clear previous brains! ");

                }


            }
        });

        //load brain button for player 2
        JButton player2 = new JButton("Load Player 2's Brain");
        player2.setPreferredSize(new Dimension(10, 10));
        player2.setBounds(50, 60, 80, 30);
        player2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {


                String name = n2.getText();
                if (!playerNames.containsValue(name)) {


                    JFileChooser chooser = new JFileChooser();
                    chooser.setCurrentDirectory(new File("."));
                    chooser.setDialogTitle("Brain 2");


                    //checking if brain is correct
                    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION && brain.loadBrain(chooser.getSelectedFile())) {

                        p2BrainStatus.setText(name + " 's Brain : [" + chooser.getName(chooser.getSelectedFile()) + " ]is loaded.");
                        inputBrains.put(name, chooser.getSelectedFile());
                        p2Ready = true;
                        playerNames.put(2, name);


                    } else {
                        p2BrainStatus.setText("Your Brain is not working, retry! ");
                    }
                } else {
                    p2BrainStatus.setText("Duplicated player, retry or clear previous brains! ");

                }

            }
        });


        //load brain button for player 3
        final JButton player3 = new JButton("Load Player 3's Brain");
        player3.setPreferredSize(new Dimension(10, 10));
        player3.setBounds(50, 60, 80, 30);
        player3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                String name = n3.getText();
                if (!playerNames.containsValue(name)) {


                    JFileChooser chooser = new JFileChooser();
                    chooser.setCurrentDirectory(new File("."));
                    chooser.setDialogTitle("Brain 3");


                    //checking if brain is correct
                    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION && brain.loadBrain(chooser.getSelectedFile())) {

                        p3BrainStatus.setText(name + " 's Brain : [" + chooser.getName(chooser.getSelectedFile()) + " ]is loaded.");
                        inputBrains.put(name, chooser.getSelectedFile());
                        p3Ready = true;
                        playerNames.put(3, name);


                    } else {
                        p3BrainStatus.setText("Your Brain is not working, retry! ");
                    }
                } else {
                    p3BrainStatus.setText("Duplicated player, retry or clear previous brains! ");

                }

            }
        });


        //load brain button for player 4
        final JButton player4 = new JButton("Load Player 4's Brain");
        player4.setPreferredSize(new Dimension(10, 10));
        player4.setBounds(50, 60, 80, 30);
        player4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                String name = n4.getText();
                if (!playerNames.containsValue(name)) {


                    JFileChooser chooser = new JFileChooser();
                    chooser.setCurrentDirectory(new File("."));
                    chooser.setDialogTitle("Brain 4");


                    //checking if brain is correct
                    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION && brain.loadBrain(chooser.getSelectedFile())) {

                        p4BrainStatus.setText(name + " 's Brain : [" + chooser.getName(chooser.getSelectedFile()) + " ]is loaded.");
                        inputBrains.put(name, chooser.getSelectedFile());
                        p4Ready = true;
                        playerNames.put(4, name);
                        System.out.println(chooser.getSelectedFile());

                    } else {
                        p4BrainStatus.setText("Your Brain is not working, retry! ");
                    }
                } else {
                    p4BrainStatus.setText("Duplicated player, retry or clear previous brains! ");

                }

            }
        });

        final JLabel loadWorldText = new JLabel("No World Loaded");
        //load world button
        final JButton loadWorld = new JButton("Load Customized World");
        loadWorld.setEnabled(false);
        loadWorld.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {


                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File("."));
                chooser.setDialogTitle("Load Game World");

                Map testMap = new MapImpl();


                //checking if brain is correct
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION && testMap.loadMap(chooser.getSelectedFile())) {

                    loadWorldText.setText(" New Game World : [" + chooser.getName(chooser.getSelectedFile()) + " ]is loaded.");
                    customizedWorldFile = chooser.getSelectedFile() ;
                } else {
                    loadWorldText.setText("Your world is not working, retry! ");
                }
            }


        });

        //make radio buttons
        ButtonGroup gameButton = new ButtonGroup();
        ButtonGroup worldButton = new ButtonGroup();

        final JRadioButton singleGameButton = new JRadioButton("Single Game Mode");

        final JRadioButton randomWorld = new JRadioButton("Random World");
        randomWorld.setSelected(true);
        randomWorld.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                isRandomWorld = true;
                loadWorld.setEnabled(false);
                customizedWorldFile = null;
                loadWorldText.setText("No World loaded");
            }
        });

        final JRadioButton customWorld = new JRadioButton("Custom World");
        customWorld.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                isRandomWorld = false;
                loadWorld.setEnabled(true);
            }
        });

        worldButton.add(randomWorld);
        worldButton.add(customWorld);


        singleGameButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                isSingleGame = true;
                player3.setEnabled(false);
                player4.setEnabled(false);
                p3BrainStatus.setEnabled(false);
                p4BrainStatus.setEnabled(false);

                //make new brain list
                inputBrains = new HashMap<String, File>();
                playerNames = new HashMap<Integer, String>();
                p1BrainStatus.setText("Player 1's Brain : Not loaded");
                p2BrainStatus.setText("Player 2's Brain : Not loaded");
                p3BrainStatus.setText("Player 3's Brain : Not loaded");
                p4BrainStatus.setText("Player 4's Brain : Not loaded");
                p1Ready = false;
                p2Ready = false;
                p3Ready = false;
                p4Ready = false;

                randomWorld.setSelected(true);
                customWorld.setEnabled(true);
                loadWorld.setEnabled(false);

            }
        });

        //set defalt button as single game
        singleGameButton.setSelected(true);
        isSingleGame = true;
        player3.setEnabled(false);
        player4.setEnabled(false);
        p3BrainStatus.setEnabled(false);
        p4BrainStatus.setEnabled(false);

        JRadioButton tournamentGameButton = new JRadioButton("Tournament Mode");
        tournamentGameButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                isSingleGame = false;
                player3.setEnabled(true);
                player4.setEnabled(true);
                p3BrainStatus.setEnabled(true);
                p4BrainStatus.setEnabled(true);
                randomWorld.setSelected(true);

                //make new brain list
                inputBrains = new HashMap<String, File>();
                playerNames = new HashMap<Integer, String>();
                p1BrainStatus.setText("Player 1's Brain : Not loaded");
                p2BrainStatus.setText("Player 2's Brain : Not loaded");
                p3BrainStatus.setText("Player 3's Brain : Not loaded");
                p4BrainStatus.setText("Player 4's Brain : Not loaded");

                p1Ready = false;
                p2Ready = false;
                p3Ready = false;
                p4Ready = false;

                customWorld.setEnabled(false);
                loadWorld.setEnabled(false);


            }
        });
        gameButton.add(singleGameButton);
        gameButton.add(tournamentGameButton);

        JButton makeFixtures = new JButton("Create Games");
        makeFixtures.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                //make fixtures
                int k = 0;
                String bu = "b";


                if (isRandomWorld && (customizedWorldFile == null)) {


                    if (isSingleGame && p1Ready && p2Ready) {
                        instruction.setText("Games is ready to start !");
                        gameStatus.setText("Single Game is Ready.");

                        tab.setEnabledAt(1, true);
                        tab.setSelectedIndex(1);
                    } else {
                        if (!isSingleGame && p1Ready && p2Ready && p3Ready) {
                            for (int a = 0; a < playerNames.size() + 2; a++) {
                                for (int b = a + 1; b < playerNames.size(); b++) {
                                    System.out.println(playerNames.get(a + 1) + " " + playerNames.get(b + 1));
                                    Blist.get(k).setText(playerNames.get(a + 1) + " vs " + playerNames.get(b + 1));
                                    Blist.get(k).setEnabled(true);
                                    k++;
                                }
                            }
                            gameStatus.setText("3 Player Tournament ready.");
                            tab.setEnabledAt(1, true);

                            tab.setSelectedIndex(1);
                            fixtures = controller.createFixtures(inputBrains, tournament);

                        } else {
                            if (!isSingleGame && p1Ready && p2Ready && p3Ready && p4Ready) {
                                for (int a = 0; a < playerNames.size() + 2; a++) {
                                    for (int b = a + 1; b < playerNames.size(); b++) {
                                        System.out.println(playerNames.get(a + 1) + " " + playerNames.get(b + 1));
                                        Blist.get(k).setText(playerNames.get(a + 1) + " vs " + playerNames.get(b + 1));
                                        Blist.get(k).setEnabled(true);
                                        System.out.println(k);
                                        k++;
                                    }
                                }
                                gameStatus.setText("4 Player Tournament ready.");

                                tab.setEnabledAt(1, true);

                                tab.setSelectedIndex(1);
                                fixtures = controller.createFixtures(inputBrains, tournament);

                            } else {
                                instruction.setText("Please make sure all the brain is loaded!");
                                instruction.setForeground(Color.RED);

                            }
                        }


                    }
                } else {
                    instruction.setText("Please load your world or set to random world!");
                    instruction.setForeground(Color.RED);

                }
            }
        });

        JButton clear = new JButton("Clear All");
        clear.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                //make fixtures

                playerNames = new HashMap<Integer, String>();
                inputBrains = new HashMap<String, File>();
                playerNamesOrder = new ArrayList<String>();
                p1BrainStatus.setText("Player 1's Brain : Not loaded");
                p2BrainStatus.setText("Player 2's Brain : Not loaded");
                p3BrainStatus.setText("Player 3's Brain : Not loaded");
                p4BrainStatus.setText("Player 4's Brain : Not loaded");
            }
        });

        JLabel blank = new JLabel("");

        loadPanel.add(singleGameButton, SwingConstants.CENTER);
        loadPanel.add(tournamentGameButton, SwingConstants.CENTER);
        loadPanel.add(blank);
        loadPanel.add(blank);
        loadPanel.add(customWorld);
        loadPanel.add(randomWorld);
        loadPanel.add(loadWorldText);
        loadPanel.add(loadWorld);
        loadPanel.add(instruction);
        loadPanel.add(blank);
        loadPanel.add(n1);
        loadPanel.add(player1);
        loadPanel.add(n2);
        loadPanel.add(player2);
        loadPanel.add(n3);
        loadPanel.add(player3);
        loadPanel.add(n4);
        loadPanel.add(player4);
        loadPanel.add(p1BrainStatus);
        loadPanel.add(p2BrainStatus);
        loadPanel.add(p3BrainStatus);
        loadPanel.add(p4BrainStatus);
        loadPanel.add(makeFixtures);
        loadPanel.add(clear);


        setTitle("Please load your brains");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}


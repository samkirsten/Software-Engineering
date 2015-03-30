package com.view;

import com.model.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

public class GameGUI extends JFrame implements ActionListener {

    private static Cell[][] map;
    private int currentRound = 0;
    private Game game;
    private CellImg ci = new CellImg(3,map);
    private JButton b1, b2, b3, b4, b5, b6;
    private JTextField t1,t2,t3,t4;
    private JLabel l1, l2 , l3, l4;
    private ArrayList<JButton> Blist = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();
    private JPanel menuPanel, tablePanel, mapPanel, rankPanel,fixturePanel;
    private Container container;


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

        createMenuPanel();
        createtablePanel();
        createmapPanel();

        pack();

        setResizable(false);
        setVisible(true);

    }

    private void createMenuPanel(){
        menuPanel = new JPanel();

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

        JPanel mapPanel = new JPanel(){
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

        container.add(mapPanel, BorderLayout.CENTER);

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

    class refreshMap extends JPanel implements Runnable {

        @Override
        public void run() {


        }

        public void paintComponent(Graphics g){
            Graphics2D g2 = (Graphics2D) g;
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



    }

}




import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class guiTwoPlayerMenu extends JFrame {

    JPanel panel;
    JLabel instruction;

    public guiTwoPlayerMenu() {
        initLayout();
    }

    public final void initLayout() {
        //a label for instructions
        instruction = new JLabel("Please load your brains here, and press Start Game ", SwingConstants.CENTER);

        //setting up layout and panel
        panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new GridLayout(4, 2));

        //make new load brain button for player 1
        JButton player1 = new JButton("Player 1");
        player1.setPreferredSize(new Dimension(10, 10));
        player1.setBounds(50, 60, 80, 30);
        player1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFileChooser chooser = new JFileChooser();
                //chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("Brain 1");


                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    System.out.println("Player 1 's brain : " + chooser.getSelectedFile());
                } else {
                    System.out.println("No Selection ");
                }


                //checking for the brain goes here

            }
        });

        //load brain button for player 2
        JButton player2 = new JButton("Player 2");
        player2.setPreferredSize(new Dimension(10, 10));
        player2.setBounds(50, 60, 80, 30);
        player2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFileChooser chooser = new JFileChooser();
                //chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("Brain 1");


                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    System.out.println("Player 1 's brain : " + chooser.getSelectedFile());
                } else {
                    System.out.println("No Selection ");
                }


                //checking for the brain goes here


            }
        });

        //start game button
        JButton startGame = new JButton("START GAME");
        startGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //check brain and print out if brain is okay.
                // then runs game class
            }
        });

        panel.add(instruction);
        panel.add(player1);
        panel.add(player2);
        panel.add(startGame);

        setTitle("2-player Mode");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {


        guiTwoPlayerMenu ex = new guiTwoPlayerMenu();
        ex.setVisible(true);


    }
}
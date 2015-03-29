package com.view;

import com.model.CellImpl;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GameGUI extends JFrame implements ActionListener, Runnable {
	
	private CellImpl[][] graphicalMap;
	private Polygon poly;
	CellImg b = new CellImg(4, graphicalMap);
	
	public GameGUI(CellImpl[][] m){
		super("Ant Game Team 2");
		graphicalMap = m;
		CreateUI();
	}
	
	private void CreateUI(){
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createMenu();
		createContent();
		
		pack();
		setResizable(true);
		setVisible(true);
	}

	private void refreshMap(){




	}
	
	private void createMenu(){
		JMenuBar mb;
		JMenu mm;
		
		mm = new JMenu("Menu");
		mm.add(makeMenuItem("Normal com.model.Game"));
		mm.add(makeMenuItem("com.model.Tournament com.model.Game"));
		mm.add(makeMenuItem("Quit com.model.Game"));
		
		mb = new JMenuBar();
		mb.add(mm);
		getContentPane().add(mb,BorderLayout.NORTH);
	}
	
	private void createContent(){

		JPanel p = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
            	Graphics2D g2 = (Graphics2D)g;
    			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                super.paintComponent(g2);
                for (int j=0;j<150;j++) {
    				for (int i=0;i<150;i++) {
    					if(graphicalMap[i][j].getContents() == '+'){
    						b.drawHex(i,j,g2,Color.RED);
    					}else if(graphicalMap[i][j].getContents() == '-'){
    						b.drawHex(i,j,g2,Color.BLACK);
    					}else if(graphicalMap[i][j].getContents() == '#'){
    						b.drawHex(i,j,g2,Color.gray);
    					}else if(graphicalMap[i][j].getContents() == '.'){
    						b.drawHex(i,j,g2,Color.WHITE);
    					}else {
    						b.drawHex(i,j,g2,Color.GREEN);
    					}
    				}
    			}
            }
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(1205, 1000);
            }
        };
        p.setAutoscrolls(true);
        getContentPane().add(p,BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if (command.equals("Quit com.model.Game")) {
            System.exit(0);
        } else if (command.equals("com.model.Tournament com.model.Game")) {
            // Open menu item action
            System.out.println("com.model.Tournament com.model.Game");
        } else if (command.equals("Normal com.model.Game")) {
            // Save menu item action
            System.out.println("Normal com.model.Game");
        }
	}
	
	private JMenuItem makeMenuItem(String name){
		JMenuItem m = new JMenuItem(name);
		m.addActionListener(this);
		return m;
	}

    @Override
    public void run() {

    }
}
/*
 * Launches the ping pong game.
 */
package pingpong;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Syed Yousuf
 */
public class GameLauncher 
{
    
    // Instance variables
    private JButton singlePlayer;
    private JButton multiPlayer;
    private JButton easy;
    private JButton normal;
    private JButton medium;
    private JButton hard;
    private JButton lengendary;
    private JFrame j1;
    
    /*
    * The Default constructor
    */
    public GameLauncher()
    {
        j1 = new JFrame("Ping Pong game");
        j1.setSize(900,900);
        j1.setVisible(true);
        j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        j1.setLayout(null);
        
        j1.setBackground(Color.black);
        
        singlePlayer = new JButton("Single Player");
        singlePlayer.setBounds(200, 200, 130, 50);
        
        multiPlayer = new JButton("MultiPlayer");
        multiPlayer.setBounds(200, 250, 130, 50);
        
        j1.add(singlePlayer);
        j1.add(multiPlayer);
        
        multiPlayer.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e)
            {
                singlePlayer.setEnabled(false);
                multiPlayer.setEnabled(false);
                
                singlePlayer.setVisible(false);
                multiPlayer.setVisible(false);
                
                
                j1.setVisible(false);
                        j1.dispose();
                        
                        // single player easy
                        Table PongTable = new Table(false, "easy");
        
        
                        Thread screenThread = new Thread(PongTable);
        
                        screenThread.start();
            }
        });
        
        singlePlayer.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e)
            {
                singlePlayer.setEnabled(false);
                multiPlayer.setEnabled(false);
                
                singlePlayer.setVisible(false);
                multiPlayer.setVisible(false);
                
                easy = new JButton("easy");
                easy.setBounds(200, 200, 130, 50);
                
                normal = new JButton("normal");
                normal.setBounds(200, 250, 130, 50);
                
                medium = new JButton("medium");
                medium.setBounds(200, 300, 130, 50);
                
                
                hard = new JButton("hard");
                hard.setBounds(200, 350, 130, 50);
                
                lengendary = new JButton("lengendary");
                lengendary.setBounds(200, 400, 130, 50);
                
                easy.setEnabled(true);
                easy.setVisible(true);
                normal.setEnabled(true);
                normal.setVisible(true);
                medium.setEnabled(true);
                medium.setVisible(true);
                hard.setEnabled(true);
                hard.setVisible(true);
                lengendary.setEnabled(true);
                lengendary.setVisible(true);
                
                
                j1.add(easy);
                j1.add(normal);
                j1.add(medium);
                j1.add(hard);
                j1.add(lengendary);
                
                easy.addActionListener(new ActionListener(){
        
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        easy.setEnabled(false);
                        easy.setVisible(false);
                        
                        normal.setEnabled(false);
                        normal.setVisible(false);
                        
                        medium.setEnabled(false);
                        medium.setVisible(false);
                        
                        hard.setEnabled(false);
                        hard.setVisible(false);
                        
                        lengendary.setEnabled(false);
                        lengendary.setVisible(false);
                        
                        j1.setVisible(false);
                        j1.dispose();
                        
                        // single player easy
                        Table PongTable = new Table(true, "easy");
        
        
                        Thread screenThread = new Thread(PongTable);
        
                        screenThread.start();
                    }
                 });
                
                normal.addActionListener(new ActionListener(){
        
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        
                        easy.setEnabled(false);
                        easy.setVisible(false);
                        
                        normal.setEnabled(false);
                        normal.setVisible(false);
                        
                        medium.setEnabled(false);
                        medium.setVisible(false);
                        
                        hard.setEnabled(false);
                        hard.setVisible(false);
                        
                        lengendary.setEnabled(false);
                        lengendary.setVisible(false);
                        
                        j1.setVisible(false);
                        j1.dispose();
                        
                        // single player easy
                        Table PongTable = new Table(true, "normal");
        
        
                        Thread screenThread = new Thread(PongTable);
        
                        screenThread.start();
                        
                    }
                 });
                
                medium.addActionListener(new ActionListener(){
        
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        easy.setEnabled(false);
                        easy.setVisible(false);
                        
                        normal.setEnabled(false);
                        normal.setVisible(false);
                        
                        medium.setEnabled(false);
                        medium.setVisible(false);
                        
                        hard.setEnabled(false);
                        hard.setVisible(false);
                        
                        lengendary.setEnabled(false);
                        lengendary.setVisible(false);
                        
                        j1.setVisible(false);
                        j1.dispose();
                        
                        // single player easy
                        Table PongTable = new Table(true, "medium");
        
        
                        Thread screenThread = new Thread(PongTable);
        
                        screenThread.start();
                    }
                 });
                
                hard.addActionListener(new ActionListener(){
        
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        easy.setEnabled(false);
                        easy.setVisible(false);
                        
                        normal.setEnabled(false);
                        normal.setVisible(false);
                        
                        medium.setEnabled(false);
                        medium.setVisible(false);
                        
                        hard.setEnabled(false);
                        hard.setVisible(false);
                        
                        lengendary.setEnabled(false);
                        lengendary.setVisible(false);
                        
                        j1.setVisible(false);
                        j1.dispose();
                        
                        // single player easy
                        Table PongTable = new Table(true, "hard");
        
        
                        Thread screenThread = new Thread(PongTable);
        
                        screenThread.start();
                    }
                 });
                
                lengendary.addActionListener(new ActionListener(){
        
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        easy.setEnabled(false);
                        easy.setVisible(false);
                        
                        normal.setEnabled(false);
                        normal.setVisible(false);
                        
                        medium.setEnabled(false);
                        medium.setVisible(false);
                        
                        hard.setEnabled(false);
                        hard.setVisible(false);
                        
                        lengendary.setEnabled(false);
                        lengendary.setVisible(false);
                        
                        j1.setVisible(false);
                        j1.dispose();
                        
                        // single player easy
                        Table PongTable = new Table(true, "legendary");
        
        
                        Thread screenThread = new Thread(PongTable);
        
                        screenThread.start();
                    }
                 });
                    
                }
        
        
        });
       
    }
    
  
    /*
    * The main method
    */
    public static void main(String[]args)
    {
        //Create the JFrame.
        GameLauncher g1 = new GameLauncher();

  
        
        
    }
}

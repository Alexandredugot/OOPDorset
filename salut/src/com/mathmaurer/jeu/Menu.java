package com.mathmaurer.jeu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu extends JPanel implements ActionListener {
    public int play =0;
    public JButton button;
    public JButton button2;
    public JButton button3;
    JLabel label;

    public boolean ispause;
    //créer public attribut state déclarant l'état du bouton appuyé
    Menu(){

        ImageIcon background = new ImageIcon(getClass().getResource("/Image/marioArretDroite.png"));
        label= new JLabel();
        label.setIcon(background);
        label.setBounds(0,0,700,300);
        button = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button.setBounds(Main.fenetre.getWidth()/2- 100,Main.fenetre.getHeight()/2-50,200,50);
        button2.setBounds(Main.fenetre.getWidth()/2- 100,Main.fenetre.getHeight()/2+100,200,50);
        button3.setBounds(Main.fenetre.getWidth()/2- 100,Main.fenetre.getHeight()/2+200,200,50);
        this.setLayout(null);
        this.add(button);
        this.add(button2);
        this.add(button3);
        button.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button.setText("Play");
        button2.setText("Fullscreen");
        button3.setText("Quit game");
        button.setFocusable(false);
        button2.setFocusable(false);
        button3.setFocusable(false);
        button2.setBackground(Color.red);
        button2.setForeground(Color.CYAN);
        button3.setBackground(Color.red);
        button3.setForeground(Color.CYAN);
        button.setBackground(Color.red);
        button.setForeground(Color.CYAN);
        this.setBackground(Color.ORANGE);
        this.add(label);
        label.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            play=1;
            Main.isgame = true;
        }

        if(e.getSource() == button2)
        {
            play =2;
        }

        if(e.getSource() == button3){
            play = 3;
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;

        int width;
        int height;

        width = (int)(Main.fenetre.getWidth() /3.5);
        height = (int)(Main.fenetre.getHeight() /9.2);

        button.setBounds(Main.fenetre.getWidth()/2 -width/2,Main.fenetre.getHeight()/2 -height -80,width,height);
        button2.setBounds(Main.fenetre.getWidth()/2 -width/2,Main.fenetre.getHeight()/2 -height+20,width,height);
        button3.setBounds(Main.fenetre.getWidth()/2 -width/2,Main.fenetre.getHeight()/2 -height+120,width,height);



    }




}

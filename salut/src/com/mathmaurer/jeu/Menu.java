package com.mathmaurer.jeu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu extends JPanel implements ActionListener {
    public int play =0;
    JButton button;
    JLabel label;
    //créer public attribut state déclarant l'état du bouton appuyé
    Menu(){

        ImageIcon background = new ImageIcon(getClass().getResource("/Image/marioArretDroite.png"));
        label= new JLabel();
        label.setIcon(background);
        label.setBounds(0,0,700,300);
        button = new JButton();
        button.setBounds(250,100,200,50);
        this.setLayout(null);
        this.add(button);
        button.addActionListener(this);
        button.setText("Play");
        button.setFocusable(false);
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
        }
    }
}

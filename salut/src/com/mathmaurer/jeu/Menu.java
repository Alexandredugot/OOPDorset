package com.mathmaurer.jeu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu extends JPanel  {
    JButton button;
    //créer public attribut state déclarant l'état du bouton appuyé
    Menu(){
        button = new JButton();
        button.setBounds(250,100,200,50);
        this.setLayout(null);
       // this.setSize(100,100);
       // this.setVisible(true);
        this.add(button);
        button.addActionListener(e->System.out.println("hello"));
    }
   /* @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            System.out.println("here");
        }
    }*/
}

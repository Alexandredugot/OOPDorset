package com.mathmaurer.jeu;

import javax.swing.JFrame;

public class Main {

    public static Scene scene;

    public static void main(String[] args){
        JFrame fenetre = new JFrame("Jeu plateforme");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(700,360);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(true);
        fenetre.setAlwaysOnTop(true);

        scene = new Scene();
        fenetre.setContentPane(scene);
        fenetre.setVisible(true);
    }
}

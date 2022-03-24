package com.mathmaurer.jeu;

import javax.swing.JFrame;

public class Main {

    public static Scene scene;
    private enum STATE{
        MENU,
        GAME
    }

    private STATE state = STATE.MENU;
    public static void main(String[] args){
        JFrame fenetre = new JFrame("Jeu plateforme");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(700,360);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(true);
        fenetre.setAlwaysOnTop(true);

     /*   Menu menu = new Menu();
        fenetre.setContentPane(menu);*/

        scene = new Scene();
        fenetre.setContentPane(scene);
        fenetre.setVisible(true);
    }
}

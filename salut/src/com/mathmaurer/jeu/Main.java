package com.mathmaurer.jeu;

import javax.swing.*;
import java.util.EventListener;

public class Main {

    public static Scene scene;
    private enum STATE{
        MENU,
        GAME
    }

    private STATE state = STATE.MENU;
    public static void main(String[] args){
        JFrame fenetre = new JFrame("Start menu");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(700,360);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(true);
        fenetre.setAlwaysOnTop(true);

        Menu menu = new Menu();
        fenetre.setContentPane(menu);
        fenetre.setVisible(true);

        while(menu.play !=1){
            System.out.print(menu.play);
        }
        fenetre.dispose();
        JFrame Gamewindow = new JFrame("Jeu plateforme");
        Gamewindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Gamewindow.setSize(700,360);
        Gamewindow.setLocationRelativeTo(null);
        Gamewindow.setResizable(true);

        scene = new Scene();
        Gamewindow.setContentPane(scene);
        Gamewindow.setVisible(true);
    }
}

package com.mathmaurer.jeu;

import javax.swing.*;
import java.awt.*;
import java.util.EventListener;

public class Main {

    public static Scene scene;
    private enum STATE{
        MENU,
        GAME
    }

    private STATE state = STATE.MENU;
    public static JFrame fenetre = new JFrame("start menu");
    public static Menu menu;
    public static GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
    public static GraphicsDevice device = graphics.getDefaultScreenDevice();

    public static void main(String[] args){
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(700,360);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(true);
        fenetre.setAlwaysOnTop(true);

        menu = new Menu();
        fenetre.setContentPane(menu);
        fenetre.setVisible(true);




        while(menu.play !=1){
            System.out.print("");
            if(menu.play == 2){
                device.setFullScreenWindow(fenetre);
            }
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

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
    public static boolean isgame = false;

    public static void main(String[] args){
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(700,360);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(true);
        fenetre.setAlwaysOnTop(true);

        menu = new Menu();
        fenetre.setContentPane(menu);
        fenetre.setVisible(true);



        JFrame Gamewindow = new JFrame("Jeu plateforme");
        while(menu.play !=1){
            System.out.print("");

            if(menu.play == 1){
                isgame = true;
            }
            else if(menu.play == 2){
                device.setFullScreenWindow(fenetre);
            }
            else if(menu.play == 3){
                fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                fenetre.dispose();
                System.exit(0);
            }
        }
        fenetre.dispose();
        Gamewindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Gamewindow.setSize(700,360);
        Gamewindow.setLocationRelativeTo(null);
        Gamewindow.setResizable(true);

        scene = new Scene();
        Gamewindow.setContentPane(scene);
        Gamewindow.setVisible(true);

    }
}

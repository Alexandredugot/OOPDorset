package com.mathmaurer.jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT && e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            Main.scene.Setdx(0);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT && e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            Main.scene.Setdx(0);
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            Main.scene.Setdx(1);
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            Main.scene.Setdx(-1);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        Main.scene.Setdx(0);
    }
}

package com.mathmaurer.jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener {
    public boolean g = true;
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT && e.getKeyCode() == KeyEvent.VK_LEFT && Main.scene.player.life>0 && Main.scene.player.finishedlevel==0)
        {
            Main.scene.Setdx(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE && Main.scene.player.life>0 && Main.scene.player.finishedlevel==0)
        {
            Main.scene.SetjumpForce(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_L && Main.scene.player.life>0 && Main.scene.player.finishedlevel==0){
            Scene.life = true;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT && Main.scene.player.life>0 && Main.scene.player.finishedlevel==0)
        {
            Main.scene.Setdx(1);
            Main.scene.player.setMarche(true);
            Main.scene.player.setVersDroite(true);
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT && Main.scene.player.life>0 && Main.scene.player.finishedlevel==0)
        {
            Main.scene.Setdx(-1);
            Main.scene.player.setMarche(true);
            Main.scene.player.setVersDroite(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE && Main.scene.player.life>0 && Main.scene.player.finishedlevel==0)
        {
            Main.scene.player.SetSaut(true);
        }
        if(Main.isgame && e.getKeyCode() == KeyEvent.VK_ESCAPE && g && Main.scene.player.life>0 && Main.scene.player.finishedlevel==0)
        {
            Main.scene.ispause = true;
            g =false;
        }
        else if(g==false && e.getKeyCode() == KeyEvent.VK_ESCAPE && Main.scene.player.life>0 && Main.scene.player.finishedlevel==0)
        {
            Main.scene.ispause = false;
            Main.scene.notpause = true;
            g = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_L){

            if(Main.scene.player.life>=10)
            {
                Main.scene.player.life -=10;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        Main.scene.Setdx(0);
        Main.scene.player.setMarche(false);
    }
}

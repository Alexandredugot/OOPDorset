package com.mathmaurer.jeu;

import com.mathmaurer.object.object;

public class Chrono implements Runnable{
    private final int PAUSE = 3;
    @Override
    public void run(){
        while(true)
        {
            Main.scene.repaint();
            Main.menu.repaint();



            try{
            Thread.sleep(PAUSE);
            }catch(InterruptedException e){

            }





        }
    }
}

package com.mathmaurer.personnage;

import com.mathmaurer.jeu.Main;

import javax.swing.*;
import java.awt.*;
import java.time.*;

public class stonks extends personnage implements Runnable {

    public int x;
    public int y;


    public Image imgMonster;
    public ImageIcon icoMonster;

    public boolean droite;

    public void run(){
        while(this.life >0){
            int compteur = 70;
            this.icoMonster = new ImageIcon("src/Image/champArretDroite.png");
            this.imgMonster = this.icoMonster.getImage();
            while(compteur>0)
            {
                this.MOVE(2);
                compteur--;
                try{
                    Thread.sleep(50);
                }catch(InterruptedException e){

                }
            }
            this.icoMonster = new ImageIcon("src/Image/champArretGauche.png");
            this.imgMonster = this.icoMonster.getImage();
            compteur = 70;
            while(compteur>0)
            {
                this.MOVE(-2);
                compteur--;
                try{
                    Thread.sleep(50);
                }catch(InterruptedException e){

                }
            }
        }



    }

    public stonks(int x,int y)
    {
        super(x,y,27,30,100,10,20);
        this.x = x;
        this.y = y;

        this.icoMonster = new ImageIcon("src/Image/champArretDroite.png");
        this.imgMonster = this.icoMonster.getImage();

        droite = true;



    }


    public void MOVE(int direction){
        this.x += direction;
    }




}

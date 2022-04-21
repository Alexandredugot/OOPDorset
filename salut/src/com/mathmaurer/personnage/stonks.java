package com.mathmaurer.personnage;

import com.mathmaurer.jeu.Main;
import com.mathmaurer.object.object;

import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.util.ArrayList;

public class stonks extends personnage implements Runnable {

    public int x;
    public int y;


    public Image imgMonster;
    public ImageIcon icoMonster;

    public static ArrayList<stonks> list = new ArrayList<stonks>();


    public int direction;

    public void run(){
        while(this.life >0){
            int compteur = 70;
            direction =2;
            this.setVersDroite(true);
            while(compteur>0)
            {
                if(this.life >0)
                    this.MOVE(direction);
                compteur--;
                try{
                    Thread.sleep(40);
                }catch(InterruptedException e){

                }

            }
            compteur = 70;
            direction = -2;
            this.setVersDroite(false);
            while(compteur>0)
            {
                if(this.life >0)
                    this.MOVE(direction);
                compteur--;
                try{
                    Thread.sleep(40);
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

        this.setMarche(true);

        list.add(this);



    }


    public void MOVE(int direction){
        this.x += direction;
    }

    public static void AttackAll()
    {
        if(Main.scene!=null)
        {
            for(int i = 0;i<list.size();i++)
            {
                if(list.get(i).x <= Main.scene.player.getX()+8 && list.get(i).x>= Main.scene.player.getX()-8 && list.get(i).life >0 )
                {
                    Main.scene.player.life -= 5;

                }
            }
        }
    }






}

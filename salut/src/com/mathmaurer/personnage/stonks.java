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
                    Thread.sleep(40);
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

        droite = true;

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
                if(list.get(i).x <= Main.scene.player.getX()+8 && list.get(i).x>= Main.scene.player.getX()-8 )
                {
                    Main.scene.player.life -= 5;
                }
            }
        }
    }




}

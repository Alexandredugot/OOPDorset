package com.mathmaurer.personnage;

import javax.swing.*;
import java.awt.*;

public class stonks extends personnage {

    public int x;
    public int y;


    public Image imgMonster;
    public ImageIcon icoMonster;

    public boolean droite;

    public stonks(int x,int y)
    {
        super(x,y,27,30,100,10,20);
        this.x = x;
        this.y = y;

        this.icoMonster = new ImageIcon("src/Image/champArretDroite.png");
        this.imgMonster = this.icoMonster.getImage();

        droite = true;



    }


    public void MOVE(int R,float frequence){
        while(frequence!=0){
            frequence-=0.001;
            this.x += com.mathmaurer.jeu.Main.scene.Getdx() +1;
        }
        frequence = 30;
        while(frequence!=0){
            frequence-=0.001;
            this.x += com.mathmaurer.jeu.Main.scene.Getdx() -1;
        }
    }




}

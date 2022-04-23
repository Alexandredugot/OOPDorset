package com.mathmaurer.jeu;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


public class shop implements Runnable {
    public int x;
    public int y;

    public static ArrayList<sell> Selllist = new ArrayList<sell>();

    public ImageIcon iconshop;
    public Image imgshop;

    public void run(){
        if(Main.scene.player.getX() > this.x && Main.scene.player.getX() < this.x +70)
        {
            
        }
    }

    public shop(int x,int y){
        this.x = x;
        this.y = y;

        iconshop=new ImageIcon(getClass().getResource("/image/shop2.jpg"));
        imgshop=iconshop.getImage();
    }

    public void addSell(type t,int price){
        Selllist.add(new sell(t,price));
    }

}

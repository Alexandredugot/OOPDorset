package com.mathmaurer.object;

import javax.swing.*;
import java.awt.*;

public class Coin extends object implements Runnable{

    private int count;
    public Coin(int x, int y){
        super(x,y,30,30);
        super.objicon=new ImageIcon(getClass().getResource("/image/piece1.png"));
        super.objimg=this.getObjicon().getImage();
    }

    public Image pictchange(){
        String str;
        ImageIcon ico;
        Image img;
        this.count++;
        if(this.count/100==0){
            str="/image/piece1.png";
        }
        else {
            str="/image/piece2.png";
        }
        this.count= count%200;
        ico= new ImageIcon(getClass().getResource(str));
        img=ico.getImage();
        return img;
    }
    @Override
    public void run(){
        try{Thread.sleep(20);}
        catch (InterruptedException e){}

        while(true){
            this.pictchange();
            try {
                Thread.sleep(20);
            }
            catch (InterruptedException e){}
        }
    }
}

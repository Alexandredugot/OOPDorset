package com.mathmaurer.object;

import javax.swing.*;

public class Coin extends object{

    public Coin(int x, int y){
        super(x,y,30,30);
        super.objicon=new ImageIcon(getClass().getResource("/image/piece1.png"));
        super.objimg=this.getObjicon().getImage();
    }


}

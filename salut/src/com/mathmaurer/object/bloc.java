package com.mathmaurer.object;

import java.awt.Image;
import javax.swing.ImageIcon;
public class bloc extends object{



    public bloc(int x, int y){
        super(x,y,35,35);
        super.objicon=new ImageIcon(getClass().getResource("/image/bloc.png"));
        super.objimg=this.getObjicon().getImage();
    }

}

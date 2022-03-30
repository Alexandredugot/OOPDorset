package com.mathmaurer.object;

import java.awt.Image;
import javax.swing.ImageIcon;
public class bloc extends object{



    public bloc(int x, int y){
        super(x,y,43,65);
        super.objicon=new ImageIcon(getClass().getResource("/image/block.png"));
        super.objimg=this.getObjicon().getImage();
    }

}

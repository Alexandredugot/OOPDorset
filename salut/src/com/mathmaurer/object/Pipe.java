package com.mathmaurer.object;

import java.awt.Image;
import javax.swing.ImageIcon;
public class Pipe extends object{

    public Pipe(int x, int y){
        super(x,y,43,65);
        super.objicon=new ImageIcon(getClass().getResource("/image/tuyauRouge.png"));
        super.objimg=this.getObjicon().getImage();
    }

}

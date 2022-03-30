package com.mathmaurer.object;

import java.awt.Image;
import javax.swing.ImageIcon;
public class bloc extends object{

    private Image imgblock;
    private ImageIcon blockicon;

    public bloc(int x, int y){
        super(x,y,43,65);
        this.blockicon= new ImageIcon(getClass().getResource("/image/block.png"));
        this.imgblock=this.blockicon.getImage();
    }

    public Image getImgblock(){return imgblock;}
}

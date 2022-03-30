package com.mathmaurer.object;

import javax.swing.*;
import java.awt.*;

public class object {
   private int x,y;
   private int width,height;
   protected Image objimg;
   protected ImageIcon objicon;

   public object(int xi, int yi,int objheight, int objwidth){
       this.x=xi;
       this.y=yi;
       this.width=objwidth;
       this.height=objheight;
   }

   public int getHeight(){
       return this.height;
   }
    public int getWidth() {
        return width;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Image getObjimg() {return objimg;}
    public ImageIcon getObjicon() {return objicon;}

    public void setHeight(int height) {
        this.height = height;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setObjimg(Image objimg) {this.objimg = objimg;}
    public void setObjicon(ImageIcon objicon) {this.objicon = objicon;}
}

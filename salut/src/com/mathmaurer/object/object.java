package com.mathmaurer.object;

import com.mathmaurer.jeu.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.*;
import java.util.List;

public class object extends JPanel {
   private int x,y;
   private int width,height;
   protected Image objimg;
   protected ImageIcon objicon;

   public static ArrayList<object> list = new ArrayList<object>();

   public object(int xi, int yi,int objheight, int objwidth){
       this.x=xi;
       this.y=yi;
       this.width=objwidth;
       this.height=objheight;
       list.add(this);
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


    public void MoveOject(int i){

        list.get(i).x = x- Main.scene.Getdx();

    }


}

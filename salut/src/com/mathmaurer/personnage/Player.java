package com.mathmaurer.personnage;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.ImageIcon;

public class Player extends personnage {

    private Image imgPlayer;
    private ImageIcon icoPlayer;

    public Player(int x,int y){
        super(x,y,28,50,100,10,3);
        this.icoPlayer = new ImageIcon("src/Image/marioArretDroite.png");
        this.imgPlayer = this.icoPlayer.getImage();
    }

    public Image getImgPlayer(){return imgPlayer;}

}

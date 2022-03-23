package com.mathmaurer.jeu;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class Scene extends JPanel {

    private ImageIcon icoFond;
    private Image imgfond1;

    private ImageIcon icoGame;
    private Image imgGame;

    private int xFond1;


    public Scene(){
        super();
        this.xFond1 = -50;
        icoFond = new ImageIcon(getClass().getResource("/Image/fondEcran.png"));
        this.imgfond1 = this.icoFond.getImage();
        icoGame = new ImageIcon(getClass().getResource("/Image/marioArretDroite.png"));
        this.imgGame = this.icoGame.getImage();


    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;
        g2.drawImage(this.imgfond1,this.xFond1,0,null);
        g2.drawImage(imgGame,300,245,null);
    }
}

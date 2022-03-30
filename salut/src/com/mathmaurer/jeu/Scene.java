package com.mathmaurer.jeu;
import com.mathmaurer.personnage.Player;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class Scene extends JPanel {

    private ImageIcon icoFond;
    private Image imgfond1;
    private Image imgfond2;

    private ImageIcon icocastle;
    private Image imgcastle;
    private ImageIcon icoDepart;
    private Image imgDepart;

    private int xFond1;
    private int xFond2;

    private int xPos;
    private int ySol;
    private int HauteurPlafond;

    private int xcastle;
    private int xdepart;

    private int dx;
    private int jumpForce;

    public com.mathmaurer.personnage.Player player;



    public Scene(){
        super();
        this.xFond1 = -50;
        this.xFond2 = 750;
        this.xcastle = 10;
        this.xdepart = 220;

        this.ySol = 293;
        this.HauteurPlafond = 0;


        player = new Player(300,245);


        this.dx = 0;
        icoFond = new ImageIcon(getClass().getResource("/Image/fondEcran.png"));
        this.imgfond1 = this.icoFond.getImage();
        this.imgfond2 = this.icoFond.getImage();


        this.icocastle = new ImageIcon(getClass().getResource("/Image/chateau1.png"));
        this.imgcastle = this.icocastle.getImage();

        this.icoDepart = new ImageIcon(getClass().getResource("/Image/depart.png"));
        this.imgDepart = this.icoDepart.getImage();

        this.setFocusable(true);
        this.requestFocusInWindow();

        this.addKeyListener(new Clavier());

        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();
    }

    public int Getdx(){
        return this.dx;
    }

    public void Setdx(int n){
        this.dx = n;
    }

    public int GetJumpForce(){return this.jumpForce;}

    public void SetjumpForce(int n){this.jumpForce =n;}

    public void setySol(int n){this.ySol =n;}

    public void setHauteurPlafond(int n){this.HauteurPlafond = n;}

    public int getySol(){return this.ySol;}

    public int getHauteurPlafond(){return this.HauteurPlafond;}

    public void Movefond(){

        this.xFond1 = this.xFond1 - this.dx;
        this.xFond2 = this.xFond2 - this.dx;
        this.xcastle = this.xcastle - this.dx;
        this.xdepart = this.xdepart - this.dx;

        if(this.xFond1 == -800)
        {
            this.xFond1 = 800;
        }
        else if(this.xFond2 == -800)
        {
            this.xFond2 = 800;
        }
        else if(this.xFond1 == 800)
        {
            this.xFond1 = -800;
        }
        else if(this.xFond2 == 800)
        {
            this.xFond2 = -800;
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;

        this.Movefond();
        Menu.button.setBounds(Main.fenetre.getWidth()/2 -100,Main.fenetre.getHeight()/2 -50,200,50);
        g2.drawImage(this.imgfond1,this.xFond1,0,null);
        g2.drawImage(this.imgfond2,this.xFond2,0,null);

        if(this.player.getsaut()){g2.drawImage(this.player.saute(), this.player.getX(), this.player.getY(), null);}
        else{g2.drawImage(this.player.MOVE("mario", 25), this.player.getX(), this.player.getY(), null);}


        g2.drawImage(imgcastle,xcastle,95,null);
        g2.drawImage(imgDepart,xdepart,234,null);



    }
}

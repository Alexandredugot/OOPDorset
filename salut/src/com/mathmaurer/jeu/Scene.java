package com.mathmaurer.jeu;
import com.mathmaurer.personnage.Player;
import com.mathmaurer.object.bloc;
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
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

    public bloc blocA;
    public bloc blocB;
    public bloc blocC;
    public bloc blocD;
    public bloc blocE;
    public bloc blocF;
    public bloc blocG;
    public bloc blocH;
    public bloc blocI;
    public bloc blocJ;
    public bloc blocK;
    public bloc blocL;

    private ArrayList<Object> objlist;

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
/*
        blocA= new bloc(400,180);
        blocB=new bloc(1200,180);
        blocC= new bloc(1270,170);
        blocD = new bloc(1340,160);
        blocE = new bloc(2000,180);
        blocF = new bloc(2600,160);
        blocG= new bloc(2650,180);
        blocH= new bloc(3500,160);
        blocI= new bloc(3550,140);
        blocJ = new bloc(4000,200);
        blocK= new bloc(4200,200);
        blocL= new bloc(4300,210);

        objlist = new ArrayList<Object>();
        this.objlist.add(this.blocA);
        this.objlist.add(this.blocB);
        this.objlist.add(this.blocC);
        this.objlist.add(this.blocD);
        this.objlist.add(this.blocE);
        this.objlist.add(this.blocF);
        this.objlist.add(this.blocG);
        this.objlist.add(this.blocI);
        this.objlist.add(this.blocJ);
        this.objlist.add(this.blocK);
        this.objlist.add(this.blocL);*/
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

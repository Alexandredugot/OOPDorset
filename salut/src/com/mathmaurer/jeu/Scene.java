package com.mathmaurer.jeu;
import com.mathmaurer.object.Coin;
import com.mathmaurer.object.Pipe;
import com.mathmaurer.personnage.Player;
import com.mathmaurer.object.bloc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mathmaurer.object.object;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class Scene extends JPanel implements ActionListener{

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
    private int xCube;

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

    public JButton button;
    public boolean ispause;
    public boolean notpause;
    public boolean first;

    public Coin coinA = new Coin(402,145);
   public Coin coinB = new Coin(1202,140);
   public Coin coinC = new Coin(1272,95);
   public Coin coinD = new Coin(1342,40);
   public Coin coinE = new Coin(1650,145);
   public Coin coinF = new Coin(2650, 145);
   public Coin coinG = new Coin(3000,135);
   public Coin coinH = new Coin(3400,125);
   public Coin coinI = new Coin(4200,145);
   public Coin coinJ = new Coin(4600,40);
   private ArrayList<Coin> CoinArr= new ArrayList<Coin>();


    public Pipe redpipe1 = new Pipe(600,230);
    public Pipe redpipe2 = new Pipe(1000,230);
    public Pipe redpipe3 = new Pipe(1600,230);
    public Pipe redpipe4 = new Pipe(1900,230);
    public Pipe redpipe5 = new Pipe(2500,230);
    public Pipe redpipe6 = new Pipe(3000,230);
    public Pipe redpipe7 = new Pipe(3800,230);
    public Pipe redpipe8 = new Pipe(4500,230);

    public Scene(){
        super();
        ispause = false;
        first = false;
        this.xFond1 = -50;
        this.xFond2 = 750;
        this.xcastle = 10;
        this.xdepart = 220;
        this.xCube = 400;


        this.ySol = 293;
        this.HauteurPlafond = 0;


        player = new Player(300,245);
        blocA= new bloc(400,180);
        blocB=new bloc(1200,180);
        blocC= new bloc(1270,170);
        blocD = new bloc(1340,160);
        blocE = new bloc(2000,180);
        bloc grg = new bloc(100,150);




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

        this.CoinArr.add(this.coinA);
        this.CoinArr.add(coinB);
        this.CoinArr.add(coinC);
        this.CoinArr.add(coinD);
        this.CoinArr.add(coinE);
        this.CoinArr.add(coinF);
        this.CoinArr.add(coinG);
        this.CoinArr.add(coinH);
        this.CoinArr.add(coinI);
        this.CoinArr.add(coinJ);
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
        this.xcastle = this.xcastle - this.dx;
        this.xdepart = this.xdepart - this.dx;
        this.xFond1 = this.xFond1 - this.dx;
        this.xFond2 = this.xFond2 - this.dx;


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
        Main.menu.button.setBounds(Main.fenetre.getWidth()/2 -100,Main.fenetre.getHeight()/2 -50,200,50);
        g2.drawImage(this.imgfond1,this.xFond1,0,null);
        g2.drawImage(this.imgfond2,this.xFond2,0,null);

        if(this.player.getsaut()){g2.drawImage(this.player.saute(), this.player.getX(), this.player.getY(), null);}
        else{g2.drawImage(this.player.MOVE("mario", 25), this.player.getX(), this.player.getY(), null);}


        g2.drawImage(imgcastle,xcastle,95,null);
        g2.drawImage(imgDepart,xdepart,234,null);

        for(int i =0;i<com.mathmaurer.object.object.list.size();i++){
            com.mathmaurer.object.object.list.get(i).MoveOject(i);
            g2.drawImage(com.mathmaurer.object.object.list.get(i).getObjimg(),com.mathmaurer.object.object.list.get(i).getX(),com.mathmaurer.object.object.list.get(i).getY(),null);
        }/*
        for(int i=0;i<this.CoinArr.size();i++){
            g2.drawImage( this.CoinArr.get(i).pictchange(), this.CoinArr.get(i).getX(), this.CoinArr.get(i).getY(),null);
        }*/



        if(ispause && first == false){
            PauseMenu();
            first = true;
            notpause = false;
        }
        else if(notpause && first){
            first =false;
            ispause =  false;
            Unpause();
        }





    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            System.exit(0);
        }

    }

    public void PauseMenu() {
        button = new JButton();
        button.setBounds(100,300,200,50);
        this.add(button);
        button.addActionListener(this);
        button.setText("Quit");
        button.setFocusable(false);
        button.setBackground(Color.red);
        button.setForeground(Color.CYAN);
    }

    public void Unpause(){
        button.remove(button);
        button.setVisible(false);
    }
}

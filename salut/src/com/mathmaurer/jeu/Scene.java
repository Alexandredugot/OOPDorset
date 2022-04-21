package com.mathmaurer.jeu;
import com.mathmaurer.object.Coin;
import com.mathmaurer.object.Pipe;
import com.mathmaurer.personnage.Player;
import com.mathmaurer.object.bloc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mathmaurer.object.object;
import com.mathmaurer.personnage.damage;
import com.mathmaurer.personnage.stonks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
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

    private ImageIcon icoendflag;
    private Image endflagimg;
    private int xflag;

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

    Polygon p = new Polygon();
    String death = new String();

    public static boolean life;
    public static int damage = 0;
    public boolean a;
    public boolean dead = true;

    public JButton deathquit;
    public JButton reload;

    public com.mathmaurer.personnage.stonks monster;
    public com.mathmaurer.personnage.stonks monster2;

    public Scene(){
        super();

        death = "Only losers see this screen!";
        a=true;
        life = false;
        ispause = false;
        first = false;
        this.xFond1 = -50;
        this.xFond2 = 750;
        this.xcastle = 10;
        this.xdepart = 220;
        this.xCube = 400;
        this.xflag=4650;

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

        this.icoendflag = new ImageIcon(getClass().getResource("/Image/drapeau.png"));
        this.endflagimg = this.icoendflag.getImage();

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
        blocL= new bloc(4300,210);*/
        Thread a = new Thread(monster = new stonks(400,264));
        a.start();
        Thread c = new Thread(monster2 = new stonks(650,264));
        c.start();
        Thread b = new Thread(new damage());
        b.start();
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
        this.monster.x = this.monster.x -this.dx;
        this.monster2.x = this.monster2.x -this.dx;
        this.xflag-=this.dx;


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

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;

        for(int i =0;i<com.mathmaurer.object.object.list.size();i++){
            object objet= com.mathmaurer.object.object.list.get(i);
            if(objet.getClass()==Coin.class){
                ((Coin) objet).setObjimg(((Coin) objet).pictchange());
            }
            if(player.close(objet)){

                if(objet.getClass()!=Coin.class){
                    player.contact(objet);
                }
                else{
                    if(player.contactcoin(objet)){
                        com.mathmaurer.object.object.list.remove(i);
                    }
                }
            }
        }
        this.Movefond();
        Main.menu.button.setBounds(Main.fenetre.getWidth()/2 -100,Main.fenetre.getHeight()/2 -50,200,50);
        g2.drawImage(this.imgfond1,this.xFond1,0,null);
        g2.drawImage(this.imgfond2,this.xFond2,0,null);

        if(this.player.getsaut()){g2.drawImage(this.player.saute(), this.player.getX(), this.player.getY(), null);}
        else{g2.drawImage(this.player.MOVE("mario", 25), this.player.getX(), this.player.getY(), null);
        }


        g2.drawImage(imgcastle,xcastle,95,null);
        g2.drawImage(imgDepart,xdepart,234,null);
        g2.drawImage(endflagimg,xflag,115,null);
        for(int i =0;i<com.mathmaurer.object.object.list.size();i++){
            object objet= com.mathmaurer.object.object.list.get(i);
            objet.MoveOject(i);
            g2.drawImage(objet.getObjimg(), objet.getX(), objet.getY(), null);

        }
        /*
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

        SetLifeBar(g,damage);
        if(player.life == 0 && dead){
            KillScreen(g);
            dead = false;
        }
        if(dead == false)
        {
            deathquit.setBounds(280,180,100,50);
            reload.setBounds(280,100,100,50);
            Font f = new Font("Agency FB",Font.BOLD,35);
            g.setFont(f);
            g.drawString(death,Main.scene.getWidth()/2 -170  ,Main.scene.getHeight()/2 -100);

        }
        for(int i =0;i<stonks.list.size();i++)
        {
            if(stonks.list.get(i).life>0){

                g.drawImage(stonks.list.get(i).MOVE("champ",30),stonks.list.get(i).x,stonks.list.get(i).y,null);
            }
            else{
                for(int j = 0;j<stonks.list.size();j++)
                {
                    if(stonks.list.get(j).direction>0)
                    {
                        stonks.list.get(j).icoMonster = new ImageIcon("src/Image/champEcraseDroite.png");
                        stonks.list.get(j).imgMonster = stonks.list.get(j).icoMonster.getImage();
                    }
                    else
                    {
                        stonks.list.get(j).icoMonster = new ImageIcon("src/Image/champEcraseGauche.png");
                        stonks.list.get(j).imgMonster = stonks.list.get(j).icoMonster.getImage();
                    }
                    g.drawImage(stonks.list.get(j).imgMonster,stonks.list.get(i).x,stonks.list.get(i).y+20,null);
                }

            }
        }

        CoinBar(g);




    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            System.exit(0);
        }
        else if(e.getSource()==deathquit){
            System.exit(0);
        }
        else if(e.getSource()==reload){
            Main.scene.player.life = 100;
            dead =true;
            deathquit.setVisible(false);
            reload.setVisible(false);
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

    public void SetLifeBar(Graphics g,int damage){
        p = new Polygon();
        if(player.life<= 0)
            player.life =0;
        p.addPoint(50, 40);
        p.addPoint(Main.scene.player.life+50, 40);
        p.addPoint(Main.scene.player.life+50, 20);
        p.addPoint(50, 20);

        g.setColor(Color.red);
        g.fillPolygon(p);
        g.drawPolygon(p);
        g.setColor(Color.red);
        Font f = new Font("Agency FB",Font.BOLD,25);
        g.setFont(f);
        g.drawString("LP",20,38);
    }

    public void KillScreen(Graphics g){
        deathquit = new JButton();
        reload = new JButton();
        this.add(deathquit);
        this.add(reload);
        reload.addActionListener(this);
        deathquit.addActionListener(this);
        deathquit.setText("RageQuit");
        reload.setText("Reload");
        deathquit.setFocusable(false);
        reload.setFocusable(false);
        deathquit.setBackground(Color.red);
        deathquit.setForeground(Color.CYAN);
        reload.setBackground(Color.red);
        reload.setForeground(Color.CYAN);

    }

    public void CoinBar(Graphics g)
    {
        ImageIcon a =new ImageIcon(getClass().getResource("/image/piece1.png"));
        Image b =a.getImage();
        Font f = new Font("Agency FB",Font.BOLD,25);
        g.setFont(f);
        g.setColor(Color.white);
        g.drawString(""+Main.scene.player.coincount,610,29);
        g.drawImage(b,630,5,null);

    }




}

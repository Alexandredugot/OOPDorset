package com.mathmaurer.personnage;
import com.mathmaurer.jeu.Main;
import com.mathmaurer.object.object;
import com.mathmaurer.object.Coin;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.ImageIcon;

public class Player extends personnage {

    private Image imgPlayer;
    private ImageIcon icoPlayer;

    private boolean saut;
    private int compteurSaut;
    public int coincount;

    public int finishedlevel;

    public Player(int x,int y){
        super(x,y,28,50,100,10,3);
        this.icoPlayer = new ImageIcon("src/Image/marioArretDroite.png");
        this.imgPlayer = this.icoPlayer.getImage();

        this.saut = false;
        this.compteurSaut =0;
        this.coincount=0;
        this.finishedlevel=0;
    }

    public Image getImgPlayer(){return imgPlayer;}


    public int getCompteurSaut() {
        return compteurSaut;
    }

    public void SetCompt(int n){
        compteurSaut = n;
    }

    public boolean getsaut(){
        return saut;
    }
    public void SetSaut(boolean b){
        saut = b;
    }


    public Image saute(){
        String str;
        ImageIcon ico;
        Image img;

        this.compteurSaut++;
        // Montée du saut
        if(this.compteurSaut <= 40){
            if(this.getY() > com.mathmaurer.jeu.Main.scene.getHauteurPlafond()){this.setY(this.getY() - 4);}
            else{this.compteurSaut = 41;}
            if(this.isVersDroite() == true){str = "/Image/marioSautDroite.png";}
            else{str = "/Image/marioSautGauche.png";}
            // Retombée du saut
        }else if(this.getY() + this.getHeight() < com.mathmaurer.jeu.Main.scene.getySol()){this.setY(this.getY() + 1);
            if(this.isVersDroite() == true){str = "/Image/marioSautDroite.png";}
            else{str = "/Image/marioSautGauche.png";}
            for(int i = 0;i<stonks.list.size();i++)
            {
                if(stonks.list.get(i).x <= Main.scene.player.getX()+8 && stonks.list.get(i).x>= Main.scene.player.getX()-8)
                {
                    stonks.list.get(i).life =0;
                }
            }
            // Saut terminé
        }else{
            if(this.isVersDroite() == true){str = "/Image/marioArretDroite.png";}
            else{str = "/Image/marioArretGauche.png";}
            this.saut = false;
            this.compteurSaut = 0;
        }
        // Affichage de l'image de mario
        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
        return img;
    }

    public void contact(object objet) {
        if((super.Frontcontact(objet) && this.isVersDroite()) || (super.Backcontact(objet) && this.isVersDroite() == false)){
            Main.scene.Setdx(0);
            this.setMarche(false);
        }
        if(super.Botcontact(objet)&& this.saut){
            Main.scene.setySol(objet.getY());
        }else if(super.Botcontact(objet) == false){
            Main.scene.setySol(293);
            if(this.saut == false){this.setY(243);}
        }
        if(super.Topcontact(objet)){
            Main.scene.setHauteurPlafond(objet.getY() + objet.getHeight());
        }else if(super.Topcontact(objet) == false && this.saut == false){
            Main.scene.setHauteurPlafond(0);
        }
    }

    public boolean contactcoin(object coin){
        if(this.Backcontact(coin)||this.Topcontact(coin)||this.Frontcontact(coin)||this.Botcontact(coin)){
            this.coincount+=1;
            return true;
        }
        return false;
    }

    public void Attack()
    {
        for(int i = 0;i<stonks.list.size();i++)
        {
            if(stonks.list.get(i).x <= Main.scene.player.getX()+8 && stonks.list.get(i).x>= Main.scene.player.getX()-8)
            {

            }
        }

    }
}

package com.mathmaurer.personnage;

import java.awt.*;
import javax.swing.ImageIcon;

public class personnage {

    private int width;
    private int height;
    private int x;
    private int y;
    private boolean marche;
    private boolean versDroite;
    public int compteur;
    public int life;
    public int damage;
    public int reach;

    public personnage(int x,int y,int width,int height,int life,int damage,int reach){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.life = life;
        this.damage = damage;
        this.reach = reach;
        this.compteur = 0;
        this.marche = false;
        this.versDroite = true;
    }

    public int getLife() {
        return life;
    }

    public int getDamage() {
        return damage;
    }

    public int getReach(){
        return reach;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCompteur() {
        return compteur;
    }

    public boolean isMarche() {
        return marche;
    }

    public boolean isVersDroite() {
        return versDroite;
    }

    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setMarche(boolean marche) {
        this.marche = marche;
    }

    public void setReach(int reach) {
        this.reach = reach;
    }

    public void setVersDroite(boolean versDroite) {
        this.versDroite = versDroite;
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

    public Image MOVE(String nom, int frequence){
        String str;
        ImageIcon ico;
        Image img;

        if(this.marche == false)
        {
            if(this.versDroite ==  true)
            {
                str="/Image/" + nom + "ArretDroite.png";
            }
            else
            {
                str="/Image/" + nom + "ArretGauche.png";
            }
        }

        else
        {
            if(this.compteur/ frequence == 0)
            {
                if(this.versDroite == true)
                {
                    str="/Image/" + nom + "ArretDroite.png";
                }
                else
                {
                    str="/Image/" + nom + "ArretGauche.png";
                }
            }
            else
            {
                if(this.versDroite == true)
                {
                    str="/Image/" + nom + "MarcheDroite.png";
                }
                else
                {
                    str="/Image/" + nom + "MarcheGauche.png";
                }

            }
            this.compteur++;
            if(this.compteur == 2 * frequence)
            {
                compteur =0;
            }
        }
        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
        return img;
    }



}
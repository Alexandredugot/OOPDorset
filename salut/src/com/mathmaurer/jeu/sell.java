package com.mathmaurer.jeu;

public class sell {
    public int price;
    public type Content;


    public sell(type content,int p){
        this.Content = content;
        this.price = p;
    }
}

enum type{
    LIFE,
    SPEED,
}
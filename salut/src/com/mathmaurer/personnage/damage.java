package com.mathmaurer.personnage;

public class damage implements Runnable {
    @Override
    public void run(){
        while(stonks.list.size()>0)
        {
            stonks.AttackAll();

            try{
                Thread.sleep(60);
            }catch(InterruptedException e){

            }
        }

    }
}

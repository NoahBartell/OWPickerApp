package com.noah.stuff.Classes;
import java.util.ArrayList;
import java.util.Random;
import com.noah.stuff.Enums.*;
import com.noah.stuff.Enums.dps;
import com.noah.stuff.Enums.support;
import com.noah.stuff.Enums.tanks;

public class CharList {
    ArrayList<Character> HeroList;

    public boolean keepHeroes;
    public boolean isBalanced;

    private int times;

    public int getTimes(){
        return times;
    }

    public void setTimes(int num){
        this.times = num;
    }

    public void setKeepHeroes(boolean bool){
        this.keepHeroes = bool;
    }

    public void setBalanced(boolean bool){
        this.isBalanced = bool;
    }


    static Random rand = new Random();

    public CharList(){
        this.HeroList = setCharacters();

    }

    public void reset(){
        this.HeroList.clear();
        this.HeroList = setCharacters();
    }

    public ArrayList<Character> setCharacters(){
        ArrayList<Character> hero = new ArrayList<Character>();
        for(com.noah.stuff.Enums.dps dps : dps.values()){
            hero.add(new Character(dps.toString(), "Dps"));
        }
        for(support sup : support.values()){
            hero.add(new Character(sup.toString(), "Support"));
        }
        for(tanks tank : tanks.values()){
            hero.add(new Character(tank.toString(), "Tank"));
        }
        return hero;
    }


    public Character getHero(){
        return HeroList.get(rand.nextInt(HeroList.size()));
    }



    public String getRoll(){
        if(HeroList.size() >= times){
            String buildString = "";

            for (int i = 0; i < times; i++) {
                int num = i+1;
                buildString += "Player " + num + " ";
                Character Hero = getHero();
                buildString += Hero.printChar();
                buildString += "\n";
                if(!keepHeroes) {
                    HeroList.remove(Hero);
                }
            }
            return(buildString);
        }
        else{
            return "Reset Characters";
        }
    }

    public String getLeft(){
        String buildString = "";
        for (Character hero : HeroList){
            buildString += hero.printChar() + "\n";
        }
        return buildString;
    }
    
}

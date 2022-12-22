package com.example.stuff.Classes;


public class Character{
    public String Name;
    public String Category;

    public Character(String name, String cat){
        this.Name = name;
        this.Category = cat;
    }
    public Character(String name){
        this.Name = name;
        Category = "";
    }

    public String printChar(){
        
        String text = this.Name + " " + this.Category + " ";
        if(text.charAt(text.length()-2) == ' '){
            text = text.substring(0, text.length()-1);
        }
        return text;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic.Cards;

import MR_Game_Logic.Card;
/**
 *
 * @author pedri
 */
public class Monster extends Card{


    public Monster(){
        this.name = "Monster";
    }
    
    public Monster(int level, int area , int dice){
        this.name = "Monster";
        switch(level){
            case 1:
                this.dmg = 2;
                this.hp = area + dice;
                this.reward = 1;
                break;
            case 2:
                this.dmg = 4;
                this.hp = area + dice;
                this.reward = 1;
                break;
            case 3:
                this.dmg = 6;
                this.hp = area + dice;
                this.reward = 2;
                break;
            case 4:
                this.dmg = 8;
                this.hp = area + dice;
                this.reward = 2;
                break;
            case 5:
                this.dmg = 10;
                this.hp = area + dice;
                this.reward = 3;
                break;
        }
    }
    
    public Monster(int level , int area, int dice, boolean event){
        this.name = "Monster";
        this.hp = area + dice;
        this.dmg = level * 2;
        this.reward = 2;
    }

    public String toString(){
        String stats ="";
        stats = "NAME " + name + " | HP " + hp + " | Damage " + dmg;
        return stats;
    }
}

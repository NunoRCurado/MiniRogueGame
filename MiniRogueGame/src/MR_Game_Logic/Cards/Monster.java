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
    
    public int dmg;
    public int reward;
    public int hp;
    

    public Monster(){
        this.name = "Monster";
        this.hp = 0; 
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
    
    public Monster(int level){
        this.name = "Boss Monster";
        switch(level){
            case 1:
                this.dmg = 3;
                this.hp = 10;
                this.reward = 2;
                break;
            case 2:
                this.dmg = 5;
                this.hp = 15;
                this.reward = 2;
                break;
            case 3:
                this.dmg = 7;
                this.hp = 20;
                this.reward = 3;
                break;
            case 4:
                this.dmg = 9;
                this.hp = 25;
                this.reward = 3;
                break;
            case 5:
                this.dmg = 12;
                this.hp = 30;
                this.reward = 4;
                break;
        }
    }

    @Override
    public String toString(){
        String stats ="";
        stats = "NAME " + name + " | HP " + hp + " | Damage " + dmg;
        return stats;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    
    
}

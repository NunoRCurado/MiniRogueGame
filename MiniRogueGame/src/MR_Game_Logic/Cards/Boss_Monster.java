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
public class Boss_Monster extends Card {



    public Boss_Monster(){
        this.name = "Boss Monster";
    }
    public Boss_Monster(int level){
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
    
    public String toString(){
        String stats ="";
        stats = "NAME " + name + " | HP " + hp + " | Damage " + dmg;
        return stats;
    }
}

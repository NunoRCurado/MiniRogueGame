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
public class Treasure extends Card{
    
    public Treasure(){
        this.name = "Treasure";
    }
    
    public String toString(){
        String toString = "";
        toString = "1 - Armor Piece (+1 Armor)\n"+
                    "2 - Better Weapon (+2 Xp)\n"+
                    "3 - Firebal Spell\n" +
                    "4 - Ice Spell \n" +
                    "5 - Poison Spell\n" +
                    "6 - Healing Spell\n";
        return toString;
    }
}

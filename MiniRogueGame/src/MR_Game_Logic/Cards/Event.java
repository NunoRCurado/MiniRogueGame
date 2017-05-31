/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic.Cards;

import MR_Game_Logic.Constants;
import MR_Game_Logic.Card;
import MR_Game_Logic.Player;
/**
 *
 * @author pedri
 */
public class Event extends Card implements Constants{
    
    public Event(){
        this.name = "Event";
    }
    @Override
    public String toString(){
        String toString;
        toString = "1 - Found Ration (+1 Food)\n" +
                "2 - Found Health Potion (+2 Health)\n" +
                "3 - Found Loot (+2 Gold)\n" +
                "4 - Found Whetstone (+2Xp)\n" +
                "5 - Found Armor (+1 Armor)\n" +
                "6 - Monster\n";
        return toString;
    }
}

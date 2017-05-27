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
public class Trap extends Card {
    
    public Trap(){
        this.name = "Trap";
    }
    
    public String toString(){      
        String toString= "";
        toString = "1 - Mold Miasma (-1 Food)\n" +
                "2 - Tripwire (-1 Gold)\n" +
                "3 - Acid Mist (-1 Armor)\n" +
                "4 - Spring Blades (-1 Hp)\n" +
                "5 - Moving Walls (-1 Xp)\n" +
                "6 - Pit\n";
        return toString;
    }
}

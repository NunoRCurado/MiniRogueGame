/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic.Spell;

import MR_Game_Logic.GameData;
import MR_Game_Logic.Spells;

/**
 *
 * @author Foca
 */
public class Poison extends Spells{
    
    public Poison(){
        this.name = "Poison";
    }
    
    @Override
    public void effect(GameData gameData){
        gameData.getPlayer().setDmg(gameData.getPlayer().getDmg() + 5);
        gameData.getPlayer().setPoison(true);
    }
}

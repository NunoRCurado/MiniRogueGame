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
public class Fireball extends Spells{
     
    public Fireball(){
        this.name = "Fireball";
    }
    
    @Override
    public void effect(GameData gameData){
        gameData.getPlayer().setDmg(gameData.getPlayer().getDmg() + 8);
    }
    
    public void removeEffect(GameData gameData){
        if(gameData.getPlayer().getDmg() >= 8)
            gameData.getPlayer().setDmg(gameData.getPlayer().getDmg() - 8);
    }
}

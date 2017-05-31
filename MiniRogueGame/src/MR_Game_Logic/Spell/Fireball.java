/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic.Spell;

import MR_Game_Logic.Cards.Monster;
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
        int monsterHp = ((Monster)gameData.getCard()).getHp();
        ((Monster)gameData.getCard()).setHp(monsterHp - 8);
    }
    
}

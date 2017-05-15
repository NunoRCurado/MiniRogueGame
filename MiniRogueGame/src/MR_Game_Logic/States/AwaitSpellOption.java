/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic.States;

import MR_Game_Logic.GameData;

/**
 *
 * @author Nuno
 */
public class AwaitSpellOption extends StateAdapter {
    
    public AwaitSpellOption(GameData g) {
        super(g);
    }
    
    @Override
    public IStates setSpellOption(int option){
        
       if (!getGame().getPlayer().getSpells().isEmpty()) {
            getGame().getPlayer().getSpells().get(option).effect();
        }
  
       return this;
    }
}

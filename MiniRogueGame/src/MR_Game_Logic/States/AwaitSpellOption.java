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
    
    @Override
    public IStates attack() {
        int playerDmg = getGame().getPlayer().getDmg();
        int monsterHp = getGame().getCard().getHp();
        int monsterDmg = getGame().getCard().getDmg();
        int playerHealth = getGame().getPlayer().getHp() + getGame().getPlayer().getArmor();
        if( playerDmg >= monsterHp){
            getGame().setUiText("Matou o monstro");
            getGame().getPlayer().setXp(getGame().getPlayer().getXp() + getGame().getCard().getReward());
            getGame().checkLevelUp();
            getGame().checkCardEnd();
            return new AwaitCardSelection(getGame());
        }else{
            getGame().getPlayer().setHp(playerHealth - monsterDmg);
            if(monsterDmg >= getGame().getPlayer().getArmor()){
                getGame().getPlayer().setArmor(0);
            }
            if(getGame().isDead()){
                getGame().setUiText("Morreu e perdeu o jogo");
                return new AwaitBeginning(getGame());
            }
            getGame().getCard().setHp(monsterHp - playerDmg);
        return new AwaitDiceRoll(getGame());
    }
    
    }
}

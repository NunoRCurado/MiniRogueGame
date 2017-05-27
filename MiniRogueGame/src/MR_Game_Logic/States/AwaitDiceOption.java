/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic.States;

import MR_Game_Logic.*;
import MR_Game_Logic.Cards.Monster;
/**
 *
 * @author Foca
 */
public class AwaitDiceOption extends StateAdapter implements Constants{
    
    public AwaitDiceOption(GameData g) {
        super(g);
    }
    
    //Falta fazer Feats
    @Override
    public IStates checkAttack() {
        int playerDmg = getGame().getPlayer().getDmg();
        int monsterHp = ((Monster)getGame().getCard()).getHp();
        if( playerDmg >= monsterHp){
            getGame().setUiText("O seu dano e de: " + playerDmg);
            getGame().getPlayer().setDmg(0);
            getGame().setUiText(getGame().getUiText() + "\nMatou o monstro");
            getGame().getPlayer().setXp(getGame().getPlayer().getXp() + ((Monster)getGame().getCard()).getReward());
            if(getGame().checkLevelUp()){
                getGame().setUiText(getGame().getUiText() + "\n||=== Evoluiu para o Rank " + getGame().getPlayer().getRank() + "===||");
            }
            getGame().checkCardEnd();
            return new AwaitCardSelection(getGame());
        }
        return new AwaitSpellOption(getGame());
    }
    
}

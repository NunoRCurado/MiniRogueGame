/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic.States;

import MR_Game_Logic.*;
/**
 *
 * @author Foca
 */
public class AwaitDiceOption extends StateAdapter{
    
    public AwaitDiceOption(GameData g) {
        super(g);
    }
    
    //verificar se mato ou nao
    @Override
    public IStates checkAttack() {
        int playerDmg = getGame().getPlayer().getDmg();
        int monsterHp = getGame().getCard().getHp();
        if( playerDmg >= monsterHp){
            getGame().setUiText("Matou o monstro");
            getGame().getPlayer().setXp(getGame().getPlayer().getXp() + getGame().getCard().getReward());
            return new AwaitCardSelection(getGame());
        }
        return new AwaitSpellOption(getGame());
    }
    //senao mando para spells
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic.States;

import MR_Game_Logic.*;
import MR_Game_Logic.Cards.Monster;
import java.util.List;
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
        if(getGame().getPlayer().isPoison()){
            getGame().getPlayer().setDmg(playerDmg + 5);
        }
        int monsterHp = ((Monster)getGame().getCard()).getHp();
        List<Dice> dicesOut = getGame().getPlayer().getDices();
        for (int i = 0; i < getGame().getNumDices(); i++) {
                if (dicesOut.get(i).getStatus() == true) {
                    dicesOut.get(i).setStatus(false);
                    dicesOut.get(i).setRoll(dicesOut.get(i).getRoll());
                    break;
                }
            }
        if( playerDmg >= monsterHp){
            //getGame().setUiText("O seu dano e de: " + playerDmg);
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
    
    @Override
    public IStates performFeat(int num, int option) {
        //Meter na text ui os dados com feat possivel
        int roll, rollc, dmg = 0;
        getGame().getDice().roll();
        roll = getGame().getDice().getRoll();
        List<Dice> dicesOut = getGame().getPlayer().getDices();
        if (option == 1) {
            if (getGame().featHp()) {
                if (roll == 1) {
                    dicesOut.get(num).setStatus(true);
                    dicesOut.get(num).setRoll(0);
                } else if (roll == 6) {
                    dicesOut.get(num).setStatus(true);
                    dicesOut.get(num).setRoll(roll);
                    do {
                        getGame().getDice().roll();
                        rollc = getGame().getDice().getRoll();
                        if (rollc == 1) {
                            dicesOut.get(num).setRoll(0);
                        } else {
                            dicesOut.get(num).setRoll(dicesOut.get(num).getRoll() + rollc);
                        }
                    } while (rollc == 6);
                } else {
                    dicesOut.get(num).setStatus(true);
                    dicesOut.get(num).setRoll(roll);
                }
            }
            else{
                getGame().setUiText("Nao tem HP Suficiente");
                return this;
            }
        }
        if (option == 2) {
            if (getGame().featXp()) {
                if (roll == 1) {
                    dicesOut.get(num).setStatus(true);
                    dicesOut.get(num).setRoll(0);
                } else if (roll == 6) {
                    dicesOut.get(num).setStatus(true);
                    dicesOut.get(num).setRoll(roll);
                    do {
                        getGame().getDice().roll();
                        rollc = getGame().getDice().getRoll();
                        if (rollc == 1) {
                            dicesOut.get(num).setRoll(0);
                        } else {
                            dicesOut.get(num).setRoll(dicesOut.get(num).getRoll() + rollc);
                        }
                    } while (rollc == 6);
                } else {
                    dicesOut.get(num).setStatus(true);
                    dicesOut.get(num).setRoll(roll);
                }
            }
            else{
                getGame().setUiText("Nao tem XP Suficiente");
                return this;
            }
        }
        
        for (int i = 0; i < getGame().getNumDices(); i++) {
            dmg += dicesOut.get(i).getRoll();
        }
        getGame().getPlayer().setDmg(dmg);

        return this;
    }
}

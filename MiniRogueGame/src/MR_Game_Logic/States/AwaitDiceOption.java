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
        System.out.println("AwaitDiceOption");
        

    }
    
    //Falta fazer Feats
    @Override
    public IStates checkAttack() {
        int playerDmg = game.getPlayer().getDmg();
        if(game.getPlayer().isPoison()){
            game.getPlayer().setDmg(playerDmg + 5);
        }
        int monsterHp = ((Monster)game.getCard()).getHp(); 
        List<Dice> dicesOut = game.getPlayer().getDices();
        for (int i = 0; i < game.getNumDices(); i++) {
                if (dicesOut.get(i).getStatus() == true) {
                    dicesOut.get(i).setStatus(false);
                    dicesOut.get(i).setRoll(dicesOut.get(i).getRoll());
                    break;
                }
            }
        if( playerDmg >= monsterHp){
            game.getPlayer().setDmg(0);
            game.getPlayer().setPoison(false);
            game.setUiText(game.getUiText() + "\nMatou o monstro");
            game.getPlayer().setXp(game.getPlayer().getXp() + ((Monster)game.getCard()).getReward());
            if(game.checkLevelUp()){
                game.setUiText(game.getUiText() + "\n||=== Evoluiu para o Rank " + game.getPlayer().getRank() + "===||");
            }
            game.checkCardEnd();
            return new AwaitCardSelection(game);
        }

        return new AwaitSpellOption(game);
    }
    
    @Override
    public IStates performFeat(int num, int option) {
        //Meter na text ui os dados com feat possivel
        int roll, rollc, dmg = 0;
        game.getDice().roll();
        roll = game.getDice().getRoll();
        List<Dice> dicesOut = game.getPlayer().getDices();
        if (option == 1) {
            if (game.featHp()) {
                if (roll == 1) {
                    dicesOut.get(num).setStatus(true);
                    dicesOut.get(num).setRoll(0);
                } else if (roll == 6) {
                    dicesOut.get(num).setStatus(true);
                    dicesOut.get(num).setRoll(roll);
                    do {
                        game.getDice().roll();
                        rollc = game.getDice().getRoll();
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
                game.setUiText("Nao tem HP Suficiente");
                return this;
            }
        }
        if (option == 2) {
            if (game.featXp()) {
                if (roll == 1) {
                    dicesOut.get(num).setStatus(true);
                    dicesOut.get(num).setRoll(0);
                } else if (roll == 6) {
                    dicesOut.get(num).setStatus(true);
                    dicesOut.get(num).setRoll(roll);
                    do {
                        game.getDice().roll();
                        rollc = game.getDice().getRoll();
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
                game.setUiText("Nao tem XP Suficiente");
                return this;
            }
        }
        
        for (int i = 0; i < game.getNumDices(); i++) {
            dmg += dicesOut.get(i).getRoll();
        }
        game.getPlayer().setDmg(dmg);

        return this;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic.States;

import MR_Game_Logic.Constants;
import MR_Game_Logic.Dice;
import MR_Game_Logic.GameData;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Nuno
 */
public class AwaitDiceRoll extends StateAdapter implements Constants {

    public AwaitDiceRoll(GameData g) {
        super(g);
    }

    @Override
    public IStates rollDice() {
        int roll, dmg = 0;
        List<Dice> dicesOut = getGame().getPlayer().getDices();
//        if (num == 2 && getGame().checkCrits()) {
//            for (int i = 0; i < getGame().getNumDices(); i++) {
//                if (dicesOut.get(i).getStatus()) {
//                    dicesOut.get(i).setStatus(false);
//                }
//            }
//            getGame().setUiText("O seu dano e de: " + dmg);
//            return new AwaitDiceOption(getGame());
//        }
        if (!getGame().checkCrits()) {
            for (int i = 0; i < getGame().getNumDices(); i++) {
                getGame().getDice().roll();
                roll = 6;
                if (roll == 1) {
                    dicesOut.get(i).setStatus(false);
                    dicesOut.get(i).setRoll(roll);
                } else if (roll == 6) {
                    dicesOut.get(i).setStatus(true);
                    dicesOut.get(i).setRoll(roll);
                } else {
                    dicesOut.get(i).setStatus(false);
                    dicesOut.get(i).setRoll(roll);
                }
            }
            for (int i = 0; i < getGame().getNumDices(); i++) {
                dmg += dicesOut.get(i).getRoll();
            }

            getGame().getPlayer().setDmg(getGame().getPlayer().getDmg() + dmg);

            if (getGame().checkCrits()) {
                return this;
            }
        }
        getGame().setUiText("O seu dano e de: " + dmg);
        return new AwaitDiceOption(getGame());

    }

    @Override
    public IStates critDices(int num) {
        int roll, rollc, dmg = 0;
        List<Dice> dicesOut = getGame().getPlayer().getDices();
        if (num == 1) {
            for (int i = 0; i < getGame().getNumDices(); i++) {
                if (dicesOut.get(i).getStatus()) { //encontrou dado critico
                    getGame().getDice().roll();
                    roll = 6;
                    if (roll == 1) {
                        dicesOut.get(i).setStatus(false);
                        dicesOut.get(i).setRoll(0);
                        break;
                    } else if (roll == 6) {
                        dicesOut.get(i).setRoll(dicesOut.get(i).getRoll() + roll);
                        dicesOut.get(i).setStatus(false);
                        do {
                            getGame().getDice().roll();
                            rollc = getGame().getDice().getRoll();
                            if (rollc == 1) {
                                dicesOut.get(i).setStatus(false);
                                dicesOut.get(i).setRoll(0);
                                break;
                            } else {
                                dicesOut.get(i).setRoll(dicesOut.get(i).getRoll() + rollc);
                            }
                        } while (rollc == 6);
                        break;
                    } else {
                        dicesOut.get(i).setStatus(false);
                        dicesOut.get(i).setRoll(dicesOut.get(i).getRoll() + roll);
                        break;
                    }
                }
            }
        } else {
            for (int i = 0; i < getGame().getNumDices(); i++) {
                if (dicesOut.get(i).getStatus() == true) {
                    dicesOut.get(i).setStatus(false);
                    dicesOut.get(i).setRoll(dicesOut.get(i).getRoll());
                    break;
                }
            }
        }
        for (int i = 0; i < getGame().getNumDices(); i++) {
            dmg += dicesOut.get(i).getRoll();
        }
        getGame().getPlayer().setDmg(dmg);
        getGame().setUiText("O seu dano e de: " + dmg + " com dados criticos");
        if (getGame().checkCrits()) {
            return this;
        }
        return new AwaitDiceOption(getGame());
    }
}

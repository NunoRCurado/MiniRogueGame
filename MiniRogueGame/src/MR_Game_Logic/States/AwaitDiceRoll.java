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
        if (!getGame().checkCrits()) {
            for (int i = 0; i < getGame().getNumDices(); i++) {
                getGame().getDice().roll();
                roll = getGame().getDice().getRoll();
                if (roll == 1) {
                    dicesOut.get(i).setStatus(false);
                    dicesOut.get(i).setRoll(0);
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
        for (int i = 0; i < getGame().getNumDices(); i++) {
                dmg += dicesOut.get(i).getRoll();
        }
        getGame().getPlayer().setDmg(getGame().getPlayer().getDmg() + dmg);
        //getGame().setUiText("O seu dano e de: " + dmg);
        return new AwaitDiceOption(getGame());

    }

    @Override
    public IStates critDices(int num, int option) {
        int roll, rollc, dmg = 0;
        List<Dice> dicesOut = getGame().getPlayer().getDices();
        if (num == 1) {
            if (option <= dicesOut.size()) {
                if (dicesOut.get(option).getRoll() == 6 && dicesOut.get(option).getStatus()) {
                    getGame().getDice().roll();
                    roll = getGame().getDice().getRoll();
                    if (roll == 1) {
                        dicesOut.get(option).setStatus(false);
                        dicesOut.get(option).setRoll(0);
                    } else if (roll == 6) {
                        dicesOut.get(option).setRoll(dicesOut.get(option).getRoll() + roll);
                        dicesOut.get(option).setStatus(false);
                        do {
                            getGame().getDice().roll();
                            rollc = getGame().getDice().getRoll();
                            if (rollc == 1) {
                                dicesOut.get(option).setStatus(false);
                                dicesOut.get(option).setRoll(0);
                            } else {
                                dicesOut.get(option).setRoll(dicesOut.get(option).getRoll() + rollc);
                            }
                        } while (rollc == 6);
                    } else {
                        dicesOut.get(option).setStatus(false);
                        dicesOut.get(option).setRoll(dicesOut.get(option).getRoll() + roll);
                    }
                }
            } else {
                getGame().setUiText("Numero de Dado Invalido");
                return this;
            }
        } else {
            for (int i = 0; i < getGame().getNumDices(); i++) {
                if (dicesOut.get(i).getStatus() == true) {
                    dicesOut.get(i).setStatus(false);
                }
            }
        }
        for (int i = 0; i < getGame().getNumDices(); i++) {
            dmg += dicesOut.get(i).getRoll();
        }
        getGame().getPlayer().setDmg(dmg);
        if (getGame().checkCrits()) {
            return this;
        }
        return new AwaitDiceOption(getGame());
    }
}

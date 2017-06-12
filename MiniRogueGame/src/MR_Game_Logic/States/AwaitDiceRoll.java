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
         System.out.println("AwaitDiceRoll");
    }

    @Override
    public IStates rollDice() {
        int roll, dmg = 0;
        List<Dice> dicesOut = game.getPlayer().getDices();
        if (!game.checkCrits()) {
            for (int i = 0; i < game.getNumDices(); i++) {
                game.getDice().roll();
                roll = game.getDice().getRoll();
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
            for (int i = 0; i < game.getNumDices(); i++) {
                dmg += dicesOut.get(i).getRoll();
            }

            game.getPlayer().setDmg(game.getPlayer().getDmg() + dmg);

            if (game.checkCrits()) {
                return this;
            }
        }
        for (int i = 0; i < game.getNumDices(); i++) {
                dmg += dicesOut.get(i).getRoll();
        }
        game.getPlayer().setDmg(game.getPlayer().getDmg() + dmg);
        return new AwaitDiceOption(game);

    }

    @Override
    public IStates critDices(int num, int option) {
        int roll, rollc, dmg = 0;
        List<Dice> dicesOut = game.getPlayer().getDices();
        if (num == 1) {
            if (option <= dicesOut.size()) {
                if (dicesOut.get(option).getRoll() == 6 && dicesOut.get(option).getStatus()) {
                    game.getDice().roll();
                    roll = game.getDice().getRoll();
                    if (roll == 1) {
                        dicesOut.get(option).setStatus(false);
                        dicesOut.get(option).setRoll(0);
                    } else if (roll == 6) {
                        dicesOut.get(option).setRoll(dicesOut.get(option).getRoll() + roll);
                        dicesOut.get(option).setStatus(false);
                        do {
                            game.getDice().roll();
                            rollc = game.getDice().getRoll();
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
                game.setUiText("Numero de Dado Invalido");
                return this;
            }
        } else {
            for (int i = 0; i < game.getNumDices(); i++) {
                if (dicesOut.get(i).getStatus() == true) {
                    dicesOut.get(i).setStatus(false);
                }
            }
        }
        for (int i = 0; i < game.getNumDices(); i++) {
            dmg += dicesOut.get(i).getRoll();
        }
        game.getPlayer().setDmg(dmg);
        if (game.checkCrits()) {
            return this;
        }
        return new AwaitDiceOption(game);
    }
}

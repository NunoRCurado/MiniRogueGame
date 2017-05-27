/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic.States;

import MR_Game_Logic.*;
import MR_Game_Logic.Cards.*;
import MR_Game_Logic.Spell.Fireball;
import MR_Game_Logic.Spell.Healing;
import MR_Game_Logic.Spell.Ice;
import MR_Game_Logic.Spell.Poison;

/**
 *
 * @author pedri
 */
public class AwaitCardSelection extends StateAdapter {

    public AwaitCardSelection(GameData game) {
        super(game);
    }

    @Override
    public IStates resolveCard(String card) {
        if (card == "Trap") {
            getGame().getDice().roll();
            int roll = getGame().getDice().getRoll();
            getGame().getDice().roll();
            getGame().setUiText(getGame().getCard().toString());
            getGame().setUiText(getGame().getUiText() + "\nPrimeiro Dado: " + roll);
            int roll2 = getGame().getDice().getRoll();
            getGame().setUiText(getGame().getUiText() + "\n");
            getGame().setUiText(getGame().getUiText() + "Segundo Dado: " + roll2);
            getGame().setUiText(getGame().getUiText() + "\n");
            Player p = getGame().getPlayer();
            if (!getGame().skillCheck(roll2)) {
                switch (roll) {
                    case 1:
                        p.setFood(p.getFood() - 1);
                        getGame().setUiText(getGame().getUiText() + "Perdeu 1 de Food");
                        break;
                    case 2:
                        p.setGold(p.getGold() - 1);
                        getGame().setUiText(getGame().getUiText() + "Perdeu 1 de Gold");
                        break;
                    case 3:
                        p.setArmor(p.getArmor() - 1);
                        getGame().setUiText(getGame().getUiText() + "Perdeu 1 de Armor");
                        break;
                    case 4:
                        p.setHp(p.getHp() - 1);
                        getGame().setUiText(getGame().getUiText() + "Perdeu 1 de Hp");
                        break;
                    case 5:
                        p.setXp(p.getXp() - 1);
                        getGame().setUiText(getGame().getUiText() + "Perdeu 1 de Xp");
                        break;
                    case 6:
                        p.setHp(p.getHp() - 2);
                        if (getGame().getLevel() == 5) {
                            getGame().setUiText(getGame().getUiText() + "Perdeu 2 de Hp");
                            break;
                        }
                        getGame().setArenaBellow(getGame().getArena());
                        getGame().setUiText(getGame().getUiText() + "Perdeu 2 de HP e foi movido para a arena " + getGame().getArena());
                        break;

                }
            }
            getGame().checkCardEnd();
            return this;
        }
        if (card == "Treasure") {
            getGame().getDice().roll();
            int roll = getGame().getDice().getRoll();
            getGame().getDice().roll();
            getGame().setUiText(getGame().getCard().toString());
            getGame().setUiText(getGame().getUiText() + "\nPrimeiro Dado: " + roll);
            int roll2 = getGame().getDice().getRoll();
            getGame().setUiText(getGame().getUiText() + "\n");
            getGame().setUiText(getGame().getUiText() + "Segundo Dado: " + roll2);
            getGame().setUiText(getGame().getUiText() + "\n");
            Player p = getGame().getPlayer();
            if (getGame().isFight()) {
                getGame().setUiText(getGame().getUiText() + "Ganhou 2 de Gold");
                p.setGold(p.getGold() + 2);
            } else {
                getGame().setUiText(getGame().getUiText() + "Ganhou 1 de Gold");
                p.setGold(p.getGold() + 1);
            }
            if (roll >= 5) {
                switch (roll2) {
                    case 1:
                        p.setArmor(p.getArmor() + 1);
                        getGame().setUiText(getGame().getUiText() + " e Ganhou 1 de Armor");
                        break;
                    case 2:
                        p.setXp(p.getXp() + 2);
                        getGame().setUiText(getGame().getUiText() + " e Ganhou 2 de Xp");
                        if (getGame().checkLevelUp()) {
                            getGame().setUiText(getGame().getUiText() + "\n||=== Evoluiu para o Rank " + getGame().getPlayer().getRank() + "===||");
                        }
                        break;
                    case 3:
                        if (p.spells.size() == 2) {
                            getGame().removesSpell();
                        }
                        getGame().setUiText(getGame().getUiText() + " e Ganhou 1 Spell FireBall");
                        p.spells.add(new Fireball());
                        break;
                    case 4:
                        if (p.spells.size() == 2) {
                            getGame().removesSpell();
                        }
                        getGame().setUiText(getGame().getUiText() + " e Ganhou 1 Spell Ice");
                        p.spells.add(new Ice());
                        break;
                    case 5:
                        if (p.spells.size() == 2) {
                            getGame().removesSpell();
                        }
                        getGame().setUiText(getGame().getUiText() + " e Ganhou 1 Spell Poison");
                        p.spells.add(new Poison());
                        break;
                    case 6:
                        if (p.spells.size() == 2) {
                            getGame().removesSpell();
                        }
                        getGame().setUiText(getGame().getUiText() + " e Ganhou 1 Spell Healing");
                        p.spells.add(new Healing());
                        break;
                }
            }
            getGame().checkCardEnd();
            return this;
        }

        if (card == "Event") {
            getGame().getDice().roll();
            int roll = getGame().getDice().getRoll();
            getGame().setUiText(getGame().getCard().toString());
            getGame().setUiText(getGame().getUiText() + "\nPrimeiro Dado: " + roll);
            getGame().setUiText(getGame().getUiText() + "\n");
            Player p = getGame().getPlayer();
            switch (roll) {
                case 1:
                    p.setFood(p.getFood() + 1);
                    getGame().setUiText(getGame().getUiText() + "Ganhou 1 de Food");
                    break;
                case 2:
                    p.setHp(p.getHp() + 2);
                    getGame().setUiText(getGame().getUiText() + "Ganhou 2 de Hp");
                    break;
                case 3:
                    p.setGold(p.getGold() + 2);
                    getGame().setUiText(getGame().getUiText() + "Ganhou 2 de Gold");
                    break;
                case 4:
                    p.setXp(p.getXp() + 2);
                    getGame().setUiText(getGame().getUiText() + "Ganhou 2 de Xp");
                    if (getGame().checkLevelUp()) {
                        getGame().setUiText(getGame().getUiText() + "\n||=== Evoluiu para o Rank " + getGame().getPlayer().getRank() + "===||");
                    }
                    break;
                case 5:
                    p.setArmor(p.getArmor() + 1);
                    getGame().setUiText(getGame().getUiText() + "Ganhou 1 de Armor");
                    break;
                case 6:
                    getGame().setUiText(getGame().getUiText() + "Fase de Combate");
                    getGame().getDice().roll();
                    int rollDice = getGame().getDice().getRoll();
                    getGame().setCard(new Monster(getGame().getLevel(), getGame().getArena(), rollDice, true));
                    return new AwaitDiceRoll(getGame());
            }
            getGame().checkCardEnd();
            return this;
        }

        if (card == "Resting") {
            return new AwaitRest(getGame());
        }
        if (card == "Merchant") {
            return new AwaitTrading(getGame());
        }
        if (card == "Monster") {
            getGame().getDice().roll();
            int rollDice = getGame().getDice().getRoll();
            getGame().setCard(new Monster(getGame().getLevel(), getGame().getArena(), rollDice));
            return new AwaitDiceRoll(getGame());
        }
        if (card == "Boss Monster") {
            getGame().setCard(new Monster(getGame().getLevel()));
            return new AwaitDiceRoll(getGame());
        }
        return this;
    }
}

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
            game.getDice().roll();
            int roll = game.getDice().getRoll();
            game.getDice().roll();
            game.setUiText(game.getDungeon().Card(game.getArena(), game.getLevel(), game.getCardPosition()).toString());
            game.setUiText(game.getUiText() + "\nPrimeiro Dado: " + roll);
            int roll2 = game.getDice().getRoll();
            game.setUiText(game.getUiText() + "\n");
            game.setUiText(game.getUiText() + "Segundo Dado: " + roll2);
            game.setUiText(game.getUiText() + "\n");
            Player p = game.getPlayer();
            if (!game.skillCheck(roll2)) {
                switch (roll) {
                    case 1:
                        if (p.getFood() == 0) {
                            game.setUiText(game.getUiText() + "Ja nao tem comida para perder");
                        } else {
                            p.setFood(p.getFood() - 1);
                            game.setUiText(game.getUiText() + "Perdeu 1 de Food");
                        }
                        break;
                    case 2:
                        if (p.getGold() == 0) {
                            game.setUiText(game.getUiText() + "Ja nao tem gold para perder");
                        } else {
                            p.setGold(p.getGold() - 1);
                            game.setUiText(game.getUiText() + "Perdeu 1 de Gold");
                        }

                        break;
                    case 3:
                        if (p.getArmor() == 0) {
                            game.setUiText(game.getUiText() + "Ja nao tem armor para perder");
                        } else {
                            p.setArmor(p.getArmor() - 1);
                            game.setUiText(game.getUiText() + "Perdeu 1 de Armor");
                        }

                        break;
                    case 4:
                        if (p.getHp() == 0) {
                            game.setUiText(game.getUiText() + "Ja nao tem hp para perder");
                        } else {
                            p.setHp(p.getHp() - 1);
                            if (game.isDead()) {
                                game.setUiText(game.getUiText() + "Perdeu 1 de Hp \n Nao tem mais Hp e perdeu o Jogo");
                                return new AwaitBeginning(game);
                            }
                            game.setUiText(game.getUiText() + "Perdeu 1 de Hp");
                        }
                        break;
                    case 5:
                        if (p.getXp() == 0 && p.getRank() == 1) {
                            game.setUiText(game.getUiText() + "Ja nao tem xp para perder");
                        } else {

                            p.setXp(p.getXp() - 1);
                            game.checkLevelDown();
                            game.setUiText(game.getUiText() + "Perdeu 1 de Xp");
                        }
                        break;
                    case 6:
                        p.setHp(p.getHp() - 2);
                        if (game.getLevel() == 5) {
                            game.setUiText(game.getUiText() + "Perdeu 2 de Hp");
                            break;
                        }
                        game.setArenaBellow(game.getArena());
                        game.setUiText(game.getUiText() + "Perdeu 2 de HP e foi movido para a arena " + game.getArena());
                        break;

                }
            }
            game.checkCardEnd();
            return this;
        }
        if (card == "Treasure") {
            game.getDice().roll();
            int roll = game.getDice().getRoll();
            game.getDice().roll();
            game.setUiText(game.getDungeon().Card(game.getArena(), game.getLevel(), game.getCardPosition()).toString());
            game.setUiText(game.getUiText() + "\nPrimeiro Dado: " + roll);
            int roll2 = game.getDice().getRoll();
            game.setUiText(game.getUiText() + "\n");
            game.setUiText(game.getUiText() + "Segundo Dado: " + roll2);
            game.setUiText(game.getUiText() + "\n");
            Player p = game.getPlayer();
            if (game.isFight()) {
                game.setUiText(game.getUiText() + "Ganhou 2 de Gold");
                p.setGold(p.getGold() + 2);
            } else {
                game.setUiText(game.getUiText() + "Ganhou 1 de Gold");
                p.setGold(p.getGold() + 1);
            }
            if (roll >= 5) {
                switch (roll2) {
                    case 1:
                        p.setArmor(p.getArmor() + 1);
                        game.setUiText(game.getUiText() + " e Ganhou 1 de Armor");
                        break;
                    case 2:
                        p.setXp(p.getXp() + 2);
                        game.setUiText(game.getUiText() + " e Ganhou 2 de Xp");
                        if (game.checkLevelUp()) {
                            game.setUiText(game.getUiText() + "\n||=== Evoluiu para o Rank " + game.getPlayer().getRank() + "===||");
                        }
                        break;
                    case 3:
                        if (p.spells.size() == 2) {
                            game.removesSpell();
                        }
                        game.setUiText(game.getUiText() + " e Ganhou 1 Spell FireBall");
                        p.spells.add(new Fireball());
                        break;
                    case 4:
                        if (p.spells.size() == 2) {
                            game.removesSpell();
                        }
                        game.setUiText(game.getUiText() + " e Ganhou 1 Spell Ice");
                        p.spells.add(new Ice());
                        break;
                    case 5:
                        if (p.spells.size() == 2) {
                            game.removesSpell();
                        }
                        game.setUiText(game.getUiText() + " e Ganhou 1 Spell Poison");
                        p.spells.add(new Poison());
                        break;
                    case 6:
                        if (p.spells.size() == 2) {
                            game.removesSpell();
                        }
                        game.setUiText(game.getUiText() + " e Ganhou 1 Spell Healing");
                        p.spells.add(new Healing());
                        break;
                }
            }
            game.checkCardEnd();
            return this;
        }

        if (card == "Event") {
            game.getDice().roll();
            int roll = game.getDice().getRoll();
            game.setUiText(game.getDungeon().Card(game.getArena(), game.getLevel(), game.getCardPosition()).toString());
            game.setUiText(game.getUiText() + "\nPrimeiro Dado: " + roll);
            game.setUiText(game.getUiText() + "\n");
            Player p = game.getPlayer();
            switch (roll) {
                case 1:
                    p.setFood(p.getFood() + 1);
                    game.setUiText(game.getUiText() + "Ganhou 1 de Food");
                    break;
                case 2:
                    p.setHp(p.getHp() + 2);
                    game.setUiText(game.getUiText() + "Ganhou 2 de Hp");
                    break;
                case 3:
                    p.setGold(p.getGold() + 2);
                    game.setUiText(game.getUiText() + "Ganhou 2 de Gold");
                    break;
                case 4:
                    p.setXp(p.getXp() + 2);
                    game.setUiText(game.getUiText() + "Ganhou 2 de Xp");
                    if (game.checkLevelUp()) {
                        game.setUiText(game.getUiText() + "\n||=== Evoluiu para o Rank " + game.getPlayer().getRank() + "===||");
                    }
                    break;
                case 5:
                    p.setArmor(p.getArmor() + 1);
                    game.setUiText(game.getUiText() + "Ganhou 1 de Armor");
                    break;
                case 6:
                    game.setUiText(game.getUiText() + "Fase de Combate");
                    game.getDice().roll();
                    int rollDice = game.getDice().getRoll();
                    game.setCard(new Monster(game.getLevel(), game.getArena(), rollDice, true));
                    return new AwaitDiceRoll(game);
            }
            game.checkCardEnd();
            return this;
        }

        if (card == "Resting") {
            return new AwaitRest(game);
        }
        if (card == "Merchant") {
            return new AwaitTrading(game);
        }
        if (card == "Monster") {
            game.getDice().roll();
            int rollDice = game.getDice().getRoll();
            game.setCard(new Monster(game.getLevel(), game.getArena(), rollDice));
            return new AwaitDiceRoll(game);
        }
        if (card == "Boss Monster") {
            game.setCard(new Monster(game.getLevel()));
            return new AwaitDiceRoll(game);
        }
        return this;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic.States;

import MR_Game_Logic.Cards.Monster;
import MR_Game_Logic.GameData;
import MR_Game_Logic.Spell.*;
import MR_Game_Logic.Spells;
import java.util.List;

/**
 *
 * @author Nuno
 */
public class AwaitSpellOption extends StateAdapter {

    public AwaitSpellOption(GameData g) {
        super(g);
    }

    @Override
    public IStates setSpellOption(int option) {
        List<Spells> spells = getGame().getPlayer().getSpells();
        if (option <= spells.size()) {
            String spellName = getGame().getPlayer().getSpells().get(option).getName();
            int playerDmg = getGame().getPlayer().getDmg();
            int monsterHp = ((Monster) getGame().getCard()).getHp();
            if (!getGame().getPlayer().getSpells().isEmpty()) {
                switch (spellName) {
                    case "Fireball":
                        ((Fireball) getGame().getPlayer().getSpells().get(option)).effect(getGame());
                        getGame().getPlayer().removeSpell(spellName);
                        break;
                    case "Healing":
                        ((Healing) getGame().getPlayer().getSpells().get(option)).effect(getGame());
                        getGame().getPlayer().removeSpell(spellName);
                        break;
                    case "Ice":
                        if (playerDmg >= monsterHp) {
                            getGame().getPlayer().setDmg(0);
                            getGame().setUiText("Matou o monstro");
                            getGame().getPlayer().setXp(getGame().getPlayer().getXp() + ((Monster) getGame().getCard()).getReward());
                            if (getGame().checkLevelUp()) {
                                getGame().setUiText(getGame().getUiText() + "\n||=== Evoluiu para o Rank " + getGame().getPlayer().getRank() + "===||");
                            }
                            getGame().checkCardEnd();
                            return new AwaitCardSelection(getGame());
                        }
                        ((Monster) getGame().getCard()).setHp(monsterHp - playerDmg);
                        getGame().getPlayer().removeSpell(spellName);
                        return new AwaitDiceRoll(getGame());
                    case "Poison":
                        ((Poison) getGame().getPlayer().getSpells().get(option)).effect(getGame());
                        getGame().getPlayer().removeSpell(spellName);
                        break;

                }
            }
        } else {
            getGame().setUiText("Spell invalido");
            return this;
        }

        return this;
    }

    @Override
    public IStates attack() {
        int playerDmg = getGame().getPlayer().getDmg();
        int monsterHp = ((Monster) getGame().getCard()).getHp();
        int monsterDmg = ((Monster) getGame().getCard()).getDmg();
        int playerHealth = getGame().getPlayer().getHp() + getGame().getPlayer().getArmor();
        if (playerDmg >= monsterHp) {
            getGame().getPlayer().setDmg(0);
            getGame().setUiText("Matou o monstro");
            getGame().getPlayer().setXp(getGame().getPlayer().getXp() + ((Monster) getGame().getCard()).getReward());
            if (getGame().checkLevelUp()) {
                getGame().setUiText(getGame().getUiText() + "\n||=== Evoluiu para o Rank " + getGame().getPlayer().getRank() + "===||");
            }
            getGame().checkCardEnd();
            return new AwaitCardSelection(getGame());
        } else {
            getGame().getPlayer().setHp(playerHealth - monsterDmg);
            if (monsterDmg >= getGame().getPlayer().getArmor()) {
                getGame().getPlayer().setArmor(0);
            }
            if (getGame().isDead()) {
                getGame().setUiText("Morreu e perdeu o jogo");
                return new AwaitBeginning(getGame());
            }
            ((Monster) getGame().getCard()).setHp(monsterHp - playerDmg);
            getGame().getPlayer().setDmg(0);
            return new AwaitDiceRoll(getGame());
        }

    }
}

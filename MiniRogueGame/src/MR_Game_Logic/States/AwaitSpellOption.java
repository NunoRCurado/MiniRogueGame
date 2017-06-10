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
    public IStates setSpellOption(int option) { // 1-> Fireball  2-> Healing  3->Ice  4->poison
        List<Spells> spells = game.getPlayer().getSpells();
        switch(option){
            case 1 :
                option = game.getPlayer().findSpellState("Fireball");
                break;
            case 2:
                option = game.getPlayer().findSpellState("Healing");
                break;
            case 3:
                option = game.getPlayer().findSpellState("Ice");
                break;
            case 4:
                option = game.getPlayer().findSpellState("Poison");
                break;
        }
        if (option <= spells.size()) {
            String spellName = game.getPlayer().getSpells().get(option).getName();
            int playerDmg = game.getPlayer().getDmg();
            int monsterHp = ((Monster) game.getCard()).getHp();
            if (!game.getPlayer().getSpells().isEmpty()) {
                switch (spellName) {
                    case "Fireball":
                        ((Fireball) game.getPlayer().getSpells().get(option)).effect(game);
                        game.getPlayer().removeSpell(spellName);
                        break;
                    case "Healing":
                        ((Healing) game.getPlayer().getSpells().get(option)).effect(game);
                        game.getPlayer().removeSpell(spellName);
                        break;
                    case "Ice":
                        if (playerDmg >= monsterHp) {
                            game.getPlayer().setDmg(0);
                            game.getPlayer().setPoison(false);
                            game.setUiText("Matou o monstro");
                            game.getPlayer().setXp(game.getPlayer().getXp() + ((Monster) game.getCard()).getReward());
                            if (game.checkLevelUp()) {
                                game.setUiText(game.getUiText() + "\n||=== Evoluiu para o Rank " + game.getPlayer().getRank() + "===||");
                            }
                            game.checkCardEnd();
                            return new AwaitCardSelection(game);
                        }
                        ((Monster) game.getCard()).setHp(monsterHp - playerDmg);
                        game.getPlayer().removeSpell(spellName);
                        return new AwaitDiceRoll(game);
                    case "Poison":
                        ((Poison) game.getPlayer().getSpells().get(option)).effect(game);
                        game.getPlayer().removeSpell(spellName);
                        break;

                }
            }
        } else {
            game.setUiText("Spell invalido");
            return this;
        }

        return this;
    }

    @Override
    public IStates attack() {
        int playerDmg = game.getPlayer().getDmg();
        int monsterHp = ((Monster) game.getCard()).getHp();
        int monsterDmg = ((Monster) game.getCard()).getDmg();
        int playerHealth = game.getPlayer().getHp() + game.getPlayer().getArmor();
        if (playerDmg >= monsterHp) {
            game.getPlayer().setDmg(0);
            game.getPlayer().setPoison(false);
            game.setUiText("Matou o monstro");
            game.getPlayer().setXp(game.getPlayer().getXp() + ((Monster) game.getCard()).getReward());
            if (game.checkLevelUp()) {
                game.setUiText(game.getUiText() + "\n||=== Evoluiu para o Rank " + game.getPlayer().getRank() + "===||");
            }
            game.checkCardEnd();
            return new AwaitCardSelection(game);
        } else {
            game.getPlayer().setHp(playerHealth - monsterDmg);
            if (monsterDmg >= game.getPlayer().getArmor()) {
                game.getPlayer().setArmor(0);
            }
            if (game.isDead()) {
                game.setUiText("Morreu e perdeu o jogo");
                return new AwaitBeginning(game);
            }
            ((Monster) game.getCard()).setHp(monsterHp - playerDmg);
            game.getPlayer().setDmg(0);
            return new AwaitDiceRoll(game);
        }

    }
}

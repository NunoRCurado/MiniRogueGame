/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic.States;

import MR_Game_Logic.*;
import MR_Game_Logic.Spell.*;
import java.util.List;

/**
 *
 * @author pedri
 */
public class AwaitTrading extends StateAdapter implements Constants {

    public AwaitTrading(GameData g) {
        super(g);
    }

    @Override
    public IStates skip() {
        getGame().checkCardEnd();
        return new AwaitCardSelection(getGame());

    }

    @Override
    public IStates sellOption(int option) {
        Player p = getGame().getPlayer();
        int pArmor = p.getArmor();
        int pGold = p.getGold();
        List<Spells> pSpell = p.getSpells();
        if (option == 1) {
            if (pArmor <= 0) {
                getGame().setUiText("Nao tem armor");
                return this;
            }
            getGame().setUiText("Vendeu 1 Armor e ganhou 3 de Gold");
            p.setGold(pGold + 3);
            p.setArmor(pArmor - 1);
        }
        if (option == 2) {//fire
            if (pSpell.isEmpty()) {
                getGame().setUiText("Nao tem spells para vender");
                return this;
            }
            if(getGame().getPlayer().findSpell("fire")){
                getGame().getPlayer().removeSpell("fire");
                getGame().setUiText("Vendeu o spell Fireball");
            }
            else{
                getGame().setUiText("Nao tem este spell");
            }
        }
        if (option == 3) {//ice
            if (pSpell.isEmpty()) {
                getGame().setUiText("Nao tem spells para vender");
                return this;
            }
            if(getGame().getPlayer().findSpell("ice")){
                getGame().getPlayer().removeSpell("ice");
                getGame().setUiText("Vendeu o spell Ice");
            }
            else{
                getGame().setUiText("Nao tem este spell");
            }
        }
        if (option == 4) {//poison
            if (pSpell.isEmpty()) {
                getGame().setUiText("Nao tem spells para vender");
                return this;
            }
            if(getGame().getPlayer().findSpell("poison")){
                getGame().getPlayer().removeSpell("poison");
                getGame().setUiText("Vendeu o spell Poison");
            }
            else{
                getGame().setUiText("Nao tem este spell");
            }
        }
        if (option == 5) {//heal
            if (pSpell.isEmpty()) {
                getGame().setUiText("Nao tem spells para vender");
                return this;
            }
            if(getGame().getPlayer().findSpell("healing")){
                getGame().getPlayer().removeSpell("healing");
                getGame().setUiText("Vendeu o spell Healing");
            }
            else{
                getGame().setUiText("Nao tem este spell");
            }
        }
        return this;
    }


    @Override
    public IStates buyOption(int option) {
        Player p = getGame().getPlayer();
        int pFood = p.getFood();
        int pHealth = p.getHp();
        int pArmor = p.getArmor();
        int pGold = p.getGold();
        List<Spells> pSpell = p.getSpells();
        switch (option) {
            case 1:
                if (pGold < 1) {
                    getGame().setUiText("Nao tem Gold suficiente");
                    break;
                }
                p.setGold(pGold - 1);
                p.setFood(pFood + 1);
                break;
            case 2:
                if (pGold < 1) {
                    getGame().setUiText("Nao tem Gold suficiente");
                    break;
                }
                p.setGold(pGold - 1);
                p.setHp(pHealth + 1);
                break;
            case 3:
                if (pGold < 3) {
                    getGame().setUiText("Nao tem Gold suficiente");
                    break;
                }
                p.setGold(pGold - 3);
                p.setHp(pHealth + 4);
                break;
            case 4:
                if (pGold < 6) {
                    getGame().setUiText("Nao tem Gold suficiente");
                    break;
                }
                p.setGold(pGold - 6);
                p.setArmor(pArmor + 1);
                break;
            case 5://fire
                if (pGold < 8) {
                    getGame().setUiText("Nao tem Gold suficiente");
                    break;
                }
                p.setGold(pGold - 8);
                if (pSpell.size() == 2) {
                    pSpell.remove(0);
                }
                pSpell.add(new Fireball());
                break;
            case 6://ice
                if (pGold < 8) {
                    getGame().setUiText("Nao tem Gold suficiente");
                    break;
                }
                p.setGold(pGold - 8);
                if (pSpell.size() == 2) {
                    pSpell.remove(0);
                }
                pSpell.add(new Ice());
                break;
            case 7://poison
                if (pGold < 8) {
                    getGame().setUiText("Nao tem Gold suficiente");
                    break;
                }
                p.setGold(pGold - 8);
                if (pSpell.size() == 2) {
                    pSpell.remove(0);
                }
                pSpell.add(new Poison());
                break;
            case 8://Heal
                if (pGold < 8) {
                    getGame().setUiText("Nao tem Gold suficiente");
                    break;
                }
                p.setGold(pGold - 8);
                if (pSpell.size() == 2) {
                    pSpell.remove(0);
                }
                pSpell.add(new Healing());
                break;
        }
        return this;
    }

}

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
            if(getGame().getPlayer().findSpell("fireball")){
                getGame().getPlayer().removeSpell("fireball");
                p.setGold(pGold + 4);
                getGame().setUiText("Vendeu o spell Fireball e ganhou 4 de Gold");
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
                p.setGold(pGold + 4);
                getGame().setUiText("Vendeu o spell Ice e ganhou 4 de Gold");
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
                p.setGold(pGold + 4);
                getGame().setUiText("Vendeu o spell Poison e ganhou 4 de Gold");
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
                p.setGold(pGold + 4);
                getGame().setUiText("Vendeu o spell Healing e ganhou 4 de Gold");
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
                getGame().setUiText("Comprou Ration e ganhou 1 de Food");
                p.setGold(pGold - 1);
                p.setFood(pFood + 1);
                break;
            case 2:
                if (pGold < 1) {
                    getGame().setUiText("Nao tem Gold suficiente");
                    break;
                }
                getGame().setUiText("Comprou Health Potion e ganhou 1 de Hp");
                p.setGold(pGold - 1);
                p.setHp(pHealth + 1);
                break;
            case 3:
                if (pGold < 3) {
                    getGame().setUiText("Nao tem Gold suficiente");
                    break;
                }
                getGame().setUiText("Comprou Big Health Potion e ganhou 4 de Hp");
                p.setGold(pGold - 3);
                p.setHp(pHealth + 4);
                break;
            case 4:
                if (pGold < 6) {
                    getGame().setUiText("Nao tem Gold suficiente");
                    break;
                }
                getGame().setUiText("Comprou Armor Piece e ganhou 1 de Armor");
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
                getGame().setUiText("Comprou Fireball Spell");
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
                getGame().setUiText("Comprou Ice Spell");
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
                getGame().setUiText("Comprou Poison Spell");
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
                getGame().setUiText("Comprou Healing Spell");
                pSpell.add(new Healing());
                break;
        }
        return this;
    }

}

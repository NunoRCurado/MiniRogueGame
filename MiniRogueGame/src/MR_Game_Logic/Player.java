/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author pedri
 */
public class Player implements Constants, Serializable{
    public int hp;
    public int gold;
    public int food;
    public int armor;
    public List<Spells> spells;
    public int rank;
    public int xp;
    public String name;
    public int dmg;
    public List<Dice> dices;
    public String dicesString;
    public boolean poison = false;
    
    public Player(){
        
    }
    
    public Player(int difficulty, String name){
        switch(difficulty){
            case NORMAL:
                this.name = name;
                this.hp = 5;
                this.armor = 0;
                this.gold = 3;
                this.food = 6;
                this.rank = 1;
                this.xp = 0;
                this.spells = new ArrayList<>();
                this.dices = new ArrayList<>();
                this.dices.add(new Dice());
                this.dmg = 0;
                break;
            case HARD:
                this.name = name;
                this.hp = 4;
                this.armor = 0;
                this.gold = 2;
                this.food = 5;
                this.rank = 1;
                this.xp = 0;
                this.spells = new ArrayList<>();
                this.dices = new ArrayList<>();
                this.dices.add(new Dice());
                this.dmg = 0;
                break;
            case IMPOSSIBLE:
                this.name = name;
                this.hp = 3;
                this.armor = 0;
                this.gold = 1;
                this.food = 3;
                this.rank = 1;
                this.xp = 0;
                this.dices = new ArrayList<>();
                this.dices.add(new Dice());
                this.spells = new ArrayList<>();
                this.dmg = 0;
                break;
            default: //CASUAL
                this.name = name;
                this.hp = 5;
                this.armor = 1;
                this.gold = 5 + 10;
                this.food = 6;
                this.rank = 1;
                this.xp = 0;
                this.dices = new ArrayList<>();
                this.dices.add(new Dice());
                this.spells = new ArrayList<>();
                this.dmg = 0;
                break;
        }
    }
    
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public List<Spells> getSpells() {
        return spells;
    }

    public void setSpells(List<Spells> spells) {
        this.spells = spells;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public List<Dice> getDices() {
        return dices;
    }

    public void setDices(List<Dice> dices) {
        this.dices = dices;
    }
    
    public Boolean findSpell(String spellName) {
        for (int i = 0; i < this.spells.size(); i++) {
            if (this.spells.get(i).getName().equalsIgnoreCase(spellName)) {
                return true;
            }
        }
        return false;
    }
    
    public int findSpellState(String spellName) {
        for (int i = 0; i < this.spells.size(); i++) {
            if (this.spells.get(i).getName().equalsIgnoreCase(spellName)) {
                return i;
            }
        }
        return -1;
    }
    
    public void removeSpell(String spellName){
         for (int i = 0; i < this.spells.size(); i++) {
            if (this.spells.get(i).getName().equalsIgnoreCase(spellName)) {
                this.spells.remove(i);
            }
        }
    }
    
    public int findSpellState(String spellName) {
        for (int i = 0; i < this.spells.size(); i++) {
            if (this.spells.get(i).getName().equalsIgnoreCase(spellName)) {
                return i;
            }
        }
        return -1;
    }
    
    public String playerToString(){
       
        String stats ="";
        stats = "NAME " + name + " | HP " + hp + " | GOLD " + gold + " | FOOD " + food + " | ARMOR " + armor + " | RANK " + rank + " | XP " 
                + xp;
        if(spells.isEmpty()){
            stats = stats + " | Spells : Nao tem nenhum spell";
        }else{
            if(spells.size() == 1)
                stats = stats + " | Spells: " + spells.get(0).getName();
            if(spells.size() == 2)
                stats = stats + " | Spells: " + spells.get(0).getName() + " , " + spells.get(1).getName();
        }
        return stats;
    }
    
    public String dicesToString(){
       
        String dices ="Dices : ";
        for (int i = 0; i < this.dices.size(); i++) {
            dices += this.dices.get(i).getRoll() + " ";
        }
        return dices;
    }
    
    public String featDicesToString(){
       
        String dices ="Valid Dices : \n";
        for (int i = 0; i < this.dices.size(); i++) {
            if(!this.dices.get(i).getStatus())
                dices += i + 1 +" -> " + this.dices.get(i).getRoll() + "\n";
        }
        return dices;
    }
    
    public String critDicesToString(){
       
        String dices ="Valid Dices : \n";
        for (int i = 0; i < this.dices.size(); i++) {
            if(this.dices.get(i).roll == 6)
                dices += i + 1 +" -> " + this.dices.get(i).getRoll() + "\n";
        }
        return dices;
    }
    
    public String validSpellsToString(){
       String stats = "";
        if(spells.isEmpty()){
            stats = stats + "Valid Spells : Nao tem nenhum spell";
        }else{
            if(spells.size() == 1)
                stats = stats + "Valid Spells: 1 -> " + spells.get(0).getName();
            if(spells.size() == 2)
                stats = stats + "Valid Spells: 1-> " + spells.get(0).getName() + " \n 2->" + spells.get(1).getName();
        }
        return stats;
    }

    public boolean isPoison() {
        return poison;
    }

    public void setPoison(boolean poison) {
        this.poison = poison;
    }
    
    
}

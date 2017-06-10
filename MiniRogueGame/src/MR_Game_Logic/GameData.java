/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic;

import MR_Game_Logic.Cards.*;
import static MR_Game_Logic.Constants.CASUAL;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.HashMap;
import static MR_Game_Logic.Constants.DEFAULTDICE;

/**
 *
 * @author pedri
 */
public class GameData implements Serializable{
    private Player player;
    private Dungeon dungeon;
    private int level;
    private int arena;
    private int numDices;
    private int difficulty;
    private Dice dice;
    private boolean fight;
    private int cardPosition;
    private String uiText;
    private String currentCard;
    private int column;
    private String playerStats;
    private Card card;
    private boolean crit = false;
    
    public GameData(){
        dice = new Dice();
        dungeon = new Dungeon();
        player = new Player();
        arena = 1;
        difficulty = CASUAL;
    }
    
    public boolean initialize(){
        level = 1;
        numDices = 1;
        arena = 1;
        cardPosition = 0;
        fight = false;
        column = 1;
        dungeon.createDungeon();
        player = new Player(difficulty, player.getName());
        currentCard = getDungeon().currentCard(arena, level, cardPosition);
        card = getDungeon().Card(arena, level, cardPosition);
        uiText = "";
        return true;
    }
    
    public boolean initializeOnArea(int area){
        arena = area;
        cardPosition = 0;
        setLevelByArena(area);
        numDices = 1;
        fight = false;
        column = 1;
        dungeon.createDungeon();
        currentCard = getDungeon().currentCard(arena, level, cardPosition);
        card = getDungeon().Card(arena, level, cardPosition);
        player = new Player(difficulty, player.getName());
        uiText = "";
        return true;
    }
    
    public boolean checkLevelUp(){
        if(player.getXp() >= 7 && player.getRank() == 1){
            player.setXp(player.getXp() - 6);
            player.setRank(2);
            player.dices.add(new Dice());
            numDices = 2;
            return true;
        }
        if(player.getXp() >= 13 && player.getRank() == 2){
            player.setXp(player.getXp() - 12);
            player.setRank(3);
            player.dices.add(new Dice());
            numDices = 3;
            return true;
        }
        if(player.getXp() >= 19 && player.getRank() == 3){
            player.setXp(player.getXp() - 18);
            player.setRank(4);
            player.dices.add(new Dice());
            numDices = 4;
            return true;
        }
        if(player.getRank()== 4){
            player.setHp(player.getHp() + 1);
            return true;
        }
        return false;
    }
    
    public void checkLevelDown(){
        if(player.getXp() <= 6 && player.getRank() > 1)
            player.setRank(1);
        if(player.getXp() <= 12 && player.getRank() > 2)
            player.setRank(2);
        if(player.getXp() <= 18 && player.getRank() > 3)
            player.setRank(3);
    }
    
    public String dungeonToString(){
        String dungeon="";
        dungeon = "LEVEL " + level + "|ARENA " + arena + "|Coluna " + column;
        return dungeon;
    }
    
    public boolean isDead(){
        if(player.getHp() <= 0){
            return true;
        }
        return false;
    }
    
    public boolean skillCheck(int dice){
        if(dice <= player.getRank()){
            return true;
        }
        return false;
    }

    public boolean isCrit() {
        return crit;
    }

    public void setCrit(boolean crit) {
        this.crit = crit;
    }
    
    public boolean checkCrits(){
        for (int i = 0; i < player.dices.size(); i++) {
            if(player.dices.get(i).getStatus())
                return true;
        }
        return false;
    }
    
    public boolean checkFeats(int value){
        return player.dices.get(value - 1).getStatus(); 
    }
    
    public boolean checkValidDice(int num){
        if(num - 1 > player.dices.size()){
            return false;
        }
        else
            return true;
    }
    
    public void checkCardEndArenaGrafic(){
        if (player.getFood() == 0) {
            player.setHp(player.getHp() - 2);
        } else {
            player.setFood(player.getFood() - 1);
        }
        setArena(getArena() + 1);
    }
    
    public void checkCardEndMonsterGrafic(){
        if (player.getFood() == 0) {
            player.setHp(player.getHp() - 2);
        } else {
            player.setFood(player.getFood() - 1);
        }
        setArena(getArena() + 1);
        setLevel(getLevel() + 1);
    }
    
    public void checkCardEnd() {
        if (column == 2) {
            if(cardPosition == 1)
                setCardPosition(getCardPosition() + 2);
            else
                setCardPosition(getCardPosition() + 1);
            setColumn(getColumn() + 1);
            return;
        }
        if (column == 4 && arena == 2 || column == 4 && arena == 4 ||column == 4 && arena == 7 ||column == 4 && arena == 10 ||column == 4 && arena == 14) {
            //falta boss-monster
            setColumn(getColumn() + 1);
             if(cardPosition == 4)
                setCardPosition(getCardPosition() + 2);
            else
                setCardPosition(getCardPosition() + 1);
            return;
        }
        if (column == 4){
            if (player.getFood() == 0) {
                player.setHp(player.getHp() - 2);
            } else {
                player.setFood(player.getFood() - 1);
            }
            setArena(getArena() + 1);
            setCardPosition(0);
            setColumn(1);
            return;
        }
        if (column == 5){
            if (player.getFood() == 0) {
                player.setHp(player.getHp() - 2);
            } else {
                player.setFood(player.getFood() - 1);
            }
            setArena(getArena() + 1);
            setCardPosition(0);
            setColumn(1);
            setLevel(getLevel() + 1);
            return;
        }
        
        setCardPosition(getCardPosition() + 1);
        setColumn(getColumn() + 1);
    }
    
    public void removesSpell(){
        int rand = (int)(Math.random() * 2 + 1);
        List<Spells> spells = player.getSpells();
        if(rand == 1){
            spells.remove(0);
        }else 
            spells.remove(1);
        player.setSpells(spells);
    }
    
    public void setArenaBellow(int area){
        switch(area){
            case 1:
                setArena(3);
                setLevel(2);
                setCardPosition(0);
                setColumn(1);
                break;
            case 2:
                setArena(4);
                setLevel(2);
                setCardPosition(0);
                setColumn(1);
                break;
            case 3:
                setArena(5);
                setLevel(3);
                setCardPosition(0);
                setColumn(1);
                break;
            case 4:
                setLevel(3);
                setArena(6);
                setCardPosition(0);
                setColumn(1);
                break;
            case 5:
                setLevel(4);
                setArena(8);
                setCardPosition(0);
                setColumn(1);
                break;
            case 6:
                setArena(9);
                setLevel(4);
                setCardPosition(0);
                setColumn(1);
                break;
            case 7:
                setArena(10);
                setLevel(4);
                setCardPosition(0);
                setColumn(1);
                break;
            case 8:
                setArena(11);
                setLevel(5);
                setCardPosition(0);
                setColumn(1);
                break;
            case 9:
                setArena(12);
                setLevel(5);
                setCardPosition(0);
                setColumn(1);
                break;
            case 10:
                setArena(13);
                setLevel(5);
                setCardPosition(0);
                setColumn(1);
                break;
        }
    }
    
    public void setLevelByArena(int area){
        if(area >= 1 && area <= 2){
            setLevel(1);
        }
        if(area >= 3 && area <= 4){
            setLevel(2);
        }
        if(area >= 5 && area <= 7){
            setLevel(3);
        }
        if(area >= 8 && area <= 10){
            setLevel(4);
        }
        if(area >= 11 && area <= 14){
            setLevel(5);
        }
    }
    
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getArena() {
        return arena;
    }

    public void setArena(int arena) {
        this.arena = arena;
    }

    public int getNumDices() {
        return numDices;
    }

    public void setNumDices(int numDices) {
        this.numDices = numDices;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public int getCardPosition() {
        return cardPosition;
    }

    public void setCardPosition(int cardPosition) {
        this.cardPosition = cardPosition;
    }
    
    public boolean isFight() {
        return fight;
    }

    public void setFight(boolean fight) {
        this.fight = fight;
    }

    public String getUiText() {
        return uiText;
    }

    public void setUiText(String uiText) {
        this.uiText = uiText;
    }

    public String getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(String currentCard) {
        this.currentCard = currentCard;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
    
    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
    
    public String getPlayerStats() {
        return playerStats;
    }
    public void setPlayerStats(String playerStats) {
        this.playerStats = playerStats;
    }
    
    public boolean featHp(){
        if(player.getHp() > 2){
            player.setHp(player.getHp() - 2);
            return true;
        }
        else 
            return false;
    }
    
    public boolean featXp(){
        if(player.getXp() >= 1){
            player.setXp(player.getXp() - 1);
            return true;
        }
        else 
            return false;
    }

    public int monsterHp(){
        Card cardMonster = null;
        for(int i = 0; i < currentListArray().size() ; i++)
            if(currentListArray().get(i).getName().equals("Monster") || currentListArray().get(i).getName().equals("Boss Monster")){
                cardMonster = getDungeon().Card(arena, level, i);
                return ((Monster) cardMonster).getHp();
            }
        return 0;
    }
    
    public boolean hasFireball(){
        for(int i = 0 ; i < player.spells.size() ; i++){
            if(player.getSpells().get(i).getName().equals("Fireball")){
                return true;
            }
        }
        return false;
    }
    public boolean hasHealling(){
        for(int i = 0 ; i < player.spells.size() ; i++){
            if(player.spells.get(i).getName().equals("Healing")){
                return true;
            }
        }
        return false;
    }
    public boolean hasIce(){
        for(int i = 0 ; i < player.spells.size() ; i++){
            if(player.spells.get(i).getName().equals("Ice")){
                return true;
            }
        }
        return false;
    }
    public boolean hasPoison(){
        for(int i = 0 ; i < player.spells.size() ; i++){
            if(player.spells.get(i).getName().equals("Poison")){
                return true;
            }
        }
        return false;
    }
    
    public String validSpellsToString(){
        return player.validSpellsToString();
    }
    
    public List<Card> currentListArray(){
        return getDungeon().getcurrentCards(level, arena);
    }
}

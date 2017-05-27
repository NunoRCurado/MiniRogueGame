/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic;

import MR_Game_Logic.Card;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 *
 * @author pedri
 */
public class Dungeon implements Serializable{
    Card card;
    List<Card> cards;
    List<Card> cardsBoss;
    HashMap<Integer, List<Card>> level1;
    HashMap<Integer, List<Card>> level2;
    HashMap<Integer, List<Card>> level3;
    HashMap<Integer, List<Card>> level4;
    HashMap<Integer, List<Card>> level5;
    
    public Dungeon(){
        card = new Card();
        cards = new ArrayList<>();
        cardsBoss = new ArrayList<>();
        level1 = new HashMap<>();
        level2 = new HashMap<>();
        level3 = new HashMap<>();
        level4 = new HashMap<>();
        level5 = new HashMap<>();
    }
    
    public void createDungeon(){
        initiateNormalArea();
        initiateBossArea(1);
        level1.put(1, cards);
        level1.put(2, cardsBoss);
        initiateBossArea(2);
        level2.put(3, cards);
        level2.put(4, cardsBoss);
        initiateBossArea(3);
        level3.put(5, cards);
        level3.put(6, cards);
        level3.put(7, cardsBoss);
        initiateBossArea(4);
        level4.put(8, cards);
        level4.put(9, cards);
        level4.put(10, cardsBoss);
        initiateBossArea(5);
        level5.put(11, cards);
        level5.put(12, cards);
        level5.put(13, cards);
        level5.put(14, cardsBoss);        
    }
    
    public void initiateNormalArea(){
        cards = card.getCards();
    }
    
    public void initiateBossArea(int level){
        cardsBoss = card.getCardsBoss(level);
    }
    
    public String currentCard(int area, int level, int areaLevel){
        switch(level){
            case 1:
                return level1.get(area).get(areaLevel).getName();
            case 2:
                return level2.get(area).get(areaLevel).getName();
            case 3:
                return level3.get(area).get(areaLevel).getName();
            case 4:
                return level4.get(area).get(areaLevel).getName();
            case 5:
                return level5.get(area).get(areaLevel).getName();               
        }
        return null;
    }
    
    public Card Card(int area, int level, int areaLevel){
        switch(level){
            case 1:
                return level1.get(area).get(areaLevel);
            case 2:
                return level2.get(area).get(areaLevel);
            case 3:
                return level3.get(area).get(areaLevel);
            case 4:
                return level4.get(area).get(areaLevel);
            case 5:
                return level5.get(area).get(areaLevel);               
        }
        return null;
    }
    
    public int currentColumn(int areaLevel){
        if(areaLevel == 0)
            return 1;
        if(areaLevel == 1 || areaLevel == 2)
            return 2;
        if(areaLevel == 3)
            return 3;
        if(areaLevel == 4 || areaLevel == 5)
            return 4;
        if(areaLevel == 6)
            return 5;
        return 0;
    }
}

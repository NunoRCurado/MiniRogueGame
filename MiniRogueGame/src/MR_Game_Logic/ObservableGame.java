/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic;

import MR_Game_Logic.States.IStates;
import java.util.List;
import java.util.Observable;


/**
 *
 * @author Nuno
 */
public class ObservableGame extends Observable{
    MR_Game g;
    
    
    public ObservableGame(){
        g=new MR_Game();
        
    }
    
    public IStates getState(){
        return g.getState();
    }
    
   public int getLevel(){
       return g.getGameData().getLevel();
   }
   
    //Nivel no jogo
     public int getArena(){
      return g.getGameData().getArena();
   }
     
     //numero de cartas
   public int getArenaLevel(){
      return g.getGameData().getCardPosition();
   }
   
   //saber se mostra 1 ou duas cartas
   public int getColumn(){
       return g.getGameData().getColumn();
   }
   public int getHP(){
      return g.getGameData().getPlayer().getHp();
   }
   
    public int getArmor(){
      return g.getGameData().getPlayer().getArmor();
   }
    
     public int getDmg(){
      return g.getGameData().getPlayer().getDmg();
   }
     
      public int getFood(){
      return g.getGameData().getPlayer().getFood();
   }
      
      public List<Card> getCurrentDeck(){
         return g.getGameData().currentListArray();
     }
        
      public int getGold(){
      return g.getGameData().getPlayer().getGold();
   }
      
       public String getCurrentCard(){
        return g.getGameData().getDungeon().currentCard(g.getGameData().getArena(), g.getGameData().getLevel(), g.getGameData().getCardPosition()).toLowerCase();
     } 
       
       public Dungeon getDungeon() {
        return g.getGameData().getDungeon();
    }
        
      public int getRank(){
      return g.getGameData().getPlayer().getRank();
   }
      
        
      public int getXp(){
      return g.getGameData().getPlayer().getXp();
   }
      public boolean hasFire(){
      return g.getGameData().hasFireball();
   }
      
      public boolean hasIce(){
      return g.getGameData().hasIce();
   }
      public boolean hasPoison(){
      return g.getGameData().hasPoison();
   }
      public boolean hasHealling(){
      return g.getGameData().hasHealling();
   }
      public boolean featHp(){
      return g.getGameData().featHp();
   }
      public boolean featXp(){
      return g.getGameData().featXp();
   }
      public int monsterHp(){
      return g.getGameData().monsterHp();
   }
   
      public int getDifficulty(){
      return g.getGameData().getDifficulty();
   }
      
     
      
      public void startGame(){
          g.startGame();
          setChanged();
          notifyObservers();
      }
      
      //falta get lista dos spells ou hasSpell X
      //Falta ir getMonster HP
      //Load Game
     
      
      public void Skip(){
          g.skip();
          setChanged();
          notifyObservers();
      }
      
       public void endGame(){
          g.endGame();
          setChanged();
          notifyObservers();
      }
       public void nextArenaLevel(){
          g.nextArenaLevel();
          setChanged();
          notifyObservers();
      }
       
       public void setName(String name){
          g.nextArenaLevel();
          setChanged();
          notifyObservers();
      }
       
       public void setDifficulty(int difficulty){
          g.setDifficulty(difficulty);
          setChanged();
          notifyObservers();
      }
       public void setStartingArea(int area){
          g.setStartingArea(area);
          setChanged();
          notifyObservers();
      }
       public void setRestOption(int option){
          g.setRestOption(option);
          setChanged();
          notifyObservers();
      }
       
        public void setSpellOption(int option){
          g.setSpellOption(option);
          setChanged();
          notifyObservers();
      }
        
         public void sellOption(int option){
          g.sellOption(option);
          setChanged();
          notifyObservers();
      }
         public void buyOption(int option){
          g.buyOption(option);
          setChanged();
          notifyObservers();
      }
         public void resolveCard(String card){
          g.resolveCard(card);
          setChanged();
          notifyObservers();
      }
         
         public void rollDice(){
          g.rollDice();
          setChanged();
          notifyObservers();
      }
         public void checkAttack(){
          g.checkAttack();
          setChanged();
          notifyObservers();
      }
         public void critDices(int num, int option){
          g.critDices(num, option);
          setChanged();
          notifyObservers();
      }
         
         public void attack(){
          g.attack();
          setChanged();
          notifyObservers();
      }
         
          public void performFeat(int num, int option){
          g.performFeat(num, option);
          setChanged();
          notifyObservers();
      }
}


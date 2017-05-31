/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic;

import MR_Game_Logic.States.IStates;
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
      
        
      public int getGold(){
      return g.getGameData().getPlayer().getGold();
   }
      
        
      public int getRank(){
      return g.getGameData().getPlayer().getRank();
   }
      
        
      public int getXp(){
      return g.getGameData().getPlayer().getXp();
   }
      
     
      
      public void startGame(){
          g = new MR_Game();
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
         public void critDices(int num){
          g.critDices(num);
          setChanged();
          notifyObservers();
      }
         
         public void attack(){
          g.attack();
          setChanged();
          notifyObservers();
      }
}


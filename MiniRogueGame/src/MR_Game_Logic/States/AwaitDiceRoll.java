/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic.States;

import MR_Game_Logic.GameData;

/**
 *
 * @author Nuno
 */
public class AwaitDiceRoll extends StateAdapter {
    
    public AwaitDiceRoll(GameData g) {
        super(g);
    }
    
    @Override
    public IStates rollDice(){
       
       int roll;
       getGame().getPlayer().setDmg(0);
       for(int i = 1; i<= getGame().getPlayer().getRank(); i++){
          roll = 0;
          roll = getGame().getDice().getRoll();
          
          if(roll == 1){
              getGame().getPlayer().setDmg(getGame().getPlayer().getDmg() + 0);
              //discard dice
          }
          else if(roll == 6){
              getGame().getPlayer().setDmg(getGame().getPlayer().getDmg() + roll);
          }
          else{
              getGame().getPlayer().setDmg(getGame().getPlayer().getDmg() + roll);
          }
       }
        
        return new AwaitDiceOption(getGame());
    }
}

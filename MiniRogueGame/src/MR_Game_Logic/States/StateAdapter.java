/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic.States;

import MR_Game_Logic.GameData;
/**
 *
 * @author pedri
 */
public class StateAdapter implements IStates{

    GameData game;

    public StateAdapter(GameData g)
    {
        this.game = g;
    }

    public GameData getgame() 
    {
        return game;
    }
    
    public void setGame(GameData game) 
    {
        this.game = game;
    }
    
    @Override
    public IStates updatePlayer() {
        return this;
    }

    @Override
    public IStates setName(String name) {
        return this;
    }

    @Override
    public IStates setDifficulty(int difficulty) {
        return this;
    }

    @Override
    public IStates setStartingArea(int area) {
        return this;
    }

    @Override
    public IStates startGame() {
        return this;
    }

    @Override
    public IStates loadGame(GameData game){
        return this;
    }
    
    @Override
    public IStates setRestOption(int option) {
        return this;
    }

    @Override
    public IStates sellOption(int option) {
        return this;
    }

    @Override
    public IStates buyOption(int option) {
        return this;
    }

    @Override
    public IStates endGame() {
        return this;
    }

    @Override
    public IStates skip() {
        return this;
    }
    
    @Override
    public IStates resolveCard(String card){
        return this;
    }
  
       @Override
    public IStates rollDice() {
        return this;
    }

    @Override
    public IStates critDices(int num, int option){
        return this;
    }
    
    @Override
    public IStates checkAttack() {
        return this;
    }
    
    @Override
    public IStates setSpellOption(int option) {
        return this;
    }

    @Override
    public IStates spellSelected() {
        return this;
    }

    @Override
    public IStates attack() {
        return this;
    }
    
    @Override
     public IStates performFeat(int num, int option){
         return this;
     }
}

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
public class AwaitBeginning extends StateAdapter{

    public AwaitBeginning(GameData g) {
        super(g);
    }
    
    @Override
    public IStates setName(String name){
        game.getPlayer().setName(name);
        return this;
    }
    
    @Override
    public IStates setDifficulty(int difficulty){
        game.setDifficulty(difficulty);
        return this;
    }
    
    @Override
    public IStates setStartingArea(int area){
        game.setArena(area);
        game.setCardPosition(area);
        return this;
    }
    
    @Override
    public IStates startGame(){
        if(game.getArena() != 1){
            if(game.initializeOnArea(game.getArena()))
                return new AwaitCardSelection(game);
        }
        if(game.initialize())
            return new AwaitCardSelection(game);
        
        return this;
    }
    
    @Override
    public IStates loadGame(GameData gameData){
        game = gameData;
        return new AwaitCardSelection(game);
    }
    
}

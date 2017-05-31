package MR_Game_Logic;

import MR_Game_Logic.States.*;
import java.io.Serializable;

/**
 *
 * @author pedri
 */

public class MR_Game implements Serializable
{    
    private GameData gameData;
    private IStates state; 
    
    public MR_Game()
    {
        this.gameData = new GameData();
        setState(new AwaitBeginning(gameData));
    }

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData)
    {
        this.gameData = gameData;
    }

    public IStates getState()
    {
        return state;
    }
    
    private void setState(IStates state)
    {
        this.state = state;
    }        
    
     // Methods retrieve data from the game
                       

    public int getLevel()
    {
        return gameData.getLevel();
    }
    
    public int getArena()
    {
        return gameData.getArena();
    }
    
    public int getArenaLevel()
    {
        return gameData.getCardPosition();
    }
    
    public int getColumn()
    {
        return gameData.getColumn();
    }
    
    public Player getPlayer()
    {
        return gameData.getPlayer();
    }
    
    public String dungeonToString()
    {
        return gameData.dungeonToString();
    }
    
    public int getHP()
    {
        return gameData.getPlayer().getHp();
    }
 
    public Dungeon getDungeon() {
        return gameData.getDungeon();
    }

    public int getNumDices() {
        return gameData.getNumDices();
    }

    public int getDifficulty() {
        return gameData.getDifficulty();
    }

    public Dice getDice() {
        return gameData.getDice();
    }
    
    public String getUiText(){
        return gameData.getUiText();
    }
    
    public boolean isCrit(){
        return gameData.isCrit();
    }
    
    public boolean checkCrits(){
        return gameData.checkCrits();
    }
    
    public String getPlayerStats(){
       return gameData.getPlayer().playerToString();
    }
    
    public String getDicesString(){
       return gameData.getPlayer().dicesToString();
    }
    
    public String getFeatDicesString(){
       return gameData.getPlayer().featDicesToString();
    }
    
    public String getCritDicesString(){
       return gameData.getPlayer().critDicesToString();
    }
    
     public String getDungeonStats(){
       return gameData.dungeonToString();
     }
    
     public void setUiText(String clear){
         gameData.setUiText(clear);
     }
     
     public String cardToString(){
         return gameData.getCard().toString();
     }
     
     public boolean checkFeats(int num){
         return gameData.checkFeats(num);
     }
     
     public boolean checkValidDice(int num){
         return gameData.checkValidDice(num);
     }
     
     public boolean featXp(){
         return gameData.featXp();
     }
     
     public boolean featHp(){
         return gameData.featHp();
     }
     
     public int monsterHp(){
         return gameData.monsterHp();
     }
     
     public boolean hasFireball(){
         return gameData.hasFireball();
     }
     
     public boolean hasHealing(){
         return gameData.hasHealling();
     }
     
     public boolean hasIce(){
         return gameData.hasIce();
     }
     
     public boolean hasPoison(){
         return gameData.hasPoison();
     }
     
     public String getValidSpellsToString(){
         return gameData.validSpellsToString();
     }
     
    // Methods that are intended to be used by the user interfaces and that are delegated in the current state of the finite state machine 
    

    public void setName(String name) 
    {
        setState(getState().setName(name));
    }
    
     public void setDifficulty(int difficulty) 
    {
        setState(getState().setDifficulty(difficulty));
    }
    
    public void setStartingArea(int area){
        setState(getState().setStartingArea(area));
    }
    public void startGame(){
        setState(getState().startGame());
    }

    public void loadGame(){
        setState(getState().loadGame());
    }
    
    public void setRestOption(int option){
        setState(getState().setRestOption(option));
    }
    
     public void setSpellOption(int option){
        setState(getState().setSpellOption(option));
    }
   
    public void skip(){
        setState(getState().skip());
    }
    
    public void sellOption(int option){
        setState(getState().sellOption(option));
    }
    
    public void buyOption(int option){
        setState(getState().buyOption(option));
    }
    
    public void endGame(){
        setState(getState().endGame());
    }

    public void nextArenaLevel() {
          setState(getState().skip());
    }
    
    public void resolveCard(String card){
        setState(getState().resolveCard(card));
    }
    
    public void rollDice(){
        setState(getState().rollDice());
    }
    
    public void critDices(int num, int option){
        setState(getState().critDices(num, option));
    }
    
    public void checkAttack(){
        setState(getState().checkAttack());
    }
    
    public void attack(){
        setState(getState().attack());
    }
    
    public void performFeat(int num, int option){
        setState(getState().performFeat(num, option));
    }
}

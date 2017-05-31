/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic.States;

/**
 *
 * @author pedri
 */
public interface IStates {
    //All Phases
    public IStates updatePlayer();
    //AwaitBeginning
    public IStates setName(String name);
    public IStates setDifficulty(int difficulty);
    public IStates setStartingArea(int area);
    public IStates startGame();
    public IStates loadGame();
    //AwaitCardSelection
    public IStates resolveCard(String card);
    //AwaitRest
    public IStates setRestOption(int option);
    //AwaitTrading
    public IStates spellSelected();
    public IStates skip();
    public IStates sellOption(int option);
    public IStates buyOption(int option);

    //AwaitDiceOption
    public IStates checkAttack();
    public IStates rollDice();
    public IStates critDices(int num, int option);
    public IStates attack();
    public IStates setSpellOption(int option);
    public IStates endGame();
    public IStates performFeat(int num, int option);
}

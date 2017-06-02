package MR_Text_UI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pedri
 */
import MR_Game_Logic.Card;
import MR_Game_Logic.FileManager;
import MR_Game_Logic.MR_Game;
import MR_Game_Logic.States.AwaitBeginning;
import MR_Game_Logic.States.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class TextUI {

    private MR_Game game;
    private boolean quit = false;
    private FileManager fm;
    private boolean flag = false;
    

    public TextUI(MR_Game game) {
        this.game = game;
        fm = new FileManager();
    }

    public void uiAwaitFirstBeginning() {
        Scanner sc = new Scanner(System.in);
        String option;
        char c;
        String name;
        if (!flag) {
            while (true) {
                do {
                    System.out.println();
                    System.out.println("0 - Quit");
                    System.out.println("1 - Load Game");
                    System.out.println("2 - New Game");
                    System.out.print("\nYour option : ");
                    option = sc.next();

                    if (option.length() >= 1) {
                        c = option.charAt(0);
                    } else {
                        c = ' ';
                    }

                } while (c < '0' || c > '2');

                switch (c) {
                    case '0':
                        quit = true;
                        return;

                    case '1':
                        System.out.println("\nSave File Name: ");
                        name = sc.next();
                        MR_Game outro = fm.loadGame(name);
                        if (outro != null) {
                            game = outro;
                        }
                        return;
                    case '2':
                        flag = true;
                        uiAwaitSecondBeginning();
                    default:
                        return;

                } //switch

            } //while
        } else {
            uiAwaitSecondBeginning();
        }

    } //uiWaitBeginning

    public void uiAwaitSecondBeginning() {
        Scanner sc = new Scanner(System.in);
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String option;
        char c;
        int num;
        String name;

        while (true) {
            do {
                System.out.println();
                System.out.println("1 - Set difficulty");
                System.out.println("2 - Set the starting area");
                System.out.println("3 - Start");
                System.out.print("\nYour option : ");
                option = sc.next();

                if (option.length() >= 1) {
                    c = option.charAt(0);
                } else {
                    c = ' ';
                }

            } while (c < '1' || c > '3');

            switch (c) {
                case '1':
                    char o;
                    do {
                        System.out.println("Set difficulty: ");
                        System.out.println("1 - Casual ");
                        System.out.println("2 - Normal ");
                        System.out.println("3 - Hard ");
                        System.out.println("4 - Impossible ");
                        System.out.print("\nYour option : ");
                        num = sc.nextInt();

                    } while (num < 1 || num > 4);

                    switch (num) {
                        case 1:
                            System.out.print("Difficulty Casual");
                            game.setDifficulty(num);
                            break;
                        case 2:
                            System.out.print("Difficulty Normal");
                            game.setDifficulty(num);
                            break;
                        case 3:
                            System.out.print("Difficulty Hard");
                            game.setDifficulty(num);
                            break;
                        case 4:
                            System.out.print("Difficulty Impossible");
                            game.setDifficulty(num);
                            break;

                    }

                    return;
                case '2':
                    do {
                        System.out.println("Set starting area between 1 and 14: ");
                        System.out.print("\nYour option : ");
                        num = sc.nextInt();
                    } while (num < 1 || num > 14);

                    game.setStartingArea(num);
                    System.out.println("Starting area: " + num);
                    return;

                case '3':
                    System.out.print("Enter the name of the player : ");

                    try {
                        System.out.print("\nYour name : ");
                        name = bin.readLine();

                        game.getPlayer().setName(name);

                    } catch (IOException | NumberFormatException ex) {
                        System.out.println(ex);
                    }
                    System.out.println("Game started");
                    game.startGame();
                    return;

                default:
                    return;

            } //switch

        } //while

    } //uiWaitBeginning    

    public void uiAwaitSpellOption() {
        Scanner sc = new Scanner(System.in);
        int num, spell;
        int numSpells = game.getPlayer().getSpells().size();

        System.out.println(game.getUiText());

        if (numSpells == 0) {
            System.out.println("Nao tem spells para usar");
            game.attack();
        } else {
            do {
                System.out.println("Select Option: ");
                System.out.println("1 - Use spell ");
                System.out.println("2 - Don't Use Spell ");
                System.out.print("\nYour option : ");
                num = sc.nextInt();
            } while (num < 1 || num > 2);//Fazer igual ao feat
            if (num != 2) {
                do {
                    System.out.println(game.getValidSpellsToString());
                    System.out.print("\nYour option : ");
                    spell = sc.nextInt();
                } while (spell < 1 || spell > 2);
                game.setSpellOption(spell - 1);
            } else {
                game.attack();
            }
        }
    }

    public void uiAWaitCardSelection() {
        Scanner sc = new Scanner(System.in);
        int flipCard;
        int cardChoosed;
        String card2;
        String name;
        String card = game.getDungeon().currentCard(game.getArena(), game.getLevel(), game.getArenaLevel());
        int column = game.getColumn();
        System.out.println(game.getUiText());
        game.setUiText("");
        System.out.println(game.getPlayerStats());
        System.out.println("\nFlip next card ?");
        System.out.println("\n1 - Yes");
        System.out.println("\n2 - No");
        System.out.print("\nYour option : ");
        flipCard = sc.nextInt();
        if (flipCard == 2) {
            System.out.println("\nSave Game ?");
            System.out.println("\n1 - Yes");
            System.out.println("\n2 - No");
            System.out.print("\nYour option : ");
            flipCard = sc.nextInt();
            if (flipCard == 1) {
                System.out.println("\nSave File Name: ");
                name = sc.next();
                fm.saveGame(game, name);
                quit = true;
            } else {
                quit = true;
            }
        } else {
            System.out.println(game.getDungeonStats());
            if (column == 2) {
                card2 = game.getDungeon().currentCard(game.getArena(), game.getLevel(), 2);
                System.out.println();
                System.out.println("\n=== Card 1 === \n");
                System.out.println(card);
                System.out.println("\n============ \n");
                System.out.println("\n=== Card 2 === \n");
                System.out.println(card2);
                System.out.println("\n============ \n");
                System.out.println("\nChoose card");
                System.out.println("\n1 - " + card);
                System.out.println("\n2 - " + card2);
                System.out.print("\nYour option : ");
                cardChoosed = sc.nextInt();
                if (cardChoosed == 2) {
                    card = card2;
                }
            }
            if (column == 4) {
                card2 = game.getDungeon().currentCard(game.getArena(), game.getLevel(), 5);
                System.out.println();
                System.out.println("\n=== Card 1 === \n");
                System.out.println(card);
                System.out.println("\n============ \n");
                System.out.println("\n=== Card 2 === \n");
                System.out.println(card2);
                System.out.println("\n============ \n");

                System.out.println("\nChoose card");
                System.out.println("\n1 - " + card);
                System.out.println("\n2 - " + card2);
                System.out.print("\nYour option : ");
                cardChoosed = sc.nextInt();
                if (cardChoosed == 2) {
                    card = card2;
                }
            }
            System.out.println();
            System.out.println("\n=== Card === \n");
            System.out.println(card);
            System.out.println("\n============ \n");

            game.resolveCard(card);       
        }
    }

    public void uiAWaitRest() {
        int num;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Select Option: ");
            System.out.println("1 - Reinforce Your Weapon +1Xp ");
            System.out.println("2 - Search For Ration +1Food ");
            System.out.println("3 - Heal +2Hp ");
            System.out.print("\nYour option : ");
            num = sc.nextInt();
        } while (num < 1 || num > 3);
        game.setRestOption(num);
    }

    public void uiAWaitTrading() {
        int num;
        int option;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(game.getUiText());
            System.out.println(game.getPlayerStats());
            System.out.println("Select Option: ");
            System.out.println("1 - Buy ");
            System.out.println("2 - Sell ");
            System.out.println("3 - Skip ");
            System.out.print("\nYour option : ");
            num = sc.nextInt();

        } while (num < 1 || num > 3);

        switch (num) {
            case 1:
                System.out.println("|=========Buy Menu========|");
                System.out.println("1 - Ration: +1 Food / -1 Gold");
                System.out.println("2 - Health Potion: +1 Hp / -1 Gold");
                System.out.println("3 - Big Health Potion: +4 Hp / -3 Gold");
                System.out.println("4 - Armor Piece: +1 Armor / -6 Gold");
                System.out.println("5 - Fireball Spell / -8 Gold");
                System.out.println("6 - Ice Spell / -8 Gold");
                System.out.println("7 - Poison Spell / -8 Gold");
                System.out.println("8 - Healing Spell / -8 Gold");
                System.out.print("\nYour option : ");
                option = sc.nextInt();
                game.buyOption(option);
                break;
            case 2:
                System.out.println("|=========Sell Menu========|");
                System.out.println("1 - 1 Armor Piece: -1 Armor / +3 Gold");
                System.out.println("2 - Fireball Spell / +4 Gold");
                System.out.println("3 - Ice Spell / +4 Gold");
                System.out.println("4 - Poison Spell / +4 Gold");
                System.out.println("5 - Healing Spell / +4 Gold");
                System.out.print("\nYour option : ");
                option = sc.nextInt();
                game.sellOption(option);
                break;
            case 3:
                System.out.println("\n|=========Card Skipped========|\n");
                game.skip();
                break;
        }
    }

    public void uiAWaitDiceOption() {
        System.out.println("A Atacar ");
        System.out.println(game.getDicesString());
        game.checkAttack();
    }

    public void uiAWaitDiceRoll() {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println(game.getPlayerStats());
        System.out.println(game.cardToString());
        if (!game.checkCrits()) {
            do {
                System.out.println("1 - Atacar ");
                System.out.print("\nYour option : ");
                num = sc.nextInt();

            } while (num != 1);
            game.rollDice();
        } else {
            uiCriticalDice();
        }
    }

    public void uiCriticalDice() {
        Scanner sc = new Scanner(System.in);
        int num, option = 0;
        do {
            System.out.println(game.getDicesString());
            System.out.println("Reroll Critical Dice");
            System.out.println("1 - Yes");
            System.out.println("2 - No");
            System.out.print("\nYour option : ");
            num = sc.nextInt();
        } while (num < 1 || num > 2);
        if(num != 2){
        do {
            System.out.println(game.getDicesString());
            System.out.println("Select Crit Dice: ");
            System.out.println(game.getCritDicesString());
            System.out.print("\nYour option : ");
            option = sc.nextInt();
        } while (option < 1 || option > 4);
            game.critDices(num, option - 1);
        }else
            game.critDices(num, option - 1);
    }
    
    public void uiPerformFeat() {
        int num, option;
        Scanner sc = new Scanner(System.in);
        System.out.println(game.getUiText());
        do {
            System.out.println(game.getDicesString());
            System.out.println("Select Dice For Feat: ");
            System.out.println(game.getFeatDicesString()); //Dados com feats possiveis
            System.out.println("5 - Skip ");
            System.out.print("\nYour option : ");
            num = sc.nextInt();
        } while (num < 1 || num > 5);
        if (num != 5) {
        do {
            System.out.println("Select Pay Method: ");
            System.out.println("1 - Hp ");
            System.out.println("2 - Xp ");
            System.out.print("\nYour option : ");
            option = sc.nextInt();
        } while (option < 1 || option > 2);
            game.performFeat(num - 1, option);
        }else {
            uiAWaitDiceOption();
        }
    }

    public void run() {
        while (!quit) {
            IStates state = game.getState();

            if (state instanceof AwaitBeginning) {
                uiAwaitFirstBeginning();
            } else if (state instanceof AwaitCardSelection) {
                uiAWaitCardSelection();
            } else if (state instanceof AwaitRest) {
                uiAWaitRest();
            } else if (state instanceof AwaitTrading) {
                uiAWaitTrading();
            } else if (state instanceof AwaitDiceRoll) {
                uiAWaitDiceRoll();
            } else if (state instanceof AwaitDiceOption) {
                uiPerformFeat();
            } else if (state instanceof AwaitSpellOption) {
                uiAwaitSpellOption();
            }
        }
    }

}

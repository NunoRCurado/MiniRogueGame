/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic;

import java.io.*;

/**
 *
 * @author Marco
 */
public class FileManager {
    String localDirectory = "Saves\\";
    String extension = ".mse";
    
    public Boolean loadGame(MR_Game game, String name){

        try{
            System.out.println("\nLoad file name: " + name);
            File f = new File(fullPath(name));

            if(f.exists()){
                deserializeGameModel(new FileInputStream(f), game);
            } else{
                System.out.println("\nFile doesn't exist!\n");
                return false;
            }
        }catch(IOException e){
            System.out.println("\nCouldn't open file for reading!\n");
            return false;
        }
        
        return true;
    }
    
    public Boolean saveGame(MR_Game game, String name){

        File f = new File(localDirectory);
        
        if(!f.exists())
            f.mkdir();
        
        try{
            System.out.println("\nSave file name: ");
            f = new File(fullPath(name));
            f.createNewFile();
            
            if(f.exists()){
                serializeGameModel(new FileOutputStream(f), game);
            } else{
                System.out.println("\nFile doesn't exist!\n");
                return false;
            }
        }catch(IOException e){
            System.out.println("\nCouldn't open file for reading!\n");
            return false;
        }
        
        return true;
    }
    
    public String fullPath(String fileName){
        return localDirectory + fileName + extension;
    }
    
    public void serializeGameModel(FileOutputStream file, MR_Game game){
        ObjectOutputStream oos;
        
        try{
            oos = new ObjectOutputStream(file);
            oos.writeObject(game.getGameData());
            oos.close();
            
            System.out.println("\nSave successful!");
        } catch(IOException | IOError e){
            System.out.println("\nException -> Files.java serializeGameModel(): " + e.getMessage() + "\n");
        }
    }
    
    public void deserializeGameModel(FileInputStream file, MR_Game game){
        ObjectInputStream ois;
        
        try{
            ois = new ObjectInputStream(file);
            game.setGameData((GameData) ois.readObject());
            ois.close();
            
            System.out.println("\nLoad successful!");
        } catch(IOException | ClassNotFoundException e){
            System.out.println("\nException -> Files.java deserializeGameModel(): " + e.getMessage() + "\n");
        }
    }
}

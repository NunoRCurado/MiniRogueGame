/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic;

import java.util.ArrayList;
import java.util.List;
import MR_Game_Logic.*;
import java.io.Serializable;
/**
 *
 * @author Foca
 */
public class Spells implements Serializable{
    public String name;
    
    
    public Spells(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void effect(GameData gameData){
    }
    
}

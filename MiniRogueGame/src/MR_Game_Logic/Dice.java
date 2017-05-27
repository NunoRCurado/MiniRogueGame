/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic;

import java.io.Serializable;

/**
 *
 * @author pedri
 */
public class Dice implements Serializable{
    Integer roll;
    Boolean status;

    public Dice(){
        roll = 0;
        status = false;
    }
    
    public void roll(){
        roll = (int)(Math.random() * 6 + 1);
    }

    public Integer getRoll(){
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }
    
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    
}
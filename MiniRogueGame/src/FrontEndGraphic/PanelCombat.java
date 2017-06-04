/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEndGraphic;

import MR_Game_Logic.ObservableGame;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author Nuno
 */
public class PanelCombat extends JPanel implements Observer{

    private ObservableGame game;
    
    public PanelCombat(ObservableGame g){
        game = g;
        setup();
        game.addObserver(this);
    }
    @Override
    public void update(Observable o, Object o1) {
        
    }

    private void setup() {
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEndGraphic;

import MR_Game_Logic.ObservableGame;
import java.awt.Event;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Nuno
 */
public class PanelRollDice extends JPanel{
    
    private ObservableGame game;
    private JButton rollDice;
    
    public PanelRollDice(ObservableGame g){
        game=g;
        setup();
    }

    private void setup() {
        rollDice=new JButton("RollDice");
        
        setLayout(new GridBagLayout());
        GridBagConstraints gridBag=new GridBagConstraints();
        gridBag.fill=GridBagConstraints.BOTH;

        gridBag.gridx=0;
        gridBag.gridy=0;
        add(rollDice,gridBag);
        
        rollDice.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.rollDice();
            }
            
        });
    }

   
    
   
    
}

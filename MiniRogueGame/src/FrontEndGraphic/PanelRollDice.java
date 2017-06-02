/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEndGraphic;

import MR_Game_Logic.ObservableGame;
import java.awt.Color;
import java.awt.Event;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Nuno
 */
public class PanelRollDice extends JPanel{
    
    private ObservableGame game;
    private JButton rollDice;
    private JButton skip;
    private JButton sell;
    private JButton buy;
    
    public PanelRollDice(ObservableGame g){
        game=g;
        setup();
    }

    private void setup() {
        rollDice=new JButton("RollDice");
        skip = new JButton("Skip");
        buy = new JButton("Buy");
        sell = new JButton("Sell");
        
        setLayout(new GridBagLayout());
        GridBagConstraints gridBag=new GridBagConstraints();
        gridBag.fill=GridBagConstraints.BOTH;

      
        
        gridBag.gridx=0;
        gridBag.gridy=0;
        add(rollDice,gridBag);
        
        gridBag.gridx=1;
        gridBag.gridy=0;
        add(skip,gridBag);
        
        gridBag.gridx=2;
        gridBag.gridy=0;
        add(buy,gridBag);
        
        gridBag.gridx=3;
        gridBag.gridy=0;
        add(sell,gridBag);
        
        
        rollDice.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.rollDice();
            }
            
        });
        
         
        skip.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.Skip();
            }
            
        });
        
        buy.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
             
            }
            
        });
        
        sell.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
            
        });
    }

   
    
   
    
}

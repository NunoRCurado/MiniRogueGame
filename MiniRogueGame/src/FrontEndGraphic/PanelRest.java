/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEndGraphic;

import MR_Game_Logic.ObservableGame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Nuno
 */
public class PanelRest extends JPanel implements Observer {

    private ObservableGame game;
    private JButton button = new JButton ("Reinforce your Weapon | +1 xp");
    private JButton button1 = new JButton ("Search for ration | +1 food");
    private JButton button2 = new JButton ("Heal | +2 hp");
    
    @Override
    public void update(Observable o, Object o1) {
       
    }
    
    public PanelRest(ObservableGame g){
        game = g;
        setup();
        game.addObserver(this);
    }

    private void setup() {
        
        setLayout(new GridBagLayout());
        GridBagConstraints gridBag=new GridBagConstraints();
        gridBag.fill=GridBagConstraints.BOTH;
        
        gridBag.gridx=0;
        gridBag.gridy=0;
        add(button, gridBag);
        
        gridBag.gridx=0;
        gridBag.gridy=1;
        add(button1, gridBag);
        
        gridBag.gridx=0;
        gridBag.gridy=2;
        add(button2, gridBag);
        
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.setRestOption(1);
            }
            
        });
        
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.setRestOption(2);
            }
            
        });
        
        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.setRestOption(3);
                
            }
            
        });
}
    }
    
    

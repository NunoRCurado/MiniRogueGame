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
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Nuno
 */
public class PanelComprareVender extends JPanel implements Observer{

    private ObservableGame game;
    private JLabel sell = new JLabel("Sell");
    private JLabel buy = new JLabel("Buy");
    
    private JButton button = new JButton("Ration +1 food | - 1 Gold");
    private JButton button1 = new JButton("Health Potion  +1 Hp | -1 Gold");
    private JButton button2= new JButton("Big Health Potion +4 Hp | -3 Gold");
    private JButton button3= new JButton("Armor Piece: +1 Armor | -6 Gold");
    private JButton button4= new JButton("Fireball Spell | -8 Gold");
    private JButton button5= new JButton("Ice Spell | -8 Gold");
    private JButton button6= new JButton("Poison Spell | -8 Gold");
    private JButton button7= new JButton("Healing Spell | -8 Gold");
    
    private JButton button8= new JButton("1 Armor Piece: -1 Armor | +3 Gold");
    private JButton button9= new JButton("Fireball Spell | +4 Gold");
    private JButton button10= new JButton("Ice Spell | +4 Gold");
    private JButton button11= new JButton("Poison Spell | +4 Gold");
    private JButton button12= new JButton("Healing Spell | +4 Gold");
    
    private JButton button13= new JButton("Skip");
      
    
    
    
     
    @Override
    public void update(Observable o, Object o1) {
    }
    
    
    public PanelComprareVender(ObservableGame g){
        game = g;
        setup();
        game.addObserver(this);
    }

    private void setup() {
        
        
        setLayout(new GridBagLayout());
        GridBagConstraints gridBag=new GridBagConstraints();
        gridBag.fill=GridBagConstraints.BOTH;
        
        
        //buy
        gridBag.gridx=0;
        gridBag.gridy=0;
        gridBag.ipady= 20;
        add(buy, gridBag);
        
        gridBag.gridx=0;
        gridBag.gridy=1;
        gridBag.ipady= 20;
        add(button, gridBag);
        
        gridBag.gridx=1;
        gridBag.gridy=1;
        add(button1, gridBag);
        
        gridBag.gridx=0;
        gridBag.gridy=2;
        add(button2, gridBag);
        
        gridBag.gridx=1;
        gridBag.gridy=2;
        add(button3, gridBag);
        
        gridBag.gridx=0;
        gridBag.gridy=3;
        add(button4, gridBag);
        
        gridBag.gridx=1;
        gridBag.gridy=3;
        add(button5, gridBag);
        
        gridBag.gridx=0;
        gridBag.gridy=4;
        add(button6, gridBag);
        
        gridBag.gridx=1;
        gridBag.gridy=4;
        add(button7, gridBag);
        
        gridBag.gridx=0;
        gridBag.gridy=5;
        gridBag.ipady= 20;
        add(sell, gridBag);
       
        //sell
         gridBag.gridx=0;
        gridBag.gridy=6;
        add(button8, gridBag);
        
        gridBag.gridx=1;
        gridBag.gridy=6;
        add(button9, gridBag);
        
        gridBag.gridx=0;
        gridBag.gridy=7;
        add(button10, gridBag);
        
        gridBag.gridx=1;
        gridBag.gridy=7;
        add(button11, gridBag);
        
        gridBag.gridx=0;
        gridBag.gridy=8;
        add(button12, gridBag);
        
        gridBag.gridx=0;
        gridBag.gridy=9;
        add(button13, gridBag);
        
        
         
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.buyOption(1);
            }
            
        });
        
        
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.buyOption(2);
            }
            
        });
        
        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.buyOption(3);
            }
            
        });
        
        button3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.buyOption(4);
            }
            
        });
        
        button4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.buyOption(5);
            }
            
        });
        
        button5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.buyOption(6);
            }
            
        });
        
        button6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.buyOption(7);
            }
            
        });
        
        button7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.buyOption(8);
            }
            
        });
        
        //SElL
        
        button8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.sellOption(1);
            }
            
        });
        
        button9.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.sellOption(2);
            }
            
        });
        
        button10.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.sellOption(3);
            }
            
        });
        
        button11.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.sellOption(4);
            }
            
        });
        
        button12.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.sellOption(5);
            }
            
        });
        
         button13.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.Skip();
                
            }
            
        });
       
        
    }
}

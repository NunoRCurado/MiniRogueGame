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
public class PanelCombat extends JPanel implements Observer{

    
    private ObservableGame game;
    private JButton skip = new JButton("Skip");
    private JButton feats = new JButton("feats");
    private JButton noFeats = new JButton("no feats");
    private JButton critDicesSim = new JButton("Rodar Criticos");
    private JButton critDicesNao = new JButton("Nao Rodar Criticos");
    
    // caso tenha ou nao spells, se tiver e para nao usar
    private JButton attack = new JButton("Attack");
    
    private JButton noSpells = new JButton("Nao usar spells");
    
    
    
    private JButton fire = new JButton("fire");
    private JButton ice = new JButton("ice");
    private JButton poison = new JButton("poison");
    private JButton heal = new JButton("heal");
    
    public PanelCombat(ObservableGame g){
        game = g;
        setup();
        game.addObserver(this);
        
     
        
        feats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.performFeat(WIDTH, ERROR);
            }
        });
        
         noFeats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.checkAttack();
            }
        });
        
     
        
        critDicesSim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.critDices(1,0);
            }
        });
        
         critDicesNao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.critDices(2, 2);
            }
        });
         
         attack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.attack();
            }
        });
         
        
         fire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //1 = fire
                game.setSpellOption(1);
            }
        });
         
         ice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // 3 = ice
                game.setSpellOption(3);
            }
        });
         
         poison.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // 4 = poison
                game.setSpellOption(4);
            }
        });
         
         heal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // 2 heal
                game.setSpellOption(2);
            }
        });
        
        
    }
    @Override
    public void update(Observable o, Object o1) {
        
    }

    private void setup() {
        
        setLayout(new GridBagLayout());
        GridBagConstraints gridBag=new GridBagConstraints();
        gridBag.fill=GridBagConstraints.BOTH;

        gridBag.anchor = GridBagConstraints.CENTER;
        
        
        gridBag.gridx=0;
        gridBag.gridy=0;
        add(critDicesSim,gridBag);
        
          
        gridBag.gridx=1;
        gridBag.gridy=0;
        add(critDicesNao,gridBag);
        
        
        
        gridBag.gridx=0;
        gridBag.gridy=1;
        add(feats,gridBag);
        
        
        gridBag.gridx=1;
        gridBag.gridy=1;
        add(noFeats,gridBag);
        
 
        
        
        gridBag.gridx=0;
        gridBag.gridy=2;
        gridBag.gridwidth=2;
        add(attack,gridBag);
        gridBag.gridwidth=1;
     
        gridBag.gridx=0;
        gridBag.gridy=3;
        add(fire,gridBag);
        
        gridBag.gridx=1;
        gridBag.gridy=3;
        add(ice,gridBag);
        
        gridBag.gridx=0;
        gridBag.gridy=4;
        add(poison,gridBag);
        
        gridBag.gridx=1;
        gridBag.gridy=4;
        add(heal,gridBag);
    }
    
}

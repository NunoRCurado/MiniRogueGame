/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEndGraphic;

import MR_Game_Logic.ObservableGame;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Nuno
 */
public class PanelRollDice extends JPanel implements Observer{
    
    private ObservableGame game;
    private JLabel dado1 = new JLabel("0");
    private JLabel dado2= new JLabel("0");
    private JLabel dado3= new JLabel("0");
    private JLabel dado4= new JLabel("0");
    
    private JButton rodaDado1 = new JButton("Roda dado 1");
    private JButton rodaDado2  = new JButton("Roda dado 2");
    private JButton rodaDado3 = new JButton("Roda dado 3");
    private JButton rodaDado4 = new JButton("Roda dado 4");
    
    String valorDado1 = "0";
    String valorDado2= "0";
    String valorDado3= "0";
    String valorDado4= "0";
    
    public PanelRollDice(ObservableGame g){
        game= g;
        setup();
        game.addObserver(this); 
    }

    private void setup() {
       
        
        setLayout(new GridBagLayout());
        GridBagConstraints gridBag=new GridBagConstraints();
        gridBag.fill=GridBagConstraints.BOTH;

        gridBag.anchor = GridBagConstraints.CENTER;
        
        
        gridBag.gridx=0;
        gridBag.gridy=0;
        add(dado1,gridBag);
        
        gridBag.gridx=0;
        gridBag.gridy=1;
        add(rodaDado1,gridBag);
        
        gridBag.gridx=1;
        gridBag.gridy=0;
        add(dado2,gridBag);
        
        gridBag.gridx=1;
        gridBag.gridy=1;
        add(rodaDado2,gridBag);
        
//        if(game.getPlayer().getDices().get(1).getRoll()== 0){
//            dado2.setVisible(false);
//        }else
//            dado2.setVisible(true);
        
        gridBag.gridx=2;
        gridBag.gridy=0;
        add(dado3,gridBag);
        
        gridBag.gridx=2;
        gridBag.gridy=1;
        add(rodaDado3,gridBag);
        
//        if(game.getPlayer().getDices().get(2).getRoll()== 0){
//            dado3.setVisible(false);
//        }else
//            dado3.setVisible(true);
        
        gridBag.gridx=3;
        gridBag.gridy=0;
        add(dado4,gridBag);
        
        gridBag.gridx=3;
        gridBag.gridy=1;
        add(rodaDado4,gridBag);
        
//          if(game.getPlayer().getDices().get(3).getRoll()== 0){
//            dado4.setVisible(false);
//        }else
//            dado4.setVisible(true);
        
      
    }

   
     public void updateDices(){
            valorDado1 = Integer.toString(game.getPlayer().getDices().get(0).getRoll());
          
            
            dado1.setText(valorDado1);
        
            if(game.getPlayer().getDices().size()>1){
               valorDado2 = Integer.toString(game.getPlayer().getDices().get(1).getRoll());
               dado2.setText(valorDado2);
            }
               
            if(game.getPlayer().getDices().size()>2){
               valorDado3 = Integer.toString(game.getPlayer().getDices().get(2).getRoll());
               dado3.setText(valorDado3);
            }
               
            if(game.getPlayer().getDices().size()>3){
               valorDado4 = Integer.toString(game.getPlayer().getDices().get(3).getRoll());
               dado4.setText(valorDado4);
            }
            }
        

    @Override
    public void update(Observable o, Object o1) {
        updateDices();
        repaint();
    }
    
     @Override
     public void paintComponent(Graphics g){
         super.paintComponent(g);
          dado1.setText(valorDado1);
          dado2.setText(valorDado2);
          dado3.setText(valorDado3);
          dado4.setText(valorDado4);
           
    }
   
    
}
